package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u WHERE u.correo_electronico = :correo")
    Optional<Usuario> getCorreo(@Param("correo") String correo);

    Optional<Usuario> getByUsuarioAndPin(String usuario, String pin);

    Optional<Usuario> getByUsuario(Integer usuario);

}
