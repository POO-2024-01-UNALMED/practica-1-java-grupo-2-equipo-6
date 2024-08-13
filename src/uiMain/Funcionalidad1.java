package uiMain;

import gestorAplicacion.Entorno.Ciudad;
import gestorAplicacion.Entorno.Zona;
import gestorAplicacion.Gestion.Restaurante;
import gestorAplicacion.Usuario.Cliente;

import java.awt.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

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
                                            if (eleccion4 > zonasConRestaurante.size() || eleccion4 < 1) { //Si no se encuentra el restaurante
                                                System.out.println("Ingrese un número válido [1 - " +
                                                        zona.getRestaurantes().size() + "].");
                                            } else { //Si se encuentra el restaurante
                                                seleccionMesa(zona.getRestaurantes().get(eleccion4 - 1));
                                                // seleccion fecha
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

        int eleccion1 = readInt("¿Qué tipo de mesa quiere usar?\n1. Estándar.\n2. VIP.");
        boolean tipoMesa = false;
        int cercania;
        seleccionFecha(restaurante);

        System.out.println(restaurante);
    }

    public static void seleccionFecha(Restaurante restaurante) {
        ArrayList<Integer> anios = new ArrayList<Integer>();
        ArrayList<Integer> meses = new ArrayList<Integer>();
        for (ArrayList<Integer> fechasMes : restaurante.getFechasDisponibles()) {
            if (!anios.contains(fechasMes.get(0))) {
                anios.add(fechasMes.get(0));
            }
        }
        System.out.println("Años disponibles:");
        for (int i = 0; i < anios.size(); i++) {
            System.out.println(i + ". " + anios.get(i) + ".");
        }
        int eleccion1 = readInt("Escriba un número para elegir su opción [1 - " + anios.size() + "].");
        int eleccion2 = 0;
        boolean encendido1 = true;
        do {
            System.out.println("Meses disponibles:");
            int i = 1;
            for (ArrayList<Integer> fechasMes : restaurante.getFechasDisponibles()) {
                if (eleccion1 == fechasMes.get(0)) {
                    System.out.println(i + ". " + fechasMes.get(1) + ".");
                    meses.add(fechasMes.get(1));
                    i++;
                }
            }
            eleccion2 = readInt("Escriba un número para elegir su opción [1 - " + i + "].");
            if (eleccion2 > meses.size() || eleccion2 < 1) {
                System.out.println("Ingrese un número válido");
            } else {
                encendido1 = false;
            }
        } while (encendido1);
        boolean encendido2 = true;
        do {
            System.out.println("Días disponibles:");
            int indiceMes = 0;
            for (int i = 0; i < restaurante.getFechasDisponibles().size(); i++) {
                if (eleccion2 == restaurante.getFechasDisponibles().get(i).get(1)) {
                    indiceMes = i;
                }
            }
            for (int i = 2; i < restaurante.getFechasDisponibles().get(indiceMes).size(); i++) {
                System.out.println(i - 1 + ". " + restaurante.getFechasDisponibles().get(indiceMes).get(i) + ".");
            }
            int eleccion3 = readInt("Escriba un número para elegir su opción [1 - " +
                    restaurante.getFechasDisponibles().get(indiceMes).size() + "].");
            if (eleccion3 > restaurante.getFechasDisponibles().get(indiceMes).size() || eleccion3 < 1) {
                System.out.println("Ingrese un número válido");
            } else {
                encendido2 = false;
            }
        } while (encendido2);
    }

    // Interacción 2
    public static void extrasReserva(Cliente cliente, Restaurante restaurante){
        System.out.println("Desde la cadena de restaurantes ofrecemos los servicios de: ");
        System.out.println("""
                1. Reserva de Parqueadero.
                2. Decoraciones para la mesa.
                3. No desea ningún servicio extra.""");
        int eleccion = readInt();
        switch (eleccion){
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
                        for (int i = 0; i < restaurante.getParqueadero().size(); i++) {
                            if (restaurante.getParqueadero().get(i) == false) {
                                System.out.println("Parqueadero reservado con éxito para el vehículo con placa: " +
                                        placa + ".");
                                break;
                            }
                        }
                        System.out.println("Parqueadero reservado con éxito.");
                    } else {
                        extrasReserva(cliente, restaurante);
                    }
                }
                break;
            case 2:
                System.out.println("Decoraciones para la mesa");
                if (cliente.getAfiliacion() != Cliente.Afiliacion.NINGUNA){
                    System.out.println("Obtuvo un 15% de descuento en las decoraciones para mesa. El costo es de $42.500");
                } else {
                    System.out.println("El costo de las decoraciones es de $50.000");
                }
                System.out.println("¿Desea decorar la mesa?");
                System.out.println("""
                        1. Sí.
                        2. No.""");
                int eleccion3 = readInt();
                switch (eleccion3){
                    case 1:
                        System.out.println("Decoraciones para la mesa reservadas con éxito.");
                        break;
                    case 2:
                        extrasReserva(cliente, restaurante);
                        break;
                    default:
                        System.out.println("Ingrese un número válido.");
                        extrasReserva(cliente, restaurante);
                        break;
                }


                break;
            case 3:
                System.out.println("No desea ningún servicio extra");
                break;
            default:
                System.out.println("Ingrese un número válido.");
                extrasReserva(cliente, restaurante);
                break;
        }
    }
}
