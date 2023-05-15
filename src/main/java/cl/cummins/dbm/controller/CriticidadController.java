package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.Criticidad;
import cl.cummins.dbm.service.CriticidadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/criticidad")
public class CriticidadController {
    @Autowired
    private CriticidadService service;

    @GetMapping
    public ResponseEntity<List<Criticidad>> findAll(){
        List<Criticidad> criticidads = service.findAll();
        return new ResponseEntity<>(criticidads, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Criticidad> findById(@PathVariable("id") Long id){
        Criticidad criticidad = service.findById(id).orElseThrow(() -> new ModelNotFoundException("Criticidad no encontrado"));
        return new ResponseEntity<>(criticidad, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Criticidad> create(@Valid @RequestBody Criticidad criticidad){
        Criticidad user = service.create(criticidad);
        Optional<Criticidad> criticidadNew = service.findById((user.getId()));
        if (criticidadNew.isPresent()){
            return new ResponseEntity<>(criticidadNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<Criticidad> update(@Valid @RequestBody Criticidad criticidad){
        Optional<Criticidad> criticidadOld = service.findById(criticidad.getId());
        Criticidad faneaNew = null;

        if(criticidadOld.isPresent()){
            faneaNew = service.update(criticidad);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
