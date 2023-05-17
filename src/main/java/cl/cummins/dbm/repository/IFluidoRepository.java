package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.Fluido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFluidoRepository extends JpaRepository<Fluido, Long> {
}
