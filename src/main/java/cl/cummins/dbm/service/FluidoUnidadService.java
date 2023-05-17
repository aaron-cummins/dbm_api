package cl.cummins.dbm.service;

import cl.cummins.dbm.model.FluidoUnidad;
import cl.cummins.dbm.repository.IFluidoUnidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FluidoUnidadService implements ICRUDService<FluidoUnidad>{
    @Autowired
    private IFluidoUnidadRepository Repo;

    @Override
    public List<FluidoUnidad> findAll() {
        return Repo.findAll();
    }

    @Override
    public Optional<FluidoUnidad> findById(Long id) {
        return Repo.findById(id);
    }

    @Override
    public FluidoUnidad create(FluidoUnidad model) {
        return Repo.saveAndFlush(model);
    }

    @Override
    public FluidoUnidad update(FluidoUnidad model) {
        return Repo.save(model);
    }

    @Override
    public void delete(Long id) {
        Repo.deleteById(id);
    }
}
