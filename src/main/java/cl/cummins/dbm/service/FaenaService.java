package cl.cummins.dbm.service;

import cl.cummins.dbm.model.Faena;
import cl.cummins.dbm.repository.IFaenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaenaService implements ICRUDService<Faena>{

    @Autowired
    private IFaenaRepository faenaRepo;

    @Override
    public List<Faena> findAll() {
        return faenaRepo.findAll();
    }

    @Override
    public Optional<Faena> findById(Long id) {
        return faenaRepo.findById(id);
    }

    @Override
    public Faena create(Faena model) {
        return faenaRepo.saveAndFlush(model);
    }

    @Override
    public Faena update(Faena model) {
        return faenaRepo.save(model);
    }

    @Override
    public void delete(Long id) {
        faenaRepo.deleteById(id);
    }
}
