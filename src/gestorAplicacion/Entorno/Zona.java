package gestorAplicacion.Entorno;

import gestorAplicacion.Gestion.Restaurante;

import java.io.Serializable;
import java.util.ArrayList;

public class Zona implements Serializable {
    //Atributos
    public Restaurante RestauranteZona;
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
    public Zona(Restaurante RestauranteZona, String nombre){
        this.nombre = nombre;
        this.RestauranteZona = RestauranteZona;
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
    public String getNombreRestaurante(){
        return RestauranteZona.getNombre();
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
