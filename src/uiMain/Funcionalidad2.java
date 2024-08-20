package uiMain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import gestorAplicacion.Entorno.Ciudad;
import gestorAplicacion.Entorno.Mesa;
import gestorAplicacion.Entorno.Zona;
import gestorAplicacion.Gestion.*;
import gestorAplicacion.Usuario.Cliente;
import gestorAplicacion.Usuario.Trabajador;
import jdk.jshell.execution.Util;

import static uiMain.Main.menuPrincipal;

public class Funcionalidad2 implements Utilidad{


	private static ArrayList<Pedido> hacerPedido(ArrayList<Cliente> clientes, Pedido pedido) {
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		for (Cliente cliente : clientes) {
			Pedido pedidoCliente = new Pedido();
			boolean encendido2;
			do {
				System.out.println("Seleccione una opción:\n1. Entradas.\n2. Platos Fuertes.\n3. Bebidas.\n4. " +"Postres.\n5. Menú Infantil.\n6. Todos.\n7. Terminar.");

				int opcion = Utilidad.readInt();
				encendido2 = true;
				switch (opcion) {
					case 1:
						Utilidad.limpiarPantalla();
						pedido = platosMenu("Entrada", cliente);
						if (!pedido.getPlatos().isEmpty()) {
							pedidoCliente.getPlatos().addAll(pedido.getPlatos());
						}
						break;
					case 2:
						Utilidad.limpiarPantalla();
						pedido = platosMenu("Plato fuerte", cliente);
						if (!pedido.getPlatos().isEmpty()) {
							pedidoCliente.getPlatos().addAll(pedido.getPlatos());
						}
						break;
					case 3:
						Utilidad.limpiarPantalla();
						pedido = platosMenu("Bebida", cliente);
						if (!pedido.getPlatos().isEmpty()) {
							pedidoCliente.getPlatos().addAll(pedido.getPlatos());
						}
						break;
					case 4:
						Utilidad.limpiarPantalla();
						pedido = platosMenu("Postre", cliente);
						if (!pedido.getPlatos().isEmpty()) {
							pedidoCliente.getPlatos().addAll(pedido.getPlatos());
						}
						break;
					case 5:
						Utilidad.limpiarPantalla();
						pedido = platosMenu("Infantil", cliente);
						if (!pedido.getPlatos().isEmpty()) {
							pedidoCliente.getPlatos().addAll(pedido.getPlatos());
						}
						break;
					case 6:
						Utilidad.limpiarPantalla();
						pedido = platosMenu("Ninguno", cliente);
						if (!pedido.getPlatos().isEmpty()) {
							pedidoCliente.getPlatos().addAll(pedido.getPlatos());
						}
						break;
					default:
						if (pedidoCliente.getPlatos().isEmpty()) {
							System.out.println("Ingrese un valor válido [1 - 6]");
						} else{
							System.out.println("Fin pedido");
							encendido2 = false;
						}
				}
			} while (encendido2);
			pedidos.add(pedidoCliente);
			cliente.setPedido(pedidoCliente);
		}
		return pedidos;
	}

	// INTERACCION 3
	public static ArrayList<Factura> asignarFactura(ArrayList<Pedido> pedidos) {

		Trabajador mesero = pedidos.getFirst().getMesero();
		Mesa mesa = mesero.getMesa();

		for (int i = 0; i < pedidos.size(); i++) {
			int valorFactura = 0;
			Factura factura = new Factura(pedidos.get(i), valorFactura);
			mesa.getFacturas().add(factura);
			mesa.getClientes().get(i).setFactura(factura);

			for (Plato plato : pedidos.get(i).getPlatos()) {
				factura.aumentarValor(plato.getPrecio());
			}

			System.out.println(factura);
		}

		mesero.aumentarGananciasExtra(5000);

		Utilidad.limpiarPantalla();

		return mesa.getFacturas();
	}
}
