package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.LugarReparacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILugarReparacionRepository extends JpaRepository<LugarReparacion, Long> {
}
