package com.restaurante;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.restaurante.TipoPlato.EnumPlato;

/**
 * @author  Cristian Popica
 */
public class Plato {
    private final HashMap<Ingrediente, Integer> Ingredientes_Plato = new HashMap<>(); //Almacena ingredientes del plato y la cantidad
    public  static List<Plato> Platos_Restaurante = new ArrayList<>();
    private String nombre;//Nombre del plato

    private static int min_ingredientes = 3;

    private int Precio;//Precio del plato
    private EnumPlato tipo ;

    public Plato() {
    }


    /**
     * Metodo getter
     * @return Devuelve el minimo de ingredienes que pueden tener los
     * platos del restaurante
     */
    public static int getMin_ingredientes() {
        return min_ingredientes;
    }

    /**
     * Metodo setter que comprueba si el  parametro min_ingredientes
     * es mayor que 0 y lo guarda como valor estatico de Plato
     * @param min_ingredientes Entero que pasara a ser el minimo de
     *                         ingredientes que deberan tener todos
     *                         los platos del restaurante
     */
    public static void setMin_ingredientes(int min_ingredientes) {
        if(min_ingredientes > 0) {
            Plato.min_ingredientes = min_ingredientes;
        } else {
            System.out.println("El numero de ingredientes que deben" +
                    "tener los platos tiene que ser superior a 0");
        }
    }

    /**
     *  Metodo getter
     * @return Devuelve el hasmap con los ingredientes que tiene el
     * plato y su cantidad
     */
    public HashMap<Ingrediente, Integer> getIngredientes_Plato() {
        return Ingredientes_Plato;
    }


    /**
     * Metodo getter
     * @return Develve el tipo de plato de la instancia
     */
    public EnumPlato getTipo() {
        return tipo;
    }

