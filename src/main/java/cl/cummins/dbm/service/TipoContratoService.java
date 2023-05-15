package cl.cummins.dbm.service;

import cl.cummins.dbm.model.TipoAdmision;
import cl.cummins.dbm.model.TipoContrato;
import cl.cummins.dbm.repository.ITipoAdmisionRepository;
import cl.cummins.dbm.repository.ITipoContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoContratoService implements ICRUDService<TipoContrato> {
    @Autowired
    private ITipoContratoRepository repo;

    @Override
    public List<TipoContrato> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<TipoContrato> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public TipoContrato create(TipoContrato model) {
        return repo.saveAndFlush(model);
    }

    @Override
    public TipoContrato update(TipoContrato model) {
        return repo.save(model);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
