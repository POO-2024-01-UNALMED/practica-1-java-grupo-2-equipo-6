package gestorAplicacion.Gestion;
import gestorAplicacion.Usuario.Cliente;
import gestorAplicacion.Usuario.Trabajador;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedido implements Serializable {
    private static ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    private ArrayList<Plato> platos = new ArrayList<Plato>();
    private Cliente cliente;
    private Restaurante restaurante;
    private Trabajador mesero;

    public Pedido(){
        pedidos.add(this);
    };

    public Pedido(Cliente cliente, Restaurante restaurante) {
        this.cliente = cliente;
        this.restaurante = restaurante;
        pedidos.add(this);
    }

    public Pedido(Cliente cliente, Restaurante restaurante, Trabajador mesero) {
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.mesero = mesero;
        pedidos.add(this);
    }

    public void agregarPlato(Plato plato){
        platos.add(plato);
    }

    public void agregarPlato(ArrayList<Plato> platos) {
    	ArrayList <Plato> listaPlatos = platos;
    	
    	for (Plato plato: listaPlatos) {
    		this.agregarPlato(plato);
    	}
    }

    public ArrayList<Plato> getPlatos(){
        return platos;
    }

    public void setPlatos(ArrayList<Plato> platos){
        this.platos = platos;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("productos\n");
        
        for (Plato p: platos){
           sb.append(p.getNombre() + "   $ " + p.getPrecio()+ "\n") ;
        }
        
        return sb.toString();
    }

    public static ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
    public Restaurante getRestaurante() {
        return restaurante;
    }
    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
    public Trabajador getMesero() {
    	return mesero;
    }
    public void setMesero(Trabajador mesero) {
    	this.mesero = mesero;
    }
}
