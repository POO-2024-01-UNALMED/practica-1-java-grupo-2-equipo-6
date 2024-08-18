package uiMain;

import gestorAplicacion.Entorno.Ciudad;
import gestorAplicacion.Entorno.Zona;
import gestorAplicacion.Gestion.Plato;
import gestorAplicacion.Gestion.Reserva;
import gestorAplicacion.Gestion.Restaurante;
import gestorAplicacion.Gestion.Factura;
import gestorAplicacion.Usuario.Cliente;
import gestorAplicacion.Gestion.Evento;
import gestorAplicacion.Usuario.Trabajador;

import java.util.*;

import static uiMain.Main.*;

public class Funcionalidad5 implements Utilidad {
    static Scanner input = new Scanner(System.in);

    static void printLn(Object obj) {
        System.out.println(obj);
    }

    static void print(Object obj) {
        System.out.println(obj);
    }

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
//                    System.out.println("Interacción 1.");
//                    //La primera a de retornar un restaurante
                    restaurante = recomendarLocalizacion();
//                    //Esto es una prueba de su funcionalidad, borrar después
//                    printLn(restaurante.getInformacionRecomendacion());
//                    int cantidadFechas = restaurante.getReservas().size();
//                    for (int i = 0; i < (restaurante.getReservas().size()); i++) {
//                        Reserva fecha = restaurante.getReservas().get(i);
//                        if (i == restaurante.getReservas().size() - 1) {
//                            printLn(fecha.getFecha() + " <------ He aquí su reserva señor/a " + restaurante.getCliente() + "🫡");
//                        } else {
//                            printLn(fecha.getFecha());
//                        }
//                    }
                    //Hasta acá va la prueba
                    printLn("Interaccion2");
                    factura = recomendarEvento();
                    datos_horaReserva(restaurante, factura);


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

    public static Restaurante recomendarLocalizacion() {
        Cliente clientePP = new Cliente();
        Reserva reservaPP = new Reserva();
        Restaurante restauranteElegido = new Restaurante();
        boolean encendido = true;

        //Primera parte, en donde se pide la ciudad y se hace las respectivas recomendaciones
        do {
            printLn("Indica por favor la ciudad donde realizar el evento: ");
            String CiudadEvento = Utilidad.readString().toUpperCase(); //Ciudades con mayusculas y sin tilde
            Ciudad ciudadRequerida = ciudades.stream()
                    .filter(ciudad -> ciudad.getNombre().equalsIgnoreCase(CiudadEvento))
                    .findFirst()
                    .orElse(null);

            printLn("""
                    Desea que le recomendemos el restaurante con mayor capacidad: 
                    1.Sí, por favor
                    2.No, deseo conocerlos todos
                    """);
            int opcionRecomentacion = Utilidad.readInt();
            switch (opcionRecomentacion) {
                //Primera parte Sí
                case 1:
                    if (ciudadRequerida != null) {
                        restauranteElegido = getRestaurante(ciudadRequerida);
                        print(restauranteElegido.getNombre()); //Esto es para pruebas
                    }
                    encendido = false;
                    break;

                case 2:
                    //Caso del No
                    if (ciudadRequerida != null) {
                        printLn("Digita el restaurante que deseas");
                        listadoZonasPorCiudad(ciudadRequerida);
                        int opcionRecomendacion2 = Utilidad.readInt();
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
        //Mismo error que  lo solucionado abajo
        printLn("Estimado Cliente, nos permite los siguientes datos: Cédula ");
        double cedulaCliente = Utilidad.readInt();
        printLn("Nombre: ");
        String nombreCliente = Utilidad.readString();
        ArrayList<Integer> fecha = new ArrayList<Integer>(4);
        System.out.println("Ingrese el día de la reserva:");
        fecha.add(Utilidad.readInt()); // Día
        System.out.println("Ingrese el mes de la reserva:");
        fecha.add(Utilidad.readInt());
        System.out.println("Ingrese el año de la reserva:");
        fecha.add(Utilidad.readInt());

        clientePP.setNombre(nombreCliente);
        clientePP.setCedula((int) cedulaCliente);
        reservaPP.setFecha(fecha);
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
                    printLn(contador + ". " + nombreVino.getNombre());
                }
            }
            vinos_champan_ultimos = recomendacionMeeting(numeroInvitados, vinos_lista);
        }
        if (opcion == 2) {
            for (Plato nombreChampa : vinos_champanas) {
                if (!nombreChampa.getNombre().toLowerCase().contains("vino")) {
                    champanas_lista.add(nombreChampa);
                    contador++;
                    printLn(contador + ". " + nombreChampa.getNombre());
                }
            }
            vinos_champan_ultimos = recomendacionMeeting(numeroInvitados, champanas_lista);
        }


        return vinos_champan_ultimos;
    }

