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
                                    System.out.println("Zonas de " + ciudad.getNombre());
                                    ArrayList<Zona> zonasConRestaurante = listadoZonasConRestauranteCiudad(ciudad);
                                    int eleccion3 = readInt("Escriba un número para elegir la zona.");
                                    if (eleccion3 > zonasConRestaurante.size() || eleccion3 < 1) {
                                        System.out.println("Ingrese un número válido [1 - " + zonasConRestaurante.size() +
                                                "].");
                                    } else {
                                        limpiarPantalla();
                                        Zona zona = zonasConRestaurante.get(eleccion3 - 1);
                                        
                                        encendido2 = false;
                                    }
                                } while (encendido2);

                            }
                        } else { //Si no se encuentra la ciudad
                            System.out.println("Lo sentimos, pero estas son las únicas ciudades donde tenemos " +
                                    "restaurantes de nuestra cadena.");
                            int eleccion4 = readInt("¿Desea elegir otra ciudad?\n1. Sí.\n2. No.\nEscriba un " +
                                    "número para elegir su opción.");
                            switch (eleccion4) {
                                case 1:
                                    reservarMesa();
                                    break;
                                default:
                                    menuPrincipal();
                                    break;
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

    public static void seleccionMesa() {

    }
}
