package com.restaurante;

/**
 * @author cristian
 * @project RESTAURANTE-Samuel-y-Cristian- - com.restaurante
 * @created 25/3/23
 */
public class ingrediente {
    private String nombre;
    private String tipo;
    private int cantidad;

    public ingrediente(String nombre, String tipo, int cantidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if(cantidad >= 0) {
            this.cantidad = cantidad;
        } else {
            System.out.println("Los ingredientes deben de tener una cantidad mayor a 0");
        }
    }

    public void AumentarCantidad(int cantidad) {
        this.setCantidad(this.cantidad + cantidad);
    }


    public void ReducirCantidad(int cantidad) {
        this.setCantidad(this.cantidad - cantidad);
    }

}
