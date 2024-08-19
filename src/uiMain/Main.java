package uiMain;

import gestorAplicacion.Entorno.Ciudad;
import gestorAplicacion.Entorno.Mesa;
import gestorAplicacion.Gestion.*;
import gestorAplicacion.Entorno.Zona;
import gestorAplicacion.Usuario.Cliente;
import gestorAplicacion.Usuario.Trabajador;

import java.util.*;


import static uiMain.Funcionalidad1.reservarMesa;

import static uiMain.Funcionalidad2.*;

import static uiMain.Funcionalidad3.*;
import static uiMain.Funcionalidad4.*;


public class Main implements Utilidad {
    static ArrayList<Reserva> reservasUsaquen = new ArrayList<Reserva>();

    static {
        //Creamos ciudades de muestra
        Ciudad ciudad1 = new Ciudad("Medellín");
        Ciudad.getCiudades().add(ciudad1);
        Ciudad ciudad2 = new Ciudad("Bogotá");
        Ciudad.getCiudades().add(ciudad2);

        //Creamos zonas de muestra
        Zona.getZonas().add(new Zona(4378, "Robledo", ciudad1));
        Zona.getZonas().add(new Zona(7426, "Aranjuez", ciudad1));
        Zona.getZonas().add(new Zona(193134, "Kennedy", ciudad2));

        //Agregamos las zonas creadas al array zonas de su respectiva ciudad
        for (Ciudad ciudad : Ciudad.getCiudades()) {
            for (Zona zona : Zona.getZonas()) {
                if (zona.getCiudad() == ciudad) {
                    ciudad.getZonasCiudad().add(zona);
                }
            }
        }
        Restaurante restaurante1 = new Restaurante(ciudad1, ciudad1.getZonasCiudad().getFirst(), true,
                "El Comecuernos");

        Mesa mesa1 = new Mesa(0, 0, 0, false, 4);
        restaurante1.agregarMesa(mesa1);
        mesa1.setRestaurante(restaurante1);
        ciudad1.getRestaurantes().add(restaurante1);
        ciudad1.getZonasCiudad().get(0).getRestaurantes().add(restaurante1);

        //Creamos clientes de muestra para la mesa 1
        ArrayList <Cliente> clientes1 = new ArrayList<Cliente>();
        clientes1.add(new Cliente("Juan", 001, Cliente.Afiliacion.ESTRELLA, "1234567"));
        clientes1.getFirst().setMesa(mesa1);
        mesa1.setClientes(clientes1);
        Cliente.getClientes().add(clientes1.getFirst());

        clientes1.add(new Cliente("Pedro", 002, Cliente.Afiliacion.ESTRELLITA, "7654321"));
        clientes1.get(1).setMesa(mesa1);
        Cliente.getClientes().add(clientes1.get(1));

        clientes1.add(new Cliente("María", 003, "9876543"));
        clientes1.get(2).setMesa(mesa1);
        Cliente.getClientes().add(clientes1.get(2));

        //Creamos ingredientes y cantidades necesarias de platos de muestra
//        Ingrediente Tomate = new Ingrediente("Tomate", 500);
//        Ingrediente Lechuga = new Ingrediente("Lechuga", 300);
//        HashMap <Ingrediente,Double> ingredientesEnsalada = new HashMap<Ingrediente,Double>();
//        ingredientesEnsalada.put(Lechuga,(double)1);
//        ingredientesEnsalada.put(Tomate,(double)1);
//        Plato Ensalada = new Plato("Ensalada", 19000, "Entrada",ingredientesEnsalada);
//
//        Ingrediente Carne = new Ingrediente("Carne", 1000);
//        Ingrediente Pan = new Ingrediente("Pan", 500);
//        HashMap <Ingrediente,Double> ingredientesHamburguesa = new HashMap<Ingrediente,Double>();
//        ingredientesHamburguesa.put(Tomate, (double) 1);
//        ingredientesHamburguesa.put(Carne, (double)1);
//        ingredientesHamburguesa.put(Pan,(double)2 );
//        Plato Hamburguesa = new Plato("Hamburguesa", 25000, "Plato fuerte", ingredientesHamburguesa );
//
//        Ingrediente Arroz = new Ingrediente("Arroz", 800);
//        Ingrediente Pollo = new Ingrediente("Pollo", 700);
//        HashMap <Ingrediente,Double> ingredientesArroz = new HashMap<Ingrediente,Double>();
//        ingredientesArroz.put(Arroz, (double)1);
//        ingredientesArroz.put(Pollo, (double)1);
//        Plato ArrozConPollo = new Plato("Arroz con pollo", 20000, "Plato fuerte", ingredientesArroz);

        //Creamos pedidos de muestra
        Pedido pedido1 = new Pedido();
        Pedido pedido2 = new Pedido();
        Pedido pedido3 = new Pedido();

//        pedido1.agregarPlato(Ensalada);
//        pedido2.agregarPlato(Hamburguesa);
//        pedido3.agregarPlato(ArrozConPollo);

        //Creamos facturas de muestra
        Factura factura1 = new Factura(pedido1, "Efectivo", false, 0);
        Factura factura2 = new Factura(pedido2, "Tarjeta", false, 0);
        Factura factura3 = new Factura(pedido3, "Efectivo", false, 0);
        clientes1.get(0).setFactura(factura1);
        clientes1.get(1).setFactura(factura2);
        clientes1.get(2).setFactura(factura3);

        //Creamos un restaurante de muestra
        Restaurante restauranteMuestra = new Restaurante(ciudad1, ciudad1.getZonasCiudad().get(0), true, "Muestra");
        ciudad1.getZonasCiudad().get(0).getRestaurantes().add(restauranteMuestra);

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
        restauranteMuestra.setCapacidad(1234);

//Resolver lo de las reservas con el patrón, va a estar comentado
//        /////////APARTADO BOGOTA/////////////
//        //Crear ciudades
//        Ciudad BOG = new Ciudad("BOGOTA");
//        ciudades.add(BOG);
//        //Crear zonas BOG y su respectivo restaurante
//        Restaurante restaurante_usaquen = new Restaurante(100, "BuenaMesa Usaquen", reservasUsaquen);
//        Zona usaquen_bog = new Zona(restaurante_usaquen, "Usaquén");
//
//        Restaurante restaurante_funza = new Restaurante(30, "Pastas Funza", reservasFunza);
//        Zona funza_bog = new Zona(restaurante_funza, "Funza");
//
//        Restaurante restaurante_chia = new Restaurante(10, "Chíaurante", reservasChia);
//        Zona chia_bog = new Zona(restaurante_chia, "Chía");
//
//        BOG.agregarZonas(usaquen_bog);
//        BOG.agregarZonas(funza_bog);
//        BOG.agregarZonas(chia_bog);
//
//        ///////////APARTADO MEDELLÍN////////
//        Ciudad MDE = new Ciudad("MEDELLIN");
//        ciudades.add(MDE);
//        //Crear zonas  y restaurantes medellin MDE
//        Restaurante restaurante_laureles = new Restaurante(56, "Laurel del Norte", reservasLaureles);
//        Zona laureles_mde = new Zona(restaurante_laureles, "Laureles");
//        Restaurante restaurante_estadio = new Restaurante(32, "DIM Delicias", reservasEstadio);
//        Zona estadio_mde = new Zona(restaurante_estadio, "Estadio");
//        Restaurante restaurante_poblado = new Restaurante(43, "Go home yanquis", reservasPoblado);
//        Zona moravia_mde = new Zona(restaurante_poblado, "Poblado");
//        //Agregar zonas a ciudades
//
//        MDE.agregarZonas(laureles_mde);
//        MDE.agregarZonas(estadio_mde);
//        MDE.agregarZonas(moravia_mde);
//
//        ////////////APARTADO CARTAGENA////////////
//        Ciudad CAR = new Ciudad("CARTAGENA");
//        ciudades.add(CAR);
//        //Crear zonas  y restaurantes medellin MDE
//        Restaurante restaurante_baru = new Restaurante(16, "El Diomedante", reservasBaru);
//        Zona baru_car = new Zona(restaurante_baru, "Barú");
//        Restaurante restaurante_PuertaDeOro = new Restaurante(24, "Puerta de Delicias", reservasPuertaDeOro);
//        Zona PuertaDeOro_car = new Zona(restaurante_PuertaDeOro, "Puerta de Oro");
//        Restaurante restaurante_Bocachica = new Restaurante(32, "Blas de Lazo", reservasBocachica);
//        Zona bocachica_car = new Zona(restaurante_Bocachica, "Bocachica");
//        //Agregar zonas a ciudades
//
//        CAR.agregarZonas(baru_car);
//        CAR.agregarZonas(bocachica_car);
//        CAR.agregarZonas(PuertaDeOro_car);

        //Hasta acá discutir con Colorado
        //Agregar al ArrayList ciudades
        ArrayList<Integer> fechaReserva1 = new ArrayList<Integer>();
        fechaReserva1.add(2024);
        fechaReserva1.add(7);
        fechaReserva1.add(28);
        fechaReserva1.add(8);
        Reserva reserva1 = new Reserva(clientes1, fechaReserva1);
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
        Plato.getPlatosCumple().add(platoTortaGra);
        Plato.getPlatosCumple().add(platoTortaPeq);
        Evento eventoCumple = new Evento("Cumpleanos Feliz", 210000, Plato.getPlatosCumple());
        Evento.getEventos().add(eventoCumple);

        //Vinos y Champañas
        Plato vinoCatena = new Plato("Vino Catena (Argentino)", 225000, 4, 5);
        Plato vinoSymington = new Plato("Vino  Symington (Portugal)", 180000, 4, 4);
        Plato vinoGenerico = new Plato("Vino Genérico ", 45000, 4, 10);
        Plato champanaRuinart = new Plato("Ruinart Blanc de Blancs", 400000, 5, 5);
        Plato champanaBollinger = new Plato("Bollinger Spécial Cuvée Brut", 360000, 5, 6);
        Plato champanaGenerica = new Plato("Champaña Genérica", 40000, 5, 10);

        Plato.getVinos_champanas_meeting().add(vinoCatena);
        Plato.getVinos_champanas_meeting().add(vinoSymington);
        Plato.getVinos_champanas_meeting().add(vinoGenerico);
        Plato.getVinos_champanas_meeting().add(champanaRuinart);
        Plato.getVinos_champanas_meeting().add(champanaBollinger);
        Plato.getVinos_champanas_meeting().add(champanaGenerica);

        Evento eventoMeeting = new Evento("Meetigns Empresarial", 450000, Plato.getVinos_champanas_meeting());
        Evento.getEventos().add(eventoMeeting);
        Trabajador trabajadorSonmerlier = new Trabajador("Evaristo", 12345, "Sonmerlier", 1300000);
        Trabajador trabajadorItaliano = new Trabajador("Mario Guissepe", 876543, "Italiana", 2300000);
        Trabajador trabajadorJapones = new Trabajador("Rika Miyuka", 575288, "Japonesa", 2300000);
        Trabajador trabajadorMarroqui = new Trabajador("Hakin Hasan Ibrahim", 8428257, "Marroquí", 2300000);
        Trabajador trabajadorFrances = new Trabajador("Emmanuel Macrom", 95175, "Francesa", 2300000);
        Trabajador.getCocineros().add(trabajadorSonmerlier);
        Trabajador.getCocineros().add(trabajadorItaliano);
        Trabajador.getCocineros().add(trabajadorJapones);
        Trabajador.getCocineros().add(trabajadorMarroqui);
        Trabajador.getCocineros().add(trabajadorFrances);
        Plato bagget = new Plato("Bagget", 2000,  100, "Meetings");
        Plato queso = new Plato("Queso mediterraneo", 50000,  100, "Meetings");
        Plato mochi = new Plato("Mochi", 4300,  100, "Japonesa");
        Plato postreNapolitano = new Plato("PostreNapolitano", 4300,  100, "Italiana");
        Plato magrud = new Plato("Maqrud", 4300,  100, "Marroquí");
        Plato macarons = new Plato("Macarons", 4300,  100, "Francesa");
        Plato.getPlatos_varios().add(bagget);
        Plato.getPlatos_varios().add(queso);
        Plato.getPlatos_varios().add(mochi);
        Plato.getPlatos_varios().add(postreNapolitano);
        Plato.getPlatos_varios().add(magrud);
        Plato.getPlatos_varios().add(macarons);
        Plato soppa_minestrone = new Plato("Sopa Minnestrone", 54000, 5, "Italiana");
        Plato ensalada_Caprese = new Plato("Ensalada Caprese", 35300, 8, "Italiana");
        Plato Carpaccio = new Plato("Carpaccio", 44000, 1, "Italiana");
        Plato Vitello_tonnatoe = new Plato("Vitello tonnatoe", 74000, 4, "Italiana");
        Plato.getGastronomias_italiana().add(soppa_minestrone);
        Plato.getGastronomias_italiana().add(ensalada_Caprese);
        Plato.getGastronomias_italiana().add(Carpaccio);
        Plato.getGastronomias_italiana().add(Vitello_tonnatoe);
        Plato sushi = new Plato("Sushi Yarigato", 54000, 5, "Japonesa");
        Plato tempura = new Plato("Tempura Ora Ora", 35300, 8, "Japonesa");
        Plato katsudon = new Plato("Katsudon Primaveral", 44000, 3, "Japonesa");
        Plato kaisedon = new Plato("Kaisedon Hokkaido", 74000, 4, "Japonesa");
        Plato.getGastronomias_japonesa().add(sushi);
        Plato.getGastronomias_japonesa().add(tempura);
        Plato.getGastronomias_japonesa().add(katsudon);
        Plato.getGastronomias_japonesa().add(kaisedon);
        Plato tajin = new Plato("Tajín Avepus", 54000, 5, "Marroquí");
        Plato cuscus = new Plato("Cuscús Adriático", 35300, 8, "Marroquí");
        Plato harira = new Plato("Harira Candente", 44000, 3, "Marroquí");
        Plato briouat = new Plato("Briouat Sur", 74000, 4, "Marroquí");
        Plato.getGastronomias_marroqui().add(tajin);
        Plato.getGastronomias_marroqui().add(cuscus);
        Plato.getGastronomias_marroqui().add(harira);
        Plato.getGastronomias_marroqui().add(briouat);
        Plato ratatouille = new Plato("Ratatouille Avignon", 54000, 5, "Francesa");
        Plato escargots = new Plato("Escargots D' Bourgogne", 35300, 8, "Francesa");
        Plato fricase = new Plato("Fricasé Le Mans", 44000, 1, "Francesa");
        Plato gratin = new Plato("Le gratin dauphinois", 74000, 1, "Francesa");
        Plato.getGastronomias_francesa().add(ratatouille);
        Plato.getGastronomias_francesa().add(escargots);
        Plato.getGastronomias_francesa().add(fricase);
        Plato.getGastronomias_francesa().add(gratin);
        Plato.getPlatos_gastronomias().add(Plato.getGastronomias_francesa());
        Plato.getPlatos_gastronomias().add(Plato.getGastronomias_italiana());
        Plato.getPlatos_gastronomias().add(Plato.getGastronomias_marroqui());
        Plato.getPlatos_gastronomias().add(Plato.getGastronomias_japonesa());
        Plato.getPlatos_gastronomias().add(Plato.getGastronomias_japonesa());

    }

    public static void main(String[] args) {
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
                    6. Salir.
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