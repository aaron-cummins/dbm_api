package cl.cummins.dbm.service;

import cl.cummins.dbm.model.Asesor;
import cl.cummins.dbm.repository.IAsesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsesorService implements ICRUDService<Asesor>{

    @Autowired
    private IAsesorRepository asesorRepo;

    @Override
    public List<Asesor> findAll() {
        return asesorRepo.findAll();
    }

    @Override
    public Optional<Asesor> findById(Long id) {
        return asesorRepo.findById(id);
    }

    @Override
    public Asesor create(Asesor model) {
        return asesorRepo.saveAndFlush(model);
    }

    @Override
    public Asesor update(Asesor model) {
        return asesorRepo.save(model);
    }

    @Override
    public void delete(Long id) {
        asesorRepo.deleteById(id);
    }
}
