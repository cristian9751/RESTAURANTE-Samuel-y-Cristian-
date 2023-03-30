package com.restaurante;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static com.restaurante.TipoPlato.EnumPlato.*;

/**
 * @author cristian
 */
class PlatoTest {
    private final Plato PRUEBA = new Plato();
    Ingrediente ingrediente = new Ingrediente("Ingrediente1", "Tipo1");
    private final ByteArrayOutputStream outErrContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setErr(new PrintStream(outErrContent));
        Plato.setMin_ingredientes(1);
        PRUEBA.setTipo(ENTRANTE);
        PRUEBA.setNombre("Nombre del plato");
        PRUEBA.setPrecio(10);
        Ingrediente.Ingredientes_Restaurante.add(ingrediente);
        PRUEBA.Agregar_Ingrediente(ingrediente, 10);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void getNum_ingredientes() {
        assertEquals(1, Plato.getMin_ingredientes());
    }

    @Test
    void getTipo() {
        assertEquals(ENTRANTE, PRUEBA.getTipo());
    }

    @Test
    void getNombre() {
        assertEquals("Nombre del plato", PRUEBA.getNombre());
    }

    @Test
    void getPrecio() {
        assertEquals(10, PRUEBA.getPrecio());
        PRUEBA.setPrecio(-1);
        assertEquals("El precio debe de ser mayor que 0\n",
                outErrContent.toString());
    }

    @Test
    void agregar_Ingrediente() {
        assertTrue(PRUEBA.getIngredientes_Plato().containsKey(ingrediente));
        Ingrediente otro = new Ingrediente();
        PRUEBA.Agregar_Ingrediente(otro, 10);
        assertEquals("El ingrediente especificado no existe\n"
                , outErrContent.toString());
    }

    @Test
    void agregar_Ingrediente_Repetido() {
        PRUEBA.Agregar_Ingrediente(ingrediente, 10);
        assertEquals("El plato Nombre del plato ya tiene el ingrediente" +
                " Ingrediente1\n", outErrContent.toString());
    }

    @Test
    void quitar_Ingrediente() {
        assertTrue(PRUEBA.Quitar_Ingrediente(ingrediente));
        Ingrediente otro = new Ingrediente("Otro", "Otro");
        PRUEBA.Quitar_Ingrediente(otro);
        assertEquals("El ingrediente Otro no esta en el plato" +
                " Nombre del plato o no existe\n", outErrContent.toString());
    }

    @Test void exists() {
        Plato.Platos_Restaurante.add(PRUEBA);
        assertTrue(Plato.exists(PRUEBA));
        Plato.Platos_Restaurante.remove(PRUEBA);
        assertFalse(Plato.exists(PRUEBA));
    }

    @Test void mostrar_ingredientes() {
       PRUEBA.mostrar_ingredientes();
       String expected1 = "LISTA DE INGREDIENTES DEL PLATO Nombre del" +
               " plato: \n"+
               "NOMBRE\tCANTIDAD\n" +
               "Ingrediente1\t10\n";
       assertEquals(expected1, outContent.toString());
    }

    @Test
    void isEmptyFalse() {
        Plato.Platos_Restaurante.add(PRUEBA);
        assertFalse(Plato.isEmpty());
        Plato.Platos_Restaurante.remove(PRUEBA);
    }

    @Test
    void IsEmptyTrue() {
        Plato.Platos_Restaurante.clear();
        assertTrue(Plato.isEmpty());
    }

    @Test
    void buscar() {
        Plato.Platos_Restaurante.add(PRUEBA);
        assertNull(Plato.buscar("Pepe"));
        assertEquals(PRUEBA, Plato.buscar(PRUEBA.getNombre()));
        Plato.Platos_Restaurante.remove(PRUEBA);
    }

    @Test void nameExists() {
        Plato.Platos_Restaurante.add(PRUEBA);
        assertFalse(Plato.NameExists("Pepe"));
        assertTrue(Plato.NameExists(PRUEBA.getNombre()));
        Plato.Platos_Restaurante.remove(PRUEBA);
    }

    @Test void modificar_cantidad() {
        PRUEBA.modificar_cantidad(ingrediente, 3);
        assertEquals("Se ha modificado la cantidad de "
        + ingrediente.getNombre() + " en el plato " + PRUEBA.getNombre()
                + "\n", outContent.toString());
        Ingrediente otro = new Ingrediente("Otro", "Otro");
        PRUEBA.modificar_cantidad(otro, 7);
        assertEquals("El ingrediente especificado no existe\n",
                outErrContent.toString());

    }

    @Test
        void modificar_cantidad_Ingredientenoexiste() {
        Ingrediente otro = new Ingrediente("Otro", "Otro");
        Ingrediente.Ingredientes_Restaurante.add(otro);
        PRUEBA.modificar_cantidad(otro, 8);
        assertEquals("El ingrediente Otro no esta en el plato "
                + PRUEBA.getNombre() + "\n", outErrContent.toString());
    }
    @Test void eliminar() {
          //Si se intenta eliminar un plato que no esta en el arraylist
        assertFalse(Plato.Eliminar(PRUEBA));
          Plato.Platos_Restaurante.add(PRUEBA);
        assertTrue(Plato.Eliminar(PRUEBA));
          Plato.Platos_Restaurante.remove(PRUEBA);
    }

    @Test void mostrar() {
        Plato.mostrar();
        assertEquals("No hay platos que mostrar ahora mismo\n",
                outErrContent.toString());
        Plato.Platos_Restaurante.add(PRUEBA);
        assertEquals(PRUEBA.toString(), Plato.Platos_Restaurante.get(0).toString());
    }

}