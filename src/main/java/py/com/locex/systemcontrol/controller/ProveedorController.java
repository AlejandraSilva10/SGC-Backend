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

import py.com.locex.systemcontrol.entity.Proveedor;
import py.com.locex.systemcontrol.service.ProveedorService;

@RestController
@RequestMapping("/contabilidad")
public class ProveedorController {
	
	@Autowired
	private ProveedorService proveedorService;	
	
	@GetMapping(value="/proveedores", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> listarProveedores(HttpServletRequest request){
		return proveedorService.listarProveedores();
	}
	
	@PostMapping(value="/proveedores")
	public ResponseEntity<Object> crearProveedor(@RequestBody Proveedor proveedor){
		return proveedorService.crearProveedor(proveedor);
	}
}
