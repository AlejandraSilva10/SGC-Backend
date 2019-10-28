package py.com.uds.sgc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import py.com.uds.sgc.entity.PlanCuenta;

@Repository
public interface PlanCuentaRepository extends JpaRepository<PlanCuenta, Integer> {}
