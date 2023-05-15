package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.SintomaCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISintomaCategoriaRepository extends JpaRepository<SintomaCategoria, Long> {
}
