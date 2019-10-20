/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.uds.sgc.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import py.com.uds.sgc.entity.Contribuyente;
import py.com.uds.sgc.entity.Sucursal;
import py.com.uds.sgc.model.request.SucursalRequest;
import py.com.uds.sgc.model.response.SucursalResponse;

/**
 *
 * @author gino_junchaya
 */

@Component
public class SucursalConverter {

    public SucursalResponse entityToModel(Sucursal entity){
        if(entity == null){ return null; }
        SucursalResponse model = new SucursalResponse();
        model.setDescripcion(entity.getDescripcion());
        model.setId(entity.getIdSucursal());
        return model;
    }
    
    public List<SucursalResponse> entitiesToModels(List<Sucursal> entities){
        List<SucursalResponse> models = new ArrayList<>();
        if(entities == null || entities.isEmpty()){
            return models;
        }
        for(Sucursal entity : entities){
            models.add(this.entityToModel(entity));
        }
        return models;
    }
    
    public Sucursal modelToEntity(SucursalRequest model){
        if(model == null) { return null; }
        Sucursal entity = new Sucursal();
        entity.setDescripcion(model.getDescripcion());
        entity.setIdSucursal(model.getId());
        Contribuyente contribuyente = new Contribuyente();
        contribuyente.setIdContribuyente(model.getIdContribuyente());
        entity.setIdContribuyente(contribuyente);
        return entity;
    }
    
}
