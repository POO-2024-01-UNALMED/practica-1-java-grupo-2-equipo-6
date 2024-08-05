package gestorAplicacion.Gestion;

import gestorAplicacion.Entorno.Casilla;
import gestorAplicacion.Entorno.Ciudad;
import gestorAplicacion.Entorno.Zona;
import gestorAplicacion.Usuario.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class Restaurante {
    // Atributos
    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public static ArrayList<Plato> menu = new ArrayList<Plato>();
    public static ArrayList<Mesa> mesas = new ArrayList<Mesa>();
    private ArrayList<ArrayList<String>> disposicion = new ArrayList<ArrayList<String>>();
    private ArrayList<Casilla> casillas = new ArrayList<Casilla>();
    public static int restaurantesCreados;
    private Ciudad ciudad;
    private Zona zona;
    private boolean zonaVIP;
    private float calificacion;
    private int coordX;
    private int coordY;
    private ArrayList<Ingrediente> bodega = new ArrayList<Ingrediente>();
    private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    private ArrayList<String> reseñas = new ArrayList<String>();
    private ArrayList<Plato> platosRecomendados = new ArrayList<Plato>();
    private ArrayList<Plato> platosDescuento = new ArrayList<Plato>();

    // Constructores
    public Restaurante() {
        restaurantesCreados++;
    }

    public Restaurante(Ciudad ciudad, Zona zona, boolean zonaVIP) {
        restaurantesCreados++;
        this.ciudad = ciudad;
        this.zona = zona;
        this.zonaVIP = zonaVIP;
    }

    // Métodos
    static Scanner consola = new Scanner(System.in);

    static String readString() {
        return consola.nextLine();
    }

    static int readInt() {
        return Integer.parseInt(consola.nextLine());
    }

    /*
     * METODO CONFIMAR CLIENTE FUNCIONALIDAD # 2
     * FUNCIONAMIENTO: recibe como parametro la cedula de el cliente, con este
     * parametro se busca
     * dentro del arryList clientes, si existe algun cliente con esta
     * identificacion. De ser asi
     * 1. se busca el indice dentro del arraylist que contenta el mismo numero de
     * cedula(cc) que se le paso como argumento
     * 2. Con el indice se busca el objeto cliente y se retorna por completo.
     * En caso de no estar presente se llama al metodo (...) para crear un cliente-
     */

    public static boolean confirmarCliente(int cc) {

        boolean in = false;
        Cliente cliente = new Cliente();

        for (Cliente i : clientes) {

            if (i.getCedula() == cc) {
                in = true;
                break;
            }
        }
        return in;
    }

    // Necesario para funcionalidad #2

    public static Cliente crearCliente(int cc) {

        System.out.println("La cédula ingresada es: " + cc);
        System.out.print("¿Es correcta? (1. Confirmar, 2. Cambiar): ");
        int opcion = readInt();
        consola.nextLine();

        if (opcion == 2) {
            System.out.print("Ingrese la nueva cédula: ");
            cc = readInt();
            consola.nextLine();
        }

        System.out.print("Se necesita el siguiente dato:\nNombre: ");
        String nombre = consola.nextLine();

        clientes.add(new Cliente(cc, nombre));
        System.out.println("Cliente agregado exitosamente.");

        return clientes.get(clientes.size() - 1);

    }

    public static void platosOferta(String tipo) {

        switch (tipo) {

            case "Entrada":
                for (Plato p : menu) {
                    if (p.getTipo() == "Entrada") {
                        System.out.println(p);
                    }
                }

            case "Fuerte":
                for (Plato p : menu) {
                    if (p.getTipo() == "Entrada") {
                        System.out.println(p);
                    }
                }

            case "Bebidas":
                for (Plato p : menu) {
                    if (p.getTipo() == "Entrada") {
                        System.out.println(p);
                    }
                }

            case "Postre":
                for (Plato p : menu) {
                    if (p.getTipo() == "Entrada") {
                        System.out.println(p);
                    }
                }

            case "Infantil":
                for (Plato p : menu) {
                    if (p.getTipo() == "Entrada") {
                        System.out.println(p);
                    }
                }
        }

    }

    public boolean isZonaVIP() {
        return zonaVIP;
    }

    public void setZonaVIP(boolean zonaVIP) {
        this.zonaVIP = zonaVIP;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public ArrayList<ArrayList<String>> getDisposicion() {
        return disposicion;
    }

    public void setDisposicion(ArrayList<ArrayList<String>> disposicion) {
        this.disposicion = disposicion;
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public static ArrayList<Mesa> getMesas() {
        return mesas;
    }

    public static void setMesas(ArrayList<Mesa> mesas) {
        Restaurante.mesas = mesas;
    }

    public ArrayList<Casilla> getCasillas() {
        return casillas;
    }

    public void setCasillas(ArrayList<Casilla> casillas) {
        this.casillas = casillas;
    }

    public static ArrayList<Plato> getMenu() {
        return menu;
    }

    public static void setMenu(ArrayList<Plato> menu) {
        Restaurante.menu = menu;
    }

    public void añadirReseña(String reseña) {
        reseñas.add(reseña);
    }

    public void agregarPlatoRecomendado(Plato plato) {
        platosRecomendados.add(plato);
    }
    public void eliminarPlatoRecomendado(Plato plato) {
        platosRecomendados.remove(plato);
    }
    public void agregarPlatoDescuento(Plato plato) {
        platosDescuento.add(plato);
    }
    public void eliminarPlatoDescuento(Plato plato) {
        platosDescuento.remove(plato);
    }
    public ArrayList<Plato> getPlatosRecomendados() {
        return platosRecomendados;
    }
    public ArrayList<Plato> getPlatosDescuento() {
        return platosDescuento;
    }
    public void eliminarPlato(Plato plato) {
        menu.remove(plato);
    }
    public void agregarPlato(Plato plato) {
        menu.add(plato);
    }
    public void agregarMesa(Mesa mesa) {
        mesas.add(mesa);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{Información del Restaurante: ");
        sb.append("ciudad=").append(ciudad.getNombre());
        sb.append(", zona=").append(zona.getNombre());
        sb.append(", zonaVIP=").append(zonaVIP);
        sb.append(", calificacion=").append(calificacion);
        sb.append(", mesas=").append(mesas);
        sb.append(", menu=").append(menu);
        sb.append('}');
        return sb.toString();
    }


    // FUNCIONALIDAD NUMERO 4: agregarSede
    // Interacción 1: elegirCiudad

}
