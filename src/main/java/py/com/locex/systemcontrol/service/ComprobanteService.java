package py.com.locex.systemcontrol.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import py.com.locex.systemcontrol.entity.Comprobante;
import py.com.locex.systemcontrol.repository.ComprobanteRepository;

@Service
public class ComprobanteService {
	
	@Autowired
	private ComprobanteRepository comprobanteRepository;
	
	private Logger LOGGER = Logger.getLogger(ComprobanteService.class);
	
	public ResponseEntity<Object> listarComprobantes(){
		try {
			List<Comprobante> comprobantes = new ArrayList<>();
			comprobantes = comprobanteRepository.findAll();
			if(comprobantes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(comprobantes, HttpStatus.OK);
		}
		catch(Exception e) {
			LOGGER.error(e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	public ResponseEntity<Object> listarComprobantesDeCliente(Long idCliente){
		try {
			List<Comprobante> comprobantes = new ArrayList<>();
			comprobantes = comprobanteRepository.findByClienteId(idCliente);
			if(comprobantes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(comprobantes, HttpStatus.OK);
		}
		catch(Exception e) {
			LOGGER.error(e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	public ResponseEntity<Object> eliminarComprobante(Long id){
		try {
			if(id == null)
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			comprobanteRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			LOGGER.error(e);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<Object> crearComprobante(Comprobante comprobante){
		try {
			comprobanteRepository.save(comprobante);
			return new ResponseEntity<>(HttpStatus.CREATED);			
		}
		catch(Exception e) {
			LOGGER.error(e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
