package uiMain;

import gestorAplicacion.Entorno.Casilla;
import gestorAplicacion.Entorno.Ciudad;
import gestorAplicacion.Gestion.*;
import gestorAplicacion.Entorno.Zona;
import gestorAplicacion.Usuario.Cliente;

import java.time.LocalDateTime;
import java.util.*;

import static uiMain.Funcionalidad3.*;
import static uiMain.Funcionalidad4.*;
import static uiMain.Utilidad.*;


public class Main {
    static LocalDateTime localDateTime = LocalDateTime.now(); //Fecha a la hora de ejectuar el programa
    static ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>(); //Lista de ciudades
    static ArrayList<Zona> zonas = new ArrayList<Zona>(); //Lista de zonas
    static ArrayList<Plato> platos = new ArrayList<Plato>(); //Lista de platos
    static ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>(); //Lista de ingredientes

    static {
        //Creamos ciudades de muestra
        Ciudad ciudad1 = new Ciudad("Medellín");
        ciudades.add(ciudad1);
        Ciudad ciudad2 = new Ciudad("Bogotá");
        ciudades.add(ciudad2);

        //Creamos zonas de muestra
        zonas.add(new Zona(4378, "Robledo", ciudad1));
        zonas.add(new Zona(7426, "Aranjuez", ciudad1));
        zonas.add(new Zona(193134, "Kennedy", ciudad2));

        System.out.println("Sexo");

        //Agregamos las zonas creadas al array zonas de su respectiva ciudad
        for (Ciudad ciudad : ciudades) {
            for (Zona zona : zonas) {
                if (zona.getCiudad() == ciudad) {
                    ciudad.getZonas().add(zona);
                }
            }
        }
        Restaurante restaurante1 = new Restaurante();
        Mesa mesa1 = new Mesa(0, 0, 0, false, 4);
        restaurante1.agregarMesa(mesa1);
        mesa1.setRestaurante(restaurante1);


        //Creamos clientes de muestra para la mesa 1
        ArrayList <Cliente> clientesMesa1 = new ArrayList<Cliente>();
        Cliente cliente1 = new Cliente("Juan", 001, "Estrella", "1234567");
        cliente1.setMesa(mesa1);
        clientesMesa1.add(cliente1);
        Cliente cliente2 = new Cliente("Pedro", 002, "Estrellita", "7654321");
        cliente2.setMesa(mesa1);
        clientesMesa1.add(cliente2);
        Cliente cliente3 = new Cliente("María", 003, "9876543");
        cliente3.setMesa(mesa1);
        clientesMesa1.add(cliente3);
        mesa1.setClientes(clientesMesa1);

        //Creamos ingredientes y platos de muestra
        Ingrediente Tomate = new Ingrediente("Tomate", 500);
        Ingrediente Lechuga = new Ingrediente("Lechuga", 300);
        ArrayList<Ingrediente> ingredientesEnsalada = new ArrayList<Ingrediente>();
        ingredientesEnsalada.add(Tomate);
        ingredientesEnsalada.add(Lechuga);
        Plato Ensalada = new Plato("Ensalada", 19000, ingredientesEnsalada);

        Ingrediente Carne = new Ingrediente("Carne", 1000);
        Ingrediente Pan = new Ingrediente("Pan", 500);
        ArrayList<Ingrediente> ingredientesHamburguesa = new ArrayList<Ingrediente>();
        ingredientesHamburguesa.add(Carne);
        ingredientesHamburguesa.add(Pan);
        Plato Hamburguesa = new Plato("Hamburguesa", 25000, ingredientesHamburguesa);

        Ingrediente Arroz = new Ingrediente("Arroz", 800);
        Ingrediente Pollo = new Ingrediente("Pollo", 700);
        ArrayList<Ingrediente> ingredientesArroz = new ArrayList<Ingrediente>();
        ingredientesArroz.add(Arroz);
        ingredientesArroz.add(Pollo);
        Plato ArrozConPollo = new Plato("Arroz con pollo", 20000, ingredientesArroz);

        //Creamos pedidos de muestra
        Pedido pedido1 = new Pedido();
        Pedido pedido2 = new Pedido();
        Pedido pedido3 = new Pedido();

        pedido1.agregarPlato(Ensalada);
        pedido2.agregarPlato(Hamburguesa);
        pedido3.agregarPlato(ArrozConPollo);

        //Creamos facturas de muestra
        Factura factura1 = new Factura(pedido1, "Efectivo", false, 0);
        Factura factura2 = new Factura(pedido2, "Tarjeta", false, 0);
        Factura factura3 = new Factura(pedido3, "Efectivo", false, 0);
        cliente1.setFactura(factura1);
        cliente2.setFactura(factura2);
        cliente3.setFactura(factura3);

        //Creamos un restaurante de muestra
        Restaurante restauranteMuestra = new Restaurante();
        restauranteMuestra.setZonaVIP(true);

        //Creamos una disposición default para el restaurante de muestra
        ArrayList<ArrayList<String>> disposicion = new ArrayList<ArrayList<String>>();
        disposicion.add(new ArrayList(Arrays.asList(
                new String[]{"╔", "═", "╦", "╗", "║", "╠", "╬", "╣", "╚", "╩", "╝", " "})));
        disposicion.add(new ArrayList(Arrays.asList(
                new String[]{"B", "B", "B", "B", "B", "B", "B", "B", "B", "B"})));
        disposicion.add(new ArrayList(Arrays.asList(
                new String[]{"B", " ", "V", " ", "V", " ", "V", " ", "V", "B"})));
        disposicion.add(new ArrayList(Arrays.asList(
                new String[]{"W", " ", " ", " ", " ", " ", " ", " ", " ", "W"})));
        disposicion.add(new ArrayList(Arrays.asList(
                new String[]{"B", " ", "T", " ", "T", " ", "T", " ", "T", "B"})));
        disposicion.add(new ArrayList(Arrays.asList(
                new String[]{"B", " ", " ", " ", " ", " ", " ", " ", " ", "B"})));
        disposicion.add(new ArrayList(Arrays.asList(
                new String[]{"B", " ", "T", " ", "T", " ", "T", " ", " ", "B"})));
        disposicion.add(new ArrayList(Arrays.asList(
                new String[]{"B", " ", " ", " ", " ", " ", " ", " ", " ", "B"})));
        disposicion.add(new ArrayList(Arrays.asList(
                new String[]{"W", " ", "T", " ", "T", " ", "T", " ", " ", "W"})));
        disposicion.add(new ArrayList(Arrays.asList(
                new String[]{"B", " ", " ", " ", " ", " ", " ", " ", " ", "B"})));
        disposicion.add(new ArrayList(Arrays.asList(
                new String[]{"B", "B", "B", "B", "B", "B", "B", "E", "B", "B"})));
        restauranteMuestra.setDisposicion(disposicion);
    }

