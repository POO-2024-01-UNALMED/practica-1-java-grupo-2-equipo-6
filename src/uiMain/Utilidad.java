package uiMain;

import gestorAplicacion.Entorno.Casilla;
import gestorAplicacion.Entorno.Ciudad;
import gestorAplicacion.Entorno.Zona;
import gestorAplicacion.Gestion.Ingrediente;
import gestorAplicacion.Gestion.Mesa;
import gestorAplicacion.Gestion.Plato;
import gestorAplicacion.Gestion.Restaurante;
import gestorAplicacion.Usuario.Cliente;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import static uiMain.Main.*;

public class Utilidad {
    static Scanner consola = new Scanner(System.in);

    static String readString() {
        return consola.nextLine();
    }

    public static int readInt() {
        String numero = readString();
        try {
            return Integer.parseInt(numero);
        } catch (NumberFormatException ex) {
            System.out.println("Ingrese un número entero válido. Ej: 172, 92, 5");
            return readInt();
        }
    }

    static int readInt(String string) {
        System.out.println(string);
        String numero = readString();
        try {
            return Integer.parseInt(numero);
        } catch (NumberFormatException ex) {
            System.out.println("Ingrese un número entero válido. Ej: 172, 92, 5");
            return readInt();
        }
    }

    static float readFloat(){
        String numero = readString();
        try {
            return Float.parseFloat(numero);
        } catch (NumberFormatException ex) {
            System.out.println("Ingrese un número decimal válido. Ej: 2.5, 7.2, 5.1");
            return readFloat();
        }
    }

    static Date readDateTime(int year, int month, int day, int hours) throws ParseException {
        String fecha = day + "/" + month + "/" + year + " " + hours + ":" + 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return sdf.parse(fecha);
    }

    static Date readDate(int year, int month, int day) throws ParseException {
        String fecha = day + "/" + month + "/" + year;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.parse(fecha);
    }

    static Date readTime(int hours) throws ParseException {
        String hora = hours + ":" + 0;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.parse(hora);
    }

    static String capitalize(String text) {
        char[] letrasIndividuales = text.toLowerCase().toCharArray();
        boolean espacioBlanco = true;
        for (int i = 0; i < letrasIndividuales.length; i++) {
            if (Character.isLetter(letrasIndividuales[i])) {
                if (espacioBlanco) {
                    letrasIndividuales[i] = Character.toUpperCase(letrasIndividuales[i]);
                    espacioBlanco = false;
                }
            } else {
                espacioBlanco = true;
            }
        }
        return String.valueOf(letrasIndividuales);
    }

    //Este método se encarga de limpiar la pantalla del ejecutable.
    public static void limpiarPantalla() {
        try {
            String sistemaOperativo = System.getProperty("os.name");
            ArrayList<String> comando = new ArrayList<>();
            if (sistemaOperativo.contains("Windows")) {
                comando.add("cmd");
                comando.add("/C");
                comando.add("cls");
            } else {
                comando.add("clear");
            }
            ProcessBuilder pb = new ProcessBuilder(comando);
            Process iniciarProceso = pb.inheritIO().start();
            iniciarProceso.waitFor();
        } catch (Exception e) {
            System.out.println("Error al limpiar la pantalla" + e.getMessage());
        }
    }

    //Este método se encarga de organizar en orden alfabético el listado de ciudades para luego imprimir un listado
    //numerado desde 1 con el nombre de estas.
    public static void listadoCiudades() {
        if (!ciudades.isEmpty()) {
            ciudades.sort(new Comparator<Ciudad>() {
                @Override
                public int compare(Ciudad o1, Ciudad o2) {
                    return o1.getNombre().compareToIgnoreCase(o2.getNombre());
                }
            });
            for (int i = 0; i < ciudades.size(); i++) {
                System.out.println(String.valueOf(i + 1) + ". " + ciudades.get(i).getNombre() + '.');
            }
        }
    }