    /**
     * Metodo setter que indica el tipo de plato
     * @param tipo Enumerado tipo que pasara a ser el tipo de la instancia
     */
    public void setTipo(EnumPlato tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo getter
     * @return Devuelve el nombre de la instancia de plato
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo setter
     * @param nombre Indica el nuevo nombre de la instancia de Plato
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo getter
     * @return Devuelve el precio de la instancia de plato
     */
    public int getPrecio() {
        return Precio;
    }

    /**
     * Metodo setter que acutaliza el precio de la instancia de plato
     * @param precio Entero que pasara a ser el precio de la instancia
     * @return Devuelve verdadero si ha seteado o falso si no
     */
    public boolean setPrecio(int precio) {
        if(precio > 0) {
            this.Precio = precio;
            return true;
        } else {
            System.err.println("El precio debe de ser mayor que 0");
            return false;
        }
    }

    /**
     * Metodo que agrega un nuevo ingrediente al plato haciendo
     * los checks necesarios
     * @param ingrediente Ingrediente que se quiere añadir al plato
     * @param cant Cantidad del ingrediente que se quiere añadir al plato
     * @return Devuelve verdadero si se ha Agregado el ingrediente o
     * falso si no lo ha hecho
     */
    public boolean Agregar_Ingrediente(Ingrediente ingrediente, int cant) {
        boolean done = false;
        //Si el ingrediente existe en el arrayList de ingredientes
        if(Ingrediente.exists(ingrediente)) {
            //Si el ingrediente no esta en el plato
            if(!this.Ingredientes_Plato.containsKey(ingrediente)) {
                if(cant > 0) {
                    Ingredientes_Plato.put(ingrediente, cant);
                    done = true;
                } else {
                    System.out.println("La cantidad debe de ser mayor que 0");
                }
            } else {
                //Si el ingrediente ya esta en el plato
                System.err.println("El plato " + this.nombre + " ya tiene el ingrediente " + ingrediente.getNombre());
            }
            //Si el ingrediente no existe en el arrraylist de ingredientes
        } else {
            System.err.println("El ingrediente especificado no existe");
        }

        //Si se ha agregado el ingrediente al plato mostrara el siguiente
        //texto
        if(done) {
            System.out.println("Se ha añadido el ingrediente " + ingrediente.getNombre() +
                    " en el plato " + this.getNombre());
        }
        return done;
    }

    /**
     * Metodo que elimina un ingrediente de una instancia de plato
     * @param ingrediente Ingrediente que se quiere eliminar de
     *                    la instancia plato
     * @return Deveulve verdaero si se ha podido eliminar o falso si no
     */
    public boolean Quitar_Ingrediente(Ingrediente ingrediente) {
        //Si el ingrediente esta en el plato
        if(Ingredientes_Plato.containsKey(ingrediente)) {
            Ingredientes_Plato.remove(ingrediente);
            return true;
            //Si el ingrediente no esta en el plato
        } else {
            System.err.println("El ingrediente " + ingrediente.getNombre()
                    + " no esta en el plato " + this.getNombre() + " o no existe");
            return false;
        }
    }

    /**
     * Metodo que comprueba si un plato existe en el array de Platos
     * @param plato El plato que se quiere comprobar si existe
     * @return Valor true si existe o false si no existe el plato
     */
    public  static boolean exists(Plato plato) {
        return Platos_Restaurante.contains(plato);
    }

    /***
     * Metodo que muestra los ingredientes de una instancia de plato
     * nunca podra estar vacio porque para  crear el plato se requiere
     * un minimo de ingredientes y ese minimo de ingredientes
     * siempre debe de ser mayor a 0 tal y como se especifica en el
     * setter
     */
    public void mostrar_ingredientes() {
        System.out.println("LISTA DE INGREDIENTES DEL PLATO "  + this.getNombre() + ": ");
        System.out.println("NOMBRE\tCANTIDAD");
        for(Ingrediente ingrediente : Ingredientes_Plato.keySet()) {
            System.out.println(ingrediente.getNombre() + "\t"
                    + Ingredientes_Plato.get(ingrediente));
        }
    }

    /**
     * Metodo que comprueba si el array de Platos esta o no vacio
     * @return  Devuelve un valor booleano verdadero si esta vacio
     * junto con un texto, si no esta vacio devuelve un booleano falso
     */
    public static boolean isEmpty() {
        if(Platos_Restaurante.isEmpty()) {
            System.err.println("No hay platos que mostrar ahora mismo");
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo que busca un plato por su nombre
     * @param nombre Nombre del plato que queremos buscar
     * @return Devuelve la instancia de tipo plato que estamos buscando
     * de no encontrarla devuelve una objeto nulo
     */
    public static Plato buscar(String nombre) {
        Plato res  = null;
        for(Plato plato : Platos_Restaurante) {
            if(plato.getNombre().equalsIgnoreCase(nombre)) {
                res = plato;
            }

        }
        return res;
    }

    /**
     * Metodo que comprueba si el nombre de un plato ya esta en uso
     * @param nombre Nombre que se quiere comprobar
     * @return Valor booleano verdadero si el nombre ya esta en uso
     * o falso si el nomrbre no esta en uso
     */
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

    /**
     * Metodo que pide el nombre del plato a la hora de crear uno nuevo
     * haciendo una serie de checkeos
     * @return Devuelve el nombre que cumple con todos los requisitos
     */
    private static String PedirNombre() {
        String nombre;
        boolean invalid;
        do {
            nombre = utilidades.PedirString("Introduce el nombre del plato");
            invalid = NameExists(nombre); //Devuelve verdadero si el nombre esta en uso
        } while(invalid); // Hasta que se introduzca un nombre que no esta en uso
        return nombre;
    }


    /**
     * Metodo que modifica la cantidad que se usa  de un ingrediente
     * en una instancia de plato
     * @param ingrediente Ingrediente del cual se quiere modificar la
     *                    cantidad
     * @param cant Nueva cantidad del ingrediente que se quiere asignar
     */
    public void modificar_cantidad(Ingrediente ingrediente , int cant) {
        //Si el ingrediente esta en el array de Ingredientes
        if(Ingrediente.exists(ingrediente)) {
            //Si el plato contiene el ingrediente
            if(this.Ingredientes_Plato.containsKey(ingrediente)) {
                Ingredientes_Plato.replace(ingrediente, cant);
                System.out.println("Se ha modificado la cantidad de " +
                        ingrediente.getNombre() + " en el plato " + this.getNombre());
                //Si el plato no contiene el ingrediente
            } else {
                System.err.println("El ingrediente " + ingrediente.getNombre()
                        + " no esta en el plato " +
                        this.getNombre());
            }
            //Si el ingrediente no esta en el array de Ingredientes
        } else {
            System.err.println("El ingrediente especificado no existe");
        }
    }


    /**
     * Metodo que comprueba si el numero de ingredientes supera
     * el minimo de ingredientes por cada plato del restaurante
     * @param num Cantidad de ingredientes que se quiere
     *            asignar a un nuevo plato
     * @return Devuelve el numero de ingredientes valido
     */
    private static int check_numingredientes(int num) {
        while(num < min_ingredientes ) {
            num = utilidades.PideEntero("Debes introducir un minimo" +
                    "de " + min_ingredientes + " ingredientes");
        }
        return num;
    }

    /**
     * Metodo que crea una nueva instancia de Plato y añade la misma
     * al arrayList de Platos
     * @return Devuelve la nueva instancia de Plato
     */
    public static Plato Crear() {
        Plato nuevo = null;
        // Si el numero de ingredientes que hay en el ArrayList de ingredientes
        //supera la cantidad minima de ingredientes por plato
        if(Ingrediente.Ingredientes_Restaurante.size() >= min_ingredientes) {
            nuevo = new Plato();
            nuevo.setNombre(PedirNombre());
            boolean p_valido;
            //Pedira el precio hasta que se introduzca un precio valido
            do {
                p_valido = nuevo.setPrecio(utilidades.PideEntero("Introduce el precio del plato"));
            } while(!p_valido);

            //Pide el numero de ingredientes que tendra el plato
            int num_ingredientes = utilidades.PideEntero("Introduce" +
                    "el numero de ingredientes que va a tener el plato");
            //Debera superar el minimo de ingredientes
            num_ingredientes = check_numingredientes(num_ingredientes);

            //Bucle for que añade el ingrediente a un plato tantas veces
            // como ingredientes vaya a tener el plato
            for(int i = 1; i<= num_ingredientes; i++) {
                String nombre = utilidades.PedirString("Introduce el nombre del ingrediente "
                        + i);
                int cantidad = utilidades.PideEntero("Introde la cantidad de "  + nombre
                        + " que se va a utilizar en el plato " + nuevo.getNombre());

                Ingrediente ingrediente = Ingrediente.buscar(nombre);

                //Si no se ha podido agregar el ingrediente
                if(!nuevo.Agregar_Ingrediente(ingrediente, cantidad)) {
                    i--;
                }

            }
            System.out.println("Selecciona el tipo de plato");
            EnumPlato tipo = TipoPlato.elegir();
            nuevo.setTipo(tipo);

            Platos_Restaurante.add(nuevo);
            //Si el numero de ingredientes del ArrayList de ingredients
            //no suepra el minimo de ingredientes por plato
        } else {
            System.out.println("No hay ingredientes suficientes para crear un plato" +
                    ". Deben haber " + min_ingredientes + "\n"
                    + "Pudes cambiar este ajuste desde el menu de gestion" +
                    "de platos");
        }

        return nuevo;
    }

    /**
     * Metodo que elimina un Plato del ArrayList de Platos
     * @param plato Plato que se desea eliminar
     * @return Devuevle verdadero si en efecot se ha eliminado o falo
     * si no se ha eliminado
     */
    public static boolean Eliminar(Plato plato) {
        if(exists(plato)) {
            Platos_Restaurante.remove(plato);
            return true;
        } else {
            return false;
        }
    }


    /**
     * Metodo que muestra todos los platos del ArrayList de Platos
     */
    public static void mostrar() {
        if(!isEmpty()) {
            for(Plato plato : Platos_Restaurante) {
                System.out.println(plato);
            }
        }
    }

    /**
     * Metodo toString que modifica como se muestra la informacion
     * de una instancia de Plato
     * @return Devuelve la informacion de una instancia de Plato
     */
    @Override
    public String toString() {
        String lineas = "\n----------\n";
        return lineas + "Nombre: " + this.nombre + "\n"
                + "Precio: " + this.Precio + "\n"
                + "Tipo: " + this.tipo + lineas;
    }
}
