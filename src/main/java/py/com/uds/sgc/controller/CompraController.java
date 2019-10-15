/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.uds.sgc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import py.com.uds.sgc.entity.Compra;
import py.com.uds.sgc.service.CompraService;

/**
 *
 * @author gino_junchaya
 */

@CrossOrigin("*")
@RestController
@RequestMapping("/compras")
public class CompraController {
    
    @Autowired
    private CompraService compraService;

    @GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() {
        try {
            List<Compra> compras = compraService.getAll();
            if (compras == null || compras.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(compras, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
//    @GetMapping(value="/filtered", produces=MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> getByFields(
//        @RequestParam(value="nombres", required=false) String nombres,
//        @RequestParam(value="apellidos", required=false) String apellidos,
//        @RequestParam(value="ciudad", required=false) Integer ciudad){
//        try {
//            List<ClienteResponse> clientes = clienteService.getAllFiltered(nombres,
//                apellidos, ciudad);
//            if (clientes == null || clientes.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(clientes, HttpStatus.OK);
//        } catch (Exception ex) {
//            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
//        }        
//    }
    
    @GetMapping(value="/{id_compra}", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable("id_compra") Integer idCompra) {
        try {
            Compra compra = compraService.getById(idCompra);
            if (compra == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(compra, HttpStatus.OK);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody Compra request){
        try {
            Compra compra = compraService.save(request);
            if (compra == null) {
                return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
            }
            return new ResponseEntity<>(compra, HttpStatus.CREATED);
        }
        catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
//    @DeleteMapping(value="/{id_cliente}", produces=MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> delete(@PathVariable("id_cliente") Integer idCliente){
//        try{
//            clienteService.delete(idCliente);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        catch(Exception ex){
//            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
    
}