package py.com.uds.sgc.converter;

import org.springframework.stereotype.Component;
import py.com.uds.sgc.entity.Usuarios;
import py.com.uds.sgc.model.request.RegisterRequest;
import py.com.uds.sgc.model.response.LoginResponse;

@Component
public class UsuarioConverter {
    
    
    public LoginResponse entityToModel(Usuarios entity){
        LoginResponse model = new LoginResponse();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setPassword(entity.getPassword());
        model.setNombre(entity.getNombre());
        model.setApellido(entity.getApellido());
        return model;
    }
    
    public Usuarios modelToEntity(RegisterRequest request){
        Usuarios usuarios = new Usuarios();
        usuarios.setId(request.getId());
        usuarios.setUsername(request.getUsername());
        usuarios.setPassword(request.getPassword());
        usuarios.setEmail(request.getEmail());
        usuarios.setNombre(request.getNombre());
        usuarios.setApellido(request.getApellido());
        return usuarios;
    }
    
}
