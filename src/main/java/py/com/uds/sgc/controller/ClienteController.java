package py.com.uds.sgc.controller;

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
import org.springframework.web.bind.annotation.RestController;
import py.com.uds.sgc.entity.Cliente;
import py.com.uds.sgc.service.ClienteService;

@CrossOrigin("*")
@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() {
        try {
            List<Cliente> clientes = clienteService.getAll();
            if (clientes == null || clientes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping(value="/{id_cliente}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable("id_cliente") Integer idCliente) {
        try {
            Cliente cliente = clienteService.getById(idCliente);
            if (cliente == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody Cliente request){
        try {
            Cliente cliente = clienteService.save(request);
            if (cliente == null) {
                return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
            }
            return new ResponseEntity<>(cliente, HttpStatus.CREATED);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody Cliente request){
        try {
            Cliente cliente = clienteService.update(request);
            if (cliente == null) {
                return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
            }
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }    
    
    @DeleteMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        try{
            clienteService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
