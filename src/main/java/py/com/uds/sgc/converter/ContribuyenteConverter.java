package py.com.uds.sgc.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import py.com.uds.sgc.entity.Contribuyente;
import py.com.uds.sgc.entity.PlanCuenta;
import py.com.uds.sgc.model.request.ContribuyenteRequest;
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
    
    public Contribuyente modelToEntity(ContribuyenteRequest model){
        if(model == null) { return null; }
        Contribuyente entity = new Contribuyente();
        entity.setRuc(model.getRuc());
        entity.setDireccion(model.getDireccion());
        entity.setIdContribuyente(model.getId());
        entity.setTelefono(model.getTelefono());
        entity.setRazonSocial(model.getRazonSocial());
        PlanCuenta planCuenta = new PlanCuenta();
        planCuenta.setIdPlanCuentas(model.getIdPlanCuentas());
        entity.setIdPlanCuentas(planCuenta);
        return entity;
    }
    
    public Contribuyente modelToEntity(ContribuyenteResponse model){
        if(model == null) { return null; }
        Contribuyente entity = new Contribuyente();
        entity.setRuc(model.getRuc());
        entity.setDireccion(model.getDireccion());
        entity.setIdContribuyente(model.getId());
        entity.setTelefono(model.getTelefono());
        entity.setRazonSocial(model.getRazonSocial());
        return entity;
    }    
        
}
