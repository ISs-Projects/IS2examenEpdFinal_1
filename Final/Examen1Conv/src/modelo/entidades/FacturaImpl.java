package modelo.entidades;

import java.util.Date;


public class FacturaImpl implements Factura {

    private String identificador;
    private Cliente cliente;
    private Double importe;
    private Date fechaPago;

    public FacturaImpl(String identifiador, Cliente cliente, Double importe,Date fechaPago) {
        this.identificador = identifiador;
        this.cliente = cliente;
        this.importe = importe;
        this.fechaPago = fechaPago;
    }

    public FacturaImpl(String identificador) {
        this(identificador,null,null,null);
    }


    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    
    
    @Override
    public String getIdentificador() {
        return this.identificador;
    }

    @Override
    public Cliente getCliente() {
        return this.cliente;
    }

    @Override
    public Double getImporte() {
        return this.importe;
    }

    @Override
    public void setIdentificador(String id) {
        this.identificador = id;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    
    
}
