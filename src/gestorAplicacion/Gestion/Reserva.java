package gestorAplicacion.Gestion;

import gestorAplicacion.Usuario.Cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Reserva implements Serializable {
    public ArrayList<Cliente> clientes;
    //Preguntarle a Colo por esta vaina del Date
    public ArrayList<Integer> fecha;

    public Reserva(ArrayList<Cliente> clientes, ArrayList<Integer> fecha){
        this.fecha = fecha;
        this.clientes = clientes;
    }
    public Reserva(){}
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Reserva{");
        sb.append("clientes=").append(clientes);
        sb.append(", fecha=").append(fecha);
        sb.append('}');
        return sb.toString();
    }
}
