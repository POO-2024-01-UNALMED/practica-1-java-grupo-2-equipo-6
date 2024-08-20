package uiMain;

import baseDatos.Deserializador;
import baseDatos.Serializador;

import gestorAplicacion.Entorno.Casilla;
import gestorAplicacion.Entorno.Ciudad;
import gestorAplicacion.Entorno.Mesa;
import gestorAplicacion.Entorno.Zona;
import gestorAplicacion.Gestion.*;
import gestorAplicacion.Usuario.Cliente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import static uiMain.Funcionalidad1.reservarMesa;

import static uiMain.Funcionalidad2.*;
import static uiMain.Funcionalidad3.*;

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

    //FUNCIONALIDAD TRES
    //Desarrollada por Juan José Arango
    //Este método se encarga de la interacción con el usuario para que este pueda dejar un restaurante.
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
    //Desarrollada por Samuel Colorado.
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
                    Ciudad.getCiudades().add(ciudad);
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
        for (Plato plato : Plato.getPlatos()) {
            if (plato.getNombre().equals(nombre)) {
                existe = true;
                indiceExiste = Plato.getPlatos().indexOf(plato);
                break;
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
                                crearIngrediente(cantidadIngredientes, ingredientesPlato);
                            }
                            encendido1 = false;
                            break;
                        case 3:
                            for (int i = 0; i < numIngredientes; i++) {
                                crearIngrediente(cantidadIngredientes, ingredientesPlato);
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
                    crearIngrediente(cantidadIngredientes, ingredientesPlato);
                }
                platoRetorno = new Plato(nombre, precio, ingredientesPlato, cantidadIngredientes, 3);
            }
        } else {
            platoRetorno = Plato.getPlatos().get(indiceExiste);
        }
        return platoRetorno;
    }

    public static void crearIngrediente(ArrayList<ArrayList<String>> cantidadIngredientes, ArrayList<Ingrediente> ingredientesPlato) {
        System.out.println("Ingrese el nombre del nuevo ingrediente.");
        String nombreIngrediente = Utilidad.capitalize(Utilidad.readString());
        System.out.println("Ingrese el precio unitario del nuevo ingrediente.");
        int precioIngrediente = Utilidad.readInt();
        if (precioIngrediente < 1) {
            precioIngrediente = 1;
        }
        Ingrediente ingrediente = new Ingrediente(nombreIngrediente, precioIngrediente);
        Ingrediente.getIngredientes().add(ingrediente);
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
}