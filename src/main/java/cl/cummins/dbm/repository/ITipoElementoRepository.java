package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.TipoElemento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoElementoRepository extends JpaRepository<TipoElemento, Long> {
}
