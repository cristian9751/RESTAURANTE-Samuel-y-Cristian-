package com.restaurante;

import java.util.ArrayList;

/**
 * @author cristian
 */
public class Ingrediente {
    public static  ArrayList<Ingrediente> Ingredientes_Restaurante = new ArrayList<Ingrediente>();
    private String nombre;//Nombre del ingrediente
    private String tipo;//Tipo de ingrediente
    private int cantidad;//Cantidad del ingrediente que tiene el restaurante en stock

    /***
     * Constructor vacio
     */
    public Ingrediente() {
    }

    /***
     * Constructor con tres parametros
     * @param nombre Nombre que va a tener el ingrediente
     * @param tipo String tipo que va  a tenr el ingrediente
     * @param cantidad Entero que va a indicar la cantidad del ingrediente
     */
    private Ingrediente(String nombre, String tipo, int cantidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
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

    /**
     * Metodo get
     * @return Obtiene la cantidad del ingrediente
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Metodo set que actualiza la cantidad del ingrediente.
     * @param cantidad Entero que pasara a ser el parametro cantidad del ingrediente
     */
    public void setCantidad(int cantidad) {
        if(comprobar_cantidad(cantidad, false)) {
            this.cantidad = cantidad;
        } else {
            System.err.println("La cantidad del ingrediente " + this.nombre
                    + " no puede ser " + cantidad);
        }
    }

    /***
     * Metodo que aumenta la cantidad de un ingrediente
     * @param Cantidad Entero que indica el numero en el que queremos aumentar la cantidad
     */
    public void AumentarCantidad(int Cantidad) {
        if(comprobar_cantidad(Cantidad, true)) {
            this.setCantidad(this.cantidad + Cantidad);
        }
    }


    /***
     * Metodo que reduce la cantidad de un ingrediente
     * @param Cantidad Entero que indica el numero en el que queremos reducir la cantidad
     */
    public void ReducirCantidad(int Cantidad) {
        if(comprobar_cantidad(Cantidad, true)) {
            this.setCantidad(this.cantidad - Cantidad);
        }
    }

    /***
     * Metodo que comprueba si la cantidad es mayor que 0
     * @param cant Entero que indica cual es el numero en el que queremos aumentar la cantidad
     * @param txt Valor booleano que  indica si debe mostrarse un texto al devolver false
     * @return Devuelve true o false en funcion de si la cantidad es mayor que 0 o no
     */
    private static boolean comprobar_cantidad(int cant, boolean txt) {
        if(cant >= 0) {
            return true;
        } else {
            if(txt) {
                System.err.println("Debes indicar una cantidad mayor o igual a 0");
            }
            return false;
        }
    }

    /***
     * Metodo que busca un ingrediente segun el nombre
     * @param nombre String  con el nombre que se va a buscar
     * @return Objeto de clase ingrediente que se encuentra. Si no se encuentra es nulo
     */
    public static Ingrediente buscar(String nombre) {
        Ingrediente res = null;
        for(Ingrediente ingrediente : Ingredientes_Restaurante) {
            if(ingrediente.getNombre().equalsIgnoreCase(nombre)) {
                res = ingrediente;
            }
        }
        if(res == null) {
            System.out.println("No hay ningun ingrediente" +
                    "con el nombre " + nombre);
        }
        return res;
    }

    /***
     * Metodo que comprueba si ya existe un ingrediente con ese nombre a la hora de crearlo
     * @param nombre Nombre que se esta buscando
     * @return Devuelve true si el nombre ya existe y false si el nombre todavia no existe
     */
    private static boolean NameExists(String nombre) {
        if(Ingredientes_Restaurante.isEmpty()) {
            return false;
        } else {
            if(buscar(nombre) == null ) {
                return false;
            } else {
                System.out.println(nombre + " ya esta en uso, o es invalido");
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
        } while(invalid_name);

        return nombre;
    }

    /**
     * Metodo que pide los datos de nuevo ingrediente al usuario y
     * llama al constructor para almacenar el nuevo ingrediente
     * en el arrayList
     * @return Devuelve un booleano true si se ha podido crear, false si no
     */
    public static boolean Crear() {
        String Nombre_Ingrediente = Pedir_Nombre();
        String Tipo_Ingrediente = utilidades.PedirString("Introduce el tipo de producto");
        int Cant_Ingrediente = utilidades.PideEntero("Introduce la cantidad de " +
                Nombre_Ingrediente + " que hay");
        if(comprobar_cantidad(Cant_Ingrediente, true)) {
            Ingredientes_Restaurante.add(new Ingrediente(Nombre_Ingrediente, Tipo_Ingrediente, Cant_Ingrediente));
            return true;
        } else {
            return false;
        }
    }

    /***
     * Metodo tostring que controla como se muestra la informacion de un objeto de tipo ingrediente
     * @return Devuelve la informacion de un ingrediente
     */

    @Override
    public String toString() {
        return "Ingrediente: " + this.nombre + ": \n"
                + "Nombre: " + this.nombre + "\n"
                + "Tipo: " + this.tipo + "\n"
                + "Cantidad en stock: " + this.cantidad;
    }


}