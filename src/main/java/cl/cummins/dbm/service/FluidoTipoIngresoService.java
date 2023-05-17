package cl.cummins.dbm.service;

import cl.cummins.dbm.model.FluidoTipoIngreso;
import cl.cummins.dbm.repository.IFluidoTipoIngresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FluidoTipoIngresoService implements ICRUDService<FluidoTipoIngreso>{
    @Autowired
    private IFluidoTipoIngresoRepository Repo;

    @Override
    public List<FluidoTipoIngreso> findAll() {
        return Repo.findAll();
    }

    @Override
    public Optional<FluidoTipoIngreso> findById(Long id) {
        return Repo.findById(id);
    }

    @Override
    public FluidoTipoIngreso create(FluidoTipoIngreso model) {
        return Repo.saveAndFlush(model);
    }

    @Override
    public FluidoTipoIngreso update(FluidoTipoIngreso model) {
        return Repo.save(model);
    }

    @Override
    public void delete(Long id) {
        Repo.deleteById(id);
    }
}
