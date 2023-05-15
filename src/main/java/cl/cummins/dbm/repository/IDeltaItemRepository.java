package cl.cummins.dbm.repository;

import cl.cummins.dbm.model.DeltaItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDeltaItemRepository extends JpaRepository<DeltaItem, Long> {
}
