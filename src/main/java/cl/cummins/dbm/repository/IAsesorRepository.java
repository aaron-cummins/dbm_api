package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.Asesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAsesorRepository extends JpaRepository<Asesor, Long> {
}
