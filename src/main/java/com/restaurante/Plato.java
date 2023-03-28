package com.restaurante;

/**
 * @author cristian
 * @project RESTAURANTE-Samuel-y-Cristian- - com.restaurante
 * @created 25/3/23
 */
import java.util.HashMap;
public class Plato {
    private  HashMap<Ingrediente, Integer> Ingredientes_Plato; //Almacena ingredientes del plato y la cantidad
    private String nombre;//Nombre del plato

    private int Precio;//Precio del plato

    private Plato(HashMap<Ingrediente, Integer> ingredientes_Plato, String nombre, int precio) {
        Ingredientes_Plato = ingredientes_Plato;
        this.nombre = nombre;
        Precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int precio) {
        Precio = precio;
    }

    public void Agregar_Ingrediente(Ingrediente ingrediente, int cant) {
        boolean done = false;
        if(Ingrediente.exists(ingrediente)) {
            if(!Ingredientes_Plato.containsKey(ingrediente)) {
                if(Ingrediente.comprobar_cantidad(cant, true)) {
                    Ingredientes_Plato.put(ingrediente, cant);
                    done = true;
                }
            }
        }

        if(done) {
            System.out.println("Se ha añadido el ingrediente " + ingrediente.getNombre() +
                    " en el plato " + this.getNombre());
        }
    }

}
