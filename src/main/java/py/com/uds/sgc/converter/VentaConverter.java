package py.com.uds.sgc.converter;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import py.com.uds.sgc.entity.Cliente;
import py.com.uds.sgc.entity.Contribuyente;
import py.com.uds.sgc.entity.Sucursal;
import py.com.uds.sgc.entity.TipoDocumento;
import py.com.uds.sgc.entity.Venta;
import py.com.uds.sgc.model.request.VentaRequest;
import py.com.uds.sgc.model.response.CompraReport;
import py.com.uds.sgc.model.response.CompraResponse;
import py.com.uds.sgc.model.response.VentaReport;
import py.com.uds.sgc.model.response.VentaResponse;
import py.com.uds.sgc.service.TipoDocumentoService;

@Component
public class VentaConverter {
    
    @Autowired
    private ClienteConverter clienteConverter;
    
    @Autowired
    private SucursalConverter sucursalConverter;
    
    @Autowired
    private TipoDocumentoConverter tipoDocumentoConverter;
    
    @Autowired
    private TipoDocumentoService tipoDocumentoService;
    
    public VentaReport toReport(VentaResponse model){
        VentaReport report = new VentaReport();
        report.setExentas(model.getExentas());
        report.setFecha(model.getFecha());
        report.setImporteTotal(model.getImporteTotal());
        report.setIva10(model.getIva10());
        report.setIva5(model.getIva5());
        report.setNroComprobante(model.getNroComprobante());
        report.setCliente(model.getCliente().getRazonSocial());
        report.setClienteRuc(model.getCliente().getRuc());
        report.setSucursal(model.getSucursal().getDescripcion());
        report.setTipoDocumento(model.getTipoDocumento().getDescripcion());
        return report;
    }
    
    public List<VentaReport> toReports(List<VentaResponse> entities){
        List<VentaReport> models = new ArrayList<>();
        if(entities == null || entities.isEmpty()){ return models; }
        entities.forEach((entity) -> { models.add(this.toReport(entity)); });
        return models;
    }    
    
    public VentaResponse entityToModel(Venta entity){
        if(entity == null){ return null; }
        VentaResponse model = new VentaResponse();
        model.setConcepto(entity.getConcepto());
        model.setExentas(entity.getExentas());
        model.setFecha(entity.getFecha());
        model.setId(entity.getIdVenta());
        TipoDocumento tipoDocumento = tipoDocumentoService.getById(entity.getIdTipoDocumento());
        model.setTipoDocumento(tipoDocumentoConverter.entityToModel(tipoDocumento));
        model.setImporteTotal(entity.getImporteTotal());
        model.setIva10(entity.getIva10());
        model.setIva5(entity.getIva5());
        model.setNroComprobante(entity.getNroComprobante());
        model.setNroTimbrado(entity.getNroTimbrado());
        model.setCliente(clienteConverter.entityToModel(entity.getIdCliente()));
        model.setSucursal(sucursalConverter.entityToModel(entity.getIdSucursal()));
        return model;
    }
    
    public List<VentaResponse> entitiesToModels(List<Venta> entities){
        List<VentaResponse> models = new ArrayList<>();
        if(entities == null || entities.isEmpty()){
            return models;
        }
        entities.forEach((entity) -> { models.add(this.entityToModel(entity)); });
        return models;
    }
    
    public Venta modelToEntity(VentaRequest request){
        Venta entity = new Venta();
        entity.setConcepto(request.getConcepto());
        entity.setExentas(request.getExentas());
        entity.setFecha(request.getFecha());
        entity.setIdTipoDocumento(request.getIdTipoDocumento());
        entity.setIdVenta(request.getId());
        entity.setImporteTotal(request.getImporteTotal());
        entity.setIva10(request.getIva10());
        entity.setIva5(request.getIva5());
        entity.setNroComprobante(request.getNroComprobante());
        entity.setNroTimbrado(request.getNroTimbrado());
        Contribuyente contribuyente = new Contribuyente();
        contribuyente.setIdContribuyente(request.getIdContribuyente());
        Sucursal sucursal = new Sucursal();
        sucursal.setIdSucursal(request.getIdSucursal());
        sucursal.setIdContribuyente(contribuyente);
        entity.setIdSucursal(sucursal);
        entity.setIdContribuyente(contribuyente);
        Cliente cliente = new Cliente();
        cliente.setIdCliente(request.getIdCliente());
        entity.setIdCliente(cliente);
        return entity;
    }
    
}
