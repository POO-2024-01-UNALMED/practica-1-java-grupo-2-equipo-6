package gestorAplicacion.Usuario;

import java.util.ArrayList;

    public class Trabajador extends Persona {
        private String especialidad;
        private int salario;
        private boolean ocupado;
        private float calificacion;
        private ArrayList<String> reseñas = new ArrayList<String>();

        public Trabajador(String nombre, int cedula, String especialidad, int salario) {
            super(nombre, cedula);
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
    }

