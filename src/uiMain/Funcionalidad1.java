package uiMain;

import gestorAplicacion.Entorno.Ciudad;
import gestorAplicacion.Entorno.Zona;
import gestorAplicacion.Gestion.Factura;
import gestorAplicacion.Entorno.Mesa;
import gestorAplicacion.Gestion.Pedido;
import gestorAplicacion.Gestion.Reserva;
import gestorAplicacion.Gestion.Restaurante;
import gestorAplicacion.Usuario.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static uiMain.Main.menuPrincipal;

//Desarrollada por Juan José Arango y Samuel Colorado. Y STIVEN NO.
public class Funcionalidad1 implements Utilidad{



    // Interacción 2
    public static Restaurante extrasReserva(Cliente cliente){
        Restaurante restaurante = cliente.getRestaurante();
        System.out.println("Desde la cadena de restaurantes ofrecemos los servicios de reserva de parqueadero y " +
                "decoraciones para la mesa. Elija un servicio en caso de necesitarlo:");
        System.out.println("""
                1. Reserva de Parqueadero.
                2. Decoraciones para la mesa.
                3. No desea ningún servicio extra.""");
        int eleccion = Utilidad.readInt();
        switch (eleccion) {
            case 1:
                System.out.println("Reserva de Parqueadero");
                String placa = "";
                int cargoExtra1 = 0;
                if (cliente.getAfiliacion() == Cliente.Afiliacion.NINGUNA){
                    System.out.println("El servicio tiene un coste de $10.000. ¿Desea reservar el parqueadero?");
                    System.out.println("""
                            1. Sí.
                            2. No.""");
                    int eleccion2 = Utilidad.readInt();
                    if (eleccion2 == 1){
                        cargoExtra1 = 10000;
                        int indiceCelda = restaurante.getParqueadero().indexOf(false);
                        System.out.println("Su celda de parqueo es la número: #" + (indiceCelda + 1));
                        if (cliente.getPlacaVehiculo().equals("Ninguna")){
                            System.out.println("Ingrese la placa del vehículo:");
                            placa = Utilidad.readString();
                            cliente.setPlacaVehiculo(placa);
                        } else {
                            placa = cliente.getPlacaVehiculo();
                        }
                        System.out.println("Parqueadero reservado con éxito para el vehículo con placa: " + placa + ".");
                    } else {
                        extrasReserva(cliente);
                    }
                } else {
                    if (cliente.getPlacaVehiculo().equals("Ninguna")){
                        System.out.println("Ingrese la placa del vehículo:");
                        placa = Utilidad.readString();
                        cliente.setPlacaVehiculo(placa);
                    } else {
                        placa = cliente.getPlacaVehiculo();
                    }
                    for (int i = 0; i < restaurante.getParqueadero().size(); i++) {
                        if (!restaurante.getParqueadero().get(i)) {
                            System.out.println("Parqueadero reservado con éxito para el vehículo con placa: " +
                                    placa + ".");
                            break;
                        }
                    }
                    System.out.println("Parqueadero reservado con éxito.");
                }
                cliente.getFactura().aumentarValor(cargoExtra1);
                break;
            case 2:
                System.out.println("Decoraciones para la mesa");
                if (cliente.getAfiliacion() != Cliente.Afiliacion.NINGUNA) {
                    System.out.println("Obtuvo un 15% de descuento en las decoraciones para mesa. El costo es de $42.500");
                } else {
                    System.out.println("El costo de las decoraciones es de $50.000");
                }
                System.out.println("¿Desea decorar la mesa?");
                System.out.println("""
                        1. Sí.
                        2. No.""");
                int eleccion3 = Utilidad.readInt();
                if (eleccion3 == 1) {
                    boolean encendido1 = false;
                    do {
                        int cargoExtra2 = 0;
                        System.out.println("""
                                Disponemos de los siguientes paquetes de decoración:
                                1. Cena romántica (30000$).
                                2. Graduación (1200$ + 5000$ por cada comensal).
                                3. Descubrimiento (1200$ + 6000$ por cada comensal).""");
                        int eleccion4 = Utilidad.readInt();
                        switch (eleccion4) {
                            case 1:
                                restaurante.restarDeBodega(Utilidad.indiceBodegaItems("rosa", restaurante), 1);
                                restaurante.restarDeBodega(Utilidad.indiceBodegaItems("vela", restaurante), 3);
                                restaurante.restarDeBodegaIngrediente(Utilidad.indiceBodegaIngredientes("vino blanco", restaurante), 1);
                                cargoExtra2 = 30000;
                                break;
                            case 2:

                                restaurante.restarDeBodega(Utilidad.indiceBodegaItems("globo negro", restaurante), 3);
                                restaurante.restarDeBodega(Utilidad.indiceBodegaItems("globo dorado", restaurante), 3);
                                restaurante.restarDeBodega(Utilidad.indiceBodegaItems("birrete", restaurante),
                                        cliente.getMesa().getClientes().size());
                                int cargoBirretes = 5000 * cliente.getMesa().getClientes().size();
                                cargoExtra2 = 1200 + cargoBirretes;
                                break;
                            case 3:
                                System.out.println("Seleccione el género del bebé:\n1. Niño.\n2. Niña.");
                                int eleccion5 = Utilidad.readInt();
                                if (eleccion5 == 1) {
                                    restaurante.restarDeBodega(Utilidad.indiceBodegaItems("globo azul", restaurante), 3);
                                    restaurante.restarDeBodega(Utilidad.indiceBodegaItems("globo blanco", restaurante), 3);
                                    restaurante.restarDeBodega(Utilidad.indiceBodegaItems("angel varon", restaurante),
                                            cliente.getMesa().getClientes().size());
                                } else {
                                    restaurante.restarDeBodega(Utilidad.indiceBodegaItems("globo rosado", restaurante), 3);
                                    restaurante.restarDeBodega(Utilidad.indiceBodegaItems("globo blanco", restaurante), 3);
                                    restaurante.restarDeBodega(Utilidad.indiceBodegaItems("angel femenino", restaurante),
                                            cliente.getMesa().getClientes().size());
                                }
                                int cargoAngeles = 6000 * cliente.getMesa().getClientes().size();
                                cargoExtra2 = 1200 + cargoAngeles;
                                break;
                            default:
                                System.out.println("Ingrese un dato válido [1 - 3]");
                                encendido1 = true;
                                break;
                        }
                        cliente.getFactura().aumentarValor(cargoExtra2);
                    } while (encendido1);
                } else {
                    extrasReserva(cliente);
                }
                break;
            case 3:
                System.out.println("No desea ningún servicio extra.");
                break;
            default:
                System.out.println("Ingrese un número válido.");
                extrasReserva(cliente);
                break;
        }
        return restaurante;
    }

