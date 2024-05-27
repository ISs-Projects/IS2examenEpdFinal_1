package modelo.entidades;

import java.io.Serializable;
import java.util.Date;

public interface Factura extends Serializable,Entidad {
    
    public String getIdentificador();
    public Cliente getCliente();
    public Double getImporte();
    public Date getFechaPago();
    
    public void setFechaPago(Date fechaPago);
    public void setIdentificador(String id);
    //void setCliente(Cliente cl);
    void setImporte(Double im);
}
