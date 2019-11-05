package py.com.uds.sgc.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import py.com.uds.sgc.model.request.VentaRequest;
import py.com.uds.sgc.model.response.VentaResponse;
import py.com.uds.sgc.service.VentaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService service;

    @GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() {
        try {
            List<VentaResponse> models = service.getAll();
            if (models == null || models.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(models, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }   
    
    @GetMapping(value="/filtered", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByFields(
        @RequestParam(value="contribuyente", required=true) Integer contribuyente){
        try {
            List<VentaResponse> models = service.getByContribuyente(contribuyente);
            if (models == null || models.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(models, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }        
    }
    
   @GetMapping(value="/report", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> report(
        @RequestParam(value="type", required=true) String reportType,            
        @RequestParam(value="contribuyente", required=true) Integer contribuyente,
        @RequestParam(value="desde", required=false) Date desde,
        @RequestParam(value="hasta", required=false) Date hasta){
        try {
            byte[] report = service.report(reportType, contribuyente, desde, hasta);
            if(report == null){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return ResponseEntity.ok().header("Content-Type", "application/pdf; charset=UTF-8")
            .header("Content-Disposition", "inline; filename=\"" + System.currentTimeMillis() + ".pdf\"")
            .body(report);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }      
    
    @PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody VentaRequest request){
        try {
            VentaResponse model = service.save(request);
            if (model == null) {
                return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
            }
            return new ResponseEntity<>(model, HttpStatus.CREATED);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody VentaRequest request){
        try {
            VentaResponse entity = service.update(request);
            if (entity == null) {
                return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
            }
            return new ResponseEntity<>(entity, HttpStatus.OK);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }  
    
    @DeleteMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        try{
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
