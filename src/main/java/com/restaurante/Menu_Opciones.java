package com.restaurante;

/**
 * @author cristian
 */
public class Menu_Opciones {
    public static int menu_principal() {
        System.out.println("MENU PRINCIPAL");
        System.out.println("1. Gestionar ingredientes");
        System.out.println("2. Gestionar platos");
        System.out.println("3. Gestionar menus");
        System.out.println("4. Gestionar empleados");
        System.out.println("5. Salir de la aplicacion");
        return escoger_opcion("Selecciona una de las cinco opciones");
    }

    public static int menu_ingrediente() {
        System.out.println("MENU DE OPCIONES DE LOS INGREDIENTES");
        System.out.println("1. Crear nuevo ingrediente");
        System.out.println("2. Eliminar un ingrediente");
        System.out.println("3. Ver todos los ingredientes del restaurante");
        System.out.println("4. Volver al menu principal");
        return escoger_opcion("Escoge una de las tres opciones");
    }

    public static int menu_plato() {
        System.out.println("MENU DE OPCIONES DE PLATOS");
        System.out.println("1. Crear plato");
        System.out.println("2. Eliminar plato");
        System.out.println("3. Cambiar precio");
        System.out.println("4. Añadir ingrediente");
        System.out.println("5. Quitar ingrediente");
        System.out.println("6. Modificar cantidades de los ingredientes");
        System.out.println("7. Cambiar el minimo de ingredientes que deben tener los platos");
        System.out.println("8. Mostrar platos");
        System.out.println("9. Volver al menu principal");
        return escoger_opcion("Escoge una de las nueve opciones");
    }

    public static int menu_tipo_plato() {
        System.out.println("MENU TIPOS DE PLATO");
        for(TipoPlato.EnumPlato tipo : TipoPlato.EnumPlato.values()) {
            System.out.println(tipo.getNum() + " "  +tipo.getNombre());
        }

        return escoger_opcion("Escoge el tipo de plato");
    }

    private static int escoger_opcion(String txt) {
        return utilidades.PideEntero(txt);
    }

    private static String escoger_texto(String txt) {
        return utilidades.PedirString(txt);
    }
}
