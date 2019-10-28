package py.com.uds.sgc.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import py.com.uds.sgc.entity.Contribuyente;

@Repository
public interface ContribuyenteRepository extends JpaRepository<Contribuyente, Integer> {

    @Query("SELECT C FROM Contribuyente C WHERE C.idContribuyente = :id")
    @Override
    public Optional<Contribuyente> findById(@Param("id") Integer id);
    
}
