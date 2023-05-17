package cl.cummins.dbm.service;

import cl.cummins.dbm.model.IntervencionFechas;
import cl.cummins.dbm.repository.IIntervencionFechasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IntervencionFechasService implements ICRUDService<IntervencionFechas> {
    @Autowired
    private IIntervencionFechasRepository Repo;

    @Override
    public List<IntervencionFechas> findAll() {
        return Repo.findAll();
    }

    @Override
    public Optional<IntervencionFechas> findById(Long id) {
        return Repo.findById(id);
    }

    @Override
    public IntervencionFechas create(IntervencionFechas model) {
        return Repo.saveAndFlush(model);
    }

    @Override
    public IntervencionFechas update(IntervencionFechas model) {
        return Repo.save(model);
    }

    @Override
    public void delete(Long id) {
        Repo.deleteById(id);
    }
}
