package cl.cummins.dbm.service;

import cl.cummins.dbm.model.Motor;
import cl.cummins.dbm.repository.IMotorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotorService implements ICRUDService<Motor> {
    @Autowired
    private IMotorRepository Repo;

    @Override
    public List<Motor> findAll() {
        return Repo.findAll();
    }

    @Override
    public Optional<Motor> findById(Long id) {
        return Repo.findById(id);
    }

    @Override
    public Motor create(Motor model) {
        return Repo.saveAndFlush(model);
    }

    @Override
    public Motor update(Motor model) {
        return Repo.save(model);
    }

    @Override
    public void delete(Long id) {
        Repo.deleteById(id);
    }
}
