package py.com.uds.sgc.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import py.com.uds.sgc.entity.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {

    @Query("SELECT C FROM Compra C WHERE C.idContribuyente.idContribuyente = :id")
    public List<Compra> findByContribuyente(@Param("id") Integer id);    
    
    @Query("SELECT C FROM Compra C WHERE C.idContribuyente.idContribuyente = :id and C.fecha BETWEEN :start and :end")
    public List<Compra> findByFields(@Param("id") Integer id, @Param("start") Date start, @Param("end") Date end);
    
    @Override
    @Query("SELECT C FROM Compra C WHERE C.idCompra = :id")
    public Optional<Compra> findById(@Param("id") Integer id);
    
    
    @Modifying
    @Query("DELETE FROM Compra C WHERE C.idCompra = :id")
    public void delete(@Param("id") Integer id);

}
