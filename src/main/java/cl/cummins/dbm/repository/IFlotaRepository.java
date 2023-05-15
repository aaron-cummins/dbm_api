package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.Flota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFlotaRepository extends JpaRepository<Flota, Long> {
}
