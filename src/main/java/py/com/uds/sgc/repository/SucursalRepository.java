package py.com.uds.sgc.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import py.com.uds.sgc.entity.Sucursal;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {

    @Query("SELECT S FROM Sucursal S WHERE S.idContribuyente.idContribuyente = :id")
    public List<Sucursal> findByContribuyente(@Param("id") Integer contribuyente);
    
}