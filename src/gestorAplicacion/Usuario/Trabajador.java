package gestorAplicacion.Usuario;

import gestorAplicacion.Gestion.Evento;

import java.io.Serializable;
import java.util.ArrayList;

public class Trabajador extends Persona implements Serializable {
    private static ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();
    private String especialidad;
    private int salario;
    private boolean ocupado;
    private float calificacion;
    private ArrayList<String> reseñas = new ArrayList<String>();

    public Trabajador() {}
    public Trabajador(String nombre, int cedula, String especialidad, int salario) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.especialidad = especialidad;
        this.salario = salario;
        this.ocupado = false;
        this.calificacion = 0;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Cedula: " + cedula);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Salario: " + salario);
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

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public boolean getOcupado() {
        return ocupado;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void addReseña(String reseña) {
        reseñas.add(reseña);
    }

    public ArrayList<String> getReseñas() {
        return reseñas;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
    public void PagoExtraServicio(ArrayList<Evento> eventos, String especialidad) {
        for (Evento evento : eventos) {
            if (evento.getNombre().equals(getEspecialidad())) {
                this.salario += 40000;
            }
        }
    }
}

