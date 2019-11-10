package py.com.uds.sgc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import py.com.uds.sgc.entity.Usuarios;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Integer> {

    @Query("SELECT U FROM Usuarios U WHERE U.username = :username")
    public Usuarios findByUsername(@Param("username") String username);

}
