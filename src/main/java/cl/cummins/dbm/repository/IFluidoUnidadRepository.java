package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.FluidoUnidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFluidoUnidadRepository extends JpaRepository<FluidoUnidad, Long> {
}
