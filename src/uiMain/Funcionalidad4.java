package uiMain;

import gestorAplicacion.Entorno.Casilla;
import gestorAplicacion.Entorno.Ciudad;
import gestorAplicacion.Entorno.Zona;
import gestorAplicacion.Gestion.Ingrediente;
import gestorAplicacion.Entorno.Mesa;
import gestorAplicacion.Gestion.Plato;
import gestorAplicacion.Gestion.Reserva;
import gestorAplicacion.Gestion.Restaurante;

import static uiMain.Main.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

//Desarrollado por Samuel Colorado
public class Funcionalidad4 implements Utilidad {

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
            System.out.println("Ciudades:");
            Utilidad.listadoCiudades();
            System.out.println("Escriba un número para elegir la ciudad.\nEn caso de no encontrar la ciudad " +
                    "requerida escriba 0.");
            int eleccion1 = Utilidad.readInt();
            if (eleccion1 > ciudades.size() || eleccion1 < 0) {
                System.out.println("Ingrese un número válido [1 - " + ciudades.size() + "].");
            } else {
                Utilidad.limpiarPantalla();
                if (!(eleccion1 == 0)) { //Si se encuentra la ciudad
                    Ciudad ciudad = ciudades.get(eleccion1 - 1);
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
                        for (Zona zona : ciudad.getZonas()) {
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
                                for (ArrayList<Integer> intento : restauranteZona.getIntentosReserva()) {
                                    totalIntentos++;
                                    LocalDate fechaToDate = LocalDate.of(intento.get(0), intento.get(1), intento.get(2));
                                    if (fechaToDate.isAfter(LocalDate.now().minusDays(30)) &&
                                            fechaToDate.isBefore(LocalDate.now())) {
                                        intentosRestaurante.add(intento);
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
                    }

                } else { //Si no se encuentra la ciudad
                    System.out.println("Por favor ingrese el nombre de la ciudad.");
                    Ciudad ciudad = new Ciudad(Utilidad.capitalize(Utilidad.readString()));
                    ciudades.add(ciudad);
                    System.out.println("Por favor ingrese la cantidad de zonas que tiene la ciudad.");
                    int cantidadZonas = Utilidad.readInt();
                    //Este ciclo for se encarga de la creación de las zonas de la nueva ciudad.
                    for (int i = 1; i <= cantidadZonas; i++) {
                        System.out.println("Por favor ingrese el nombre de la zona #" + i + '.');
                        String nombreZona = Utilidad.capitalize(Utilidad.readString());
                        System.out.println("Por favor ingrese la población de la zona #" + i + '.');
                        int poblacionZona = Utilidad.readInt();
                        ciudad.getZonas().add(new Zona(poblacionZona, Utilidad.capitalize(nombreZona), ciudad));
                        ciudad.actualizarPoblacion();
                        System.out.println(ciudad.getZonas().getLast());
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
    public static void parametrosBasicos(Ciudad ciudad, Restaurante restaurante) {
        System.out.println("Zonas de " + ciudad.getNombre() + ":");
        Utilidad.listadoZonasCiudad(ciudad);
        System.out.println("Escriba un número para elegir la zona.\nEn caso de no encontrar la zona " +
                "requerida escriba 0.");
        int eleccionZona1 = Utilidad.readInt();
        if (eleccionZona1 > ciudades.size() || eleccionZona1 < 0) {
            System.out.println("Ingrese un número válido [1 - " + ciudad.getZonas().size() + "].");
            parametrosBasicos(ciudad, restaurante);
        } else {
            Utilidad.limpiarPantalla();
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



                    //Se enlaza la ciudad al restaurante
                    restaurante.setCiudad(ciudad);
                    //Se enlaza la zona al restaurante
                    restaurante.setZona(ciudad.getZonas().get(eleccionZona1 - 1));
                    //Se enlaza el restaurante a la zona
                    ciudad.getZonas().get(eleccionZona1 - 1).getRestaurantes().add(restaurante);
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
                ciudad.getZonas().add(new Zona(poblacionZona, Utilidad.capitalize(nombreZona), ciudad));
                ciudad.actualizarPoblacion();
                restaurante.setCiudad(ciudad);
                System.out.println("Zonas de " + ciudad.getNombre() + ":");
                Utilidad.listadoZonasCiudad(ciudad);
                System.out.println("Escriba un número para elegir la zona.\nEn caso de no encontrar la zona " +
                        "requerida escriba 0.");
                int eleccionZona2 = Utilidad.readInt();
                if (eleccionZona2 > ciudades.size() || eleccionZona2 < 0) {
                    System.out.println("Ingrese un número válido [1 - " + ciudad.getZonas().size() + "].");
                } else {
                    Utilidad.limpiarPantalla();
                    //Se enlaza la ciudad al restaurante
                    restaurante.setCiudad(ciudad);
                    //Se enlaza la zona al restaurante
                    restaurante.setZona(ciudad.getZonas().get(eleccionZona2 - 1));
                    //Se enlaza el restaurante a la zona
                    ciudad.getZonas().get(eleccionZona2 - 1).getRestaurantes().add(restaurante);
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
                default:
                    System.out.println("Ingrese un valor válido [1 - 2].");
                    establecerMenuYEncargos(restaurante);
                    break;
            }

            //Establecer Encargos
            for (Plato plato : restaurante.getMenu()) {
                System.out.println("Nombre: " + plato.getNombre() + "\nVeces pedido: " + plato.getVecesPedido());
                System.out.println("Ingredientes:");
                for (ArrayList<String> cantidadIngredientes : plato.getCantidadIngredientes()) {
                    System.out.println(cantidadIngredientes.getFirst() + ": " + cantidadIngredientes.get(1));
                }

            }
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
        }
    }

    private static Plato crearPlato() {
        System.out.println("Ingrese el nombre del plato:");
        String nombre = Utilidad.capitalize(Utilidad.readString());
        boolean existe = false;
        int indiceExiste = 0;
        Plato platoRetorno = new Plato();
        ArrayList<ArrayList<String>> cantidadIngredientes = new ArrayList<ArrayList<String>>();
        for (Plato plato : platos) {
            if (plato.getNombre().equals(nombre)) {
                existe = true;
                indiceExiste = platos.indexOf(plato);
                break;
            }
        }
        if (!existe) {
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
            platoRetorno = platos.get(indiceExiste);
        }
        return platoRetorno;
    }

    private static void crearIngrediente(ArrayList<ArrayList<String>> cantidadIngredientes, ArrayList<Ingrediente> ingredientesPlato) {
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