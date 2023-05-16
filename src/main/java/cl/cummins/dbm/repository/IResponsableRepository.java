package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.Responsable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IResponsableRepository extends JpaRepository<Responsable, Long> {
}
