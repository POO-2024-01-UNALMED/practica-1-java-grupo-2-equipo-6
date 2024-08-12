package uiMain;

import gestorAplicacion.Entorno.Casilla;
import gestorAplicacion.Entorno.Ciudad;
import gestorAplicacion.Gestion.*;
import gestorAplicacion.Entorno.Zona;
import gestorAplicacion.Usuario.Cliente;

import java.time.LocalDateTime;
import java.util.*;

import static uiMain.Funcionalidad1.reservarMesa;
import static uiMain.Funcionalidad3.*;
import static uiMain.Funcionalidad4.*;
import static uiMain.Utilidad.*;


public class Main {

    static LocalDateTime localDateTime = LocalDateTime.now(); //Fecha a la hora de ejectuar el programa
    static ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>(); //Lista de ciudades
    static ArrayList<Zona> zonas = new ArrayList<Zona>(); //Lista de zonas
    static ArrayList<Plato> platos = new ArrayList<Plato>(); //Lista de platos
    static ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>(); //Lista de ingredientes

    static ArrayList<Reserva> reservasUsaquen = new ArrayList<Reserva>();
    static ArrayList<Plato> platosCumple = new ArrayList<Plato>(); //Lista de platos cumpleaños
    static ArrayList<Evento> eventos = new ArrayList<Evento>();
    static ArrayList<Plato> vinos_champanas_meeting = new ArrayList<Plato>();
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

        //Agregamos las zonas creadas al array zonas de su respectiva ciudad
        for (Ciudad ciudad : ciudades) {
            for (Zona zona : zonas) {
                if (zona.getCiudad() == ciudad) {
                    ciudad.getZonas().add(zona);
                }
            }
        }
        Restaurante restaurante1 = new Restaurante(ciudad1, ciudad1.getZonas().getFirst(), true,
                "El Comecuernos");

        Mesa mesa1 = new Mesa(0, 0, 0, false, 4);
        restaurante1.agregarMesa(mesa1);
        mesa1.setRestaurante(restaurante1);
        ciudad1.getRestaurantes().add(restaurante1);
        ciudad1.getZonas().get(0).getRestaurantes().add(restaurante1);


        //Creamos clientes de muestra para la mesa 1
        ArrayList <Cliente> clientes1 = new ArrayList<Cliente>();
        clientes1.add(new Cliente("Juan", 001, Cliente.Afiliacion.ESTRELLA, "1234567"));
        clientes1.getFirst().setMesa(mesa1);
        mesa1.setClientes(clientes1);
        Restaurante.getClientes().add(clientes1.getFirst());

        clientes1.add(new Cliente("Pedro", 002, Cliente.Afiliacion.ESTRELLITA, "7654321"));
        clientes1.get(1).setMesa(mesa1);
        Restaurante.getClientes().add(clientes1.get(1));

        clientes1.add(new Cliente("María", 003, "9876543"));
        clientes1.get(2).setMesa(mesa1);
        Restaurante.getClientes().add(clientes1.get(2));

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
        clientes1.get(0).setFactura(factura1);
        clientes1.get(1).setFactura(factura2);
        clientes1.get(2).setFactura(factura3);

        //Creamos un restaurante de muestra
        Restaurante restauranteMuestra = new Restaurante(ciudad1, ciudad1.getZonas().get(0), true, "Muestra");
        ciudad1.getZonas().get(0).getRestaurantes().add(restauranteMuestra);

        //Creamos una disposición default para el restaurante de muestra
        ArrayList<ArrayList<String>> disposicion = new ArrayList<ArrayList<String>>();

        //B = Border/Pared, W = Window/Ventana, T = Standard Table/Mesa Estándar, V = VIP Table/Mesa VIP, E = Entrance/Entrada

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

        //Consultar con Colo como es esto
        Ciudad BOG = new Ciudad("BOGOTA");
        Ciudad MDE = new Ciudad("MEDELLIN");
        //Crear zonas BOGcy su respectivo restaurante
        Restaurante restaurante_usaquen = new Restaurante(100, "BuenaMesa Usaquen", reservasUsaquen);
        Zona usaquen_bog = new Zona(restaurante_usaquen, "Usaquén");

        Restaurante restaurante_funza = new Restaurante(30, "Pastas Funza");
        Zona funza_bog = new Zona(restaurante_funza, "Funza");

