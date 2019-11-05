package py.com.uds.sgc.model.response;

import java.util.Date;
import lombok.Data;

@Data
public class CompraReport {

    private String nroComprobante;
    private Date fecha;
    private String importeTotal;
    private String exentas;
    private String gravadas10;
    private String iva10;
    private String gravadas5;
    private String iva5;
    private String proveedor;
    private String proveedorRuc;    
    private String sucursal;
    private String tipoDocumento;
    
}
