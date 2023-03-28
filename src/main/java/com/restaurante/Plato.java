package com.restaurante;

/**
 * @author cristian
 * @project RESTAURANTE-Samuel-y-Cristian- - com.restaurante
 * @created 25/3/23
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.restaurante.TipoPlato;
import com.restaurante.TipoPlato.EnumPlato;
import com.restaurante.utilidades.*;

public class Plato {
    private  HashMap<Ingrediente, Integer> Ingredientes_Plato; //Almacena ingredientes del plato y la cantidad
    private static List<Plato> Platos_Restaurante = new ArrayList<Plato>();
    private String nombre;//Nombre del plato

    private static int min_ingredientes = 3;

    private int Precio;//Precio del plato
    private EnumPlato tipo ;

    public Plato() {
    }

    public EnumPlato getTipo() {
        return tipo;
    }

    public void setTipo(EnumPlato tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre.length() >= 7) {
            this.nombre = nombre;
        } else {
            System.err.println("El nombre debe de ser mayor que 7");
        }
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

    public void Quitar_Ingrediente(Ingrediente ingrediente) {
        if(Ingredientes_Plato.containsKey(ingrediente)) {
            Ingredientes_Plato.remove(ingrediente);
        } else {
            System.out.println("El ingrediente " + ingrediente.getNombre()
            + " no esta en el plato " + this.getNombre());
        }
    }

    public  static boolean exists(Plato plato) {
        if(Platos_Restaurante.contains(plato)) {
            return true;
        } else {
            System.out.println("El plato especficado no existe");
            return false;
        }
    }

    public void mostrar_ingredientes() {
        for(Map.Entry ingrediente : Ingredientes_Plato.entrySet()) {
            System.out.println(ingrediente.getKey() + "\n" +
                    "Cantidad : " + ingrediente.getValue());
        }
    }


    public static Plato buscar(String nombre) {
        Plato res  = null;
        for(Plato plato : Platos_Restaurante) {
            if(plato.getNombre().equalsIgnoreCase(nombre)) {
                res = plato;
            }

        }
        return res;
    }

    public static boolean NameExists(String nombre) {
        if(Platos_Restaurante.isEmpty()) {
            return false;
        } else {
            if(buscar(nombre) == null ) {
                return false;
            } else {
                System.err.println("El nombre de plato " + nombre + " ya esta en uso, o es invalido");
                return true;
            }
        }
    }

    private static String PedirNombre() {
        String nombre;
        boolean invalid = true;
        do {
            nombre = utilidades.PedirString("Introduce el nombre del plato");
            invalid = NameExists(nombre);
        } while(invalid);
        return nombre;
    }

    public static boolean Crear() {
        Plato nuevo = new Plato();
        nuevo.setNombre(PedirNombre());
        nuevo.setPrecio(utilidades.PideEntero("Introduce el precio del plato"));
        for(int i = 0; i<= min_ingredientes; i++) {
            Ingrediente ingrediente = Ingrediente.buscar(utilidades.PedirString("Introduce el nombre del " +
                    "ingrdiente"));
            if(ingrediente == null) {
                System.out.println("El ingrediente indicado no existe");
                i--;
                continue;
            }
            int cantidad = utilidades.PideEntero("Introde la cantidad de "  + ingrediente.getNombre()
            + " que se va a utilizar en el plato " + nuevo.getNombre());

            if(!Ingrediente.comprobar_cantidad(cantidad, true)) {
                i--;
                continue;
            }

            nuevo.Agregar_Ingrediente(ingrediente, cantidad);
        }

        Platos_Restaurante.add(nuevo);
        return exists(nuevo);
    }



    @Override
    public String toString() {
        return "Nombre: " + this.nombre + "\n"
                + "Precio: " + this.Precio + "\n"
                + "Tipo: " + this.tipo;
    }
}
