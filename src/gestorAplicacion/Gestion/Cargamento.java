package gestorAplicacion.Gestion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Cargamento implements Serializable {
	//Atributos
	private static final long serialVersionUID = 1L;
	private static ArrayList<Cargamento> cargamentos = new ArrayList<Cargamento>();
	public static final ArrayList<String> UTILIDADES = new ArrayList<String>(Arrays.asList("Rosa", "Vela", "Globo Negro",
			"Globo Blanco", "Globo Dorado", "Globo Rosado", "Globo Azul", "Birrete", "Angel Varon", "Angel Femenino"));
	private ArrayList<Integer> proximaEntrega;
	private ArrayList<ArrayList<String>> ingredientes = new ArrayList<ArrayList<String>>();
	private ArrayList<Integer> utilidades = new ArrayList<Integer>();
	private int frecuencia;
	private Restaurante restaurante;

	//Constructor
	public Cargamento() {
		cargamentos.add(this);
	}
	public Cargamento(ArrayList<Integer> proximaEntrega, ArrayList<ArrayList<String>> ingredientes, int frecuencia) {
		this.ingredientes = ingredientes;
		this.frecuencia = frecuencia;
		cargamentos.add(this);
	}

	//Metodos

	public void setProximaEntrega(ArrayList<Integer> proximaEntrega) {
		this.proximaEntrega = proximaEntrega;
	}

	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}
	public ArrayList<ArrayList<String>> getIngredientes() {
		return ingredientes;
	}

	public ArrayList<Integer> getUtilidades() {
		return utilidades;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
	public static ArrayList<Cargamento> getCargamentos() {
		return cargamentos;
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
}
