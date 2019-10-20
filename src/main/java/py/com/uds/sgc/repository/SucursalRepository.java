/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.uds.sgc.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import py.com.uds.sgc.entity.Sucursal;

/**
 *
 * @author gino_junchaya
 */

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {

    
    @Query("SELECT S FROM Sucursal S WHERE S.idContribuyente.idContribuyente = :id")
    public List<Sucursal> findByContribuyente(@Param("id") Integer contribuyente);
    
}