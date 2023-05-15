package cl.cummins.dbm.service;

import cl.cummins.dbm.model.EstadoEquipos;
import cl.cummins.dbm.repository.IEstadoEquiposRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoEuiposService implements ICRUDService<EstadoEquipos> {
    @Autowired
    private IEstadoEquiposRepository Repo;

    @Override
    public List<EstadoEquipos> findAll() {
        return Repo.findAll();
    }

    @Override
    public Optional<EstadoEquipos> findById(Long id) {
        return Repo.findById(id);
    }

    @Override
    public EstadoEquipos create(EstadoEquipos model) {
        return Repo.saveAndFlush(model);
    }

    @Override
    public EstadoEquipos update(EstadoEquipos model) {
        return Repo.save(model);
    }

    @Override
    public void delete(Long id) {
        Repo.deleteById(id);
    }
}
