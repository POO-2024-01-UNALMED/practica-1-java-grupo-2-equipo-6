package gestorAplicacion.Usuario;

import java.awt.*;
import java.io.Serializable;

public abstract class Persona implements Serializable {
    // Atributos
    private static final long serialVersionUID = 1L;
    protected String nombre;
    protected int cedula;

    // Metodo abstracto
    public abstract void mostrarInformacion();

    //Metodo
    public String despedida() {
        return "Hasta luego " + nombre + ".\nEsperamos que regreses pronto.";
    }
    // Getters y Setters
    public abstract String getNombre();
    public abstract void setNombre(String nombre);
    public abstract int getCedula();
    public abstract void setCedula(int cedula);
}