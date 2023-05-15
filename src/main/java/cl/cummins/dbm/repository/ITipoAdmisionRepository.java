package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.TipoAdmision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoAdmisionRepository extends JpaRepository<TipoAdmision, Long> {
}
