package cl.cummins.dbm.service;

import cl.cummins.dbm.model.TipoAdmision;
import cl.cummins.dbm.repository.ITipoAdmisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoAdmisionService implements ICRUDService<TipoAdmision> {
    @Autowired
    private ITipoAdmisionRepository repo;

    @Override
    public List<TipoAdmision> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<TipoAdmision> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public TipoAdmision create(TipoAdmision model) {
        return repo.saveAndFlush(model);
    }

    @Override
    public TipoAdmision update(TipoAdmision model) {
        return repo.save(model);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
