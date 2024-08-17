package gestorAplicacion.Gestion;

import java.util.ArrayList;
import java.util.List;

public interface Receta {
    String getNombre();
    int getPrecio();
    ArrayList<Ingrediente> getIngredientes();
    float getCalificacion();
    boolean isRecomendado();
    int getVecesPedido();
    int getValorEnPuntosCliente();

    void setNombre(String nombre);
    void setPrecio(int precio);
    void setIngredientes(ArrayList<Ingrediente> ingredientes);
    void setCalificacion(float calificacion);
    void setRecomendado(boolean recomendado);
    void setVecesPedido(int vecesPedido);
    void setValorEnPuntosCliente(int valorEnPuntosCliente);
}
