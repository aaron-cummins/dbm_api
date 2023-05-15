package cl.cummins.dbm.service;

import cl.cummins.dbm.model.CategoriaSintoma;
import cl.cummins.dbm.repository.ICategoriaSintomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaSintomaService implements ICRUDService<CategoriaSintoma> {

    @Autowired
    private ICategoriaSintomaRepository repo;

    @Override
    public List<CategoriaSintoma> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<CategoriaSintoma> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public CategoriaSintoma create(CategoriaSintoma model) {
        return repo.saveAndFlush(model);
    }

    @Override
    public CategoriaSintoma update(CategoriaSintoma model) {
        return repo.save(model);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
