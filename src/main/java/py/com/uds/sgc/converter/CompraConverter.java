package py.com.uds.sgc.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import py.com.uds.sgc.entity.Compra;
import py.com.uds.sgc.entity.Contribuyente;
import py.com.uds.sgc.entity.Proveedor;
import py.com.uds.sgc.entity.Sucursal;
import py.com.uds.sgc.entity.TipoDocumento;
import py.com.uds.sgc.model.request.CompraRequest;
import py.com.uds.sgc.model.response.CompraResponse;

@Component
public class CompraConverter {
    
    @Autowired
    private ContribuyenteConverter contribuyenteConverter;
    
    @Autowired
    private ProveedorConverter proveedorConverter;
    
    @Autowired
    private SucursalConverter sucursalConverter;
    
    @Autowired
    private TipoDocumentoConverter tipoDocumentoConverter;
    
    public CompraResponse entityToModel(Compra entity){
        if(entity == null){ return null; }
        CompraResponse model = new CompraResponse();
        model.setConcepto(entity.getConcepto());
        model.setExentas(entity.getExentas());
        model.setFecha(entity.getFecha());
        model.setId(entity.getIdCompra());
        model.setImporteTotal(entity.getImporteTotal());
        model.setIva10(entity.getIva10());
        model.setIva5(entity.getIva5());
        model.setNroComprobante(entity.getNroComprobante());
        model.setNroTimbrado(entity.getNroTimbrado());
        model.setContribuyente(contribuyenteConverter.entityToModel(entity.getIdContribuyente()));
        model.setProveedor(proveedorConverter.entityToModel(entity.getIdProveedor()));
        model.setSucursal(sucursalConverter.entityToModel(entity.getIdSucursal()));
        model.setTipoDocumento(tipoDocumentoConverter.entityToModel(entity.getIdTipoDocumento()));
        return model;
    }
    
    public List<CompraResponse> entitiesToModels(List<Compra> entities){
        List<CompraResponse> models = new ArrayList<>();
        if(entities == null || entities.isEmpty()){
            return models;
        }
        entities.forEach((entity) -> { models.add(this.entityToModel(entity)); });
        return models;
    }
    
    public Compra modelToEntity(CompraRequest request){
        Compra entity = new Compra();
        entity.setConcepto(request.getConcepto());
        entity.setExentas(request.getExentas());
        entity.setFecha(request.getFecha());
        entity.setIdCompra(request.getId());
        entity.setImporteTotal(request.getImporteTotal());
        entity.setIva10(request.getIva10());
        entity.setIva5(request.getIva5());
        entity.setNroComprobante(request.getNroComprobante());
        entity.setNroTimbrado(request.getNroTimbrado());

        Contribuyente contribuyente = new Contribuyente();
        contribuyente.setIdContribuyente(request.getContribuyente());
        entity.setIdContribuyente(contribuyente);
        
        Proveedor proveedor = new Proveedor();
        proveedor.setIdProveedor(request.getProveedor());
        entity.setIdProveedor(proveedor);
        
        Sucursal sucursal = new Sucursal();
        sucursal.setIdSucursal(request.getSucursal());
        entity.setIdSucursal(sucursal);
        
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setIdTipoDocumento(request.getTipoDocumento());
        entity.setIdTipoDocumento(tipoDocumento);
        
        return entity;
    }
    
}
