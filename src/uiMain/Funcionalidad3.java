package uiMain;
import gestorAplicacion.Gestion.*;
import gestorAplicacion.Entorno.*;
import gestorAplicacion.Usuario.*;
import java.util.*;
import static uiMain.Main.*;
import static uiMain.Utilidad.*;

public class Funcionalidad3 {
    public static void dejarRestaurante() {
        boolean encendido = true;
        do {
            System.out.println("""
                    ¿Algún cliente desea dejar un restaurante?
                    1. Sí.
                    2. No.
                    Escriba un número para elegir su opción.""");
            int eleccion = readInt();
            switch (eleccion) {
                case 1:
                    limpiarPantalla();
                    System.out.println("Ingrese el número de cédula del cliente que va a dejar el restaurante");
                    int cedula = readInt();
                    Cliente cliente = clienteCedula(new Cliente("", cedula));
                    Mesa mesa = cliente.getMesa();
                    cobrarFactura(mesa);
                    encendido = false;
                    break;
                case 2:
                    limpiarPantalla();
                    menuPrincipal();
                    encendido = false;
                    break;
                default:
                    limpiarPantalla();
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
            int eleccion = readInt();
            switch (eleccion) {
                case 1:
                    System.out.println("Por favor ingrese el valor de la propina.");
                    int propina = readInt();
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
            int eleccion = readInt();
            switch (eleccion) {
                case 1:
                    System.out.println("Por favor ingrese el número de personas que van a pagar la factura.");
                    int cedula = 0;
                    int numeroPersonas = readInt();
                    if (numeroPersonas == mesa.getClientes().size()) {
                        ArrayList<Cliente> clientesPagadores = new ArrayList<Cliente>();
                        System.out.println("¿Todos desean pagar el mismo monto?");
                        System.out.println("""
                                1. Sí.
                                2. No.
                                Escriba un número para elegir su opción.""");
                        int eleccion2 = readInt();
                        switch (eleccion2) {
                            case 1:
                                int valorFactura = mesa.getValorTotal();
                                int valorPorPersona = valorFactura / numeroPersonas;
                                System.out.println("El valor por persona es: " + valorPorPersona);
                                limpiarPantalla();
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
                                        int confirmacion = readInt();
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
                                        int confirmacion = readInt();
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
                                cedula = readInt();

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
                                    int valor = readInt();
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
                            int clienteAPagar = readInt();
                            System.out.println("Debe pagar el total restante de: " + mesa.getValorTotal());
                            System.out.println("¿Desea confirmar la transacción?");
                            System.out.println("""
                                            1. Sí.
                                            2. No.
                                            Escriba un número para elegir su opción.""");
                            int confirmacion = readInt();
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
                    limpiarPantalla();
                    int cedulaCliente = readInt("Ingrese la cédula del cliente que realizará el pago.");
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
                                int confirmacion = readInt();
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
                4. Puntos.
                Escriba un número para elegir su opción.""");
        int metodoPago = readInt();
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
            case 4:
                clientePagador.getFactura().setMetodoPago("Puntos");
                metodosPago.add("Puntos");
                break;
            default:
                System.out.println("Número no válido");
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
            int eleccion = readInt();
            switch (eleccion){
                case 1:
                    System.out.println("¿Cuántos clientes desean hacer una reservación?");
                    int numeroClientes = readInt();
                    for (int i = 0; i < numeroClientes; i++){
                        System.out.println("Ingrese la cédula del cliente que desea reservar.");
                        int cedula = readInt();
                        for (Cliente cliente : mesa.getClientes()){
                            if (cliente.getCedula() == cedula){
                                if (cliente.getAfiliacion() != null){
                                    // reservarMesa(mesa, cliente);
                                    // aplicarDescuentos(){}
                                } else {
                                    System.out.println("¿Desea afiliarse?");
                                    System.out.println("""
                                            1. Sí.
                                            2. No.
                                            Escriba un número para elegir su opción.""");
                                    int eleccion2 = readInt();
                                    switch (eleccion2){
                                        case 1:
                                            System.out.println("¿Qué nivel de afiliación desea?");
                                            System.out.println("""
                                                    1. Estrellita.
                                                    2. Estrella.
                                                    3. Super estrellota.
                                                    Escriba un número para elegir su opción.""");
                                            int nivelAfiliacion = readInt();
                                            switch (nivelAfiliacion){
                                                case 1:
                                                    boolean transaccionConfirmada = false;
                                                    do {
                                                        System.out.println("¿Desea confirmar la transacción con un valor de: 35.900?");
                                                        System.out.println("""
                                                                1. Sí.
                                                                2. No.
                                                                Escriba un número para elegir su opción.""");
                                                        int confirmacion = readInt();
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
                                                    // aplicarDescuentos(){} Se aplican descuentos a la reserva que va a realizar.
                                                    break;
                                                case 2:
                                                    boolean transaccionConfirmada2 = false;
                                                    do {
                                                        System.out.println("¿Desea confirmar la transacción con un valor de: 48.900?");
                                                        System.out.println("""
                                                                1. Sí.
                                                                2. No.
                                                                Escriba un número para elegir su opción.""");
                                                        int confirmacion = readInt();
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
                                                        int confirmacion = readInt();
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
                                            break;
                                        case 2:
                                            // reservarMesa (mesa, cliente);
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
                            int eleccion3 = readInt();
                            switch (eleccion3){
                                case 1:
                                    System.out.println("¿Qué nivel de afiliación desea?");
                                    System.out.println("""
                                            1. Estrellita.
                                            2. Estrella.
                                            3. Super estrellota.
                                            Escriba un número para elegir su opción.""");
                                    int nivelAfiliacion = readInt();
                                    switch (nivelAfiliacion){
                                        case 1:
                                            boolean transaccionConfirmada = false;
                                            do {
                                                System.out.println("¿Desea confirmar la transacción con un valor de: 35.900?");
                                                System.out.println("""
                                                                1. Sí.
                                                                2. No.
                                                                Escriba un número para elegir su opción.""");
                                                int confirmacion = readInt();
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
                                                int confirmacion = readInt();
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
                                                int confirmacion = readInt();
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
        float calificacion = readFloat();
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
        int eleccion = readInt();
        switch (eleccion) {
            case 1:
                System.out.println("Por favor ingrese su reseña.");
                String reseña = readString();
                cliente.getMesa().getRestaurante().añadirReseña(reseña);
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
        float calificacionPlato = readFloat();
        for (Plato plato : cliente.getFactura().getPedido().getPlatos()) {
            if (calificacionPlato >= 1 && calificacionPlato <= 5) {
                if (calificacionPlato >= 4.5) {
                    cliente.agregarPlatoFavorito(plato);
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
                    int eleccion = readInt();
                    switch (eleccion){
                        case 1:
                            System.out.println("Por favor ingrese el nombre del plato.");
                            String nombrePlato = readString();
                            System.out.println("Por favor ingrese el precio del plato.");
                            int precioPlato = readInt();
                            System.out.println("Por favor ingrese los ingredientes del plato.");
                            ArrayList<Ingrediente> ingredientes = new ArrayList<>();
                            while (true){
                                System.out.println("Por favor ingrese el nombre del ingrediente o Stop para detenerse:");
                                String nombreIngrediente = readString();
                                for (Ingrediente ingrediente : Ingrediente.getListaIngredientes()){
                                    if (ingrediente.getNombre().equals(nombreIngrediente)){
                                        ingredientes.add(ingrediente);
                                        break;
                                    }
                                }
                                if (nombreIngrediente.equals("Stop")){
                                    break;
                                }
                            }
                            restaurante.agregarPlato(new Plato(nombrePlato, precioPlato, ingredientes));
                            System.out.println("Se ha añadido un nuevo plato al menú.");
                            break;
                        case 2:
                            System.out.println("Por favor ingrese el nombre del plato.");
//                            String nombrePlato2 = readString();
//                            for (Restaurante restaurante1 : Restaurante.restaurantes){
//                                for (Plato plato1 : restaurante1.getMenu()){
//                                    if (plato1.getNombre().equals(nombrePlato2)){
//                                        restaurante.getMenu().add(plato1);
//                                    }
//                                }
//                            }
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
        return valorFinal;
    }
}