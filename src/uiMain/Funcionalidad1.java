package uiMain;

import gestorAplicacion.Entorno.Ciudad;
import gestorAplicacion.Entorno.Zona;
import gestorAplicacion.Gestion.Mesa;
import gestorAplicacion.Gestion.Reserva;
import gestorAplicacion.Gestion.Restaurante;
import gestorAplicacion.Usuario.Cliente;

import java.awt.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import static uiMain.Main.ciudades;
import static uiMain.Main.menuPrincipal;
import static uiMain.Utilidad.*;

public class Funcionalidad1 {
    public static void reservarMesa() {
        boolean encendido1 = true;
        do {
            System.out.println("""
                    ¿Desea reservar una mesa?
                    1. Sí.
                    2. No.
                    Escriba un número para elegir su opción.""");
            int eleccion1 = readInt();
            switch (eleccion1) {
                case 1:
                    limpiarPantalla();
                    System.out.println("Ciudades:");
                    listadoCiudades();
                    System.out.println("Escriba un número para elegir la ciudad.\nEn caso de no encontrar la ciudad " +
                            "requerida escriba 0.");
                    int eleccion2 = readInt();
                    if (eleccion2 > ciudades.size() || eleccion2 < 0) {
                        System.out.println("Ingrese un número válido [1 - " + ciudades.size() + "].");
                    } else {
                        limpiarPantalla();
                        if (!(eleccion2 == 0)) { //Si se encuentra la ciudad
                            Ciudad ciudad = ciudades.get(eleccion2 - 1);
                            if (ciudad.getRestaurantes().isEmpty()) { //Si la ciudad no tiene restaurantes
                                System.out.println("Esta ciudad no tiene restaurantes.");
                                reservarMesa();
                            } else { //Si la ciudad tiene zonas
                                boolean encendido2 = true;
                                do {
                                    limpiarPantalla();
                                    System.out.println("Zonas de " + ciudad.getNombre() + ":");
                                    ArrayList<Zona> zonasConRestaurante = listadoZonasConRestauranteCiudad(ciudad);
                                    int eleccion3 = readInt("Escriba un número para elegir la zona.");
                                    if (eleccion3 > zonasConRestaurante.size() || eleccion3 < 1) { //Si no se encuentra la zona
                                        System.out.println("Ingrese un número válido [1 - " + zonasConRestaurante.size() +
                                                "].");
                                    } else { //Si se encuentra la zona
                                        limpiarPantalla();
                                        Zona zona = zonasConRestaurante.get(eleccion3 - 1);
                                        boolean encendido3 = true;
                                        do {
                                            limpiarPantalla();
                                            System.out.println("Restaurantes de " + zona.getNombre() + ":");
                                            listadoRestaurantesZona(zona);
                                            int eleccion4 = readInt("Escriba un número para elegir el " +
                                                    "restaurante.");
                                            if (eleccion4 > zona.getRestaurantes().size() || eleccion4 < 1) { //Si no se encuentra el restaurante
                                                System.out.println("Ingrese un número válido [1 - " +
                                                        zona.getRestaurantes().size() + "].");
                                            } else { //Si se encuentra el restaurante
                                                seleccionMesa(zona.getRestaurantes().get(eleccion4 - 1));
//                                                extrasReserva();
                                                pagoAnticipado(zona.getRestaurantes().get(eleccion4 - 1));
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
                            int eleccion4 = readInt("""
                                    ¿Desea elegir otra ciudad?
                                    1. Sí.
                                    2. No.
                                    Escriba un número para elegir su opción.""");
                            if (eleccion4 == 1) {
                                reservarMesa();
                            } else {
                                menuPrincipal();
                            }
                        }
                        encendido1 = false;
                    }
                    break;
                case 2:
                    limpiarPantalla();
                    menuPrincipal();
                    encendido1 = false;
                    break;
                default:
                    limpiarPantalla();
                    System.out.println("Ingrese un número válido [1 - 2].");
                    break;
            }
        } while (encendido1);
    }

    public static void seleccionMesa(Restaurante restaurante) {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = capitalize(readString());
        System.out.println("Ingrese la cédula del cliente:");
        int cedula = readInt();
        System.out.println("Ingrese la placa del vehículo del cliente (en caso de no tener escribir 0):");
        String placaVehiculo = readString();
        Cliente cliente = new Cliente(nombre, cedula, placaVehiculo);
        if (existeCliente(cliente)) {
            cliente = clienteCedula(cliente);
            clientes.add(cliente);
        } else {
            Restaurante.getClientes().add(cliente);
            clientes.add(cliente);
        }
        System.out.println("Ingrese la cantidad de acompañantes del cliente:");
        int numAcompanantes = readInt("Ingrese la cantidad de acompañantes. No debe ser mayor a 6.\nEn caso de" +
                " ingresar un número mayor a 6, este será ignorado y se establecerá en 6.");
        if (numAcompanantes > 0) {
            if (numAcompanantes > 6) {numAcompanantes = 6;}
            for (int i = 0; i < numAcompanantes; i++) {
                System.out.println("Ingrese el nombre del acompañante #" + (i + 1) + ":");
                String nombreAcompanante = readString();
                System.out.println("Ingrese la cédula del acompañante #" + (i + 1) + ":");
                int cedulaAcompanante = readInt();
                Cliente acompanante = new Cliente(nombreAcompanante, cedulaAcompanante);
                acompanante = clienteCedula(acompanante);
                if (existeCliente(acompanante)) {
                    clientes.add(acompanante);
                } else {
                    Restaurante.getClientes().add(acompanante);
                    clientes.add(acompanante);
                }
            }
        }
        for (Cliente cliente1 : clientes) {
            cliente1.setRestaurante(restaurante);
        }
        boolean tipoMesa = false;
        boolean existe = false;
        int eleccion1 = readInt("¿Qué tipo de mesa quiere usar?\n1. Estándar.\n2. VIP.");
        switch (eleccion1) {
            case 1:
                for (Mesa mesa : restaurante.getMesas()) {
                    if (mesa.isVIP() == tipoMesa) {
                        existe = true;
                    } else {
                        System.out.println("Lo sentimos, pero no hay mesas estándar, la mesa tendrá que ser VIP.");
                        tipoMesa = true;
                    }
                }
                break;
            case 2:
                tipoMesa = true;
                for (Mesa mesa : restaurante.getMesas()) {
                    if (mesa.isVIP() == tipoMesa) {
                        existe = true;
                    } else {
                        System.out.println("Lo sentimos, pero no hay mesas VIP, la mesa tendrá que ser estándar.");
                        tipoMesa = false;
                    }
                }
                break;
            default:
                System.out.println("Debido a que ingresó un dato erróneo se le asignó una mesa estándar.");
                break;
        }
        ArrayList<Integer> mesasElegidas = new ArrayList<Integer>();
        int eleccion2 = readInt("Tiene preferencia por estar cerca de:\n1. Puerta.\n2. Ventana.\n3. Ninguna.");
        switch (eleccion2) {
            case 1, 2:
                mesasElegidas = calcularDistancia(restaurante, eleccion2, tipoMesa);
                break;
            default:
                System.out.println("Debido a que ingresó un dato erróneo se asume que no tiene ninguna preferencia.");
                break;
        }
        boolean encendido1 = true;
        do {
            ArrayList<Integer> fechaElegida = seleccionFecha(restaurante, tipoMesa, mesasElegidas);
            limpiarPantalla();
            System.out.println("Mesas disponibles para el día " + fechaElegida.get(2) + '/' + fechaElegida.get(1) + '/'
                    + fechaElegida.get(0) + ':');
            ArrayList<Mesa> mesasDisponibles = new ArrayList<Mesa>();
            for (Mesa mesa : restaurante.getMesas()) {
                for (ArrayList<Integer> fecha : mesa.getFechasDisponibles()) {
                    if (Objects.equals(fecha.get(0), fechaElegida.get(0)) && Objects.equals(fecha.get(1), fechaElegida.get(1)) && Objects.equals(fecha.get(2), // Objects.equals usado para evitar nulidad.
                            fechaElegida.get(2)) && mesa.isVIP() == tipoMesa && fecha.size() > 3) {
                        System.out.println("Mesa #" + mesa.getNumMesa());
                    }
                }
            }
            if (!mesasElegidas.isEmpty()) {
                System.out.println("Según sus preferencias se le recomienda elegir las mesas con el número:");
                for (int numMesa : mesasElegidas) {
                    System.out.println("#" + numMesa);
                }
            }
            int eleccion4 = readInt("¿Alguna de las mesas disponibles le es conveniente?\n1. Sí.\n2. No.");
            if (eleccion4 == 1) {
                int numMesa = readInt("Ingrese el número de la mesa de su preferencia.");
                Mesa mesaElegida = new Mesa();
                for (Mesa mesa : restaurante.getMesas()) {
                    if (mesa.getNumMesa() == numMesa) {
                        mesaElegida = mesa;
                        break;
                    }
                }
                if (mesaElegida.getDistanciaPuerta() == 9999 && mesaElegida.getDistanciaVentana() == 9999) {
                    System.out.println("Ingresó un número inválido. Se le asignará una mesa aleatoria.");
                    for (Mesa mesa : restaurante.getMesas()) {
                        if (mesa.getNumMesa() == mesasElegidas.getFirst()) {
                            mesaElegida = mesa;
                            break;
                        }
                    }
                }
                limpiarPantalla();
                int indiceFechaElegida = 0;
                for (ArrayList<Integer> fecha : mesaElegida.getFechasDisponibles()) {
                    if (fecha.get(1) == fechaElegida.get(1) && Objects.equals(fecha.get(2), fechaElegida.get(2))) {
                        indiceFechaElegida = mesaElegida.getFechasDisponibles().indexOf(fecha);
                        break;
                    }
                }
                System.out.println("Horarios disponibles para la mesa seleccionada:");
                for (int i = 3; i < mesaElegida.getFechasDisponibles().get(indiceFechaElegida).size(); i++) {
                    System.out.println(i-2 + ". " + mesaElegida.getFechasDisponibles().get(indiceFechaElegida).get(i)
                            + ":00.");
                }
                int eleccion5 = readInt("¿Alguno de los horarios disponibles le es conveniente?\n1. Sí.\n2. No.");
                if (eleccion5 == 1) {
                    boolean encendido2 = true;
                    do {
                        int horaElegida = readInt("Ingrese el horario de su preferencia. [1 - " +
                                (mesaElegida.getFechasDisponibles().get(indiceFechaElegida).size() - 3) + "].");
                        if (horaElegida < 1 || horaElegida >
                                mesaElegida.getFechasDisponibles().get(indiceFechaElegida).size() - 2) {
                            System.out.println("Ingrese un número válido [1 - " +
                                    (mesaElegida.getFechasDisponibles().get(indiceFechaElegida).size() - 3) + "].");
                        } else {
                            fechaElegida.add(mesaElegida.getFechasDisponibles().get(indiceFechaElegida).get(horaElegida
                                    + 2));
                            Reserva reserva = new Reserva(clientes, fechaElegida);
                            mesaElegida.getFechasDisponibles().get(indiceFechaElegida).remove(horaElegida + 2);
                            restaurante.getHistorialReservas().add(reserva);
                            for (Cliente cliente1 : clientes) {
                                cliente1.setReserva(reserva);
                            }
                            System.out.println("Mesa Elegida" + mesaElegida.getFechasDisponibles());

                            System.out.println(restaurante.getHistorialReservas());
                            System.out.println("Su reserva ha sido exitosa");
                            encendido1 = false;
                            encendido2 = false;
                        }
                    } while (encendido2);

                } else {
                    int seguir1 = readInt("¿Desea elegir una fecha diferente?\n1. Sí.\n2. No.");
                    if (seguir1 != 1) {
                        encendido1 = false;
                    }
                }
            } else {
                int seguir2 = readInt("¿Desea elegir una fecha diferente?\n1. Sí.\n2. No.");
                if (seguir2 != 1) {
                    encendido1 = false;
                }
            }
            System.out.println(restaurante);
        } while (encendido1);
    }

    public static ArrayList<Integer> seleccionFecha(Restaurante restaurante, boolean tipoMesa, ArrayList<Integer> mesasElegidas) {
        ArrayList<Integer> elecciones = new ArrayList<Integer>();
        ArrayList<Integer> anios = new ArrayList<Integer>();
        ArrayList<Integer> meses = new ArrayList<Integer>();
        for (ArrayList<Integer> fechasMes : restaurante.getFechasDisponibles()) {
            if (!anios.contains(fechasMes.getFirst())) {
                anios.add(fechasMes.getFirst());
            }
        }
        System.out.println("Años disponibles:");
        for (int i = 0; i < anios.size(); i++) {
            System.out.println((i + 1) + ". " + anios.get(i) + ".");
        }
        int eleccion1 = readInt("Escriba un número para elegir su opción [1 - " + anios.size() + "].");
        int eleccion2;
        int eleccion3;
        boolean encendido2 = true;
        do {
            System.out.println("Meses disponibles:");
            int i = 1;
            for (ArrayList<Integer> fechasMes : restaurante.getFechasDisponibles()) {
                if (Objects.equals(anios.get(eleccion1 - 1), fechasMes.get(0))) {
                    System.out.println(i + ". " + fechasMes.get(1) + ".");
                    meses.add(fechasMes.get(1));
                    i++;
                }
            }
            eleccion2 = readInt("Escriba un número para elegir su opción [1 - " + i + "].");
            if (eleccion2 > meses.size() || eleccion2 < 1) {
                System.out.println("Ingrese un número válido");
            } else {
                encendido2 = false;
            }
        } while (encendido2);
        boolean encendido3 = true;
        int indiceMes = 0;
        do {
            System.out.println("Días disponibles:");
            for (int i = 0; i < restaurante.getFechasDisponibles().size(); i++) {
                if (Objects.equals(meses.get(eleccion2 - 1), restaurante.getFechasDisponibles().get(i).get(1))) {
                    indiceMes = i;
                    break;
                }
            }
            for (int i = 2; i < restaurante.getFechasDisponibles().get(indiceMes).size(); i++) {
                System.out.println(i - 1 + ". " + restaurante.getFechasDisponibles().get(indiceMes).get(i) + ".");
            }
            eleccion3 = readInt("Escriba un número para elegir su opción [1 - " +
                    (restaurante.getFechasDisponibles().get(indiceMes).size() - 2) + "].");
            if (eleccion3 > restaurante.getFechasDisponibles().get(indiceMes).size() || eleccion3 < 1) {
                System.out.println("Ingrese un número válido");
            } else {
                encendido3 = false;
            }
        } while (encendido3);
        elecciones.add(anios.get(eleccion1 - 1));
        elecciones.add(meses.get(eleccion2 - 1));
        elecciones.add(restaurante.getFechasDisponibles().get(indiceMes).get(eleccion3 + 1));
        System.out.println(elecciones);
        return elecciones;
    }

    // Interacción 2
    public static void extrasReserva(Cliente cliente){
        System.out.println("Desde la cadena de restaurantes ofrecemos los servicios de reserva de parqueadero y " +
                "decoraciones para la mesa. Elija un servicio en caso de necesitarlo:");
        System.out.println("""
                1. Reserva de Parqueadero.
                2. Decoraciones para la mesa.
                3. No desea ningún servicio extra.""");
        int eleccion = readInt();
        switch (eleccion) {
            case 1:
                System.out.println("Reserva de Parqueadero");
                if (cliente.getAfiliacion() == Cliente.Afiliacion.NINGUNA){
                    System.out.println("El servicio tiene un coste de $10.000. ¿Desea reservar el parqueadero?");
                    System.out.println("""
                            1. Sí.
                            2. No.""");
                    int eleccion2 = readInt();
                    String placa = "";
                    if (eleccion2 == 1){
                        if (cliente.getPlacaVehiculo().equals("Ninguna")){
                            System.out.println("Ingrese la placa del vehículo:");
                            placa = readString();
                            cliente.setPlacaVehiculo(placa);
                        } else {
                            placa = cliente.getPlacaVehiculo();
                        }
                        for (int i = 0; i < cliente.getRestaurante().getParqueadero().size(); i++) {
                            if (!cliente.getRestaurante().getParqueadero().get(i)) {
                                System.out.println("Parqueadero reservado con éxito para el vehículo con placa: " +
                                        placa + ".");
                                break;
                            }
                        }
                        System.out.println("Parqueadero reservado con éxito.");
                    } else {
                        extrasReserva(cliente);
                    }
                }
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
                int eleccion3 = readInt();
                if (eleccion3 == 1) {
                    boolean encendido1 = false;
                    do {
                        System.out.println("""
                                Disponemos de los siguientes paquetes de decoración:
                                1. Cena romántica.
                                2. Graduación.
                                3. Descubrimiento.""");
                        int eleccion4 = readInt();
                        switch (eleccion4) {
                            case 1:
                                //Descontar de Bodega una unidad de rosas y velas, además de vino blanco
                                //Trabajador de tipo Violinista se le hace un pago extra ¿?
                                //Cargo extra a factura
                                break;
                            case 2:
                                //Descontar de Bodega una unidad de globos negros y globos dorados, y
                                //descontar birretes simbólicos según el número de clientes
                                //Cargo extra a factura
                                break;
                            case 3:
                                System.out.println("Seleccione el género del bebé:\n1. Niño.\n2. Niña.");
                                int eleccion5 = readInt();
                                if (eleccion5 == 1) {
                                    //Descontar de Bodega globos azules, blancos y (angel varón según # clientes)
                                } else {
                                    //Descontar de Bodega globos rosados, blancos y (angel femenino según # clientes)
                                }
                                //Cargo extra a factura
                                break;
                            default:
                                System.out.println("Ingrese un dato válido [1 - 3]");
                                encendido1 = true;
                                break;
                        }
                    } while (encendido1);
                } else {
                    extrasReserva(cliente);
                }
                break;
            case 3:
                System.out.println("No desea ningún servicio extra");
                break;
            default:
                System.out.println("Ingrese un número válido.");
                extrasReserva(cliente);
                break;
        }
    }

    //Interacción 3
    public static void pagoAnticipado(Restaurante restaurante) {
        int eleccion1 = readInt("¿Desea pagar ya mismo su reserva?\n1. Sí.\n2. No.");
        if (eleccion1 == 1) {

        } else {
            System.out.println("Al realizar el pago postconsumo se solicitará una propina porcentual obligaotria.");
            int eleccion2 = readInt("¿Teniendo esto en cuenta, desea continuar sin realizar el pago?\n1. Sí.\n" +
                    "2. No.");
            if (eleccion2 == 1) {
                System.out.println("Resumen de su reserva:");
                System.out.println(restaurante.getHistorialReservas().getLast());
                int eleccion3 = readInt("¿Desea confirmar su reserva?\n1. Sí.\n2. No.");
                if (eleccion3 == 1) {
                    System.out.println("Reserva confirmada.");
                } else {
                    System.out.println("Reserva cancelada.");
                    // Reponer lo eliminado de la mesa y otras cosas (Hacer una función para mayor comodidad)
                    for (Cliente cliente : restaurante.getHistorialReservas().getLast().getClientes()) {
                        cliente.resetAtributos();
                    }
                    restaurante.getHistorialReservas().remove(restaurante.getHistorialReservas().getLast());
                }
            } else {
                pagoAnticipado(restaurante);
            }
        }
    }
}
