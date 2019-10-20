/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.uds.sgc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.uds.sgc.converter.VentaConverter;
import py.com.uds.sgc.entity.Venta;
import py.com.uds.sgc.model.request.VentaRequest;
import py.com.uds.sgc.model.response.VentaResponse;
import py.com.uds.sgc.repository.VentaRepository;

/**
 *
 * @author gino_junchaya
 */

@Service
public class VentaService {
    
    @Autowired
    private VentaRepository ventaRepository;
    
    @Autowired
    private VentaConverter ventaConverter;
    
    public List<VentaResponse> getAll(){
        return ventaConverter.entitiesToModels(ventaRepository.findAll());
    }
    
    public List<VentaResponse> getByContribuyente(Integer id){
        return ventaConverter.entitiesToModels(ventaRepository.findByContribuyente(id));
    }
    
    public VentaResponse save(VentaRequest request){
        Venta entity = ventaConverter.modelToEntity(request);
        return ventaConverter.entityToModel(ventaRepository.save(entity));
    }
    
    public void delete(Integer id) throws Exception{
        Venta entity = ventaRepository.findById(id).get();
        if(entity != null){
            ventaRepository.delete(entity);            
            return;
        }
        throw new Exception("La venta no existe");        
    }
    
}
