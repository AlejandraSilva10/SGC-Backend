package py.com.uds.sgc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import py.com.uds.sgc.entity.Rubro;

@Repository
public interface RubroRepository extends JpaRepository<Rubro, Integer> {}