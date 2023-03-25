package com.restaurante;

/**
 * @author cristian
 * @project RESTAURANTE-Samuel-y-Cristian- - com.restaurante
 * @created 25/3/23
 */
public class ingrediente {
    private String nombre;//Nombre del ingrediente
    private String tipo;//Tipo de ingrediente
    private int cantidad;//Cantidad del ingrediente que tiene el restaurante en stock

    /***
     * Constructor con tres parametros
     * @param nombre Nombre que va a tener el ingrediente
     * @param tipo String tipo que va  a tenr el ingrediente
     * @param cantidad Entero que va a indicar la cantidad del ingrediente
     */
    public ingrediente(String nombre, String tipo, int cantidad) {
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
            System.out.println("La canttidad del ingrediente " + this.nombre
            + " no puede ser " + cantidad);
        }
    }

    /***
     * Metodo que aumenta la cantidad de un ingrediente
     * @param cantidad Entero que indica el numero en el que queremos aumentar la cantidad
     */
    public void AumentarCantidad(int cantidad) {
        if(comprobar_cantidad(cantidad, true)) {
            this.setCantidad(this.cantidad + cantidad);
        }
    }


    /***
     * Metodo que reduce la cantidad de un ingrediente
     * @param cantidad Entero que indica el numero en el que queremos reducir la cantidad
     */
    public void ReducirCantidad(int cantidad) {
        if(comprobar_cantidad(cantidad, true)) {
            this.setCantidad(this.cantidad - cantidad);
        }
    }

    /***
     * Metodo que comprueba si la cantidad es mayor que 0
     * @param cant Entero que indica cual es el numero en el que queremos aumentar la cantidad
     * @param txt Valor booleano que  indica si debe mostrarse un texto al devolver false
     * @return Devuelve true o false en funcion de si la cantidad es mayor que 0 o no
     */
    private boolean comprobar_cantidad(int cant, boolean txt) {
        if(cant > 0) {
            return true;
        } else {
            if(txt) {
                System.out.println("Debes indicar un valor mayor o igual a 0");
            }
            return false;
        }
    }
}
