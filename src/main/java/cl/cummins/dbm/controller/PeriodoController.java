package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.Periodo;
import cl.cummins.dbm.service.PeriodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/periodo")
public class PeriodoController {
    @Autowired
    private PeriodoService service;

    @GetMapping
    public ResponseEntity<List<Periodo>> findAll(){
        List<Periodo> periodos = service.findAll();
        return new ResponseEntity<>(periodos, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Periodo> findById(@PathVariable("id") Long id){
        Periodo periodo = service.findById(id).orElseThrow(() -> new ModelNotFoundException("Periodo no encontrado"));
        return new ResponseEntity<>(periodo, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Periodo> create(@Valid @RequestBody Periodo periodo){
        Periodo user = service.create(periodo);
        Optional<Periodo> periodoNew = service.findById((user.getId()));
        if (periodoNew.isPresent()){
            return new ResponseEntity<>(periodoNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<Periodo> update(@Valid @RequestBody Periodo periodo){
        Optional<Periodo> periodoOld = service.findById(periodo.getId());
        Periodo faneaNew = null;

        if(periodoOld.isPresent()){
            faneaNew = service.update(periodo);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
