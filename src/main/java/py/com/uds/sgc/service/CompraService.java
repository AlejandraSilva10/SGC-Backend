/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.uds.sgc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.uds.sgc.converter.CompraConverter;
import py.com.uds.sgc.entity.Compra;
import py.com.uds.sgc.model.request.CompraRequest;
import py.com.uds.sgc.model.response.CompraResponse;
import py.com.uds.sgc.model.response.VentaResponse;
import py.com.uds.sgc.repository.CompraRepository;

/**
 *
 * @author gino_junchaya
 */

@Service
public class CompraService {
    
    @Autowired
    private CompraRepository compraRepository;
    
    @Autowired
    private CompraConverter compraConverter;
    
    public List<CompraResponse> getAll(){
        return compraConverter.entitiesToModels(compraRepository.findAll());
    }
    
    public List<CompraResponse> getByContribuyente(Integer id){
        return compraConverter.entitiesToModels(compraRepository.findByContribuyente(id));
    }    
    
    public CompraResponse getById(Integer id){
        return compraConverter.entityToModel(compraRepository.findById(id).get());
    }
    
    public CompraResponse save(CompraRequest request){
        Compra entity = compraConverter.modelToEntity(request);
        return compraConverter.entityToModel(compraRepository.save(entity));
    }
    
    public CompraResponse update(CompraRequest model) throws Exception{
        Compra entity = compraRepository.findById(model.getId()).get();
        if(entity != null){
            entity.setConcepto(model.getConcepto());
            entity.setExentas(model.getExentas());
            entity.setFecha(model.getFecha());
            entity.setImporteTotal(model.getImporteTotal());
            entity.setIva10(model.getIva10());
            entity.setIva5(model.getIva5());
            entity.setNroComprobante(model.getNroComprobante());
            entity.setNroTimbrado(model.getNroTimbrado());
            return compraConverter.entityToModel(compraRepository.saveAndFlush(entity));
        }
        throw new Exception("La compra no existe");
    }
    
    public void delete(Integer id) throws Exception{
        Compra entity = compraRepository.findById(id).get();
        if(entity != null){
            compraRepository.delete(entity);            
            return;
        }
        throw new Exception("La compra no existe");
    }
    
}
