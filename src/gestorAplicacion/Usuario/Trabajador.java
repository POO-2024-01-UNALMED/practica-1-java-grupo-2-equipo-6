package gestorAplicacion.Usuario;

import gestorAplicacion.Entorno.Mesa;
import gestorAplicacion.Gestion.*;

import java.io.Serializable;
import java.util.ArrayList;

public class Trabajador extends Persona implements Serializable {
    private static ArrayList<Trabajador> cocineros = new ArrayList<Trabajador>();
    private static ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();
    private String especialidad;
    private int salario;
    private float calificacion;
    private ArrayList<String> reseñas = new ArrayList<String>();
    private Restaurante restaurante;
    private Enum tipo;
    private Mesa mesa;
    private int gananciasExtra;

    public enum Tipo {COCINERO, MESERO} //Caso #2 Enum

    public Trabajador() {}

    public Trabajador(String nombre, int cedula, String especialidad, int salario) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.especialidad = especialidad;
        this.salario = salario;
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

    public void aumentarGananciasExtra(int valor) {
        this.gananciasExtra += valor;
    }
    public Enum getTipo() {
        return tipo;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public static ArrayList<Trabajador> getCocineros() {
        return cocineros;
    }
    public static void setCocineros(ArrayList<Trabajador> cocineros) {
        Trabajador.cocineros = cocineros;
    }
    public Mesa getMesa() {
        return mesa;
    }
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public void pagoExtraServicio(ArrayList<Evento> eventos, String especialidad) {
        for (Evento evento : eventos) {
            if (evento.getNombre().equals(getEspecialidad())) {
                this.salario += 40000;
            }
        }
    }

    public ArrayList<Plato> cocinar(Pedido pedido) {
        ArrayList<Plato> platosCocinados = new ArrayList<Plato>();
        for (Plato plato: pedido.getPlatos()) {
            for (ArrayList<String> ingredienteCantidad : plato.getCantidadIngredientes()) { //["NombreIngrediente", "2"]
                for (ArrayList<String> ingrediente : pedido.getRestaurante().getBodegaIngredientes()) {
                    int enBodegaAntes = Integer.parseInt(ingrediente.get(1));
                    int cantidadRequerida = Integer.parseInt(ingredienteCantidad.get(1));
                    //Ver la cantidad de ese ingrediente en bodegaIngredientes de restaurante
                    if (cantidadRequerida <= enBodegaAntes) {
                        int enBodegaAhora = enBodegaAntes - cantidadRequerida;
                        ingrediente.remove(1);
                        ingrediente.add(String.valueOf(enBodegaAhora));
                        platosCocinados.add(plato);
                    }
                }
            }
        }
        return platosCocinados;
    }
}