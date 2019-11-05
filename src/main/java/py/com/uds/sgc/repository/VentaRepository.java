package py.com.uds.sgc.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import py.com.uds.sgc.entity.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {

    @Query("SELECT V FROM Venta V WHERE V.idContribuyente.idContribuyente = :id")
    public List<Venta> findByContribuyente(@Param("id") Integer id);
    
    @Query("SELECT V FROM Venta V WHERE V.idContribuyente.idContribuyente = :id and V.fecha BETWEEN :start and :end")
    public List<Venta> findByFields(@Param("id") Integer id, @Param("start") Date start, @Param("end") Date end);
    
    @Override
    @Query("SELECT V FROM Venta V WHERE V.idVenta = :id")
    public Optional<Venta> findById(@Param("id") Integer id);
    
    @Modifying
    @Query("DELETE FROM Venta V WHERE V.idVenta = :id")
    public void delete(@Param("id") Integer id);
    
}