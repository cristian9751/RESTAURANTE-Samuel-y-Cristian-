package com.restaurante;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author cristian
 */
class IngredienteTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final Ingrediente PRUEBA = new Ingrediente();



    @BeforeEach
    void setUp() {
        Ingrediente.Ingredientes_Restaurante.add(PRUEBA);
        PRUEBA.setCantidad(10);
        PRUEBA.setNombre("Patata");
        PRUEBA.setTipo("Tuberculo");
        System.setErr(new PrintStream(outContent));
    }

    @Test
    void getNombre() {
        PRUEBA.setNombre("Patata");
        assertEquals("Patata", PRUEBA.getNombre());
    }

    @Test
    void getTipo() {
        PRUEBA.setTipo("Tuberculo");
        assertEquals("Tuberculo", PRUEBA.getTipo());
    }

    @Test
    void getCantidad() {
        PRUEBA.setCantidad(10);
        assertEquals(10, PRUEBA.getCantidad());
    }

    @Test
    void aumentarCantidad() {
        PRUEBA.AumentarCantidad(1);
        assertEquals(11, PRUEBA.getCantidad());
    }

    @Test
    void reducirCantidad() {
        PRUEBA.ReducirCantidad(1);
        assertEquals(9, PRUEBA.getCantidad());
    }

    @Test
    void testToString() {
        String resultado = "\n----------\nIngrediente: Patata: \n"
                + "Nombre: Patata\n"
                + "Tipo: Tuberculo\n"
                + "Cantidad en stock: 10\n----------\n";
        assertEquals(resultado, PRUEBA.toString());
    }

    /***
     * Metodo que testea si al modificarse la cantidad de un ingrediente
     * por un valor menor a 0 se muestre el mensaje de error correspondiente
     */
    @Test
    void TestErrCantidad() {
        PRUEBA.setCantidad(-1);
        assertEquals("La cantidad del ingrediente Patata no puede" +
                " ser -1\n", outContent.toString());
    }

    /***
     * Metodo que testea si al introducirse un valor menor a 0 como argumento para
     * aumentar cantidad se muestra el mensaje de error correspondiente del metodo
     * comprobar_cantidad
     */
    @Test
    void TestErrAumentarCantidad() {
        PRUEBA.AumentarCantidad(-1);
        assertEquals("Debes indicar una cantidad mayor o igual a 0\n"
                , outContent.toString());
    }

    /***
     * Metodo que testea si al introducirse un valor menor a 0 copmo argumento para
     * reducir cantidad se el mensaje de error correspondiente del metodo
     * comprobar_cantidad
     */
    @Test
    void TestErrReducirCantidad() {
        PRUEBA.ReducirCantidad(-1);
        assertEquals("Debes indicar una cantidad mayor o igual a 0\n"
        , outContent.toString());
    }

    @Test
    void TestBuscar() {
        assertEquals(Ingrediente.Ingredientes_Restaurante.get(0), Ingrediente.buscar("Patata"));
    }

    @Test
    void TestNameExists() {
        assertEquals(true, Ingrediente.NameExists("Patata"));
        assertEquals("El nombre de ingrediente Patata ya esta en uso, o es invalido\n",
                outContent.toString());
    }

    @Test
    void TestExists() {
        assertEquals(true, Ingrediente.exists(PRUEBA));
    }
}