package py.com.uds.sgc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.com.uds.sgc.converter.CompraConverter;
import py.com.uds.sgc.entity.Compra;
import py.com.uds.sgc.entity.Proveedor;
import py.com.uds.sgc.entity.Sucursal;
import py.com.uds.sgc.model.request.CompraRequest;
import py.com.uds.sgc.model.response.CompraResponse;
import py.com.uds.sgc.repository.CompraRepository;

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
            Proveedor proveedor = new Proveedor();
            proveedor.setIdProveedor(model.getProveedor());
            entity.setIdProveedor(proveedor);
            Sucursal sucursal = new Sucursal();
            sucursal.setIdSucursal(model.getSucursal());
            entity.setIdSucursal(sucursal);
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

    @Transactional
    public void delete(Integer id) throws Exception{
        Compra entity = compraRepository.findById(id).get();
        if(entity != null){
            compraRepository.delete(entity.getIdCompra());            
            return;
        }
        throw new Exception("La compra no existe");
    }
    
}
