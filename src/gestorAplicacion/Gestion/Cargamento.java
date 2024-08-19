package gestorAplicacion.Gestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
public class Cargamento {
	//Atributos
	public static final ArrayList<String> UTILIDADES = new ArrayList<String>(Arrays.asList("Rosa", "Vela", "Globo Negro",
			"Globo Blanco", "Globo Dorado", "Globo Rosado", "Globo Azul", "Birrete", "Angel Varon", "Angel Femenino"));
	private ArrayList<Integer> proximaEntrega;
	private ArrayList<ArrayList<String>> ingredientes;
	private ArrayList<Integer> utilidades;
	private int frecuencia;
	private Restaurante restaurante;

	//Constructor
	public Cargamento() {}
	public Cargamento(ArrayList<Integer> proximaEntrega, ArrayList<ArrayList<String>> ingredientes, int frecuencia) {
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
	public ArrayList<ArrayList<String>> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(ArrayList<ArrayList<String>> ingredientes) {
		this.ingredientes = ingredientes;
	}
	public ArrayList<Integer> getUtilidades() {
		return utilidades;
	}
	public void setUtilidades(ArrayList<Integer> utilidades) {
		this.utilidades = utilidades;
	}

	public void aumentarCantidadIngrediente(ArrayList<String> cantidadNueva) {
		boolean existe = false;
		int indiceExiste = -1;
		int cantidad = 0;
		for (ArrayList<String> cantidadActual : this.ingredientes) {
			if (cantidadActual.getFirst().equals(cantidadNueva.getFirst())) {
				indiceExiste = this.ingredientes.indexOf(cantidadActual);
				existe = true;
				break;
			}
		}
		if (existe) {
			cantidad = Integer.parseInt(this.ingredientes.get(indiceExiste).get(1));
			cantidad += Integer.parseInt(cantidadNueva.get(1));
			this.ingredientes.get(indiceExiste).remove(1);
			this.ingredientes.get(indiceExiste).add(String.valueOf(cantidad));
		} else {
			this.ingredientes.add(cantidadNueva);
		}
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
