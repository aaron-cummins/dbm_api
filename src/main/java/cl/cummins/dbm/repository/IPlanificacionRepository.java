package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.Planificacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface IPlanificacionRepository extends JpaRepository<Planificacion, Long> {

    Page<Planificacion> findAllByFecha(Date fecha, Pageable pageable);

    Page<Planificacion> findAllByFechaBetween(Date fechaini, Date fechafin, Pageable pageable);
}
