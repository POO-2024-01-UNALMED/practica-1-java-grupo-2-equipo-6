package gestorAplicacion.Gestion;

import java.io.Serializable;
import java.util.ArrayList;

public class Factura implements Serializable {
    //  Atributos
    private static ArrayList<Factura> facturas = new ArrayList<Factura>();
    private Evento evento;
    private static int numeroFactura = 0;
    private int valor = 0;
    private String metodoPago;
    private boolean pagoPreconsumo;
    private Pedido pedido;
    private int propina;
    private boolean pagada;

    // Constructores
    public Factura(){
        facturas.add(this);
    }

    public Factura(Pedido pedido){
        this.pedido = pedido;
        numeroFactura++;
        facturas.add(this);
    }

    public Factura(Pedido pedido, int valor) {
    	this.pedido = pedido;
    	this.valor = valor;
    	numeroFactura ++;
        facturas.add(this);
    }

    public Factura(Pedido pedido, String metodoPago, boolean pagoPreconsumo, int propina){
        this.pedido = pedido;
        this.metodoPago = metodoPago;
        this.pagoPreconsumo = pagoPreconsumo;
        this.propina = propina;
        this.pagada = false;
        numeroFactura++;
        facturas.add(this);
    }

    public Factura(int valor, int propina, boolean pagada){
        this.valor = valor;
        this.propina = propina;
        this.pagada = pagada;
        facturas.add(this);
    }

    // Metodos
    public static Factura crearFacturaUnificada(ArrayList<Factura> facturas){
        int valor = 0;
        for (Factura factura : facturas) {
            valor += factura.calcularValor();
        }
        return new Factura(valor, 0, false);
    }

    public static ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void pagar(){
        this.pagada = true;
    }
    public void setMetodoPago(String metodoPago){
        this.metodoPago = metodoPago;
    }
    public void setPagoPreconsumo(boolean pagoPreconsumo){
        this.pagoPreconsumo = pagoPreconsumo;
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
    public Pedido getPedido(){
        return pedido;
    }
    public Factura(Evento evento){
        this.evento = evento;
    }
    public void aumentarValor(int valor) {
        this.valor += valor;
    }
    public Evento getEvento() {
        return evento;
    }
    public void setEvento(Evento evento) {
        this.evento = evento;
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
        String factura = ("\nNúmero factura "+ Factura.numeroFactura + "\n" + calcularValor());
        return factura;
    }

}