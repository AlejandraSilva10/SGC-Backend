/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.uds.sgc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.uds.sgc.converter.ProveedorConverter;
import py.com.uds.sgc.entity.Proveedor;
import py.com.uds.sgc.model.response.ProveedorResponse;
import py.com.uds.sgc.repository.ProveedorRepository;

/**
 *
 * @author gino_junchaya
 */

@Service
public class ProveedorService {
    
    @Autowired
    private ProveedorRepository proveedorRepository;
    
    @Autowired
    private ProveedorConverter proveedorConverter;
    
    public List<ProveedorResponse> getAll(){
        return proveedorConverter.entitiesToModels(proveedorRepository.findAll());
    }
    
    public ProveedorResponse getById(Integer id){
        return proveedorConverter.entityToModel(proveedorRepository.findById(id).get());
    }
    
    public Proveedor save(Proveedor entity){
        return proveedorRepository.save(entity);
    }
    
    public Proveedor update(Proveedor entity){
        return proveedorRepository.saveAndFlush(entity);
    }
    
}
