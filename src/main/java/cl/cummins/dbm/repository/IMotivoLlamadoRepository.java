package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.MotivoLlamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMotivoLlamadoRepository extends JpaRepository<MotivoLlamado, Long> {
}
