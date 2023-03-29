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
    private  HashMap<Ingrediente, Integer> Ingredientes_Plato = new HashMap<>(); //Almacena ingredientes del plato y la cantidad
    private static List<Plato> Platos_Restaurante = new ArrayList<>();
    private String nombre;//Nombre del plato

    private static int min_ingredientes = 3;

    private int Precio;//Precio del plato
    private EnumPlato tipo ;

    public Plato() {
    }

    public static int getMin_ingredientes() {
        return min_ingredientes;
    }

    public static void setMin_ingredientes(int min_ingredientes) {
        Plato.min_ingredientes = min_ingredientes;
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

    public boolean Agregar_Ingrediente(Ingrediente ingrediente, int cant) {
        boolean done = false;
        if(Ingrediente.exists(ingrediente)) {
            if(!Ingredientes_Plato.containsKey(ingrediente)) {
                if(cant > 0) {
                    Ingredientes_Plato.put(ingrediente, cant);
                    done = true;
                } else {
                    System.out.println("La cantidad debe de ser mayor que 0");
                }
            } else {
                System.out.println("El plato " + this.nombre + " ya tiene el ingrediente" + ingrediente.getNombre());
            }
        }

        if(done) {
            System.out.println("Se ha añadido el ingrediente " + ingrediente.getNombre() +
                    " en el plato " + this.getNombre());
        }
        return done;
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
        System.out.println("LISTA DE INGREDIENTES DEL PLATO "  + this.getNombre() + ": ");
        System.out.println("NOMBRE\tCANTIDAD");
        for(Ingrediente ingrediente : Ingredientes_Plato.keySet()) {
            System.out.println(ingrediente.getNombre() + "\t"
            + Ingredientes_Plato.get(ingrediente));
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
            System.out.println("El ingrediente " + ingrediente.getNombre() + " no esta en el plato " +
                    this.getNombre());
        }
    }


    public static void Crear() {
        if(Ingrediente.Ingredientes_Restaurante.size() >= min_ingredientes) {
            Plato nuevo = new Plato();
            nuevo.setNombre(PedirNombre());
            boolean p_valido;
            do {
                p_valido = nuevo.setPrecio(utilidades.PideEntero("Introduce el precio del plato"));
            } while(!p_valido);

            for(int i = 1; i<= min_ingredientes; i++) {
                Ingrediente ingrediente = Ingrediente.buscar(utilidades.PedirString("Introduce el nombre del " +
                        "ingrdiente" + i));
                int cantidad = utilidades.PideEntero("Introde la cantidad de "  + ingrediente.getNombre()
                        + " que se va a utilizar en el plato " + nuevo.getNombre());

                nuevo.Agregar_Ingrediente(ingrediente, cantidad);
            }

            Platos_Restaurante.add(nuevo);
        } else {
            System.out.println("No hay ingredientes suficientes para crear un plato");
        }

        System.out.println("Se ha creado el plato correctamente");

    }

    public static boolean Eliminar(Plato plato) {
        if(Platos_Restaurante.contains(plato)) {
            Platos_Restaurante.remove(plato);
            return true;
        } else {
            return false;
        }
    }

    public static void manejar_opcion(int opcion) {
        boolean sw = false;
        Plato plato = null;
        if(opcion == 1 || opcion == 7) {
            sw = true;
        } else {
            plato = buscar(utilidades.PedirString("Introduce el nombre del plato."));
            if(exists(plato)) {
                sw = true;
            }
        }
        if(sw) {
            swtich_opcion(opcion, plato);
        }
    }

    private static void swtich_opcion(int opcion, Plato plato) {
        switch (opcion) {
            case 1:
                Crear();
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
                String nombre = utilidades.PedirString("Introduce el nombre del ingrediente que " +
                        "quieres añadir al plato " + plato.getNombre());
                int cant = utilidades.PideEntero("Introduce la cantidad de " + nombre + " que quieres" +
                        "agregar al plato " + plato.getNombre());
                plato.Agregar_Ingrediente(Ingrediente.buscar(nombre), cant);
                break;
            case 5, 6:
                plato.mostrar_ingredientes();
                nombre = utilidades.PedirString("Introduce el nombre de uno de los ingredientes" +
                        "del plato " + plato.getNombre());
                if(opcion == 5) {
                    plato.Quitar_Ingrediente(Ingrediente.buscar(nombre));
                } else {
                    cant = utilidades.PideEntero("Introduce la cantidad de " + nombre
                    + "que quieres que haya en el plato " + plato.getNombre());
                    plato.Quitar_Ingrediente(Ingrediente.buscar(nombre));
                }

            case 7:
                min_ingredientes = utilidades.PideEntero("Introduce el minmo de ingredientes " +
                        "que quieres que tengan los nuevos platos");
                break;
            case 8:
                mostrar();
            default:
                System.out.println("Debes seleccionar una opcion del 1 al 6");
                break;


        }
    }

    public static void mostrar() {
        for(Plato plato : Platos_Restaurante) {
            System.out.println(plato);
        }
    }
    @Override
    public String toString() {
        return "Nombre: " + this.nombre + "\n"
                + "Precio: " + this.Precio + "\n"
                + "Tipo: " + this.tipo;
    }
}
