package baseDatos;

import gestorAplicacion.Gestion.*;
import gestorAplicacion.Usuario.*;
import gestorAplicacion.Entorno.*;

import java.io.*;
import java.util.ArrayList;

public class Deserializador {
    private static <T> void deserializar(ArrayList lista, String nombre) {
        File archivo = new File("");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            File path = new File(archivo.getAbsolutePath() + "/src/baseDatos/temp/" + nombre + ".txt");
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
            lista.addAll((ArrayList<T>) ois.readObject()) ;
            ois.close();
            fis.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void deserializarListas(){
        deserializar(Casilla.getCasillas(), "casillas");
        deserializar(Ciudad.getCiudades(), "ciudades");
        deserializar(Mesa.getMesas(), "mesas");
        deserializar(Zona.getZonas(), "zonas");
        deserializar(Cargamento.getCargamentos(), "cargamentos");
        deserializar(Evento.getEventos(), "eventos");
        deserializar(Factura.getFacturas(), "facturas");
        deserializar(Ingrediente.getIngredientes(), "ingredientes");
        deserializar(Pedido.getPedidos(), "pedidos");
        deserializar(Plato.getPlatos(), "platos");
        deserializar(Reserva.getReservas(), "reservas");
        deserializar(Restaurante.getRestaurantes(), "restaurantes");
        deserializar(Cliente.getClientes(), "clientes");
        deserializar(Trabajador.getCocineros(), "trabajadores");
    }

}
