package py.com.uds.sgc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import py.com.uds.sgc.entity.PeriodoFiscal;
import py.com.uds.sgc.entity.PeriodoFiscalPK;

@Repository
public interface PeriodoFiscalRepository extends JpaRepository<PeriodoFiscal, PeriodoFiscalPK> {}
