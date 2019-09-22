package py.com.locex.systemcontrol.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import py.com.locex.systemcontrol.entity.TipoDocumento;

@Component
public interface TipoDocumentoRepository extends CrudRepository<TipoDocumento, Long>{
	
	List<TipoDocumento> findAll();	

}
