package gestorAplicacion.Gestion;

import gestorAplicacion.Entorno.Casilla;
import gestorAplicacion.Entorno.Ciudad;
import gestorAplicacion.Entorno.Zona;
import gestorAplicacion.Usuario.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class Restaurante {
    //Atributos
    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public static ArrayList<Plato> menu = new ArrayList<Plato>();
    public static ArrayList<Mesa> mesas = new ArrayList<Mesa>();
    private ArrayList<ArrayList<String>> disposicion = new ArrayList<ArrayList<String>>();
    private ArrayList<Casilla> casillas = new ArrayList<Casilla>();
    public static int restaurantesCreados;
    private Ciudad ciudad;
    private Zona zona;
    private boolean zonaVIP;
    private int calificacion;
    private int coordX;
    private int coordY;
    private ArrayList<Ingrediente> bodega = new ArrayList<Ingrediente>();
    private ArrayList<Reserva> reservas = new ArrayList<Reserva>();

    //Constructores
    public Restaurante() {
        restaurantesCreados++;
    }
    public Restaurante(Ciudad ciudad, Zona zona, boolean zonaVIP) {
        restaurantesCreados++;
        this.ciudad = ciudad;
        this.zona = zona;
        this.zonaVIP = zonaVIP;
    }

    //Métodos
    static Scanner consola = new Scanner(System.in);
    static String readString() {
        return consola.nextLine();
    }
    static int readInt() {
        return Integer.parseInt(consola.nextLine());
    }
    public boolean isZonaVIP() {
        return zonaVIP;
    }
    public void setZonaVIP(boolean zonaVIP) {
        this.zonaVIP = zonaVIP;
    }
    public Zona getZona() {
        return zona;
    }
    public void setZona(Zona zona) {
        this.zona = zona;
    }
    public Ciudad getCiudad() {
        return ciudad;
    }
    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    public int getCalificacion() {
        return calificacion;
    }
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
    public ArrayList<ArrayList<String>> getDisposicion() {
        return disposicion;
    }
    public void setDisposicion(ArrayList<ArrayList<String>> disposicion) {
        this.disposicion = disposicion;
    }
    public int getCoordX() {
        return coordX;
    }
    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }
    public int getCoordY() {
        return coordY;
    }
    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }
    public static ArrayList<Mesa> getMesas() {
        return mesas;
    }
    public static void setMesas(ArrayList<Mesa> mesas) {
        Restaurante.mesas = mesas;
    }
    public ArrayList<Casilla> getCasillas() {
        return casillas;
    }
    public void setCasillas(ArrayList<Casilla> casillas) {
        this.casillas = casillas;
    }
    public static ArrayList<Plato> getMenu() {
        return menu;
    }
    public static void setMenu(ArrayList<Plato> menu) {
        Restaurante.menu = menu;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{Información del Restaurante: ");
        sb.append("ciudad=").append(ciudad.getNombre());
        sb.append(", zona=").append(zona.getNombre());
        sb.append(", zonaVIP=").append(zonaVIP);
        sb.append(", calificacion=").append(calificacion);
        sb.append(", mesas=").append(mesas);
        sb.append(", menu=").append(menu);
        sb.append('}');
        return sb.toString();
    }
    //    FUNCIONALIDAD NUMERO 4: agregarSede
//    Interacción 1: elegirCiudad

}
