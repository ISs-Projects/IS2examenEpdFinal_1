package controlador;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.FacturaModel;
import modelo.entidades.Cliente;
import modelo.entidades.Factura;
import modelo.entidades.FacturaImpl;
import vista.factura.FacturaView;

public class FacturaControllerImpl extends AbstractControllerImpl<FacturaModel, FacturaView, Serializable> implements FacturaController {

    @Override
    protected Factura generaEntidad(List<Serializable> datos) {
        
        String identificador = (String) datos.get(0);
        Cliente cliente = (Cliente) datos.get(1);
        Double importe = new Double((String) datos.get(2));
        String fechaEnString = (String) datos.get(3);    
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null; // Variable que almacenará la fecha
// fechaEnString es de tipo String y contiene la fecha a convertir
        if (fechaEnString.length() > 2) {
            try {
                fecha = formatter.parse(fechaEnString);
            } catch (ParseException ex) {
                Logger.getLogger(FacturaControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        Factura f = new FacturaImpl(identificador, cliente, importe, fecha);
        f.setImporte(importe);
        return f;

    }

    @Override
    protected Factura generaEntidad(Serializable pk) {
        return new FacturaImpl((String) pk);
    }

    @Override
    public List<Factura> listaFacturaEntidadGesture() {
        return getModel().listar();
    }

    @Override
    public List<Factura> listarFacuraEntidadPorClienteGesture(String nombre) {
        return getModel().listarPorCliente(nombre);
    }
    
    public List<Factura> listarFacturaEntidadPorAnyoGesture(String fechaEnString){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha2 = null;
        Date fecha = null; // Variable que almacenará la fecha
// fechaEnString es de tipo String y contiene la fecha a convertir
        if (fechaEnString.length() > 0) {
            try {
                Integer anyo = Integer.valueOf(fechaEnString);
                fechaEnString+="-01-01";
                fecha = formatter.parse(fechaEnString);
            } catch (ParseException ex) {
                Logger.getLogger(FacturaControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return getModel().listarPorAnyo(fecha);
    }

}
