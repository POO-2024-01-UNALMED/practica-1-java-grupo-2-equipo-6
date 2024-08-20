package uiMain;

import baseDatos.Deserializador;
import baseDatos.Serializador;

import gestorAplicacion.Gestion.*;

import static uiMain.Funcionalidad1.reservarMesa;

import static uiMain.Funcionalidad2.*;
import static uiMain.Funcionalidad3.*;
import static uiMain.Funcionalidad4.*;

public class Main implements Utilidad {
    public static void main(String[] args) {
        Deserializador.deserializarListas();
        menuPrincipal();
    }

    //Muestra el menú principal del programa
    static void menuPrincipal() {
        Utilidad.limpiarPantalla();
        boolean encendido = true;
        do {
            Utilidad.limpiarPantalla();
            System.out.println("""
                    ¿Qué desea hacer?
                    1. Reservar Mesa.
                    2. Ordenar Comida.
                    3. Dejar Restaurante
                    4. Agregar Sede.
                    5. Crear Evento.
                    6. Guardar y Salir.
                    Escriba un número para elegir su opción.""");
            int eleccion = Utilidad.readInt();
            switch (eleccion) {
                case 1:
                    Utilidad.limpiarPantalla();
                    reservarMesa();
                    break;
                case 2:
                    Utilidad.limpiarPantalla();
                    System.out.println("Funcionalidad 2.");
                    ordenarComida();
                    encendido = false;

                    break;
                case 3:
                    Utilidad.limpiarPantalla();
                    dejarRestaurante();
                    encendido = false;
                    break;
                case 4:
                    Utilidad.limpiarPantalla();
                    Restaurante restaurante4 = agregarSede();
                    restaurante4.actualizarFechasDisponibles();
                    break;
                case 5:
                    Utilidad.limpiarPantalla();
                    System.out.println("Funcionalidad 5.");
                    Funcionalidad5.crearEvento();
                    encendido = false;
                    break;
                case 6:
                    Utilidad.limpiarPantalla();
                    System.out.println("Se cierra el programa.");
                    Serializador.serializarListas();
                    encendido = false;
                    break;
                default:
                    Utilidad.limpiarPantalla();
                    System.out.println("Ingrese un número válido [1 - 6].");
                    break;
            }
        } while (encendido);
    }
}