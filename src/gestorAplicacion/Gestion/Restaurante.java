package gestorAplicacion.Gestion;

import gestorAplicacion.Entorno.Casilla;
import gestorAplicacion.Entorno.Ciudad;
import gestorAplicacion.Entorno.Mesa;
import gestorAplicacion.Entorno.Zona;
import gestorAplicacion.Usuario.Cliente;
import gestorAplicacion.Usuario.Trabajador;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SequencedCollection;

import static uiMain.Utilidad.intersectarListas;

public class Restaurante implements Serializable {
    // Atributos
    private ArrayList<ArrayList<Integer>> intentosReserva;
    private static ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();
    public ArrayList<Cliente> clientes = new ArrayList<Cliente>(); //No puede ser static, arreglar lo que conlleva cambiarlo
    //una buena solucion seria crear una lista clientesRestaurante. Traería menos problemas (En principio).
    public ArrayList<Plato> menu = new ArrayList<Plato>();
    public static int restaurantesCreados;
    public ArrayList<Mesa> mesas = new ArrayList<Mesa>();
    private ArrayList<ArrayList<String>> disposicion = new ArrayList<ArrayList<String>>();
    private ArrayList<Casilla> casillas = new ArrayList<Casilla>();
    private ArrayList<ArrayList<Integer>> fechasDisponibles = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Reserva> historialReservas = new ArrayList<Reserva>();
    private ArrayList<Boolean> parqueadero = new ArrayList<Boolean>(10);
    private Ciudad ciudad;
    private Zona zona;
    private boolean zonaVIP;
    private float calificacion;
    private int coordX;
    private int coordY;
    private ArrayList<Ingrediente> bodegaIngredientes = new ArrayList<Ingrediente>();
    private ArrayList<ArrayList<String>> bodegaItems = new ArrayList<>();
    private ArrayList<String> reseñas = new ArrayList<String>();
    private ArrayList<Plato> platosRecomendados = new ArrayList<Plato>();
    private ArrayList<Plato> platosDescuento = new ArrayList<Plato>();
    private String nombre;
    private int capacidad;
    public static ArrayList<Trabajador> trabajadores = new ArrayList <Trabajador>();
    private Cargamento cargamento;

    // Constructores
    public Restaurante() {
        restaurantesCreados++;
    }
    public Restaurante(String nombre) {

    }
    public Restaurante(int capacidad, String nombre){
        restaurantesCreados++;
        this.capacidad =  capacidad;
        this.nombre = nombre;
    }

    public Restaurante(int capacidad, String nombre, ArrayList<Reserva> historialReservas){
        this(capacidad, nombre); //Caso #3 this()
        this.historialReservas = historialReservas;
    }
    public Restaurante(Ciudad ciudad, Zona zona, boolean zonaVIP, String nombre) {
        restaurantesCreados++;
        this.ciudad = ciudad;
        this.zona = zona;
        this.zonaVIP = zonaVIP;
        this.nombre = nombre;
    }

    // Métodos
    static Scanner consola = new Scanner(System.in);

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

    public  boolean confirmarCliente(int cc) {

        boolean in = false;

        for (Cliente i : clientes) {

            if (i.getCedula() == cc) {
                in = true;
                break;
            }
        }
        return in;
    }

    // Necesario para funcionalidad #2

    public  Cliente crearCliente(int cc) {

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

        clientes.add(new Cliente(nombre, cc));
        System.out.println("Cliente agregado exitosamente.");

        return clientes.get(clientes.size() - 1);


    }
   
