package cl.cummins.dbm.service;

import cl.cummins.dbm.model.TipoSalida;
import cl.cummins.dbm.repository.ITipoSalidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoSalidaService implements ICRUDService<TipoSalida> {
    @Autowired
    private ITipoSalidaRepository repo;

    @Override
    public List<TipoSalida> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<TipoSalida> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public TipoSalida create(TipoSalida model) {
        return repo.saveAndFlush(model);
    }

    @Override
    public TipoSalida update(TipoSalida model) {
        return repo.save(model);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
