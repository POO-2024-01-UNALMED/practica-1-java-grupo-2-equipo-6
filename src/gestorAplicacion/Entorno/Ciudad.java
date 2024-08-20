package gestorAplicacion.Entorno;

import java.io.Serializable;
import java.util.ArrayList;

public class Ciudad extends Zona implements Serializable {
    //Atributos
    private static ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
    private ArrayList<Zona> zonasCiudad = new ArrayList<Zona>();

    //Construtores
    public Ciudad(){
        ciudades.add(this);
    }
    public Ciudad(String nombre) {
        this.nombre = nombre;
        ciudades.add(this);
    }

    //Métodos
    public ArrayList<Zona> getZonasCiudad() {
        return zonasCiudad;
    }
    public static ArrayList<Ciudad> getCiudades() {
        return ciudades;
    }

    public void actualizarPoblacion() {
        this.poblacion = 0;
        for (Zona zona : this.zonasCiudad) {
            this.poblacion += (int) zona.getPoblacion();
        }
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{Información de la Ciudad: ");
        sb.append("poblacion = ").append(poblacion);
        sb.append(", nombre = '").append(nombre).append("'}");
        return sb.toString();
    }
    public void agregarZonas(Zona zona){
        zonasCiudad.add(zona);
    }

}