    //Este método se encarga de organizar en orden alfabético el listado de zonas de una ciudad en específico para
    // luego imprimir un listado de estas numeradas desde el 1.
    public static void listadoZonasCiudad(Ciudad ciudad) {
        ciudad.getZonas().sort(new Comparator<Zona>() {
            @Override
            public int compare(Zona o1, Zona o2) {
                return o1.getNombre().compareToIgnoreCase(o2.getNombre());
            }
        });
        for (int i = 0; i < ciudad.getZonas().size(); i++) {
            System.out.println(String.valueOf(i + 1) + ". " + ciudad.getZonas().get(i).getNombre() + '.');
        }
        ciudad.actualizarPoblacion();

    }

    public static ArrayList<Zona> listadoZonasConRestauranteCiudad(Ciudad ciudad) {
        ArrayList<Zona> zonasConRestaurante = new ArrayList<Zona>();
        for (Zona zona : ciudad.getZonas()) {
            if (!zona.getRestaurantes().isEmpty()) {
                zonasConRestaurante.add(zona);
            }
        }
        zonasConRestaurante.sort(new Comparator<Zona>() {
            @Override
            public int compare(Zona o1, Zona o2) {
                return o1.getNombre().compareToIgnoreCase(o2.getNombre());
            }
        });
        for (int i = 0; i < zonasConRestaurante.size(); i++) {
            System.out.println(String.valueOf(i + 1) + ". " + zonasConRestaurante.get(i).getNombre() + '.');
        }
        ciudad.actualizarPoblacion();
        return zonasConRestaurante;
    }

    public static void listadoRestaurantesZona(Zona zona) {
        if (!zona.getRestaurantes().isEmpty()) {
            zona.getRestaurantes().sort(new Comparator<Restaurante>() {
                @Override
                public int compare(Restaurante o1, Restaurante o2) {
                    return o1.getNombre().compareToIgnoreCase(o2.getNombre());
                }
            });
            for (int i = 0; i < zona.getRestaurantes().size(); i++) {
                System.out.println(String.valueOf(i + 1) + ". " + zona.getRestaurantes().get(i).getNombre() +
                        '.');
            }
        }
    }

    //Este método se encarga de organizar en orden alfabético el listado de platos para luego imprimir un listado
    //numerado desde 1 con el nombre de estos.
    public static void listadoPlatos() {
        if (!platos.isEmpty()) {
            platos.sort(new Comparator<Plato>() {
                @Override
                public int compare(Plato o1, Plato o2) {
                    return o1.getNombre().compareToIgnoreCase(o2.getNombre());
                }
            });
            for (int i = 0; i < ingredientes.size(); i++) {
                System.out.println(String.valueOf(i + 1) + ". " + ingredientes.get(i).getNombre() + '.');
            }
        }
    }

    //Este método se encarga de organizar en orden de calificación el listado de platos para luego imprimir un listado
    //numerado desde 1 hasta 10 (máximo), con el nombre de estos.
    public static void listadoPlatosCalificacion() {
        platos.sort(new Comparator<Plato>() {
            @Override
            public int compare(Plato o1, Plato o2) {
                    return Float.compare(o1.getCalificacion(), o2.getCalificacion());
                }
        });
        for (int i = 0; i < 10; i++) {
            if (i < platos.size()) {
                System.out.println(String.valueOf(i + 1) + ". " + platos.reversed().get(i).getNombre() + ": " +
                        platos.reversed().get(i).getCalificacion() + " Estrellas.");
            } else {
                break;
            }
        }
    }

    //Este método se encarga de organizar en orden alfabético el listado de zonas de una ciudad en específico para
    // luego imprimir un listado de estas numeradas desde el 1.
    public static void listadoPlatosRestaurante(Restaurante restaurante) {
        if (!restaurante.getMenu().isEmpty()) {
            restaurante.getMenu().sort(new Comparator<Plato>() {
                @Override
                public int compare(Plato o1, Plato o2) {
                    return o1.getNombre().compareToIgnoreCase(o2.getNombre());
                }
            });
            for (int i = 0; i < restaurante.getMenu().size(); i++) {
                System.out.println(String.valueOf(i + 1) + ". " + restaurante.getMenu().get(i).getNombre() + '.');
            }
        }
    }

