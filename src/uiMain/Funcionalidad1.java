package uiMain;

import static uiMain.Utilidad.*;

public class Funcionalidad1 {
    public static void reservarMesa() {
        System.out.println("Elija la ciudad donde desea hacer la reserva:");
        listadoCiudades();
        int eleccion = readInt();
        
    }
}
