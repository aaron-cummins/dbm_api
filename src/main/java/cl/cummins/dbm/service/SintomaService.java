package cl.cummins.dbm.service;

import cl.cummins.dbm.model.Sintoma;
import cl.cummins.dbm.repository.ISintomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SintomaService implements ICRUDService<Sintoma> {
    @Autowired
    private ISintomaRepository Repo;

    @Override
    public List<Sintoma> findAll() {
        return Repo.findAll();
    }

    @Override
    public Optional<Sintoma> findById(Long id) {
        return Repo.findById(id);
    }

    @Override
    public Sintoma create(Sintoma model) {
        return Repo.saveAndFlush(model);
    }

    @Override
    public Sintoma update(Sintoma model) {
        return Repo.save(model);
    }

    @Override
    public void delete(Long id) {
        Repo.deleteById(id);
    }
}
