package uiMain;

import gestorAplicacion.Gestion.Restaurante;
import gestorAplicacion.Usuario.Cliente;


public class Funcionalidad2 {

    public static Cliente establecerCliente(Restaurante restaurante) {
    		System.out.println("Ingrese el numero de cédulo de la persona que desea ordenar: ");
    		int cedula = Utilidad.readInt();
    		Cliente cliente = new Cliente();
    	
    		boolean valor = restaurante.confirmarCliente(cedula);
    	
    		if (valor){
    			for(Cliente i: restaurante.clientes) {
    				if (i.getCedula() == cedula) {
    					cliente = i;}	
    			
    			}
    		}
    		else {
    			System.out.println("El número de cédula ingresado no se encuentra en nuestra base para hacer pedido.\n	Para continuar es necesario ser registrado\n");
    			cliente = restaurante.crearCliente(cedula);
    		}
    	
    		return cliente;
    		
    		} 

    public static void hacerComida(Cliente cliente) {
    		
        System.out.println("Seleccione el tipo de plato que quiere ver\n1. Entrada\n2. Plato fuerte\n3. Bedidas\n4. Postre\n5. Menú infantil");
        int opcion = Utilidad.readInt();
        boolean confirma = true;
        do{
            switch (opcion) {
                case 1:
                       
                        //Entradas
                        
                case 2:
                        // Plato fuerte
                case 3:
                        // Bebidas
                    
                case 4:
                        // Postre
                    
                case 5:
                        //Menu infantil
                    }
                    
                
                }while (confirma);            
    }

}
