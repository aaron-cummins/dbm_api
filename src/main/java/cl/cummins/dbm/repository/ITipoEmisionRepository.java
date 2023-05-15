package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.TipoEmision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoEmisionRepository extends JpaRepository<TipoEmision, Long> {
}
