/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.uds.sgc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.uds.sgc.converter.UsuarioConverter;
import py.com.uds.sgc.entity.Usuarios;
import py.com.uds.sgc.model.request.LoginRequest;
import py.com.uds.sgc.model.request.RegisterRequest;
import py.com.uds.sgc.model.response.LoginResponse;
import py.com.uds.sgc.model.response.RegisterResponse;
import py.com.uds.sgc.repository.UsuarioRepository;

/**
 *
 * @author gino_junchaya
 */

@Service
public class LoginService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private UsuarioConverter usuarioConverter;
    
    public LoginResponse getByUsername(String username){
        return usuarioConverter.entityToModel(usuarioRepository.findByUsername(username));        
    }
    
    public LoginResponse login(LoginRequest request) throws Exception {
        LoginResponse user = this.getByUsername(request.getUsername());
        if(user.getPassword().equals(request.getPassword())){
            return user;
        }
        else{
            throw new Exception("Usuario o contraseña incorrecta");
        }        
    }
    
    public LoginResponse register(RegisterRequest request){
        Usuarios entity = usuarioConverter.modelToEntity(request);
        usuarioRepository.save(entity);
        return usuarioConverter.entityToModel(entity);
    }
    
}
