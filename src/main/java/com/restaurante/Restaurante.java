package com.restaurante;
import com.restaurante.Menu_Opciones;
/**
 * @author cristian
 * @project RESTAURANTE-Samuel-y-Cristian- - com.restaurante
 * @created 25/3/23
 */
import com.restaurante.Ingrediente;

import java.awt.*;

public class Restaurante {

    public static void main(String[] args) {
        int opcion_principal;
        do {
            opcion_principal = Menu_Opciones.menu_principal();
            manejar(opcion_principal);
        } while(opcion_principal != 5);
    }

    public static void manejar(int opcion) {
        switch (opcion) {
            case 1:
                Ingrediente.manejar_opcion(Menu_Opciones.menu_ingrediente());
                break;
            case 2:
                Plato.manejar_opcion(Menu_Opciones.menu_plato());
                break;


        }
    }
}