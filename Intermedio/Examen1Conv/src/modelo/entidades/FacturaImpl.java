package modelo.entidades;

public class FacturaImpl implements Factura {

    private String identificador;
    private Cliente cliente;
    private Double importe;
    private Boolean pago;
    
    java.sql.Date variableSqlDate = new java.sql.Date(variableUtilDate.getTime());
    
    // Getter y Setter de 'pago'

    
    public Boolean getPagado() {
        return pago;
    }

    @Override
    public void setPagado(Boolean pa) {
        this.pago = pa;
    }

    // Al inicializar una factura, ésta se marca como no pagada pagada.
    // Contructor que llama 'FacturaControllerImpl'
    public FacturaImpl(String identifiador, Cliente cliente, Double importe, Boolean pa) {
        this.identificador = identifiador;
        this.cliente = cliente;
        this.importe = importe;
        this.pago = false;
    }

    // Contructor que llama 'FacturaControllerImpl'
    public FacturaImpl(String identificador, Cliente cliente) {
        this(identificador, cliente, null, false);
    }

    // Contructor que llama 'FacturaControllerImpl'
    public FacturaImpl(String identificador) {
        this(identificador, null, null, false);
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

    // Implementamos el método para 'settear' importe
    @Override
    public void setImporte(Double im) {
        this.importe = im;
    }

}
