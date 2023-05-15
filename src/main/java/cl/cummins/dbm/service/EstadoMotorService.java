package cl.cummins.dbm.service;

import cl.cummins.dbm.model.EstadoMotor;
import cl.cummins.dbm.repository.IEstadoMotorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoMotorService implements ICRUDService<EstadoMotor> {
    @Autowired
    private IEstadoMotorRepository Repo;

    @Override
    public List<EstadoMotor> findAll() {
        return Repo.findAll();
    }

    @Override
    public Optional<EstadoMotor> findById(Long id) {
        return Repo.findById(id);
    }

    @Override
    public EstadoMotor create(EstadoMotor model) {
        return Repo.saveAndFlush(model);
    }

    @Override
    public EstadoMotor update(EstadoMotor model) {
        return Repo.save(model);
    }

    @Override
    public void delete(Long id) {
        Repo.deleteById(id);
    }
}
