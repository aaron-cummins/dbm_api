package cl.cummins.dbm.service;

import cl.cummins.dbm.model.DeltaDetalle;
import cl.cummins.dbm.repository.IDeltaDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeltaDetalleService implements ICRUDService<DeltaDetalle> {
    @Autowired
    private IDeltaDetalleRepository repo;

    @Override
    public List<DeltaDetalle> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<DeltaDetalle> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public DeltaDetalle create(DeltaDetalle model) {
        return repo.saveAndFlush(model);
    }

    @Override
    public DeltaDetalle update(DeltaDetalle model) {
        return repo.save(model);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
