package gestorAplicacion.Gestion;

import gestorAplicacion.Usuario.Cliente;

import java.util.ArrayList;
public class Reserva{
    public ArrayList<Cliente> clientes;
    public Cliente cliente;
    //Preguntarle a Colo por esta vaina del Date
    public String fecha;

    public Reserva(Cliente cliente, String fecha){
        this.cliente = cliente;
        this.fecha = fecha;
        this.clientes = new ArrayList<>();
    }
    public Reserva(){}
    public String getFecha(){
        return fecha;
    }
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
}
