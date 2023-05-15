package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.DeltaResponsable;
import cl.cummins.dbm.service.DeltaResponsableService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/deltaresponsable")
public class DeltaResponsableController {
    @Autowired
    private DeltaResponsableService service;

    @GetMapping
    public ResponseEntity<List<DeltaResponsable>> findAll(){
        List<DeltaResponsable> deltaResponsables = service.findAll();
        return new ResponseEntity<>(deltaResponsables, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<DeltaResponsable> findById(@PathVariable("id") Long id){
        DeltaResponsable deltaResponsable = service.findById(id).orElseThrow(() -> new ModelNotFoundException("Delta Responsable no encontrado"));
        return new ResponseEntity<>(deltaResponsable, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<DeltaResponsable> create(@Valid @RequestBody DeltaResponsable deltaResponsable){
        DeltaResponsable user = service.create(deltaResponsable);
        Optional<DeltaResponsable> deltaResponsableNew = service.findById((user.getId()));
        if (deltaResponsableNew.isPresent()){
            return new ResponseEntity<>(deltaResponsableNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<DeltaResponsable> update(@Valid @RequestBody DeltaResponsable deltaResponsable){
        Optional<DeltaResponsable> deltaResponsableOld = service.findById(deltaResponsable.getId());
        DeltaResponsable faneaNew = null;

        if(deltaResponsableOld.isPresent()){
            faneaNew = service.update(deltaResponsable);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
