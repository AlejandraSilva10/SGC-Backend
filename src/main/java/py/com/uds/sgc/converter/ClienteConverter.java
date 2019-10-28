package py.com.uds.sgc.converter;

import org.springframework.stereotype.Component;
import py.com.uds.sgc.entity.Cliente;
import py.com.uds.sgc.model.response.ClienteResponse;

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
