package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.Estados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadosRepository extends JpaRepository<Estados, Long> {
}
