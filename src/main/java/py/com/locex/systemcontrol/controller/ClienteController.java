package py.com.locex.systemcontrol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import py.com.locex.systemcontrol.entity.Cliente;
import py.com.locex.systemcontrol.service.ClienteService;

@RestController
@RequestMapping("/contabilidad")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping(value="/clientes", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> buscarClientes(@RequestParam(value="ruc", required=false) String ruc){
		if(ruc == null)
			return clienteService.buscarClientes();
		return clienteService.buscarCliente(ruc);
	}
	
	@PostMapping(value="/clientes")
	public ResponseEntity<Object> crearCliente(@RequestBody Cliente cliente){
		return clienteService.crearCliente(cliente);
	}

	@PutMapping(value="/clientes")
	public ResponseEntity<Object> actualizarCliente(@RequestBody Cliente cliente){
		return clienteService.actualizarCliente(cliente);
	}

	@DeleteMapping(value="/clientes/{idCliente}")
	public ResponseEntity<Object> eliminarCliente(@PathVariable("idCliente") Long idCliente){
		return clienteService.eliminarCliente(idCliente);
	}


}
