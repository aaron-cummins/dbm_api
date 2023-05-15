package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.FaenaFlota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFaenaFlotaRepository extends JpaRepository<FaenaFlota, Long> {
}
