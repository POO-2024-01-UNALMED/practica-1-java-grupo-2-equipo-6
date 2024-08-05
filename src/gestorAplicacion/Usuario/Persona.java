package gestorAplicacion.Usuario;

public abstract class Persona {
    // Atributos
    protected String nombre;
    protected int cedula;

    // Constructores
    public Persona() {
    }

    public Persona(String nombre, int cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    // Metodo abstracto
    public abstract void mostrarInformacion();

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
}