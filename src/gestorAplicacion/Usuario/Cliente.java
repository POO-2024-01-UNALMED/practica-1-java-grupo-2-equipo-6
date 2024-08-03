package gestorAplicacion.Usuario;

public class Cliente extends Persona {

    // constructor
    public Cliente(){}
    public Cliente(int cc, String nombre) {
        this.cedula = cc;
        this.nombre = nombre;
    }

    // Metodo abstracto de la clase Persona

    @Override
    public String toString() {
        String cadena = "Nombre: " + nombre + "Cédula: " + cedula;

        return cadena;
    }

    @Override
    public int getCedula() {
        return cedula;
    }
}
