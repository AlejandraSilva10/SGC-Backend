package py.com.locex.systemcontrol.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import py.com.locex.systemcontrol.entity.TipoDocumento;
import py.com.locex.systemcontrol.repository.TipoDocumentoRepository;

@Service
public class TipoDocumentoService {

	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;
	
	private Logger LOGGER = Logger.getLogger(TipoDocumentoService.class);

	public ResponseEntity<?> crearTipoDocumento(TipoDocumento tipoDocumento){
		try {
			tipoDocumentoRepository.save(tipoDocumento);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		catch(Exception e) {
			LOGGER.error(e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<Object> listarTipoDocumento(){
		try {
			List<TipoDocumento> tipoDocumento = new ArrayList<>();
			tipoDocumento = tipoDocumentoRepository.findAll();
			if(tipoDocumento.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);				
			}
			return new ResponseEntity<>(tipoDocumento, HttpStatus.OK);
		}
		catch(Exception e) {
			LOGGER.error(e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
