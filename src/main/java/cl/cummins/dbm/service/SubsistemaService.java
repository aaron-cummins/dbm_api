package cl.cummins.dbm.service;

import cl.cummins.dbm.model.Sistema;
import cl.cummins.dbm.model.Subsistema;
import cl.cummins.dbm.repository.ISistemaRepository;
import cl.cummins.dbm.repository.ISubsistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubsistemaService implements ICRUDService<Subsistema>{
    @Autowired
    private ISubsistemaRepository Repo;

    @Override
    public List<Subsistema> findAll() {
        return Repo.findAll();
    }

    @Override
    public Optional<Subsistema> findById(Long id) {
        return Repo.findById(id);
    }

    @Override
    public Subsistema create(Subsistema model) {
        return Repo.saveAndFlush(model);
    }

    @Override
    public Subsistema update(Subsistema model) {
        return Repo.save(model);
    }

    @Override
    public void delete(Long id) {
        Repo.deleteById(id);
    }
}