    public  void platosOferta() {
    
        for (Plato p : menu) {

            if (p.getTipo().equals("Entrada")) {
                System.out.println((menu.indexOf(p)) + " " + p);}}
        
        for (Plato p : menu) {
            
            if (p.getTipo().equals("Fuerte")) {
                System.out.println((menu.indexOf(p)) + " " + p);}}
        
        for (Plato p : menu) {
            
            if (p.getTipo().equals("Bebidas")) {
                System.out.println((menu.indexOf(p)) + " " + p);}}
        
        for (Plato p : menu) {
            
            if (p.getTipo().equals("Postre")) {
                System.out.println((menu.indexOf(p)) + " " + p);}}
        
        for (Plato p : menu) {
            
            if (p.getTipo().equals("Infantil")) {
                System.out.println((menu.indexOf(p)) + " " + p);}}


    }
       
    
	public  Pedido platosOferta(String tipo) {
    	ArrayList<Plato> platos = new ArrayList<Plato>();   	
        Pedido pedido = new Pedido();
        
        switch (tipo) {
        
        	case "Entrada":
        			System.out.println("Entradas Disponibles\n");
        			for (Plato p : menu) {
            		
        				if (p.getTipo().equals("Entrada")) {
        					platos.add(p);
        				}
            		
        			}

            case "Plato fuerte":
    			System.out.println("Plato fuertes Disponibles\n");
    			for (Plato p : menu) {
        		
    				if (p.getTipo().equals("Plato fuerte")) {
    					platos.add(p);
    				}
        		
    			}
    			break;

            case "Bebida":
    			System.out.println("Bebidas Disponibles\n");
    			for (Plato p : menu) {
        		
    				if (p.getTipo().equals("Bebida")) {
    					platos.add(p);
    				}
        		
    			}
    			break;
            case "Postre":
    			System.out.println("Postres Disponibles\n");
    			for (Plato p : menu) {
        		
    				if (p.getTipo().equals("Postre")) {
    					platos.add(p);
    				}
        		
    			}
    			break;
            case "Infantil":
    			System.out.println("Menú infantil\n");
    			for (Plato p : menu) {
        		
    				if (p.getTipo().equals("Infantil")) {
    					platos.add(p);
    				}
        		
    			}
    			break;
        }   
        
        if (platos.isEmpty()) {
			System.out.println("No contamos con Platos de este tipo por el momento.");}
        else {
            for (Plato p: platos) {
         		 System.out.println( platos.indexOf(p)+1    +". " +  p.toString());
           } 
           
           System.out.println("- Ingrese el número del plato que desea.");
           int numPlato = readInt();
           System.out.println("- Ingrese la cantidad deseada (1, 2...)");
           int cantidad = readInt();
           
           int contador = 1;
          
           while (contador <= cantidad) {
           	Plato platoPedido = platos.get(numPlato-1);   // Almacena el plato deseado
               pedido.agregarPlato(platoPedido);

           	contador++;
           	System.out.print("Su Pedido hasta ahora\nProductos\n"+pedido+"\n");
           	
           }
        }

        return pedido;
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
    public ArrayList<Mesa> getMesas() {
        return mesas;
    }
    public void setMesas(ArrayList<Mesa> mesas) {
        this.mesas = mesas;
    }
    public ArrayList<Casilla> getCasillas() {
        return casillas;
    }
    public void setCasillas(ArrayList<Casilla> casillas) {
        this.casillas = casillas;
    }
    public ArrayList<Plato> getMenu() {
        return menu;
    }
    public void setMenu(ArrayList<Plato> menu) {
        this.menu = menu;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    public ArrayList<Boolean> getParqueadero() {
        return parqueadero;
    }
    public ArrayList<ArrayList<Integer>> getIntentosReserva() {
        return intentosReserva;
    }
    public void anadirIntentosReserva(ArrayList<Integer> intentoReserva) {
        intentosReserva.add(intentoReserva);
    }
    public ArrayList<Ingrediente> getBodegaIngredientes() {
        return bodegaIngredientes;
    }
    public void setBodegaIngredientes(ArrayList<Ingrediente> bodegaIngredientes) {
        this.bodegaIngredientes = bodegaIngredientes;
    }
    public ArrayList<ArrayList<String>> getBodegaItems() {
        return bodegaItems;
    }
    public void setBodegaItems(ArrayList<ArrayList<String>> bodegaItems) {
        this.bodegaItems = bodegaItems;
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

    public int getCapacidad(){
        return capacidad;
    }
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    public ArrayList<ArrayList<Integer>> getFechasDisponibles() {
        return fechasDisponibles;
    }
    public void setFechasDisponibles(ArrayList<ArrayList<Integer>> fechasDisponibles) {
        this.fechasDisponibles = fechasDisponibles;
    }
    public ArrayList<Reserva> getHistorialReservas() {
        return historialReservas;
    }
    public void setHistorialReservas(ArrayList<Reserva> historialReservas) {
        this.historialReservas = historialReservas;
    }

    public void actualizarFechasDisponibles() {
        ArrayList<ArrayList<Integer>> totalFechasDisponiblesMesas = new ArrayList<ArrayList<Integer>>();
        for (Mesa mesa : this.getMesas()) {
            totalFechasDisponiblesMesas = intersectarListas(totalFechasDisponiblesMesas, mesa.getFechasDisponibles());
        }

        ArrayList<ArrayList<Integer>> nuevoArray = new ArrayList<ArrayList<Integer>>();
        int anioActual = totalFechasDisponiblesMesas.get(0).get(0);
        int mesActual = totalFechasDisponiblesMesas.get(0).get(1);
        ArrayList<Integer> listaActual = new ArrayList<Integer>();
        listaActual.add(anioActual);
        listaActual.add(mesActual);

        for (ArrayList<Integer> fila : totalFechasDisponiblesMesas) {
            int anio = fila.get(0);
            int mes = fila.get(1);
            int dia = fila.get(2);

            // Si el año o el mes cambian, agregamos la lista actual al nuevo array y creamos una nueva lista
            if (anio != anioActual || mes != mesActual) {
                nuevoArray.add(listaActual);
                listaActual = new ArrayList<Integer>();
                listaActual.add(anio);
                listaActual.add(mes);
                anioActual = anio;
                mesActual = mes;
            }

            listaActual.add(dia);
        }

        nuevoArray.add(listaActual);

        for (ArrayList<Integer> fila : nuevoArray) {
            System.out.println(fila);
        }

        this.setFechasDisponibles(nuevoArray);
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void restarDeBodega(Ingrediente ingrediente, int cantidad) {

    }
    public void restarDeBodega(int indice, int cantidad) {

    }
}
