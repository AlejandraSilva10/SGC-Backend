/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.uds.sgc.model.request;

import lombok.Data;

/**
 *
 * @author gino_junchaya
 */

@Data
public class SucursalRequest {
    
    private Integer id;
    private String descripcion;    
    private Integer idContribuyente;
    
}
