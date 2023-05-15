package cl.cummins.dbm.service;

import cl.cummins.dbm.model.TipoSalida;
import cl.cummins.dbm.model.TipoTecnico;
import cl.cummins.dbm.repository.ITipoSalidaRepository;
import cl.cummins.dbm.repository.ITipoTecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoTecnicoService implements ICRUDService<TipoTecnico> {
    @Autowired
    private ITipoTecnicoRepository repo;

    @Override
    public List<TipoTecnico> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<TipoTecnico> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public TipoTecnico create(TipoTecnico model) {
        return repo.saveAndFlush(model);
    }

    @Override
    public TipoTecnico update(TipoTecnico model) {
        return repo.save(model);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
