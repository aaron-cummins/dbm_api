package cl.cummins.dbm.service;

import cl.cummins.dbm.model.Faena;
import cl.cummins.dbm.model.FaenaZona;
import cl.cummins.dbm.repository.IFaenaRepository;
import cl.cummins.dbm.repository.IFaenaZonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaenaZonaService implements ICRUDService<FaenaZona>{

    @Autowired
    private IFaenaZonaRepository faenaRepo;

    @Override
    public List<FaenaZona> findAll() {
        return faenaRepo.findAll();
    }

    @Override
    public Optional<FaenaZona> findById(Long id) {
        return faenaRepo.findById(id);
    }

    @Override
    public FaenaZona create(FaenaZona model) {
        return faenaRepo.saveAndFlush(model);
    }

    @Override
    public FaenaZona update(FaenaZona model) {
        return faenaRepo.save(model);
    }

    @Override
    public void delete(Long id) {
        faenaRepo.deleteById(id);
    }
}
