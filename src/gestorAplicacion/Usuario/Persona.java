package gestorAplicacion.Usuario;

public abstract class Persona {
    // Atributos
    protected String nombre;
    protected int cedula;

    // Metodo abstracto
    public abstract void mostrarInformacion();

    // Getters y Setters
    public abstract String getNombre();
    public abstract void setNombre(String nombre);
    public abstract int getCedula();
    public abstract void setCedula(int cedula);
}