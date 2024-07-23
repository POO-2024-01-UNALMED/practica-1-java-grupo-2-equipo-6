package uiMain;

import gestorAplicacion.Entorno.Ciudad;
import gestorAplicacion.Gestion.Mesa;
import gestorAplicacion.Gestion.Restaurante;
import gestorAplicacion.Entorno.Zona;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
    static LocalDateTime localDateTime = LocalDateTime.now(); //Fecha a la hora de ejectuar el programa
    static ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>(); //Lista de ciudades
    static ArrayList<Zona> zonas = new ArrayList<Zona>(); //Lista de zonas
    static ArrayList<String> nombreZonas = new ArrayList<String>(); //Lista con el nombre de las zonas

    static {
        //Creamos ciudades de muestra
        Ciudad ciudad1 = new Ciudad("Medellín");
        ciudades.add(ciudad1);
        Ciudad ciudad2 = new Ciudad("Bogotá");
        ciudades.add(ciudad2);

        //Creamos zonas de muestra
        zonas.add(new Zona(4378, "Robledo", ciudad1));
        zonas.add(new Zona(7426, "Aranjuez", ciudad1));
        zonas.add(new Zona(193134, "Kennedy", ciudad2));

        //Agregamos el nombre de las zonas al array nombreZonas
        for (Zona zona : zonas) {
            nombreZonas.add(zona.getNombre());
        }

        //Agregamos las zonas creadas al array zonas de su respectiva ciudad
        for (Ciudad ciudad : ciudades) {
            for (Zona zona : zonas) {
                if (zona.getCiudad() == ciudad) {
                    ciudad.getZonas().add(zona);
                }
            }
        }

        //Creamos un restaurante de muestra
        Restaurante restauranteMuestra = new Restaurante();
        restauranteMuestra.setZonaVIP(true);

        //Creamos una disposición default para el restaurante de muestra
        ArrayList<ArrayList<String>> disposicion = new ArrayList<ArrayList<String>>();
        disposicion.add(new ArrayList(Arrays.asList(
                new String[]{"╔", "═", "╦", "╗", "║", "╠", "╬", "╣", "╚", "╩", "╝", " "})));
        disposicion.add(new ArrayList(Arrays.asList(
                new String[]{"B", "B", "B", "B", "B", "B", "B", "B", "B", "B"})));
        disposicion.add(new ArrayList(Arrays.asList(
                new String[]{"B", " ", "V", " ", "V", " ", "V", " ", "V", "B"})));
        disposicion.add(new ArrayList(Arrays.asList(
                new String[]{"W", " ", " ", " ", " ", " ", " ", " ", " ", "W"})));
        disposicion.add(new ArrayList(Arrays.asList(
                new String[]{"B", " ", "T", " ", "T", " ", "T", " ", "T", "B"})));
        disposicion.add(new ArrayList(Arrays.asList(
                new String[]{"B", " ", " ", " ", " ", " ", " ", " ", " ", "B"})));
        disposicion.add(new ArrayList(Arrays.asList(
                new String[]{"B", " ", "T", " ", "T", " ", "T", " ", " ", "B"})));
        disposicion.add(new ArrayList(Arrays.asList(
                new String[]{"B", " ", " ", " ", " ", " ", " ", " ", " ", "B"})));
        disposicion.add(new ArrayList(Arrays.asList(
                new String[]{"W", " ", "T", " ", "T", " ", "T", " ", " ", "W"})));
        disposicion.add(new ArrayList(Arrays.asList(
                new String[]{"B", " ", " ", " ", " ", " ", " ", " ", " ", "B"})));
        disposicion.add(new ArrayList(Arrays.asList(
                new String[]{"B", "B", "B", "B", "B", "B", "B", "E", "B", "B"})));
        restauranteMuestra.setDisposicion(disposicion);
    }

    public static void main(String[] args) {
        menuPrincipal();
    }

    //Muestra el menú principal del programa
    static void menuPrincipal() {
        limpiarPantalla();
        boolean encendido = true;
        do {
            System.out.println("""
                    ¿Qué desea hacer?
                    1. Reservar Mesa.
                    2. Ordenar Comida.
                    3. Dejar Restaurante
                    4. Agregar Sede.
                    5. Crear Evento.
                    6. Salir.
                    Escriba un número para elegir su opción.""");
            int eleccion = readInt();
            switch (eleccion) {
                case 1:
                    limpiarPantalla();
                    System.out.println("Interacción 1.");
                    encendido = false;
                    break;
                case 2:
                    limpiarPantalla();
                    System.out.println("Funcionalidad 2.");
                    encendido = false;
                    break;
                case 3:
                    limpiarPantalla();
                    System.out.println("Interacción 3.");
                    encendido = false;
                    break;
                case 4:
                    limpiarPantalla();
                    Restaurante restaurante = agregarSede();
                    encendido = false;
                    break;
                case 5:
                    limpiarPantalla();
                    System.out.println("Funcionalidad 5.");
                    encendido = false;
                    break;
                case 6:
                    limpiarPantalla();
                    System.out.println("Se cierra el programa.");
                    encendido = false;
                    break;
                default:
                    limpiarPantalla();
                    System.out.println("Ingrese un número válido [1 - 6].");
                    break;
            }
        } while (encendido);
    }

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

    //Funcionalidad 4: Agregar Sede
    public static Restaurante agregarSede() {
        Restaurante restaurante = new Restaurante();
        boolean encendido = true;
        do {
            System.out.println("""
                    ¿Desea añadir una nueva sede?
                    1. Sí.
                    2. No.
                    Escriba un número para elegir su opción.""");
            int eleccion = readInt();
            switch (eleccion) {
                case 1:
                    limpiarPantalla();
                    System.out.println("Interacción 1.");
                    restaurante = elegirZona(restaurante);
                    establecerDisposicion(restaurante);
                    editarRestaurante(restaurante);
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
        return restaurante;
    }

    //Funcionalidad 4. Interacción 1: Elegir Zona
    public static Restaurante elegirZona(Restaurante restaurante) {
        boolean encendido = true;
        do {
            //Se muestran las ciudades de las que se tienen datos
            System.out.println("Ciudades:");
            listadoCiudades();
            System.out.println("Escriba un número para elegir la ciudad.\nEn caso de no encontrar la ciudad " +
                    "requerida escriba 0.");
            int eleccion1 = readInt();
            if (eleccion1 > ciudades.size() || eleccion1 < 0) {
                System.out.println("Ingrese un número válido [1 - " + ciudades.size() + "].");
            } else {
                limpiarPantalla();
                if (!(eleccion1 == 0)) { //Si se encuentra la ciudad
                    Ciudad ciudad = ciudades.get(eleccion1 - 1);
                    if (ciudad.getRestaurantes().isEmpty()) { //Si la ciudad no tiene restaurantes
                        restaurante = parametrosBasicos(ciudad, restaurante);
                    } else { //Si la ciudad tiene restaurantes
                        //Análisis de reservas
                    }

                } else { //Si no se encuentra la ciudad
                    System.out.println("Por favor ingrese el nombre de la ciudad.");
                    Ciudad ciudad = new Ciudad(capitalize(readString()));
                    ciudades.add(ciudad);
                    System.out.println("Por favor ingrese la cantidad de zonas que tiene la ciudad.");
                    int cantidadZonas = readInt();
                    //Este ciclo for se encarga de la creación de las zonas de la nueva ciudad.
                    for (int i = 1; i <= cantidadZonas; i++) {
                        System.out.println("Por favor ingrese el nombre de la zona #" + i + '.');
                        String nombreZona = readString();
                        System.out.println("Por favor ingrese la población de la zona #" + i + '.');
                        int poblacionZona = readInt();
                        ciudad.getZonas().add(new Zona(poblacionZona, capitalize(nombreZona), ciudad));
                        ciudad.actualizarPoblacion();
                        System.out.println(ciudad.getZonas().getLast());
                    }
                    limpiarPantalla();
                    restaurante = parametrosBasicos(ciudad, restaurante);
                }
                encendido = false;
            }
        } while (encendido);
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

        for (Zona zona : zonas) {
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

    //Este método se encarga de definir los parámetros básicos del restaurante: Ciudad, Zona, Zona VIP y Calificación
    public static Restaurante parametrosBasicos(Ciudad ciudad, Restaurante restaurante) {
        System.out.println("Zonas de " + ciudad.getNombre() + ":");
        listadoZonasCiudad(ciudad);
        System.out.println("Escriba un número para elegir la zona.\nEn caso de no encontrar la zona " +
                "requerida escriba 0.");
        int eleccionZona1 = readInt();
        if (eleccionZona1 > ciudades.size() || eleccionZona1 < 0) {
            System.out.println("Ingrese un número válido [1 - " + ciudad.getZonas().size() + "].");
        } else {
            limpiarPantalla();
            if (!(eleccionZona1 == 0)) { //Si se encuentra la zona
                Zona zonaElegida = ciudad.getZonas().get(eleccionZona1 - 1);
                //Se evalúa si existen restaurantes enlazados a esta zona.
                if (zonaElegida.getRestaurantes().isEmpty()) { //Si la zona elegida no tiene restaurantes
                    //Se enlaza la ciudad al restaurante
                    restaurante.setCiudad(ciudad);
                    //Se enlaza la zona al restaurante
                    restaurante.setZona(ciudad.getZonas().get(eleccionZona1 - 1));
                    //Se enlaza el restaurante a la zona
                    ciudad.getZonas().get(eleccionZona1 - 1).getRestaurantes().add(restaurante);
                    //Se establecen los parámetros básicos del restaurante
                    System.out.println("¿El restaurante tendrá zona VIP?\n1. Sí.\n2. No.\nEscriba un número para elegir.");
                    int tieneVIP = readInt();
                    if (tieneVIP == 1) {
                        restaurante.setZonaVIP(true);
                    } else if (tieneVIP == 2) {
                    } else {
                        System.out.println("Número no válido");
                    }
                    restaurante.setCalificacion((int) (Math.random() * 5) + 1);
                } else { //Si la zona elegida tiene restaurantes
                    //Análisis de reservas
                }

            } else { //Si no se encuentra la zona
                System.out.println("Por favor ingrese el nombre de la zona.");
                String nombreZona = readString();
                System.out.println("Por favor ingrese la población de la zona.");
                int poblacionZona = readInt();
                ciudad.getZonas().add(new Zona(poblacionZona, capitalize(nombreZona), ciudad));
                ciudad.actualizarPoblacion();
//                restaurante.setCiudad(ciudad);
                System.out.println("Zonas de " + ciudad.getNombre() + ":");
                listadoZonasCiudad(ciudad);
                System.out.println("Escriba un número para elegir la zona.\nEn caso de no encontrar la zona " +
                        "requerida escriba 0.");
                int eleccionZona2 = readInt();
                if (eleccionZona2 > ciudades.size() || eleccionZona2 < 0) {
                    System.out.println("Ingrese un número válido [1 - " + ciudad.getZonas().size() + "].");
                } else {
                    limpiarPantalla();
                    //Se enlaza la ciudad al restaurante
                    restaurante.setCiudad(ciudad);
                    //Se enlaza la zona al restaurante
                    restaurante.setZona(ciudad.getZonas().get(eleccionZona2 - 1));
                    //Se enlaza el restaurante a la zona
                    ciudad.getZonas().get(eleccionZona2 - 1).getRestaurantes().add(restaurante);
                    //Se establecen los parámetros básicos del restaurante
                    System.out.println("¿El restaurante tendrá zona VIP?\n1. Sí.\n2. No.\nEscriba un número para " +
                            "elegir.");
                    int tieneVIP = readInt();
                    if (tieneVIP == 1) {
                        restaurante.setZonaVIP(true);
                    } else {}
                    restaurante.setCalificacion((int) (Math.random() * 5) + 1);
                }
            }
        }
        System.out.println(restaurante.getCiudad());
        System.out.println(restaurante.getZona());
        return restaurante;
    }

    //Funcionalidad 4. Interacción 2: Establecer Disposicion
    public static Restaurante establecerDisposicion(Restaurante restaurante) {
        limpiarPantalla();
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
        return restaurante;
    }

    //Este método se encarga de modificar el plano de un restaurante al momento de ser creado
    public static void editarRestaurante(Restaurante restaurante) {
        int coordX = readInt("Ingresa el ancho del restaurante:");
        int coordY = readInt("Ingresa el largo del restaurante:");
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
        cambiarElemento(restaurante.getDisposicion(), coordX, coordY, chars, topRow, separator, bottomRow);

        boolean modifying = true;
        do {
            System.out.println("¿Desea realizar otra modificación?\n1. Sí.\n2. No.\nEscriba un número para elegir " +
                    "su opción");
            int decision = readInt();
            switch (decision) {
                case 1:
                    cambiarElemento(restaurante.getDisposicion(), coordX, coordY, chars, topRow, separator, bottomRow);
                    break;
                case 2:
                    modifying = false;
                    break;
                default:
                    System.out.println("Ingresa un número válido [1 - 2].");
                    break;
            }
        } while (modifying);
    }

    //Este método es un complemento de editarRestaurante
    private static void cambiarElemento(ArrayList<ArrayList<String>> planoRestaurante, int coordX, int coordY,
                                        ArrayList<String> chars, String topRow, String separator, String bottomRow) {
        int modCoordX;
        int modCoordY;
        int tileType;

        System.out.println("Escribe la coordenada en X:");
        modCoordX = readInt();
        System.out.println("Escribe la coordenada en Y:");
        modCoordY = readInt();

        if (modCoordY < 1 || modCoordY > coordY || modCoordX < 1 || modCoordX > coordX) {
            System.out.println("Escribe valores válidos para ambas coordenadas\nX = [1 - " + coordX + "]\n" +
                    "Y = [1 - " + coordY + "]");
            cambiarElemento(planoRestaurante, coordX, coordY, chars, topRow, separator, bottomRow);
        } else {
            if (modCoordY == 1 || modCoordY == coordY || modCoordX == 1 || modCoordX == coordX) {
                System.out.println("Reemplazar por:\n1. Pared (B).\n2. Ventana (W).\n3. Entrada (E).");
                tileType = readInt();
                switch (tileType) {
                    case 1:
                        planoRestaurante.get(modCoordY).set(modCoordX-1, "B");
                        break;
                    case 2:
                        planoRestaurante.get(modCoordY).set(modCoordX-1, "W");
                        break;
                    case 3:
                        planoRestaurante.get(modCoordY).set(modCoordX-1, "E");
                        break;
                    default:
                        System.out.println("Dato inválido. Se reemplazará por una pared.");
                        planoRestaurante.get(modCoordY).set(modCoordX-1, "B");
                }
            } else {
                System.out.println("Reemplazar por:\n1. Espacio Vacío ( ).\n2. Mesa Estándar (T).\n" +
                        "3. Mesa VIP (V).");
                tileType = readInt();
                switch (tileType) {
                    case 1:
                        planoRestaurante.get(modCoordY).set(modCoordX - 1, " ");
                        break;
                    case 2:
                        planoRestaurante.get(modCoordY).set(modCoordX - 1, "T");
                        break;
                    case 3:
                        planoRestaurante.get(modCoordY).set(modCoordX - 1, "V");
                        break;
                    default:
                        System.out.println("Dato inválido. Se reemplazará por un espacio vacío.");
                        planoRestaurante.get(modCoordY).set(modCoordX - 1, " ");
                }
            }
            limpiarPantalla();
            imprimirDisposicionRestaurante(planoRestaurante, coordX, coordY, chars, topRow, separator, bottomRow);
        }
    }

    //Este método es un complemento de editarRestaurante
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
            borderRow = borderRow + chars.get(4) + chars.get(11) + planoRestaurante.get(i).get(j+1) + chars.get(11) +
                    chars.get(4);
            System.out.println(borderRow);
            if (i == coordY) {
                System.out.println(bottomRow);
            } else {
                System.out.println(separator);
            }
        }
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