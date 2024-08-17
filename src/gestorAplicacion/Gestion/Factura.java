package gestorAplicacion.Gestion;

import java.io.Serializable;
import java.util.ArrayList;

public class Factura implements Serializable {
    private static ArrayList<Factura> facturas = new ArrayList<Factura>();
    Evento evento;
    //  Atributos
    private static int numeroFactura = 0;
    private int valor = 0;
    private String metodoPago;
    private boolean pagoPreconsumo;
    private Pedido pedido;
    private int propina;
    private boolean pagada;


    // Constructores
    public Factura(){}

    public Factura(Pedido pedido, String metodoPago, boolean pagoPreconsumo, int propina){
        this.pedido = pedido;
        this.metodoPago = metodoPago;
        this.pagoPreconsumo = pagoPreconsumo;
        this.propina = propina;
        this.pagada = false;
        numeroFactura++;
    }

    public Factura(int valor, int propina, boolean pagada){
        this.valor = valor;
        this.propina = propina;
        this.pagada = pagada;
    }

    // Metodos
    public static Factura crearFacturaUnificada(ArrayList<Factura> facturas){
        int valor = 0;
        for (Factura factura : facturas) {
            valor += factura.calcularValor();
        }
        return new Factura(valor, 0, false);
    }
    public void pagar(){
        this.pagada = true;
    }
    public void agregarPlato(Plato plato){
        pedido.agregarPlato(plato);
    }
    public void setPropina(int propina){
        this.propina = propina;
    }
    public void setMetodoPago(String metodoPago){
        this.metodoPago = metodoPago;
    }
    public void setPagoPreconsumo(boolean pagoPreconsumo){
        this.pagoPreconsumo = pagoPreconsumo;
    }
    public void setPedido(Pedido pedido){
        this.pedido = pedido;
    }
    public void setValor(int valor){
        this.valor = valor;
    }
    public int getValor(){
        return valor;
    }
    public String getMetodoPago(){
        return metodoPago;
    }
    public boolean getPagoPreconsumo(){
        return pagoPreconsumo;
    }
    public Pedido getPedido(){
        return pedido;
    }
    public int getPropina(){
        return propina;
    }
    public boolean getPagada(){
        return pagada;
    }
    public static int getNumeroFactura(){
        return numeroFactura;
    }
    public static void setNumeroFactura(int numeroFactura){
        Factura.numeroFactura = numeroFactura;
    }
    public void setPagada(boolean pagada){
        this.pagada = pagada;
    }
    public Factura(Evento evento){
        this.evento = evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public void aumentarValor(int valor) {
        this.valor += valor;
    }

    public int calcularValor(){
        int valor = 0;
        for (Plato plato : pedido.getPlatos()){
            valor += plato.getPrecio();
        }
        if (pagoPreconsumo){
            valor += (int) (valor * 0.19);
        }
        valor += propina;
        this.setValor(valor);
        return valor;
    }

    @Override
    public String toString(){

        return ("Número factura "+ Factura.numeroFactura + "\n" + pedido.toString() + "Total :      $  " + getValor());
    }

}