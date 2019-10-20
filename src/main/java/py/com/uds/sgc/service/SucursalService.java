/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.uds.sgc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.uds.sgc.converter.SucursalConverter;
import py.com.uds.sgc.entity.Sucursal;
import py.com.uds.sgc.model.request.SucursalRequest;
import py.com.uds.sgc.model.response.SucursalResponse;
import py.com.uds.sgc.repository.SucursalRepository;

/**
 *
 * @author gino_junchaya
 */

@Service
public class SucursalService {
    
    @Autowired
    private SucursalRepository sucursalRepository;
    
    @Autowired
    private SucursalConverter sucursalConverter;
    
    public List<SucursalResponse> getAll(){
        return sucursalConverter.entitiesToModels(sucursalRepository.findAll());
    }
    
    public List<SucursalResponse> getFiltered(Integer contribuyente){
        return sucursalConverter.entitiesToModels(sucursalRepository.findByContribuyente(contribuyente));
    }
    
    public SucursalResponse save(SucursalRequest model){
        Sucursal entity = sucursalConverter.modelToEntity(model);
        return sucursalConverter.entityToModel(sucursalRepository.save(entity));
    }
    
    public SucursalResponse update(SucursalRequest model) throws Exception{
        Sucursal entity = sucursalRepository.findById(model.getId()).get();
        if(entity != null){
            entity.setDescripcion(model.getDescripcion());
            return sucursalConverter.entityToModel(sucursalRepository.saveAndFlush(entity));
        }
        throw new Exception("La sucursal no existe");
    }
    
    public void delete(Integer id) throws Exception{
        Sucursal entity = sucursalRepository.findById(id).get();
        if(entity != null){
            sucursalRepository.delete(entity);            
            return;
        }
        throw new Exception("La sucursal no existe");        
    }
    
}
