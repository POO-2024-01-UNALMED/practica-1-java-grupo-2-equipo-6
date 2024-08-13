package gestorAplicacion.Gestion;

import gestorAplicacion.Usuario.Cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Reserva implements Serializable {
    public ArrayList<Cliente> clientes;
    //Preguntarle a Colo por esta vaina del Date
    public Date fecha;

    public Reserva(ArrayList<Cliente> clientes, Date fecha){
        this.fecha = fecha;
        this.clientes = new ArrayList<>();
    }
    public Reserva(){}
    public Date getFecha(){
        return fecha;
    }
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
}
