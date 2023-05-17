package cl.cummins.dbm.service;

import cl.cummins.dbm.model.IntervencionDecisiones;
import cl.cummins.dbm.repository.IIntervencionDecisionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IntervencionDecisionesService implements ICRUDService<IntervencionDecisiones> {
    @Autowired
    private IIntervencionDecisionesRepository Repo;

    @Override
    public List<IntervencionDecisiones> findAll() {
        return Repo.findAll();
    }

    @Override
    public Optional<IntervencionDecisiones> findById(Long id) {
        return Repo.findById(id);
    }

    @Override
    public IntervencionDecisiones create(IntervencionDecisiones model) {
        return Repo.saveAndFlush(model);
    }

    @Override
    public IntervencionDecisiones update(IntervencionDecisiones model) {
        return Repo.save(model);
    }

    @Override
    public void delete(Long id) {
        Repo.deleteById(id);
    }
}
