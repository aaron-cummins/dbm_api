package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.Motor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMotorRepository extends JpaRepository<Motor, Long> {
}