    public static void main(String[] args) {
        menuPrincipal();
    }

    //Muestra el menú principal del programa
    static void menuPrincipal() {
        limpiarPantalla();
        boolean encendido = true;
        do {
            limpiarPantalla();
            System.out.println("""
                    ¿Qué desea hacer?
                    1. Reservar Mesa.
                    2. Ordenar Comida.
                    3. Dejar Restaurante
                    4. Agregar Sede.
                    5. Crear Evento.
                    6. Salir.
                    Escriba un número para elegir su opción.""");
            int eleccion = readInt();
            switch (eleccion) {
                case 1:
                    limpiarPantalla();
                    System.out.println("Interacción 1.");
                    System.out.println(ciudades.getLast().getZonas());
                    encendido = false;
                    break;
                case 2:
                    limpiarPantalla();
                    System.out.println("Funcionalidad 2.");
                    encendido = false;
                    break;
                case 3:
                    limpiarPantalla();
                    System.out.println("Interacción 3.");
                    dejarRestaurante();
                    encendido = false;
                    break;
                case 4:
                    limpiarPantalla();
                    Restaurante restaurante = agregarSede();
                    break;
                case 5:
                    limpiarPantalla();
                    System.out.println("Funcionalidad 5.");
                    encendido = false;
                    break;
                case 6:
                    limpiarPantalla();
                    System.out.println("Se cierra el programa.");
                    encendido = false;
                    break;
                default:
                    limpiarPantalla();
                    System.out.println("Ingrese un número válido [1 - 6].");
                    break;
            }
        } while (encendido);
    }
}