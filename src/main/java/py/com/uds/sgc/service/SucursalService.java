/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.uds.sgc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.uds.sgc.repository.SucursalRepository;

/**
 *
 * @author gino_junchaya
 */

@Service
public class SucursalService {
    
    @Autowired
    private SucursalRepository sucursalRepository;
    
}
