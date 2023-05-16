package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.Periodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPeriodoRepository extends JpaRepository<Periodo, Long> {
}
