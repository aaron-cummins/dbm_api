package cl.cummins.dbm.service;

import cl.cummins.dbm.model.Fluido;
import cl.cummins.dbm.repository.IFluidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FluidoService implements ICRUDService<Fluido>{
    @Autowired
    private IFluidoRepository Repo;

    @Override
    public List<Fluido> findAll() {
        return Repo.findAll();
    }

    @Override
    public Optional<Fluido> findById(Long id) {
        return Repo.findById(id);
    }

    @Override
    public Fluido create(Fluido model) {
        return Repo.saveAndFlush(model);
    }

    @Override
    public Fluido update(Fluido model) {
        return Repo.save(model);
    }

    @Override
    public void delete(Long id) {
        Repo.deleteById(id);
    }
}
