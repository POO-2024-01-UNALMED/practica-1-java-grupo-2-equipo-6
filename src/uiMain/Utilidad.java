package uiMain;

import gestorAplicacion.Entorno.Ciudad;
import gestorAplicacion.Entorno.Zona;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import static uiMain.Main.ciudades;

public class Utilidad {
    static Scanner consola = new Scanner(System.in);

    static String readString() {
        return consola.nextLine();
    }

    static int readInt() {
        String numero = readString();
        try {
            return Integer.parseInt(numero);
        } catch (NumberFormatException ex) {
            System.out.println("Ingrese un número enteor válido. Ej: 172, 92, 5");
            return readInt();
        }
    }

    static int readInt(String string) {
        System.out.println(string);
        String numero = readString();
        try {
            return Integer.parseInt(numero);
        } catch (NumberFormatException ex) {
            System.out.println("Ingrese un número enteor válido. Ej: 172, 92, 5");
            return readInt();
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

    //Este método se encarga de organizar en orden alfabético el listado de ciudades para luego imprimir un listado
    //numerado desde 1 con el nombre de estas.
    public static void listadoCiudades() {
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
}
