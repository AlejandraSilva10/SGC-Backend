package py.com.uds.sgc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import py.com.uds.sgc.converter.ContribuyenteConverter;
import py.com.uds.sgc.entity.Contribuyente;
import py.com.uds.sgc.model.request.ContribuyenteRequest;
import py.com.uds.sgc.model.response.ContribuyenteResponse;
import py.com.uds.sgc.repository.ContribuyenteRepository;

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
    
    public Contribuyente save(ContribuyenteRequest model){
        Contribuyente entity = contribuyenteConverter.modelToEntity(model);
        return contribuyenteRepository.save(entity);
    }
    
    public ContribuyenteResponse update(ContribuyenteRequest model) throws Exception{
        Contribuyente entity = contribuyenteRepository.findById(model.getId()).get();
        if(entity != null){
            entity.setDireccion(model.getDireccion());
            entity.setRazonSocial(model.getRazonSocial());
            entity.setRuc(model.getRuc());
            entity.setTelefono(model.getTelefono());
            return contribuyenteConverter.entityToModel(contribuyenteRepository.saveAndFlush(entity));
        }
        throw new Exception("El contribuyente no existe");
    }
    
    public void delete(Integer id) throws Exception{
        Contribuyente entity = contribuyenteRepository.findById(id).get();
        if(entity != null){
            contribuyenteRepository.delete(entity);            
            return;
        }
        throw new Exception("El contribuyente no existe");
    }
    
}
