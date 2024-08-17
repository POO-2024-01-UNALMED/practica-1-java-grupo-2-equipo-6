package gestorAplicacion.Entorno;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Casilla implements Serializable {
    private static ArrayList<Casilla> casillas = new ArrayList<Casilla>();
    private static ArrayList<String> tipos = new ArrayList<>(Arrays.asList("MESA", "VENTANA", "PUERTA"));
    public String tipo;
    private int coordX;
    private int coordY;

    public Casilla(){}
    public Casilla(int tipo, int coordX, int coordY) {
        this.tipo = tipos.get(tipo);
        this.coordX = coordX;
        this.coordY = coordY;
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
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
}