    public static Plato recomendacionMeeting(int numeroInvitados, List<Plato> eleccion) {
        Plato plato_final = new Plato();
        printLn("""
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
                printLn("Son pocas personas, suponiendo su alto rango, os recomendamos: ");
                ArrayList<Plato> botellasAllevar = new ArrayList<>();
                for (Plato caros : eleccion) {
                    if (caros.getPrecio() > 170000) {
                        botellasAllevar.add(caros);
                    }
                }
                for (Plato finales : botellasAllevar) {
                    contador++;
                    printLn(contador + ". " + finales.getNombre());
                }
                printLn("Cual deseais: ");
                int opcionMedia = Utilidad.readInt();
                productoOfrecido = botellasAllevar.get(opcionMedia - 1);

                if (numeroInvitados <= 4) {
                    botellasCantidad = 1;
                } else {
                    botellasCantidad = 2;
                }
                plato_final = new Plato(productoOfrecido.getNombre(), botellasCantidad, productoOfrecido.getPrecio());
            } else {
                printLn("Son bastantes invitados, para su economía os recomendamos: ");
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
                    printLn(contador + ". " + finales.getNombre());
                }
                printLn("Cual deseais: ");
                int opcionMedia = Utilidad.readInt();
                productoOfrecido = botellasAllevar.get(opcionMedia - 1);
                cuentaBotellas = (int) Math.ceil((double) numeroInvitados / productoOfrecido.getPorciones());
                printLn("Un total de " + cuentaBotellas + " botellas");
                plato_final = new Plato(productoOfrecido.getNombre(), cuentaBotellas, productoOfrecido.getPrecio());
            }
        } else {
            int cantidadBebida = 2;
            printLn("Cuál desea: ");
            for (int i = 0; i < eleccion.size(); i++) {
                printLn((i + 1) + ". " + eleccion.get(i).getNombre());
            }
            int opcion = Utilidad.readInt();
            Plato escogido = eleccion.get(opcion - 1);
            printLn("De " + escogido.getNombre() + "tenemos " + escogido.getCantidadDePlato() + " en bodega, Cúantos desea: ");
            int cantidadEscogida = Utilidad.readInt();
            if (cantidadEscogida <= escogido.getCantidadDePlato()) {
                cantidadBebida = cantidadEscogida;
                printLn("Excelente");
            } else {
                printLn("No poseemos esa cantidad, le vamos a vender la maxima cantidad");
                cantidadBebida = escogido.getCantidadDePlato();
            }
            plato_final = new Plato(escogido.getNombre(), cantidadBebida, escogido.getPrecio());

        }
        return plato_final;
    }

    public static ArrayList<Plato> listado_final(String gastronomia_escogida) {
        for (ArrayList<Plato> listado_general : platos_gastronomias) {
            for (Plato plato : listado_general) {
                if (plato.getTipo().equals(gastronomia_escogida)) {
                    return listado_general;
                }
            }
        }
        return null;
    }

    public static ArrayList<Plato> gastronomias_mundiales(int opcionGastronomias, ArrayList<String> gastronomias_nombres) {
        String gastronomia_escogida = gastronomias_nombres.get(opcionGastronomias - 1);
        ArrayList<Plato> escogidos;
        escogidos = listado_final(gastronomia_escogida);
        printLn("Para ello, ha preparado los siguientes platos: ");
        int contador = 0;
        for (Plato plato : escogidos) {
            contador++;
            printLn(contador + ". " + plato.getNombre());
        }
        return escogidos;
    }

    public static Trabajador cocineroElegido(int opcionGastronomias, ArrayList<String> gastronomias_nombres) {
        String gastronomia_escogida = gastronomias_nombres.get(opcionGastronomias - 1);
        for (Trabajador trabajador_elegido : cocineros) {
            if (trabajador_elegido.getEspecialidad().equals(gastronomia_escogida)) {
                return trabajador_elegido;
            }
        }
        return null;
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
        printLn(STR."Vemos que son \{numeroInvitados} ,Les recomendamos la torta: \{platoRecomendado.getNombre()}, que tiene porciones para \{platoRecomendado.getPorciones()} personas");
    }

    public static Factura recomendarEvento() {
        Evento evento1 = new Evento();
        Factura factura = new Factura();
        boolean encendido = true;
        Cliente cliente = new Cliente();
        printLn("""
                ¿Eres afiliado?
                1. Si
                2.No
                """);
        int respuestaAfiliacion = Utilidad.readInt();
        if (respuestaAfiliacion == 1) {
            cliente.esAfiliado();
        } else {
            printLn("Dale, no hay lio 😠🍆");
        }

        printLn("¿Desea conocer las temáticas de Eventos especiales qué tenemos?");
        printLn("1.Sí, por favor");
        printLn("2.No");
        int opcionEvento = Utilidad.readInt();
        printLn("1. Cumpleaños.\n" +
                "2. Meetings Empresariales.\n" +
                "3. Gastronomias Mundiales.\n" +
                "4. No, salir.\n" +
                "Escriba un número para elegir su opción.");
        int opcionFinal = Utilidad.readInt();
        //Colocar el listado de los eventos
        switch (opcionFinal) {
            case 1:
                Factura factura_cumple = new Factura();
                printLn("¿Cuántos invitados son?");
                int numeroInvitados = Utilidad.readInt();
                printLn("El Evento tiene un coste de 210.000$, ¿Desea continuar?");
                printLn("1.Sí");
                printLn("2.No");
                int RespuestaCumple = Utilidad.readInt();
                if (RespuestaCumple == 1) {
                    new Plato();
                    Plato torta_seleccionada = null;
                    String descripcionEvento = "Feliz Cumpleaños!!! Te deseamos lo mejor en esta etapa";
                    String nombreRespuesta = "Cumpleanos Feliz";
                    int coste = 210000;
                    for (Evento elemento : eventos) {
                        if (elemento.getNombre().equals(nombreRespuesta)) {
                            evento1 = elemento;
                        }
                    }
                    printLn("Perfecto! Danos el nombre del festejado:");
                    String nombreFestejado = Utilidad.readString(); //Pendiente por meter
                    printLn("A continuación verá las tortas para la ocasión: ");
                    listadoPlatosEvento(evento1);
                    recomendacionPorCantidad(evento1, numeroInvitados); //Planear qué pasaría sí hay un excedente
                    printLn("Digite la opción de la torta: ");
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
//                    factura = factura_cumple;
//                                assert torta_seleccionada != null;
//                                printLn("Prueba de la torta: " + torta_seleccionada.getNombre() + " Prueba descuente " + torta_seleccionada.getCantidadDePlato());

//                                factura.setEvento(evento1);
                    break;

                } else {
                    printLn("Acá sería el no, Planear como devolver lo que se pide");
                }
                break;
            case 2:
                Factura factura_meeting = new Factura();
                Plato vino_champana_final = new Plato();
                printLn("El Evento tiene un coste de 450.000$, ¿Desea continuar?");
                printLn("1.Sí");
                printLn("2.No");
                int RespuestaMeeting = Utilidad.readInt();
                if (RespuestaMeeting == 1) {
                    printLn("¿Cuántos asistentes son?");
                    int numeroInvitados_meeting = Utilidad.readInt();
                    printLn("Digite el NIT de la empresa: ");
                    int NIT = Utilidad.readInt();
                    ArrayList<Plato> platosAfiliacionCumple = new ArrayList<>();
                    Trabajador cocineroOcasion = new Trabajador();
                    ArrayList<Plato> platosMeeting = new ArrayList<Plato>(); //Revisar
                    String descripcionEvento = "Una empresa que demustra su talento, seriedad y humanidad"; //Sujeto a cambio
                    String nombreRespuesta = "Meetigns Empresarial";
                    int coste = 450000;//Evaluar esto
                    for (Evento elemento : eventos) {
                        if (elemento.getNombre().equals(nombreRespuesta)) {
                            evento1 = elemento;
                        }
                    }
                    printLn("""
                            Tenemos las siguientes opciones para acompañar el meeting:
                            1. Vino.
                            2. Champaña.
                            """);
                    int opcionVino_Champana = Utilidad.readInt();
                    vino_champana_final = listadoPlatosEvento(evento1, numeroInvitados_meeting, opcionVino_Champana);
                    platosMeeting.add(vino_champana_final);
                    printLn(vino_champana_final.getCantidadDePlato());
                    //He de poner la parte en que descuenta la cantidad de vinos y demas existencias
                    // A esta monda he de revolcarla para meterle lo que es afiliaciones y todo el cuento

                    if (cliente.esAfiliado()) {
                        printLn("""
                                Vemos que eres afiliado, deseas redimir tú derecho
                                1. Si
                                2. No""");
                        int opcionCumpleFinal = Utilidad.readInt();

                        if (opcionCumpleFinal == 1) {
                            for (Trabajador cocineroEnCuestion : cocineros) {
                                if (cocineroEnCuestion.getEspecialidad().equals("Sonmerlier")) {
                                    cocineroOcasion = cocineroEnCuestion;
                                    cocineroEnCuestion.PagoExtraServicio(eventos, cocineroEnCuestion.getEspecialidad());
                                    for (Plato plato : platos_varios) {
                                        if (plato.getNombre().equals("Bagget")) {
                                            platosAfiliacionCumple.add(plato);
                                            plato.descontarPlato(numeroInvitados_meeting);
                                        }

                                    }
                                    for (Plato plato : platos_varios) {
                                        if (plato.getNombre().equals("Queso mediterraneo")) {
                                            platosAfiliacionCumple.add(plato);
                                            int cantidadAdescontar = (int) Math.ceil((double) numeroInvitados_meeting / plato.getPorciones());
                                            plato.descontarPlato(cantidadAdescontar);
                                        }
                                    }
                                }
                            }
                            printLn("Excelente, de nuestra parte os damos a nuestro mejor sonmelier " + cocineroOcasion.getNombre() + "que ha de preparar el mejor" + platosAfiliacionCumple.get(1) + "acompañado de unos deliciosos " + platosAfiliacionCumple.getFirst());
                        }
                    }
                    evento1.setNombreEvento(nombreRespuesta);
                    evento1.setDescripcion(descripcionEvento);
                    evento1.setCoste(coste);
                    evento1.setPlatos(platosMeeting);//Esta es prueba
//                    factura_meeting.setEvento(evento1);
//                    factura  = factura_meeting;
                    break;
                } else {
//                            case 2:
                    printLn("Prueba No Meeting");
                    break;
                }
            case 3:
                Trabajador chef;
                ArrayList<Plato> final_gastro_evento;
                ArrayList<Plato> platos_pedidos = new ArrayList<>();
                ArrayList<String> gastronomias_nombres = new ArrayList<>();
                gastronomias_nombres.add("Italiana");
                gastronomias_nombres.add("Japonesa");
                gastronomias_nombres.add("Marroquí");
                gastronomias_nombres.add("Francesa");
                printLn("""
                        El servicio tiene un costo de 345000, deseas continuar:
                        1. Sí, por favor.
                        2. No, así está bien.
                        """);
                int respuesta = Utilidad.readInt();
                if (respuesta == 1) {

                    printLn("""
                            Gastronomias mundiales, escoge la de tu preferencia:
                            1.Italiana
                            2.Japonesa
                            3.Marroquí
                            4.Francesa
                            Dijite la opcion de su preferencia:\s
                            """);
                    int opcionGastronomias = Utilidad.readInt();
                    String tipoEvento = gastronomias_nombres.get(opcionGastronomias-1);
                    chef = cocineroElegido(opcionGastronomias, gastronomias_nombres);
                    printLn("El/la chef " + chef.getNombre() + " te va a acopañar en esta velada");
                    final_gastro_evento = gastronomias_mundiales(opcionGastronomias, gastronomias_nombres);
                    boolean escoger = true;
                    printLn("Cual de ellos gusta: ");
                    int leer = Utilidad.readInt();
                    printLn("Excelente, de ese plato tenemos " + final_gastro_evento.get(leer - 1).getCantidadDePlato() + ", cuantos desea?");
                    int a = Utilidad.readInt();
                    Plato primer_plato = final_gastro_evento.get(leer - 1);
                    primer_plato.setVecesPedido(a);
                    primer_plato.descontarPlato(a);
                    platos_pedidos.add(primer_plato);
                    final_gastro_evento.remove(leer - 1);
                    final_gastro_evento.get(leer - 1).descontarPlato(a);
                    while (escoger) {
                        printLn("""
                                Desea ordenar otros platos?:
                                1. Sí, deseo ordenar más platos
                                2. No, así está bien\s
                                """);
                        int leer2 = Utilidad.readInt();
                        if (leer2 == 1) {
                            if (!(final_gastro_evento.isEmpty())) {
                                printLn("Por supuesto, he aquí de nuevo el menú con el resto de plato:");
                                int contador = 0;
                                for (Plato dadada : final_gastro_evento) {
                                    contador++;
                                    printLn(contador + ". " + dadada.getNombre());
                                }
                                printLn("Digite el que guste pedir: ");
                                int leer3 = Utilidad.readInt();
                                printLn("Listo, este plato cuenta con " + final_gastro_evento.get(leer3 - 1).getCantidadDePlato() + " existencias, ¿Cuántas desea?");
                                int b = Utilidad.readInt();
                                Plato platos_venideros = final_gastro_evento.get(leer3 - 1);
                                platos_venideros.setVecesPedido(b);
                                platos_venideros.descontarPlato(b);
                                platos_pedidos.add(platos_venideros);
                                final_gastro_evento.remove(leer3 - 1);
                                printLn("""
                                        Desea seguir ordenando:
                                        1. Sí.
                                        2. No""");
                                int respuesta2 = Utilidad.readInt();
                                if (respuesta2 == 1) {
                                    encendido = true;
                                } else {
                                    System.out.println("Dale");
                                    encendido= false;
                                }
                            } else {
                                printLn("Lo sentimos, pero no hay más platos para mostrarte");
                                escoger = false;
                            }
                        } else {
                            printLn("Agradecemos tú confianza");
                            escoger = false;
                        }
                        Evento eventoGastronomias = new Evento("Gastronomias mundiales", 345000, platos_pedidos, tipoEvento);
                        eventoGastronomias.setNombreMotivo(gastronomias_nombres.get(opcionGastronomias - 1));
                        eventoGastronomias.setCoste(345000);
                        eventoGastronomias.setDescripcion("...");
                        evento1 = eventoGastronomias;
//                                        factura.setEvento(eventoGastronomias);

                        break;
                    }
                    printLn("No gastrononmias");
                } else {
                    break;
                }
            case 4:
                printLn("Escoge una opcion");
        }
        printLn("Prueba de si sí coge ");
        factura.setEvento(evento1);
        return factura;
    }

    //    Interaccion3:
    public static void listado_precios_factura(Factura factura, ArrayList<Integer> reserva, boolean diaFinDeSemana) {
        ArrayList<Plato> platos = factura.getEvento().getPlatos();
        printLn("He aquí su consumo: ");
        int acomulado_total = 0;
        for (Plato plato : platos) {
            printLn(plato.getNombre() + "   X" + plato.getVecesPedido() + "   ... " + (plato.getVecesPedido() * plato.getPrecio()));
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


        printLn("El total de su factura es: " + acomulado_total);
    }

    public static void formato_factura_evento(Restaurante restaurante, Factura factura, ArrayList<Integer> reserva, boolean diaFinDeSemana){
        System.out.println(STR.".............. \{restaurante.getNombre()}..............");
        System.out.println("Cliente: " + restaurante.getCliente().getNombre());
        System.out.println("Cédula: " + restaurante.getCliente().getCedula());
        listado_precios_factura(factura, reserva, diaFinDeSemana);
    }




    public static String datos_horaReserva(Restaurante restaurante, Factura factura) {
//        ArrayList<Plato> platos = factura.getEvento().getPlatos();
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
                printLn("Estimado Cliente, nos regala la hora a la que desea el evento (HH:MM): ");
                String hora_evento = Utilidad.readString();
                String [] fraccion = hora_evento.split(":");
                int hora_evento_real = Integer.parseInt(fraccion[0]);
                reserva = restaurante.getReservas().getLast().getFecha();
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
//}

//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.Locale;
//
//public class DiaDeLaSemana {
//    public static void main(String[] args) {
//        // Obtener la fecha de entrada (ejemplo: 2023-11-22)
//        String fechaString = "2023-11-22";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate fecha = LocalDate.parse(fechaString, formatter);
//
//        // Obtener el día de la semana
//        DayOfWeek diaSemana = fecha.getDayOfWeek();
//
//        // Mostrar el resultado en español
//        String diaSemanaString = diaSemana.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("es"));
//
//        System.out.println("La fecha " + fechaString + " corresponde a un " + diaSemanaString);
//    }
//}
}