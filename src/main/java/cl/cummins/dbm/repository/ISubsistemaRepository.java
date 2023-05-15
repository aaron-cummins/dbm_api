package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.Subsistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubsistemaRepository extends JpaRepository<Subsistema, Long> {
}