    //Interacción 3
    public static void pagoAnticipado(Restaurante restaurante) {
        Reserva reserva = restaurante.getHistorialReservas().getLast();
        ArrayList<Cliente> clientes = reserva.getClientes();
        Factura factura = clientes.getFirst().getFactura();
        factura.setValor(15000);

        System.out.println("¿Desea pagar ya mismo su reserva?\n1. Sí.\n2. No.");
        int eleccion1 = Utilidad.readInt();
        if (eleccion1 == 1) {
            if (clientes.getFirst().getAfiliacion() == Cliente.Afiliacion.NINGUNA) {
                System.out.println("¿Desea afiliarse al restaurante? Hacerlo le daría un descuento extra por ser " +
                        "un nuevo socio\n1. Sí.\n2. No.");
                int eleccion2 = Utilidad.readInt();
                if (eleccion2 == 1) {
                    factura.setValor(13500); //Aplicar 10% de descuento al valor de la reserva.
                    pagarReserva(restaurante, reserva, clientes, factura);
                } else {
                    factura.setValor(15000);
                    pagarReserva(restaurante, reserva, clientes, factura);
                }
            } else {
                factura.setValor(14300); //Aplicar 5% de descuento al valor de la reserva.
                pagarReserva(restaurante, reserva, clientes, factura);
            }
            clientes.getFirst().getFactura().setPagoPreconsumo(true);
        } else {
            System.out.println("Al realizar el pago postconsumo se solicitará una propina porcentual obligaotria.");
            System.out.println("¿Teniendo esto en cuenta, desea continuar sin realizar el pago?\n1. Sí.\n" +
                    "2. No.");
            int eleccion6 = Utilidad.readInt();
            if (eleccion6 == 1) {
                confirmarReserva(restaurante, reserva, clientes);
            } else {
                pagoAnticipado(restaurante);
            }
        }
    }

    private static void pagarReserva(Restaurante restaurante, Reserva reserva, ArrayList<Cliente> clientes,
                                     Factura factura) {
        if (confirmarReserva(restaurante, reserva, clientes)) {
            escogerMetodoPago(clientes.getFirst());
            boolean encendido1 = true;
            do {
                System.out.println("¿Desea confirmar la transacción con un valor de: " +
                        factura.getValor() + "?");
                System.out.println("""
                                1. Sí.
                                2. No.
                                Escriba un número para elegir su opción.""");
                int eleccion3 = Utilidad.readInt();
                switch (eleccion3) {
                    case 1:
                        System.out.println("Transacción confirmada.");
                        clientes.getFirst().getFactura().setValor(0);
                        break;
                    case 2:
                        encendido1 = false;
                        break;
                    default:
                        encendido1 = false;
                        System.out.println("Ingrese un valor válido [1 - 2].");
                        break;
                }
            } while (encendido1);
        }
    }

    public static boolean confirmarReserva(Restaurante restaurante, Reserva reserva, ArrayList<Cliente> clientes) {
        boolean confirmada;
        LocalDate fechaIntento = LocalDate.now();
        restaurante.getIntentosReserva().add(new ArrayList<Integer>(Arrays.asList(fechaIntento.getYear(),
                fechaIntento.getMonthValue(), fechaIntento.getDayOfMonth())));
        System.out.println("Resumen de su reserva:");
        System.out.println(reserva);
        System.out.println("¿Desea confirmar su reserva?\n1. Sí.\n2. No.");
        int eleccion1 = Utilidad.readInt();
        if (eleccion1 == 1) {
            confirmada = true;
            System.out.println("Reserva confirmada.");
            System.out.println("Su código de reserva es: " + reserva.getCodigoReserva());
        } else {
            confirmada = false;
            System.out.println("Reserva cancelada.");
            Mesa mesaReserva = clientes.getFirst().getMesa();
            ArrayList<Integer> fechaReserva = mesaReserva.getFechasDisponibles().get(mesaReserva.getUltimaFechaReserva());
            fechaReserva.add(reserva.getFecha().get(3));
            mesaReserva.setClientes(null);
            mesaReserva.setUltimaFechaReserva(0);
            for (Cliente cliente : clientes) {
                cliente.resetDatosReserva();
            }
            restaurante.getHistorialReservas().remove(reserva);
        }
        return confirmada;
    }
}