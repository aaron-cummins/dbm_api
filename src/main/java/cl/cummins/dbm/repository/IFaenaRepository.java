package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.Faena;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFaenaRepository extends JpaRepository<Faena, Long> {
}
