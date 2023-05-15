package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.Sistema;
import cl.cummins.dbm.model.Subsistema;
import cl.cummins.dbm.service.SistemaService;
import cl.cummins.dbm.service.SubsistemaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subsistema")
public class SubsistemaController {
    @Autowired
    private SubsistemaService service;

    @GetMapping
    public ResponseEntity<List<Subsistema>> findAll(){
        List<Subsistema> subsistemas = service.findAll();
        return new ResponseEntity<>(subsistemas, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Subsistema> findById(@PathVariable("id") Long id){
        Subsistema subsistema = service.findById(id).orElseThrow(() -> new ModelNotFoundException("Subsistema no encontrado"));
        return new ResponseEntity<>(subsistema, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Subsistema> create(@Valid @RequestBody Subsistema subsistema){
        Subsistema user = service.create(subsistema);
        Optional<Subsistema> subsistemaNew = service.findById((user.getId()));
        if (subsistemaNew.isPresent()){
            return new ResponseEntity<>(subsistemaNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<Subsistema> update(@Valid @RequestBody Subsistema subsistema){
        Optional<Subsistema> subsistemaOld = service.findById(subsistema.getId());
        Subsistema faneaNew = null;

        if(subsistemaOld.isPresent()){
            faneaNew = service.update(subsistema);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
