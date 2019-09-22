package py.com.locex.systemcontrol.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import py.com.locex.systemcontrol.entity.Proveedor;
import py.com.locex.systemcontrol.repository.ProveedorRepository;

@Service
public class ProveedorService {
	
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	private Logger LOGGER = Logger.getLogger(ProveedorService.class);
	
	public ResponseEntity<Object> listarProveedores(){
		try {
			List<Proveedor> proveedores = new ArrayList<>();
			proveedores = proveedorRepository.findAll();
			if(proveedores.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);				
			}
			return new ResponseEntity<>(proveedores, HttpStatus.OK);
		}
		catch(Exception e) {
			LOGGER.error(e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	public ResponseEntity<Object> crearProveedor(Proveedor proveedor){
		try {
			proveedorRepository.save(proveedor);
			return new ResponseEntity<>(proveedor.getId(), HttpStatus.CREATED);
		}
		catch(Exception e) {
			LOGGER.error(e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}

}
