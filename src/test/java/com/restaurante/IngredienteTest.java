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
    void testToString() {
        String resultado = "\n----------\nIngrediente: Patata: \n"
                + "Nombre: Patata\n"
                + "Tipo: Tuberculo\n"
                +   "\n----------\n" ;
        assertEquals(resultado, PRUEBA.toString());
    }


    @Test
    void TestBuscar() {
        assertEquals(PRUEBA.toString(), Ingrediente.buscar("Patata").toString());
    }

    @Test
    void TestNameExists() {
        assertEquals(true, Ingrediente.NameExists("Patata"));
        assertEquals("El nombre de ingrediente Patata ya esta en uso, o es invalido\n",
                outContent.toString());
    }
}