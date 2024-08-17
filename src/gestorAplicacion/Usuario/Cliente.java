package gestorAplicacion.Usuario;

import gestorAplicacion.Entorno.Mesa;
import gestorAplicacion.Gestion.*;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente extends Persona implements Serializable {
    // Atributos
    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private Pedido pedido;
    private Factura factura;
    private Mesa mesa;
    private Restaurante restaurante;
    private Enum afiliacion;
    private int puntosAcumulados;
    private ArrayList<Plato> platosFavoritos = new ArrayList<Plato>();
    private String placaVehiculo;
    private Reserva reserva;

    // Constructores
    public Cliente(){};
    public Cliente (String nombre, int cedula){
        this.nombre = nombre;
        this.cedula = cedula;
        this.afiliacion = Afiliacion.NINGUNA;
        this.placaVehiculo = "Ninguna";
    }
    public Cliente (String nombre, int cedula, Enum afiliacion, String placaVehiculo){
        this.nombre = nombre;
        this.cedula = cedula;
        this.afiliacion = afiliacion;
        this.placaVehiculo = placaVehiculo;
    }
    public Cliente (String nombre, int cedula, String placaVehiculo){
        this.nombre = nombre;
        this.cedula = cedula;
        this.afiliacion = Afiliacion.NINGUNA;
        this.placaVehiculo = placaVehiculo;
    }
    public Cliente (String nombre, int cedula, String placaVehiculo, Factura factura){
        this(nombre, cedula, placaVehiculo); //Caso #2 this()
        this.afiliacion = Afiliacion.NINGUNA;
        this.placaVehiculo = placaVehiculo;
        this.factura = factura;
    }

    // Métodos
    public void mostrarInformacion(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Cedula: " + cedula);
        System.out.println("Afiliacion: " + afiliacion);
        System.out.println("Placa del vehiculo: " + placaVehiculo);
    }
    public static void despedida(Persona persona) {
        persona.despedida();
    }

    @Override
    public String getNombre() {
        return nombre;
    }
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public int getCedula() {
        return cedula;
    }
    @Override
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    public void setFactura(Factura factura){
        this.factura = factura;
    }
    public Pedido getPedido() {
        return pedido;
    }
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    public Factura getFactura(){
        return factura;
    }
    public void setMesa(Mesa mesa){
        this.mesa = mesa;
    }
    public Mesa getMesa(){
        return mesa;
    }
    public void setRestaurante(Restaurante restaurante){
        this.restaurante = restaurante;
    }
    public Restaurante getRestaurante(){
        return restaurante;
    }
    public void setAfiliacion(Enum afiliacion){
        this.afiliacion = afiliacion;
    }
    public Enum getAfiliacion(){
        return afiliacion;
    }
    public void setPuntosAcumulados(int puntosAcumulados){
        this.puntosAcumulados = puntosAcumulados;
    }
    public int getPuntosAcumulados(){
        return puntosAcumulados;
    }
    public void setPlatosFavoritos(ArrayList<Plato> platosFavoritos){
        this.platosFavoritos = platosFavoritos;
    }
    public ArrayList<Plato> getPlatosFavoritos(){
        return platosFavoritos;
    }
    public void setPlacaVehiculo(String placaVehiculo){
        this.placaVehiculo = placaVehiculo;
    }
    public String getPlacaVehiculo(){
        return placaVehiculo;
    }
    public Reserva getReserva() {
        return reserva;
    }
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }


    public void agregarPlatoFavorito(Plato plato){
        platosFavoritos.add(plato);
    }

    public void resetDatosReserva() {
        this.restaurante = null;
        this.mesa = null;
        this.factura = null;
        this.reserva = null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Datos del cliente:");
        sb.append("\nNombre: ").append(nombre);
        sb.append("\nCédula: ").append(cedula);
        return sb.toString();
    }

    //Enum
    public enum Afiliacion {NINGUNA, ESTRELLITA, ESTRELLA, SUPERESTRELLOTA}

    public boolean esAfiliado() {
        if (this.getAfiliacion() != Afiliacion.NINGUNA) {
            return true;
        } else {
            return false;
        }
    }

    	
	public Pedido mostrarPedido() {
		
		if (pedido.getPlatos().isEmpty()) {
			System.out.print("Todavia no  hay platos agregados");
		}

		return pedido;
		
		
	}

	public void agregarPedido(Pedido pedidoAgregar){
		
		pedido.agregarPlato(pedidoAgregar.getPlatos());
		

	}
}
