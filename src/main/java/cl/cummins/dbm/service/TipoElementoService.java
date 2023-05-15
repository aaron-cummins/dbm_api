package cl.cummins.dbm.service;

import cl.cummins.dbm.model.TipoElemento;
import cl.cummins.dbm.repository.ITipoElementoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoElementoService implements ICRUDService<TipoElemento> {
    @Autowired
    private ITipoElementoRepository repo;

    @Override
    public List<TipoElemento> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<TipoElemento> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public TipoElemento create(TipoElemento model) {
        return repo.saveAndFlush(model);
    }

    @Override
    public TipoElemento update(TipoElemento model) {
        return repo.save(model);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
