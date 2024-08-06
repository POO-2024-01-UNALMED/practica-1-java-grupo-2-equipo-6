package uiMain;

import gestorAplicacion.Entorno.Ciudad;
import gestorAplicacion.Entorno.Zona;
import gestorAplicacion.Gestion.Plato;
import gestorAplicacion.Gestion.Reserva;
import gestorAplicacion.Gestion.Restaurante;
import gestorAplicacion.Gestion.Factura;
import gestorAplicacion.Usuario.Cliente;
import gestorAplicacion.Gestion.Evento;

import java.util.Scanner;

import static uiMain.Main.*;
import static uiMain.Utilidad.*;

import java.util.ArrayList;
import java.util.List;

public class Funcionalidad5 {
    static Scanner input = new Scanner(System.in);
    static void printLn(Object obj) {
        System.out.println(obj);
    }

    static void print(Object obj) {
        System.out.println(obj);
    }

    static byte readByte() {
        return input.nextByte();
    }

    static int readInt() {
        return input.nextInt();
    }

    static String readString() {
        return input.next();
    }

    static double readDouble() {
        return input.nextDouble();
    }

    public static Restaurante CrearEvento() {
        Restaurante restaurante = new Restaurante();
        Factura factura = new Factura();
        boolean encendido = true;
        do {
            System.out.println("""
                    ¿Desea un evento?
                    1. Sí.
                    2. No.
                    Escriba un número para elegir su opción.""");
            int eleccion = readInt();
            switch (eleccion) {
                case 1:
                    System.out.println("Interacción 1.");
//                    restaurante = recomendarLocalizacion(restaurante);
//                    printLn(restaurante.getTodo());
//                    for (Reserva reserva: restaurante.getReservas()){
//                        printLn(reserva.getFecha());
//                    }
                    printLn("Interaccion2");
                    factura = recomendarEvento();
                    printLn(factura.toString());

//                    editarRestaurante(restaurante);
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
        return restaurante;
    }
    public static Restaurante recomendarLocalizacion(Restaurante restaurante) {
        Cliente clientePP = new Cliente();
        Reserva reservaPP = new Reserva();
        Restaurante restauranteElegido = new Restaurante();
        boolean encendido = true;

        //Primera parte, en donde se pide la ciudad y se hace las respectivas recomendaciones
        do {
            printLn("Indica por favor la ciudad donde realizar el evento: ");
            String CiudadEvento = readString().toUpperCase(); //Ciudades con mayusculas y sin tilde
            Ciudad ciudadRequerida = ciudades.stream()
                    .filter(ciudad -> ciudad.getNombreCiudad().equalsIgnoreCase(CiudadEvento))
                    .findFirst()
                    .orElse(null);

            printLn("Desea que le recomendemos el restaurante con mayor capacidad: ");
            printLn("1.Sí, por favor");
            printLn("2.No, deseo conocerlos todos");
            int opcionRecomentacion = readInt();
            switch (opcionRecomentacion) {
                //Primera parte Sí
                case 1:
                    if (ciudadRequerida != null) {
                        restauranteElegido = getRestaurante(ciudadRequerida);
                        print(restauranteElegido.getNombreRestaurante());
                    } else {
                        printLn("Algo anda mal");
                    }
                    encendido = false;
                    break;

                case 2:
                    if (ciudadRequerida != null) {
                        printLn("Digita el restaurante que deseas");
                        listadoZonasPorCiudad(ciudadRequerida);
                        int opcionRecomendacion2 = readInt();
                        if (!(opcionRecomendacion2 == 0)) {
                            restauranteElegido = ciudadRequerida.getZonas().get(opcionRecomendacion2 - 1).RestauranteZona;
                        }
                    } else {
                        System.out.println("Ciudad no encontrada");
                    }
                    encendido = false;
                    break;
            }
        } while (encendido);

        printLn("Estimado Cliente, nos permite los siguientes datos: Cédula ");
        double cedulaCliente = readInt();
        printLn("Nombre: ");
        String nombreCliente = readString();
        printLn("Día de la reserva (dd/mm/aa)");
        String fechaReserva = readString();
        clientePP.setNombre(nombreCliente);
        clientePP.setCedula((int) cedulaCliente);
        reservaPP.setFecha(fechaReserva);
        restauranteElegido.agregarReserva(reservaPP);
        restauranteElegido.setCliente(clientePP);
        printLn(restauranteElegido.getCliente());
        return restauranteElegido;
        //Segunda parte, donde se muestran las reservas y se crea al cliente
    }

    public static Restaurante getRestaurante(Ciudad ciudadRequerida) {
        Restaurante restauranteMayorCapacidad = null;
        int mayorCapacidad = 0;
        for (Zona zona : ciudadRequerida.getZonas()) {
            Restaurante variable = zona.RestauranteZona;
            if (variable.getCapacidad() > mayorCapacidad) {
                restauranteMayorCapacidad = variable;
                mayorCapacidad = variable.getCapacidad();
            }
        }
        return restauranteMayorCapacidad;
    }

    //PREGUNTARLE A COLO
    public static void listadoZonasPorCiudad(Ciudad ciudadRequerida) {
        List<Zona> zonasCiudad = ciudadRequerida.getZonas();
        for (int i = 0; i < zonasCiudad.size(); i++) {
            printLn((i + 1) + ". " + zonasCiudad.get(i).getNombreRestaurante() + "...");
        }
    }
    public static void listadoPlatosEvento(Evento evento) {
        List<Plato> platosEvento = evento.getPlatos();
        for (int i = 0; i < platosEvento.size(); i++) {
            printLn((i + 1) + ". " + platosEvento.get(i).getNombre());
        }
    }
    public static void listadoPlatosEvento(Evento evento, int numeroInvitados, int opcion){
        List<Plato> vinos_champanas = evento.getPlatos();
        List<Plato> vinos_lista = new ArrayList<>();
        List<Plato> champanas_lista = new ArrayList<>();
//        List<String> vinos = null;
        int contador = 0;
        if (opcion == 1){
            for (Plato nombreVino : vinos_champanas){
                if (nombreVino.getNombre().toLowerCase().contains("vino")){
                    vinos_lista.add(nombreVino);
                    contador++;
                    printLn(contador + ". " + nombreVino.getNombre());
                }
            }
            recomendacionMeeting(numeroInvitados, vinos_lista);
        }
        if (opcion == 2){
            for (Plato nombreChampa : vinos_champanas){
                if (!nombreChampa.getNombre().toLowerCase().contains("vino")){
                    champanas_lista.add(nombreChampa);
                    contador++;
                    printLn(contador + ". " + nombreChampa.getNombre());
                }
            }
            recomendacionMeeting(numeroInvitados, champanas_lista);
        }
    }

    public static void recomendacionMeeting(int numeroInvitados, List<Plato> eleccion){
        int botellasEnTotal = 0;
        Plato productoFinal = null;
        if (numeroInvitados > 0 && numeroInvitados <= 8){
            int botellasCantidad = 0;
            Plato productoOfrecido = null;
            int contador = 0;
            printLn("Son pocas personas, suponiendo su alto rango, os recomendamos: ");
            for (Plato caros : eleccion){
                ArrayList<Plato> botellasAllevar = new ArrayList<>();
                if (caros.getPrecio() > 170000){
                    contador++;
                    botellasAllevar.add(caros);
                    printLn(contador + ". " + caros.getNombre());
                }
                printLn("Cual deseais: ");
                int opcionMedia = readInt();
                productoOfrecido = botellasAllevar.get(opcionMedia-1);
                if (numeroInvitados <= 4){
                    botellasCantidad = 1;
                }else{
                    botellasCantidad=2;
                }
            }
        }
        else{
            printLn("Son bastantes invitados, para su economía os recomendamos: ");
            int cuentaBotellas = 0;
            Plato productoOfrecido = null;
            for (Plato baratos : eleccion){
                ArrayList<Plato> botellasAllevar = new ArrayList<>();
                if (baratos.getPrecio() < 60000){
                    botellasAllevar.add(baratos);
                    cuentaBotellas = (int)Math.ceil((double) numeroInvitados /baratos.getPorciones());
                    printLn(baratos.getNombre());
                }
                printLn("Cual deseais: ");
                int opcionMedia = readInt();
                productoOfrecido = botellasAllevar.get(opcionMedia - 1);
                printLn("Un total de " + cuentaBotellas + " botellas");

            }

        }
        printLn("""
                Si no os gusta la recomendación, podeis pedir libre:
                1. Sí, tomo la recomendación
                2. No, deseo ordenar por mi cuenta
                """);
        int opinion = readInt();
        if (opinion == 1){
            printLn("Melo, ahora me ocupo de esto");


        }else{
            printLn("Cuál vino desea: ");
            for (int i = 0; i < eleccion.size(); i++) {
                printLn((i + 1) + ". " + eleccion.get(i).getNombre());
            }
            int opcion = readInt();
            Plato escogido = eleccion.get(opcion-1);
            printLn("De " + escogido.getNombre() + "tenemos " + escogido.getCantidadDePlato() + " en bodega, Cúantos desea: ");
            int cantidadEscogida = readInt();
            if (cantidadEscogida <= escogido.getCantidadDePlato()){
                printLn("Excelente");
            }else{
                printLn("No poseemos esa cantidad");
            }

        }
    }

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
        printLn("Vemos que son " + numeroInvitados + " ,Les recomendamos la torta: " + platoRecomendado.getNombre() + ", que tiene" +
                " porciones para " + platoRecomendado.getPorciones() + " personas");
    }

    public static Factura recomendarEvento(){
        Evento evento1 = new Evento();
        Factura factura = new Factura();
        boolean encendido = true;

        printLn("¿Desea conocer las temáticas de Eventos especiales qué tenemos?");
        do {
            printLn("1.Sí, por favor");
            printLn("2.No");
            int opcionEvento = readInt();
            printLn("1. Cumpleaños.\n" +
                    "2. Meetings Empresariales.\n" +
                    "3. Gastronomias Mundiales.\n" +
                    "4. No, salir.\n" +
                    "Escriba un número para elegir su opción.");
            int opcionFinal = readInt();
            //Colocar el listado de los eventos
            switch (opcionFinal) {
                case 1:
                    do {
                        printLn("¿Cuántos invitados son?");
                        int numeroInvitados = readInt();
                        printLn("El Evento tiene un coste de 210.000$, ¿Desea continuar?");
                        printLn("1.Sí");
                        printLn("2.No");
                        int RespuestaCumple = readInt();
                        switch (RespuestaCumple) {
                            case 1:
                                new Plato();
                                Plato torta_seleccionada = null;
                                String descripcionEvento = "Feliz Cumpleaños!!! Te deseamos lo mejor en esta etapa";
                                String nombreRespuesta = "Cumpleanos Feliz";
                                int coste = 210000;
                                for (Evento elemento : eventos) {
                                    if (elemento.getNombreEvento().equals(nombreRespuesta)) {
                                        evento1 = elemento;
                                    }
                                }
                                printLn("Perfecto! Danos el nombre del festejado:");
                                String nombreFestejado = readString(); //Pendiente por meter
                                printLn("A continuación verá las tortas para la ocasión: ");
                                listadoPlatosEvento(evento1);
                                recomendacionPorCantidad(evento1, numeroInvitados); //Planear qué pasaría sí hay un excedente
                                printLn("Digite la opción de la torta: ");
                                int pastelEscogido = readInt();
                                if (!(pastelEscogido == 0)) {
                                    torta_seleccionada = evento1.getPlatos().get(pastelEscogido - 1);
                                    torta_seleccionada.descontarPlato();  //Hasta acá llega la parte de la planeación del excedente
                                }
                                ArrayList<Plato> platosDeEsteEvento = new ArrayList<>();
                                platosDeEsteEvento.add(torta_seleccionada);  //Para esto, crear un métodp que sea meterle estas 3 cosas

                                evento1.setNombreEvento(nombreRespuesta);
                                evento1.setDescripcion(descripcionEvento);
                                evento1.setCoste(coste);
                                evento1.setPlatos(platosDeEsteEvento);
                                factura.setEvento(evento1);
//                                assert torta_seleccionada != null;
//                                printLn("Prueba de la torta: " + torta_seleccionada.getNombre() + " Prueba descuente " + torta_seleccionada.getCantidadDePlato());
                                encendido = false;
                                break;

                            case 2:
                                printLn("Acá sería el no, Planear como devolver lo que se pide");
                                break;
                        }break;//Revisar esto

                    } while (encendido);
                case 2:
                    do {
                        printLn("¿Cuántos asistentes son?");
                        int numeroInvitados = readInt();
                        printLn("Digite el NIT de la empresa: ");
                        int NIT = readInt();
                        printLn("El Evento tiene un coste de 450.000$, ¿Desea continuar?");
                        printLn("1.Sí");
                        printLn("2.No");
                        int RespuestaMeeting = readInt();
                        switch (RespuestaMeeting) {
                            case 1:
                                new Plato();
//                                new Cocinero();
                                ArrayList<Plato> platosMeeting = null; //Revisar
                                String descripcionEvento = "Una empresa que demustra su talento, seriedad y humanidad"; //Sujeto a cambio
                                String nombreRespuesta = "Meetigns Empresarial";
                                int coste = 450000;//Evaluar esto
                                for (Evento elemento : eventos) {
                                    if (elemento.getNombreEvento().equals(nombreRespuesta)) {
                                        evento1 = elemento;
                                    }
                                }
                                printLn("""
                                        Tenemos las siguientes opciones para acompañar el meeting:
                                        1. Vino.
                                        2. Champaña.
                                        """);
                                int opcionVino_Champana = readInt();
                                listadoPlatosEvento(evento1, numeroInvitados, opcionVino_Champana);
                                encendido=false;
                                break;
                            case 2:
                                printLn("Prueba No Meeting");



                        }
                    }while (encendido);

            }
        }while(encendido);
        return factura;
    }

}
