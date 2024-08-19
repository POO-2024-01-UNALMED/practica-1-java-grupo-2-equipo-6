package gestorAplicacion.Gestion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
public class Plato implements Serializable {
    // Atributos
    private static ArrayList<Plato> platos = new ArrayList<Plato>();
    private String nombre;
    private int precio;
    private ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
    private ArrayList<ArrayList<String>> cantidadIngredientes = new ArrayList<ArrayList<String>>();
    // Ingrediente, cantidad preparacion
//    private HashMap<Ingrediente, Double> ingredientesMenu = new HashMap<Ingrediente, Double>();
    private float calificacion;
    private boolean recomendado;
    private int cantidadCalificaciones;
    private int vecesPedido;
    private String tipo;
    private int pedidosRecomendados;
    private int valorEnPuntosCliente;
    private int porciones;
    private int cantidadDePlato;
    //Listas Stiven
    private static ArrayList<Plato> platosCumple = new ArrayList<Plato>(); //Lista de platos cumpleaños
    private static ArrayList<Plato> vinos_champanas_meeting = new ArrayList<Plato>();
    private static ArrayList<Plato> platos_varios = new ArrayList<Plato>();
    private static ArrayList<Plato> gastronomias_japonesa = new ArrayList<Plato>();
    private static ArrayList<Plato> gastronomias_italiana = new ArrayList<Plato>();
    private static ArrayList<Plato> gastronomias_marroqui = new ArrayList<Plato>();
    private static ArrayList<Plato> gastronomias_francesa = new ArrayList<Plato>();
    private static ArrayList<ArrayList<Plato>> platos_gastronomias = new ArrayList<ArrayList<Plato>>();

    // Constructor
    public Plato() {}

	
    public Plato(String nombre, int precio,  String tipo, ArrayList<Ingrediente> ingredientes) {
    	nombre = nombre;
    	precio = precio;
        this.tipo = tipo;
    	this.ingredientes = ingredientes;
    }

