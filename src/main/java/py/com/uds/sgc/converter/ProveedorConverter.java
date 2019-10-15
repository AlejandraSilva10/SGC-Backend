package py.com.uds.sgc.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import py.com.uds.sgc.entity.Proveedor;
import py.com.uds.sgc.model.response.ProveedorResponse;

@Component
public class ProveedorConverter {
    
    public ProveedorResponse entityToModel(Proveedor entity){
        if(entity == null){ return null; }
        ProveedorResponse model = new ProveedorResponse();
        model.setId(entity.getIdProveedor());
        model.setRazonSocial(entity.getRazonSocial());
        model.setRuc(entity.getRuc());
        return model;
    }
    
    public List<ProveedorResponse> entitiesToModels(List<Proveedor> entities){
        List<ProveedorResponse> models = new ArrayList<>();
        if(entities == null || entities.isEmpty()) { return models; }
        entities.forEach((entity) -> { models.add(this.entityToModel(entity)); });
        return models;
    }
    
}
