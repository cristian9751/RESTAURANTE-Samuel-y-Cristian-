package com.restaurante;

import java.util.ArrayList;

/**
 * @author cristian
 */
public class Ingrediente {
    public static ArrayList<Ingrediente> Ingredientes_Restaurante = new ArrayList<Ingrediente>();
    private String nombre;//Nombre del ingrediente
    private String tipo;//Tipo de ingrediente

    /***
     * Constructor vacio
     */
    public Ingrediente() {
    }

    /***
     * Constructor con tres parametros
     * @param nombre Nombre que va a tener el ingrediente
     * @param tipo String tipo que va  a tenr el ingrediente
     */
    private Ingrediente(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    /***
     * Metodo get
     * @return Devuelve el nombre del ingrediente
     */
    public String getNombre() {
        return nombre;
    }

    /***
     * Metodo set que actualiza el nombre del ingrdiente
     * @param nombre  String que pasara a ser el nuevo nombre del ingrediente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /***
     * Metodo get
     * @return Devuelve el parametro tipo del ingrediente
     */
    public String getTipo() {
        return tipo;
    }

    /***
     * Metodo set que actualiza el string tipo del ingrediente
     * @param tipo String que pasara a ser el paramtro tipo del ingrediente
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /***
     * Metodo que busca un ingrediente segun el nombre
     * @param nombre String  con el nombre que se va a buscar
     * @return Objeto de clase ingrediente que se encuentra. Si no se encuentra es nulo
     */
    public static Ingrediente buscar(String nombre) {
        Ingrediente res = null;
        if (!IngredientesEmpty()) {
            for (Ingrediente ingrediente : Ingredientes_Restaurante) {
                if (ingrediente.getNombre().equalsIgnoreCase(nombre)) {
                    res = ingrediente;
                    break;
                }
            }
        }
        return res;
    }

    /***
     * Metodo que comprueba si un ingrdiente existe en el arraylist
     * @param ingrediente Ingrediente que se busca
     * @return Valor true si  existo o false si no existe
     */
    public static boolean exists(Ingrediente ingrediente) {
        boolean res = false;
        if (Ingredientes_Restaurante.contains(ingrediente)) {
            res = true;
        }
        if (!res) {
            System.out.println(" El ingrediente " + ingrediente.getNombre() + " no existe");
        }
        return res;
    }

    /***
     * Metodo que comprueba si ya existe un ingrediente con ese nombre a la hora de crearlo
     * @param nombre Nombre que se esta buscando
     * @return Devuelve true si el nombre ya existe y false si el nombre todavia no existe
     */
    public static boolean NameExists(String nombre) {
        if (Ingredientes_Restaurante.isEmpty()) {
            return false;
        } else {
            if (buscar(nombre) == null) {
                return false;
            } else {
                System.err.println("El nombre de ingrediente " + nombre + " ya esta en uso, o es invalido");
                return true;
            }
        }
    }

    /***
     * Metodo que solicita el nuevo nombre de ingrediente
     * al usuario hasta que introduceuno correcto
     * @return Nombre que ha introducido el usuario
     */
    private static String Pedir_Nombre() {
        boolean invalid_name;
        String nombre;
        do {
            nombre = utilidades.PedirString("Introduce el nombre del ingrediente");
            invalid_name = NameExists(nombre);
        } while (invalid_name);

        return nombre;
    }

    /**
     * Metodo que pide los datos de nuevo ingrediente al usuario y
     * llama al constructor para almacenar el nuevo ingrediente
     * en el arrayList
     *
     * @return Devuelve un booleano true si se ha podido crear, false si no
     */
    public static boolean Crear() {
        Ingrediente nuevo = new Ingrediente();
        String Nombre_Ingrediente = Pedir_Nombre();
        String Tipo_Ingrediente = utilidades.PedirString("Introduce el tipo de producto");
        nuevo.setNombre(Nombre_Ingrediente);
        nuevo.setTipo(Tipo_Ingrediente);
        Ingredientes_Restaurante.add(nuevo);

        return exists(nuevo);
    }

    public static boolean Eliminar(Ingrediente ingrediente) {
        if (exists(ingrediente)) {
            Ingredientes_Restaurante.remove(ingrediente);
            return true;
        } else {
            return false;
        }
    }

    private static boolean IngredientesEmpty() {
        if (Ingredientes_Restaurante.isEmpty()) {
            System.out.println("No hay ingredientes en stock actualmente");
            return true;
        } else {
            return false;
        }
    }

    public static void manejar_opcion(int opcion) {
        switch (opcion) {
            case 1:
                if (Crear()) {
                    System.out.println("Se ha creado el ingrediente correctamente");
                } else {
                    System.out.println("No se ha podido crear el ingrediente");
                }
                break;

            case 2:
                Ingrediente ingrediente = buscar(utilidades.PedirString("Introduce el nombre del ingrediente"));
                if (ingrediente == null) {
                    System.out.println("El ingrediente no existe");
                } else {
                    Eliminar(ingrediente);
                    System.out.println("Se ha eliminado el ingrediente correctamente");
                }
                break;
            case 3:
                System.out.println("Volver al menu principal");
                break;
            default:
                System.out.println("Debes escoger una opcion del 1 al 3");
                break;
        }
    }

    /***
     * Metodo tostring que controla como se muestra la informacion de un objeto de tipo ingrediente
     * @return Devuelve la informacion de un ingrediente
     */

    @Override
    public String toString() {
        String lineas = "\n----------\n";
        return lineas + "Ingrediente: " + this.nombre + ": \n"
                + "Nombre: " + this.nombre + "\n"
                + "Tipo: " + this.tipo + "\n"
                + lineas;
    }
}

