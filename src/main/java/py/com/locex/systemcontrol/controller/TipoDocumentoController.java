package py.com.locex.systemcontrol.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.com.locex.systemcontrol.entity.TipoDocumento;
import py.com.locex.systemcontrol.service.TipoDocumentoService;

@RestController
@RequestMapping("/contabilidad")
public class TipoDocumentoController {
	
	@Autowired
	private TipoDocumentoService tipoDocumentoService;
	
	@GetMapping(value="/documentos", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listarTipoDocumento(HttpServletRequest request){
		return tipoDocumentoService.listarTipoDocumento();
	}
	
	@PostMapping(value="/documentos")
	public ResponseEntity<?> crearTipoDocumento(@RequestBody TipoDocumento tipoDocumento){
		return tipoDocumentoService.crearTipoDocumento(tipoDocumento);
	}
}
