package com.restaurante;

/**
 * @author cristian
 * @project RESTAURANTE-Samuel-y-Cristian- - com.restaurante
 * @created 25/3/23
 */
public class Menu_Opciones {
    public static int menu_principal() {
        System.out.println("1. Gestionar ingredientes");
        System.out.println("2. Gestionar platos");
        System.out.println("3. Gestionar menus");
        System.out.println("4. Gestionar empleados");
        System.out.println("5. Salir de la aplicacion");
        return escoger_opcion("Selecciona una de las cinco opciones");
    }

    public static int menu_ingrediente() {
        System.out.println("1. Crear nuevo ingrediente");
        System.out.println("2. Eliminar un ingrediente");
        System.out.println("3. Volver al menu principal");
        return escoger_opcion("Escoge una de las tres opciones");
    }

    private static int escoger_opcion(String txt) {
        return utilidades.PideEntero(txt);
    }

    private static String escoger_texto(String txt) {
        return utilidades.PedirString(txt);
    }
}
