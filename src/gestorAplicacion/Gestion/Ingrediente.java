package gestorAplicacion.Gestion;

import java.io.Serializable;
import java.util.ArrayList;

public class Ingrediente implements Serializable {
    //Atributos
    private static final long serialVersionUID = 1L;
    private String nombre;
    private int precio;
    private static ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();

    //Constructor
    public Ingrediente() {
        ingredientes.add(this);
    }
    public Ingrediente(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
        ingredientes.add(this);
    }
    public Ingrediente(String nombre, double cantidad){
        this.nombre = nombre;
        ingredientes.add(this);
    }
    public Ingrediente(String nombre, double cantidad, int precio, int inventario) {
        this.nombre = nombre;
        this.precio = precio;
        ingredientes.add(this);
    }

    //Métodos
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public static ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }
    public static void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        Ingrediente.ingredientes = ingredientes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ingrediente{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", precio=").append(precio);
        sb.append('}');
        return sb.toString();
    }
}
