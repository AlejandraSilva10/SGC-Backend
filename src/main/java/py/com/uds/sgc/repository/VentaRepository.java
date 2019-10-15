/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.uds.sgc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import py.com.uds.sgc.entity.Venta;

/**
 *
 * @author gino_junchaya
 */

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {}