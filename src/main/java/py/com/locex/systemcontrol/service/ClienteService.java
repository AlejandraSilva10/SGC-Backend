package py.com.locex.systemcontrol.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.swagger.models.Response;
import py.com.locex.systemcontrol.entity.Cliente;
import py.com.locex.systemcontrol.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	private Logger LOGGER = Logger.getLogger(ClienteService.class);

	public ResponseEntity<Object> buscarClientes() {
		try {
			List<Cliente> clientes = new ArrayList<>();
			clientes = clienteRepository.findAll();
			if (clientes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(clientes, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> buscarCliente(String ruc) {
		try {
			Cliente cliente = clienteRepository.findClienteByRuc(ruc);
			if (cliente == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(cliente, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error(e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> crearCliente(Cliente cliente) {
		try {
			clienteRepository.save(cliente);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			LOGGER.error(e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> actualizarCliente(Cliente cliente) {
		try {
			Optional<Cliente> clienteActualizar = clienteRepository.findById(cliente.getId());
			Cliente clienteObj = clienteActualizar.get();
			clienteObj = cliente;
			clienteRepository.save(clienteObj);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e){
			LOGGER.error(e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Object> eliminarCliente(Long idCliente){
		try{
			Optional<Cliente> clienteEliminar = clienteRepository.findById(idCliente);
			clienteRepository.delete(clienteEliminar.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e){
			LOGGER.error(e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
