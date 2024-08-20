package gestorAplicacion.Gestion;
import gestorAplicacion.Usuario.Cliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;
    private static ArrayList<Evento> eventos = new ArrayList<Evento>();
    private String nombre;
    private String descripcion;
    private String tipoEvento;
    private String nombreMotivo;
    int coste;
    Date fecha;
    Cliente clienteEvento;
    ArrayList<Plato> platos;

    public Evento(String nombre){
        this.nombre = nombre;
        eventos.add(this);
    }
    public Evento(String nombreEvento, int coste, ArrayList<Plato> platos){
        this.coste = coste;
        this.nombre = nombreEvento;
        this.platos = platos;
        eventos.add(this);
    }
    public Evento(String nombreEvento, int coste, ArrayList<Plato> platos, String tipoEvento){
        this(nombreEvento,coste, platos);
        this.tipoEvento = tipoEvento;
        eventos.add(this);
    }

    Evento(Cliente clienteEvento, Date fecha){
        this.clienteEvento = clienteEvento;
        this.fecha = fecha;
        eventos.add(this);
    }
    //UN metodo para mostrar los platos

    public Evento() {
        eventos.add(this);
    }

    // Evento.getEventos().add(new Evento())

    public static ArrayList<Evento> getEventos() {
        return eventos;
    }
    public static void setEventos(ArrayList<Evento> eventos) {
        Evento.eventos = eventos;
    }
    public void setNombreEvento(String nombreEvento){
        this.nombre = nombreEvento;
    }
    public void setCoste(int coste){
        this.coste = coste;
    }
    public void setNombreMotivo(String nombreMotivo){
        this.nombreMotivo = nombre;
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
    public String getNombre(){
        return nombre;
    }

    public int getCoste() {
        return coste;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }
}
