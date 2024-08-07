package gestorAplicacion.Usuario;

import gestorAplicacion.Gestion.Factura;
import gestorAplicacion.Gestion.Mesa;
import gestorAplicacion.Gestion.Plato;
import gestorAplicacion.Gestion.Restaurante;

import java.util.ArrayList;

public class Cliente extends Persona {

    // Atributos
    private Factura factura;
    private Mesa mesa;
    private Restaurante restaurante;
    private String afiliacion;
    private int puntosAcumulados;
    private ArrayList<Plato> platosFavoritos = new ArrayList<Plato>();
    private String placaVehiculo;

    // Constructores
    public Cliente(){};

    public Cliente (int cedula, String nombre){
        super(nombre, cedula);
        this.afiliacion = "Ninguna";
        this.placaVehiculo = "Ninguna";
    }
    public Cliente (String nombre, int cedula, String afiliacion, String placaVehiculo){
        super(nombre, cedula);
        this.afiliacion = afiliacion;
        this.placaVehiculo = placaVehiculo;
    }
    public Cliente (String nombre, int cedula, String placaVehiculo){
        super(nombre, cedula);
        this.afiliacion = "Ninguna";
        this.placaVehiculo = placaVehiculo;
    }
    // Metodos
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

    public void setAfiliacion(String afiliacion){
        this.afiliacion = afiliacion;
    }

    public String getAfiliacion(){
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

    public void agregarPlatoFavorito(Plato plato){
        platosFavoritos.add(plato);
    }
}
