package gestorAplicacion.Entorno;

import gestorAplicacion.Entorno.Zona;

import java.util.ArrayList;

public class Ciudad extends Zona {
    //Atributos
    private ArrayList<Zona> zonas = new ArrayList<Zona>();
    //Construtores
    public Ciudad(){}
    public Ciudad(String nombre) {
        this.nombre = nombre;
    }
    //Métodos
    public ArrayList<Zona> getZonas() {
        return zonas;
    }
    public void setZonas(ArrayList<Zona> zonas) {
        this.zonas = zonas;
    }
    public void addZona(Zona zona) {
        this.zonas.add(zona);
    }
    public void actualizarPoblacion() {
        this.poblacion = 0;
        for (Zona zona : this.zonas) {
            this.poblacion += (int) zona.getPoblacion();
        }
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(nombre);
        sb.append(", poblacion = ").append(poblacion);
        return sb.toString();
    }
}
