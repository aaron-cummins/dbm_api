package cl.cummins.dbm.service;

import cl.cummins.dbm.model.Flota;
import cl.cummins.dbm.repository.IFlotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlotaService implements ICRUDService<Flota>{

    @Autowired
    private IFlotaRepository flotaRepo;

    @Override
    public List<Flota> findAll() {
        return flotaRepo.findAll();
    }

    @Override
    public Optional<Flota> findById(Long id) {
        return flotaRepo.findById(id);
    }

    @Override
    public Flota create(Flota model) {
        return flotaRepo.saveAndFlush(model);
    }

    @Override
    public Flota update(Flota model) {
        return flotaRepo.save(model);
    }

    @Override
    public void delete(Long id) {
        flotaRepo.deleteById(id);
    }
}
