package gestorAplicacion.Gestion;

import gestorAplicacion.Entorno.Casilla;
import gestorAplicacion.Entorno.Ciudad;
import gestorAplicacion.Entorno.Mesa;
import gestorAplicacion.Entorno.Zona;
import gestorAplicacion.Usuario.Cliente;
import gestorAplicacion.Usuario.Trabajador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import static uiMain.Utilidad.intersectarListas;

public class Restaurante implements Serializable {
    // Atributos
    private static final long serialVersionUID = 1L;
    private ArrayList<ArrayList<Integer>> intentosReserva = new ArrayList<ArrayList<Integer>>();
    private static ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();
    public ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public ArrayList<Plato> menu = new ArrayList<Plato>();
    public static int restaurantesCreados;
    public ArrayList<Mesa> mesas = new ArrayList<Mesa>();
    private ArrayList<ArrayList<String>> disposicion = new ArrayList<ArrayList<String>>();
    private ArrayList<Casilla> casillas = new ArrayList<Casilla>();
    private ArrayList<ArrayList<Integer>> fechasDisponibles = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Reserva> historialReservas = new ArrayList<Reserva>();
    private ArrayList<Boolean> parqueadero = new ArrayList<Boolean>(10);
    private Ciudad ciudad;
    private Zona zona;
    private boolean zonaVIP;
    private float calificacion;
    private int coordX;
    private int coordY;
    private ArrayList<ArrayList<String>> bodegaIngredientes = new ArrayList<ArrayList<String>>();
    private ArrayList<ArrayList<String>> bodegaItems = new ArrayList<ArrayList<String>>();
    private ArrayList<String> reseñas = new ArrayList<String>();
    private ArrayList<Plato> platosRecomendados = new ArrayList<Plato>();
    private ArrayList<Plato> platosDescuento = new ArrayList<Plato>();
    private String nombre;
    private int capacidad;
    private ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();
    private Cargamento cargamento;
    private int ganancias;

    // Constructores
    public Restaurante() {
        restaurantesCreados++;
    }
    public Restaurante(String nombre) {

    }
    public Restaurante(int capacidad, String nombre) {
        restaurantesCreados++;
        this.capacidad = capacidad;
        this.nombre = nombre;
    }
    public Restaurante(int capacidad, String nombre, ArrayList<Reserva> historialReservas){
        this(capacidad, nombre); //Caso #3 this()
        this.historialReservas = historialReservas;
    }
    public Restaurante(Ciudad ciudad, Zona zona, boolean zonaVIP, String nombre) {
        restaurantesCreados++;
        this.ciudad = ciudad;
        this.zona = zona;
        this.zonaVIP = zonaVIP;
        this.nombre = nombre;
    }

    // Métodos
    public static ArrayList<Restaurante> getRestaurantes() {
        return restaurantes;
    }
    public int getGanancias() {
        return ganancias;
    }
    public void setGanancias(int ganancias) {
        this.ganancias = ganancias;
    }
    public ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }
    public void setTrabajadores(ArrayList<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }
    public int getCapacidad(){
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    public ArrayList<ArrayList<Integer>> getFechasDisponibles() {
        return fechasDisponibles;
    }
    public void setFechasDisponibles(ArrayList<ArrayList<Integer>> fechasDisponibles) {
        this.fechasDisponibles = fechasDisponibles;
    }
    public ArrayList<Reserva> getHistorialReservas() {
        return historialReservas;
    }
    public Cargamento getCargamento() {
        return cargamento;
    }
    public void setCargamento(Cargamento cargamento) {
        this.cargamento = cargamento;
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
    public float getCalificacion() {
        return calificacion;
    }
    public void setCalificacion(float calificacion) {
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
    public int getCoordY() {
        return coordY;
    }
    public ArrayList<Mesa> getMesas() {
        return mesas;
    }
    public ArrayList<Casilla> getCasillas() {
        return casillas;
    }
    public ArrayList<Plato> getMenu() {
        return menu;
    }
    public void setMenu(ArrayList<Plato> menu) {
        this.menu = menu;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void anadirReserva(String reseña) {
        reseñas.add(reseña);
    }
    public void agregarPlatoRecomendado(Plato plato) {
        platosRecomendados.add(plato);
    }
    public void eliminarPlatoRecomendado(Plato plato) {
        platosRecomendados.remove(plato);
    }
    public void agregarPlatoDescuento(Plato plato) {
        platosDescuento.add(plato);
    }
    public void eliminarPlatoDescuento(Plato plato) {
        platosDescuento.remove(plato);
    }
    public ArrayList<Plato> getPlatosRecomendados() {
        return platosRecomendados;
    }
    public ArrayList<Plato> getPlatosDescuento() {
        return platosDescuento;
    }
    public void eliminarPlato(Plato plato) {
        menu.remove(plato);
    }
    public void agregarPlato(Plato plato) {
        menu.add(plato);
    }
    public void agregarMesa(Mesa mesa) {
        mesas.add(mesa);
    }
    public ArrayList<Boolean> getParqueadero() {
        return parqueadero;
    }
    public ArrayList<ArrayList<Integer>> getIntentosReserva() {
        return intentosReserva;
    }
    public void anadirIntentosReserva(ArrayList<Integer> intentoReserva) {
        intentosReserva.add(intentoReserva);
    }
    public ArrayList<ArrayList<String>> getBodegaIngredientes() {
        return bodegaIngredientes;
    }
    public ArrayList<ArrayList<String>> getBodegaItems() {
        return bodegaItems;
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

    public void restarDeBodegaIngrediente(int indice, int cantidad) {
        int cantidadPasada = Integer.parseInt(this.bodegaIngredientes.get(indice).get(1));
        String nombre = this.bodegaIngredientes.get(indice).getFirst();
        this.bodegaIngredientes.remove(indice);
        this.bodegaIngredientes.add(new ArrayList<String>(Arrays.asList(nombre,
                String.valueOf(cantidadPasada - cantidad))));
    }
    public void restarDeBodega(int indice, int cantidad) {
        if (indice != -1) {
            int cantidadPasada = Integer.parseInt(this.bodegaItems.get(indice).get(1));
            String nombre = this.bodegaItems.get(indice).getFirst();
            this.bodegaItems.remove(indice);
            this.bodegaItems.add(new ArrayList<String>(Arrays.asList(nombre,
                    String.valueOf(cantidadPasada - cantidad))));
        }

    }
}
