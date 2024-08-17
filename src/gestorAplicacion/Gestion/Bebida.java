package gestorAplicacion.Gestion;

import java.util.ArrayList;
import java.util.List;

public class Bebida implements Receta{
    //Atributos
    private enum temperatura {CALIENTE, FRIO};
    private Enum temperatura;
    private String nombre;
    private int precio;
    private ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
    private float calificacion;
    private boolean recomendado;
    private int cantidadCalificaciones;
    private int vecesPedido;
    private int pedidosRecomendados;
    private int valorEnPuntosCliente;
    private float onzas;

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
    public int getPedidosRecomendados() {
        return pedidosRecomendados;
    }
    public void setPedidosRecomendados(int pedidosRecomendados) {
        this.pedidosRecomendados = pedidosRecomendados;
    }
    public int getValorEnPuntosCliente() {
        return valorEnPuntosCliente;
    }
    public void setValorEnPuntosCliente(int valorEnPuntosCliente) {
        this.valorEnPuntosCliente = valorEnPuntosCliente;
    }
    public float getOnzas() {
        return onzas;
    }
    public void setOnzas(float onzas) {
        this.onzas = onzas;
    }
    public Enum getTemperatura() {
        return temperatura;
    }
    public void setTemperatura(Enum temperatura){
        this.temperatura = temperatura;
    }
}


