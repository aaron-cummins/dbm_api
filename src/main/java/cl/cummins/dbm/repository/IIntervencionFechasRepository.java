package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.IntervencionFechas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIntervencionFechasRepository extends JpaRepository<IntervencionFechas, Long> {
}
