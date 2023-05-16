package cl.cummins.dbm.service;

import cl.cummins.dbm.model.Periodo;
import cl.cummins.dbm.repository.IPeriodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PeriodoService implements ICRUDService<Periodo> {
    @Autowired
    private IPeriodoRepository Repo;

    @Override
    public List<Periodo> findAll() {
        return Repo.findAll();
    }

    @Override
    public Optional<Periodo> findById(Long id) {
        return Repo.findById(id);
    }

    @Override
    public Periodo create(Periodo model) {
        return Repo.saveAndFlush(model);
    }

    @Override
    public Periodo update(Periodo model) {
        return Repo.save(model);
    }

    @Override
    public void delete(Long id) {
        Repo.deleteById(id);
    }
}
