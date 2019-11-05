package py.com.uds.sgc.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.com.uds.sgc.converter.VentaConverter;
import py.com.uds.sgc.entity.Cliente;
import py.com.uds.sgc.entity.Sucursal;
import py.com.uds.sgc.entity.Venta;
import py.com.uds.sgc.model.request.VentaRequest;
import py.com.uds.sgc.model.response.ContribuyenteResponse;
import py.com.uds.sgc.model.response.VentaReport;
import py.com.uds.sgc.model.response.VentaResponse;
import py.com.uds.sgc.repository.VentaRepository;

@Service
public class VentaService {
    
    @Autowired
    private VentaRepository ventaRepository;
    
    @Autowired
    private VentaConverter ventaConverter;
    
    @Autowired
    private ContribuyenteService contribuyenteService;
    
    @Autowired
    private ReportService reportService;
    
    String [] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};    
    
    public List<VentaResponse> getAll(){
        return ventaConverter.entitiesToModels(ventaRepository.findAll());
    }
    
    public List<VentaResponse> getByFilters(Integer idContribuyente, Date desde, Date hasta){
        if(desde == null || hasta == null){
            return getByContribuyente(idContribuyente);
        }
        else{
            return ventaConverter.entitiesToModels(ventaRepository.findByFields(idContribuyente, desde, hasta));
        }
    }    
    
    public List<VentaResponse> getByContribuyente(Integer id){
        return ventaConverter.entitiesToModels(ventaRepository.findByContribuyente(id));
    }
    
    public byte[] report(String reportType, Integer contribuyente, Date start, Date end) throws JRException{
        List<VentaResponse> compras = getByFilters(contribuyente, start, end);
        List<VentaReport> reportes = ventaConverter.toReports(compras);
        if(compras == null || compras.isEmpty()){ return null; }
        JRBeanCollectionDataSource comprasDS = new JRBeanCollectionDataSource(reportes);
        ContribuyenteResponse contribuyenteModel = contribuyenteService.getById(contribuyente);
        Map<String, Object> params = new HashMap<>();
        params.put("contribuyente", contribuyenteModel.getRazonSocial());
        params.put("ruc", contribuyenteModel.getRuc());
        params.put("fecha", today());
        params.put("mes", meses[new Date().getMonth()]);
        params.put("ventas", comprasDS);
        return reportService.generatePDF("ventas-report.jrxml", params, comprasDS);
    }    
    
    public String today(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date);
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
