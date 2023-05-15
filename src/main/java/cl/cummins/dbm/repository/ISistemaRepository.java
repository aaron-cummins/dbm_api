package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.Sistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISistemaRepository extends JpaRepository<Sistema, Long> {
}
