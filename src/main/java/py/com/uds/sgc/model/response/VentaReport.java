package py.com.uds.sgc.model.response;

import java.util.Date;
import lombok.Data;

@Data
public class VentaReport {
    private Date fecha;
    private String nroComprobante;       
    private String tipoDocumento;
    private String importeTotal;
    private String exentas;
    private String iva10;
    private String iva5;
    private String cliente;
    private String clienteRuc;
    private String sucursal;
}
