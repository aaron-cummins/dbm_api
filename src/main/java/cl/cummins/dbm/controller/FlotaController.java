package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.Asesor;
import cl.cummins.dbm.model.Flota;
import cl.cummins.dbm.service.AsesorService;
import cl.cummins.dbm.service.FlotaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flota")
public class FlotaController {

    @Autowired
    private FlotaService service;

    @GetMapping
    public ResponseEntity<List<Flota>> findAll(){
        List<Flota> flotas = service.findAll();
        return new ResponseEntity<>(flotas, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Flota> findById(@PathVariable("id") Long id){
        Flota flota = service.findById(id).orElseThrow(() -> new ModelNotFoundException("flota no encontrado"));
        return new ResponseEntity<>(flota, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Flota> create(@Valid @RequestBody Flota flota){
        Flota user = service.create(flota);
        Optional<Flota> flotaNew = service.findById((user.getId()));
        if (flotaNew.isPresent()){
            return new ResponseEntity<>(flotaNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<Flota> update(@Valid @RequestBody Flota flota){
        Optional<Flota> flotaOld = service.findById(flota.getId());
        Flota faneaNew = null;

        if(flotaOld.isPresent()){
            faneaNew = service.update(flota);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
