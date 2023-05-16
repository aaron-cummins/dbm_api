package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.Planificacion;
import cl.cummins.dbm.service.PlanificacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/planificacion")
public class PlanificacionController {
    @Autowired
    private PlanificacionService service;

    @GetMapping
    public ResponseEntity<Map<String, Object>> findAll(@RequestParam("fechaini") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaini,
                                                       @RequestParam("fechafin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechafin,
                                                       @RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "3") int size){

        try{
            List<Planificacion> planificacions;
            Pageable pagina = PageRequest.of(page, size);

            Page<Planificacion> pagePLanificacion;
            pagePLanificacion = service.findAllByFechasBetween(fechaini, fechafin, pagina);

            planificacions = pagePLanificacion.getContent();

            Map<String, Object> response = new HashMap<>();

            response.put("planificaciones", planificacions);
            response.put("currentPage", pagePLanificacion.getNumber());
            response.put("totalItems", pagePLanificacion.getTotalElements());
            response.put("totalPages", pagePLanificacion.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception ex){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/options")
    public ResponseEntity<Map<String, Object>> findAllByfechas(
            @RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fecha,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size){
        try{
            List<Planificacion> planificaciones = new ArrayList<Planificacion>();
            Pageable pagina = PageRequest.of(page, size);

            Page<Planificacion> pagePLanificacion;
            pagePLanificacion = service.findAllByFechas(fecha, pagina);

            planificaciones = pagePLanificacion.getContent();

            Map<String, Object> response = new HashMap<>();

            response.put("planificaciones", planificaciones);
            response.put("currentPage", pagePLanificacion.getNumber());
            response.put("totalItems", pagePLanificacion.getTotalElements());
            response.put("totalPages", pagePLanificacion.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @GetMapping("/{id}")
    public ResponseEntity<Planificacion> findById(@PathVariable("id") Long id){
        Planificacion planificacion = service.findById(id).orElseThrow(() -> new ModelNotFoundException("Planificacion no encontrado"));
        return new ResponseEntity<>(planificacion, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Planificacion> create(@Valid @RequestBody Planificacion planificacion){
        Planificacion user = service.create(planificacion);
        Optional<Planificacion> planificacionNew = service.findById((user.getId()));
        if (planificacionNew.isPresent()){
            return new ResponseEntity<>(planificacionNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<Planificacion> update(@Valid @RequestBody Planificacion planificacion){
        Optional<Planificacion> planificacionOld = service.findById(planificacion.getId());
        Planificacion faneaNew = null;

        if(planificacionOld.isPresent()){
            faneaNew = service.update(planificacion);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
