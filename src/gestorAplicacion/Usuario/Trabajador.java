package gestorAplicacion.Usuario;

import gestorAplicacion.Gestion.Cargamento;
import gestorAplicacion.Gestion.Evento;
import gestorAplicacion.Gestion.Factura;
import gestorAplicacion.Gestion.Ingrediente;
import gestorAplicacion.Gestion.Pedido;
import gestorAplicacion.Gestion.Plato;
import gestorAplicacion.Gestion.Restaurante;
import uiMain.Main;

import java.io.Serializable;
import java.util.ArrayList;

public class Trabajador extends Persona implements Serializable {
    static ArrayList<Trabajador> cocineros = new ArrayList<Trabajador>();
    private static ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();
    private String especialidad;
    private int salario;
    private boolean ocupado;
    private float calificacion;
    private ArrayList<String> reseñas = new ArrayList<String>();
    private Restaurante restaurante;

    public Trabajador() {
    }

    public Trabajador(String nombre, int cedula, String especialidad, int salario) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.especialidad = especialidad;
        this.salario = salario;
        this.ocupado = false;
        this.calificacion = 0;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Cedula: " + cedula);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Salario: " + salario);
    }

    @Override
    public String getNombre() {
        return nombre;
    }
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public int getCedula() {
        return cedula;
    }
    @Override
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    public boolean getOcupado() {
        return ocupado;
    }
    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }
    public float getCalificacion() {
        return calificacion;
    }
    public void addReseña(String reseña) {
        reseñas.add(reseña);
    }
    public ArrayList<String> getReseñas() {
        return reseñas;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public int getSalario() {
        return salario;
    }
    public void setSalario(int salario) {
        this.salario = salario;
    }
    public static ArrayList<Trabajador> getCocineros() {
        return cocineros;
    }
    public static void setCocineros(ArrayList<Trabajador> cocineros) {
        Trabajador.cocineros = cocineros;
    }

    public void PagoExtraServicio(ArrayList<Evento> eventos, String especialidad) {
        for (Evento evento : eventos) {
            if (evento.getNombre().equals(getEspecialidad())) {
                this.salario += 40000;
            }
        }
    }
}
//public void actualizarGanancia(Factura facturaGanancia) {
//
//
//
////    	Restaurante.ganancias(facturaGanancia.getPropina() + facturaGanancia.getValor()) ;
//    }
//public void llevar(ArrayList<Plato> platoListos, Cliente cliente) {
//
//		System.out.println(cliente);
//
//		Pedido pedido = new Pedido();
//		for (Plato plato: platoListos) {
//			pedido.agregarPlato(plato);
//		}
//		cliente.setPedido(pedido);
////		cliente.getMesa().setPedido(pedido);
//
//	}
//
//
//public Plato cocinar(Plato plato) {
//
////    HashMap <Ingrediente, Double> ingredientesPlato = plato.getIngredientes();
//    ArrayList <Ingrediente> ingredientes  = new ArrayList <Ingrediente>();
//	ArrayList<Plato> platoListos = new ArrayList<Plato>();
//
//
//
//
//    System.out.println("Se esta realizando su pedido... ");
//
//
//
//
//    for (Map.Entry<Ingrediente, Double> ingrediente : ingredientesPlato.entrySet()) {
//
//
// 		if (ingrediente.getKey().existencia() >=  ingrediente.getValue() ) {
// 			ingrediente.getKey().reducirInventario(ingrediente.getValue() );
// 			ingredientes.add(ingrediente.getKey());}
//
// 		else {
// 				System.out.println(plato.getNombre()+" ❌");
// 				System.out.println("No hay suficiente inventario para preparar " + plato.getNombre() );
// 				System.out.println("Ingrediente necesario "+ingrediente.getKey() + " " + ingrediente.getValue() + " Inventario : " + ingrediente.getKey().getInventario() );
// 				System.out.println("Desea agregar el ingrediente necesario para el siguiente plato.\n1. Sí [s]\n2. No [n] ");
// 				char opcion = readChar();
// 				if (opcion == 's' || opcion == 'S' ) {
// 					Cargamento.agregarPedido(ingrediente.getKey(), ingrediente.getValue() * 2);
// 					}
// 			}
// 		}
//
//
//    if (ingredientesPlato.size() == ingredientes.size()) {
//    	platoListos.add(plato);
//    }
//
//
//   if (platoListos.isEmpty()) {
//	   	return null;
//   } else {
//	   return platoListos.getFirst();}
//    }
//
//
//public int valorFactura(Factura factura) {
//
//	int valor = factura.calcularValor();
//
//
//	return valor;
//}
//	}
//
//
//
//
