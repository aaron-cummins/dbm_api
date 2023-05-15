package cl.cummins.dbm.service;

import cl.cummins.dbm.model.SintomaCategoria;
import cl.cummins.dbm.repository.ISintomaCategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SintomaCategoriaService implements ICRUDService<SintomaCategoria> {

    @Autowired
    private ISintomaCategoriaRepository repo;

    @Override
    public List<SintomaCategoria> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<SintomaCategoria> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public SintomaCategoria create(SintomaCategoria model) {
        return repo.saveAndFlush(model);
    }

    @Override
    public SintomaCategoria update(SintomaCategoria model) {
        return repo.save(model);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
