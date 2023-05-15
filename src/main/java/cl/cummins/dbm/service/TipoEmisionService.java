package cl.cummins.dbm.service;


import cl.cummins.dbm.model.TipoEmision;
import cl.cummins.dbm.repository.ITipoEmisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoEmisionService implements ICRUDService<TipoEmision> {
    @Autowired
    private ITipoEmisionRepository repo;

    @Override
    public List<TipoEmision> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<TipoEmision> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public TipoEmision create(TipoEmision model) {
        return repo.saveAndFlush(model);
    }

    @Override
    public TipoEmision update(TipoEmision model) {
        return repo.save(model);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
