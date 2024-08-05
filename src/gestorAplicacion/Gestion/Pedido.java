package gestorAplicacion.Gestion;
import java.util.ArrayList;

public class Pedido {
    private ArrayList<Plato> platos = new ArrayList<Plato>();

    public Pedido(){};

    public void agregarPlato(Plato plato){
        platos.add(plato);
    }

    public void eliminarPlato(Plato plato){
        platos.remove(plato);
    }

    public ArrayList<Plato> getPlatos(){
        return platos;
    }

    public void setPlatos(ArrayList<Plato> platos){
        this.platos = platos;
    }
}
