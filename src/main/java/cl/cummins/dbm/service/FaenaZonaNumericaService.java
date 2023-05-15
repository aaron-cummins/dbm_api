package cl.cummins.dbm.service;


import cl.cummins.dbm.model.FaenaZonaNumerica;
import cl.cummins.dbm.repository.IFaenaZonaNumericaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaenaZonaNumericaService implements ICRUDService<FaenaZonaNumerica>{
    @Autowired
    private IFaenaZonaNumericaRepository faenaRepo;

    @Override
    public List<FaenaZonaNumerica> findAll() {
        return faenaRepo.findAll();
    }

    @Override
    public Optional<FaenaZonaNumerica> findById(Long id) {
        return faenaRepo.findById(id);
    }

    @Override
    public FaenaZonaNumerica create(FaenaZonaNumerica model) {
        return faenaRepo.saveAndFlush(model);
    }

    @Override
    public FaenaZonaNumerica update(FaenaZonaNumerica model) {
        return faenaRepo.save(model);
    }

    @Override
    public void delete(Long id) {
        faenaRepo.deleteById(id);
    }
}