    public Plato(String nombre, int precio, ArrayList<Ingrediente> ingredientes,
                 ArrayList<ArrayList<String>> cantidadIngredientes, float calificacion) {
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

    public Plato(String nombre, int precio, ArrayList<Ingrediente> ingredientes, float calificacion, boolean recomendado,
                 int cantidadCalificaciones, int vecesPedido, int pedidosRecomendados) {
        this.nombre = nombre;
        this.precio = precio;
        this.ingredientes = ingredientes;
        this.calificacion = calificacion;
        this.recomendado = recomendado;
        this.cantidadCalificaciones = cantidadCalificaciones;
        this.vecesPedido = vecesPedido;
        this.pedidosRecomendados = pedidosRecomendados;
    }
    public Plato(String nombre, int precio, ArrayList<Ingrediente> ingredientes, int porciones, int cantidadDePlato) {
        this.nombre = nombre;
        this.precio = precio;
        this.ingredientes = ingredientes;
        this.porciones = porciones;
        this.cantidadDePlato = cantidadDePlato;
    }
    

    // Constructos vinos
    public Plato(String nombre, int precio, int porciones, int cantidadDePlato){
        this.nombre = nombre;
        this.precio = precio;
        this.porciones = porciones;
        this.cantidadDePlato = cantidadDePlato;
    }
    public Plato(String nombre, int vecesPedido, int precio){
        this.nombre = nombre;
        this.vecesPedido = vecesPedido;
        this.precio = precio;
    }
    public Plato(String nombre, int precio, int cantidadDePlato, String tipo){
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.cantidadDePlato = cantidadDePlato;
    }

    // Métodos
    //
    public static ArrayList<Plato> getGastronomias_francesa() {
        return gastronomias_francesa;
    }
    public static void setGastronomias_francesa(ArrayList<Plato> gastronomias_francesa) {
        Plato.gastronomias_francesa = gastronomias_francesa;
    }
    public static ArrayList<Plato> getGastronomias_marroqui() {
        return gastronomias_marroqui;
    }
    public static void setGastronomias_marroqui(ArrayList<Plato> gastronomias_marroqui) {
        Plato.gastronomias_marroqui = gastronomias_marroqui;
    }
    public static ArrayList<Plato> getGastronomias_italiana() {
        return gastronomias_italiana;
    }
    public static void setGastronomias_italiana(ArrayList<Plato> gastronomias_italiana) {
        Plato.gastronomias_italiana = gastronomias_italiana;
    }
    public static ArrayList<Plato> getGastronomias_japonesa() {
        return gastronomias_japonesa;
    }
    public static void setGastronomias_japonesa(ArrayList<Plato> gastronomias_japonesa) {
        Plato.gastronomias_japonesa = gastronomias_japonesa;
    }
    public static ArrayList<Plato> getPlatos_varios() {
        return platos_varios;
    }
    public static void setPlatos_varios(ArrayList<Plato> platos_varios) {
        Plato.platos_varios = platos_varios;
    }
    public static ArrayList<Plato> getVinos_champanas_meeting() {
        return vinos_champanas_meeting;
    }
    public static void setVinos_champanas_meeting(ArrayList<Plato> vinos_champanas_meeting) {
        Plato.vinos_champanas_meeting = vinos_champanas_meeting;
    }
    public static ArrayList<Plato> getPlatosCumple() {
        return platosCumple;
    }
    public static void setPlatosCumple(ArrayList<Plato> platosCumple) {
        Plato.platosCumple = platosCumple;
    }
    public static ArrayList<ArrayList<Plato>> getPlatos_gastronomias() {
        return platos_gastronomias;
    }
    public static void setPlatos_gastronomias(ArrayList<ArrayList<Plato>> platos_gastronomias) {
        Plato.platos_gastronomias = platos_gastronomias;
    }
    //

    public static ArrayList<Plato> getPlatos() {
        return platos;
    }
    public static void setPlatos(ArrayList<Plato> platos) {
        Plato.platos = platos;
    }
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

    public void setIngredientes(ArrayList<Ingrediente> ingredientes)
     {
        this.ingredientes = ingredientes;
    }

    public ArrayList<ArrayList<String>> getCantidadIngredientes() {
        return cantidadIngredientes;
    }

    public void setCantidadIngredientes(ArrayList<ArrayList<String>> cantidadIngredientes) {
        this.cantidadIngredientes = cantidadIngredientes;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = (getCalificacion()+calificacion)/(cantidadCalificaciones+1);
        cantidadCalificaciones++;
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

//    public void agregarIngrediente(Ingrediente ingrediente, int cantidadd)  {
//        this.ingredientesMenu.put(ingrediente, (double) cantidadd);
//    }
//    public void eliminarIngrediente(Ingrediente ingrediente) {
//        this.ingredientesMenu.remove(ingrediente);
//    }

    public void aumentarVecesPedido() {
        this.vecesPedido++;
    }

    public void aumentarPedidosRecomendados() {
        this.pedidosRecomendados++;
    }

    public int getPedidosRecomendados() {
        return pedidosRecomendados;
    }

    public int getValorEnPuntosCliente() {
        return valorEnPuntosCliente;
    }

    public void setValorEnPuntosCliente(int valorEnPuntosCliente) {
        this.valorEnPuntosCliente = valorEnPuntosCliente;
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
    public void descontarPlato(int cantidadDePlatoPedido){
        if (cantidadDePlatoPedido <= getCantidadDePlato()) {
            this.cantidadDePlato -= cantidadDePlatoPedido;
        }
        else {
            System.out.println("Error, proceso inválido");
        }
    }
    public int getPorciones(){
        return porciones;
    }
    public void setPorciones(int porciones){
        this.porciones = porciones;
    }
    public int getCantidadDePlato(){
        return cantidadDePlato;
    }

}
