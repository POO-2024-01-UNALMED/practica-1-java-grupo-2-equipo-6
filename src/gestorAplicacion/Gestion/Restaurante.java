package gestorAplicacion.Gestion;

import gestorAplicacion.Entorno.Casilla;
import gestorAplicacion.Entorno.Ciudad;
import gestorAplicacion.Entorno.Zona;
import gestorAplicacion.Usuario.Cliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static uiMain.Utilidad.intersectarListas;

public class Restaurante {
    // Atributos
    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public static ArrayList<Plato> menu = new ArrayList<Plato>();
    public static int restaurantesCreados;
    public ArrayList<Mesa> mesas = new ArrayList<Mesa>();
    private ArrayList<ArrayList<String>> disposicion = new ArrayList<ArrayList<String>>();
    private ArrayList<Casilla> casillas = new ArrayList<Casilla>();
    private ArrayList<ArrayList<String>> fechasDisponibles = new ArrayList<ArrayList<String>>();
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
    private String nombre;
    private int capacidad;



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

    public Restaurante(Ciudad ciudad, Zona zona, boolean zonaVIP) {
        restaurantesCreados++;
        this.ciudad = ciudad;
        this.zona = zona;
        this.zonaVIP = zonaVIP;
    }
    public Restaurante(int capacidad, String nombre, ArrayList<Reserva> reservas){
        restaurantesCreados++;
        this.capacidad = capacidad;
        this.nombre = nombre;
        this.reservas = reservas;

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

        clientes.add(new Cliente(nombre, cc));
        System.out.println("Cliente agregado exitosamente.");

        return clientes.get(clientes.size() - 1);


    }
   
    public static void platosOferta() {
    
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
       
    
	public static Pedido platosOferta(String tipo) {

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

    public void agregarReserva(Reserva nuevaReserva) {
        reservas.add(nuevaReserva);
    }
    public int getCapacidad(){
        return capacidad;
    }
    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }
    public static void setClientes(ArrayList<Cliente> clientes) {
        Restaurante.clientes = clientes;
    }
    public ArrayList<ArrayList<String>> getFechasDisponibles() {
        return fechasDisponibles;
    }
    public void setFechasDisponibles(ArrayList<ArrayList<String>> fechasDisponibles) {
        this.fechasDisponibles = fechasDisponibles;
    }

    public void actualizarFechasDisponibles() {
        ArrayList<ArrayList<Integer>> totalFechasDisponiblesMesas = new ArrayList<ArrayList<Integer>>();
        for (Mesa mesa : this.getMesas()) {
            totalFechasDisponiblesMesas = intersectarListas(totalFechasDisponiblesMesas, mesa.getFechasDisponibles());
        }

        ArrayList<ArrayList<Integer>> nuevoArray = new ArrayList<ArrayList<Integer>>();
        int añoActual = totalFechasDisponiblesMesas.get(0).get(0);
        int mesActual = totalFechasDisponiblesMesas.get(0).get(1);
        ArrayList<Integer> listaActual = new ArrayList<Integer>();
        listaActual.add(añoActual);
        listaActual.add(mesActual);

        for (ArrayList<Integer> fila : totalFechasDisponiblesMesas) {
            int anio = fila.get(0);
            int mes = fila.get(1);
            int dia = fila.get(2);

            // Si el año o el mes cambian, agregamos la lista actual al nuevo array y creamos una nueva lista
            if (anio != añoActual || mes != mesActual) {
                nuevoArray.add(listaActual);
                listaActual = new ArrayList<Integer>();
                listaActual.add(anio);
                listaActual.add(mes);
                añoActual = anio;
                mesActual = mes;
            }

            listaActual.add(dia);
        }

        nuevoArray.add(listaActual);

        for (ArrayList<Integer> fila : nuevoArray) {
            System.out.println(fila);
        }
    }
}
