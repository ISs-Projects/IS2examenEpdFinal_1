package modelo.entidades;

import java.io.Serializable;

public interface Factura extends Serializable{
    
    public String getIdentificador();
    public Cliente getCliente();
    public Double getImporte();
    
    public void setIdentificador(String id);
    //void setCliente(Cliente cl);
    //void setImporte(Double im);
}
