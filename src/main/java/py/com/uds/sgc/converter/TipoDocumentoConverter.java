/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.uds.sgc.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import py.com.uds.sgc.entity.TipoDocumento;
import py.com.uds.sgc.model.request.TipoDocumentoRequest;
import py.com.uds.sgc.model.response.TipoDocumentoResponse;

/**
 *
 * @author gino_junchaya
 */

@Component
public class TipoDocumentoConverter {
    
    public TipoDocumentoResponse entityToModel(TipoDocumento entity){
        TipoDocumentoResponse response = new TipoDocumentoResponse();
        response.setId(entity.getIdTipoDocumento());
        response.setDescripcion(entity.getDescripcion());
        return response;
    }
    
    public List<TipoDocumentoResponse> entitiesToModels(List<TipoDocumento> entities){
        List<TipoDocumentoResponse> models = new ArrayList<>();
        if(entities == null || entities.isEmpty()){
            return models;
        }
        for(TipoDocumento entity : entities){
            models.add(this.entityToModel(entity));
        }
        return models;
    }
    
    public TipoDocumento modelToEntity(TipoDocumentoRequest request){
        TipoDocumento entity = new TipoDocumento();
        entity.setDescripcion(request.getDescripcion());
        entity.setIdTipoDocumento(request.getId());
        return entity;
    }
    
}
