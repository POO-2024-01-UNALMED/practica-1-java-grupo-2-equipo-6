package uiMain;

import static uiMain.Utilidad.readChar;
import static uiMain.Utilidad.readInt;

import java.util.ArrayList;

import gestorAplicacion.Entorno.Ciudad;
import gestorAplicacion.Gestion.Factura;
import gestorAplicacion.Gestion.Pedido;
import gestorAplicacion.Gestion.Plato;
import gestorAplicacion.Gestion.Restaurante;
import gestorAplicacion.Usuario.Cliente;
import gestorAplicacion.Usuario.Trabajador;


public class Funcionalidad2 {
public static void ordenarComida() {
			
			
			
			Restaurante restaurante = new Restaurante();
			int name;
			boolean correcto = false;
			do {
				ArrayList <Ciudad> ciudades = Ciudad.getCiudades();
				for (Ciudad c: ciudades) {
					System.out.println(ciudades.indexOf(c) +1 + ". " + c );
				}
				System.out.println("\nSeleccione la ciudad que desea hacer el proceso \n");
				name = readInt();
				
				Ciudad ciudad = ciudades.get(name-1);
		

				
				ArrayList <Restaurante> restaurantes = ciudad.getRestaurantes();

				System.out.println("Estos son los restaurante en la ciudad, seleccione [1..2] \n");

				 for (Restaurante restaurantee: restaurantes) {
						System.out.println(restaurantes.indexOf(restaurantee) +1 + ". " + restaurantee );
					}
				int nameRests = readInt();

				restaurante = restaurantes.get(nameRests-1);
				
				correcto = true;
				
				
				
					
			
			} while (!correcto);
			
		Utilidad.limpiarPantalla();
			
			establecerCliente(restaurante);

		}
	    public static Cliente establecerCliente(Restaurante restaurante) {
	    		
	    		System.out.println("Ingrese el numero de cédula de la persona que desea ordenar: \n");
	    		int cedula = readInt();
	    		Cliente cliente = new Cliente();
	    	
	    		boolean valor = restaurante.confirmarCliente(cedula);
	    	
	    		if (valor){
	    			for(Cliente i: restaurante.clientes) {
	    				if (i.getCedula() == cedula) {
	    					cliente = i;}	
	    			
	    			}
	    		}
	    		else {
	    			System.out.println("El número de cédula ingresado no se encuentra en nuestra base para hacer pedido.\n 	--- Para continuar es necesario ser registrado --- \n");
	    			cliente = restaurante.crearCliente(cedula);
	    		}

	    		hacerComida(cliente);
	    		return cliente;
	    		
	    		} 
	
	
	
