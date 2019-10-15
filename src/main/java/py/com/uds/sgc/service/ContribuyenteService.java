/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.uds.sgc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.uds.sgc.converter.ContribuyenteConverter;
import py.com.uds.sgc.entity.Contribuyente;
import py.com.uds.sgc.model.response.ContribuyenteResponse;
import py.com.uds.sgc.repository.ContribuyenteRepository;

/**
 *
 * @author gino_junchaya
 */

@Service
public class ContribuyenteService {
    
    @Autowired
    private ContribuyenteRepository contribuyenteRepository;
    
    @Autowired
    private ContribuyenteConverter contribuyenteConverter;
    
    public List<ContribuyenteResponse> getAll(){
        return contribuyenteConverter.entitiesToModels(contribuyenteRepository.findAll());
    }
    
    public ContribuyenteResponse getById(Integer id){
        return contribuyenteConverter.entityToModel(contribuyenteRepository.findById(id).get());
    }
    
    public Contribuyente save(Contribuyente entity){
        return contribuyenteRepository.save(entity);
    }
    
    public Contribuyente update(Contribuyente entity){
        return contribuyenteRepository.saveAndFlush(entity);
    }
    
}
