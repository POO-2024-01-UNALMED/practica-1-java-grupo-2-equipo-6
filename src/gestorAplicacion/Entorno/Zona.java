package gestorAplicacion.Entorno;

import gestorAplicacion.Gestion.Restaurante;

import java.util.ArrayList;

public class Zona {
    //Atributos
    protected String nombreZona;
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
        this.poblacion = poblacion;
        this.nombre = nombre;
        this.ciudad = ciudad;
    }
    public Zona(Restaurante RestauranteZona, String nombreZona){
        this.nombreZona = nombreZona;
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
    public String getNombreRestaurante(){
        return RestauranteZona.getNombre();
    }
}
