package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.Responsable;
import cl.cummins.dbm.service.ResponsableService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/responsable")
public class ResponsableController {
    @Autowired
    private ResponsableService service;

    @GetMapping
    public ResponseEntity<List<Responsable>> findAll(){
        List<Responsable> responsables = service.findAll();
        return new ResponseEntity<>(responsables, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Responsable> findById(@PathVariable("id") Long id){
        Responsable responsable = service.findById(id).orElseThrow(() -> new ModelNotFoundException("Responsable no encontrado"));
        return new ResponseEntity<>(responsable, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Responsable> create(@Valid @RequestBody Responsable responsable){
        Responsable user = service.create(responsable);
        Optional<Responsable> responsableNew = service.findById((user.getId()));
        if (responsableNew.isPresent()){
            return new ResponseEntity<>(responsableNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<Responsable> update(@Valid @RequestBody Responsable responsable){
        Optional<Responsable> responsableOld = service.findById(responsable.getId());
        Responsable faneaNew = null;

        if(responsableOld.isPresent()){
            faneaNew = service.update(responsable);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
