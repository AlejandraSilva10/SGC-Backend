/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.uds.sgc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.uds.sgc.converter.TipoDocumentoConverter;
import py.com.uds.sgc.entity.TipoDocumento;
import py.com.uds.sgc.model.request.TipoDocumentoRequest;
import py.com.uds.sgc.model.response.TipoDocumentoResponse;
import py.com.uds.sgc.repository.TipoDocumentoRepository;

/**
 *
 * @author gino_junchaya
 */

@Service
public class TipoDocumentoService {
    
    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;
    
    @Autowired
    private TipoDocumentoConverter tipoDocumentoConverter;
    
    public List<TipoDocumentoResponse> getAll(){
        return tipoDocumentoConverter.entitiesToModels(tipoDocumentoRepository.findAll());
    }
    
    public TipoDocumentoResponse save(TipoDocumentoRequest request){
        TipoDocumento entity = tipoDocumentoConverter.modelToEntity(request);
        return tipoDocumentoConverter.entityToModel(tipoDocumentoRepository.save(entity));
    }
    
    public void delete(Integer id) throws Exception{
        TipoDocumento entity = tipoDocumentoRepository.findById(id).get();
        if(entity != null){
            tipoDocumentoRepository.delete(entity);            
            return;
        }
        throw new Exception("El tipo de documento no existe");        
    }    
    
    
}
