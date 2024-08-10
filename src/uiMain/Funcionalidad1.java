package uiMain;

import gestorAplicacion.Entorno.Ciudad;
import gestorAplicacion.Entorno.Zona;
import gestorAplicacion.Gestion.Restaurante;

import java.util.ArrayList;

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
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = capitalize(readString());
        System.out.println("Ingrese la cédula del cliente:");
        int cedula = readInt();
        System.out.println("Ingrese la placa del vehículo del cliente (en caso de no tener escribir 0):");
        String placaVehiculo = readString();
        System.out.println("Ingrese la cantidad de acompañantes del cliente:");
        int numAcompanantes = readInt();
        for (int i = 0; i < numAcompanantes; i++) {

        }
        System.out.println(restaurante);
    }
}
