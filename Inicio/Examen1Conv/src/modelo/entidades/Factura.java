package modelo.entidades;

import java.io.Serializable;

public interface Factura extends Serializable{
    
    public String getIdentificador();
    public Cliente getCliente();
    public Double getImporte();
    
    public void setIdentificador(String id);
    //void setCliente(Cliente cl);
    // Habilitamos el método que se encontraba comentado 
    void setImporte(Double im);
    
    // Definimos el metodo para marcar la factura como pagada
    public void setPagado(Boolean p);
    public Boolean getPagado();
}
