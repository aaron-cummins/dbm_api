package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.TipoSalida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoSalidaRepository extends JpaRepository<TipoSalida, Long> {
}
