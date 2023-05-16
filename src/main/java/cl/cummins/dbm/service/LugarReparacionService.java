package cl.cummins.dbm.service;

import cl.cummins.dbm.model.LugarReparacion;
import cl.cummins.dbm.repository.ILugarReparacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LugarReparacionService implements ICRUDService<LugarReparacion> {
    @Autowired
    private ILugarReparacionRepository Repo;

    @Override
    public List<LugarReparacion> findAll() {
        return Repo.findAll();
    }

    @Override
    public Optional<LugarReparacion> findById(Long id) {
        return Repo.findById(id);
    }

    @Override
    public LugarReparacion create(LugarReparacion model) {
        return Repo.saveAndFlush(model);
    }

    @Override
    public LugarReparacion update(LugarReparacion model) {
        return Repo.save(model);
    }

    @Override
    public void delete(Long id) {
        Repo.deleteById(id);
    }
}
