package gestorAplicacion.Usuario;

public abstract class Persona {
    //Atributos
    protected int cedula;
    protected String nombre;

    //Métodos
    @Override
    public abstract String toString();
    public abstract int getCedula();
}