package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.CategoriaSintoma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaSintomaRepository extends JpaRepository<CategoriaSintoma, Long> {
}