        Restaurante restaurante_chia = new Restaurante(10, "Chíaurante");
        Zona chia_bog = new Zona(restaurante_chia, "Chía");
        //Crear zonas MDE
        Zona laureles_mde = new Zona(1440, "Laureles");
        Zona estadio_mde = new Zona(1420, "Estadio");
        Zona moravia_mde = new Zona(10, "Moravia");
        //Agregar zonas a ciudades
        BOG.addZona(usaquen_bog);
        BOG.addZona(funza_bog);
        BOG.addZona(chia_bog);
        MDE.addZona(laureles_mde);
        MDE.addZona(estadio_mde);
        MDE.addZona(moravia_mde);
        //Agregar al ArrayList ciudades

        Reserva reserva1 = new Reserva(clientes1, new Date(2024, 7, 28, 8, 0));
//        Reserva reserva2 = new Reserva(clientes2, new Date(2024, 7, 29, 9, 0));
//        Reserva reserva3 = new Reserva(clientes3, new Date(2024, 7, 30, 10, 0));
        reservasUsaquen.add(reserva1);
//        reservasUsaquen.add(reserva2);
//        reservasUsaquen.add(reserva3);

        //Ingredientes Torta Pequeña Cumpleaños
        Ingrediente harinaTortaPequena = new Ingrediente("Harina", 5000);
        Ingrediente huevosTortaPequena = new Ingrediente("Huevos", 8);
        Ingrediente azucarTortaPequena = new Ingrediente("Azúcar", 1000);
        Ingrediente lecheTortaPequena = new Ingrediente("Leche", 2);
        ArrayList<Ingrediente> ingredientesTortaPequena = new ArrayList<Ingrediente>();
        ingredientesTortaPequena.add(harinaTortaPequena);
        ingredientesTortaPequena.add(huevosTortaPequena);
        ingredientesTortaPequena.add(azucarTortaPequena);
        ingredientesTortaPequena.add(lecheTortaPequena);

        //Ingredientes Torta Pequeña Cumpleaños
        Ingrediente harinaTORTAGRANDE = new Ingrediente("Harina", 15000);
        Ingrediente huevosTORTAGRANDE = new Ingrediente("Huevos", 20);
        Ingrediente azucarTORTAGRANDE = new Ingrediente("Azúcar", 3000);
        Ingrediente lecheTORTAGRANDE = new Ingrediente("Leche", 6);
        ArrayList<Ingrediente> ingredientesharinaTORTAGRANDE = new ArrayList<Ingrediente>();
        ingredientesharinaTORTAGRANDE.add(harinaTORTAGRANDE);
        ingredientesharinaTORTAGRANDE.add(huevosTORTAGRANDE);
        ingredientesharinaTORTAGRANDE.add(azucarTORTAGRANDE);
        ingredientesharinaTORTAGRANDE.add(lecheTORTAGRANDE);
        //Plato para cumpleaños Torta grande y pequeña
        Plato platoTortaPeq = new Plato("Torta Pequeña", 120000, ingredientesTortaPequena, 7, 4);
        Plato platoTortaGra = new Plato("Torta Grande", 300000, ingredientesharinaTORTAGRANDE, 20, 5);
        platosCumple.add(platoTortaGra);
        platosCumple.add(platoTortaPeq);
        Evento eventoCumple = new Evento("Cumpleanos Feliz", 210000, platosCumple);
        eventos.add(eventoCumple);

        //Vinos y Champañas
        Plato vinoCatena = new Plato("Vino Catena (Argentino)", 225000, 4, 5);
        Plato vinoSymington = new Plato("Vino  Symington (Portugal)", 180000, 4, 4);
        Plato vinoGenerico = new Plato("Vino Genérico ", 45000, 4, 10);
        Plato champanaRuinart = new Plato("Ruinart Blanc de Blancs", 400000, 5, 5);
        Plato champanaBollinger = new Plato("Bollinger Spécial Cuvée Brut", 360000, 5, 6);
        Plato champanaGenerica = new Plato("Champaña Genérica", 40000, 5, 10);

        vinos_champanas_meeting.add(vinoCatena);
        vinos_champanas_meeting.add(vinoSymington);
        vinos_champanas_meeting.add(vinoGenerico);
        vinos_champanas_meeting.add(champanaRuinart);
        vinos_champanas_meeting.add(champanaBollinger);
        vinos_champanas_meeting.add(champanaGenerica);

        Evento eventoMeeting = new Evento("Meetigns Empresarial", 450000, vinos_champanas_meeting);
        eventos.add(eventoMeeting);
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
                    reservarMesa();
                    break;
                case 2:
                    limpiarPantalla();
                    break;
                case 3:
                    limpiarPantalla();
                    dejarRestaurante();
                    encendido = false;
                    break;
                case 4:
                    limpiarPantalla();
                    Restaurante restaurante4 = agregarSede();
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