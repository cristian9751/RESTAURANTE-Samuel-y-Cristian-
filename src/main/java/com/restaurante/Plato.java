package com.restaurante;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author cristian
 * @project RESTAURANTE-Samuel-y-Cristian- - com.restaurante
 * @created 25/3/23
 */
public class Plato {
    public static ArrayList<Plato> Platos = new ArrayList<Plato>();
    public enum TipoPlato{ENTRANTE, PLATO_PRINCIPAL, POSTRE}
    private String nombre;
    private TipoPlato tipo;

    private HashMap<Ingrediente, Integer> Ingredientes = new HashMap<Ingrediente, Integer>();

    public Plato() {
    }

    public Plato(String nombre, TipoPlato tipo, HashMap<Ingrediente, Integer> ingredientes) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.Ingredientes = ingredientes;
    }

    /***
     * Metodo getter
     * @return Devuelve el nombre del plato
     */
    public String getNombre() {
        return nombre;
    }

    /***
     * Metodo setter
     * @param nombre String que pasara a ser el nombre del ingrediente
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /***
     * Metodo getter
     * @return Devuelve el tipo de plato
     */
    public TipoPlato getTipo() {
        return tipo;
    }

    /***
     * Metodo  setter
     * @param tipo Tipo que pasara a ser el nuevo tipo del plato
     */
    public void setTipo(TipoPlato tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo que modifica la cantidad de un ingrediente en el plato
     * @param ingrediente INgrediente del cual se va a modificar la cantidad
     * @param cant Nueva cantidad del ingrediente en el plato
     */
    public void modificar_cantidad(Ingrediente ingrediente, int cant) {
        this.Ingredientes.replace(ingrediente, cant);
    }

    /***
     * Muestra la caantidad de un ingrediente en el plato
     * @param ingrediente Ingrediente del cual se quiere saber la cantidad
     * @return La cantidad del ingrediente especificado en el plato
     */
    public int get_cantidad(Ingrediente ingrediente) {
        int res = -1;
        if(this.exists(ingrediente)) {
            res = Ingredientes.get(ingrediente);
        }
        return res;
    }

    /***
     * Añadir un ingrediente a un plato
     * @param ingrediente Ingrediente que se va a añadir al plato
     * @param cant Cantidad del ingrdiente que habra en el plato
     */
    public void agregar(Ingrediente ingrediente , int cant) {
        this.Ingredientes.put(ingrediente, cant);
    }

    /**
     * Metodo que quita un ingredieente del plato
     * @param ingrediente Ingrediente que se va a eliminar del plato
     */
    public void quitar(Ingrediente ingrediente) {
        if(this.exists(ingrediente)) {
            Ingredientes.remove(ingrediente);
        }
    }


    /***
     * Metodo que comprueba si un ingrediente esta en un plato
     * @param ingrediente Ingrediente que se va a buscar en el plato
     * @return Devuelve true si se encuentra el ingrediente y false si no se ecuentra
     */
    public boolean exists(Ingrediente ingrediente) {
      if(Ingredientes.containsKey(ingrediente))  {
          return true;
      } else {
          System.err.println("El ingrediente "+  ingrediente.getNombre()
          + " no esta en este plato");
          return false;
      }
    }
}
