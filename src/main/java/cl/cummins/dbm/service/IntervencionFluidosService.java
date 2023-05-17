package cl.cummins.dbm.service;

import cl.cummins.dbm.model.IntervencionFluidos;
import cl.cummins.dbm.repository.IIntervencionFluidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IntervencionFluidosService implements ICRUDService<IntervencionFluidos> {
    @Autowired
    private IIntervencionFluidosRepository Repo;

    @Override
    public List<IntervencionFluidos> findAll() {
        return Repo.findAll();
    }

    @Override
    public Optional<IntervencionFluidos> findById(Long id) {
        return Repo.findById(id);
    }

    @Override
    public IntervencionFluidos create(IntervencionFluidos model) {
        return Repo.saveAndFlush(model);
    }

    @Override
    public IntervencionFluidos update(IntervencionFluidos model) {
        return Repo.save(model);
    }

    @Override
    public void delete(Long id) {
        Repo.deleteById(id);
    }
}
