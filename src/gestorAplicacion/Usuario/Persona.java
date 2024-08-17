package gestorAplicacion.Usuario;

public abstract class Persona {
    // Atributos
    protected String nombre;
    protected int cedula;

    public Persona(String nombre, int cedula) {
    }

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