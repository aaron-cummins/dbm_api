package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.FaenaZonaNumerica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFaenaZonaNumericaRepository extends JpaRepository<FaenaZonaNumerica, Long> {
}
