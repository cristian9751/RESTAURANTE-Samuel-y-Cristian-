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
        if(comprobar_cantidad(cantidad, false)) {
            this.cantidad = cantidad;
        } else {
            System.out.println("La canttidad del ingrediente " + this.nombre
            + " no puede ser " + cantidad);
        }
    }

    public void AumentarCantidad(int cantidad) {
        if(comprobar_cantidad(cantidad, true)) {
            this.setCantidad(this.cantidad + cantidad);
        }
    }


    public void ReducirCantidad(int cantidad) {
        if(comprobar_cantidad(cantidad, true)) {
            this.setCantidad(this.cantidad - cantidad);
        }
    }

    private boolean comprobar_cantidad(int cant, boolean txt) {
        if(cant > 0) {
            return true
        } else {
            if(txt) {
                System.out.println("Debes indicar un valor mayor o igual a 0");
            }
            return false;
        }
    }
}
