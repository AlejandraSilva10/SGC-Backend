package py.com.uds.sgc.service;

import java.io.InputStream;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    
    public byte[] generatePDF(String file, Map<String, Object> params, JRBeanCollectionDataSource datasource) throws JRException{
        InputStream comprasReportStream = getClass().getResourceAsStream("/reports/" + file);
        JasperReport jasperReport = JasperCompileManager.compileReport(comprasReportStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, datasource);
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
    
}
