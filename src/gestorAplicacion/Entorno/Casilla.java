package gestorAplicacion.Entorno;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Casilla implements Serializable {
    private static final long serialVersionUID = 1L;
    private static ArrayList<Casilla> casillas = new ArrayList<Casilla>();
    private static ArrayList<String> tipos = new ArrayList<>(Arrays.asList("MESA", "VENTANA", "PUERTA"));
    public String tipo;
    private int coordX;
    private int coordY;

    public Casilla(){
        casillas.add(this);
    }
    public Casilla(int tipo, int coordX, int coordY) {
        this.tipo = tipos.get(tipo);
        this.coordX = coordX;
        this.coordY = coordY;
        casillas.add(this);
    }
    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public String getTipo() {
        return tipo;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Casilla{");
        sb.append("tipo='").append(tipo).append('\'');
        sb.append(", coordX=").append(coordX);
        sb.append(", coordY=").append(coordY);
        sb.append('}');
        return sb.toString();
    }

    public static ArrayList<Casilla> getCasillas() {
        return casillas;
    }
}
