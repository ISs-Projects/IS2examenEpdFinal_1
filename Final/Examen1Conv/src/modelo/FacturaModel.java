package modelo;


import controlador.FacturaController;
import java.util.Date;
import java.util.List;
import modelo.entidades.Factura;

public interface FacturaModel extends Model<FacturaController,Factura,String>{
    List<Factura> listarPorCliente(String nombre);
    List<Factura> listarPorAnyo(Date fecha);
}
