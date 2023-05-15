package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.FaenaZona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFaenaZonaRepository extends JpaRepository<FaenaZona, Long> {
}
