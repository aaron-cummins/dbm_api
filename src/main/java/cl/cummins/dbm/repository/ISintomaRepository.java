package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.Sintoma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISintomaRepository extends JpaRepository<Sintoma, Long> {
}
