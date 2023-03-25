package com.restaurante;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author cristian
 * @project RESTAURANTE-Samuel-y-Cristian- - com.restaurante
 * @created 25/3/23
 */
class ingredienteTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ingrediente prueba = new ingrediente();

    @BeforeEach
    void setUp() {
        prueba.setCantidad(10);
        prueba.setNombre("Patata");
        prueba.setTipo("Tuberculo");
        System.setErr(new PrintStream(outContent));
    }

    @Test
    void getNombre() {
        prueba.setNombre("Patata");
        assertEquals("Patata", prueba.getNombre());
    }

    @Test
    void getTipo() {
        prueba.setTipo("Tuberculo");
        assertEquals("Tuberculo", prueba.getTipo());
    }

    @Test
    void getCantidad() {
        prueba.setCantidad(10);
        assertEquals(10, prueba.getCantidad());
    }

    @Test
    void aumentarCantidad() {
        prueba.AumentarCantidad(1);
        assertEquals(11, prueba.getCantidad());
    }

    @Test
    void reducirCantidad() {
        prueba.ReducirCantidad(1);
        assertEquals(9, prueba.getCantidad());
    }

    @Test
    void testToString() {
        String resultado = "Ingrediente: Patata: \n"
                + "Nombre: Patata\n"
                + "Tipo: Tuberculo\n"
                + "Cantidad en stock: 10";
        assertEquals(resultado, prueba.toString());
    }

    /***
     * Metodo que testea si al modificarse la cantidad de un ingrediente
     * por un valor menor a 0 se muestre el mensaje de error correspondiente
     */
    @Test
    void TestErrCantidad() {
        prueba.setCantidad(-1);
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
        prueba.AumentarCantidad(-1);
        assertEquals("Debes indicar un valor mayor o igual a 0\n"
                , outContent.toString());
    }

    /***
     * Metodo que testea si al introducirse un valor menor a 0 copmo argumento para
     * reducir cantidad se el mensaje de error correspondiente del metodo
     * comprobar_cantidad
     */
    @Test
    void TestErrReducirCantidad() {
        prueba.ReducirCantidad(-1);
        assertEquals("Debes indicar un valor mayor o igual a 0\n"
        , outContent.toString());
    }
}