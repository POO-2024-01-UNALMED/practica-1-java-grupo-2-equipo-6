/*
Interfaz dirigida a la creación de métodos que pueden resultar útiles en cualquiera de las insteracciones.

Desarrollada por:
Samuel Colorado Castrillón
 */

package uiMain;

import gestorAplicacion.Entorno.Casilla;
import gestorAplicacion.Entorno.Ciudad;
import gestorAplicacion.Entorno.Zona;
import gestorAplicacion.Gestion.Ingrediente;
import gestorAplicacion.Entorno.Mesa;
import gestorAplicacion.Gestion.Plato;
import gestorAplicacion.Gestion.Restaurante;
import gestorAplicacion.Usuario.Cliente;

import java.util.*;

public interface Utilidad {
    Scanner CONSOLA = new Scanner(System.in); //Constante

    static String readString() {
        return CONSOLA.nextLine();
    }

    static int readInt() {
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

    //Este metodo se encarga de limpiar la pantalla del ejecutable.
    static void limpiarPantalla() {
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

    //Este metodo se encarga de organizar en orden alfabético el listado de ciudades para luego imprimir un listado
    //numerado desde 1 con el nombre de estas.
    static void listadoCiudades() {

        if (!Ciudad.getCiudades().isEmpty()) {
            Ciudad.getCiudades().sort(new Comparator<Ciudad>() {
                @Override
                public int compare(Ciudad o1, Ciudad o2) {
                    return o1.getNombre().compareToIgnoreCase(o2.getNombre());
                }
            });
            for (int i = 0; i < Ciudad.getCiudades().size(); i++) {
                System.out.println((i + 1) + ". " + Ciudad.getCiudades().get(i).getNombre() + '.');
            }
        }
    }

    //Este metodo se encarga de organizar en orden alfabético el listado de zonas de una ciudad en específico para
    // luego imprimir un listado de estas numeradas desde el 1.
    static void listadoZonasCiudad(Ciudad ciudad) {
        ciudad.getZonasCiudad().sort(new Comparator<Zona>() {
            @Override
            public int compare(Zona o1, Zona o2) {
                return o1.getNombre().compareToIgnoreCase(o2.getNombre());
            }
        });
        for (int i = 0; i < ciudad.getZonasCiudad().size(); i++) {
            System.out.println(String.valueOf(i + 1) + ". " + ciudad.getZonasCiudad().get(i).getNombre() + '.');
        }
        ciudad.actualizarPoblacion();
    }

    static ArrayList<Zona> listadoZonasConRestauranteCiudad(Ciudad ciudad) {
        ArrayList<Zona> zonasConRestaurante = new ArrayList<Zona>();
        for (Zona zona : ciudad.getZonasCiudad()) {
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

    static void listadoRestaurantesZona(Zona zona) {
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

    //Este metodo se encarga de organizar en orden de calificación el listado de platos para luego imprimir un listado
    //numerado desde 1 hasta 10 (máximo), con el nombre de estos.
    static ArrayList<Plato> listadoPlatosCalificacion() {
        Plato.getPlatos().sort(new Comparator<Plato>() {
            @Override
            public int compare(Plato o1, Plato o2) {
                    return Double.compare(o1.getCalificacion(), o2.getCalificacion());
                }
        });
        ArrayList<Plato> mejoresPlatos = new ArrayList<Plato>();
        for (int i = 0; i < 10; i++) {
            if (i < Plato.getPlatos().size()) {
                mejoresPlatos.add(Plato.getPlatos().reversed().get(i));
                System.out.println((i + 1) + ". " + Plato.getPlatos().reversed().get(i).getNombre() +
                        ": " + Plato.getPlatos().reversed().get(i).getCalificacion() + " Estrellas.");
            } else {
                break;
            }
        }
        return mejoresPlatos;
    }

    //Este metodo se encarga de organizar en orden alfabético el listado de ingredientes para luego imprimir un listado
    //numerado desde 1 con el nombre de estos.
    static ArrayList<Ingrediente> listadoIngredientes() {
        if (!Ingrediente.getIngredientes().isEmpty()) {
            Ingrediente.getIngredientes().sort(new Comparator<Ingrediente>() {
                @Override
                public int compare(Ingrediente o1, Ingrediente o2) {
                    return o1.getNombre().compareToIgnoreCase(o2.getNombre());
                }
            });
            return Ingrediente.getIngredientes();
        } else {
            return null;
        }
    }

    //Este metodo se encarga de retornar verdadero o falso segun si existe o no un cliente con una cedula dada.
    static boolean existeCliente(Cliente clienteActual) {
        for (Cliente cliente : Cliente.getClientes()) {
            if (clienteActual.getCedula() == cliente.getCedula()) {
                return true;
            }
        }
        return false;
    }

    //SOBRECARGA DE METODOS:
    //Este metodo se encarga de retornar la referencia de un cliente presente en la lista de clientes
    static Cliente clienteCedula(Cliente clienteActual, Restaurante restaurante) {
        for (Cliente cliente : Cliente.getClientes()) {
            if (clienteActual.getCedula() == cliente.getCedula()) {
                return cliente;
            } else if (clienteActual.getCedula() == cliente.getCedula()) {
                System.out.println("El cliente existe pero no está en el restaurante indicado.");
            } else {
                System.out.println("El cliente no está registrado en ningún restaurante.");
            }
        }
        return clienteActual;
    }

    static Cliente clienteCedula(Cliente clienteActual) {
        for (Cliente cliente : Cliente.getClientes()) {
            if (clienteActual.getCedula() == cliente.getCedula()) {
                return cliente;
            }
        }
        return clienteActual;
    }

    // Este metodo se encarga de calcular la distancia entre las mesas que tiene un restaurante y el tipo de casilla
    // seleccionado (Puerta o Ventana), para recomendar la mesa que se ajuste a las preferencias del cliente.
    // Retorna el número de la(s) mesa(s) que más cerca se encuentren a la casilla de preferencia.
    static ArrayList<Integer> calcularDistancia(Restaurante restaurante, int preferencia, boolean tipoMesa){
        ArrayList<Mesa> mesas = new ArrayList<Mesa>();
        ArrayList<Integer> mesasElegidas = new ArrayList<Integer>();
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
            int distanciaPuerta = 0;
            for (Casilla casilla : puertas){
                for (Mesa mesa : mesas){
                    distanciaPuerta = Math.abs((casilla.getCoordX() - mesa.getCoordX()) +
                            (casilla.getCoordY() - mesa.getCoordX()));
                    mesa.setDistanciaPuerta(distanciaPuerta);
                    if (distanciaPuerta < menorDistancia){
                        menorDistancia = distanciaPuerta;
                    }
                }
            }
            for (Mesa mesa : mesas) {
                if (mesa.getDistanciaPuerta() == menorDistancia) {
                    mesasElegidas.add(mesa.getNumMesa());
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
            for (Mesa mesa : mesas) {
                if (mesa.getDistanciaVentana() == menorDistancia) {
                    mesasElegidas.add(mesa.getNumMesa());
                }
            }
        }
        return mesasElegidas;
    }

    //Este metodo se encarga de retornar la union de dos listas dadas
    static ArrayList<ArrayList<Integer>> intersectarListas(ArrayList<ArrayList<Integer>> lista1,
                                                                  ArrayList<ArrayList<Integer>> lista2) {
        // Crear un LinkedHashSet para evitar duplicados y mantener el orden de inserción
        Set<ArrayList<Integer>> set = new LinkedHashSet<>(lista1);
        set.addAll(lista2);
        // Convertir el Set de nuevo a ArrayList
        ArrayList<ArrayList<Integer>> listaCombinada = new ArrayList<>(set);
        return listaCombinada;
    }

    //Este metodo se encarga de recorrer la bodega de items de un restaurante, para devolver el indice donde se
    //encuentra el item en especifico
    static int indiceBodegaItems(String nombreItem, Restaurante restaurante) {
        for (ArrayList<String> item : restaurante.getBodegaItems()) {
            if (capitalize(item.getFirst()).equals(capitalize(nombreItem))) {
                return restaurante.getBodegaItems().indexOf(item);
            }
        }
        return -1;
    }

    //Este metodo se encarga de recorrer la bodega de ingredientes de un restaurante, para devolver el ingrediente
    //que tenga el nombre indicado.
    static int indiceBodegaIngredientes(String nombreItem, Restaurante restaurante) {
        for (ArrayList<String> ingredienteCantidad : restaurante.getBodegaIngredientes()) {
            if (capitalize(ingredienteCantidad.getFirst()).equals(capitalize(nombreItem))) {
                return restaurante.getBodegaIngredientes().indexOf(ingredienteCantidad);
            }
        }
        return -1;
    }
}
