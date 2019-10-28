package py.com.uds.sgc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.com.uds.sgc.converter.VentaConverter;
import py.com.uds.sgc.entity.Cliente;
import py.com.uds.sgc.entity.Sucursal;
import py.com.uds.sgc.entity.Venta;
import py.com.uds.sgc.model.request.VentaRequest;
import py.com.uds.sgc.model.response.VentaResponse;
import py.com.uds.sgc.repository.VentaRepository;

@Service
public class VentaService {
    
    @Autowired
    private VentaRepository ventaRepository;
    
    @Autowired
    private VentaConverter ventaConverter;
    
    public List<VentaResponse> getAll(){
        return ventaConverter.entitiesToModels(ventaRepository.findAll());
    }
    
    public List<VentaResponse> getByContribuyente(Integer id){
        return ventaConverter.entitiesToModels(ventaRepository.findByContribuyente(id));
    }
    
    public VentaResponse save(VentaRequest request){
        Venta entity = ventaConverter.modelToEntity(request);
        return ventaConverter.entityToModel(ventaRepository.save(entity));
    }
    
    public VentaResponse update(VentaRequest request) throws Exception{
        Venta entity = ventaRepository.findById(request.getId()).get();
        if(entity != null){
            entity.setConcepto(request.getConcepto());
            entity.setExentas(request.getExentas());
            entity.setFecha(request.getFecha());
            Sucursal sucursal = new Sucursal();
            sucursal.setIdSucursal(request.getIdSucursal());
            entity.setIdSucursal(sucursal);
            Cliente cliente = new Cliente();
            cliente.setIdCliente(request.getIdCliente());
            entity.setIdCliente(cliente);
            entity.setIdTipoDocumento(request.getId());
            entity.setImporteTotal(request.getImporteTotal());
            entity.setIva10(request.getIva10());
            entity.setIva5(request.getIva5());
            entity.setNroComprobante(request.getNroComprobante());
            entity.setNroTimbrado(request.getNroTimbrado());
            return ventaConverter.entityToModel(ventaRepository.saveAndFlush(entity));
        }
        throw new Exception("La venta no existe");
    }
    
    
    @Transactional
    public void delete(Integer id) throws Exception{
        Venta entity = ventaRepository.findById(id).get();
        if(entity != null){
            ventaRepository.delete(entity.getIdVenta());            
            return;
        }
        throw new Exception("La venta no existe");        
    }
    
}
