package gestorAplicacion.Entorno;

import gestorAplicacion.Gestion.Restaurante;

import java.io.Serializable;
import java.util.ArrayList;

public class Zona implements Serializable {
    //Atributos
    private static ArrayList<Zona> zonas = new ArrayList<Zona>();
    protected int poblacion;
    protected String nombre;
    private ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();
    private Ciudad ciudad;

    //Constructores
    public Zona(){}
    public Zona(int poblacion, String nombre) {
        this.poblacion = poblacion;
        this.nombre = nombre;
    }
    public Zona(int poblacion, String nombre, Ciudad ciudad) {
        this(poblacion, nombre); //Caso #1 this()
        this.ciudad = ciudad;
    }

    //Métodos
    public Ciudad getCiudad() {
        return ciudad;
    }
    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    public double getPoblacion() {
        return poblacion;
    }
    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public ArrayList<Restaurante> getRestaurantes() {
        return restaurantes;
    }
    public void setRestaurantes(ArrayList<Restaurante> restaurantes) {
        this.restaurantes = restaurantes;
    }
    public static ArrayList<Zona> getZonas() {
        return zonas;
    }
    public static void setZonas(ArrayList<Zona> zonas) {
        Zona.zonas = zonas;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{Información de la Zona: ");
        sb.append("poblacion = ").append(poblacion);
        sb.append(", nombre = '").append(nombre).append('\'');
        sb.append(", restaurantes = ").append(restaurantes);
        sb.append(", ciudad = ").append(ciudad);
        sb.append('}');
        return sb.toString();
    }
}
