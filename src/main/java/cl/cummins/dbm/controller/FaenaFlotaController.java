package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.Asesor;
import cl.cummins.dbm.model.FaenaFlota;
import cl.cummins.dbm.service.AsesorService;
import cl.cummins.dbm.service.FaenaFlotaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/faenaflota")
public class FaenaFlotaController {
    @Autowired
    private FaenaFlotaService service;

    @GetMapping
    public ResponseEntity<List<FaenaFlota>> findAll(){
        List<FaenaFlota> flotafaenas = service.findAll();
        return new ResponseEntity<>(flotafaenas, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<FaenaFlota> findById(@PathVariable("id") Long id){
        FaenaFlota flotafaena = service.findById(id).orElseThrow(() -> new ModelNotFoundException("flota faena no encontrado"));
        return new ResponseEntity<>(flotafaena, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<FaenaFlota> create(@Valid @RequestBody FaenaFlota flotafaena){
        FaenaFlota user = service.create(flotafaena);
        Optional<FaenaFlota> flotafaenaNew = service.findById((user.getId()));
        if (flotafaenaNew.isPresent()){
            return new ResponseEntity<>(flotafaenaNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<FaenaFlota> update(@Valid @RequestBody FaenaFlota flotafaena){
        Optional<FaenaFlota> flotafaenaOld = service.findById(flotafaena.getId());
        FaenaFlota faneaNew = null;

        if(flotafaenaOld.isPresent()){
            faneaNew = service.update(flotafaena);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
