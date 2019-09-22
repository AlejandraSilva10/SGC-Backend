package py.com.locex.systemcontrol.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import py.com.locex.systemcontrol.entity.Cliente;

@Component
public interface ClienteRepository extends CrudRepository<Cliente, Long>{
	
	public List<Cliente> findAll();
	
	public Cliente findClienteByRuc(String ruc);
}
