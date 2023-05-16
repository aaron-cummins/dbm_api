package cl.cummins.dbm.service;

import cl.cummins.dbm.model.Planificacion;
import cl.cummins.dbm.repository.IPlanificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PlanificacionService implements ICRUDService<Planificacion> {
    @Autowired
    private IPlanificacionRepository Repo;

    @Override
    public List<Planificacion> findAll() {
        return Repo.findAll();
    }

    public Page<Planificacion> findAllByFechas(Date fecha, Pageable pageable){
        return Repo.findAllByFecha(fecha, pageable);
    }

    public Page<Planificacion> findAllByFechasBetween(Date fechaini, Date fechafin, Pageable pageable){
        return Repo.findAllByFechaBetween(fechaini, fechafin, pageable);
    }

    @Override
    public Optional<Planificacion> findById(Long id) {
        return Repo.findById(id);
    }

    @Override
    public Planificacion create(Planificacion model) {
        return Repo.saveAndFlush(model);
    }

    @Override
    public Planificacion update(Planificacion model) {
        return Repo.save(model);
    }

    @Override
    public void delete(Long id) {
        Repo.deleteById(id);
    }
}
