package com.restaurante;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.restaurante.Plato.TipoPlato;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;


class PlatoTest {

    private final Plato PRUEBA_PLATO = new Plato();
    final Ingrediente INGREDIENTE1 = new Ingrediente("Ingrediente1", "Tipo1", 10);
    final Ingrediente INGREDIENTE2 = new Ingrediente("Ingrediente2", "Tipo2", 20);

    @BeforeEach
    void setUp() {
        final HashMap<Ingrediente, Integer> INGREDIENTES_PLATO = new HashMap<Ingrediente, Integer>();
        PRUEBA_PLATO.agregar(INGREDIENTE1, 10);
        PRUEBA_PLATO.setNombre("Plato1");
        PRUEBA_PLATO.setTipo(TipoPlato.PLATO_PRINCIPAL);
    }

    @Test
    void testgetNombre() {
        assertEquals("Plato1", PRUEBA_PLATO.getNombre());
    }

    @Test
    void tesgetTipo() {
        assertEquals(TipoPlato.PLATO_PRINCIPAL, PRUEBA_PLATO.getTipo());
    }

    @Test
    void testmodificar_cantidad() {
        PRUEBA_PLATO.modificar_cantidad(INGREDIENTE1, 1 );
        assertEquals(1, PRUEBA_PLATO.get_cantidad(INGREDIENTE1));
    }

    @Test
    void testagregar() {
        PRUEBA_PLATO.agregar(INGREDIENTE2, 20);
        assertEquals(true, PRUEBA_PLATO.exists(INGREDIENTE2));
    }

    @Test
    void testquitar() {
        PRUEBA_PLATO.quitar(INGREDIENTE1);
        assertEquals(false, PRUEBA_PLATO.exists(INGREDIENTE1));
    }

    @Test
    void testexists() {
        assertEquals(true, PRUEBA_PLATO.exists(INGREDIENTE1));
    }

    @Test
    void testgetcantidad() {
        assertEquals(10,  PRUEBA_PLATO.get_cantidad(INGREDIENTE1));
    }
}