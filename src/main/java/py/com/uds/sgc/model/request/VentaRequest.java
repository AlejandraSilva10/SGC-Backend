/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.uds.sgc.model.request;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author gino_junchaya
 */

@Data
public class VentaRequest {
    
    private Integer id;
    private String nroComprobante;
    private Integer nroTimbrado;
    private Date fecha;
    private Integer idTipoDocumento;
    private String importeTotal;
    private String exentas;
    private String iva10;
    private String iva5;
    private String concepto;
    private Integer idCliente;
    private Integer idContribuyente;
    private Integer idRubro;
    private Integer idSucursal;
    
}