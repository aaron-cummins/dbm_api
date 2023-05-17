package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.IntervencionDecisiones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIntervencionDecisionesRepository extends JpaRepository<IntervencionDecisiones, Long> {
}
