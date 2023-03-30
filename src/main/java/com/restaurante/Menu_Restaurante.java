package com.restaurante;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cristian
 * @project RESTAURANTE-Samuel-y-Cristian- - com.restaurante
 * @created 25/3/23
 */
public class Menu_Restaurante {

    // Declaración de un ArrayList
    public static List<Menu_Restaurante> Menus = new ArrayList<>();
    // PARAMETROS
    private int precio;
    private int modificacion;
    private int max_platos;
    private String nombre_menu;
    private String nombre_plato ;
    

    /*
     * Contstructor vacio
     */
    public Menu_Restaurante() {

    }

    /*
     * Constructor con 3 parametros
     * 
     * @param precio que elamacena el coste del menu
     * 
     * @param max_platos que almacena el maximo de platos de un menu
     * 
     * @param nombre que almacena el nombre de un menu
     * 
     * @param nombre_plato que almacena el nombre de los platos
     */
    public Menu_Restaurante(int precio, int max_platos, String nombre_menu, String nombre_plato) {

    }

    /*
     * Metodo get
     * 
     * @return Devuelve el precio de un menu
     */
    public int getPrecio() {
        return precio;
    }

    /*
     * Metodo set que actualiza el precio de un plato
     * 
     * @param int que pasa a ser el nuevo precio del menu
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /*
     * Metodo get
     * 
     * @return Devuelve el valor que va a modificar el precio  del menu
     */
    public int getModificacion() {
        return modificacion;
    }

    /*
     * Metodo set que actualixa el valor del valor que va a modificar el precio del menu
     * 
     * @param int que pasa a ser el nuevo valor que va a modificar el precio del menu
     */
    public void setModificacion(int modificacion) {
        this.modificacion = modificacion;
    }

    /*
     * Metodo get
     * 
     * @return Devuelve max_platos
     */
    public int getMax_platos() {
        return max_platos;
    }

    /*
     * Metodo set que almacena el maximo de platos de un menu
     * 
     * @param int que pasa a ser el nuevo maximo de platos de un menu
     */
    public void setMax_platos(int max_platos) {
        this.max_platos = max_platos;
    }

    /*
     * Metodo get
     * 
     * @return Devuelve el nombre
     */
    public String getNombre() {
        return nombre_menu;
    }

    /*
     * Metodo set que actualiza el nombre de un menu
     * 
     * @param String que pasa a ser el nuevo nombre de un menu
     */
    public void setNombre(String nombre) {
        this.nombre_menu = nombre;
    }
    
    /*
     * 
     */
    public String getNombre_plato() {
        return nombre_plato;
    }
    /*
     * 
     */
    public void setNombre_plato(String nombre_plato) {
        this.nombre_plato = nombre_plato;
    }

    /*
     * Metodo que muestr la opcion escogida del Menu_menus
     */
    public void Menu_escogido(int opcion) {
        
        do {
            opcion = Menu_Opciones.Menu_menus();
            switch (opcion) {
                case 1:
                    Crear_menu(nombre_menu, max_platos, precio);
                    break;
                case 2:
                    Modificar_precio();
                    break;
                case 3:
                    Modificar_cantidad_platos();
                    break;
          
                default:
                    break;
            }
            
        } while (opcion != 6);
    }

    @Override
    public String toString(){
        return "Nombre del menu: " + this.nombre_menu + "\n" +
                "Numero máximo de platos: " + this.max_platos + "\n" +
                "Precio del menu: " + this.precio;
    }

    /*
     * Metodo que te permite crear un Menu de platos
     */
    public void Crear_menu(String nombre_menu, int max_platos, int precio) {
        
        nombre_menu = utilidades.PedirString("Nombre del menu: ");
        max_platos = utilidades.PideEntero("Numero máximo de platos: ");
        precio = utilidades.PideEntero("Precio del menu: ");
        for (int i = 0; i < max_platos; i++) {
            Plato.buscar(nombre_plato);
            //nombre_plato = utilidades.PedirString("Introduzca el nombre del plato que desea ingresar:");
            //Plato.buscar(nombre_plato);
        }
        Menus.add(new Menu_Restaurante(precio, max_platos, nombre_menu, nombre_plato));
    }

    /*
     * Metodo qaue modifica el precio del menu
     */
    public void Modificar_precio() {

        int opcion;
        int modificacion;
        String nombre;

        System.out.println("1.Amunetar precio del menu" + "\n" +
                            "2.Disminuir precio del menu" + "\n" + 
                            "----------------------------");
        opcion = utilidades.PideEntero("Introduzca una de las opciones");
        if (opcion == 1) {
            nombre = utilidades.PedirString("Introduzca el nombre del menu que esta buscando:");
        for (Menu_Restaurante menu_Restaurante : Menus) {
            if (menu_Restaurante.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(menu_Restaurante);
                modificacion = utilidades.PideEntero("Introduzca la cantidad que quiere sumarle al precio:");
                int precio = this.precio += modificacion;
                menu_Restaurante.setPrecio(precio);
            }
        }
        } else {
            nombre = utilidades.PedirString("Introduzca el nombre del menu que esta buscando:");
        for (Menu_Restaurante menu_Restaurante : Menus) {
            if (menu_Restaurante.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(menu_Restaurante);
                modificacion = utilidades.PideEntero("Introduzca la cantidad que quiere resatarle al precio");
                int precio = this.precio -= modificacion;
                menu_Restaurante.setPrecio(precio);
            }
        }       
        }
        
    }
    /*
     * Metodo que momdifica la cantidad de platos de un menu
     */
    public void Modificar_cantidad_platos() {
        int opcion;
        int modificacion;
        String nombre;

        System.out.println("1.Aumentar la cantidad de platos" + "\n" +
                            "2.Disminuir la cantidad de platos" + "\n" +
                            "----------------------------------");
        opcion = utilidades.PideEntero("Introduzca una de las opciones: ");
        if (opcion == 1) {
            nombre = utilidades.PedirString("Introduzca el nombre del menu que busca");
            for (Menu_Restaurante menu_Restaurante : Menus) {
                if (menu_Restaurante.getNombre().equalsIgnoreCase(nombre)) {
                    System.out.println(menu_Restaurante);
                    modificacion = utilidades.PideEntero("Introduzca la cantidad que quiere sumarle a la cantidad de platos: ");
                    int max =this.max_platos += modificacion;
                    menu_Restaurante.setMax_platos(max);
                }
                
                
            }
        } else {
            nombre = utilidades.PedirString("Introduzca el nombre del menu que esta buscando");
            for (Menu_Restaurante menu_Restaurante : Menus) {
                if (menu_Restaurante.getNombre().equalsIgnoreCase(nombre)) {
                    System.out.println(menu_Restaurante);
                    modificacion = utilidades.PideEntero("Introduzca la cantidad que quiere restarle a la cantidad de platos:");
                    int max = this.max_platos -= modificacion;
                    menu_Restaurante.setMax_platos(max);
                }
                
                
            }
        }
    }
}