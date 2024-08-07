package gestorAplicacion.Entorno;

import java.util.ArrayList;
import java.util.Arrays;

public class Casilla {
    private ArrayList<String> tipos = new ArrayList<>(Arrays.asList("MESA", "VENTANA", "PUERTA"));
    public String tipo;
    public int coordX;
    public int coordY;

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
}
