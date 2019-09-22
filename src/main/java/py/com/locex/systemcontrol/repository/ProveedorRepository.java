package py.com.locex.systemcontrol.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import py.com.locex.systemcontrol.entity.Proveedor;

@Component
public interface ProveedorRepository extends CrudRepository<Proveedor, Long>{

	public List<Proveedor> findAll();

}
