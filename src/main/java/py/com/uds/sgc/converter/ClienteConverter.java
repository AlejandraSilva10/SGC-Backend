/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.uds.sgc.converter;

import org.springframework.stereotype.Component;
import py.com.uds.sgc.entity.Cliente;
import py.com.uds.sgc.model.response.ClienteResponse;

/**
 *
 * @author gino_junchaya
 */

@Component
public class ClienteConverter {
    
    public ClienteResponse entityToModel(Cliente entity){
        ClienteResponse response = new ClienteResponse();
        response.setId(entity.getIdCliente());
        response.setRazonSocial(entity.getRazonSocial());
        response.setRuc(entity.getRuc());
        return response;
    }
    
}
