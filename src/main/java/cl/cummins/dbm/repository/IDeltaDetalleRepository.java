package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.DeltaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDeltaDetalleRepository extends JpaRepository<DeltaDetalle, Long> {
}
