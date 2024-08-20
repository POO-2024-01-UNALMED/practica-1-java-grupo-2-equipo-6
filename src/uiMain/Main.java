/*
Clase dirigida a permitir la interacción del usuario con el sistema desarrollado.

Main.java desarrollado por:
Juan José Arango Marín
Samuel Colorado Castrillón
Stiven Saldarriaga Mayorga
 */

package uiMain;

import baseDatos.Deserializador;
import baseDatos.Serializador;

import gestorAplicacion.Entorno.Casilla;
import gestorAplicacion.Entorno.Ciudad;
import gestorAplicacion.Entorno.Mesa;
import gestorAplicacion.Entorno.Zona;
import gestorAplicacion.Gestion.*;
import gestorAplicacion.Usuario.Cliente;
import gestorAplicacion.Usuario.Trabajador;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main implements Utilidad {

    public static void main(String[] args) {
//        Ciudad ciudad1 = new Ciudad("Medellín");
//        ciudad1.getZonasCiudad().add(new Zona(4378, "Robledo", ciudad1));
//        Restaurante restauranteMuestra = new Restaurante(ciudad1, ciudad1.getZonasCiudad().getFirst(), true, "POO");
//        ciudad1.getZonasCiudad().get(0).getRestaurantes().add(restauranteMuestra);
//        ciudad1.getRestaurantes().add(restauranteMuestra);
//        ArrayList<ArrayList<String>> disposicion = new ArrayList<ArrayList<String>>();
//
//        disposicion.add(new ArrayList(Arrays.asList(
//                new String[]{"╔", "═", "╦", "╗", "║", "╠", "╬", "╣", "╚", "╩", "╝", " "})));
//        disposicion.add(new ArrayList(Arrays.asList(
//                new String[]{"B", "B", "B", "B", "B", "B", "B", "B", "B", "B"})));
//        disposicion.add(new ArrayList(Arrays.asList(
//                new String[]{"B", " ", "V", " ", "V", " ", "V", " ", "V", "B"})));
//        disposicion.add(new ArrayList(Arrays.asList(
//                new String[]{"W", " ", " ", " ", " ", " ", " ", " ", " ", "W"})));
//        disposicion.add(new ArrayList(Arrays.asList(
//                new String[]{"B", " ", "T", " ", "T", " ", "T", " ", "T", "B"})));
//        disposicion.add(new ArrayList(Arrays.asList(
//                new String[]{"B", " ", " ", " ", " ", " ", " ", " ", " ", "B"})));
//        disposicion.add(new ArrayList(Arrays.asList(
//                new String[]{"B", " ", "T", " ", "T", " ", "T", " ", " ", "B"})));
//        disposicion.add(new ArrayList(Arrays.asList(
//                new String[]{"B", " ", " ", " ", " ", " ", " ", " ", " ", "B"})));
//        disposicion.add(new ArrayList(Arrays.asList(
//                new String[]{"W", " ", "T", " ", "T", " ", "T", " ", " ", "W"})));
//        disposicion.add(new ArrayList(Arrays.asList(
//                new String[]{"B", " ", " ", " ", " ", " ", " ", " ", " ", "B"})));
//        disposicion.add(new ArrayList(Arrays.asList(
//                new String[]{"B", "B", "B", "B", "B", "B", "B", "E", "B", "B"})));
//
//        restauranteMuestra.setDisposicion(disposicion);
//        restauranteMuestra.setCapacidad(1234);
//        //mesas
//        Mesa mesa1 = new Mesa(0, 3, 2, true, 4);
//        mesa1.setRestaurante(restauranteMuestra);
//        restauranteMuestra.getCasillas().add(mesa1);
//        restauranteMuestra.getMesas().add(mesa1);
//
//        Mesa mesa2 = new Mesa(0, 5, 2, true, 4);
//        mesa2.setRestaurante(restauranteMuestra);
//        restauranteMuestra.getCasillas().add(mesa2);
//        restauranteMuestra.getMesas().add(mesa2);
//
//        Mesa mesa3 = new Mesa(0, 7, 2, true, 4);
//        mesa3.setRestaurante(restauranteMuestra);
//        restauranteMuestra.getCasillas().add(mesa3);
//        restauranteMuestra.getMesas().add(mesa3);
//
//        Mesa mesa4 = new Mesa(0, 9, 2, true, 4);
//        mesa4.setRestaurante(restauranteMuestra);
//        restauranteMuestra.getCasillas().add(mesa4);
//        restauranteMuestra.getMesas().add(mesa4);
//
//        Mesa mesa5 = new Mesa(0, 3, 4, false, 4);
//        mesa5.setRestaurante(restauranteMuestra);
//        restauranteMuestra.getCasillas().add(mesa5);
//        restauranteMuestra.getMesas().add(mesa5);
//
//        Mesa mesa6 = new Mesa(0, 5, 4, false, 4);
//        mesa6.setRestaurante(restauranteMuestra);
//        restauranteMuestra.getCasillas().add(mesa6);
//        restauranteMuestra.getMesas().add(mesa6);
//
//        Mesa mesa7 = new Mesa(0, 7, 4, false, 4);
//        mesa7.setRestaurante(restauranteMuestra);
//        restauranteMuestra.getCasillas().add(mesa7);
//        restauranteMuestra.getMesas().add(mesa7);
//
//        Mesa mesa8 = new Mesa(0, 9, 4, false, 4);
//        mesa8.setRestaurante(restauranteMuestra);
//        restauranteMuestra.getCasillas().add(mesa8);
//        restauranteMuestra.getMesas().add(mesa8);
//
//        Mesa mesa9 = new Mesa(0, 3, 6, false, 4);
//        mesa9.setRestaurante(restauranteMuestra);
//        restauranteMuestra.getCasillas().add(mesa9);
//        restauranteMuestra.getMesas().add(mesa9);
//
//        Mesa mesa10 = new Mesa(0, 5, 6, false, 4);
//        mesa10.setRestaurante(restauranteMuestra);
//        restauranteMuestra.getCasillas().add(mesa10);
//        restauranteMuestra.getMesas().add(mesa10);
//
//        Mesa mesa11 = new Mesa(0, 7, 6, false, 4);
//        mesa11.setRestaurante(restauranteMuestra);
//        restauranteMuestra.getCasillas().add(mesa11);
//        restauranteMuestra.getMesas().add(mesa11);
//        Mesa mesa12 = new Mesa(0, 3, 8, false, 4);
//        mesa12.setRestaurante(restauranteMuestra);
//        restauranteMuestra.getCasillas().add(mesa12);
//        restauranteMuestra.getMesas().add(mesa12);
//
//        Mesa mesa13 = new Mesa(0, 5, 8, false, 4);
//        mesa13.setRestaurante(restauranteMuestra);
//        restauranteMuestra.getCasillas().add(mesa13);
//        restauranteMuestra.getMesas().add(mesa13);
//
//        Mesa mesa14 = new Mesa(0, 7, 8, false, 4);
//        mesa14.setRestaurante(restauranteMuestra);
//        restauranteMuestra.getCasillas().add(mesa14);
//        restauranteMuestra.getMesas().add(mesa14);
//
//        //casillas
//        Casilla casilla1 = new Casilla(1, 1, 3);
//        restauranteMuestra.getCasillas().add(casilla1);
//        Casilla casilla2 = new Casilla(1, 1, 8);
//        restauranteMuestra.getCasillas().add(casilla2);
//        Casilla casilla3 = new Casilla(1, 10, 3);
//        restauranteMuestra.getCasillas().add(casilla3);
//        Casilla casilla4 = new Casilla(1, 10, 8);
//        restauranteMuestra.getCasillas().add(casilla4);
//        Casilla casilla5 = new Casilla(2, 8, 10);
//        restauranteMuestra.getCasillas().add(casilla5);
//
//        //clientes
//        ArrayList<Cliente> clientes1 = new ArrayList<Cliente>();
//        clientes1.add(new Cliente("Juan", 001, Cliente.Afiliacion.ESTRELLA, "1234567"));
//        clientes1.getFirst().setMesa(mesa1);
//        mesa1.setClientes(clientes1);
//        Cliente.getClientes().add(clientes1.getFirst());
//        restauranteMuestra.getClientes().addAll(clientes1);
//
//        clientes1.add(new Cliente("Pedro", 002, Cliente.Afiliacion.ESTRELLITA, "7654321"));
//        clientes1.get(1).setMesa(mesa1);
//        Cliente.getClientes().add(clientes1.get(1));
//
//        clientes1.add(new Cliente("María", 003, "9876543"));
//        clientes1.get(2).setMesa(mesa1);
//        Cliente.getClientes().add(clientes1.get(2));
//
//        Ingrediente tomate = new Ingrediente("Tomate", 300);
//        Ingrediente harina = new Ingrediente("Harina", 300);
//        Ingrediente carne = new Ingrediente("Carne", 300);
//        Ingrediente pan = new Ingrediente("Pan", 300);
//        Ingrediente chocolate = new Ingrediente("Chocolate", 300);
//        Ingrediente vainilla = new Ingrediente("Vainilla", 300);
//        Ingrediente aguaNegra = new Ingrediente("Agua Negra", 300);
//        Ingrediente mora = new Ingrediente("Mora", 300);
//
//        Plato ensalada = new Plato("Ensalada", 19000, 5, "Entrada");
//        ArrayList<Ingrediente> ingredientesEnsalada = new ArrayList<Ingrediente>();
//        ingredientesEnsalada.add(tomate);
//        ensalada.setIngredientes(ingredientesEnsalada);
//        ensalada.getCantidadIngredientes().add(new ArrayList<String>(Arrays.asList("Tomate", "2")));
//        ensalada.setCalificacion(3);
//        restauranteMuestra.getMenu().add(ensalada);
//
//        Plato nachos = new Plato("Nachos", 15000, 5, "Entrada");
//        ArrayList<Ingrediente> ingredientesNachos = new ArrayList<Ingrediente>();
//        ingredientesNachos.add(harina);
//        nachos.setIngredientes(ingredientesNachos);
//        nachos.getCantidadIngredientes().add(new ArrayList<String>(Arrays.asList("Harina", "2")));
//        nachos.setCalificacion(4.7);
//        restauranteMuestra.getMenu().add(nachos);
//
//        Plato empanadas = new Plato("Empanadas", 10000, 5, "Entrada");
//        ArrayList<Ingrediente> ingredientesEmpanadas = new ArrayList<Ingrediente>();
//        ingredientesEmpanadas.add(harina);
//        empanadas.setIngredientes(ingredientesEmpanadas);
//        empanadas.getCantidadIngredientes().add(new ArrayList<String>(Arrays.asList("Harina", "2")));
//        empanadas.setCalificacion(4);
//        restauranteMuestra.getMenu().add(empanadas);
//
//        Plato hamburguesa = new Plato("Hamburguesa", 20000, 5, "Plato fuerte");
//        ArrayList<Ingrediente> ingredientesHamburguesa = new ArrayList<Ingrediente>();
//        ingredientesHamburguesa.add(carne);
//        hamburguesa.setIngredientes(ingredientesHamburguesa);
//        hamburguesa.getCantidadIngredientes().add(new ArrayList<String>(Arrays.asList("Carne", "2")));
//        hamburguesa.setCalificacion(4);
//        restauranteMuestra.getMenu().add(hamburguesa);
//
//        Plato pizza = new Plato("Pizza", 25000, 5, "Plato fuerte");
//        ArrayList<Ingrediente> ingredientesPizza = new ArrayList<Ingrediente>();
//        ingredientesPizza.add(pan);
//        pizza.setIngredientes(ingredientesPizza);
//        pizza.getCantidadIngredientes().add(new ArrayList<String>(Arrays.asList("Pan", "2")));
//        pizza.setCalificacion(5);
//        restauranteMuestra.getMenu().add(pizza);
//
//        Plato helado = new Plato("Helado", 5000, 5, "Postre");
//        ArrayList<Ingrediente> ingredientesHelado = new ArrayList<Ingrediente>();
//        ingredientesHelado.add(chocolate);
//        helado.setIngredientes(ingredientesHelado);
//        helado.getCantidadIngredientes().add(new ArrayList<String>(Arrays.asList("Chocolate", "2")));
//        helado.setCalificacion(5);
//        restauranteMuestra.getMenu().add(helado);
//
//        Plato torta = new Plato("Torta", 10000, 5, "Postre");
//        ArrayList<Ingrediente> ingredientesTorta = new ArrayList<Ingrediente>();
//        ingredientesTorta.add(vainilla);
//        torta.setIngredientes(ingredientesTorta);
//        torta.getCantidadIngredientes().add(new ArrayList<String>(Arrays.asList("Vainilla", "2")));
//        torta.setCalificacion(4);
//        restauranteMuestra.getMenu().add(torta);
//
//        Plato cajitaFeliz = new Plato("Cajita Feliz", 15000, 5, "Infantil");
//        ArrayList<Ingrediente> ingredientesCajitaFeliz = new ArrayList<Ingrediente>();
//        ingredientesCajitaFeliz.add(pan);
//        cajitaFeliz.setIngredientes(ingredientesCajitaFeliz);
//        cajitaFeliz.getCantidadIngredientes().add(new ArrayList<String>(Arrays.asList("Pan", "2")));
//        cajitaFeliz.setCalificacion(5);
//        restauranteMuestra.getMenu().add(cajitaFeliz);
//
//        Plato cocacola = new Plato("Cocacola", 3000, 5, "Bebida");
//        ArrayList<Ingrediente> ingredientesCocacola = new ArrayList<Ingrediente>();
//        ingredientesCocacola.add(aguaNegra);
//        cocacola.setIngredientes(ingredientesCocacola);
//        cocacola.getCantidadIngredientes().add(new ArrayList<String>(Arrays.asList("Agua Negra", "2")));
//        cocacola.setCalificacion(5);
//        restauranteMuestra.getMenu().add(cocacola);
//
//        Plato jugo = new Plato("Jugo", 2000, 5, "Bebida");
//        ArrayList<Ingrediente> ingredientesJugo = new ArrayList<Ingrediente>();
//        ingredientesJugo.add(mora);
//        jugo.setIngredientes(ingredientesJugo);
//        jugo.getCantidadIngredientes().add(new ArrayList<String>(Arrays.asList("Mora", "2")));
//        jugo.setCalificacion(4);
//        restauranteMuestra.getMenu().add(jugo);
//
//        Pedido pedido1 = new Pedido(clientes1.getFirst(), restauranteMuestra);
//        Pedido pedido2 = new Pedido(clientes1.get(1), restauranteMuestra);
//        Pedido pedido3 = new Pedido(clientes1.get(2), restauranteMuestra);
//
//        pedido1.agregarPlato(ensalada);
//        pedido2.agregarPlato(nachos);
//        pedido3.agregarPlato(empanadas);
//
//
//        Factura factura1 = new Factura(pedido1);
//        Factura factura2 = new Factura(pedido2);
//        Factura factura3 = new Factura(pedido3);
//
//        clientes1.get(0).setFactura(factura1);
//        clientes1.get(1).setFactura(factura2);
//        clientes1.get(2).setFactura(factura3);
//
//        ArrayList<Integer> fechaReserva1 = new ArrayList<Integer>();
//        fechaReserva1.add(2024);
//        fechaReserva1.add(7);
//        fechaReserva1.add(28);
//        fechaReserva1.add(8);
//        Reserva reserva1 = new Reserva(clientes1, fechaReserva1);
//
//        //Ingredientes Torta Pequeña Cumpleaños
//        Ingrediente harinaTortaPequena = new Ingrediente("Harina", 5000);
//        Ingrediente huevosTortaPequena = new Ingrediente("Huevos", 8);
//        Ingrediente azucarTortaPequena = new Ingrediente("Azúcar", 1000);
//        Ingrediente lecheTortaPequena = new Ingrediente("Leche", 2);
//        ArrayList<Ingrediente> ingredientesTortaPequena = new ArrayList<Ingrediente>();
//        ingredientesTortaPequena.add(harinaTortaPequena);
//        ingredientesTortaPequena.add(huevosTortaPequena);
//        ingredientesTortaPequena.add(azucarTortaPequena);
//        ingredientesTortaPequena.add(lecheTortaPequena);
//
//        //Ingredientes Torta Pequeña Cumpleaños
//        ArrayList<Ingrediente> ingredientesharinaTORTAGRANDE = new ArrayList<Ingrediente>();
//        ingredientesharinaTORTAGRANDE.add(harinaTortaPequena);
//        ingredientesharinaTORTAGRANDE.add(huevosTortaPequena);
//        ingredientesharinaTORTAGRANDE.add(azucarTortaPequena);
//        ingredientesharinaTORTAGRANDE.add(lecheTortaPequena);
//        //Plato para cumpleaños Torta grande y pequeña
//        Plato platoTortaPeq = new Plato("Torta Pequeña", 120000, ingredientesTortaPequena, 7, 4);
//        Plato platoTortaGra = new Plato("Torta Grande", 300000, ingredientesharinaTORTAGRANDE, 20, 5);
//        Plato.getPlatosCumple().add(platoTortaGra);
//        Plato.getPlatosCumple().add(platoTortaPeq);
//        Evento eventoCumple = new Evento("Cumpleanos Feliz", 210000, Plato.getPlatosCumple());
//        Evento.getEventos().add(eventoCumple);
//
//        //Vinos y Champañas
//        Plato vinoCatena = new Plato("Vino Catena (Argentino)", 225000, 4, 5);
//        Plato vinoSymington = new Plato("Vino  Symington (Portugal)", 180000, 4, 4);
//        Plato vinoGenerico = new Plato("Vino Genérico ", 45000, 4, 10);
//        Plato champanaRuinart = new Plato("Ruinart Blanc de Blancs", 400000, 5, 5);
//        Plato champanaBollinger = new Plato("Bollinger Spécial Cuvée Brut", 360000, 5, 6);
//        Plato champanaGenerica = new Plato("Champaña Genérica", 40000, 5, 10);
//
//        Plato.getVinos_champanas_meeting().add(vinoCatena);
//        Plato.getVinos_champanas_meeting().add(vinoSymington);
//        Plato.getVinos_champanas_meeting().add(vinoGenerico);
//        Plato.getVinos_champanas_meeting().add(champanaRuinart);
//        Plato.getVinos_champanas_meeting().add(champanaBollinger);
//        Plato.getVinos_champanas_meeting().add(champanaGenerica);
//
//        Evento eventoMeeting = new Evento("Meetings Empresarial", 450000, Plato.getVinos_champanas_meeting());
//        Evento.getEventos().add(eventoMeeting);
//        Trabajador trabajadorSonmerlier = new Trabajador("Evaristo", 12345, "Sommelier", 1300000);
//        Trabajador trabajadorItaliano = new Trabajador("Mario Guissepe", 876543, "Italiana", 2300000);
//        Trabajador trabajadorJapones = new Trabajador("Rika Miyuka", 575288, "Japonesa", 2300000);
//        Trabajador trabajadorMarroqui = new Trabajador("Hakin Hasan Ibrahim", 8428257, "Marroquí", 2300000);
//        Trabajador trabajadorFrances = new Trabajador("Emmanuel Macrom", 95175, "Francesa", 2300000);
//        Trabajador.getCocineros().add(trabajadorSonmerlier);
//        Trabajador.getCocineros().add(trabajadorItaliano);
//        Trabajador.getCocineros().add(trabajadorJapones);
//        Trabajador.getCocineros().add(trabajadorMarroqui);
//        Trabajador.getCocineros().add(trabajadorFrances);
//        Plato bagget = new Plato("Bagget", 2000, 100, "Meetings");
//        Plato queso = new Plato("Queso mediterraneo", 50000, 100, "Meetings");
//        Plato mochi = new Plato("Mochi", 4300, 100, "Japonesa");
//        Plato postreNapolitano = new Plato("PostreNapolitano", 4300, 100, "Italiana");
//        Plato magrud = new Plato("Maqrud", 4300, 100, "Marroquí");
//        Plato macarons = new Plato("Macarons", 4300, 100, "Francesa");
//        Plato.getPlatos_varios().add(bagget);
//        Plato.getPlatos_varios().add(queso);
//        Plato.getPlatos_varios().add(mochi);
//        Plato.getPlatos_varios().add(postreNapolitano);
//        Plato.getPlatos_varios().add(magrud);
//        Plato.getPlatos_varios().add(macarons);
//        Plato soppa_minestrone = new Plato("Sopa Minnestrone", 54000, 5, "Italiana");
//        Plato ensalada_Caprese = new Plato("Ensalada Caprese", 35300, 8, "Italiana");
//        Plato Carpaccio = new Plato("Carpaccio", 44000, 1, "Italiana");
//        Plato Vitello_tonnatoe = new Plato("Vitello tonnatoe", 74000, 4, "Italiana");
//        Plato.getGastronomias_italiana().add(soppa_minestrone);
//        Plato.getGastronomias_italiana().add(ensalada_Caprese);
//        Plato.getGastronomias_italiana().add(Carpaccio);
//        Plato.getGastronomias_italiana().add(Vitello_tonnatoe);
//        Plato sushi = new Plato("Sushi Yarigato", 54000, 5, "Japonesa");
//        Plato tempura = new Plato("Tempura Ora Ora", 35300, 8, "Japonesa");
//        Plato katsudon = new Plato("Katsudon Primaveral", 44000, 3, "Japonesa");
//        Plato kaisedon = new Plato("Kaisedon Hokkaido", 74000, 4, "Japonesa");
//        Plato.getGastronomias_japonesa().add(sushi);
//        Plato.getGastronomias_japonesa().add(tempura);
//        Plato.getGastronomias_japonesa().add(katsudon);
//        Plato.getGastronomias_japonesa().add(kaisedon);
//        Plato tajin = new Plato("Tajín Avepus", 54000, 5, "Marroquí");
//        Plato cuscus = new Plato("Cuscús Adriático", 35300, 8, "Marroquí");
//        Plato harira = new Plato("Harira Candente", 44000, 3, "Marroquí");
//        Plato briouat = new Plato("Briouat Sur", 74000, 4, "Marroquí");
//        Plato.getGastronomias_marroqui().add(tajin);
//        Plato.getGastronomias_marroqui().add(cuscus);
//        Plato.getGastronomias_marroqui().add(harira);
//        Plato.getGastronomias_marroqui().add(briouat);
//        Plato ratatouille = new Plato("Ratatouille Avignon", 54000, 5, "Francesa");
//        Plato escargots = new Plato("Escargots D' Bourgogne", 35300, 8, "Francesa");
//        Plato fricase = new Plato("Fricasé Le Mans", 44000, 1, "Francesa");
//        Plato gratin = new Plato("Le gratin dauphinois", 74000, 1, "Francesa");
//        Plato.getGastronomias_francesa().add(ratatouille);
//        Plato.getGastronomias_francesa().add(escargots);
//        Plato.getGastronomias_francesa().add(fricase);
//        Plato.getGastronomias_francesa().add(gratin);
//        Plato.getPlatos_gastronomias().add(Plato.getGastronomias_francesa());
//        Plato.getPlatos_gastronomias().add(Plato.getGastronomias_italiana());
//        Plato.getPlatos_gastronomias().add(Plato.getGastronomias_marroqui());
//        Plato.getPlatos_gastronomias().add(Plato.getGastronomias_japonesa());
//        Plato.getPlatos_gastronomias().add(Plato.getGastronomias_japonesa());
//
//        System.out.println(Ciudad.getCiudades().get(0).getZonasCiudad().get(0).getRestaurantes().get(0).getMenu());
//        System.out.println(Plato.getPlatos());
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
                    break;
                case 5:
                    Utilidad.limpiarPantalla();
                    crearEvento();
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

    //FUNCIONALIDAD UNO
    public static void reservarMesa() {
        boolean encendido1 = true;
        do {
            System.out.println("""
                    ¿Desea reservar una mesa?
                    1. Sí.
                    2. No.
                    Escriba un número para elegir su opción.""");
            int eleccion1 = Utilidad.readInt();
            switch (eleccion1) {
                case 1:
                    Utilidad.limpiarPantalla();
                    System.out.println("Ciudades:");
                    Utilidad.listadoCiudades();
                    System.out.println("Escriba un número para elegir la ciudad.\nEn caso de no encontrar la ciudad " +
                            "requerida escriba 0.");
                    int eleccion2 = Utilidad.readInt();
                    if (eleccion2 > Ciudad.getCiudades().size() || eleccion2 < 0) {
                        System.out.println("Ingrese un número válido [1 - " + Ciudad.getCiudades().size() + "].");
                    } else {
                        Utilidad.limpiarPantalla();
                        if (!(eleccion2 == 0)) { //Si se encuentra la ciudad
                            Ciudad ciudad = Ciudad.getCiudades().get(eleccion2 - 1);
                            if (ciudad.getRestaurantes().isEmpty()) { //Si la ciudad no tiene restaurantes
                                System.out.println("Esta ciudad no tiene restaurantes.");
                                reservarMesa();
                            } else { //Si la ciudad tiene zonas
                                boolean encendido2 = true;
                                do {
                                    Utilidad.limpiarPantalla();
                                    System.out.println("Zonas de " + ciudad.getNombre() + ":");
                                    ArrayList<Zona> zonasConRestaurante = Utilidad.listadoZonasConRestauranteCiudad(ciudad);
                                    System.out.println("Escriba un número para elegir la zona.");
                                    int eleccion3 = Utilidad.readInt();
                                    if (eleccion3 > zonasConRestaurante.size() || eleccion3 < 1) { //Si no se encuentra la zona
                                        System.out.println("Ingrese un número válido [1 - " + zonasConRestaurante.size() +
                                                "].");
                                    } else { //Si se encuentra la zona
                                        Utilidad.limpiarPantalla();
                                        Zona zona = zonasConRestaurante.get(eleccion3 - 1);
                                        boolean encendido3 = true;
                                        do {
                                            Utilidad.limpiarPantalla();
                                            System.out.println("Restaurantes de " + zona.getNombre() + ":");
                                            Utilidad.listadoRestaurantesZona(zona);
                                            System.out.println("Escriba un número para elegir el " +
                                                    "restaurante.");
                                            int eleccion4 = Utilidad.readInt();
                                            if (eleccion4 > zona.getRestaurantes().size() || eleccion4 < 1) { //Si no se encuentra el restaurante
                                                System.out.println("Ingrese un número válido [1 - " +
                                                        zona.getRestaurantes().size() + "].");
                                            } else { //Si se encuentra el restaurante
                                                Cliente cliente = seleccionMesa(zona.getRestaurantes().get(eleccion4 - 1));
                                                Restaurante restaurante = extrasReserva(cliente);
                                                pagoAnticipado(restaurante);
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
                            System.out.println("""
                                    ¿Desea elegir otra ciudad?
                                    1. Sí.
                                    2. No.
                                    Escriba un número para elegir su opción.""");
                            int eleccion4 = Utilidad.readInt();
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
                    Utilidad.limpiarPantalla();
                    menuPrincipal();
                    encendido1 = false;
                    break;
                default:
                    Utilidad.limpiarPantalla();
                    System.out.println("Ingrese un número válido [1 - 2].");
                    break;
            }
        } while (encendido1);
    }

    public static Cliente seleccionMesa(Restaurante restaurante) {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = Utilidad.capitalize(Utilidad.readString());
        System.out.println("Ingrese la cédula del cliente:");
        int cedula = Utilidad.readInt();
        System.out.println("Ingrese la placa del vehículo del cliente (en caso de no tener escribir 0):");
        String placaVehiculo = Utilidad.readString();
        Cliente cliente = new Cliente(nombre, cedula, placaVehiculo, new Factura());
        if (Utilidad.existeCliente(cliente)) {
            cliente = Utilidad.clienteCedula(cliente);
            clientes.add(cliente);
        } else {
            restaurante.getClientes().add(cliente);
            clientes.add(cliente);
        }
        System.out.println("Ingrese la cantidad de acompañantes del cliente:");
        System.out.println("Ingrese la cantidad de acompañantes. No debe ser mayor a 6.\nEn caso de" +
                " ingresar un número mayor a 6, este será ignorado y se establecerá en 6.");
        int numAcompanantes = Utilidad.readInt();
        if (numAcompanantes > 0) {
            if (numAcompanantes > 6) {numAcompanantes = 6;}
            for (int i = 0; i < numAcompanantes; i++) {
                System.out.println("Ingrese el nombre del acompañante #" + (i + 1) + ":");
                String nombreAcompanante = Utilidad.readString();
                System.out.println("Ingrese la cédula del acompañante #" + (i + 1) + ":");
                int cedulaAcompanante = Utilidad.readInt();
                Cliente acompanante = new Cliente(nombreAcompanante, cedulaAcompanante);
                if (Utilidad.existeCliente(acompanante)) {
                    acompanante = Utilidad.clienteCedula(acompanante);
                    clientes.add(acompanante);
                } else {
                    restaurante.getClientes().add(acompanante);
                    clientes.add(acompanante);
                }
            }
        }
        for (Cliente cliente1 : clientes) {
            cliente1.setRestaurante(restaurante);
        }
        boolean tipoMesa = false;
        boolean existe = false;
        System.out.println("¿Qué tipo de mesa quiere usar?\n1. Estándar.\n2. VIP.");
        int eleccion1 = Utilidad.readInt();
        switch (eleccion1) {
            case 1:
                for (Mesa mesa : restaurante.getMesas()) {
                    if (mesa.isVIP() == tipoMesa) {
                        existe = true;
                    } else {
                        System.out.println("Lo sentimos, pero no hay mesas estándar, la mesa tendrá que ser VIP.");
                        tipoMesa = true;
                        break;
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
        System.out.println("Tiene preferencia por estar cerca de:\n1. Puerta.\n2. Ventana.\n3. Ninguna.");
        int eleccion2 = Utilidad.readInt();
        switch (eleccion2) {
            case 1, 2:
                mesasElegidas = Utilidad.calcularDistancia(restaurante, eleccion2, tipoMesa);
                break;
            case 3:
                for (Mesa mesa : restaurante.getMesas()) {
                    mesa.setDistanciaPuerta(0);
                    mesa.setDistanciaVentana(0);
                }
                break;
            default:
                System.out.println("Debido a que ingresó un dato erróneo se asume que no tiene ninguna preferencia.");
                break;
        }
        boolean encendido1 = true;
        do {
            ArrayList<Integer> fechaElegida = seleccionFecha(restaurante, tipoMesa, mesasElegidas);
            Utilidad.limpiarPantalla();
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
            System.out.println("¿Alguna de las mesas disponibles le es conveniente?\n1. Sí.\n2. No.");
            int eleccion4 = Utilidad.readInt();
            if (eleccion4 == 1) {
                System.out.println("Ingrese el número de la mesa de su preferencia.");
                int numMesa = Utilidad.readInt();
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
                Utilidad.limpiarPantalla();
                int indiceFechaElegida = 0;
                for (ArrayList<Integer> fecha : mesaElegida.getFechasDisponibles()) {
                    if (fecha.get(1) == fechaElegida.get(1) && Objects.equals(fecha.get(2), fechaElegida.get(2))) {
                        indiceFechaElegida = mesaElegida.getFechasDisponibles().indexOf(fecha);
                        mesaElegida.setUltimaFechaReserva(indiceFechaElegida);
                        break;
                    }
                }
                System.out.println("Horarios disponibles para la mesa seleccionada:");
                for (int i = 3; i < mesaElegida.getFechasDisponibles().get(indiceFechaElegida).size(); i++) {
                    System.out.println(i-2 + ". " + mesaElegida.getFechasDisponibles().get(indiceFechaElegida).get(i)
                            + ":00.");
                }
                System.out.println("¿Alguno de los horarios disponibles le es conveniente?\n1. Sí.\n2. No.");
                int eleccion5 = Utilidad.readInt();
                if (eleccion5 == 1) {
                    boolean encendido2 = true;
                    do {
                        System.out.println("Ingrese el horario de su preferencia. [1 - " +
                                (mesaElegida.getFechasDisponibles().get(indiceFechaElegida).size() - 3) + "].");
                        int horaElegida = Utilidad.readInt();
                        if (horaElegida < 1 || horaElegida >
                                mesaElegida.getFechasDisponibles().get(indiceFechaElegida).size() - 2) {
                            System.out.println("Ingrese un número válido [1 - " +
                                    (mesaElegida.getFechasDisponibles().get(indiceFechaElegida).size() - 3) + "].");
                        } else {
                            fechaElegida.add(mesaElegida.getFechasDisponibles().get(indiceFechaElegida).get(horaElegida
                                    + 2));
                            Reserva reserva = new Reserva(clientes, fechaElegida);
                            reserva.setRestaurante(restaurante);
                            mesaElegida.getFechasDisponibles().get(indiceFechaElegida).remove(horaElegida + 2);
                            restaurante.getHistorialReservas().add(reserva);
                            for (Cliente cliente1 : clientes) {
                                cliente1.setReserva(reserva);
                                cliente1.setMesa(mesaElegida);
                                cliente1.setFactura(new Factura(new Pedido()));
                            }
                            System.out.println("Mesa Elegida" + mesaElegida.getFechasDisponibles());
                            System.out.println(restaurante.getHistorialReservas());
                            System.out.println("Su reserva ha sido exitosa");
                            encendido1 = false;
                            encendido2 = false;
                        }
                    } while (encendido2);

                } else {
                    System.out.println("¿Desea elegir una fecha diferente?\n1. Sí.\n2. No.");
                    int seguir1 = Utilidad.readInt();
                    if (seguir1 != 1) {
                        encendido1 = false;
                    }
                }
            } else {
                System.out.println("¿Desea elegir una fecha diferente?\n1. Sí.\n2. No.");
                int seguir2 = Utilidad.readInt();
                if (seguir2 != 1) {
                    encendido1 = false;
                }
            }
            System.out.println(restaurante);
        } while (encendido1);
        return cliente;
    }

    public static ArrayList<Integer> seleccionFecha(Restaurante restaurante, boolean tipoMesa,
                                                    ArrayList<Integer> mesasElegidas) {
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
        System.out.println("Escriba un número para elegir su opción [1 - " + anios.size() + "].");
        int eleccion1 = Utilidad.readInt();
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
            System.out.println("Escriba un número para elegir su opción [1 - " + i + "].");
            eleccion2 = Utilidad.readInt();
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
            System.out.println("Escriba un número para elegir su opción [1 - " +
                    (restaurante.getFechasDisponibles().get(indiceMes).size() - 2) + "].");
            eleccion3 = Utilidad.readInt();
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
                        System.out.println(cliente.getFactura());
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

        System.out.println("¿Desea pagar ya mismo su reserva?\n1. Sí.\n2. No.");
        int eleccion1 = Utilidad.readInt();
        if (eleccion1 == 1) {
            if (clientes.getFirst().getAfiliacion() == Cliente.Afiliacion.NINGUNA) {
                System.out.println("¿Desea afiliarse al restaurante? Hacerlo le daría un descuento extra por ser " +
                        "un nuevo socio\n1. Sí.\n2. No.");
                int eleccion2 = Utilidad.readInt();
                if (eleccion2 == 1) {
                    factura.aumentarValor(13500); //Aplicar 10% de descuento al valor de la reserva.
                    pagarReserva(restaurante, reserva, clientes, factura);
                } else {
                    factura.aumentarValor(15000);
                    pagarReserva(restaurante, reserva, clientes, factura);
                }
            } else {
                factura.setValor(14300); //Aplicar 5% de descuento al valor de la reserva.
                pagarReserva(restaurante, reserva, clientes, factura);
            }
            clientes.getFirst().getFactura().setPagoPreconsumo(true);
        } else {
            factura.aumentarValor(15000);
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
                factura.calcularValor();
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
                        encendido1 = false;
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

    //FUNCIONALIDAD 2
    public static void ordenarComida() {
        boolean encendido1 = true;
        do {
            System.out.println("""
                    ¿Desea ordenar comida?
                    1. Sí.
                    2. No.
                    Escriba un número para elegir su opción.""");
            int eleccion1 = Utilidad.readInt();
            switch (eleccion1) {
                case 1:
                    Utilidad.limpiarPantalla();
                    System.out.println("Ciudades:");
                    Utilidad.listadoCiudades();
                    System.out.println("Escriba un número para elegir la ciudad.\nEn caso de no encontrar la ciudad " +
                            "requerida escriba 0.");
                    int eleccion2 = Utilidad.readInt();
                    if (eleccion2 > Ciudad.getCiudades().size() || eleccion2 < 0) {
                        System.out.println("Ingrese un número válido [1 - " + Ciudad.getCiudades().size() + "].");
                    } else {
                        Utilidad.limpiarPantalla();
                        if (!(eleccion2 == 0)) { //Si se encuentra la ciudad
                            Ciudad ciudad = Ciudad.getCiudades().get(eleccion2 - 1);
                            if (ciudad.getRestaurantes().isEmpty()) { //Si la ciudad no tiene restaurantes
                                System.out.println("Esta ciudad no tiene restaurantes.");
                                ordenarComida();
                            } else { //Si la ciudad tiene zonas
                                boolean encendido2 = true;
                                do {
                                    Utilidad.limpiarPantalla();
                                    System.out.println("Zonas de " + ciudad.getNombre() + ":");
                                    ArrayList<Zona> zonasConRestaurante = Utilidad.listadoZonasConRestauranteCiudad(ciudad);
                                    System.out.println("Escriba un número para elegir la zona.");
                                    int eleccion3 = Utilidad.readInt();
                                    if (eleccion3 > zonasConRestaurante.size() || eleccion3 < 1) { //Si no se encuentra la zona
                                        System.out.println("Ingrese un número válido [1 - " +
                                                zonasConRestaurante.size() + "].");
                                    } else { //Si se encuentra la zona
                                        Utilidad.limpiarPantalla();
                                        Zona zona = zonasConRestaurante.get(eleccion3 - 1);
                                        boolean encendido3 = true;
                                        do {
                                            Utilidad.limpiarPantalla();
                                            System.out.println("Restaurantes de " + zona.getNombre() + ":");
                                            Utilidad.listadoRestaurantesZona(zona);
                                            System.out.println("Escriba un número para elegir el " +
                                                    "restaurante.");
                                            int eleccion4 = Utilidad.readInt();
                                            if (eleccion4 > zona.getRestaurantes().size() || eleccion4 < 1) { //Si no se encuentra el restaurante
                                                System.out.println("Ingrese un número válido [1 - " +
                                                        zona.getRestaurantes().size() + "].");
                                            } else { //Si se encuentra el restaurante
                                                //Interacción #1
                                                ArrayList<Cliente> clientes = establecerCliente(zona.getRestaurantes().get(eleccion4 - 1));
                                                ArrayList<Pedido> pedidos = hacerComida(clientes);
                                                asignarFactura(pedidos);
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
                            System.out.println("""
                                    ¿Desea elegir otra ciudad?
                                    1. Sí.
                                    2. No.
                                    Escriba un número para elegir su opción.""");
                            int eleccion4 = Utilidad.readInt();
                            if (eleccion4 == 1) {
                                ordenarComida();
                            } else {
                                menuPrincipal();
                            }
                        }
                        encendido1 = false;
                    }
                    break;
                case 2:
                    Utilidad.limpiarPantalla();
                    menuPrincipal();
                    encendido1 = false;
                    break;
                default:
                    Utilidad.limpiarPantalla();
                    System.out.println("Ingrese un número válido [1 - 2].");
                    break;
            }
        } while (encendido1);
    }

    //Interaccion 1
    public static ArrayList<Cliente> establecerCliente(Restaurante restaurante) {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        System.out.println("Ingrese el número de cédula de la persona que desea ordenar:");
        int cedula = Utilidad.readInt();
        Cliente cliente = new Cliente(cedula);

        boolean existeCliente = Utilidad.existeCliente(cliente);

        if (existeCliente){
            Cliente nuevoCliente = Utilidad.clienteCedula(cliente);
            System.out.println(nuevoCliente);
            if (nuevoCliente == cliente) { //Si el cliente no tiene reserva
                System.out.println("El cliente con cédula " + cedula + " no está registrado en el restaurante indicado.");
                System.out.println("Para continuar tendrá que brindarnos algunos datos adicionales.");
                System.out.println("Ingrese el nombre del cliente:");
                String nombre = Utilidad.capitalize(Utilidad.readString());
                cliente.setNombre(nombre);
//                ArrayList<Cliente> clientes = new ArrayList<Cliente>();
                clientes.add(cliente);
                restaurante.getClientes().add(cliente);
                cliente.setRestaurante(restaurante);
                Mesa mesa = new Mesa();
                for (Mesa mesaRestaurante : restaurante.getMesas()) {
                    if (mesaRestaurante.getClientes().isEmpty()) {
                        cliente.setMesa(mesaRestaurante);
                        mesaRestaurante.setClientes(new ArrayList<Cliente>(Arrays.asList(cliente)));
                        mesa = mesaRestaurante;
                    }
                }
                clientes = mesa.getClientes();

            } else {//Si el cliente tiene reserva
                boolean encendido1 = true;
                Mesa mesa = new Mesa();
                do {
                    System.out.println("Ingrese el código de reserva:");
                    int codigoReserva = Utilidad.readInt();
                    for (Reserva reserva : restaurante.getHistorialReservas()) {
                        if (reserva.getCodigoReserva() == codigoReserva) {
                            nuevoCliente.setReserva(reserva);
                            clientes.add(nuevoCliente);
                            mesa = nuevoCliente.getMesa();
                            mesa.setClientes(clientes);
                            System.out.println("Por favor diríjase a la mesa " + mesa.getNumMesa() + ".");
                            encendido1 = false;
                            break;
                        }
                    }
                    if (encendido1 == false) {
                        continue;
                    } else {
                        System.out.println("El código de reserva ingresado no es válido.");
                        System.out.println("Por favor, ingrese un código de reserva válido.");
                    }
                } while (encendido1);
//				ArrayList<Cliente> clientes = new ArrayList<Cliente>();
                clientes = mesa.getClientes();
            }
        } else {
            Mesa mesa = new Mesa();
            System.out.println("El cliente con cédula " + cedula + " no está registrado en ningún restaurante.");
            System.out.println("Para continuar tendrá que brindarnos algunos datos adicionales.");
            System.out.println("Ingrese el nombre del cliente:");
            String nombre = Utilidad.capitalize(Utilidad.readString());
            cliente.setNombre(nombre);
            clientes.add(cliente);
            Cliente.getClientes().add(cliente);
            restaurante.getClientes().add(cliente);
            cliente.setRestaurante(restaurante);
            for (Mesa mesaRestaurante : restaurante.getMesas()) {
                if (mesaRestaurante.getClientes().isEmpty()) {
                    cliente.setMesa(mesaRestaurante);
                    mesaRestaurante.setClientes(new ArrayList<Cliente>(Arrays.asList(cliente)));
                    mesa = mesaRestaurante;
                }
            }
//			ArrayList<Cliente> clientes = new ArrayList<Cliente>();
            clientes = mesa.getClientes();
        }
        System.out.println(clientes.size());
        return clientes;
    }

    //Interaccion 2
    public static ArrayList<Pedido> hacerComida(ArrayList<Cliente> clientes) {
        Utilidad.limpiarPantalla();

        ArrayList<Trabajador> trabajadores = clientes.getFirst().getRestaurante().getTrabajadores(); //Tostao

        // Buscar Trabajador especialidad Cocinero, especialidad Mesero
        Trabajador cocinero = new Trabajador();
        Trabajador mesero = new Trabajador();

        for (Trabajador trabajador : trabajadores) {
            if (trabajador.getTipo() == Trabajador.Tipo.COCINERO) {
                cocinero = trabajador;
            }
            if (trabajador.getTipo() == Trabajador.Tipo.MESERO) {
                mesero = trabajador;
            }
        }

        mesero.setMesa(clientes.getFirst().getMesa());
        clientes.getFirst().getMesa().setMesero(mesero);

        Pedido pedidoDummy = new Pedido();

        ArrayList<Pedido> pedidos = hacerPedido(mesero.getMesa().getClientes(), pedidoDummy);

        for (Pedido pedido : pedidos) {
            pedido.setMesero(mesero);

            pedido.setRestaurante(clientes.getFirst().getRestaurante());

            ArrayList<Plato> platosCocinados = cocinero.cocinar(pedido);

            if (platosCocinados.size() != pedido.getPlatos().size()) {
                System.out.println("Algun(os) plato(s) del pedido no ha(n) podido ser cocinado(s) debido a la falta de " +
                        "ingredientes");
                System.out.println("Se le descontará de la factura.");
                pedido.setPlatos(platosCocinados);
            }
        }

        return pedidos;
    }

    public static Pedido platosMenu(String tipo, Cliente cliente) {
        ArrayList<Plato> platos = new ArrayList<Plato>();
        Pedido pedido = new Pedido();
        switch (tipo) {
            case "Entrada":
                System.out.println("Entradas Disponibles\n");
                for (Plato plato : cliente.getRestaurante().getMenu()) {
                    if (plato.getTipo().equals("Entrada")) {
                        platos.add(plato);
                    }
                }
            case "Plato fuerte":
                System.out.println("Plato fuertes Disponibles\n");
                for (Plato plato : cliente.getRestaurante().getMenu()) {
                    if (plato.getTipo().equals("Plato Fuerte")) {
                        platos.add(plato);
                    }
                }
                break;

            case "Bebida":
                System.out.println("Bebidas Disponibles\n");
                for (Plato plato : cliente.getRestaurante().getMenu()) {
                    if (plato.getTipo().equals("Bebida")) {
                        platos.add(plato);
                    }
                }
                break;
            case "Postre":
                System.out.println("Postres Disponibles\n");
                for (Plato plato : cliente.getRestaurante().getMenu()) {
                    if (plato.getTipo().equals("Postre")) {
                        platos.add(plato);
                    }
                }
                break;
            case "Infantil":
                System.out.println("Menú infantil\n");
                for (Plato plato : cliente.getRestaurante().getMenu()) {
                    if (plato.getTipo().equals("Infantil")) {
                        platos.add(plato);
                    }
                }
                break;
            case "Ninguno":
                System.out.println("Menú General\n");
                for (Plato plato : cliente.getRestaurante().getMenu()) {
                    platos.add(plato);
                }
        }
        for (Plato plato : cliente.getPlatosFavoritos()){
            if (cliente.getRestaurante().getMenu().contains(plato)){
                platos.add(plato);
            }
        }
        if (platos.isEmpty()) {
            System.out.println("No contamos con platos de este tipo por el momento.");
        } else {
            for (Plato plato : platos) {
                System.out.println((platos.indexOf(plato) + 1) +". " +  plato);
            }

            System.out.println("Ingrese el número del plato que desea.");
            int numPlato = Utilidad.readInt();
            System.out.println("Ingrese la cantidad deseada (1, 2...)");
            int cantidad = Utilidad.readInt();

            for (int i = 1; i < cantidad; i++){
                Plato platoPedido = platos.get(numPlato - 1);
                platoPedido.aumentarVecesPedido();
                pedido.agregarPlato(platoPedido);
                System.out.print("Su Pedido hasta ahora\n" + pedido + "\n");
            }
        }
        return pedido;
    }

    private static ArrayList<Pedido> hacerPedido(ArrayList<Cliente> clientes, Pedido pedido) {
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        for (Cliente cliente : clientes) {
            Pedido pedidoCliente = new Pedido();
            boolean encendido2;
            do {
                System.out.println("Seleccione una opción:\n1. Entradas.\n2. Platos Fuertes.\n3. Bebidas.\n4. " +"Postres.\n5. Menú Infantil.\n6. Todos.\n7. Terminar.");

                int opcion = Utilidad.readInt();
                encendido2 = true;
                switch (opcion) {
                    case 1:
                        Utilidad.limpiarPantalla();
                        pedido = platosMenu("Entrada", cliente);
                        if (!pedido.getPlatos().isEmpty()) {
                            pedidoCliente.getPlatos().addAll(pedido.getPlatos());
                        }
                        break;
                    case 2:
                        Utilidad.limpiarPantalla();
                        pedido = platosMenu("Plato fuerte", cliente);
                        if (!pedido.getPlatos().isEmpty()) {
                            pedidoCliente.getPlatos().addAll(pedido.getPlatos());
                        }
                        break;
                    case 3:
                        Utilidad.limpiarPantalla();
                        pedido = platosMenu("Bebida", cliente);
                        if (!pedido.getPlatos().isEmpty()) {
                            pedidoCliente.getPlatos().addAll(pedido.getPlatos());
                        }
                        break;
                    case 4:
                        Utilidad.limpiarPantalla();
                        pedido = platosMenu("Postre", cliente);
                        if (!pedido.getPlatos().isEmpty()) {
                            pedidoCliente.getPlatos().addAll(pedido.getPlatos());
                        }
                        break;
                    case 5:
                        Utilidad.limpiarPantalla();
                        pedido = platosMenu("Infantil", cliente);
                        if (!pedido.getPlatos().isEmpty()) {
                            pedidoCliente.getPlatos().addAll(pedido.getPlatos());
                        }
                        break;
                    case 6:
                        Utilidad.limpiarPantalla();
                        pedido = platosMenu("Ninguno", cliente);
                        if (!pedido.getPlatos().isEmpty()) {
                            pedidoCliente.getPlatos().addAll(pedido.getPlatos());
                        }
                        break;
                    default:
                        if (pedidoCliente.getPlatos().isEmpty()) {
                            System.out.println("Ingrese un valor válido [1 - 6]");
                        } else{
                            System.out.println("Fin pedido");
                            encendido2 = false;
                        }
                }
            } while (encendido2);
            pedidos.add(pedidoCliente);
            cliente.setPedido(pedidoCliente);
        }
        return pedidos;
    }

    // INTERACCION 3
    public static ArrayList<Factura> asignarFactura(ArrayList<Pedido> pedidos) {

        Trabajador mesero = pedidos.getFirst().getMesero();
        Mesa mesa = mesero.getMesa();

        for (int i = 0; i < pedidos.size(); i++) {
            int valorFactura = 0;
            Factura factura = new Factura(pedidos.get(i), valorFactura);
            mesa.getFacturas().add(factura);
            mesa.getClientes().get(i).setFactura(factura);

            for (Plato plato : pedidos.get(i).getPlatos()) {
                factura.aumentarValor(plato.getPrecio());
            }

            System.out.println(factura);
        }

        mesero.aumentarGananciasExtra(5000);

        Utilidad.limpiarPantalla();

        return mesa.getFacturas();
    }

    //FUNCIONALIDAD TRES
    //Este metodo se encarga de la interacción con el usuario para que este pueda dejar un restaurante.
    public static void dejarRestaurante() {
        boolean encendido = true;
        do {
            System.out.println("""
                    ¿Algún cliente desea dejar un restaurante?
                    1. Sí.
                    2. No.
                    Escriba un número para elegir su opción.""");
            int eleccion = Utilidad.readInt();
            switch (eleccion) {
                case 1:
                    Utilidad.limpiarPantalla();
                    System.out.println("Ingrese el número de cédula del cliente que va a dejar el restaurante");
                    int cedula = Utilidad.readInt();
                    Cliente cliente = Utilidad.clienteCedula(new Cliente("", cedula));
                    Mesa mesa = cliente.getMesa();
                    cobrarFactura(mesa);
                    encendido = false;
                    break;
                case 2:
                    Utilidad.limpiarPantalla();
                    menuPrincipal();
                    encendido = false;
                    break;
                default:
                    Utilidad.limpiarPantalla();
                    System.out.println("Ingrese un número válido [1 - 2].");
                    break;
            }
        } while (encendido);
    }

    // Interacción 1: cobrarFactura
    // Este metodo es el encargado de cobrar la factura de una mesa en específico. Es la primera interacción de la funcionalidad número 3.
    public static void cobrarFactura(Mesa mesa) {
        boolean encendido = true;
        do {
            System.out.println("Interacción 1.");
            int valorFactura = 0;
            for (Cliente cliente : mesa.getClientes()) {
                valorFactura += cliente.getFactura().calcularValor();
            }
            System.out.println("El valor de la factura es: " + valorFactura);
            System.out.println("""
                    ¿Desea agregar propina?
                    1. Sí.
                    2. No.
                    Escriba un número para elegir su opción.""");
            int eleccion = Utilidad.readInt();
            switch (eleccion) {
                case 1:
                    System.out.println("Por favor ingrese el valor de la propina.");
                    int propina = Utilidad.readInt();
                    valorFactura += propina;
                    mesa.setValorTotal(valorFactura);
                    System.out.println("El valor de la factura con propina es: " + valorFactura);
                    separarFactura(mesa);
                    liberarMesa(mesa);
                    encendido = false;
                    break;
                case 2:
                    System.out.println("El valor de la factura sin propina es: " + valorFactura);
                    mesa.setValorTotal(valorFactura);
                    separarFactura(mesa);
                    liberarMesa(mesa);
                    encendido = false;
                    break;
                default:
                    System.out.println("Número no válido.");
                    break;
            }
        } while (encendido);
    }

    // Este metodo pertenece a la primera interacción y se encarga de separar y cobrar la factura de la mesa que desea dejar el restaurante.
    public static void separarFactura(Mesa mesa) {
        boolean encendido = true;
        do {
            System.out.println("¿Desea separar la factura?");
            System.out.println("""
                    1. Sí.
                    2. No.
                    Escriba un número para elegir su opción.""");
            int eleccion = Utilidad.readInt();
            switch (eleccion) {
                case 1:
                    System.out.println("Por favor ingrese el número de personas que van a pagar la factura.");
                    int cedula = 0;
                    int numeroPersonas = Utilidad.readInt();
                    if (numeroPersonas == mesa.getClientes().size()) {
                        ArrayList<Cliente> clientesPagadores = new ArrayList<Cliente>();
                        System.out.println("¿Todos desean pagar el mismo monto?");
                        System.out.println("""
                                1. Sí.
                                2. No.
                                Escriba un número para elegir su opción.""");
                        int eleccion2 = Utilidad.readInt();
                        switch (eleccion2) {
                            case 1:
                                int valorFactura = mesa.getValorTotal();
                                int valorPorPersona = valorFactura / numeroPersonas;
                                System.out.println("El valor por persona es: " + valorPorPersona);
                                Utilidad.limpiarPantalla();
                                clientesPagadores = mesa.getClientes();
                                for (Cliente clientePagador : clientesPagadores) {
                                    escogerMetodoPago(clientePagador);
                                    int valorFinalPorPersona = aplicarDescuentosCuenta(clientePagador, valorPorPersona);
                                    boolean transaccionConfirmada = false;
                                    do {
                                        System.out.println("Descuento por afiliación: " + (valorPorPersona - valorFinalPorPersona));

                                        System.out.println("¿Desea confirmar la transacción con un valor de: " + valorFinalPorPersona + "?");
                                        System.out.println("""
                                                    1. Sí.
                                                    2. No.
                                                    Escriba un número para elegir su opción.""");
                                        int confirmacion = Utilidad.readInt();
                                        switch (confirmacion) {
                                            case 1:
                                                System.out.println("Transacción confirmada.");
                                                clientePagador.getFactura().pagar();
                                                mesa.setValorTotal(mesa.getValorTotal() - valorPorPersona);
                                                transaccionConfirmada = true;
                                                break;
                                            case 2:
                                                break;
                                            default:
                                                System.out.println("Número no válido.");
                                                break;
                                        }
                                    } while (!transaccionConfirmada);

                                }
                                if (mesa.getValorTotal() == 0) {
                                    System.out.println("La factura ha sido pagada. Esperamos que vuelvan pronto!!!");
                                }
                                break;
                            case 2:
                                System.out.println("Cada persona pagará lo que consumió.");
                                for (Cliente cliente : mesa.getClientes()) {
                                    System.out.println(cliente.getNombre() + " debe pagar: " + cliente.getFactura().getValor());
                                    escogerMetodoPago(cliente);
                                    int valorFinalFactura = aplicarDescuentosCuenta(cliente, cliente.getFactura().getValor());
                                    boolean transaccionConfirmada = false;
                                    do {
                                        System.out.println("¿Desea confirmar la transacción con un valor de: " + valorFinalFactura + "?");
                                        System.out.println("""
                                                1. Sí.
                                                2. No.
                                                Escriba un número para elegir su opción.""");
                                        int confirmacion = Utilidad.readInt();
                                        switch (confirmacion) {
                                            case 1:
                                                System.out.println("Transacción confirmada.");
                                                cliente.getFactura().pagar();
                                                mesa.setValorTotal(mesa.getValorTotal() - cliente.getFactura().getValor());
                                                transaccionConfirmada = true;
                                                break;
                                            case 2:
                                                break;
                                            default:
                                                System.out.println("Número no válido.");
                                                break;
                                        }
                                    } while (!transaccionConfirmada);
                                }
                                if (mesa.getValorTotal() == 0) {
                                    System.out.println("La factura ha sido pagada. Esperamos que vuelvan pronto!!!");
                                }
                                break;
                        }
                    } else {
                        ArrayList<Cliente> clientesPagadores = new ArrayList<Cliente>(numeroPersonas);
                        int personasProcesadas = 0;
                        while (mesa.getValorTotal() > 0 && personasProcesadas < numeroPersonas) {
                            for (int j = 0; j < numeroPersonas; j++) {
                                System.out.println("Ingrese la cédula de la persona que pagará la factura.");
                                cedula = Utilidad.readInt();

                                // Verificar si la cédula ingresada corresponde a algún cliente
                                boolean cedulaValida = false;
                                Cliente clientePagador = null;
                                for (Cliente cliente : mesa.getClientes()) {
                                    if (cliente.getCedula() == cedula) {
                                        cedulaValida = true;
                                        clientePagador = cliente;
                                        clientesPagadores.add(cliente);
                                        break;
                                    }
                                }
                                if (cedulaValida) {
                                    System.out.println("Ingrese la cantidad que desea pagar.");
                                    int valor = Utilidad.readInt();
                                    if (valor > mesa.getValorTotal()) {
                                        System.out.println("El valor ingresado es mayor al valor de la factura.");
                                    } else {
                                        escogerMetodoPago(clientePagador);
                                        int valorFinalPersona = aplicarDescuentosCuenta(clientePagador, valor);
                                        mesa.setValorTotal(mesa.getValorTotal() - valor + (valor - valorFinalPersona));
                                        System.out.println("El pago final fue: " + valorFinalPersona);
                                        System.out.println("El valor restante de la factura es: " + mesa.getValorTotal());

                                    }
                                    personasProcesadas++;
                                    if (mesa.getValorTotal() <= 0) {
                                        break;
                                    }
                                } else {
                                    System.out.println("Cédula no válida.");
                                }
                            }
                        }
                        if (mesa.getValorTotal() != 0) {
                            System.out.println("La factura aún no ha sido pagada.");
                            System.out.println("Seleccione el cliente que pagará la factura.");
                            for (int i = 0; i < clientesPagadores.size(); i++) {
                                System.out.println(i + 1 + ". " + clientesPagadores.get(i).getNombre());
                            }
                            int clienteAPagar = Utilidad.readInt();
                            System.out.println("Debe pagar el total restante de: " + mesa.getValorTotal());
                            System.out.println("¿Desea confirmar la transacción?");
                            System.out.println("""
                                            1. Sí.
                                            2. No.
                                            Escriba un número para elegir su opción.""");
                            int confirmacion = Utilidad.readInt();
                            switch (confirmacion) {
                                case 1:
                                    System.out.println("Transacción confirmada.");
                                    mesa.setValorTotal(0);
                                    break;
                                case 2:
                                default:
                                    System.out.println("Número no válido.");
                                    break;
                            }
                        }

                        System.out.println("La factura ha sido pagada.");
                    }
                    encendido = false;
                    break;
                case 2:
                    Utilidad.limpiarPantalla();
                    System.out.println("Ingrese la cédula del cliente que realizará el pago.");
                    int cedulaCliente = Utilidad.readInt();
                    for (Cliente cliente : mesa.getClientes()) {
                        if (cliente.getCedula() == cedulaCliente) {
                            escogerMetodoPago(cliente);
                            int valorFinalFactura = aplicarDescuentosCuenta(cliente, mesa.getValorTotal());
                            boolean transaccionConfirmada = false;
                            do {
                                System.out.println("¿Desea confirmar la transacción con un valor de: " + valorFinalFactura + "?");
                                System.out.println("""
                                        1. Sí.
                                        2. No.
                                        Escriba un número para elegir su opción.""");
                                int confirmacion = Utilidad.readInt();
                                switch (confirmacion) {
                                    case 1:
                                        System.out.println("Transacción confirmada.");
                                        for (Cliente clientes : mesa.getClientes()) {
                                            clientes.getFactura().pagar();
                                        }
                                        mesa.setValorTotal(0);
                                        transaccionConfirmada = true;
                                        break;
                                    case 2:
                                        break;
                                    default:
                                        System.out.println("Número no válido.");
                                        break;
                                }
                            } while (!transaccionConfirmada);
                        }
                        if (mesa.getValorTotal() == 0) {
                            System.out.println("La factura ha sido pagada. Esperamos que vuelvan pronto!!!");
                        }
                        encendido = false;
                    }
                    break;
                default:
                    System.out.println("Número no válido.");
                    break;
            }
        } while (encendido);
    }

    // Este metodo se encarga de dar las opciones de metodo de pago a la hora de cobrar la factura.
    public static void escogerMetodoPago(Cliente clientePagador) {
        System.out.println("Por favor escoja el método de pago: " + clientePagador.getNombre());
        System.out.println("""
                1. Efectivo.
                2. Tarjeta.
                3. Cheque.
                Escriba un número para elegir su opción.""");
        int metodoPago = Utilidad.readInt();
        ArrayList<String> metodosPago = new ArrayList<String>();
        switch (metodoPago) {
            case 1:
                clientePagador.getFactura().setMetodoPago("Efectivo");
                metodosPago.add("Efectivo");
                break;
            case 2:
                clientePagador.getFactura().setMetodoPago("Tarjeta");
                metodosPago.add("Tarjeta");
                break;
            case 3:
                clientePagador.getFactura().setMetodoPago("Cheque");
                metodosPago.add("Cheque");
                break;
            default:
                System.out.println("Número no válido");
                escogerMetodoPago(clientePagador);
                break;
        }
    }

    // Interacción 2: liberarMesa

    public static void liberarMesa(Mesa mesa){
        boolean encendido = true;
        do {
            System.out.println("Interacción 2.");
            System.out.println("¿Algún cliente desea reservar nuevamente?");
            System.out.println("""
                    1. Sí.
                    2. No.
                    Escriba un número para elegir su opción.""");
            int eleccion = Utilidad.readInt();
            switch (eleccion){
                case 1:
                    System.out.println("¿Cuántos clientes desean hacer una reservación?");
                    int numeroClientes = Utilidad.readInt();
                    for (int i = 0; i < numeroClientes; i++){
                        System.out.println("Ingrese la cédula del cliente que desea reservar.");
                        int cedula = Utilidad.readInt();
                        for (Cliente cliente : mesa.getClientes()){
                            if (cliente.getCedula() == cedula){
                                if (cliente.getAfiliacion() != Cliente.Afiliacion.NINGUNA){
                                    reservarMesa();
                                } else {
                                    System.out.println("¿Desea afiliarse?");
                                    System.out.println("""
                                            1. Sí.
                                            2. No.
                                            Escriba un número para elegir su opción.""");
                                    int eleccion2 = Utilidad.readInt();
                                    switch (eleccion2){
                                        case 1:
                                            System.out.println("¿Qué nivel de afiliación desea?");
                                            System.out.println("""
                                                    1. Estrellita.
                                                    2. Estrella.
                                                    3. Super estrellota.
                                                    Escriba un número para elegir su opción.""");
                                            int nivelAfiliacion = Utilidad.readInt();
                                            switch (nivelAfiliacion){
                                                case 1:
                                                    boolean transaccionConfirmada = false;
                                                    do {
                                                        System.out.println("¿Desea confirmar la transacción con un valor de: 35.900?");
                                                        System.out.println("""
                                                                1. Sí.
                                                                2. No.
                                                                Escriba un número para elegir su opción.""");
                                                        int confirmacion = Utilidad.readInt();
                                                        switch (confirmacion) {
                                                            case 1:
                                                                System.out.println("Transacción confirmada.");
                                                                cliente.setAfiliacion(Cliente.Afiliacion.ESTRELLITA);
                                                                transaccionConfirmada = true;
                                                                break;
                                                            case 2:
                                                                System.out.println("Afiliación no confirmada.");
                                                                break;
                                                            default:
                                                                System.out.println("Número no válido.");
                                                                break;
                                                        }
                                                    } while (!transaccionConfirmada);
                                                    break;
                                                case 2:
                                                    boolean transaccionConfirmada2 = false;
                                                    do {
                                                        System.out.println("¿Desea confirmar la transacción con un valor de: 48.900?");
                                                        System.out.println("""
                                                                1. Sí.
                                                                2. No.
                                                                Escriba un número para elegir su opción.""");
                                                        int confirmacion = Utilidad.readInt();
                                                        switch (confirmacion) {
                                                            case 1:
                                                                System.out.println("Transacción confirmada.");
                                                                cliente.setAfiliacion(Cliente.Afiliacion.ESTRELLA);
                                                                transaccionConfirmada2 = true;
                                                                break;
                                                            case 2:
                                                                System.out.println("Afiliación no confirmada.");
                                                                break;
                                                            default:
                                                                System.out.println("Número no válido.");
                                                                break;
                                                        }
                                                    } while (!transaccionConfirmada2);
                                                    // aplicarDescuentos(){} Se aplican descuentos a la reserva que va a realizar.
                                                    break;
                                                case 3:
                                                    boolean transaccionConfirmada3 = false;
                                                    do {
                                                        System.out.println("¿Desea confirmar la transacción con un valor de: 65.900?");
                                                        System.out.println("""
                                                                1. Sí.
                                                                2. No.
                                                                Escriba un número para elegir su opción.""");
                                                        int confirmacion = Utilidad.readInt();
                                                        switch (confirmacion) {
                                                            case 1:
                                                                System.out.println("Transacción confirmada.");
                                                                cliente.setAfiliacion(Cliente.Afiliacion.SUPERESTRELLOTA);
                                                                transaccionConfirmada3 = true;
                                                                break;
                                                            case 2:
                                                                System.out.println("Afiliación no confirmada.");
                                                                break;
                                                            default:
                                                                System.out.println("Número no válido.");
                                                                break;
                                                        }
                                                    } while (!transaccionConfirmada3);
                                                    // aplicarDescuentos(){} Se aplican descuentos a la reserva que va a realizar.
                                                    break;
                                                default:
                                                    System.out.println("Número no válido.");
                                                    break;
                                            }
                                            reservarMesa();
                                            break;
                                        case 2:
                                            reservarMesa();
                                            break;
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    for (Cliente cliente : mesa.getClientes()){
                        if (cliente.getAfiliacion() == Cliente.Afiliacion.NINGUNA){
                            System.out.println("¿" + cliente.getNombre() + ", desea afiliarse?");
                            System.out.println("""
                                    1. Sí.
                                    2. No.
                                    Escriba un número para elegir su opción.""");
                            int eleccion3 = Utilidad.readInt();
                            switch (eleccion3){
                                case 1:
                                    System.out.println("¿Qué nivel de afiliación desea?");
                                    System.out.println("""
                                            1. Estrellita.
                                            2. Estrella.
                                            3. Super estrellota.
                                            Escriba un número para elegir su opción.""");
                                    int nivelAfiliacion = Utilidad.readInt();
                                    switch (nivelAfiliacion){
                                        case 1:
                                            boolean transaccionConfirmada = false;
                                            do {
                                                System.out.println("¿Desea confirmar la transacción con un valor de: 35.900?");
                                                System.out.println("""
                                                                1. Sí.
                                                                2. No.
                                                                Escriba un número para elegir su opción.""");
                                                int confirmacion = Utilidad.readInt();
                                                switch (confirmacion) {
                                                    case 1:
                                                        System.out.println("Transacción confirmada.");
                                                        cliente.setAfiliacion(Cliente.Afiliacion.ESTRELLITA);
                                                        transaccionConfirmada = true;
                                                        break;
                                                    case 2:
                                                        System.out.println("Afiliación no confirmada.");
                                                        break;
                                                    default:
                                                        System.out.println("Número no válido.");
                                                        break;
                                                }
                                            } while (!transaccionConfirmada);
                                            break;
                                        case 2:
                                            boolean transaccionConfirmada2 = false;
                                            do {
                                                System.out.println("¿Desea confirmar la transacción con un valor de: 48.900?");
                                                System.out.println("""
                                                        1. Sí.
                                                        2. No.
                                                        Escriba un número para elegir su opción.""");
                                                int confirmacion = Utilidad.readInt();
                                                switch (confirmacion) {
                                                    case 1:
                                                        System.out.println("Transacción confirmada.");
                                                        cliente.setAfiliacion(Cliente.Afiliacion.ESTRELLA);
                                                        transaccionConfirmada2 = true;
                                                        break;
                                                    case 2:
                                                        System.out.println("Afiliación no confirmada.");
                                                        break;
                                                    default:
                                                        System.out.println("Número no válido.");
                                                        break;
                                                }
                                            } while (!transaccionConfirmada2);
                                        case 3:
                                            boolean transaccionConfirmada3 = false;
                                            do {
                                                System.out.println("¿Desea confirmar la transacción con un valor de: 65.900?");
                                                System.out.println("""
                                                                1. Sí.
                                                                2. No.
                                                                Escriba un número para elegir su opción.""");
                                                int confirmacion = Utilidad.readInt();
                                                switch (confirmacion) {
                                                    case 1:
                                                        System.out.println("Transacción confirmada.");
                                                        cliente.setAfiliacion(Cliente.Afiliacion.SUPERESTRELLOTA);
                                                        transaccionConfirmada3 = true;
                                                        break;
                                                    case 2:
                                                        System.out.println("Afiliación no confirmada.");
                                                        break;
                                                    default:
                                                        System.out.println("Número no válido.");
                                                        break;
                                                }
                                            } while (!transaccionConfirmada3);
                                        default:
                                            System.out.println("Número no válido.");
                                            break;
                                    }
                                case 2:
                                    break;
                            }
                        } calificarRestaurante(cliente);
                    }
            } break;
        } while (encendido);
        mesa.setClientes(null);
        for (Cliente cliente : mesa.getClientes()){
            cliente.setMesa(null);
            cliente.setFactura(null);
        }
    }

    public static void calificarRestaurante(Cliente cliente){
        System.out.println("Por favor " + cliente.getNombre() + " califique el restaurante con una nota del 1 al 5.");
        float calificacion = Utilidad.readFloat();
        if (calificacion >= 1 && calificacion <= 5) {
            System.out.println("Gracias por su calificación.");
            cliente.getMesa().getRestaurante().setCalificacion(calificacion);
        } else {
            System.out.println("Ingrese una calificación válida.");
        }
        System.out.println("¿Desea añadir una reseña?");
        System.out.println("""
                1. Sí.
                2. No.
                Escriba un número para elegir su opción.""");
        int eleccion = Utilidad.readInt();
        switch (eleccion) {
            case 1:
                System.out.println("Por favor ingrese su reseña.");
                String reseña = Utilidad.readString();
                cliente.getMesa().getRestaurante().anadirReserva(reseña);
                if (cliente.getAfiliacion() != null) {
                    cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 1);
                    System.out.println("Gracias por su reseña. Obtuvo un punto extra por ayudarnos a mejorar.");
                } else {
                    System.out.println("Gracias por su reseña.");
                }
                break;
            case 2:
                break;
            default:
                System.out.println("Número no válido.");
                break;
        }
        System.out.println("Ingrese una calificación para su plato entre 1 y 5.");
        float calificacionPlato = Utilidad.readFloat();
        for (Plato plato : cliente.getFactura().getPedido().getPlatos()) {
            if (calificacionPlato >= 1 && calificacionPlato <= 5) {
                if (calificacionPlato >= 4.5) {
                    cliente.agregarPlatoFavorito(plato);
                }
                if (calificacionPlato >= 3) {
                    cliente.getReserva().setSatisfaccion(true);
                }
                plato.setCalificacion(calificacionPlato);
                Cliente.despedida(cliente); //Caso #1 Ligadura dinámica
                System.out.println("Gracias por su calificación.");
                actualizarPlatos(plato, cliente.getMesa());
                actualizarMenu(cliente.getMesa());
            } else {
                System.out.println("Ingrese una calificación válida.");
            }
        }
    }


    // Interacción 3: actualizarRestaurante
    public static void actualizarPlatos(Plato platoCalificado, Mesa mesa){
        if (platoCalificado.getCalificacion() >= 4.5 && platoCalificado.getCantidadCalificaciones() >= 3){
            mesa.getRestaurante().agregarPlatoRecomendado(platoCalificado);
            platoCalificado.setRecomendado(true);
            platoCalificado.setPrecio((int) (platoCalificado.getPrecio() + (platoCalificado.getPrecio() * 0.2)));
        }
        if (platoCalificado.getCalificacion() <= 3.7 && platoCalificado.getCantidadCalificaciones() >= 3){
            mesa.getRestaurante().agregarPlatoDescuento(platoCalificado);
            platoCalificado.setPrecio((int) (platoCalificado.getPrecio() - (platoCalificado.getPrecio() * 0.15)));
        }
    }

    public static Restaurante actualizarMenu(Mesa mesa){
        Restaurante restaurante = mesa.getRestaurante();
        for (Plato plato : mesa.getRestaurante().getPlatosRecomendados()){
            if (plato.getPedidosRecomendados() >= 2){
                if (plato.getCalificacion() > 4.5){
                } else {
                    restaurante.eliminarPlatoRecomendado(plato);
                    plato.setPrecio((int) (plato.getPrecio() - (plato.getPrecio() * 0.2)));
                }
            }
        }
        for (Plato plato : mesa.getRestaurante().getPlatosDescuento()){
            if (plato.getPedidosRecomendados() >= 2){
                if (plato.getCalificacion() < 3.7){
                    restaurante.eliminarPlato(plato);
                    System.out.println("El plato " + plato.getNombre() + " ha sido eliminado del menú.");
                    System.out.println("¿Qué desea hacer?");
                    System.out.println("""
                            1. Añadir otro plato.
                            2. Traer un plato de otra sede.
                            Escriba un número para elegir su opción.""");
                    int eleccion = Utilidad.readInt();
                    switch (eleccion){
                        case 1:
                            Plato platoNuevo = crearPlato();
                            restaurante.agregarPlato(platoNuevo);
                            System.out.println("Se ha añadido un nuevo plato al menú.");
                            break;
                        case 2:
                            ArrayList<Plato> mejoresPlatos = Utilidad.listadoPlatosCalificacion();
                            boolean encendido1 = true;
                            do {
                                System.out.println("¿Cuál de los platos presentados desea agregar al menú del restaurante?");
                                int eleccionPlato = Utilidad.readInt();

                                if (eleccionPlato < 1 || eleccionPlato > mejoresPlatos.size()) {
                                    System.out.println("Ingrese un valor válido [1 - " + mejoresPlatos.size() + "].");
                                } else {
                                    mesa.getRestaurante().getMenu().add(mejoresPlatos.get(eleccionPlato - 1));
                                    System.out.println("Nuevo plato añadido al menú.");
                                    encendido1 = false;
                                }
                            } while (encendido1);
                            break;
                        default:
                            System.out.println("Número no válido.");
                            break;
                    }
                } else {
                    restaurante.eliminarPlatoDescuento(plato);
                    plato.setPrecio((int) (plato.getPrecio() + (plato.getPrecio() * 0.15)));
                }
            }
        }
        return restaurante;
    }

    public static int aplicarDescuentosCuenta(Cliente cliente, int valorPorPersona) {
        int valorFinal = 0;
        if (cliente.getAfiliacion() != Cliente.Afiliacion.NINGUNA) {
            valorFinal = valorPorPersona;
            System.out.println("Se aplicaron descuentos por su nivel de afiliación.");
            if (cliente.getAfiliacion() == Cliente.Afiliacion.ESTRELLITA) {
                switch (cliente.getFactura().getMetodoPago()) {
                    case "Efectivo" -> {
                        if (cliente.getFactura().getValor() < 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.05));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 1);
                        } else if (cliente.getFactura().getValor() >= 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.07));;
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 2);
                        }
                    }
                    case "Tarjeta" -> {
                        if (cliente.getFactura().getValor() < 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.03));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 1);
                        } else if (cliente.getFactura().getValor() >= 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.05));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 2);
                        }
                    }
                    case "Cheque" -> {
                        if (cliente.getFactura().getValor() < 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.02));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 0);
                        } else if (cliente.getFactura().getValor() >= 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.03));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 1);
                        }
                    }
                    case "Puntos" -> {
                    }
                }
            } else if (cliente.getAfiliacion() == Cliente.Afiliacion.ESTRELLA) {
                switch (cliente.getFactura().getMetodoPago()) {
                    case "Efectivo" -> {
                        if (cliente.getFactura().getValor() < 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.07));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 2);
                        } else if (cliente.getFactura().getValor() >= 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.15));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 4);
                        }
                    }
                    case "Tarjeta" -> {
                        if (cliente.getFactura().getValor() < 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.08));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 2);
                        } else if (cliente.getFactura().getValor() >= 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.15));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 4);
                        }
                    }
                    case "Cheque" -> {
                        if (cliente.getFactura().getValor() < 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.02));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 0);
                        } else if (cliente.getFactura().getValor() >= 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.1));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 1);
                        }
                    }
                    case "Puntos" -> {
                    }
                }
            } else if (cliente.getAfiliacion() == Cliente.Afiliacion.SUPERESTRELLOTA) {
                switch (cliente.getFactura().getMetodoPago()) {
                    case "Efectivo" -> {
                        if (cliente.getFactura().getValor() < 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.1));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 6);
                        } else if (cliente.getFactura().getValor() >= 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.2));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 8);
                        }
                    }
                    case "Tarjeta" -> {
                        if (cliente.getFactura().getValor() < 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.15));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 6);
                        } else if (cliente.getFactura().getValor() >= 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.25));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 8);
                        }
                    }
                    case "Cheque" -> {
                        if (cliente.getFactura().getValor() < 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.05));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 1);
                        } else if (cliente.getFactura().getValor() >= 30000) {
                            valorFinal = (int) (valorPorPersona - (valorPorPersona * 0.08));
                            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() + 2);
                        }
                    }
                    case "Puntos" -> {
                    }
                }
            }
        } else {
            valorFinal = valorPorPersona;
        }
        if (cliente.getPuntosAcumulados() >= 10) {
            System.out.println("Felicidades, ha obtenido un descuento de 10.000 por sus puntos acumulados.");
            valorFinal -= 10000;
            cliente.setPuntosAcumulados(cliente.getPuntosAcumulados() - 10);
        }
        return valorFinal;
    }

    //FUNCIONALIDAD CUATRO
    //Este metodo se encarga del inicio de la funcionalidad, preguntando si se quiere proceder o no con ella.
    public static Restaurante agregarSede() {
        Restaurante restaurante = new Restaurante();
        boolean encendido = true;
        do {
            System.out.println("""
                    ¿Desea añadir una nueva sede?
                    1. Sí.
                    2. No.
                    Escriba un número para elegir su opción.""");
            int eleccion = Utilidad.readInt();
            switch (eleccion) {
                case 1:
                    Utilidad.limpiarPantalla();
                    System.out.println("Interacción 1.");
                    restaurante = elegirZona(restaurante);
                    establecerDisposicion(restaurante);
                    establecerMenuYEncargos(restaurante);
                    encendido = false;
                    break;
                case 2:
                    Utilidad.limpiarPantalla();
                    menuPrincipal();
                    encendido = false;
                    break;
                default:
                    Utilidad.limpiarPantalla();
                    System.out.println("Ingrese un número válido [1 - 2].");
                    break;
            }

        } while (encendido);
        return restaurante;
    }

    //Interacción 1: Elegir Zona
    public static Restaurante elegirZona(Restaurante restaurante) {
        boolean encendido1 = true;
        do {
            //Se muestran las ciudades de las que se tienen datos
            for (Zona zona : Zona.getZonas()) {
                System.out.println(zona.getNombre());
            }
            System.out.println("Ciudades:");
            Utilidad.listadoCiudades();
            System.out.println("Escriba un número para elegir la ciudad.\nEn caso de no encontrar la ciudad " +
                    "requerida escriba 0.");
            int eleccion1 = Utilidad.readInt();
            if (eleccion1 > Ciudad.getCiudades().size() || eleccion1 < 0) {
                System.out.println("Ingrese un número válido [1 - " + Ciudad.getCiudades().size() + "].");
            } else {
                Utilidad.limpiarPantalla();
                if (!(eleccion1 == 0)) { //Si se encuentra la ciudad
                    Ciudad ciudad = Ciudad.getCiudades().get(eleccion1 - 1);
                    if (ciudad.getRestaurantes().isEmpty()) { //Si la ciudad no tiene restaurantes
                        parametrosBasicos(ciudad, restaurante);
                    } else { //Si la ciudad tiene restaurantes
                        //Análisis de reservas
                        ArrayList<Reserva> reservasUltimosTreinta = new ArrayList<Reserva>();
                        ArrayList<ArrayList<Integer>> intentosUltimosTreinta = new ArrayList<ArrayList<Integer>>();
                        ArrayList<Mesa> mesasRestaurantes = new ArrayList<Mesa>();

                        int reservasSatisfactorias = 0;
                        int totalIntentos = 0;

                        //Agregamos los datos que corresponden a los últimos 30 días de funcionamiento de los
                        // restaurantes de la ciudad correspondiente.
                        for (Zona zona : ciudad.getZonasCiudad()) {
                            for (Restaurante restauranteZona : zona.getRestaurantes()) {
                                ArrayList<Reserva> reservasRestaurante = new ArrayList<Reserva>();
                                ArrayList<ArrayList<Integer>> intentosRestaurante = new ArrayList<ArrayList<Integer>>();
                                for (Reserva reserva : restauranteZona.getHistorialReservas()) {
                                    if (reserva.isSatisfaccion()) {
                                        reservasSatisfactorias++;
                                    }
                                    LocalDateTime fechaToDateTime = LocalDateTime.of(reserva.getFecha().get(0),
                                            reserva.getFecha().get(1), reserva.getFecha().get(2),
                                            reserva.getFecha().get(3), 0);
                                    if (fechaToDateTime.isAfter(LocalDateTime.now().minusDays(30)) &&
                                            fechaToDateTime.isBefore(LocalDateTime.now()) &&
                                            reservasRestaurante.contains(fechaToDateTime) == false) {
                                        reservasRestaurante.add(reserva);
                                    }
                                }
                                if (restauranteZona.getIntentosReserva() != null) {
                                    for (ArrayList<Integer> intento : restauranteZona.getIntentosReserva()) {
                                        totalIntentos++;
                                        LocalDate fechaToDate = LocalDate.of(intento.get(0), intento.get(1), intento.get(2));
                                        if (fechaToDate.isAfter(LocalDate.now().minusDays(30)) &&
                                                fechaToDate.isBefore(LocalDate.now())) {
                                            intentosRestaurante.add(intento);
                                        }
                                    }
                                }

                                for (Mesa mesa : restauranteZona.getMesas()) {
                                    mesasRestaurantes.add(mesa);
                                }
                                reservasUltimosTreinta.addAll(reservasRestaurante);
                                intentosUltimosTreinta.addAll(intentosRestaurante);
                            }
                        }

                        //Demanda por Hora
                        int intentosReserva = intentosUltimosTreinta.size();
                        int horasFuncionamiento = reservasUltimosTreinta.size();
                        int totalMesas = mesasRestaurantes.size();

                        if (totalMesas != 0 && horasFuncionamiento != 0) {
                            double demandaPorHora = (intentosReserva / horasFuncionamiento) / totalMesas;

                            //Satisfacción del Cliente
                            double satisfaccionDelCliente = (reservasSatisfactorias / totalMesas) * 100;

                            //Conclusión Análisis
                            double conclusion = (demandaPorHora + satisfaccionDelCliente) / 2;

                            if (conclusion < 0.5) {
                                System.out.println("Según el algoritmo de análisis hecho, no es recomendable crear un " +
                                        "nuevo restaurante en " + ciudad.getNombre() + ".\nEsto se debe a que los " +
                                        "restaurantes de la ciudad tienen un flujo bajo de clientes y no están " +
                                        "cumpliendo con las expectativas de la gran mayoría de sus usuarios." +
                                        "\nTeniendo esto en cuenta, ¿Desea crear una nueva sede?\n1. Sí.\n2. No.");
                                boolean encendido2 = true;
                                do {
                                    int eleccion2 = Utilidad.readInt();
                                    switch (eleccion2) {
                                        case 1:
                                            parametrosBasicos(ciudad, restaurante);
                                            encendido2 = false;
                                            break;
                                        case 2:
                                            encendido2 = false;
                                            break;
                                        default:
                                            System.out.println("Ingrese un valor válido [1 - 2].");
                                    }
                                } while (encendido2);
                            } else if (conclusion >= 0.5 && conclusion <= 0.7) {
                                System.out.println("Según el algoritmo de análisis hecho, es medianamente recomendable " +
                                        "crear un nuevo restaurante en " + ciudad.getNombre() + ".\nEsto se debe a que " +
                                        "los restaurantes tienen un flujo medio de clientes y están cumpliendo con las " +
                                        "expectativas la mayoría de los usuarios.\nTeniendo esto en cuenta, ¿Desea " +
                                        "crear una nueva sede?\n1. Sí.\n2. No.");
                                boolean encendido3 = true;
                                do {
                                    int eleccion2 = Utilidad.readInt();
                                    switch (eleccion2) {
                                        case 1:
                                            parametrosBasicos(ciudad, restaurante);
                                            encendido3 = false;
                                            break;
                                        case 2:
                                            encendido3 = false;
                                            break;
                                        default:
                                            System.out.println("Ingrese un valor válido [1 - 2].");
                                    }
                                } while (encendido3);
                            } else {
                                parametrosBasicos(ciudad, restaurante);
                            }
                        } else {
                            parametrosBasicos(ciudad, restaurante);
                        }
                    }

                } else { //Si no se encuentra la ciudad
                    System.out.println("Por favor ingrese el nombre de la ciudad.");
                    Ciudad ciudad = new Ciudad(Utilidad.capitalize(Utilidad.readString()));
                    System.out.println("Por favor ingrese la cantidad de zonas que tiene la ciudad.");
                    int cantidadZonas = Utilidad.readInt();
                    //Este ciclo for se encarga de la creación de las zonas de la nueva ciudad.
                    for (int i = 1; i <= cantidadZonas; i++) {
                        System.out.println("Por favor ingrese el nombre de la zona #" + i + '.');
                        String nombreZona = Utilidad.capitalize(Utilidad.readString());
                        System.out.println("Por favor ingrese la población de la zona #" + i + '.');
                        int poblacionZona = Utilidad.readInt();
                        ciudad.getZonasCiudad().add(new Zona(poblacionZona, Utilidad.capitalize(nombreZona), ciudad));
                        ciudad.actualizarPoblacion();
                        System.out.println(ciudad.getZonasCiudad().getLast());
                    }
                    Utilidad.limpiarPantalla();
                    parametrosBasicos(ciudad, restaurante);
                }
                encendido1 = false;
            }
        } while (encendido1);
        return restaurante;
    }

    //Obtener los promedios de las diferentes características según los restaurantes existentes.
    public static int[] obtenerPromedios() {
        int[] valores = new int[5];
        int ancho = 0; //0
        int alto = 0; //1
        int mesasEstandar = 0; //2
        int mesasVIP = 0; //3
        int ventanas = 0; //4

        for (Zona zona : Zona.getZonas()) {
            for (Restaurante restaurante : zona.getRestaurantes()) {
                valores[0] = valores[0] + restaurante.getCoordX();
                valores[1] = valores[1] + restaurante.getCoordY();
                for (Mesa mesa : restaurante.getMesas()) {
                    if (!mesa.isVIP()) {
                        valores[2]++;
                    } else {
                        valores[3]++;
                    }
                }
                for (int i = 1; i < restaurante.getCoordY() + 1; i++) {
                    for (String string : restaurante.getDisposicion().get(i)) {
                        if (string.equals("W")) {
                            valores[4]++;
                        }
                    }
                }
            }
        }

        return valores;
    }

    //Este metodo se encarga de definir los parámetros básicos del restaurante: Ciudad, Zona, Zona VIP y Calificación
    public static void parametrosBasicos(Ciudad ciudad, Restaurante restaurante) {
        System.out.println(ciudad.getZonasCiudad());
        System.out.println("Zonas de " + ciudad.getNombre() + ":");
        Utilidad.listadoZonasCiudad(ciudad);
        System.out.println("Escriba un número para elegir la zona.\nEn caso de no encontrar la zona " +
                "requerida escriba 0.");
        int eleccionZona1 = Utilidad.readInt();
        if (eleccionZona1 > Ciudad.getCiudades().size() || eleccionZona1 < 0) {
            System.out.println("Ingrese un número válido [1 - " + ciudad.getZonasCiudad().size() + "].");
            parametrosBasicos(ciudad, restaurante);
        } else {
            Utilidad.limpiarPantalla();
            if (!(eleccionZona1 == 0)) { //Si se encuentra la zona
                Zona zonaElegida = ciudad.getZonasCiudad().get(eleccionZona1 - 1);
                //Se evalúa si existen restaurantes enlazados a esta zona.
                if (zonaElegida.getRestaurantes().isEmpty()) { //Si la zona elegida no tiene restaurantes
                    //Se enlaza la ciudad al restaurante
                    restaurante.setCiudad(ciudad);
                    //Se enlaza la zona al restaurante
                    restaurante.setZona(ciudad.getZonasCiudad().get(eleccionZona1 - 1));
                    //Se enlaza el restaurante a la zona
                    ciudad.getZonasCiudad().get(eleccionZona1 - 1).getRestaurantes().add(restaurante);
                    //Se enlaza el restaurante a la ciudad
                    ciudad.getRestaurantes().add(restaurante);
                    //Se establecen los parámetros básicos del restaurante
                    System.out.println("Ingrese el nombre del restaurante:");
                    String nombre = Utilidad.capitalize(Utilidad.readString());
                    restaurante.setNombre(nombre);
                    System.out.println("¿El restaurante tendrá zona VIP?\n1. Sí.\n2. No.\nEscriba un número para elegir.");
                    int tieneVIP = Utilidad.readInt();
                    if (tieneVIP == 1) {
                        restaurante.setZonaVIP(true);
                    } else if (tieneVIP == 2) {
                    } else {
                        System.out.println("Número no válido");
                    }
                    restaurante.setCalificacion((int) (Math.random() * 5) + 1);
                } else { //Si la zona elegida tiene restaurantes
                    //Análisis de reservas
                    ArrayList<Reserva> reservasUltimosTreinta = new ArrayList<Reserva>();
                    ArrayList<ArrayList<Integer>> intentosUltimosTreinta = new ArrayList<ArrayList<Integer>>();
                    ArrayList<Mesa> mesasRestaurantes = new ArrayList<Mesa>();

                    int reservasSatisfactorias = 0;
                    int totalIntentos = 0;

                    //Agregamos los datos que corresponden a los últimos 30 días de funcionamiento de los
                    // restaurantes de la ciudad correspondiente.
                    for (Restaurante restauranteZona : zonaElegida.getRestaurantes()) {
                        ArrayList<Reserva> reservasRestaurante = new ArrayList<Reserva>();
                        ArrayList<ArrayList<Integer>> intentosRestaurante = new ArrayList<ArrayList<Integer>>();
                        for (Reserva reserva : restauranteZona.getHistorialReservas()) {
                            if (reserva.isSatisfaccion()) {
                                reservasSatisfactorias++;
                            }
                            LocalDateTime fechaToDateTime = LocalDateTime.of(reserva.getFecha().get(0),
                                    reserva.getFecha().get(1), reserva.getFecha().get(2),
                                    reserva.getFecha().get(3), 0);
                            if (fechaToDateTime.isAfter(LocalDateTime.now().minusDays(30)) &&
                                    fechaToDateTime.isBefore(LocalDateTime.now()) &&
                                    reservasRestaurante.contains(fechaToDateTime) == false) {
                                reservasRestaurante.add(reserva);
                            }
                        }
                        if (restauranteZona.getIntentosReserva() != null) {
                            for (ArrayList<Integer> intento : restauranteZona.getIntentosReserva()) {
                                totalIntentos++;
                                LocalDate fechaToDate = LocalDate.of(intento.get(0), intento.get(1), intento.get(2));
                                if (fechaToDate.isAfter(LocalDate.now().minusDays(30)) &&
                                        fechaToDate.isBefore(LocalDate.now())) {
                                    intentosRestaurante.add(intento);
                                }
                            }
                        }

                        for (Mesa mesa : restauranteZona.getMesas()) {
                            mesasRestaurantes.add(mesa);
                        }
                        reservasUltimosTreinta.addAll(reservasRestaurante);
                        intentosUltimosTreinta.addAll(intentosRestaurante);
                    }


                    //Demanda por Hora
                    int intentosReserva = intentosUltimosTreinta.size();
                    int horasFuncionamiento = reservasUltimosTreinta.size();
                    int totalMesas = mesasRestaurantes.size();

                    if (totalMesas != 0 && horasFuncionamiento != 0) {
                        double demandaPorHora = (intentosReserva / horasFuncionamiento) / totalMesas;

                        //Satisfacción del Cliente
                        double satisfaccionDelCliente = (reservasSatisfactorias / totalMesas) * 100;

                        //Conclusión Análisis
                        double conclusion = (demandaPorHora + satisfaccionDelCliente) / 2;

                        if (conclusion < 0.5) {
                            System.out.println("Según el algoritmo de análisis hecho, no es recomendable crear un " +
                                    "nuevo restaurante en " + ciudad.getNombre() + ".\nEsto se debe a que los " +
                                    "restaurantes de la ciudad tienen un flujo bajo de clientes y no están " +
                                    "cumpliendo con las expectativas de la gran mayoría de sus usuarios." +
                                    "\nTeniendo esto en cuenta, ¿Desea crear una nueva sede?\n1. Sí.\n2. No.");
                            boolean encendido2 = true;
                            do {
                                int eleccion2 = Utilidad.readInt();
                                switch (eleccion2) {
                                    case 1:
                                        encendido2 = false;
                                        break;
                                    case 2:
                                        agregarSede();
                                        encendido2 = false;
                                        break;
                                    default:
                                        System.out.println("Ingrese un valor válido [1 - 2].");
                                }
                            } while (encendido2);
                        } else if (conclusion >= 0.5 && conclusion <= 0.7) {
                            System.out.println("Según el algoritmo de análisis hecho, es medianamente recomendable " +
                                    "crear un nuevo restaurante en " + ciudad.getNombre() + ".\nEsto se debe a que " +
                                    "los restaurantes tienen un flujo medio de clientes y están cumpliendo con las " +
                                    "expectativas la mayoría de los usuarios.\nTeniendo esto en cuenta, ¿Desea " +
                                    "crear una nueva sede?\n1. Sí.\n2. No.");
                            boolean encendido3 = true;
                            do {
                                int eleccion2 = Utilidad.readInt();
                                switch (eleccion2) {
                                    case 1:
                                        encendido3 = false;
                                        break;
                                    case 2:
                                        agregarSede();
                                        encendido3 = false;
                                        break;
                                    default:
                                        System.out.println("Ingrese un valor válido [1 - 2].");
                                }
                            } while (encendido3);
                        }
                    }

                    //Se enlaza la ciudad al restaurante
                    restaurante.setCiudad(ciudad);
                    //Se enlaza la zona al restaurante
                    restaurante.setZona(ciudad.getZonasCiudad().get(eleccionZona1 - 1));
                    //Se enlaza el restaurante a la zona
                    ciudad.getZonasCiudad().get(eleccionZona1 - 1).getRestaurantes().add(restaurante);
                    //Se enlaza el restaurante a la ciudad
                    ciudad.getRestaurantes().add(restaurante);
                    //Se establecen los parámetros básicos del restaurante
                    System.out.println("Ingrese el nombre del restaurante:");
                    String nombre = Utilidad.capitalize(Utilidad.readString());
                    restaurante.setNombre(nombre);
                    System.out.println("¿El restaurante tendrá zona VIP?\n1. Sí.\n2. No.\nEscriba un número para elegir.");
                    int tieneVIP = Utilidad.readInt();
                    if (tieneVIP == 1) {
                        restaurante.setZonaVIP(true);
                    } else if (tieneVIP == 2) {
                    } else {
                        System.out.println("Número no válido");
                    }
                    restaurante.setCalificacion((int) (Math.random() * 5) + 1);
                }

            } else { //Si no se encuentra la zona
                System.out.println("Por favor ingrese el nombre de la zona.");
                String nombreZona = Utilidad.capitalize(Utilidad.readString());
                System.out.println("Por favor ingrese la población de la zona.");
                int poblacionZona = Utilidad.readInt();
                ciudad.getZonasCiudad().add(new Zona(poblacionZona, Utilidad.capitalize(nombreZona), ciudad));
                ciudad.actualizarPoblacion();
                restaurante.setCiudad(ciudad);
                System.out.println("Zonas de " + ciudad.getNombre() + ":");
                Utilidad.listadoZonasCiudad(ciudad);
                System.out.println("Escriba un número para elegir la zona.\nEn caso de no encontrar la zona " +
                        "requerida escriba 0.");
                int eleccionZona2 = Utilidad.readInt();
                if (eleccionZona2 > Ciudad.getCiudades().size() || eleccionZona2 < 0) {
                    System.out.println("Ingrese un número válido [1 - " + ciudad.getZonasCiudad().size() + "].");
                } else {
                    Utilidad.limpiarPantalla();
                    //Se enlaza la ciudad al restaurante
                    restaurante.setCiudad(ciudad);
                    //Se enlaza la zona al restaurante
                    restaurante.setZona(ciudad.getZonasCiudad().get(eleccionZona2 - 1));
                    //Se enlaza el restaurante a la zona
                    ciudad.getZonasCiudad().get(eleccionZona2 - 1).getRestaurantes().add(restaurante);
                    //Se establecen los parámetros básicos del restaurante
                    System.out.println("¿El restaurante tendrá zona VIP?\n1. Sí.\n2. No.\nEscriba un número para " +
                            "elegir.");
                    int tieneVIP = Utilidad.readInt();
                    if (tieneVIP == 1) {
                        restaurante.setZonaVIP(true);
                    } else {
                    }
                    restaurante.setCalificacion((int) (Math.random() * 5) + 1);
                }
            }
        }
        System.out.println(restaurante.getCiudad());
        System.out.println(restaurante.getZona());
    }

    //Funcionalidad 4. Interacción 2: Establecer Disposicion
    public static Restaurante establecerDisposicion(Restaurante restaurante) {
        Utilidad.limpiarPantalla();
        if (Restaurante.restaurantesCreados > 3) {
            int[] promedios = obtenerPromedios();
            System.out.println("DISPOSICIÓN RECOMENDADA:\nTamaño:\n\tAncho = " + promedios[0] + "\n\tLargo = "
                    + promedios[1] + "\nMesas:\n\tEstándar = " + promedios[2] + "\n\tVIP = " + promedios[3] +
                    " (En caso de tener Zona VIP)\nVentanas = " + promedios[4]);
        } else {
            System.out.println("""
                    DISPOSICIÓN RECOMENDADA:
                    Tamaño:
                        Ancho = 10
                        Largo = 10
                    Mesas:
                        Estándar = 10
                        VIP = 4 (En caso de tener Zona VIP)
                    Ventanas = 4""");
        }
        editarRestaurante(restaurante);
        return restaurante;
    }

    //Este metodo se encarga de modificar el plano de un restaurante al momento de ser creado
    public static void editarRestaurante(Restaurante restaurante) {
        boolean encendido = true;
        int coordX, coordY;
        do {
            System.out.println("Ingresa el ancho del restaurante:");
            coordX = Utilidad.readInt();
            System.out.println("Ingresa el largo del restaurante:");
            coordY = Utilidad.readInt();
            if (coordX > 4 && coordY > 4) {
                encendido = false;
            } else {
                System.out.println("El valor mínimo de ancho y largo es de 5.");
            }
        } while (encendido);

        restaurante.setCapacidad(((coordX-1) * (coordY-1)) * 3);

        int modCoordX;
        int modCoordY;
        ArrayList<String> chars = new ArrayList<String>();
        restaurante.getDisposicion().add(chars);
        chars.add("╔"); //0 - Top Left
        chars.add("═"); //1 - Top Line
        chars.add("╦"); //2 - Top Intersection
        chars.add("╗"); //3 - Top Right
        chars.add("║"); //4 - Line
        chars.add("╠"); //5 - Right Intersection
        chars.add("╬"); //6 - Middle Intersection
        chars.add("╣"); //7 - Left Intersection
        chars.add("╚"); //8 - Bottom Left
        chars.add("╩"); //9 - Bottom Intersection
        chars.add("╝"); //10 - Bottom Right
        chars.add(" "); //11 - Blank
        for (int i = 0; i < coordY; i++) {
            ArrayList<String> listaActual = new ArrayList<String>();
            restaurante.getDisposicion().add(listaActual);
            if (restaurante.getDisposicion().size() == 2) {
                for (int j = 0; j < coordX; j++) {
                    listaActual.add("B");
                }
            } else if (restaurante.getDisposicion().size() > 2 && restaurante.getDisposicion().size() < coordY + 1) {
                listaActual.add("B");
                for (int j = 2; j < coordX; j++) {
                    listaActual.add(" ");
                }
                listaActual.add("B");
            } else {
                for (int j = 0; j < coordX; j++) {
                    listaActual.add("B");
                }
            }
        }
        String topRow = chars.get(0) + chars.get(1) + chars.get(1) + chars.get(1);
        for (int i = 2; i < coordX; i++) {
            topRow = topRow + chars.get(2) + chars.get(1) + chars.get(1) + chars.get(1);
        }
        topRow = topRow + chars.get(2) + chars.get(1) + chars.get(1) + chars.get(1) + chars.get(3);

        String separator = chars.get(5) + chars.get(1) + chars.get(1) + chars.get(1);
        for (int i = 2; i < coordX; i++) {
            separator = separator + chars.get(6) + chars.get(1) + chars.get(1) + chars.get(1);
        }
        separator = separator + chars.get(6) + chars.get(1) + chars.get(1) + chars.get(1) + chars.get(7);
        String bottomRow = chars.get(8) + chars.get(1) + chars.get(1) + chars.get(1);
        for (int i = 2; i < coordX; i++) {
            bottomRow = bottomRow + chars.get(9) + chars.get(1) + chars.get(1) + chars.get(1);
        }
        bottomRow = bottomRow + chars.get(9) + chars.get(1) + chars.get(1) + chars.get(1) + chars.get(10);

        imprimirDisposicionRestaurante(restaurante.getDisposicion(), coordX, coordY, chars, topRow, separator,
                bottomRow);
        cambiarElemento(restaurante, coordX, coordY, chars, topRow, separator, bottomRow);
        boolean modificando = true;
        do {
            System.out.println("¿Desea realizar otra modificación?\n1. Sí.\n2. No.\nEscriba un número para elegir " +
                    "su opción");
            int decision = Utilidad.readInt();
            switch (decision) {
                case 1:
                    cambiarElemento(restaurante, coordX, coordY, chars, topRow, separator, bottomRow);
                    break;
                case 2:
                    boolean tienePuerta = false;
                    for (Casilla casilla : restaurante.getCasillas()) {
                        if (casilla.getTipo().equals("PUERTA")) {
                            tienePuerta = true;
                        }
                    }
                    boolean tieneVentana = false;
                    for (Casilla casilla : restaurante.getCasillas()) {
                        if (casilla.getTipo().equals("VENTANA")) {
                            tieneVentana = true;
                        }
                    }
                    if (!restaurante.getMesas().isEmpty() && tienePuerta && tieneVentana) {
                        modificando = false;
                    } else {
                        Utilidad.limpiarPantalla();
                        System.out.println("Es necesario añadir como mínimo una entrada, una mesa y una ventana.");
                        modificando = true;
                    }
                    break;
                default:
                    System.out.println("Ingresa un número válido [1 - 2].");
                    break;
            }
        } while (modificando);
    }

    //Este metodo es un complemento de editarRestaurante
    private static void cambiarElemento(Restaurante restaurante, int coordX, int coordY,
                                        ArrayList<String> chars, String topRow, String separator, String bottomRow) {
        int modCoordX;
        int modCoordY;
        int tileType;
        Mesa mesa;
        System.out.println("Escribe la coordenada en X:");
        modCoordX = Utilidad.readInt();
        System.out.println("Escribe la coordenada en Y:");
        modCoordY = Utilidad.readInt();
        Casilla casilla = eliminarCasillasRepetidas(restaurante, modCoordX, modCoordY);
        if (modCoordY < 1 || modCoordY > coordY || modCoordX < 1 || modCoordX > coordX) {
            System.out.println("Escribe valores válidos para ambas coordenadas\nX = [1 - " + coordX + "]\n" +
                    "Y = [1 - " + coordY + "]");
            cambiarElemento(restaurante, coordX, coordY, chars, topRow, separator, bottomRow);
        } else {
            if ((modCoordY == 1 && modCoordX == 1) || (modCoordY == 1 && modCoordX == coordX) ||
                    (modCoordY == coordY && modCoordX == 1) || (modCoordY == coordY && modCoordX == coordX)) {
                System.out.println("No es posible realizar cambios en las esquinas del restaurante.");
                cambiarElemento(restaurante, coordX, coordY, chars, topRow, separator, bottomRow);
            } else if (modCoordY == 1 || modCoordY == coordY || modCoordX == 1 || modCoordX == coordX) {
                System.out.println("Reemplazar por:\n1. Pared (B).\n2. Ventana (W).\n3. Entrada (E).");
                tileType = Utilidad.readInt();
                switch (tileType) {
                    case 1:
                        restaurante.getDisposicion().get(modCoordY).set(modCoordX - 1, "B");
                        restaurante.getCasillas().remove(casilla);
                        break;
                    case 2:
                        restaurante.getDisposicion().get(modCoordY).set(modCoordX - 1, "W");
                        restaurante.getCasillas().remove(casilla);
                        restaurante.getCasillas().add(new Casilla(1, modCoordX, modCoordY));
                        break;
                    case 3:
                        restaurante.getDisposicion().get(modCoordY).set(modCoordX - 1, "E");
                        restaurante.getCasillas().remove(casilla);
                        restaurante.getCasillas().add(new Casilla(2, modCoordX, modCoordY));
                        break;
                    default:
                        System.out.println("Dato inválido. Se reemplazará por una pared.");
                        restaurante.getDisposicion().get(modCoordY).set(modCoordX - 1, "B");
                        restaurante.getCasillas().remove(casilla);
                }
            } else {
                System.out.println("Reemplazar por:\n1. Espacio Vacío ( ).\n2. Mesa Estándar (T).\n" +
                        "3. Mesa VIP (V).");
                tileType = Utilidad.readInt();
                switch (tileType) {
                    case 1:
                        restaurante.getDisposicion().get(modCoordY).set(modCoordX - 1, " ");
                        restaurante.getCasillas().remove(casilla);
                        restaurante.getMesas().remove(casilla);
                        break;
                    case 2:
                        restaurante.getDisposicion().get(modCoordY).set(modCoordX - 1, "T");
                        restaurante.getCasillas().remove(casilla);
                        restaurante.getMesas().remove(casilla);
                        mesa = new Mesa(0, modCoordX, modCoordY, false, 4);
                        restaurante.getCasillas().add(mesa);
                        restaurante.getMesas().add(mesa);
                        mesa.setFechasDisponibles(generarFechas());
                        break;
                    case 3:
                        if (restaurante.isZonaVIP()) {
                            restaurante.getDisposicion().get(modCoordY).set(modCoordX - 1, "V");
                            restaurante.getCasillas().remove(casilla);
                            restaurante.getMesas().remove(casilla);
                            mesa = new Mesa(0, modCoordX, modCoordY, true, 4);
                            restaurante.getCasillas().add(mesa);
                            restaurante.getMesas().add(mesa);
                            mesa.setFechasDisponibles(generarFechas());
                        } else { //En caso de que el restaurante no tenga zona VIP, se agregará una mesa estándar.
                            restaurante.getDisposicion().get(modCoordY).set(modCoordX - 1, "T");
                            restaurante.getCasillas().remove(casilla);
                            restaurante.getMesas().remove(casilla);
                            mesa = new Mesa(0, modCoordX, modCoordY, false, 4);
                            restaurante.getCasillas().add(mesa);
                            restaurante.getMesas().add(mesa);
                            mesa.setFechasDisponibles(generarFechas());
                        }
                        break;
                    default:
                        System.out.println("Dato inválido. Se reemplazará por un espacio vacío.");
                        restaurante.getCasillas().remove(casilla);
                        restaurante.getMesas().remove(casilla);
                        restaurante.getDisposicion().get(modCoordY).set(modCoordX - 1, " ");
                }
            }
            Utilidad.limpiarPantalla();
            imprimirDisposicionRestaurante(restaurante.getDisposicion(), coordX, coordY, chars, topRow, separator,
                    bottomRow);
        }
    }

    //Este metodo se encarga de crear las fechas, junto con las horas, en que una mesa está disponible.
    private static ArrayList<ArrayList<Integer>> generarFechas() {
        ArrayList<ArrayList<Integer>> fechasDisponibles = new ArrayList<ArrayList<Integer>>();
        LocalDate hoy = LocalDate.now();
        LocalDate fin = hoy.plusMonths(6);
        while (!hoy.isAfter(fin)) {
            ArrayList<Integer> fechas = new ArrayList<Integer>();
            fechas.add(hoy.getYear());
            fechas.add(hoy.getMonthValue());
            fechas.add(hoy.getDayOfMonth());
            fechas.add(10);
            fechas.add(12);
            fechas.add(14);
            fechas.add(16);
            fechas.add(18);
            fechas.add(20);
            fechasDisponibles.add(fechas);
            hoy = hoy.plusDays(1);
        }

        return fechasDisponibles;
    }

    //Este metodo se encarga de eliminar casillas obsoletas.
    private static Casilla eliminarCasillasRepetidas(Restaurante restaurante, int modCoordX, int modCoordY) {
        Casilla casillaObsoleta = new Casilla();
        for (Casilla casilla : restaurante.getCasillas()) {
            if (casilla.getCoordX() == modCoordX && casilla.getCoordY() == modCoordY) {
                casillaObsoleta = casilla;
                break;
            }
        }
        return casillaObsoleta;
    }

    //Este metodo se encarga de imprimir por pantalla el plano del restaurante deseado.
    private static void imprimirDisposicionRestaurante(ArrayList<ArrayList<String>> planoRestaurante, int coordX,
                                                       int coordY, ArrayList<String> chars, String topRow,
                                                       String separator, String bottomRow) {
        System.out.println(topRow);
        for (int i = 1; i <= coordY; i++) {
            int j = 0;
            String borderRow = chars.get(4) + chars.get(11) + planoRestaurante.get(i).get(j) + chars.get(11);
            for (int k = 2; k < coordX; k++) {
                j++;
                borderRow = borderRow + chars.get(4) + chars.get(11) + planoRestaurante.get(i).get(j) + chars.get(11);
            }
            borderRow = borderRow + chars.get(4) + chars.get(11) + planoRestaurante.get(i).get(j + 1) + chars.get(11) +
                    chars.get(4);
            System.out.println(borderRow);
            if (i == coordY) {
                System.out.println(bottomRow);
            } else {
                System.out.println(separator);
            }
        }
    }

    //Funcionalidad 4. Interacción 3: Establecer Menú y Encargos
    private static void establecerMenuYEncargos(Restaurante restaurante) {
        if (Restaurante.restaurantesCreados > 2) {
            //Establecer Menú
            ArrayList<Plato> menuTransitorio = Utilidad.listadoPlatosCalificacion(); //Listado de platos con mejor calificación.
            System.out.println("¿Desea modificar el menú generado?\n1. Sí.\n2. No.");
            int eleccion1 = Utilidad.readInt();
            switch (eleccion1) {
                case 2: //Si se quiere adoptar el menú generado
                    restaurante.setMenu(menuTransitorio);
                    break;
                case 1: //Si no se quiere adoptar el menú generado
                    boolean encendido1 = true;
                    do {
                        System.out.println("¿Qué desea hacer?\n1. Agregar.\n2. Eliminar.");
                        int eleccion2 = Utilidad.readInt();
                        int eleccion3 = 0;
                        switch (eleccion2) {
                            case 1: //Agregar
                                System.out.println("Platos existentes:");
                                for (Plato plato : Plato.getPlatos()) {
                                    if (!menuTransitorio.contains(plato)) {
                                        System.out.println(Utilidad.capitalize(plato.getNombre()));
                                    }
                                }
                                System.out.println("En caso de que quiera agregar uno de los platos mostrados en la " +
                                        "lista, ingrese el nombre tal como allí aparece.");
                                Plato plato = crearPlato();
                                menuTransitorio.add(plato);
                                System.out.println("¿Desea realizar otra modificación?\n1. Sí.\n2. No.");
                                eleccion3 = Utilidad.readInt();
                                if (eleccion3 != 1) {
                                    encendido1 = false;
                                }
                                break;
                            case 2: //Eliminar
                                for (Plato platoTransitorio : menuTransitorio) {
                                    System.out.println((menuTransitorio.indexOf(platoTransitorio) + 1) + ". " +
                                            platoTransitorio.getNombre());
                                }
                                System.out.println("Ingrese el número del plato a eliminar [1 - " +
                                        menuTransitorio.size() + "].");
                                int eleccion4 = Utilidad.readInt();
                                if (eleccion4 < 1 || eleccion4 > menuTransitorio.size()) {
                                    System.out.println("Número inválido.");
                                } else {
                                    menuTransitorio.remove(eleccion4 - 1);
                                }
                                System.out.println("¿Desea realizar otra modificación?\n1. Sí.\n2. No.");
                                eleccion3 = Utilidad.readInt();
                                if (eleccion3 != 1) {
                                    encendido1 = false;
                                }
                                break;
                            default:
                                System.out.println("Ingrese un valor válido [1 - 2].");
                                break;
                        }
                    } while (encendido1);
                    restaurante.setMenu(menuTransitorio);
                    break;
                default:
                    System.out.println("Ingrese un valor válido [1 - 2].");
                    establecerMenuYEncargos(restaurante);
                    break;
            }

            //Establecer Encargos
            cargamento(restaurante);
        } else {
            //Establecer Menú
            ArrayList<Plato> menuRestaurante = new ArrayList<Plato>();
            System.out.println("Ingrese la cantidad de platos que tendrá el menú:");
            int eleccion4 = Utilidad.readInt();
            for (int i = 0; i < eleccion4; i++) {
                menuRestaurante.add(crearPlato());
            }
            restaurante.setMenu(menuRestaurante);

            //Establecer Encargos
            cargamento(restaurante);
        }
    }

    private static void cargamento(Restaurante restaurante) {
        Cargamento cargamento = new Cargamento();

        System.out.println("Selección cantidad de ingredientes a encargar");
        for (Plato plato : restaurante.getMenu()) {
            System.out.println("Nombre: " + plato.getNombre() + "\nVeces pedido: " + plato.getVecesPedido());
            System.out.println("Ingredientes:");
            plato.getCantidadIngredientes();
            for (ArrayList<String> cantidadIngredientes : plato.getCantidadIngredientes()) {
                System.out.println("Cantidad de " + cantidadIngredientes.getFirst() + " necesitad@: " +
                        cantidadIngredientes.get(1));
                System.out.println("¿Cuánto de " + cantidadIngredientes.getFirst() + " quieres agregar?");
                int cantidadAgregar = Utilidad.readInt();
                cargamento.aumentarCantidadIngrediente(new ArrayList<String>(Arrays.asList(cantidadIngredientes.getFirst(),
                        String.valueOf(cantidadAgregar))));
            }
        }
        System.out.println("Selección cantidad de utilidades a encargar");
        for (String utilidad : Cargamento.UTILIDADES) {
            System.out.println("Nombre: " + utilidad);
            System.out.println("¿Cuánto de " + utilidad + " quieres agregar?");
            int cantidadAgregar = Utilidad.readInt();
            cargamento.getUtilidades().add(cantidadAgregar);
        }
        LocalDate fechaActual = LocalDate.now();
        System.out.println("¿Cada cuántos días quiere que venga el cargamento?");
        int frecuencia = Utilidad.readInt();
        cargamento.setFrecuencia(frecuencia);
        cargamento.setProximaEntrega(new ArrayList<Integer>(Arrays.asList(fechaActual.getYear(),
                fechaActual.getMonthValue(), fechaActual.getDayOfMonth())));
        restaurante.setCargamento(cargamento);
        cargamento.setRestaurante(restaurante);
    }

    public static Plato crearPlato() {
        System.out.println("Ingrese el nombre del plato:");
        String nombre = Utilidad.capitalize(Utilidad.readString());
        boolean existe = false;
        int indiceExiste = 0;
        Plato platoRetorno = new Plato();
        ArrayList<ArrayList<String>> cantidadIngredientes = new ArrayList<ArrayList<String>>();
        System.out.println(Plato.getPlatos());
        if (Plato.getPlatos().isEmpty() == true) {
            for (Plato plato : Plato.getPlatos()) {
                if (plato.getNombre().equals(nombre)) {
                    existe = true;
                    indiceExiste = Plato.getPlatos().indexOf(plato);
                    break;
                }
            }
        }
        if (!existe) {
            System.out.println("Ingrese el tipo del plato:\n1. Entradas.\n2. Platos Fuertes.\n3. Bebidas.\n4. " +
                    "Postres.\n5. Menú Infantil.\n6. Todos.");
            int eleccionTipo = Utilidad.readInt();
            switch (eleccionTipo) {
                case 1:
                    platoRetorno.setTipo("Entrada");
                    break;
                case 2:
                    platoRetorno.setTipo("Plato Fuerte");
                    break;
                case 3:
                    platoRetorno.setTipo("Bebida");
                    break;
                case 4:
                    platoRetorno.setTipo("Postre");
                    break;
                case 5:
                    platoRetorno.setTipo("Menú Infantil");
                    break;
                default:
                    platoRetorno.setTipo("Todos");
                    break;
            }
            System.out.println("Ingrese el precio del plato, sin decimales.");
            int precio = Utilidad.readInt();
            System.out.println("Ingrese la cantidad de ingredientes que tiene el plato.");
            int numIngredientes = Utilidad.readInt();
            if (numIngredientes < 1) {
                numIngredientes = 1;
            }
            Utilidad.limpiarPantalla();
            ArrayList<Ingrediente> listaIngredientes = Utilidad.listadoIngredientes();
            if (listaIngredientes != null) {
                for (int i = 0; i < listaIngredientes.size(); i++) {
                    System.out.println((i + 1) + ". " + listaIngredientes.get(i).getNombre() + '.');
                }
                ArrayList<Ingrediente> ingredientesPlato = new ArrayList<Ingrediente>();
                System.out.println("\nElija la situación que mejor se acomode a su situación actual con respecto a " +
                        "la lista presentada:\n1. Todos los ingredientes están presentes.\n2. Algunos ingredientes " +
                        "están presentes.\n3. Ningún ingrediente está presente.");
                boolean encendido1 = true;
                do {
                    int eleccion = Utilidad.readInt();
                    switch (eleccion) {
                        case 1:
                            System.out.println("Escriba el número de lista donde está cada uno de los " +
                                    numIngredientes + " ingredientes necesarios.");
                            for (int i = 0; i < numIngredientes; i++) {
                                System.out.println("Ingresa el número del ingrediente #" + (i + 1));
                                int indice = Utilidad.readInt() - 1;
                                Ingrediente ingrediente = Ingrediente.getIngredientes().get(indice);
                                ingredientesPlato.add(ingrediente);
                                System.out.println("Ingresa la cantidad necesaria de este ingrediente para la " +
                                        "preparación del plato");
                                int cantidadIngrediente = Utilidad.readInt();
                                if (cantidadIngrediente < 1) {
                                    cantidadIngrediente = 1;
                                }
                                cantidadIngredientes.add(new ArrayList<String>(Arrays.asList(ingrediente.getNombre(),
                                        String.valueOf(cantidadIngrediente))));
                            }
                            encendido1 = false;
                            break;
                        case 2:
                            System.out.println("Ingrese la cantidad de ingredientes que ya están presentes.");
                            int numIngExistentes = Utilidad.readInt();
                            if (numIngExistentes < 1) {
                                numIngExistentes = 1;
                            }
                            System.out.println("Escriba el número de lista donde está cada uno de los " +
                                    numIngExistentes + "ingredientes necesarios.");
                            for (int i = 0; i < numIngExistentes; i++) {
                                System.out.println("Ingresa el número del ingrediente #" + (i + 1));
                                int indice = Utilidad.readInt() - 1;
                                Ingrediente ingrediente = Ingrediente.getIngredientes().get(indice);
                                ingredientesPlato.add(ingrediente);
                                System.out.println("Ingresa la cantidad necesaria de este ingrediente para la " +
                                        "preparación del plato");
                                int cantidadIngrediente = Utilidad.readInt();
                                if (cantidadIngrediente < 1) {
                                    cantidadIngrediente = 1;
                                }
                                cantidadIngredientes.add(new ArrayList<String>(Arrays.asList(ingrediente.getNombre(),
                                        String.valueOf(cantidadIngrediente))));
                            }
                            for (int i = 0; i < (numIngredientes - numIngExistentes); i++) {
                                cantidadIngredientes = crearIngrediente(cantidadIngredientes, ingredientesPlato);
                            }
                            encendido1 = false;
                            break;
                        case 3:
                            for (int i = 0; i < numIngredientes; i++) {
                                cantidadIngredientes = crearIngrediente(cantidadIngredientes, ingredientesPlato);
                            }
                            encendido1 = false;
                            break;
                        default:
                            System.out.println("Ingrese un valor válido [1 - 3].");
                            break;
                    }
                } while (encendido1);
                platoRetorno = new Plato(nombre, precio, ingredientesPlato, cantidadIngredientes, 3);
            } else {
                ArrayList<Ingrediente> ingredientesPlato = new ArrayList<Ingrediente>();
                for (int i = 0; i < numIngredientes; i++) {
                    cantidadIngredientes = crearIngrediente(cantidadIngredientes, ingredientesPlato);
                }
                platoRetorno = new Plato(nombre, precio, ingredientesPlato, cantidadIngredientes, 3);
            }
        } else {
            platoRetorno = Plato.getPlatos().get(indiceExiste);
        }
        System.out.println(cantidadIngredientes);
        for (ArrayList<String> cantidad : cantidadIngredientes) {
            platoRetorno.getCantidadIngredientes().add(cantidad);
        }
        return platoRetorno;
    }

    public static ArrayList<ArrayList<String>> crearIngrediente(ArrayList<ArrayList<String>> cantidadIngredientes, ArrayList<Ingrediente> ingredientesPlato) {
        System.out.println("Ingrese el nombre del nuevo ingrediente.");
        String nombreIngrediente = Utilidad.capitalize(Utilidad.readString());
        System.out.println("Ingrese el precio unitario del nuevo ingrediente.");
        int precioIngrediente = Utilidad.readInt();
        if (precioIngrediente < 1) {
            precioIngrediente = 1;
        }
        Ingrediente ingrediente = new Ingrediente(nombreIngrediente, precioIngrediente);
        ingredientesPlato.add(ingrediente);
        System.out.println("Ingresa la cantidad necesaria de este ingrediente para la " +
                "preparación del plato");
        int cantidadIngrediente = Utilidad.readInt();
        if (cantidadIngrediente < 1) {
            cantidadIngrediente = 1;
        }
        cantidadIngredientes.add(new ArrayList<String>(Arrays.asList(ingrediente.getNombre(),
                String.valueOf(cantidadIngrediente))));
        return cantidadIngredientes;
    }

    //FUNCIONALIDAD CINCO
    public static void crearEvento() {
        Restaurante restaurante = new Restaurante();
        Factura factura = new Factura();
        boolean encendido = true;
        do {
            System.out.println("""
                    ¿Desea un evento?
                    1. Sí.
                    2. No.
                    Escriba un número para elegir su opción.""");
            int eleccion = Utilidad.readInt();
            switch (eleccion) {
                case 1:
                    System.out.println("Ciudades:");
                    Utilidad.listadoCiudades();

                    boolean encendido1 = false;
                    Ciudad ciudad = new Ciudad();
                    do {

                        System.out.println("Escriba un número para elegir la ciudad.\nEn caso de no encontrar la ciudad " +
                                "requerida escriba 0.");
                        int eleccion1 = Utilidad.readInt();
                        if (eleccion1 > Ciudad.getCiudades().size() || eleccion1 < 0) {
                            System.out.println("Ingrese un número válido [1 - " + Ciudad.getCiudades().size() + "].");
                            encendido1 = true;
                        } else {
                            ciudad = Ciudad.getCiudades().get(eleccion1 - 1);
                        }
                    } while (encendido1);

                    //Interacción 1
                    ArrayList<Cliente> cliente = recomendarLocalizacion(ciudad);
                    restaurante = cliente.getFirst().getRestaurante();

                    //Interacción 2
                    factura = recomendarEvento();

                    //Interacción 3
                    if (!(factura.getEvento() == new Factura().getEvento())) {
                        datos_horaReserva(restaurante, factura);
                    }

                    encendido = false;
                    break;
                case 2:
                    encendido = false;
                    break;
                default:
                    System.out.println("Ingrese un número válido [1 - 2].");
                    break;
            }

        } while (encendido);
    }
    //INTERACCIÓN #1 recomendarLocalización
    public static ArrayList<Cliente> recomendarLocalizacion(Ciudad ciudad) {
        Cliente cliente = new Cliente();

        Restaurante restaurante = null;

        //Primera parte, en donde se pide la ciudad y se hace las respectivas recomendaciones
        System.out.println("Desea que le recomendemos el restaurante con mayor capacidad:\n1. Sí, por favor.\n2. " +
                "No, deseo conocerlos todos");
        int eleccionRecomendacion = Utilidad.readInt();
        switch (eleccionRecomendacion) {
            case 1: //Si quiere que se le recomiende restaurante automaticamente.
                if (ciudad != null) {
                    restaurante = getRestaurante(ciudad);
                    cliente.setRestaurante(restaurante);
                }
                break;

            case 2:
                System.out.println("Zonas:");
                Utilidad.listadoZonasCiudad(ciudad);
                boolean encendido2 = false;
                do {
                    int eleccionZona = Utilidad.readInt();
                    if (eleccionZona < 1 || eleccionZona > ciudad.getZonasCiudad().size()) {
                        encendido2 = true;
                    } else {
                        Zona zona = ciudad.getZonasCiudad().get(eleccionZona - 1);
                        System.out.println("Restaurantes:");
                        Utilidad.listadoRestaurantesZona(zona);
                        boolean encendido3 = false;
                        do {
                            int eleccionRestaurante = Utilidad.readInt();
                            if (eleccionRestaurante < 1 || eleccionRestaurante > zona.getRestaurantes().size()) {
                                encendido3 = true;
                            } else {
                                restaurante = zona.getRestaurantes().get(eleccionRestaurante - 1);
                                cliente.setRestaurante(restaurante);
                            }
                        } while (encendido3);
                    }
                } while (encendido2);
                break;
        }

        System.out.println("Estimado Cliente, nos permite los siguientes datos:\nCédula:");
        int cedulaCliente = Utilidad.readInt();
        System.out.println("Nombre:");
        String nombreCliente = Utilidad.readString();
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        cliente.setNombre(nombreCliente);
        cliente.setCedula(cedulaCliente);

        if (Utilidad.existeCliente(cliente)) {
            cliente = Utilidad.clienteCedula(cliente);
            clientes.add(cliente);
        } else {
            Cliente.getClientes().add(cliente);
            clientes.add(cliente);
        }

        Reserva reserva = new Reserva();
        reserva.setClientes(clientes);
        reserva.setRestaurante(restaurante);

        restaurante.getHistorialReservas().add(reserva);
        restaurante.setClientes(clientes);

        boolean encendido1 = false;
        do {
            ArrayList<Integer> fecha = new ArrayList<Integer>();
            System.out.println("Ingrese el día de la reserva:");
            fecha.add(Utilidad.readInt());
            System.out.println("Ingrese el mes de la reserva:");
            fecha.add(Utilidad.readInt());
            System.out.println("Ingrese el año de la reserva:");
            fecha.add(Utilidad.readInt());

            reserva.setFecha(fecha);

            //Comprobar que no hay reservas para el día elegido.
            ArrayList<Reserva> reservasExistentes = restaurante.getHistorialReservas();
            for (Reserva reserva1 : reservasExistentes) {
                if (reserva1.getFecha().subList(0, 3) == reserva.getFecha()) {
                    System.out.println("Ya existe una reserva para la fecha elegida.");
                    encendido1 = true;
                }
            }
        } while (encendido1);

        return clientes;
    }

    //Metodo de la Interacción 1, el cual busca los restaurantes con mayor capacidad para el evento

    public static Restaurante getRestaurante(Ciudad ciudad) {
        Restaurante restauranteMayorCapacidad = null;
        int mayorCapacidad = 0;
        for (Zona zona : ciudad.getZonasCiudad()) {
            for (Restaurante restaurante : zona.getRestaurantes()) {
                if (restaurante.getCapacidad() > mayorCapacidad) {
                    restauranteMayorCapacidad = restaurante;
                    mayorCapacidad = restaurante.getCapacidad();
                }
            }
        }
        return restauranteMayorCapacidad;
    }


    //Método de la Interacción 1
    public static void listadoPlatosEvento(Evento evento) {
        List<Plato> platosEvento = evento.getPlatos();
        for (int i = 0; i < platosEvento.size(); i++) {
            System.out.println((i + 1) + ". " + platosEvento.get(i).getNombre());
        }
    }
    //Método de la Interacción 2

    public static Plato listadoPlatosEvento(Evento evento, int numeroInvitados, int opcion) {
        List<Plato> vinos_champanas = evento.getPlatos();
        List<Plato> vinos_lista = new ArrayList<>();
        List<Plato> champanas_lista = new ArrayList<>();
        Plato vinos_champan_ultimos = new Plato();
        int contador = 0;
        if (opcion == 1) {
            for (Plato nombreVino : vinos_champanas) {
                if (nombreVino.getNombre().toLowerCase().contains("vino")) {
                    vinos_lista.add(nombreVino);
                    contador++;
                    System.out.println(contador + ". " + nombreVino.getNombre());
                }
            }
            vinos_champan_ultimos = recomendacionMeeting(numeroInvitados, vinos_lista);
        }
        if (opcion == 2) {
            for (Plato nombreChampa : vinos_champanas) {
                if (!nombreChampa.getNombre().toLowerCase().contains("vino")) {
                    champanas_lista.add(nombreChampa);
                    contador++;
                    System.out.println(contador + ". " + nombreChampa.getNombre());
                }
            }
            vinos_champan_ultimos = recomendacionMeeting(numeroInvitados, champanas_lista);
        }


        return vinos_champan_ultimos;
    }
    //Método de la Interacción 2, el cual recomienda vinos y champañas dependiendo el la cantidad de los comensales
    public static Plato recomendacionMeeting(int numeroInvitados, List<Plato> eleccion) {
        Plato plato_final = new Plato();
        System.out.println("""
                Deseas conocer nuestras recomendaciones?:
                1. Sí, tomo la recomendación
                2. No, deseo ordenar por mi cuenta
                """);
        int opinion = Utilidad.readInt();
        if (opinion == 1) {
            if (numeroInvitados > 0 && numeroInvitados <= 8) { //Recomendacion para pocos invitados
                int botellasCantidad;
                Plato productoOfrecido = null;
                int contador = 0;
                System.out.println("Son pocas personas, suponiendo su alto rango, os recomendamos: ");
                ArrayList<Plato> botellasAllevar = new ArrayList<>();
                for (Plato caros : eleccion) {
                    if (caros.getPrecio() > 170000) {
                        botellasAllevar.add(caros);
                    }
                }
                for (Plato finales : botellasAllevar) {
                    contador++;
                    System.out.println(contador + ". " + finales.getNombre());
                }
                System.out.println("Cual deseais: ");
                int opcionMedia = Utilidad.readInt();
                productoOfrecido = botellasAllevar.get(opcionMedia - 1);

                if (numeroInvitados <= 4) {
                    botellasCantidad = 1;
                } else {
                    botellasCantidad = 2;
                }
                plato_final = new Plato(productoOfrecido.getNombre(), botellasCantidad, productoOfrecido.getPrecio());
            } else {
                System.out.println("Son bastantes invitados, para su economía os recomendamos: ");
                int cuentaBotellas = 0;
                Plato productoOfrecido = null;
                int contador = 0;
                ArrayList<Plato> botellasAllevar = new ArrayList<>();
                for (Plato baratos : eleccion) {
                    if (baratos.getPrecio() < 60000) {
                        botellasAllevar.add(baratos);
                    }
                }
                for (Plato finales : botellasAllevar) {
                    contador++;
                    System.out.println(contador + ". " + finales.getNombre());
                }
                System.out.println("Cual deseais: ");
                int opcionMedia = Utilidad.readInt();
                productoOfrecido = botellasAllevar.get(opcionMedia - 1);
                cuentaBotellas = (int) Math.ceil((double) numeroInvitados / productoOfrecido.getPorciones());
                System.out.println("Un total de " + cuentaBotellas + " botellas");
                plato_final = new Plato(productoOfrecido.getNombre(), cuentaBotellas, productoOfrecido.getPrecio());
            }
        } else {
            int cantidadBebida = 2;
            System.out.println("Cuál desea: ");
            for (int i = 0; i < eleccion.size(); i++) {
                System.out.println((i + 1) + ". " + eleccion.get(i).getNombre());
            }
            int opcion = Utilidad.readInt();
            Plato escogido = eleccion.get(opcion - 1);
            System.out.println("De " + escogido.getNombre() + "tenemos " + escogido.getCantidadDePlato() + " en bodega, Cúantos desea: ");
            int cantidadEscogida = Utilidad.readInt();
            if (cantidadEscogida <= escogido.getCantidadDePlato()) {
                cantidadBebida = cantidadEscogida;
                System.out.println("Excelente");
            } else {
                System.out.println("No poseemos esa cantidad, le vamos a vender la maxima cantidad");
                cantidadBebida = escogido.getCantidadDePlato();
            }
            plato_final = new Plato(escogido.getNombre(), cantidadBebida, escogido.getPrecio());

        }
        return plato_final;
    }
    //Método de la Interacción 2
    public static ArrayList<Plato> listado_final(String gastronomia_escogida) {
        for (ArrayList<Plato> listado_general : Plato.getPlatos_gastronomias()) {
            for (Plato plato : listado_general) {
                if (plato.getTipo().equals(gastronomia_escogida)) {
                    return listado_general;
                }
            }
        }
        return null;
    }
    //Este método hace parte de la interacción 2

    public static ArrayList<Plato> gastronomias_mundiales(int opcionGastronomias, ArrayList<String> gastronomias_nombres) {
        String gastronomia_escogida = gastronomias_nombres.get(opcionGastronomias - 1);
        ArrayList<Plato> escogidos;
        escogidos = listado_final(gastronomia_escogida);
        System.out.println("Para ello, ha preparado los siguientes platos: ");
        int contador = 0;
        for (Plato plato : escogidos) {
            contador++;
            System.out.println(contador + ". " + plato.getNombre());
        }
        return escogidos;
    }
    //Metodo de la Interacción 2
    public static Trabajador cocineroElegido(int opcionGastronomias, ArrayList<String> gastronomias_nombres) {
        String gastronomia_escogida = gastronomias_nombres.get(opcionGastronomias - 1);
        for (Trabajador trabajador_elegido : Trabajador.getCocineros()) {
            if (trabajador_elegido.getEspecialidad().equals(gastronomia_escogida)) {
                return trabajador_elegido;
            }
        }
        return null;
    }

    //Metodo de la Interacción 2
    public static void recomendacionPorCantidad(Evento evento, int numeroInvitados) {
        List<Plato> platosEvento = evento.getPlatos();
        Plato platoRecomendado = null;
        int diferenciaMinima = Integer.MAX_VALUE;

        for (Plato plato : platosEvento) {
            int diferencia = plato.getPorciones() - numeroInvitados;
            if (diferencia >= 0 && diferencia < diferenciaMinima) {
                diferenciaMinima = diferencia;
                platoRecomendado = plato;
            }
        }
        System.out.println("Vemos que son " + numeroInvitados + ", Les recomendamos la torta: " + platoRecomendado.getNombre() + ", que tiene porciones para " + platoRecomendado.getPorciones() + " personas");
    }

    //Interacción número 2
    public static Factura recomendarEvento() {
        Utilidad.limpiarPantalla();
        Evento evento1 = new Evento();
        Factura factura = new Factura();
        Cliente cliente = new Cliente();
        System.out.println("""
                ¿Eres afiliado?
                1. Si
                2. No
                """);
        int respuestaAfiliacion = Utilidad.readInt();
        if (respuestaAfiliacion == 1) {
            cliente.esAfiliado();
        } else {
            System.out.println("Dale, no hay lio");
        }
        boolean encendido1 = true;
        boolean encendido2 = true;
        do {
            System.out.println("¿Desea conocer las temáticas de Eventos especiales qué tenemos?");
            System.out.println("1. Sí, por favor");
            System.out.println("2. No");
            int opcionEvento = Utilidad.readInt();
            switch (opcionEvento) {
                case 1:
                    do{
                        System.out.println("1. Cumpleaños.\n" +
                                "2. Meetings Empresariales.\n" +
                                "3. Gastronomias Mundiales.\n" +
                                "4. No, salir.\n" +
                                "Escriba un número para elegir su opción.");
                        int opcionFinal = Utilidad.readInt();
                        switch (opcionFinal) {
                            case 1:
                                Factura factura_cumple = new Factura();
                                System.out.println("¿Cuántos invitados son?");
                                int numeroInvitados = Utilidad.readInt();
                                System.out.println("El Evento tiene un coste de 210.000$, ¿Desea continuar?");
                                System.out.println("1.Sí");
                                System.out.println("2.No");
                                int RespuestaCumple = Utilidad.readInt();
                                if (RespuestaCumple == 1) {
                                    new Plato();
                                    Plato torta_seleccionada = null;

                                    String nombreRespuesta = "Cumpleanos Feliz";
                                    int coste = 210000;
                                    for (Evento elemento : Evento.getEventos()) {
                                        if (elemento.getNombre().equals(nombreRespuesta)) {
                                            evento1 = elemento;
                                        }
                                    }
                                    System.out.println("Perfecto! Danos el nombre del festejado:");
                                    String nombreFestejado = Utilidad.readString();
                                    String descripcionEvento = ("Feliz Cumpleaños!!! Te deseamos lo mejor en esta etapa " + nombreFestejado);
                                    System.out.println("A continuación verá las tortas para la ocasión: ");
                                    listadoPlatosEvento(evento1);
                                    recomendacionPorCantidad(evento1, numeroInvitados); //Planear qué pasaría sí hay un excedente
                                    System.out.println("Digite la opción de la torta: ");
                                    int pastelEscogido = Utilidad.readInt();
                                    if (!(pastelEscogido == 0)) {
                                        torta_seleccionada = evento1.getPlatos().get(pastelEscogido - 1);
                                        torta_seleccionada.descontarPlato(1);  //Hasta acá llega la parte de la planeación del excedente
                                    }
                                    ArrayList<Plato> platosDeEsteEvento = new ArrayList<>();
                                    platosDeEsteEvento.add(torta_seleccionada);  //Para esto, crear un métodp que sea meterle estas 3 cosas

                                    evento1.setNombreEvento(nombreRespuesta);
                                    evento1.setDescripcion(descripcionEvento);
                                    evento1.setCoste(coste);
                                    evento1.setPlatos(platosDeEsteEvento);
                                    factura_cumple.setEvento(evento1);
                                    factura = factura_cumple;
                                    encendido2 = false;
                                } else {
                                    System.out.println("No hay problema, te mostraremos de nuevo el menú de eventos");
                                    encendido2 = true;
                                }
                                break;
                            case 2:
                                Factura factura_meeting = new Factura();
                                Plato vino_champana_final = new Plato();
                                System.out.println("El Evento tiene un coste de 450.000$, ¿Desea continuar?");
                                System.out.println("1. Sí");
                                System.out.println("2. No");
                                int RespuestaMeeting = Utilidad.readInt();
                                if (RespuestaMeeting == 1) {
                                    System.out.println("¿Cuántos asistentes son?");
                                    int numeroInvitados_meeting = Utilidad.readInt();
                                    System.out.println("Digite el NIT de la empresa: ");
                                    int NIT = Utilidad.readInt();
                                    ArrayList<Plato> platosAfiliacionMeeting = new ArrayList<>();
                                    Trabajador cocineroOcasion = new Trabajador();
                                    ArrayList<Plato> platosMeeting = new ArrayList<Plato>(); //Revisar
                                    String descripcionEvento = "Una empresa que demustra su talento, seriedad y humanidad"; //Sujeto a cambio
                                    String nombreRespuesta = "Meetigns Empresarial";
                                    int coste = 450000;//Evaluar esto
                                    for (Evento elemento : Evento.getEventos()) {
                                        if (elemento.getNombre().equals(nombreRespuesta)) {
                                            evento1 = elemento;
                                        }
                                    }
                                    System.out.println("""
                                            Tenemos las siguientes opciones para acompañar el meeting:
                                            1. Vino.
                                            2. Champaña.
                                            """);
                                    int opcionVino_Champana = Utilidad.readInt();
                                    vino_champana_final = listadoPlatosEvento(evento1, numeroInvitados_meeting, opcionVino_Champana);
                                    platosMeeting.add(vino_champana_final);

                                    if (cliente.esAfiliado()) {
                                        System.out.println("""
                                                Vemos que eres afiliado, deseas redimir tú derecho
                                                1. Si
                                                2. No""");
                                        int opcionCumpleFinal = Utilidad.readInt();

                                        if (opcionCumpleFinal == 1) {
                                            for (Trabajador cocineroEnCuestion : Trabajador.getCocineros()) {
                                                if (cocineroEnCuestion.getEspecialidad().equals("Sonmerlier")) {
                                                    cocineroOcasion = cocineroEnCuestion;
                                                    cocineroEnCuestion.pagoExtraServicio(Evento.getEventos(), cocineroEnCuestion.getEspecialidad());
                                                    for (Plato plato : Plato.getPlatos_varios()) {
                                                        if (plato.getNombre().equals("Bagget")) {
                                                            platosAfiliacionMeeting.add(plato);
                                                            plato.descontarPlato(numeroInvitados_meeting);
                                                        }

                                                    }
                                                    for (Plato plato : Plato.getPlatos_varios()) {
                                                        if (plato.getNombre().equals("Queso mediterraneo")) {
                                                            platosAfiliacionMeeting.add(plato);
                                                            plato.descontarPlato(numeroInvitados_meeting);
                                                        }
                                                    }
                                                }
                                            }
                                            System.out.println("Excelente, de nuestra parte os damos a nuestro mejor sonmelier " + cocineroOcasion.getNombre() + "que ha de preparar el mejor " + platosAfiliacionMeeting.get(1).getNombre() + "acompañado de unos deliciosos " + platosAfiliacionMeeting.getFirst().getNombre());
                                        }
                                    }
                                    evento1.setNombreEvento(nombreRespuesta);
                                    evento1.setDescripcion(descripcionEvento);
                                    evento1.setCoste(coste);
                                    evento1.setPlatos(platosMeeting);
                                    factura_meeting.setEvento(evento1);
                                    factura = factura_meeting;
                                    encendido2 = false;
                                } else {
                                    System.out.println("Te retornaremos al menú de eventos");
                                    encendido2 = true;
                                }
                                break;
                            case 3:
                                ArrayList<Plato> platosAfiliacionGastro = new ArrayList<>();
                                Trabajador chef;
                                ArrayList<Plato> final_gastro_evento;
                                ArrayList<Plato> platos_pedidos = new ArrayList<>();
                                ArrayList<String> gastronomias_nombres = new ArrayList<>();
                                gastronomias_nombres.add("Italiana");
                                gastronomias_nombres.add("Japonesa");
                                gastronomias_nombres.add("Marroquí");
                                gastronomias_nombres.add("Francesa");
                                System.out.println("""
                                        El servicio tiene un costo de 345000, deseas continuar:
                                        1. Sí, por favor.
                                        2. No, así está bien.
                                        """);
                                int respuesta = Utilidad.readInt();
                                if (respuesta == 1) {
                                    System.out.println("""
                                            Gastronomias mundiales, escoge la de tu preferencia:
                                            1.Italiana
                                            2.Japonesa
                                            3.Marroquí
                                            4.Francesa
                                            Dijite la opcion de su preferencia:\s
                                            """);
                                    int opcionGastronomias = Utilidad.readInt();
                                    System.out.println("¿Cuántos comensales son? ");
                                    int numeroInvitadosGastro = Utilidad.readInt();
                                    String tipoEvento = gastronomias_nombres.get(opcionGastronomias - 1);
                                    chef = cocineroElegido(opcionGastronomias, gastronomias_nombres);
                                    System.out.println("El/la chef " + chef.getNombre() + " te va a acopañar en esta velada");
                                    final_gastro_evento = gastronomias_mundiales(opcionGastronomias, gastronomias_nombres);
                                    boolean escoger = true;
                                    System.out.println("Cual de ellos gusta: ");
                                    int leer = Utilidad.readInt();
                                    System.out.println("Excelente, de ese plato tenemos " + final_gastro_evento.get(leer - 1).getCantidadDePlato() + ", cuantos desea?");
                                    int a = Utilidad.readInt();
                                    Plato primer_plato = final_gastro_evento.get(leer - 1);
                                    primer_plato.setVecesPedido(a);
                                    primer_plato.descontarPlato(a);
                                    platos_pedidos.add(primer_plato);
                                    final_gastro_evento.get(leer - 1).descontarPlato(a);
                                    final_gastro_evento.remove(leer - 1);

                                    //                    while (escoger) {
                                    System.out.println("""
                                            Desea ordenar otros platos?:
                                            1. Sí, deseo ordenar más platos.
                                            2. No, así está bien.
                                            """);
                                    int leer2 = Utilidad.readInt();
                                    if (leer2 == 1) {
                                        while (encendido1)
                                            if (!(final_gastro_evento.isEmpty())) {
                                                System.out.println("Por supuesto, he aquí de nuevo el menú con el resto de plato:");
                                                int contador = 0;
                                                for (Plato dadada : final_gastro_evento) {
                                                    contador++;
                                                    System.out.println(contador + ". " + dadada.getNombre());
                                                }
                                                System.out.println("Digite el que guste pedir: ");
                                                int leer3 = Utilidad.readInt();
                                                if (leer3 < final_gastro_evento.size() + 1){
                                                    System.out.println("Listo, este plato cuenta con " + final_gastro_evento.get(leer3 - 1).getCantidadDePlato() + " existencias, ¿Cuántas desea?");
                                                    int b = Utilidad.readInt();
                                                    Plato platos_venideros = final_gastro_evento.get(leer3 - 1);
                                                    if (b <= platos_venideros.getCantidadDePlato()) {
                                                        platos_venideros.setVecesPedido(b);
                                                        platos_venideros.descontarPlato(b);
                                                        platos_pedidos.add(platos_venideros);
                                                        final_gastro_evento.remove(leer3 - 1);
                                                    } else {
                                                        System.out.println("La cantidad de los pedidos excede la cantidad de existencias, por ello vamos a asiganr todos los platos disponibles");
                                                        b = platos_venideros.getCantidadDePlato();
                                                        platos_venideros.setVecesPedido(b);
                                                        platos_venideros.descontarPlato(b);
                                                        platos_pedidos.add(platos_venideros);
                                                        final_gastro_evento.remove(leer3 - 1);
                                                    }
                                                    System.out.println("""
                                                        Desea seguir ordenando:
                                                        1. Sí.
                                                        2. No""");
                                                    int respuesta2 = Utilidad.readInt();
                                                    if (!(final_gastro_evento.isEmpty())) {
                                                        if (respuesta2 == 1) {
                                                            encendido1 = true;
                                                        } else {
                                                            System.out.println("Un gusto haberle atendido");
                                                            encendido1 = false;
                                                        }

                                                    } else {
                                                        System.out.println("Lo sentimos, pero no hay más platos para mostrarte");
                                                        break;
                                                    }
                                                }else{
                                                    System.out.println("Digite un número dentro del rango expuesto");
                                                    encendido1=true;
                                                }
                                            }
                                    } else {
                                        System.out.println("Agradecemos tú confianza");
                                    }
                                    //PARTE ULTIMA
                                    if (cliente.esAfiliado()) {
                                        System.out.println("""
                                                Vemos que eres afiliado, deseas redimir tú derecho
                                                1. Si
                                                2. No""");
                                        int opcionCumpleFinal = Utilidad.readInt();

                                        if (opcionCumpleFinal == 1) {

                                            for (Plato plato : Plato.getPlatos_varios()) {
                                                if (plato.getTipo().equals(tipoEvento)) {
                                                    platosAfiliacionGastro.add(plato);
                                                    plato.descontarPlato(numeroInvitadosGastro);
                                                    System.out.println("Excelente, el chef " + chef.getNombre() + " ha preparado " + numeroInvitadosGastro + " " + plato.getNombre());
                                                }

                                            }
                                        }
                                    }
                                    Evento eventoGastronomias = new Evento("Gastronomias mundiales", 345000, platos_pedidos, tipoEvento);
                                    eventoGastronomias.setNombreMotivo(gastronomias_nombres.get(opcionGastronomias - 1));
                                    eventoGastronomias.setCoste(345000);
                                    eventoGastronomias.setDescripcion("Cata gastronómica");
                                    evento1 = eventoGastronomias;
                                    factura.setEvento(eventoGastronomias);
                                    encendido2 = false;
                                }
                                else {
                                    System.out.println("Te retornaremos al menú de eventos");
                                    encendido2 = true;
                                }
                                break;
                            case 4:
                                encendido2 = false;
                                break;
                        }
                    } while(encendido2);
                case 2:
                    encendido1 = false;
                    break;
                default:
                    System.out.println("Ingrese un número válido [1 - 2].");
                    break;
            }
        } while (encendido1);
        return factura;
    }

    //Metodo de la Interacción 3
    public static void listado_precios_factura(Factura factura, ArrayList<Integer> reserva, boolean diaFinDeSemana) {
        ArrayList<Plato> platos = factura.getEvento().getPlatos();
        System.out.println("He aquí su consumo: ");
        int acomulado_total = 0;
        for (Plato plato : platos) {
            System.out.println(plato.getNombre() + "   X" + plato.getVecesPedido() + "   ... " + (plato.getVecesPedido() * plato.getPrecio()));
            acomulado_total += plato.getVecesPedido() * plato.getPrecio();
        }

        if (diaFinDeSemana) {
            if (reserva.get(3) > 20) {
                acomulado_total += (int) (acomulado_total * (0.08));
            } else {
                acomulado_total += (int) (acomulado_total * (0.03));
            }
        }
        acomulado_total += factura.getEvento().getCoste();


        System.out.println("El total de su factura es: " + acomulado_total);
    }
    //Método de la Interacción 3

    public static void formato_factura_evento(Restaurante restaurante, Factura factura, ArrayList<Integer> reserva, boolean diaFinDeSemana){
        Utilidad.limpiarPantalla();
        Evento eventoFactura = factura.getEvento();
        System.out.println(".............. " + restaurante.getNombre() + " ..............");
        System.out.println("Cliente: " + restaurante.getClientes().getFirst().getNombre());
        System.out.println("Cédula: " + restaurante.getClientes().getFirst().getCedula());
        listado_precios_factura(factura, reserva, diaFinDeSemana);
        if (Objects.equals(eventoFactura.getNombre(), "Meetigns Empresarial")){
            System.out.println(factura.getEvento().getDescripcion());
        }
        if (Objects.equals(eventoFactura.getNombre(), "Cumpleanos Feliz")){
            System.out.println(factura.getEvento().getDescripcion());
        }
        if (Objects.equals(eventoFactura.getNombre(), "Gastronomias mundiales")){
            System.out.println(".............. " + eventoFactura.getDescripcion() +" ..............");
            if (eventoFactura.getTipoEvento() == "Italiana"){
                System.out.println(".....grazie per aver fiducia nel nostro ristorante....");
            }
            if (eventoFactura.getTipoEvento() == "Japonesa"){
                System.out.println("..Toten o shinrai shite itadaki arigatogozaimasu..");
            }
            if (eventoFactura.getTipoEvento() == "Marroquí"){
                System.out.println(".......شكرا لك على الثقة في مطعمنا........");
            }
            if (eventoFactura.getTipoEvento() == "Francesa"){
                System.out.println(".....Merci de faire confiance à notre restaurante");
            }

        }
    }

    //Interacción 3
    public static String datos_horaReserva(Restaurante restaurante, Factura factura) {
//        ArrayList<Plato> platos = factura.getEvento().getPlatos();
        Utilidad.limpiarPantalla();
        System.out.println("""
                Estimado Cliente, el día de su reserva se encuentra entre Viernes, Sábado o Domingo:
                1. Si
                2. No
                """);
        boolean diaFinDeSemana = false;
        ArrayList<Integer> reserva = new ArrayList<Integer>();
        int respuesta = Utilidad.readInt();
        switch (respuesta){
            case 1:
                System.out.println("Listo, por ello tenemos un recargo del 8%");
                diaFinDeSemana = true;
                System.out.println("Estimado Cliente, nos regala la hora a la que desea el evento (HH:MM): ");
                String hora_evento = Utilidad.readString();
                String [] fraccion = hora_evento.split(":");
                int hora_evento_real = Integer.parseInt(fraccion[0]);
                reserva = restaurante.getHistorialReservas().getLast().getFecha();
                reserva.add(hora_evento_real);
                System.out.println(reserva);
                break;
            case 2:
                System.out.println("Ten una maravillosa velada");
                reserva = null;
        }
        formato_factura_evento(restaurante, factura, reserva, diaFinDeSemana);
        return null;
    }


}