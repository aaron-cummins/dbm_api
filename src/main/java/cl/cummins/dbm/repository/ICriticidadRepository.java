package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.Criticidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICriticidadRepository extends JpaRepository<Criticidad, Long> {
}
