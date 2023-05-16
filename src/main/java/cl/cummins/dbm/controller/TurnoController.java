package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.Turno;
import cl.cummins.dbm.service.TurnoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turno")
public class TurnoController {
    @Autowired
    private TurnoService service;

    @GetMapping
    public ResponseEntity<List<Turno>> findAll(){
        List<Turno> turnos = service.findAll();
        return new ResponseEntity<>(turnos, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Turno> findById(@PathVariable("id") Long id){
        Turno turno = service.findById(id).orElseThrow(() -> new ModelNotFoundException("Turno no encontrado"));
        return new ResponseEntity<>(turno, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Turno> create(@Valid @RequestBody Turno turno){
        Turno user = service.create(turno);
        Optional<Turno> turnoNew = service.findById((user.getId()));
        if (turnoNew.isPresent()){
            return new ResponseEntity<>(turnoNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<Turno> update(@Valid @RequestBody Turno turno){
        Optional<Turno> turnoOld = service.findById(turno.getId());
        Turno faneaNew = null;

        if(turnoOld.isPresent()){
            faneaNew = service.update(turno);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
