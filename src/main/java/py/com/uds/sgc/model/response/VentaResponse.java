package py.com.uds.sgc.model.response;

import java.util.Date;
import lombok.Data;

@Data
public class VentaResponse {
    private Integer id;
    private String nroComprobante;
    private Integer nroTimbrado;
    private Date fecha;       
    private TipoDocumentoResponse tipoDocumento;
    private String importeTotal;
    private String exentas;
    private String iva10;
    private String iva5;
    private String concepto;
    private ClienteResponse cliente;
    private SucursalResponse sucursal;
}
