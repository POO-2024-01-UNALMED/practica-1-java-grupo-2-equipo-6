package gestorAplicacion.Gestion;
import gestorAplicacion.Usuario.Cliente;

import java.util.ArrayList;
import java.util.Date;
public class Evento {
    private static ArrayList<Evento> eventos = new ArrayList<Evento>();
    private String nombreEvento;
    private String descripcion;
    private String nombreMotivo;
    int coste;
    Date fecha;
    Cliente clienteEvento;
    ArrayList<Plato> platos;

    Evento(String nombreEvento, String descripcion, int coste, Date fecha){
        this.coste = coste;
        this.nombreEvento = nombreEvento;
        this.descripcion = descripcion;
        this.fecha = fecha;

    }
    public Evento(String nombreEvento, int coste, ArrayList<Plato> platos){
        this.coste = coste;
        this.nombreEvento = nombreEvento;
        this.platos = platos;

    }

    Evento(Cliente clienteEvento, Date fecha){
        this.clienteEvento = clienteEvento;
        this.fecha = fecha;
    }
    //UN metodo para mostrar los platos

    public Evento() {

    }
    public String getNombreMotivo(){
        return nombreMotivo;
    }
    public void setNombreEvento(String nombreEvento){
        this.nombreEvento = nombreEvento;
    }
    public void setCoste(int coste){
        this.coste = coste;
    }
    public void setNombreMotivo(String nombreMotivo){
        this.nombreMotivo = nombreEvento;
    }
    public void setPlatos(ArrayList<Plato> platos){
        this.platos = platos;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public ArrayList<Plato> getPlatos(){
        return platos;
    }

    public void adicionarPlato(Plato plato){
        platos.add(plato);
    }
    public String getNombreEvento(){
        return nombreEvento;
    }
}
