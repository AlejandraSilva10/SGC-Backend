package py.com.locex.systemcontrol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import py.com.locex.systemcontrol.entity.Comprobante;
import py.com.locex.systemcontrol.service.ComprobanteService;

@RestController
@RequestMapping("/contabilidad")
public class ComprobanteController {
		
	@Autowired
	private ComprobanteService comprobanteService;

	@GetMapping(value="/comprobantes", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listarComprobantes(@RequestParam(value="id_cliente", required=false) Long idCliente){
		if(idCliente == null)
			return comprobanteService.listarComprobantes();
		return comprobanteService.listarComprobantesDeCliente(idCliente);
	}
	
	@DeleteMapping(value="/comprobantes/{id}")
	public ResponseEntity<Object> eliminarComprobante(@PathVariable("id") Long id){
		return comprobanteService.eliminarComprobante(id);
	}
	
	@PostMapping(value="/comprobantes")
	public ResponseEntity<Object> crearComponent(@RequestBody Comprobante comprobante){
		return comprobanteService.crearComprobante(comprobante);
	}
	
}
