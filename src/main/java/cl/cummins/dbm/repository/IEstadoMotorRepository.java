package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.EstadoMotor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadoMotorRepository extends JpaRepository<EstadoMotor, Long> {
}
