package com.restaurante;
/**
 * @author cristian
 * @project RESTAURANTE-Samuel-y-Cristian- - com.restaurante
 * @created 25/3/23
 */

import static com.restaurante.Menu_Opciones.*;

public class Restaurante {

    public static void main(String[] args) {
        config_inicial();
        int opcion_principal;
        do {
            opcion_principal = menu_principal();
            manejar(opcion_principal);
        } while (opcion_principal != 5);
    }


    public static void config_inicial() {
        System.out.println("CONFIGURACION INCIAL");
        int min_ingredientes = utilidades.PideEntero("Introduce el" +
                "numero minimo de ingredientes que tendra cada plato del" +
                "restaurante");
        Plato.setMin_ingredientes(min_ingredientes);
    }

    public static void manejar(int opcion) {
        switch (opcion) {
            case 1:
                manejar_ingrediente(menu_ingrediente());
                break;
            case 2:
                Manejar_plato(menu_plato());
                break;
            default:
                System.out.println("Debes de selccionar una de las opciones del menu");
                break;


        }
    }

    public static void manejar_ingrediente(int opcion) {
        do {
            switch (opcion) {
                case 1:
                    if (Ingrediente.Crear()) {
                        System.out.println("Se ha creado el ingrediente correctamente");
                    } else {
                        System.out.println("No se ha podido crear el ingrediente");
                    }
                    break;

                case 2:
                    Ingrediente ingrediente = Ingrediente.buscar(utilidades.PedirString("Introduce el nombre del ingrediente"));
                    if (ingrediente == null) {
                        System.out.println("El ingrediente no existe");
                    } else {
                        Ingrediente.Eliminar(ingrediente);
                        System.out.println("Se ha eliminado el ingrediente correctamente");
                    }
                    break;
                case 3:
                    System.out.println("Seleccionaste volver al menu" +
                            "princial");
                    break;
                default:
                    System.out.println("Debes escoger una de las dos opciones");
                    break;
            }
            if (opcion != 3) {
                opcion = Menu_Opciones.menu_ingrediente();
            }
        } while (opcion != 3);
    }

    public static void Manejar_plato(int opcion) {
        boolean sw = false;
        Plato plato = null;
        if(opcion == 1 || opcion == 7 || opcion == 8) {
            sw = true;
        } else {
            plato = Plato.buscar(utilidades.PedirString("Introduce el nombre del plato."));
            if(Plato.exists(plato)) {
                sw = true;
            } else {
                System.out.println("El plato especificado no existe");
            }
        }
        if(sw) {
            swtich_plato(opcion, plato);
        }
    }

    private static void swtich_plato(int opcion, Plato plato) {
        do {
            switch (opcion) {
                case 1:
                    plato = Plato.Crear();
                    if(plato != null) {
                        System.out.println("Se ha creado el plato " +
                                "correctamente");
                        System.out.println(plato);
                    } else {
                        System.out.println("Se ha producido un error al crear" +
                                "el plato");
                    }
                    break;
                case 2:
                    if(Plato.Eliminar(plato)) {
                        System.out.println("Se ha eliminado el plato " + plato.getNombre() + " correctamente");
                    } else {
                        System.out.println("El plato que quieres eliminar no existe");
                    }
                    break;
                case 3:
                    plato.setPrecio(utilidades.PideEntero("Introduce el nuevo precio del plato"));
                    break;

                case 4:
                {
                    String nombre = utilidades.PedirString("Introduce el nombre del ingrediente que " +
                            "quieres añadir al plato " + plato.getNombre());
                    int cant = utilidades.PideEntero("Introduce la cantidad de " + nombre + " que quieres" +
                            "agregar al plato " + plato.getNombre());
                    plato.Agregar_Ingrediente(Ingrediente.buscar(nombre), cant);
                }
                break;

                case 5:
                {
                    plato.mostrar_ingredientes();
                    String nombre = utilidades.PedirString("Introduce el nombre de uno de los ingredientes del plato" +
                            plato.getNombre() + "para quitarlo");
                    plato.Quitar_Ingrediente(Ingrediente.buscar(nombre));

                }
                break;
                case 6:
                {
                    plato.mostrar_ingredientes();
                    String nombre = utilidades.PedirString("Introduce el nombre de uno de los ingredientes del plato" +
                            "para modificar la cantidad que se usa del mismo");
                    int cantidad = utilidades.PideEntero("Introduce la cantidad de " + nombre + " que quieres que haya" +
                            "en el plato " + plato.getNombre());
                    plato.modificar_cantidad(Ingrediente.buscar(nombre), cantidad);
                }
                break;

                case 7:
                    int num = utilidades.PideEntero("Introduce el minmo de ingredientes " +
                            "que quieres que tengan los nuevos platos");
                    Plato.setMin_ingredientes(num);
                    break;
                case 8:
                    Plato.mostrar();
                    break;
                case 9:
                    System.out.println("Volviste al menu principal");
                    break;
                default:
                    System.out.println("Debes seleccionar una opcion del 1 al 6");
                    break;


            }
            if(opcion != 9) {
                opcion = menu_plato();
            }
        } while(opcion != 9);
    }
}