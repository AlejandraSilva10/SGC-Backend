package py.com.uds.sgc.model.response;

import java.util.Date;
import lombok.Data;

@Data
public class CompraResponse {

    private Integer id;
    private String nroComprobante;
    private Integer nroTimbrado;
    private Date fecha;
    private String importeTotal;
    private String exentas;
    private String iva10;
    private String iva5;
    private String concepto;
    private ContribuyenteResponse contribuyente;
    private ProveedorResponse proveedor;
    private SucursalResponse sucursal;
    private TipoDocumentoResponse tipoDocumento;
    
}
