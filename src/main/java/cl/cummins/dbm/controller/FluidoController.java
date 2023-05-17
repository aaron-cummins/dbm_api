package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.Fluido;
import cl.cummins.dbm.service.FluidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fluidp")
public class FluidoController {
    @Autowired
    private FluidoService service;

    @GetMapping
    public ResponseEntity<List<Fluido>> findAll(){
        List<Fluido> fluidos = service.findAll();
        return new ResponseEntity<>(fluidos, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Fluido> findById(@PathVariable("id") Long id){
        Fluido fluido = service.findById(id).orElseThrow(() -> new ModelNotFoundException("Fluido no encontrado"));
        return new ResponseEntity<>(fluido, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Fluido> create(@Valid @RequestBody Fluido fluido){
        Fluido user = service.create(fluido);
        Optional<Fluido> fluidoNew = service.findById((user.getId()));
        if (fluidoNew.isPresent()){
            return new ResponseEntity<>(fluidoNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<Fluido> update(@Valid @RequestBody Fluido fluido){
        Optional<Fluido> fluidoOld = service.findById(fluido.getId());
        Fluido faneaNew = null;

        if(fluidoOld.isPresent()){
            faneaNew = service.update(fluido);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
