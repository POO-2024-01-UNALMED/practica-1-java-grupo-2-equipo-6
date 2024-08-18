package gestorAplicacion.Gestion;

import java.io.Serializable;
import java.util.ArrayList;

public class Ingrediente implements Serializable {
    //Atributos
    private String nombre;
    private int precio;
    private int inventario;
    private double cantidad;
    private static ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();

    //Constructor
    public Ingrediente(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    public Ingrediente(String nombre, double cantidad){
        this.nombre = nombre;
        this.cantidad = cantidad;
        ingredientes.add(this);
    }
    public Ingrediente(String nombre, double cantidad, int precio, int inventario) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.inventario = inventario;
        ingredientes.add(this);
    }

    //Métodos
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public int getInventario() {
        return inventario;
    }
    public void setInventario(int inventario) {
        this.inventario = inventario;
    }
    public double getCantidad() {
        return cantidad;
    }
    public static ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
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
