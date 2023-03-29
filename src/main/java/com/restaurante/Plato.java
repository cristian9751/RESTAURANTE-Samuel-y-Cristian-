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
    private static List<Plato> Platos_Restaurante = new ArrayList<>();
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
        this.nombre = nombre;
    }

    public int getPrecio() {
        return Precio;
    }

    public boolean setPrecio(int precio) {
        if(precio > 0) {
            this.Precio = precio;
            return true;
        } else {
            System.out.println("El precio debe de ser mayor que 0");
            return false;
        }
    }

    public void Agregar_Ingrediente(Ingrediente ingrediente, int cant) {
        boolean done = false;
        if(Ingrediente.exists(ingrediente)) {
            if(!Ingredientes_Plato.containsKey(ingrediente)) {
                Ingredientes_Plato.put(ingrediente, cant);
                done = true;
            } else {
                System.out.println("El plato " + this.nombre + " ya tiene el ingrediente" + ingrediente.getNombre());
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


    public void modificar_cantidad(Ingrediente ingrediente , int cant) {
        if(this.Ingredientes_Plato.containsKey(ingrediente)) {
            Ingredientes_Plato.replace(ingrediente, cant);
        } else {
            System.out.println("El ingrediente " + ingrediente.getNombre() + " no esta en el plato");
        }
    }


    public static boolean Crear() {
        Plato nuevo = new Plato();
        nuevo.setNombre(PedirNombre());
        boolean p_valido;
        do {
            p_valido = nuevo.setPrecio(utilidades.PideEntero("Introduce el precio del plato"));
        } while(!p_valido);

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

            nuevo.Agregar_Ingrediente(ingrediente, cantidad);
        }

        Platos_Restaurante.add(nuevo);
        return exists(nuevo);
    }

    public static boolean Eliminar(Plato plato) {
        if(Platos_Restaurante.contains(plato)) {
            Platos_Restaurante.remove(plato);
            return true;
        } else {
            return false;
        }
    }


    private static int mostrar_menu() {
        System.out.println("MENU DE OPCIONES DE PLATOS");
        System.out.println("1. Crear plato");
        System.out.println("2. Eliminar plato");
        System.out.println("3. Cambiar precio");
        System.out.println("4. Añadir ingrediente");
        System.out.println("5. Quitar ingrediente");
        System.out.println("6. Modificar cantidades de los ingredientes");
        System.out.println("7. Salir");
        return utilidades.PideEntero("Selecciona una opcion del menu");
    }



    private static void manejar_opcion(int opcion) {
        Plato plato = null;
        if(opcion != 1) {
            plato = buscar(utilidades.PedirString("Introduce el nombre del plato."));
            if(plato == null) {
                System.out.println("El plato que buscas no existe");
            } else {
                swtich_opcion(opcion, plato);
            }
        } else {
            swtich_opcion(opcion, plato);
        }
    }

    private static void swtich_opcion(int opcion, Plato plato) {
        switch (opcion) {
            case 1:
                if(Crear()) {
                    System.out.println("Se ha creado el plato correctamente");
                } else {
                    System.out.println("Se ha producido un error al crear el plato");
                }
                break;
            case 2:
                if(Eliminar(plato)) {
                    System.out.println("Se ha eliminado el plato " + plato.getNombre() + " correctamente");
                }
                break;
            case 3:
                plato.setPrecio(utilidades.PideEntero("Introduce el nuevo precio del plato"));
                break;
            case 4:
                Ingrediente ingrediente = Ingrediente.buscar(utilidades.PedirString("Introduce el nombre del " +
                        "ingrediente que quieres añadir al plato"));
                plato.Agregar_Ingrediente(ingrediente, utilidades.PideEntero("Introduce la cantidad de " +
                        ingrediente.getNombre() + " en el plato"));
                break;
            case 5:
                ingrediente = Ingrediente.buscar(utilidades.PedirString("Introduce el nombre " +
                        "del ingrediente que quieres quitar del plato"));
                plato.Quitar_Ingrediente(ingrediente);
                break;
            case 6:
                ingrediente = Ingrediente.buscar(utilidades.PedirString("Introduce el nombre del ingrediente" +
                        "del cual quiers modificar la cantidad"));
                plato.modificar_cantidad(ingrediente , utilidades.PideEntero("Introduce la cantidad"));
                break;
            case 7:
                System.out.println("Seleccionaste salir del menu");
                break;

            default:
                System.out.println("Debes seleccionar una opcion del 1 al 7");
                break;


        }
    }



    @Override
    public String toString() {
        return "Nombre: " + this.nombre + "\n"
                + "Precio: " + this.Precio + "\n"
                + "Tipo: " + this.tipo;
    }
}
