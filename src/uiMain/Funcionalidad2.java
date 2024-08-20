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
	public static void ordenarComida() {
		boolean encendido1 = true;
		do {
			System.out.println("""
                    ¿Desea ordenar comida?
                    1. Sí.
                    2. No.
                    Escriba un número para elegir su opción.""");
			int eleccion1 = Utilidad.readInt();
			switch (eleccion1) {
				case 1:
					Utilidad.limpiarPantalla();
					System.out.println("Ciudades:");
					Utilidad.listadoCiudades();
					System.out.println("Escriba un número para elegir la ciudad.\nEn caso de no encontrar la ciudad " +
							"requerida escriba 0.");
					int eleccion2 = Utilidad.readInt();
					if (eleccion2 > Ciudad.getCiudades().size() || eleccion2 < 0) {
						System.out.println("Ingrese un número válido [1 - " + Ciudad.getCiudades().size() + "].");
					} else {
						Utilidad.limpiarPantalla();
						if (!(eleccion2 == 0)) { //Si se encuentra la ciudad
							Ciudad ciudad = Ciudad.getCiudades().get(eleccion2 - 1);
							if (ciudad.getRestaurantes().isEmpty()) { //Si la ciudad no tiene restaurantes
								System.out.println("Esta ciudad no tiene restaurantes.");
								ordenarComida();
							} else { //Si la ciudad tiene zonas
								boolean encendido2 = true;
								do {
									Utilidad.limpiarPantalla();
									System.out.println("Zonas de " + ciudad.getNombre() + ":");
									ArrayList<Zona> zonasConRestaurante = Utilidad.listadoZonasConRestauranteCiudad(ciudad);
									System.out.println("Escriba un número para elegir la zona.");
									int eleccion3 = Utilidad.readInt();
									if (eleccion3 > zonasConRestaurante.size() || eleccion3 < 1) { //Si no se encuentra la zona
										System.out.println("Ingrese un número válido [1 - " +
												zonasConRestaurante.size() + "].");
									} else { //Si se encuentra la zona
										Utilidad.limpiarPantalla();
										Zona zona = zonasConRestaurante.get(eleccion3 - 1);
										boolean encendido3 = true;
										do {
											Utilidad.limpiarPantalla();
											System.out.println("Restaurantes de " + zona.getNombre() + ":");
											Utilidad.listadoRestaurantesZona(zona);
											System.out.println("Escriba un número para elegir el " +
													"restaurante.");
											int eleccion4 = Utilidad.readInt();
											if (eleccion4 > zona.getRestaurantes().size() || eleccion4 < 1) { //Si no se encuentra el restaurante
												System.out.println("Ingrese un número válido [1 - " +
														zona.getRestaurantes().size() + "].");
											} else { //Si se encuentra el restaurante
												//Interacción #1
												ArrayList<Cliente> clientes = establecerCliente(zona.getRestaurantes().get(eleccion4 - 1));
												ArrayList<Pedido> pedidos = hacerComida(clientes);
												asignarFactura(pedidos);
												encendido3 = false;
											}
										} while (encendido3);
										encendido2 = false;
									}
								} while (encendido2);
							}
						} else { //Si no se encuentra la ciudad
							System.out.println("Lo sentimos, pero estas son las únicas ciudades donde tenemos " +
									"restaurantes de nuestra cadena.");
							System.out.println("""
                                    ¿Desea elegir otra ciudad?
                                    1. Sí.
                                    2. No.
                                    Escriba un número para elegir su opción.""");
							int eleccion4 = Utilidad.readInt();
							if (eleccion4 == 1) {
								ordenarComida();
							} else {
								menuPrincipal();
							}
						}
						encendido1 = false;
					}
					break;
				case 2:
					Utilidad.limpiarPantalla();
					menuPrincipal();
					encendido1 = false;
					break;
				default:
					Utilidad.limpiarPantalla();
					System.out.println("Ingrese un número válido [1 - 2].");
					break;
			}
		} while (encendido1);
	}

	//Interaccion 1
	public static ArrayList<Cliente> establecerCliente(Restaurante restaurante) {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		System.out.println("Ingrese el número de cédula de la persona que desea ordenar:");
		int cedula = Utilidad.readInt();
		Cliente cliente = new Cliente(cedula);

		boolean existeCliente = Utilidad.existeCliente(cliente);

		if (existeCliente){
			Cliente nuevoCliente = Utilidad.clienteCedula(cliente);
			System.out.println(nuevoCliente);
			if (nuevoCliente == cliente) { //Si el cliente no tiene reserva
                System.out.println("El cliente con cédula " + cedula + " no está registrado en el restaurante indicado.");
                System.out.println("Para continuar tendrá que brindarnos algunos datos adicionales.");
                System.out.println("Ingrese el nombre del cliente:");
                String nombre = Utilidad.capitalize(Utilidad.readString());
                cliente.setNombre(nombre);
//                ArrayList<Cliente> clientes = new ArrayList<Cliente>();
                clientes.add(cliente);
                restaurante.getClientes().add(cliente);
                cliente.setRestaurante(restaurante);
                Mesa mesa = new Mesa();
                for (Mesa mesaRestaurante : restaurante.getMesas()) {
                    if (mesaRestaurante.getClientes().isEmpty()) {
                        cliente.setMesa(mesaRestaurante);
                        mesaRestaurante.setClientes(new ArrayList<Cliente>(Arrays.asList(cliente)));
                        mesa = mesaRestaurante;
                    }
                }
                clientes = mesa.getClientes();

            } else {//Si el cliente tiene reserva
				boolean encendido1 = true;
				Mesa mesa = new Mesa();
				do {
					System.out.println("Ingrese el código de reserva:");
					int codigoReserva = Utilidad.readInt();
					for (Reserva reserva : restaurante.getHistorialReservas()) {
						if (reserva.getCodigoReserva() == codigoReserva) {
							nuevoCliente.setReserva(reserva);
							clientes.add(nuevoCliente);
							mesa = nuevoCliente.getMesa();
							mesa.setClientes(clientes);
							System.out.println("Por favor diríjase a la mesa " + mesa.getNumMesa() + ".");
							encendido1 = false;
							break;
						}
					}
					if (encendido1 == false) {
						continue;
					} else {
						System.out.println("El código de reserva ingresado no es válido.");
						System.out.println("Por favor, ingrese un código de reserva válido.");
					}
				} while (encendido1);
//				ArrayList<Cliente> clientes = new ArrayList<Cliente>();
				clientes = mesa.getClientes();
			}
		} else {
			Mesa mesa = new Mesa();
			System.out.println("El cliente con cédula " + cedula + " no está registrado en ningún restaurante.");
			System.out.println("Para continuar tendrá que brindarnos algunos datos adicionales.");
			System.out.println("Ingrese el nombre del cliente:");
			String nombre = Utilidad.capitalize(Utilidad.readString());
			cliente.setNombre(nombre);
			clientes.add(cliente);
			Cliente.getClientes().add(cliente);
			restaurante.getClientes().add(cliente);
			cliente.setRestaurante(restaurante);
			for (Mesa mesaRestaurante : restaurante.getMesas()) {
				if (mesaRestaurante.getClientes().isEmpty()) {
					cliente.setMesa(mesaRestaurante);
					mesaRestaurante.setClientes(new ArrayList<Cliente>(Arrays.asList(cliente)));
					mesa = mesaRestaurante;
				}
			}
//			ArrayList<Cliente> clientes = new ArrayList<Cliente>();
            clientes = mesa.getClientes();
		}
		System.out.println(clientes.size());
		return clientes;
	}

	//Interaccion 2
	public static ArrayList<Pedido> hacerComida(ArrayList<Cliente> clientes) {
		Utilidad.limpiarPantalla();

		ArrayList<Trabajador> trabajadores = clientes.getFirst().getRestaurante().getTrabajadores(); //Tostao

		// Buscar Trabajador especialidad Cocinero, especialidad Mesero
		Trabajador cocinero = new Trabajador();
		Trabajador mesero = new Trabajador();

		for (Trabajador trabajador : trabajadores) {
			if (trabajador.getTipo() == Trabajador.Tipo.COCINERO) {
				cocinero = trabajador;
			}
			if (trabajador.getTipo() == Trabajador.Tipo.MESERO) {
				mesero = trabajador;
			}
		}

		mesero.setMesa(clientes.getFirst().getMesa());
		clientes.getFirst().getMesa().setMesero(mesero);

		Pedido pedidoDummy = new Pedido();

		ArrayList<Pedido> pedidos = hacerPedido(mesero.getMesa().getClientes(), pedidoDummy);

		for (Pedido pedido : pedidos) {
			pedido.setMesero(mesero);

			pedido.setRestaurante(clientes.getFirst().getRestaurante());

			ArrayList<Plato> platosCocinados = cocinero.cocinar(pedido);

			if (platosCocinados.size() != pedido.getPlatos().size()) {
				System.out.println("Algun(os) plato(s) del pedido no ha(n) podido ser cocinado(s) debido a la falta de " +
						"ingredientes");
				System.out.println("Se le descontará de la factura.");
				pedido.setPlatos(platosCocinados);
			}
		}

		return pedidos;
	}

	public static Pedido platosMenu(String tipo, Cliente cliente) {
		ArrayList<Plato> platos = new ArrayList<Plato>();
		Pedido pedido = new Pedido();
		switch (tipo) {
			case "Entrada":
				System.out.println("Entradas Disponibles\n");
				for (Plato plato : cliente.getRestaurante().getMenu()) {
					if (plato.getTipo().equals("Entrada")) {
						platos.add(plato);
					}
				}
			case "Plato fuerte":
				System.out.println("Plato fuertes Disponibles\n");
				for (Plato plato : cliente.getRestaurante().getMenu()) {
					if (plato.getTipo().equals("Plato Fuerte")) {
						platos.add(plato);
					}
				}
				break;

			case "Bebida":
				System.out.println("Bebidas Disponibles\n");
				for (Plato plato : cliente.getRestaurante().getMenu()) {
					if (plato.getTipo().equals("Bebida")) {
						platos.add(plato);
					}
				}
				break;
			case "Postre":
				System.out.println("Postres Disponibles\n");
				for (Plato plato : cliente.getRestaurante().getMenu()) {
					if (plato.getTipo().equals("Postre")) {
						platos.add(plato);
					}
				}
				break;
			case "Infantil":
				System.out.println("Menú infantil\n");
				for (Plato plato : cliente.getRestaurante().getMenu()) {
					if (plato.getTipo().equals("Infantil")) {
						platos.add(plato);
					}
				}
				break;
			case "Ninguno":
				System.out.println("Menú General\n");
				for (Plato plato : cliente.getRestaurante().getMenu()) {
					platos.add(plato);
				}
		}
		for (Plato plato : cliente.getPlatosFavoritos()){
			if (cliente.getRestaurante().getMenu().contains(plato)){
				platos.add(plato);
			}
		}
		if (platos.isEmpty()) {
			System.out.println("No contamos con platos de este tipo por el momento.");
		} else {
			for (Plato plato : platos) {
				System.out.println((platos.indexOf(plato) + 1) +". " +  plato);
			}

			System.out.println("Ingrese el número del plato que desea.");
			int numPlato = Utilidad.readInt();
			System.out.println("Ingrese la cantidad deseada (1, 2...)");
			int cantidad = Utilidad.readInt();

			for (int i = 1; i < cantidad; i++){
				Plato platoPedido = platos.get(numPlato - 1);
				platoPedido.aumentarVecesPedido();
				pedido.agregarPlato(platoPedido);
				System.out.print("Su Pedido hasta ahora\n" + pedido + "\n");
			}
		}
		return pedido;
	}

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
