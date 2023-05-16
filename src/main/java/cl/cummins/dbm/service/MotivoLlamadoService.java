package cl.cummins.dbm.service;

import cl.cummins.dbm.model.MotivoLlamado;
import cl.cummins.dbm.repository.IMotivoLlamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotivoLlamadoService implements ICRUDService<MotivoLlamado> {
    @Autowired
    private IMotivoLlamadoRepository Repo;

    @Override
    public List<MotivoLlamado> findAll() {
        return Repo.findAll();
    }

    @Override
    public Optional<MotivoLlamado> findById(Long id) {
        return Repo.findById(id);
    }

    @Override
    public MotivoLlamado create(MotivoLlamado model) {
        return Repo.saveAndFlush(model);
    }

    @Override
    public MotivoLlamado update(MotivoLlamado model) {
        return Repo.save(model);
    }

    @Override
    public void delete(Long id) {
        Repo.deleteById(id);
    }
}
