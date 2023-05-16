package cl.cummins.dbm.service;

import cl.cummins.dbm.model.Estados;
import cl.cummins.dbm.repository.IEstadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadosService implements ICRUDService<Estados>{
    @Autowired
    private IEstadosRepository Repo;

    @Override
    public List<Estados> findAll() {
        return Repo.findAll();
    }

    @Override
    public Optional<Estados> findById(Long id) {
        return Repo.findById(id);
    }

    @Override
    public Estados create(Estados model) {
        return Repo.saveAndFlush(model);
    }

    @Override
    public Estados update(Estados model) {
        return Repo.save(model);
    }

    @Override
    public void delete(Long id) {
        Repo.deleteById(id);
    }
}
