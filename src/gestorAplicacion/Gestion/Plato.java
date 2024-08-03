package gestorAplicacion.Gestion;

import java.util.ArrayList;

public class Plato {
    // Atributos
    private String nombre;
    private int precio;
    private ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
    private float calificacion;
    private boolean recomendado;
    private int cantidadCalificaciones;
    private int vecesPedido;
    private String tipo;

    // Constructor
    public Plato() {}

    public Plato(String nombre, int precio, ArrayList<Ingrediente> ingredientes, float calificacion) {
        this.nombre = nombre;
        this.precio = precio;
        this.ingredientes = ingredientes;
        this.calificacion = calificacion;
    }

    public Plato(String nombre, int precio, ArrayList<Ingrediente> ingredientes) {
        this.nombre = nombre;
        this.precio = precio;
        this.ingredientes = ingredientes;
    }

    // Métodos
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

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public boolean isRecomendado() {
        return recomendado;
    }

    public void setRecomendado(boolean recomendado) {
        this.recomendado = recomendado;
    }

    public int getCantidadCalificaciones() {
        return cantidadCalificaciones;
    }

    public void setCantidadCalificaciones(int cantidadCalificaciones) {
        this.cantidadCalificaciones = cantidadCalificaciones;
    }

    public int getVecesPedido() {
        return vecesPedido;
    }

    public void setVecesPedido(int vecesPedido) {
        this.vecesPedido = vecesPedido;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Plato{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", precio=").append(precio);
        sb.append(", ingredientes=").append(ingredientes);
        sb.append('}');
        return sb.toString();
    }

    public String getTipo() {
        return this.tipo;

    }
}
