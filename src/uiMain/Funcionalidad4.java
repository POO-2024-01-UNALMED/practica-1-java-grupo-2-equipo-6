package uiMain;

import gestorAplicacion.Entorno.Casilla;
import gestorAplicacion.Entorno.Ciudad;
import gestorAplicacion.Entorno.Zona;
import gestorAplicacion.Gestion.Ingrediente;
import gestorAplicacion.Gestion.Mesa;
import gestorAplicacion.Gestion.Plato;
import gestorAplicacion.Gestion.Restaurante;

import static uiMain.Main.*;
import static uiMain.Utilidad.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Funcionalidad4 {

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
            int eleccion = readInt();
            switch (eleccion) {
                case 1:
                    limpiarPantalla();
                    System.out.println("Interacción 1.");
                    restaurante = elegirZona(restaurante);
                    establecerDisposicion(restaurante);
                    establecerMenuYEncargos(restaurante);
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

    //Interacción 1: Elegir Zona
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
                        restaurante = parametrosBasicos(ciudad, restaurante);
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
                        String nombreZona = capitalize(readString());
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

    //Este metodo se encarga de definir los parámetros básicos del restaurante: Ciudad, Zona, Zona VIP y Calificación
    public static Restaurante parametrosBasicos(Ciudad ciudad, Restaurante restaurante) {
        System.out.println("Zonas de " + ciudad.getNombre() + ":");
        listadoZonasCiudad(ciudad);
        System.out.println("Escriba un número para elegir la zona.\nEn caso de no encontrar la zona " +
                "requerida escriba 0.");
        int eleccionZona1 = readInt();
        if (eleccionZona1 > ciudades.size() || eleccionZona1 < 0) {
            System.out.println("Ingrese un número válido [1 - " + ciudad.getZonas().size() + "].");
            parametrosBasicos(ciudad, restaurante);
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
                    //Se enlaza el restaurante a la ciudad
                    ciudad.getRestaurantes().add(restaurante);
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
                    //Se enlaza la ciudad al restaurante
                    restaurante.setCiudad(ciudad);
                    //Se enlaza la zona al restaurante
                    restaurante.setZona(ciudad.getZonas().get(eleccionZona1 - 1));
                    //Se enlaza el restaurante a la zona
                    ciudad.getZonas().get(eleccionZona1 - 1).getRestaurantes().add(restaurante);
                    //Se enlaza el restaurante a la ciudad
                    ciudad.getRestaurantes().add(restaurante);
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
                }

            } else { //Si no se encuentra la zona
                System.out.println("Por favor ingrese el nombre de la zona.");
                String nombreZona = capitalize(readString());
                System.out.println("Por favor ingrese la población de la zona.");
                int poblacionZona = readInt();
                ciudad.getZonas().add(new Zona(poblacionZona, capitalize(nombreZona), ciudad));
                ciudad.actualizarPoblacion();
                restaurante.setCiudad(ciudad);
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
                    } else {
                    }
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
        editarRestaurante(restaurante);
        return restaurante;
    }

    //Este metodo se encarga de modificar el plano de un restaurante al momento de ser creado
    public static void editarRestaurante(Restaurante restaurante) {
        boolean encendido = true;
        int coordX, coordY;
        do {
            coordX = readInt("Ingresa el ancho del restaurante:");
            coordY = readInt("Ingresa el largo del restaurante:");
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
            int decision = readInt();
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
                        limpiarPantalla();
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
        modCoordX = readInt();
        System.out.println("Escribe la coordenada en Y:");
        modCoordY = readInt();
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
                tileType = readInt();
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
                tileType = readInt();
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
            limpiarPantalla();
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
            listadoPlatosCalificacion();
            System.out.println("¿Desea conservar el menú generado?\n1. Sí.\n2. No.");
            int eleccion1 = readInt();
            switch (eleccion1) {
                case 1: //Si se quiere adoptar el menú generado
                    for (int i = 0; i < 10; i++) {
                        if (i < platos.size()) {
                            restaurante.getMenu().add(platos.reversed().get(i));
                        } else {
                            break;
                        }
                    }
                    break;
                case 2: //Si no se quiere adoptar el menú generado
                    listadoPlatos();
                    boolean encendido = true;
                    do {
                        System.out.println("\nElija la situación que mejor se acomode a su situación con respecto a " +
                                "la creación del menú y la lista presentada:\n1. Todos los platos están presentes." +
                                "\n2. Algunos platos están presentes.\n3. Ningún plato está presente.");
                        int eleccion2 = readInt();
                        int numPlatos;
                        switch (eleccion2) {
                            case 1:
                                numPlatos = readInt("Ingrese la cantidad de platos que desea agregar:");
                                System.out.println("Escriba el número de lista donde está cada uno de los " +
                                        numPlatos + " platos necesarios.");
                                for (int i = 0; i < numPlatos; i++) {
                                    int indice = readInt("Ingresa el número del plato #" + (i + 1));
                                    restaurante.getMenu().add(platos.get(indice - 1));
                                }
                                encendido = false;
                                break;
                            case 2:
                                encendido = false;
                                break;
                            case 3:
                                encendido = false;
                                break;
                            default:
                                System.out.println("Ingrese un número válido [1 - 3].");
                                encendido = true;
                                break;
                        }
                    } while (encendido);


                    int platosNuevos = readInt("Ingrese la cantidad de platos a crear:");
                    for (int i = 0; i < platosNuevos; i++) {
                        listadoPlatos();
                        listadoIngredientes();
                        Plato plato = crearPlato();
                        restaurante.getMenu().add(plato);
                        platos.add(plato);
                    }
                    break;
                default:
                    System.out.println("Ingrese un número válido [1 - 2].");
                    establecerMenuYEncargos(restaurante);
            }
        } else {
            int platosNuevos = readInt("Ingrese la cantidad de platos a crear:");
            for (int i = 0; i < platosNuevos; i++) {
                listadoPlatos();
                listadoIngredientes();
                Plato plato = crearPlato();
                restaurante.getMenu().add(plato);
                platos.add(plato);
            }
            System.out.println(restaurante);
        }
    }

    private static Plato crearPlato() {
        System.out.println("Ingrese el nombre del plato, sin tildes.");
        String nombre = capitalize(readString());
        boolean existe = false;
        int indiceExiste = 0;
        Plato platoRetorno = new Plato();
        for (Plato plato : platos) {
            if (plato.getNombre().equals(nombre)) {
                existe = true;
                indiceExiste = platos.indexOf(plato);
                break;
            }
        }
        if (!existe) {
            System.out.println("Ingrese el precio del plato, sin decimales.");
            int precio = readInt();
            System.out.println("Ingrese la cantidad de ingredientes que tiene el plato.");
            int numIngredientes = readInt();
            limpiarPantalla();
            listadoIngredientes();
            ArrayList<Ingrediente> ingredientesPlato = new ArrayList<Ingrediente>();
            System.out.println("\nElija la situación que mejor se acomode a su situación actual con respecto a la " +
                    "lista presentada:\n1. Todos los ingredientes están presentes.\n2. Algunos ingredientes están" +
                    " presentes.\n3. Ningún ingrediente está presente.");
            int eleccion = readInt();
            switch (eleccion) {
                case 1:
                    System.out.println("Escriba el número de lista donde está cada uno de los " + numIngredientes +
                            " ingredientes necesarios.");
                    for (int i = 0; i < numIngredientes; i++) {
                        int indice = readInt("Ingresa el número del ingrediente #" + (i + 1));
                        ingredientesPlato.add(ingredientes.get(indice - 1));
                    }
                    break;
                case 2:
                    int numIngExistentes = readInt("Ingrese la cantidad de ingredientes que ya están presentes.");
                    System.out.println("Escriba el número de lista donde está cada uno de los " + numIngExistentes +
                            "ingredientes necesarios.");
                    for (int i = 0; i < numIngExistentes; i++) {
                        int indice = readInt("Ingresa el número del ingrediente #" + (i + 1));
                        ingredientesPlato.add(ingredientes.get(indice - 1));
                    }
                    for (int i = 0; i < (numIngredientes - numIngExistentes); i++) {
                        System.out.println("Ingrese el nombre del nuevo ingrediente.");
                        String nombreIngrediente = capitalize(readString());
                        System.out.println("Ingrese el precio unitario del nuevo ingrediente.");
                        int precioIngrediente = readInt();
                        Ingrediente ingrediente = new Ingrediente(nombreIngrediente, precioIngrediente);
                        ingredientes.add(ingrediente);
                        ingredientesPlato.add(ingrediente);
                    }
                    break;
                case 3:
                    for (int i = 0; i < numIngredientes; i++) {
                        System.out.println("Ingrese el nombre del nuevo ingrediente.");
                        String nombreIngrediente = capitalize(readString());
                        System.out.println("Ingrese el precio unitario del nuevo ingrediente.");
                        int precioIngrediente = readInt();
                        Ingrediente ingrediente = new Ingrediente(nombreIngrediente, precioIngrediente);
                        ingredientes.add(ingrediente);
                        ingredientesPlato.add(ingrediente);
                    }
                    break;
            }
            platoRetorno = new Plato(nombre, precio, ingredientesPlato, (int) (Math.random() * 5) + 1);
        } else {
            platoRetorno = platos.get(indiceExiste);
        }
        return platoRetorno;
    }

}
