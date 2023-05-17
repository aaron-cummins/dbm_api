package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.IntervencionFluidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIntervencionFluidosRepository extends JpaRepository<IntervencionFluidos, Long> {
}
