package gestorAplicacion.Gestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
public class Cargamento {
	//Atributos
	private static final ArrayList<String> UTILIDADES = new ArrayList<String>(Arrays.asList("Rosa", "Vela", "Globo Negro",
			"Globo Blanco", "Globo Dorado", "Globo Rosado", "Globo Azul", "Birrete", "Angel Varon", "Angel Femenino"));
	private ArrayList<Integer> proximaEntrega;
	private ArrayList<Ingrediente> ingredientes;
	private ArrayList<String> utilidades;
	private int frecuencia;
	private Restaurante restaurante;

	//Constructor
	public Cargamento(ArrayList<Integer> proximaEntrega, ArrayList<Ingrediente> ingredientes, int frecuencia) {
		this.ingredientes = ingredientes;
		this.frecuencia = frecuencia;
	}

	//Metodos
	public ArrayList<Integer> getProximaEntrega() {
		return proximaEntrega;
	}
	public void setProximaEntrega(ArrayList<Integer> proximaEntrega) {
		this.proximaEntrega = proximaEntrega;
	}
	public int getFrecuencia() {
		return frecuencia;
	}
	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}
	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	public ArrayList<String> getUtilidades() {
		return utilidades;
	}
	public void setUtilidades(ArrayList<String> utilidades) {
		this.utilidades = utilidades;
	}

	//	public static HashMap<Ingrediente, Double> ingredientes = new HashMap<>();
//
//    public static void agregarPedido(Ingrediente ingrediente, double d) {
//
//    	if (ingredientes.containsKey(ingrediente)){
//    		System.out.print("Ya se ha realizado con pedido");
//    		}
//
//    	else {
//    		ingredientes.put(ingrediente, (double) d);
//    	}
//
//    }

}