	/// INTERACCION 2
	public static Pedido hacerComida(Cliente cliente) {
		
		Utilidad.limpiarPantalla();

		ArrayList<Trabajador> trabajadores  = Restaurante.trabajadores;
		Pedido pedido = new Pedido();
		boolean confirma = false;
		Restaurante restaurante = cliente.getRestaurante();
		
		// Buscar Trabajador especialidad Cocinero, especialidad Mesero
		Trabajador cocinero = new Trabajador();
		Trabajador mesero  = new Trabajador();
	
		
		
		
		for(Trabajador t: trabajadores) {
			if (!t.getOcupado() && t.getEspecialidad() == "cocinero"){
				cocinero = t;
				cocinero.setOcupado(true);}
			if (!t.getOcupado() && t.getEspecialidad() == "Mesero") {
				mesero = t;
				mesero.setOcupado(true);}
				
			}
		

    
	    
		
		//private ArrayList <Pedido> pedidos= new ArrayList <Pedido>();

        ///////////////////////////////

       
        do {
        	 System.out.println("\nSeleccione una opción:");
             System.out.println("1. Entradas");
             System.out.println("2. Platos Fuertes");
             System.out.println("3. Bebidas");
             System.out.println("4. Postres");
             System.out.println("5. Menú Infantil\n");

             int opcion = readInt();
        	
             switch (opcion) {
             	case 1:
             		Utilidad.limpiarPantalla();

             		pedido =restaurante.platosOferta("Entrada");
             		cliente.agregarPedido(pedido);
             		break;
             	case 2:
             		Utilidad.limpiarPantalla();


             		pedido =restaurante.platosOferta("Plato fuerte");
             		cliente.agregarPedido(pedido);
             		break;
        		
             	case 3:
       		 		Utilidad.limpiarPantalla();

             		pedido =restaurante.platosOferta("Bebida");
             		cliente.agregarPedido(pedido);             		
             		break;
        	
             	case 4:
          		 		Utilidad.limpiarPantalla();


             		pedido =restaurante.platosOferta("Postre");
             		cliente.agregarPedido(pedido);             	
             		break;
	
             	case 5:
             		 	Utilidad.limpiarPantalla();


             		pedido =restaurante.platosOferta("Infantil");
             		cliente.agregarPedido(pedido);
             		break;
             	default:
             		 	Utilidad.limpiarPantalla();


        			System.out.println("Opción no válida. Intente de nuevo.");
        			

             }

             System.out.println("¿Desea agregar un plato más? (s/n)");
             char confirmacion = readChar();
        
             if (confirmacion == 'n' || confirmacion == 'n') {
            	 confirma = true;
            	 System.out.println("Pedido confirmado.");
            	 System.out.println(cliente.mostrarPedido());
            	
             	}
             
             else if (confirmacion == 's'|| confirmacion == 'S') {
				Utilidad.limpiarPantalla();
				System.out.println("Selecciona de nuevo el tipo de plato que deseas pedir.");}
             else {
            	 System.out.println("Debe Seleccionar un caracter correcto (s/n)\n");}
             
        } while (!confirma); 
        
        
        
        
        
        
    
        
        
        
        //  recorre los platos dentro del pedido del cliente, en caso tal de que exista  los ingredientes
        //  se agregara a platosLLevar que posteriormente sera el nuevo pedido del cliente para evitar cobrar platos los cuales no hay suficientes ingredientes
        
        
        ArrayList<Plato>  platosLLevar = new ArrayList <Plato>();
        
        for( Plato pppp: cliente.getPedido().getPlatos()){
        	
        	platosLLevar.add(cocinero.cocinar(pppp));		
        
        }
        
        
        //Limpiael ArrayList platosllevar
        
        for (int i = platosLLevar.size() - 1; i >= 0; i--) {
            if (platosLLevar.get(i) == null) {
                platosLLevar.remove(i);
            }
        }
        
        
        mesero.llevar(platosLLevar, cliente);
        
   
        
        mesero.setOcupado(false);
        cocinero.setOcupado(false);
        
        
        asignarFactura(cliente.getPedido());
        
        return cliente.getPedido();
            
        
      
        
}
    
	
	// INTERACCION 3
	public static Factura asignarFactura(Pedido pedidoC) {
		
		System.out.println(pedidoC);

		
		Pedido pedido = pedidoC;
		int valorFactura = 0;
		Factura factura = new Factura(pedido,valorFactura);
		ArrayList <Plato> platosFactura = pedido.getPlatos();
		
		System.out.println("Realizando Facturación ");
		System.out.println(pedido + "  ------------ ");
		
		boolean continua = false;
		
		do{

				for (Plato plato: platosFactura) {
					valorFactura += plato.getPrecio();
				}
				continua = true;

				factura.setValor(valorFactura);
			}while (continua != true);
		
		
		
		System.out.println(factura+ "\n");
		System.out.println("Desea agregar propina\n1. Sí\n2. No");
		boolean bien = true;
		do {	
				int opcion = readInt();
				
				switch (opcion) {
					case 1:
					Utilidad.limpiarPantalla();

						System.out.println("Ingrese la cantidad sin comas ");
						int cantidad = readInt();
						factura.agregarPropina(cantidad);
						bien = false;
						break;
						
					case 2:
						bien = false;
						break;
					default:
						System.out.print("Ingrese un numero entero 1-2");
						break;
				
					}
				} while (bien);
		
		
		
		ArrayList<Trabajador> jiji = Restaurante.trabajadores;
		Trabajador mesero = jiji.get(1);
	
		mesero.asignaFactura(factura, Restaurante.clientes.getLast().getMesa());
		int ValorFactura = mesero.valorFactura(factura);
		mesero.actualizarGanancia(factura);
		
		System.out.println(factura);
		
		System.out.println("Saliendo..");

 		Utilidad.limpiarPantalla();

		return factura;
		
		
	
	}
        
        }
