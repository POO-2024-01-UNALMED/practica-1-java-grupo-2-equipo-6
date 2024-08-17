package gestorAplicacion.Gestion;

import gestorAplicacion.Entorno.Ciudad;
import gestorAplicacion.Entorno.Zona;
import gestorAplicacion.Usuario.Cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Reserva implements Serializable {
    //Atributos
    private ArrayList<Cliente> clientes;
    //Preguntarle a Colo por esta vaina del Date
    private ArrayList<Integer> fecha; //[2024, 8, 23, 16]
    private Restaurante restaurante;
    private boolean satisfaccion = false;

    //Constructores
    public Reserva(){}
    public Reserva(ArrayList<Cliente> clientes, ArrayList<Integer> fecha){
        this.fecha = fecha;
        this.clientes = clientes;
    }

    //Metodos
    public ArrayList<Integer> getFecha(){
        return fecha;
    }
    public void setFecha(ArrayList<Integer> fecha){
        this.fecha = fecha;
    }
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    public Restaurante getRestaurante() {return restaurante;}
    public void setRestaurante(Restaurante restaurante) {this.restaurante = restaurante;}
    public boolean isSatisfaccion() {return satisfaccion;}
    public void setSatisfaccion(boolean satisfaccion) {this.satisfaccion = satisfaccion;}

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Información de la reserva:");
        sb.append("\nCiudad: ").append(restaurante.getCiudad().getNombre());
        sb.append("\nZona: ").append(restaurante.getZona().getNombre());
        sb.append("\nRestaurante: ").append(restaurante.getNombre());
        sb.append("\nClientes: ").append(clientes);
        sb.append("\nFecha: ").append(fecha.get(2)).append('/').append(fecha.get(1)).append('/').append(fecha.get(0));
        sb.append("\nHora:").append(fecha.get(3)).append(":00");
        sb.append("\nMesa: #").append(clientes.getFirst().getMesa().toString());
        sb.append("\nFactura: ").append(clientes.getFirst().getFactura());

        return sb.toString();
    }
}
