package py.com.uds.sgc.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import py.com.uds.sgc.entity.Contribuyente;
import py.com.uds.sgc.model.response.ContribuyenteResponse;

@Component
public class ContribuyenteConverter {
    
    public ContribuyenteResponse entityToModel(Contribuyente entity){
        if(entity == null){ return null; }
        ContribuyenteResponse model = new ContribuyenteResponse();
        model.setDireccion(entity.getDireccion());
        model.setId(entity.getIdContribuyente());
        model.setRazonSocial(entity.getRazonSocial());
        model.setRuc(entity.getRuc());
        model.setTelefono(entity.getTelefono());
        return model;
    }
    
    public List<ContribuyenteResponse> entitiesToModels(List<Contribuyente> entities){
        List<ContribuyenteResponse> models = new ArrayList<>();
        if(entities == null || entities.isEmpty()) { return models; }
        entities.forEach((entity) -> { models.add(this.entityToModel(entity)); });
        return models;
    }
    
}
