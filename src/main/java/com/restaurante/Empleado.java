package com.restaurante;

import java.util.ArrayList;
import java.util.List;

/**
 * @TitoSam007
 * @project RESTAURANTE-Samuel-y-Cristian- - com.restaurante
 * @created 25/3/23
 */
public class Empleado {
    

    // PARAMETROS

    public static List<Empleado> Empleados = new ArrayList<>();
    private int edad;
    private String Nombre;
    private String Apellidos;
    private int saldo;
    private int modificacion;
    private tipo_puesto puesto;

    /*
     * Un enum tipo_puesto que almacena los diferentes tipos de puestos
     */
    public enum tipo_puesto {

        Cocinero(1, "Cocinero"),
        Ayudante(2,"Ayudadante"),
        Office(3, "Office"),
        Cheff(4, "Cheff"),
        Camarero(5, "Camarero");

        private String nombretipo;
        private int n;

    tipo_puesto(int num, String nombre){
        this.nombretipo = nombre;
        this.n = num;
    }

    public String getNombretipo() {
        return nombretipo;
    }
    public void setNombretipo(String nombretipo) {
        this.nombretipo = nombretipo;
    }
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }
    }

    /*
     * Consturctor Vacio
     */
    public Empleado() {
    }

    /*
     * Constructor con 4 parametros
     *
     * @param Edad int que almacena la edad del empleado
     *
     * @param Nombre String que almacena el nombre del empleado
     *
     * @param Apellidos String que almacena el apellido del empleado
     *
     * @param saldo int que almacena el salario del emopleado
     *
     * @param modificacion int que modifica el saldo de un empleado
     * 
     * @param opcion int que almacena la opcion del menu de empleado
     */
    public Empleado(int Edad, String Nombre, String Apellidos, tipo_puesto puesto, int saldo, int modificacion) {
    }

    /*
     * Metodo get
     *
     * @return Devuelve la edad
     */
    public int getEdad() {
        return edad;
    }

    /*
     * Metodo set que atcualiza la edad del emppleado
     *
     * @param int que pasar a ser la nueva edad del empleado
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /*
     * Metodo get
     *
     * @return Devuelve el nombre del empleado
     */
    public String getNombre() {
        return Nombre;
    }

    /*
     * Metodo set Actualiza el nombre del empledo
     *
     * @param String que pasa a ser el nuevo nombre del empleado
     */
    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    /*
     * Metodo get
     *
     * @return Devuelve el apellido del empleado
     */
    public String getApellidos() {
        return Apellidos;
    }

    /*
     * Metodo set
     *
     * @param String que pasa a ser el nuevo apellido del empleado
     */
    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    /*
     * Metodo get
     *
     * @retun Devuelve el saldo del empleado
     */
    public int getSaldo() {
        return saldo;
    }

    /*
     * Metodo set que actualiza el saldo del empleado
     *
     * @param int que pasa a ser el nuevo saldo del empleado
     */
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    /*
     * Meotodo get
     *
     * @return Devuelve la modificacion del saldo del empleado
     */
    public int getModificacion() {
        return modificacion;
    }

    /*
     * Metodo set que actualiza la modificacion del empleado
     *
     * @param int que pasa a ser la nueva modificacion del empleado
     */
    /*
     * Metodo get
     *
     * @return Devuelve el puesto del empleado
     */
    public tipo_puesto getPuesto() {
        return puesto;
    }

    /*
     * Metodo set que actualiza el puesto del empleado
     *
     * @aram tipo_puesto que pasa a ser el nuevo puesto del empleado
     */

    public void setPuesto(tipo_puesto puesto) {
        this.puesto = puesto;
    }

    /*
     * Metodo que muestra la opcion escogida del menu
     */
    public void Opcion_escogida(int opcion) {


        do {
            switch (opcion) {
                case 1:
                    Puesto_empleado_actualizado();
                    break;
                case 2:
                    Aumento_del_sueldo(Nombre, Apellidos, puesto, saldo, modificacion);
                    break;
                case 3:
                    Disminucion_del_sueldo(Nombre, Apellidos, puesto, saldo, modificacion);
                    break;
                case 4:
                    Nuevos_Datos_Empleado(Nombre, Apellidos, edad, saldo, puesto);
                    break;
                case 5:
                    Despedir_empleado();
                default:
                    break;
            }
        } while (opcion != 6);
    }

    @Override 
    public String toString(){
        return "Nombre: " + this.Nombre +  "\n" + 
                "Apellidos: " + this.Apellidos + "\n" + 
                "Edad: " + this.edad + "\n" +
                "Salario: " + this.saldo + "\n" +
                "Puesto: " + this.puesto;
    }

    /*
     * Metodo Nuevos_Datos_Empleado con 5 atributos
     * Ingresa los datos de un nuevo tranajador
     */
    public void Nuevos_Datos_Empleado(String nombre, String apellidos, int edad, int saldo, tipo_puesto puesto) {

        System.out.println("Datos de nuevo empleado: " + "\n" +
                "---------------------------");

        nombre = utilidades.PedirString("Nombre: ");
        apellidos = utilidades.PedirString("Apellidos: ");
        edad = utilidades.PideEntero("Edad: ");
        saldo = utilidades.PideEntero("Salario: ");
        Puesto_empleado_actualizado();

        Empleados.add(new Empleado(saldo, nombre, apellidos, puesto, edad, saldo));
    }

    /*
     * Metodo Puesto_empleado con 4 atributos
     * Verifica cual es el puesto actual del empleado
     */
    public static int Puesto_empleado_actualizado() {

        System.out.println("Puestos de trabajadores: ");
        for (tipo_puesto tipo: Empleado.tipo_puesto.values()) {
            System.out.println(tipo.getN() + " " + tipo.getNombretipo());
        }

        return utilidades.PideEntero("Escoge un tipo de empleado: ");

    }

    public static tipo_puesto Buscar_Puesto() {
        int opcion;
        String txt = new String();
        tipo_puesto elegido = null;
        do {
            System.out.println(txt);
            opcion = Puesto_empleado_actualizado();
            for (tipo_puesto tipo : Empleado.tipo_puesto.values()) {
                if(tipo.getN() == opcion){
                    elegido = tipo;
                }
            }
            txt = "Has elegido un puesto de empleado incorrecto. Intentalo de nuevo";
        } while (elegido == null);
        return elegido;
    }

    /*
     * Metos Aumento_del_sueldo con 4 atributos
     * Verifica cual es el sueldo actual del trabajador
     */
    public void Aumento_del_sueldo(String nombre, String apellidos, tipo_puesto puesto, int saldo, int aumento) {

        this.modificacion = aumento;

        do {
            aumento = utilidades.PideEntero("Introduzca el valor del aumento:");
            if (Modificacion_sueldo(aumento) == false) {
                System.out.println("Vaya, algo ha ido mal, intentalo de nuevo");
            }
        } while (Modificacion_sueldo(aumento) != true);

        saldo += aumento;

        System.out.print("Datos actualizados: " + "\n" +
                "Nombre del trabajador: " + nombre + "\n" +
                "Apellidos del trabajador: " + apellidos + "\n" +
                "Edad del empleado: " + edad + "\n" +
                "Puesto del trabajador: " + puesto + "\n" +
                "Sueldo del trabajador: " + saldo);

    }

    /*
     * Metodo Disminucion_del_sueldo cont 4 atributos
     * Verifica cual es el sueldo actual del trabajador
     */
    public void Disminucion_del_sueldo(String nombre, String apellidos, tipo_puesto puesto, int saldo, int disminucion) {

        this.modificacion = disminucion;

        do {
            disminucion = utilidades.PideEntero("Introduzca que valor quiere descontarle al empleado:");
            if (Modificacion_sueldo(disminucion) == false) {
                System.out.println("Vaya, algo ha ido mal, intentalo de nuevo");
            }
        } while (Modificacion_sueldo(disminucion) != true);
        
        saldo -= disminucion;

        System.out.print("Datos actualizados: " + "\t" +
                "Nombre del trabajador: " + nombre + "\t" +
                "Apellidos del trabajador: " + apellidos + "\t" +
                "Edad del empleado: " + edad + "\t" +
                "Puesto del trabajador: " + puesto + "\t" +
                "Sueldo del trabajador: " + saldo);
    }

    /*
     * Metodo Buscar_Empleado que busca un empleado
     */
    public static Empleado Buscar_Empleado() {

        int opcion;
        String nombres;
        Empleado empleado = null;

        System.out.println("1.Ver el empleado: ");
        System.out.println("2.Eliminar datos del empleado: ");
        opcion = utilidades.PideEntero("Introduzca una de las opciones");

        if (opcion == 1) {
            nombres = utilidades.PedirString("Introduzca el nombre del empleado que esta buscando: ");

        for (Empleado empleados : Empleados) {

            if (empleados.getNombre().equalsIgnoreCase(nombres)) {
                System.out.println(empleado);
                return empleado;
            }
        }
        } else {
            nombres = utilidades.PedirString("Introduzca el nombre del empleado que esta buscando: ");

        for (Empleado empleados : Empleados) {

            if (empleados.getNombre().equalsIgnoreCase(nombres)) {
                Despedir_empleado();
                return empleado;
            }
        }

        
        }
        return empleado;
        
    }

    /*
     * Metodo Despedir_empleado que elemina los datos de un empleado
     */
    public static void Despedir_empleado() {

        Empleados.remove(Empleados);
    }

    /*
     * Metodo booleano que comprueba que la modificacion del saldo es correcto
     */
    public boolean Modificacion_sueldo(int modificacion) {

        if (modificacion > 0) {
            return true;
        } else {
            return false;
        }
    }

}