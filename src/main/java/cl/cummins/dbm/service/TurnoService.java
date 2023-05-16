package cl.cummins.dbm.service;

import cl.cummins.dbm.model.Turno;
import cl.cummins.dbm.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService implements ICRUDService<Turno> {
    @Autowired
    private ITurnoRepository Repo;

    @Override
    public List<Turno> findAll() {
        return Repo.findAll();
    }

    @Override
    public Optional<Turno> findById(Long id) {
        return Repo.findById(id);
    }

    @Override
    public Turno create(Turno model) {
        return Repo.saveAndFlush(model);
    }

    @Override
    public Turno update(Turno model) {
        return Repo.save(model);
    }

    @Override
    public void delete(Long id) {
        Repo.deleteById(id);
    }
}
