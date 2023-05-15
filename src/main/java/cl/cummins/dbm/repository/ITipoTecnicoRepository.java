package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.TipoTecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoTecnicoRepository extends JpaRepository<TipoTecnico, Long> {
}
