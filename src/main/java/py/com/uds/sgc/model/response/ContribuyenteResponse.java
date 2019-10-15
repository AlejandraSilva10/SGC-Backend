/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.uds.sgc.model.response;

import lombok.Data;

/**
 *
 * @author gino_junchaya
 */

@Data
public class ContribuyenteResponse {

    private Integer id;
    private String razonSocial;
    private String ruc;
    private String telefono;
    private String direccion;

//    private PlanCuenta idPlanCuentas;
//    private List<PeriodoFiscal> periodosFiscalesList;
//    private List<Compra> comprasList;
//    private List<Sucursal> sucursalesList;
//    private List<Venta> ventasList;
    
    
}
