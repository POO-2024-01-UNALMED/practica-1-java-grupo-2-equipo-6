package gestorAplicacion.Usuario;

import gestorAplicacion.Gestion.*;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente extends Persona implements Serializable {
    // Atributos
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
        super(nombre, cedula);
        this.afiliacion = Afiliacion.NINGUNA;
        this.placaVehiculo = "Ninguna";
    }
    public Cliente (String nombre, int cedula, Enum afiliacion, String placaVehiculo){
        super(nombre, cedula);
        this.afiliacion = afiliacion;
        this.placaVehiculo = placaVehiculo;
    }
    public Cliente (String nombre, int cedula, String placaVehiculo){
        super(nombre, cedula);
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
    public void setFactura(Factura factura){
        this.factura = factura;
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
}
