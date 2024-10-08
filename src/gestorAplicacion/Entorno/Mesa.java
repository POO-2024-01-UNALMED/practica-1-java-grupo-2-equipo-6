package gestorAplicacion.Entorno;

import gestorAplicacion.Gestion.Factura;
import gestorAplicacion.Gestion.Restaurante;
import gestorAplicacion.Usuario.Cliente;
import gestorAplicacion.Gestion.Pedido;
import gestorAplicacion.Usuario.Trabajador;

import java.io.Serializable;
import java.util.ArrayList;

public class Mesa extends Casilla implements Serializable {
    //Atributos
    private static final long serialVersionUID = 1L;
    private static ArrayList<Mesa> mesas = new ArrayList<Mesa>();
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
    private Pedido pedido;
    private Trabajador mesero;

    //Constructor
    public Mesa(){
        mesas.add(this);
    }

    public Mesa(int tipo, int coordX, int coordY, boolean VIP, int numAsientos) {
        super(tipo, coordX, coordY);
        this.numAsientos = numAsientos;
        this.VIP = VIP;
        this.numMesa = contadorMesa;
        contadorMesa++;
        mesas.add(this);
    }

    public static ArrayList<Mesa> getMesas() {
        return mesas;
    }

    //Métodos

    public boolean isVIP() {
        return VIP;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setRestaurante(Restaurante restaurante){
        this.restaurante = restaurante;
    }
    public Restaurante getRestaurante(){
        return restaurante;
    }
    public ArrayList<Cliente> getClientes(){
        return clientes;
    }
    public void setClientes(ArrayList<Cliente> clientes){
        this.clientes = clientes;
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
    public void setMesero(Trabajador mesero) {
        this.mesero = mesero;
    }
}
