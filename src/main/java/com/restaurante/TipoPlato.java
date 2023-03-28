package com.restaurante;

public class TipoPlato {
    public enum EnumPlato {
        ENTRANTE(1, "Entrante"),
        PLATO_PRINCIPAL(2, "Plato principal"),
        POSTRE(3, "Postre");
        private String nombre;
        private int num;

        EnumPlato(int num, String nombre) {
            this.nombre = nombre;
            this.num = num;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getNum() {
            return this.num;
        }
    }

    private static int mostrar_menu(String txt) {
        System.out.println("MENU TIPOS DE PLATO");
        for(EnumPlato tipo: EnumPlato.values()) {
            System.out.println(tipo.getNum() + " " +  tipo.getNombre());
        }
        return utilidades.PideEntero("Escoge el tipo de plato: ");
    }

    public static EnumPlato elegir() {
        int opcion;
        String txt = new String();
        EnumPlato elegido = null;
        do {
            System.out.println(txt);
            opcion = mostrar_menu(txt);
            for(EnumPlato tipo: EnumPlato.values()) {
                if(tipo.getNum() == opcion) {
                    elegido = tipo;
                }
            }
            txt = "Has elegido un tipo de plato incorrecto. Intentalo de nuevo";

        } while( elegido == null);
        return elegido;
    }
}