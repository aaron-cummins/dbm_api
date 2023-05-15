package cl.cummins.dbm.service;

import cl.cummins.dbm.model.Criticidad;
import cl.cummins.dbm.repository.ICriticidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CriticidadService implements ICRUDService<Criticidad> {
    @Autowired
    private ICriticidadRepository repo;

    @Override
    public List<Criticidad> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Criticidad> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Criticidad create(Criticidad model) {
        return repo.saveAndFlush(model);
    }

    @Override
    public Criticidad update(Criticidad model) {
        return repo.save(model);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
