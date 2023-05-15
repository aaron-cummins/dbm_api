package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.EstadoEquipos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadoEquiposRepository extends JpaRepository<EstadoEquipos, Long> {
}
