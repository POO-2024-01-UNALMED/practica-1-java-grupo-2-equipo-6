package gestorAplicacion.Gestion;

import java.util.HashMap;
public class Cargamento {

	public static HashMap<Ingrediente, Double> ingredientes = new HashMap<>();
    
    public static void agregarPedido(Ingrediente ingrediente, double d) {
    	
    	if (ingredientes.containsKey(ingrediente)){
    		System.out.print("Ya se ha realizado con pedido");
    		}
    	
    	else {
    		ingredientes.put(ingrediente, (double) d);
    	}
    
    }

}
