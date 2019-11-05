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
import py.com.uds.sgc.converter.CompraConverter;
import py.com.uds.sgc.entity.Compra;
import py.com.uds.sgc.entity.Proveedor;
import py.com.uds.sgc.entity.Sucursal;
import py.com.uds.sgc.model.request.CompraRequest;
import py.com.uds.sgc.model.response.CompraReport;
import py.com.uds.sgc.model.response.CompraResponse;
import py.com.uds.sgc.model.response.ContribuyenteResponse;
import py.com.uds.sgc.repository.CompraRepository;

@Service
public class CompraService {
    
    @Autowired
    private CompraRepository compraRepository;
    
    @Autowired
    private CompraConverter compraConverter;
    
    @Autowired
    private ContribuyenteService contribuyenteService;
    
    @Autowired
    private ReportService reportService;
    
    String [] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    
    public List<CompraResponse> getAll(){
        return compraConverter.entitiesToModels(compraRepository.findAll());
    }
    
    public List<CompraResponse> getByContribuyente(Integer id){
        return compraConverter.entitiesToModels(compraRepository.findByContribuyente(id));
    }
    
    public List<CompraResponse> getByFilters(Integer idContribuyente, Date desde, Date hasta){
        if(desde == null || hasta == null){
            return getByContribuyente(idContribuyente);
        }
        else{
            return compraConverter.entitiesToModels(compraRepository.findByFields(idContribuyente, desde, hasta));
        }
    }
    
    public byte[] report(String reportType, Integer contribuyente, Date desde, Date hasta) throws JRException{
        List<CompraResponse> compras = getByFilters(contribuyente, desde, hasta);
        List<CompraReport> reportes = compraConverter.toReports(compras);
        if(compras == null || compras.isEmpty()){ return null; }
        JRBeanCollectionDataSource comprasDS = new JRBeanCollectionDataSource(reportes);
        ContribuyenteResponse contribuyenteModel = contribuyenteService.getById(contribuyente);
        Map<String, Object> params = new HashMap<>();
        params.put("contribuyente", contribuyenteModel.getRazonSocial());
        params.put("ruc", contribuyenteModel.getRuc());
        params.put("fecha", today());
        params.put("mes", meses[new Date().getMonth()]);
        params.put("compras", comprasDS);
        return reportService.generatePDF("compras-report.jrxml", params, comprasDS);
    }
    
    public String today(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date);
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
