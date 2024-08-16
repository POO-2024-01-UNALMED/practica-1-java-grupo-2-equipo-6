package gestorAplicacion.Gestion;

import gestorAplicacion.Entorno.Casilla;
import gestorAplicacion.Usuario.Cliente;

import java.io.Serializable;
import java.util.ArrayList;

public class Mesa extends Casilla implements Serializable {
    //Atributos
    public static int contadorMesa = 1;
    private ArrayList<ArrayList<Integer>> fechasDisponibles = new ArrayList<ArrayList<Integer>>();
    private int numMesa;
    private boolean VIP;
    private ArrayList<Factura> facturas = new ArrayList<Factura>();
    private int valorTotal;
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private int numAsientos = 4;
    private int ultimaFechaReserva;
    private Restaurante restaurante;
    private ArrayList<Integer> coordenada = new ArrayList<Integer>();
    private int distanciaPuerta = 9999;
    private int distanciaVentana = 9999;


    //Constructor
    public Mesa(){}

    public Mesa(int tipo, int coordX, int coordY, boolean VIP, int numAsientos) {
        super(tipo, coordX, coordY);
        this.numAsientos = numAsientos;
        this.VIP = VIP;
        this.numMesa = contadorMesa;
        contadorMesa++;
    }

    //Métodos
    public boolean isVIP() {
        return VIP;
    }
    public void setVIP(boolean VIP) {
        this.VIP = VIP;
    }
    public int getNumMesa() {
        return numMesa;
    }
    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }
    public void agregarFactura(Factura factura){
        facturas.add(factura);
    }
    public void setNumAsientos(int numAsientos){
        this.numAsientos = numAsientos;
    }
    public int getNumAsientos(){
        return numAsientos;
    }
    public void setRestaurante(Restaurante restaurante){
        this.restaurante = restaurante;
    }
    public Restaurante getRestaurante(){
        return restaurante;
    }
    public boolean getVIP(){
        return VIP;
    }
    public void setCoordenada(ArrayList<Integer> coordenada){
        this.coordenada = coordenada;
    }
    public ArrayList<Integer> getCoordenada(){
        return coordenada;
    }
    public void agregarCliente(Cliente cliente){
        clientes.add(cliente);
    }
    public ArrayList<Cliente> getClientes(){
        return clientes;
    }
    public void setClientes(ArrayList<Cliente> clientes){
        this.clientes = clientes;
    }
    public void setFacturas(ArrayList<Factura> facturas){
        this.facturas = facturas;
    }
    public ArrayList<Factura> getFacturas(){
        return facturas;
    }
    public void setValorTotal(int valorTotal){
        this.valorTotal = valorTotal;
    }
    public int getValorTotal(){
        return valorTotal;
    }
    public int getDistanciaPuerta() {
        return distanciaPuerta;
    }
    public void setDistanciaPuerta(int distanciaPuerta) {
        this.distanciaPuerta = distanciaPuerta;
    }
    public int getDistanciaVentana() {
        return distanciaVentana;
    }
    public void setDistanciaVentana(int distanciaVentana) {
        this.distanciaVentana = distanciaVentana;
    }
    public ArrayList<ArrayList<Integer>> getFechasDisponibles() {
        return fechasDisponibles;
    }
    public void setFechasDisponibles(ArrayList<ArrayList<Integer>> fechasDisponibles) {
        this.fechasDisponibles = fechasDisponibles;
    }
    public int getUltimaFechaReserva() {
        return ultimaFechaReserva;
    }
    public void setUltimaFechaReserva(int ultimaFechaReserva) {
        this.ultimaFechaReserva = ultimaFechaReserva;
    }
}
