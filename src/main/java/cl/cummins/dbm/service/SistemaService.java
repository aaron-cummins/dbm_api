package cl.cummins.dbm.service;

import cl.cummins.dbm.model.Sintoma;
import cl.cummins.dbm.model.Sistema;
import cl.cummins.dbm.repository.ISintomaRepository;
import cl.cummins.dbm.repository.ISistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SistemaService implements ICRUDService<Sistema>{
    @Autowired
    private ISistemaRepository Repo;

    @Override
    public List<Sistema> findAll() {
        return Repo.findAll();
    }

    @Override
    public Optional<Sistema> findById(Long id) {
        return Repo.findById(id);
    }

    @Override
    public Sistema create(Sistema model) {
        return Repo.saveAndFlush(model);
    }

    @Override
    public Sistema update(Sistema model) {
        return Repo.save(model);
    }

    @Override
    public void delete(Long id) {
        Repo.deleteById(id);
    }
}
