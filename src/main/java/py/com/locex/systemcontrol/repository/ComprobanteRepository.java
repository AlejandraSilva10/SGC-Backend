package py.com.locex.systemcontrol.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import py.com.locex.systemcontrol.entity.Comprobante;

@Component
public interface ComprobanteRepository extends CrudRepository<Comprobante, Long>{
	
	public List<Comprobante> findAll();
	
	public List<Comprobante> findByClienteId(Long id);
}
