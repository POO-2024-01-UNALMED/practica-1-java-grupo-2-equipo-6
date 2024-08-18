package gestorAplicacion.Gestion;
import gestorAplicacion.Usuario.Cliente;

import java.util.ArrayList;
import java.util.Date;
public class Evento {
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
    }
    public Evento(String nombreEvento, String descripcion, int coste, Date fecha){
        this.coste = coste;
        this.nombre = nombreEvento;
        this.descripcion = descripcion;
        this.fecha = fecha;

    }
    public Evento(String nombreEvento, int coste, ArrayList<Plato> platos){
        this.coste = coste;
        this.nombre = nombreEvento;
        this.platos = platos;

    }
    public Evento(String nombreEvento, int coste, ArrayList<Plato> platos, String tipoEvento){
        this(nombreEvento,coste, platos);
        this.tipoEvento = tipoEvento;
    }

    Evento(Cliente clienteEvento, Date fecha){
        this.clienteEvento = clienteEvento;
        this.fecha = fecha;
    }
    //UN metodo para mostrar los platos

    public Evento() {

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
