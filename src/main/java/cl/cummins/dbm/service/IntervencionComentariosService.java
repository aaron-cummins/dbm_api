package cl.cummins.dbm.service;

import cl.cummins.dbm.model.IntervencionComentarios;
import cl.cummins.dbm.repository.IIntervencionComentariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IntervencionComentariosService implements ICRUDService<IntervencionComentarios> {
    @Autowired
    private IIntervencionComentariosRepository Repo;

    @Override
    public List<IntervencionComentarios> findAll() {
        return Repo.findAll();
    }

    @Override
    public Optional<IntervencionComentarios> findById(Long id) {
        return Repo.findById(id);
    }

    @Override
    public IntervencionComentarios create(IntervencionComentarios model) {
        return Repo.saveAndFlush(model);
    }

    @Override
    public IntervencionComentarios update(IntervencionComentarios model) {
        return Repo.save(model);
    }

    @Override
    public void delete(Long id) {
        Repo.deleteById(id);
    }
}
