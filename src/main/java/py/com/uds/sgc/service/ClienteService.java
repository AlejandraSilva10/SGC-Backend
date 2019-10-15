/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.uds.sgc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.uds.sgc.entity.Cliente;
import py.com.uds.sgc.repository.ClienteRepository;

/**
 *
 * @author gino_junchaya
 */

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    public List<Cliente> getAll(){
        return clienteRepository.findAll();        
    }
    
    public Cliente getById(Integer id){
        return clienteRepository.findById(id).get();
    }
    
    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }
    
    public Cliente update(Cliente cliente){
        return clienteRepository.saveAndFlush(cliente);
    }
    
}
