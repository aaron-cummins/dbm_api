package cl.cummins.dbm.service;

import cl.cummins.dbm.model.Responsable;
import cl.cummins.dbm.repository.IResponsableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponsableService implements ICRUDService<Responsable> {
    @Autowired
    private IResponsableRepository Repo;

    @Override
    public List<Responsable> findAll() {
        return Repo.findAll();
    }

    @Override
    public Optional<Responsable> findById(Long id) {
        return Repo.findById(id);
    }

    @Override
    public Responsable create(Responsable model) {
        return Repo.saveAndFlush(model);
    }

    @Override
    public Responsable update(Responsable model) {
        return Repo.save(model);
    }

    @Override
    public void delete(Long id) {
        Repo.deleteById(id);
    }
}
