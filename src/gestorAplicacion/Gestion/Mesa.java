package gestorAplicacion.Gestion;

import gestorAplicacion.Entorno.Casilla;

public class Mesa extends Casilla {
    //Atributos
    public static int contadorMesa;
    private boolean VIP;

    //Constructor
    public Mesa(){}
    public Mesa(int tipo, int coordX, int coordY, boolean VIP) {
        super(tipo, coordX, coordY);
        this.VIP = VIP;
    }

    //Métodos
    public boolean isVIP() {
        return VIP;
    }
    public void setVIP(boolean VIP) {
        this.VIP = VIP;
    }
}
