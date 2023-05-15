package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUnidadRepository extends JpaRepository<Unidad, Long> {
}
