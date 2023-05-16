package cl.cummins.dbm.service;

import cl.cummins.dbm.model.LugarCreacion;
import cl.cummins.dbm.repository.ILugarCreacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LugarCreacionService implements ICRUDService<LugarCreacion> {
    @Autowired
    private ILugarCreacionRepository Repo;

    @Override
    public List<LugarCreacion> findAll() {
        return Repo.findAll();
    }

    @Override
    public Optional<LugarCreacion> findById(Long id) {
        return Repo.findById(id);
    }

    @Override
    public LugarCreacion create(LugarCreacion model) {
        return Repo.saveAndFlush(model);
    }

    @Override
    public LugarCreacion update(LugarCreacion model) {
        return Repo.save(model);
    }

    @Override
    public void delete(Long id) {
        Repo.deleteById(id);
    }
}
