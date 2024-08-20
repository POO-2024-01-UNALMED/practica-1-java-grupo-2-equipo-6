package gestorAplicacion.Gestion;

import gestorAplicacion.Usuario.Cliente;

import java.io.Serializable;
import java.util.ArrayList;

public class Reserva implements Serializable {
    //Atributos
    private static final long serialVersionUID = 1L;
    private ArrayList<Cliente> clientes;
    private static ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    private ArrayList<Integer> fecha; //[2024, 8, 23, 16]
    private Restaurante restaurante;
    private boolean satisfaccion = false;
    private int codigoReserva;
    public static int contadorReservas;

    //Constructores
    public Reserva(){
        this.codigoReserva = contadorReservas;
        contadorReservas++;
    }
    public Reserva(ArrayList<Cliente> clientes, ArrayList<Integer> fecha){
        this.fecha = fecha;
        this.clientes = clientes;
        this.codigoReserva = contadorReservas;
        contadorReservas++;
    }

    //Metodos
    public int getCodigoReserva() {
        return codigoReserva;
    }
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
    public static ArrayList<Reserva> getReservas() {return reservas;}
    public static void setReservas(ArrayList<Reserva> reservas) {Reserva.reservas = reservas;}

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Información de la reserva:");
        sb.append("\nCiudad: ").append(restaurante.getCiudad().getNombre());
        sb.append("\nZona: ").append(restaurante.getZona().getNombre());
        sb.append("\nRestaurante: ").append(restaurante.getNombre());
        sb.append("\nClientes: ").append(clientes);
        sb.append("\nFecha: ").append(fecha.get(2)).append('/').append(fecha.get(1)).append('/').append(fecha.get(0));
        sb.append("\nHora: ").append(fecha.get(3)).append(":00");
        sb.append("\nMesa: #").append(clientes.getFirst().getMesa().toString());
        sb.append("\nFactura: ").append(clientes.getFirst().getFactura());
        return sb.toString();
    }
}
