package py.com.uds.sgc.model.request;

import java.util.Date;
import lombok.Data;

@Data
public class CompraRequest {

    private Integer id;
    private String nroComprobante;
    private Integer nroTimbrado;
    private Date fecha;
    private String importeTotal;
    private String exentas;
    private String iva10;
    private String iva5;
    private String concepto;
    private Integer contribuyente;
    private Integer proveedor;
    private Integer sucursal;
    private Integer tipoDocumento;
    
}
