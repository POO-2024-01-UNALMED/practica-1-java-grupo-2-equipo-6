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

public class Funcionalidad5 implements Utilidad {
    static Scanner input = new Scanner(System.in);

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

                    ArrayList<Cliente> cliente = recomendarLocalizacion(ciudad);
                    restaurante = cliente.getFirst().getRestaurante();

                    System.out.println("Interaccion2");
                    factura = recomendarEvento();

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

            case 2: //Sino
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

    //PREGUNTARLE A COLO


    public static void listadoPlatosEvento(Evento evento) {
        List<Plato> platosEvento = evento.getPlatos();
        for (int i = 0; i < platosEvento.size(); i++) {
            System.out.println((i + 1) + ". " + platosEvento.get(i).getNombre());
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

    public static Trabajador cocineroElegido(int opcionGastronomias, ArrayList<String> gastronomias_nombres) {
        String gastronomia_escogida = gastronomias_nombres.get(opcionGastronomias - 1);
        for (Trabajador trabajador_elegido : Trabajador.getCocineros()) {
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
        System.out.println(STR."Vemos que son \{numeroInvitados} ,Les recomendamos la torta: \{platoRecomendado.getNombre()}, que tiene porciones para \{platoRecomendado.getPorciones()} personas");
    }

    public static Factura recomendarEvento() {
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
                                    String descripcionEvento = "Feliz Cumpleaños!!! Te deseamos lo mejor en esta etapa";
                                    String nombreRespuesta = "Cumpleanos Feliz";
                                    int coste = 210000;
                                    for (Evento elemento : Evento.getEventos()) {
                                        if (elemento.getNombre().equals(nombreRespuesta)) {
                                            evento1 = elemento;
                                        }
                                    }
                                    System.out.println("Perfecto! Danos el nombre del festejado:");
                                    String nombreFestejado = Utilidad.readString(); //Pendiente por meter
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
                                    ArrayList<Plato> platosAfiliacionCumple = new ArrayList<>();
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
                                    System.out.println(vino_champana_final.getCantidadDePlato());
                                    //He de poner la parte en que descuenta la cantidad de vinos y demas existencias
                                    // A esta monda he de revolcarla para meterle lo que es afiliaciones

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
                                                    cocineroEnCuestion.PagoExtraServicio(Evento.getEventos(), cocineroEnCuestion.getEspecialidad());
                                                    for (Plato plato : Plato.getPlatos_varios()) {
                                                        if (plato.getNombre().equals("Bagget")) {
                                                            platosAfiliacionCumple.add(plato);
                                                            plato.descontarPlato(numeroInvitados_meeting);
                                                        }

                                                    }
                                                    for (Plato plato : Plato.getPlatos_varios()) {
                                                        if (plato.getNombre().equals("Queso mediterraneo")) {
                                                            platosAfiliacionCumple.add(plato);
                                                            int cantidadAdescontar = (int) Math.ceil((double) numeroInvitados_meeting / plato.getPorciones());
                                                            plato.descontarPlato(cantidadAdescontar);
                                                        }
                                                    }
                                                }
                                            }
                                            System.out.println("Excelente, de nuestra parte os damos a nuestro mejor sonmelier " + cocineroOcasion.getNombre() + "que ha de preparar el mejor " + platosAfiliacionCumple.get(1).getNombre() + "acompañado de unos deliciosos " + platosAfiliacionCumple.getFirst().getNombre());
                                        }
                                    }
                                    evento1.setNombreEvento(nombreRespuesta);
                                    evento1.setDescripcion(descripcionEvento);
                                    evento1.setCoste(coste);
                                    evento1.setPlatos(platosMeeting);//Esta es prueba
                                    factura_meeting.setEvento(evento1);
                                    factura  = factura_meeting;
                                    encendido2 = false;
                                } else {
                                    System.out.println("Te retornaremos al menú de eventos");
                                    encendido2 = true;
                                }
                                break;
                            case 3:
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
                                    final_gastro_evento.remove(leer - 1);
                                    final_gastro_evento.get(leer - 1).descontarPlato(a);
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
                                            }
                                    } else {
                                        System.out.println("Agradecemos tú confianza");
                                    }
                                    Evento eventoGastronomias = new Evento("Gastronomias mundiales", 345000, platos_pedidos, tipoEvento);
                                    eventoGastronomias.setNombreMotivo(gastronomias_nombres.get(opcionGastronomias - 1));
                                    eventoGastronomias.setCoste(345000);
                                    eventoGastronomias.setDescripcion("...");
                                    evento1 = eventoGastronomias;
                                    factura.setEvento(eventoGastronomias);
                                    encendido2 = false;
                                } else {
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

    //    Interaccion3:
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

    public static void formato_factura_evento(Restaurante restaurante, Factura factura, ArrayList<Integer> reserva, boolean diaFinDeSemana){
        System.out.println(STR.".............. \{restaurante.getNombre()}..............");
        System.out.println("Cliente: " + restaurante.getClientes().getFirst().getNombre());
        System.out.println("Cédula: " + restaurante.getClientes().getFirst().getCedula());
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