package cl.cummins.dbm.service;

import cl.cummins.dbm.model.DeltaItem;
import cl.cummins.dbm.repository.IDeltaItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeltaItemService implements ICRUDService<DeltaItem> {
    @Autowired
    private IDeltaItemRepository repo;

    @Override
    public List<DeltaItem> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<DeltaItem> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public DeltaItem create(DeltaItem model) {
        return repo.saveAndFlush(model);
    }

    @Override
    public DeltaItem update(DeltaItem model) {
        return repo.save(model);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