    //Este método se encarga de organizar en orden alfabético el listado de ingredientes para luego imprimir un listado
    //numerado desde 1 con el nombre de estos.
    public static void listadoIngredientes() {
        if (!ingredientes.isEmpty()) {
            ingredientes.sort(new Comparator<Ingrediente>() {
                @Override
                public int compare(Ingrediente o1, Ingrediente o2) {
                    return o1.getNombre().compareToIgnoreCase(o2.getNombre());
                }
            });
            for (int i = 0; i < ingredientes.size(); i++) {
                System.out.println(String.valueOf(i + 1) + ". " + ingredientes.get(i).getNombre() + '.');
            }
        }
    }

    public static boolean existeCliente(Cliente clienteActual) {
        for (Cliente cliente : Restaurante.getClientes()) {
            return clienteActual.getCedula() == cliente.getCedula();
        }
        return false;
    }

    public static Cliente clienteCedula(Cliente clienteActual) {
        for (Cliente cliente : Restaurante.getClientes()) {
            if (clienteActual.getCedula() == cliente.getCedula()) {
                return cliente;
            }
        }
        return clienteActual;
    }

    public static int calcularDistancia(Restaurante restaurante, int preferencia, boolean tipoMesa){
        ArrayList<Mesa> mesas = new ArrayList<Mesa>();
        int menorDistancia = 9999;
        for (Mesa mesa : restaurante.getMesas()) {
            if (mesa.isVIP() == tipoMesa) {
                mesas.add(mesa);
            }
        }
        if (preferencia == 1) { //Puerta
            ArrayList<Casilla> puertas = new ArrayList<Casilla>();
            for (Casilla casilla : restaurante.getCasillas()){
                if (casilla.getTipo().equals("PUERTA")) {
                    puertas.add(casilla);
                }
            }
            //Ver mesas más cercanas a una puerta
            for (Casilla casilla : puertas){
                for (Mesa mesa : mesas){
                    int distanciaPuerta = Math.abs((casilla.getCoordX() - mesa.getCoordX()) +
                            (casilla.getCoordY() - mesa.getCoordX()));
                    mesa.setDistanciaPuerta(distanciaPuerta);
                    if (distanciaPuerta < menorDistancia){
                        menorDistancia = distanciaPuerta;
                    }
                }
            }
        } else { //Ventana
            ArrayList<Casilla> ventanas = new ArrayList<Casilla>();
            for (Casilla casilla : restaurante.getCasillas()) {
                if (casilla.getTipo().equals("VENTANA")) {
                    ventanas.add(casilla);
                }
            }
            //Ver mesas más cercanas a una ventana
            for (Casilla casilla : ventanas) {
                for (Mesa mesa : mesas) {
                    int distanciaVentana = Math.abs(casilla.getCoordX() - mesa.getCoordX()) +
                            Math.abs(casilla.getCoordY() - mesa.getCoordY());
                    mesa.setDistanciaVentana(distanciaVentana);
                    if (distanciaVentana < menorDistancia) {
                        menorDistancia = distanciaVentana;
                    }
                }
            }
        }
        return menorDistancia;
    }

    public static ArrayList<ArrayList<Integer>> intersectarListas(ArrayList<ArrayList<Integer>> lista1,
                                                                  ArrayList<ArrayList<Integer>> lista2) {
        // Crear un LinkedHashSet para evitar duplicados y mantener el orden de inserción
        Set<ArrayList<Integer>> set = new LinkedHashSet<>(lista1);
        set.addAll(lista2);
        // Convertir el Set de nuevo a ArrayList
        ArrayList<ArrayList<Integer>> listaCombinada= new ArrayList<>(set);
        return listaCombinada;
    }
}
