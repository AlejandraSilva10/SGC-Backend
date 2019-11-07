package py.com.uds.sgc.service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    
    public byte[] generatePDF(String type, String file, Map<String, Object> params, JRBeanCollectionDataSource datasource) throws JRException{
        InputStream comprasReportStream = getClass().getResourceAsStream("/reports/" + file);
        JasperReport jasperReport = JasperCompileManager.compileReport(comprasReportStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, datasource);
        if("pdf".equals(type)){
            return JasperExportManager.exportReportToPdf(jasperPrint);            
        }
        else{
            JRExporter exporter = new JRXlsExporter();
            exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
            exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
            exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
            exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            ByteArrayOutputStream  xlsReport = new ByteArrayOutputStream();
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, xlsReport);
            exporter.exportReport();
            return xlsReport.toByteArray();
        }
    }
    
}
