package cl.cummins.dbm.service;

import cl.cummins.dbm.model.FaenaFlota;
import cl.cummins.dbm.repository.IFaenaFlotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaenaFlotaService implements ICRUDService<FaenaFlota> {

    @Autowired
    private IFaenaFlotaRepository faenaFlotaRepo;

    @Override
    public List<FaenaFlota> findAll() {
        return faenaFlotaRepo.findAll();
    }

    @Override
    public Optional<FaenaFlota> findById(Long id) {
        return faenaFlotaRepo.findById(id);
    }

    @Override
    public FaenaFlota create(FaenaFlota model) {
        return faenaFlotaRepo.saveAndFlush(model);
    }

    @Override
    public FaenaFlota update(FaenaFlota model) {
        return faenaFlotaRepo.save(model);
    }

    @Override
    public void delete(Long id) {
        faenaFlotaRepo.deleteById(id);
    }
}
