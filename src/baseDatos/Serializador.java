package baseDatos;

import gestorAplicacion.Gestion.*;
import gestorAplicacion.Usuario.*;
import gestorAplicacion.Entorno.*;

import java.io.*;
import java.util.ArrayList;

public class Serializador {

    public static void serializar(ArrayList<? extends Object> lista, String nombre) {
        File archivo = new File("");
        try {
            File ruta = new File(archivo.getAbsolutePath()+"/src/baseDatos/temp/"+nombre+".txt");
            FileOutputStream fileOut = new FileOutputStream(ruta);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(lista);
            objectOut.close();
            fileOut.close();
            System.out.println("El objeto ha sido serializado");
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encontró");
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Error al serializar el objeto");
        }
    }

    public static void serializarListas() {
        Serializador.serializar(Casilla.getCasillas(), "casillas");
        Serializador.serializar(Ciudad.getCiudades(), "ciudades");
        Serializador.serializar(Mesa.getMesas(), "mesas");
        Serializador.serializar(Zona.getZonas() , "zonas");
        Serializador.serializar(Cargamento.getCargamentos(), "cargamentos");
        Serializador.serializar(Evento.getEventos(), "eventos");
        Serializador.serializar(Factura.getFacturas(), "facturas");
        Serializador.serializar(Ingrediente.getIngredientes(), "ingredientes");
        Serializador.serializar(Pedido.getPedidos(), "pedidos");
        Serializador.serializar(Plato.getPlatos(), "platos");
        Serializador.serializar(Reserva.getReservas(), "reservas");
        Serializador.serializar(Restaurante.getRestaurantes(), "restaurantes");
        Serializador.serializar(Cliente.getClientes(), "clientes");
        Serializador.serializar(Trabajador.getCocineros(), "trabajadores");
    }
}
