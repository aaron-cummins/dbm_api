package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.DeltaResponsable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDeltaResponsableRepository extends JpaRepository<DeltaResponsable, Long> {
}
