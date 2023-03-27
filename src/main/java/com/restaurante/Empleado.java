package com.restaurante;

/**
 * @TitoSam007
 * @project RESTAURANTE-Samuel-y-Cristian- - com.restaurante
 * @created 25/3/23
 */
public class Empleado {
    public enum tipo_puesto {
        Cocinero, Ayudante_de_cocina, Office, Jefe_de_cocina, Cheff, Camarero, Jefe_de_sala
    }
    // PARAMETROS

    private int edad;
    private String Nombre;
    private String Apellidos;
    private int saldo;
    private int aumento;
    private int disminucion;
    private tipo_puesto puesto;

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
     * @param aumento int que almacena el aumento de salario del empleado
     * 
     * @param disminucion int que almacena la disminucion del salario de un empleado 
     */
    public Empleado(int Edad, String Nombre, String Apellidos, tipo_puesto puesto, int saldo, int aumento, int disminucion) {
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
     * Metodo get
     * 
     * @return Devuelve el aumento del salario de un empleado
     */
    public int getAumento() {
        return aumento;
    }

    /*
     * Metodo set que actualiza el aumento de salario del un empleado
     * 
     * @param int que pasa a ser el nuevo aumento del sueldo del empleado
     */
    public void setAumento(int aumento) {
        this.aumento = aumento;
    }

    /*
     * Metodo get
     * 
     * @return Devuelve la dismunicion del sueldo del empleado
     */
    public int getDisminucion() {
        return disminucion;
    }

    /*
     * Metodo set que actualiza la disminucion del seldo del empleado
     * 
     * @param int que pasara a ser la nueva disminucion del saldo del empleado
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
     * Metodo que actualiza el puesto del empleado
     * 
     * @aram tipo_puesto que pasa a ser el nuevo puesto del empleado
     */
    public void setPuesto(tipo_puesto puesto) {
        this.puesto = puesto;
    }

    /*
     * Metodo Puesto_empleado con 4 atributos
     * Verifica cual es el puesto actual del empleado
     */
    public void Puesto_empleado_actualizado(String nombre, String apellidos, int edad, tipo_puesto puesto) {

        this.puesto = puesto;
        this.Nombre = nombre;
        this.Apellidos = apellidos;
        this.edad = edad;

        System.out.print("Datos actualizados: " + "\t" +
                "Nombre del trabajador: " + nombre + "\t" +
                "Apellidos del trabajador: " + apellidos + "\t" +
                "Edad del empleado: " + edad + "\t" +
                "Puesto del trabajador: " + puesto);
    }

    /*
     * Metos Aumento_del_sueldo con 4 atributos
     * Verifica cual es el sueldo actual del trabajador
     */
    public void Aumento_del_sueldo(String nombre, String apellidos, tipo_puesto puesto, int saldo, int aumento) {

        this.Nombre = nombre;
        this.Apellidos = apellidos;
        this.puesto = puesto;
        this.saldo = saldo;

        Modificacion_sueldo(saldo);

        saldo += aumento;

        System.out.print("Datos actualizados: " + "\t" +
                "Nombre del trabajador: " + nombre + "\t" +
                "Apellidos del trabajador: " + apellidos + "\t" +
                "Edad del empleado: " + edad + "\t" +
                "Puesto del trabajador: " + puesto + "\t" +
                "Sueldo del trabajador: " + saldo);

    }

    /*
     * Metodo Disminucion_del_sueldo cont 4 atributos
     * Verifica cual es el sueldo actual del trabajador
     */
    public void Disminucion_del_sueldo(String nombre, String apellidos, tipo_puesto puesto, int saldo,
            int disminucion) {

        this.Nombre = nombre;
        this.Apellidos = apellidos;
        this.puesto = puesto;
        this.saldo = saldo;

        Modificacion_sueldo(saldo);

        saldo -= disminucion;

        System.out.print("Datos actualizados: " + "\t" +
                "Nombre del trabajador: " + nombre + "\t" +
                "Apellidos del trabajador: " + apellidos + "\t" +
                "Edad del empleado: " + edad + "\t" +
                "Puesto del trabajador: " + puesto + "\t" +
                "Sueldo del trabajador: " + saldo);
    }

    /*
     * Metodo booleano que comprueba que el aumentodo es correcto
     */
    public boolean Modificacion_sueldo(int saldo) {

        if (saldo > 0) {
            return true;
        } else {
            return false;
        }
    }

}
