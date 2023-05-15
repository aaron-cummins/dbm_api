package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.TipoContrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoContratoRepository extends JpaRepository<TipoContrato, Long> {
}
