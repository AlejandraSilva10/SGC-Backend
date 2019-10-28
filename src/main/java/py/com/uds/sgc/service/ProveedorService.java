package py.com.uds.sgc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.uds.sgc.converter.ProveedorConverter;
import py.com.uds.sgc.entity.Proveedor;
import py.com.uds.sgc.model.response.ProveedorResponse;
import py.com.uds.sgc.repository.ProveedorRepository;

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
    
    public void delete(Integer id) throws Exception{
        Proveedor entity = proveedorRepository.findById(id).get();
        if(entity != null){
            proveedorRepository.delete(entity);            
            return;
        }
        throw new Exception("El proveedor no existe");
    }
    
}
