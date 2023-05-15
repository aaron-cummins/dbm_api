package cl.cummins.dbm.service;

import cl.cummins.dbm.model.Unidad;
import cl.cummins.dbm.repository.IUnidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadService implements ICRUDService<Unidad>{
    @Autowired
    private IUnidadRepository Repo;

    @Override
    public List<Unidad> findAll() {
        return Repo.findAll();
    }

    @Override
    public Optional<Unidad> findById(Long id) {
        return Repo.findById(id);
    }

    @Override
    public Unidad create(Unidad model) {
        return Repo.saveAndFlush(model);
    }

    @Override
    public Unidad update(Unidad model) {
        return Repo.save(model);
    }

    @Override
    public void delete(Long id) {
        Repo.deleteById(id);
    }
}
