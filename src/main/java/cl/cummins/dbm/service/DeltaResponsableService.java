package cl.cummins.dbm.service;

import cl.cummins.dbm.model.DeltaResponsable;
import cl.cummins.dbm.repository.IDeltaResponsableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeltaResponsableService implements ICRUDService<DeltaResponsable> {
    @Autowired
    private IDeltaResponsableRepository repo;

    @Override
    public List<DeltaResponsable> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<DeltaResponsable> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public DeltaResponsable create(DeltaResponsable model) {
        return repo.saveAndFlush(model);
    }

    @Override
    public DeltaResponsable update(DeltaResponsable model) {
        return repo.save(model);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
