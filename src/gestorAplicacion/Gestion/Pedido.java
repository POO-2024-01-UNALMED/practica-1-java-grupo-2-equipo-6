package gestorAplicacion.Gestion;
import java.io.Serializable;
import java.util.ArrayList;

public class Pedido implements Serializable {
    private static ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    private ArrayList<Plato> platos = new ArrayList<Plato>();

    public Pedido(){};

    public void agregarPlato(Plato plato){
        platos.add(plato);
    }

    public void agregarPlato(ArrayList<Plato> platos) {
    	ArrayList <Plato> listaPlatos = platos;
    	
    	for (Plato plato: listaPlatos) {
    		this.agregarPlato(plato);
    	}
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


    
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("productos\n");
        
        for (Plato p: platos){
           sb.append(p.getNombre() + "   $ " + p.getPrecio()+ "\n") ;
        }
        
        return sb.toString();
    }
}
