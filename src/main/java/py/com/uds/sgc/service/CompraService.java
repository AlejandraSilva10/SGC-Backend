/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.uds.sgc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.uds.sgc.entity.Compra;
import py.com.uds.sgc.repository.CompraRepository;

/**
 *
 * @author gino_junchaya
 */

@Service
public class CompraService {
    
    @Autowired
    private CompraRepository compraRepository;
    
    public List<Compra> getAll(){
        return compraRepository.findAll();        
    }
    
    public Compra getById(Integer id){
        return compraRepository.findById(id).get();
    }
    
    public Compra save(Compra entity){
        return compraRepository.save(entity);
    }
    
    public Compra update(Compra entity){
        return compraRepository.saveAndFlush(entity);
    }
    
}
