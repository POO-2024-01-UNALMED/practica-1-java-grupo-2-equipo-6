package uiMain;

import gestorAplicacion.Entorno.Ciudad;
import gestorAplicacion.Entorno.Mesa;
import gestorAplicacion.Gestion.*;
import gestorAplicacion.Entorno.Zona;
import gestorAplicacion.Usuario.Cliente;
import gestorAplicacion.Usuario.Trabajador;

import java.time.LocalDateTime;
import java.util.*;


import static uiMain.Funcionalidad1.reservarMesa;

import static uiMain.Funcionalidad2.*;

import static uiMain.Funcionalidad3.*;
import static uiMain.Funcionalidad4.*;
import static uiMain.Utilidad.*;

public class Main {
    static ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>(); //Lista de ciudades
    static ArrayList<Zona> zonas = new ArrayList<Zona>(); //Lista de zonas
    static ArrayList<Plato> platos = new ArrayList<Plato>(); //Lista de platos
    static ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>(); //Lista de ingredientes

    static Scanner input = new Scanner(System.in);
    static ArrayList<Reserva> reservasUsaquen = new ArrayList<Reserva>();
    static ArrayList<Reserva> reservasFunza = new ArrayList<Reserva>();
    static ArrayList<Reserva> reservasChia = new ArrayList<Reserva>();
    static ArrayList<Reserva> reservasLaureles = new ArrayList<Reserva>();
    static ArrayList<Reserva> reservasPoblado = new ArrayList<Reserva>();
    static ArrayList<Reserva> reservasEstadio = new ArrayList<Reserva>();
    static ArrayList<Reserva> reservasBocachica = new ArrayList<Reserva>();
    static ArrayList<Reserva> reservasPuertaDeOro = new ArrayList<Reserva>();
    static ArrayList<Reserva> reservasBaru = new ArrayList<Reserva>();
    static ArrayList<Plato> platosCumple = new ArrayList<Plato>(); //Lista de platos
    static ArrayList<Evento> eventos = new ArrayList<Evento>();
    static ArrayList<Plato> vinos_champanas_meeting = new ArrayList<Plato>();
    static ArrayList<Trabajador> cocineros = new ArrayList<Trabajador>();
    static ArrayList<Plato> platos_varios = new ArrayList<Plato>();
    static ArrayList<ArrayList<Plato>> platos_gastronomias = new ArrayList<ArrayList<Plato>>();
    static ArrayList<Plato> gastronomias_japonesa = new ArrayList<>();
    static ArrayList<Plato> gastronomias_italiana = new ArrayList<>();
    static ArrayList<Plato> gastronomias_marroqui = new ArrayList<>();
    static ArrayList<Plato> gastronomias_francesa = new ArrayList<>();
    static {
        //Creamos ciudades de muestra
        Ciudad ciudad1 = new Ciudad("Medellín");
        ciudades.add(ciudad1);
        Ciudad ciudad2 = new Ciudad("Bogotá");
        ciudades.add(ciudad2);

        //Creamos zonas de muestra
        zonas.add(new Zona(4378, "Robledo", ciudad1));
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
        Cliente cliente01 = new Cliente("Juan", 123, "Estrella", "1234567");
        Cliente cliente02 = new Cliente("Pedro", 456, "Estrellita", "7654321");
        Cliente cliente03 = new Cliente("María", 789, null, "9876543");

        Reserva reserva1 = new Reserva(cliente01, "Día 28/07/2024 Hora 8:00");
        Reserva reserva2 = new Reserva(cliente02, "Día 29/07/2024 Hora 9:00");
        Reserva reserva3 = new Reserva(cliente03, "Día 30/07/2024 Hora 10:00");

        reservasUsaquen.add(reserva1);
        reservasUsaquen.add(reserva2);
        reservasUsaquen.add(reserva3);

        //Clientes y reservas Funza
        Cliente cliente4 = new Cliente("Federico", 123, "Estrella", "1234567");
        Cliente cliente5 = new Cliente("Maximiliano", 456, "Estrellita", "7654321");
        Cliente cliente6 = new Cliente("Rodolfo", 789, null, "9876543");

        Reserva reserva4 = new Reserva(cliente4, "Día 29/07/2024 Hora 7:30");
        Reserva reserva5 = new Reserva(cliente5, "Día 29/07/2024 Hora 9:00");
        Reserva reserva6 = new Reserva(cliente6, "Día 39/07/2024 Hora 10:00");

        reservasFunza.add(reserva4);
        reservasFunza.add(reserva5);
        reservasFunza.add(reserva6);

        //Clientes y reservas Chia

        Cliente cliente7 = new Cliente("Federico", 123, "Estrella", "1234567");
        Cliente cliente8 = new Cliente("Maximiliano", 456, "Estrellita", "7654321");
        Cliente cliente9 = new Cliente("Rodolfo", 789, null, "9876543");

        Reserva reserva7 = new Reserva(cliente7, "Día 29/07/2024 Hora 7:30");
        Reserva reserva8 = new Reserva(cliente8, "Día 29/07/2024 Hora 9:00");
        Reserva reserva9 = new Reserva(cliente9, "Día 39/07/2024 Hora 10:00");

        reservasChia.add(reserva7);
        reservasChia.add(reserva8);
        reservasChia.add(reserva9);

        //Clientes y reservas Laureles

        Cliente cliente11 = new Cliente("Federico", 123, "Estrella", "1234567");
        Cliente cliente12 = new Cliente("Maximiliano", 456, "Estrellita", "7654321");
        Cliente cliente13 = new Cliente("Rodolfo", 789, null, "9876543");

        Reserva reserva11 = new Reserva(cliente11, "Día 29/07/2024 Hora 7:30");
        Reserva reserva12 = new Reserva(cliente12, "Día 29/07/2024 Hora 9:00");
        Reserva reserva13 = new Reserva(cliente13, "Día 39/07/2024 Hora 10:00");

        reservasLaureles.add(reserva11);
        reservasLaureles.add(reserva12);
        reservasLaureles.add(reserva13);

        //Clientes y reservas Estadio

        Cliente cliente14 = new Cliente("Federico", 123, "Estrella", "1234567");
        Cliente cliente15 = new Cliente("Maximiliano", 456, "Estrellita", "7654321");
        Cliente cliente16 = new Cliente("Rodolfo", 789, null, "9876543");

        Reserva reserva14 = new Reserva(cliente14, "Día 29/07/2024 Hora 7:30");
        Reserva reserva15 = new Reserva(cliente15, "Día 29/07/2024 Hora 9:00");
        Reserva reserva16 = new Reserva(cliente16, "Día 39/07/2024 Hora 10:00");

        reservasEstadio.add(reserva14);
        reservasEstadio.add(reserva15);
        reservasEstadio.add(reserva16);

        //Clientes y reservas Poblado

        Cliente cliente17 = new Cliente("Federico", 123, "Estrella", "1234567");
        Cliente cliente18 = new Cliente("Maximiliano", 456, "Estrellita", "7654321");
        Cliente cliente19 = new Cliente("Rodolfo", 789, null, "9876543");

        Reserva reserva17 = new Reserva(cliente17, "Día 29/07/2024 Hora 7:30");
        Reserva reserva18 = new Reserva(cliente18, "Día 29/07/2024 Hora 9:00");
        Reserva reserva19 = new Reserva(cliente19, "Día 39/07/2024 Hora 10:00");

        reservasPoblado.add(reserva19);
        reservasPoblado.add(reserva18);
        reservasPoblado.add(reserva17);

        //Reservas y clientes Bocachica

        Cliente cliente21 = new Cliente("Federico", 123, "Estrella", "1234567");
        Cliente cliente22 = new Cliente("Maximiliano", 456, "Estrellita", "7654321");
        Cliente cliente23 = new Cliente("Rodolfo", 789, null, "9876543");

        Reserva reserva21 = new Reserva(cliente21, "Día 29/07/2024 Hora 7:30");
        Reserva reserva22 = new Reserva(cliente22, "Día 29/07/2024 Hora 9:00");
        Reserva reserva23 = new Reserva(cliente23, "Día 39/07/2024 Hora 10:00");

        reservasBocachica.add(reserva21);
        reservasBocachica.add(reserva22);
        reservasBocachica.add(reserva23);

        //Reservas y clientes Puerta de Oro

        Cliente cliente25 = new Cliente("Federico", 123, "Estrella", "1234567");
        Cliente cliente26 = new Cliente("Maximiliano", 456, "Estrellita", "7654321");
        Cliente cliente27 = new Cliente("Rodolfo", 789, null, "9876543");

        Reserva reserva25 = new Reserva(cliente25, "Día 29/07/2024 Hora 7:30");
        Reserva reserva26 = new Reserva(cliente26, "Día 29/07/2024 Hora 9:00");
        Reserva reserva27 = new Reserva(cliente27, "Día 39/07/2024 Hora 10:00");

        reservasPuertaDeOro.add(reserva25);
        reservasPuertaDeOro.add(reserva26);
        reservasPuertaDeOro.add(reserva27);

        //Clientes y reservas Bura

        Cliente cliente33 = new Cliente("Federico", 123, "Estrella", "1234567");
        Cliente cliente44 = new Cliente("Maximiliano", 456, "Estrellita", "7654321");
        Cliente cliente55 = new Cliente("Rodolfo", 789, null, "9876543");

        Reserva reserva33 = new Reserva(cliente33, "Día 29/07/2024 Hora 7:30");
        Reserva reserva44 = new Reserva(cliente44, "Día 29/07/2024 Hora 9:00");
        Reserva reserva55 = new Reserva(cliente55, "Día 39/07/2024 Hora 10:00");

        reservasBaru.add(reserva44);
        reservasBaru.add(reserva55);
        reservasBaru.add(reserva33);

        /////////APARTADO BOGOTA/////////////
        //Crear ciudades
        Ciudad BOG = new Ciudad("BOGOTA");
        ciudades.add(BOG);
        //Crear zonas BOG y su respectivo restaurante
        Restaurante restaurante_usaquen = new Restaurante(100, "BuenaMesa Usaquen", reservasUsaquen);
        Zona usaquen_bog = new Zona(restaurante_usaquen, "Usaquén");

        Restaurante restaurante_funza = new Restaurante(30, "Pastas Funza", reservasFunza);
        Zona funza_bog = new Zona(restaurante_funza, "Funza");

        Restaurante restaurante_chia = new Restaurante(10, "Chíaurante", reservasChia);
        Zona chia_bog = new Zona(restaurante_chia, "Chía");

        BOG.agregarZonas(usaquen_bog);
        BOG.agregarZonas(funza_bog);
        BOG.agregarZonas(chia_bog);

        ///////////APARTADO MEDELLÍN////////
        Ciudad MDE = new Ciudad("MEDELLIN");
        ciudades.add(MDE);
        //Crear zonas  y restaurantes medellin MDE
        Restaurante restaurante_laureles = new Restaurante(56, "Laurel del Norte", reservasLaureles);
        Zona laureles_mde = new Zona(restaurante_laureles, "Laureles");
        Restaurante restaurante_estadio = new Restaurante(32, "DIM Delicias", reservasEstadio);
        Zona estadio_mde = new Zona(restaurante_estadio, "Estadio");
        Restaurante restaurante_poblado = new Restaurante(43, "Go home yanquis", reservasPoblado);
        Zona moravia_mde = new Zona(restaurante_poblado, "Poblado");
        //Agregar zonas a ciudades

        MDE.agregarZonas(laureles_mde);
        MDE.agregarZonas(estadio_mde);
        MDE.agregarZonas(moravia_mde);

        ////////////APARTADO CARTAGENA////////////
        Ciudad CAR = new Ciudad("CARTAGENA");
        ciudades.add(CAR);
        //Crear zonas  y restaurantes medellin MDE
        Restaurante restaurante_baru = new Restaurante(16, "El Diomedante", reservasBaru);
        Zona baru_car = new Zona(restaurante_baru, "Barú");
        Restaurante restaurante_PuertaDeOro = new Restaurante(24, "Puerta de Delicias", reservasPuertaDeOro);
        Zona PuertaDeOro_car = new Zona(restaurante_PuertaDeOro, "Puerta de Oro");
        Restaurante restaurante_Bocachica = new Restaurante(32, "Blas de Lazo", reservasBocachica);
        Zona bocachica_car = new Zona(restaurante_Bocachica, "Bocachica");
        //Agregar zonas a ciudades

        CAR.agregarZonas(baru_car);
        CAR.agregarZonas(bocachica_car);
        CAR.agregarZonas(PuertaDeOro_car);


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

        Trabajador trabajadorSonmerlier = new Trabajador("Evaristo", 12345, "Sonmerlier", 1300000);
        Trabajador trabajadorItaliano = new Trabajador("Mario Guissepe", 876543, "Italiana", 2300000);
        Trabajador trabajadorJapones = new Trabajador("Rika Miyuka", 575288, "Japonesa", 2300000);
        Trabajador trabajadorMarroqui = new Trabajador("Hakin Hasan Ibrahim", 8428257, "Marroquí", 2300000);
        Trabajador trabajadorFrances = new Trabajador("Emmanuel Macrom", 95175, "Francesa", 2300000);
        cocineros.add(trabajadorSonmerlier);
        cocineros.add(trabajadorItaliano);
        cocineros.add(trabajadorJapones);
        cocineros.add(trabajadorMarroqui);
        cocineros.add(trabajadorFrances);

        Plato bagget = new Plato("Bagget", 2000, 1, 100);
        Plato queso = new Plato("Queso mediterraneo", 50000, 7, 100);
        platos_varios.add(bagget);
        platos_varios.add(queso);

        //Platos Italianos
        Plato soppa_minestrone = new Plato("Sopa Minnestrone", 54000, 5, "Italiana");
        Plato ensalada_Caprese = new Plato("Ensalada Caprese", 35300, 8, "Italiana");
        Plato Carpaccio = new Plato("Carpaccio", 44000, 1, "Italiana");
        Plato Vitello_tonnatoe = new Plato("Vitello tonnatoe", 74000, 4, "Italiana");
        gastronomias_italiana.add(soppa_minestrone);
        gastronomias_italiana.add(ensalada_Caprese);
        gastronomias_italiana.add(Carpaccio);
        gastronomias_italiana.add(Vitello_tonnatoe);
        //Platos Japoneses
        Plato sushi = new Plato("Sushi Yarigato", 54000, 5, "Japonesa");
        Plato tempura = new Plato("Tempura Ora Ora", 35300, 8, "Japonesa");
        Plato katsudon = new Plato("Katsudon Primaveral", 44000, 3, "Japonesa");
        Plato kaisedon = new Plato("Kaisedon Hokkaido", 74000, 4, "Japonesa");
        gastronomias_japonesa.add(sushi);
        gastronomias_japonesa.add(tempura);
        gastronomias_japonesa.add(katsudon);
        gastronomias_japonesa.add(kaisedon);
        //Platos Marroquis
        Plato tajin = new Plato("Tajín Avepus", 54000, 5, "Marroquí");
        Plato cuscus = new Plato("Cuscús Adriático", 35300, 8, "Marroquí");
        Plato harira = new Plato("Harira Candente", 44000, 3, "Marroquí");
        Plato briouat = new Plato("Briouat Sur", 74000, 4, "Marroquí");
        gastronomias_marroqui.add(tajin);
        gastronomias_marroqui.add(cuscus);
        gastronomias_marroqui.add(harira);
        gastronomias_marroqui.add(briouat);
        //Platos Franceses
        Plato ratatouille = new Plato("Ratatouille Avignon", 54000, 5, "Francesa");
        Plato escargots = new Plato("Escargots D' Bourgogne", 35300, 8, "Francesa");
        Plato fricase = new Plato("Fricasé Le Mans", 44000, 1, "Francesa");
        Plato gratin = new Plato("Le gratin dauphinois", 74000, 1, "Francesa");
        gastronomias_francesa.add(ratatouille);
        gastronomias_francesa.add(escargots);
        gastronomias_francesa.add(fricase);
        gastronomias_francesa.add(gratin);
        platos_gastronomias.add(gastronomias_francesa);
        platos_gastronomias.add(gastronomias_italiana);
        platos_gastronomias.add(gastronomias_marroqui);
        platos_gastronomias.add(gastronomias_japonesa);

        platos_gastronomias.add(gastronomias_japonesa);
    }

    public static void main(String[] args) {
        //Insertar línea para deserializar
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
                    System.out.println("Funcionalidad 2.");
                    ordenarComida();
                    break;
                case 3:
                    limpiarPantalla();
                    dejarRestaurante();
                    break;
                case 4:
                    limpiarPantalla();
                    Restaurante restaurante4 = agregarSede();
                    restaurante4.actualizarFechasDisponibles();
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