package baseDatos;

import java.io.*;

public class Serializador {
    private static File rutaTemp = new File("src/baseDatos/temp");
    public static void serializar(Object objeto){
        try {
            FileOutputStream fileOut = new FileOutputStream(rutaTemp);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(objeto);
            objectOut.close();
            System.out.println("El objeto ha sido serializado");
        } catch (Exception ex) {
            ex.printStackTrace();
    }
}
}
