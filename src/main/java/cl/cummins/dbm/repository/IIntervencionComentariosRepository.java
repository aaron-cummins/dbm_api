package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.IntervencionComentarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIntervencionComentariosRepository extends JpaRepository<IntervencionComentarios, Long> {
}
