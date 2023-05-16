package cl.cummins.dbm.repository;


import cl.cummins.dbm.model.LugarCreacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILugarCreacionRepository extends JpaRepository<LugarCreacion, Long> {
}
