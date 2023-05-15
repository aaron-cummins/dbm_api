package cl.cummins.dbm.controller;


import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.Faena;
import cl.cummins.dbm.model.FaenaZona;
import cl.cummins.dbm.service.FaenaService;
import cl.cummins.dbm.service.FaenaZonaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/faenazona")
public class FaenaZonaController {

    @Autowired
    private FaenaZonaService service;


    @GetMapping
    public ResponseEntity<List<FaenaZona>> findAll(){
        List<FaenaZona> faenas = service.findAll();
        return new ResponseEntity<>(faenas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FaenaZona> findById(@PathVariable("id") Long id){
        FaenaZona faena = service.findById(id).orElseThrow(() -> new ModelNotFoundException("Faena Zona no encontrado"));
        return new ResponseEntity<>(faena, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<FaenaZona> create(@Valid @RequestBody FaenaZona faena){
        FaenaZona faenaZona = service.create(faena);
        Optional<FaenaZona> faenaZonaNew = service.findById((faenaZona.getId()));
        if (faenaZonaNew.isPresent()){
            return new ResponseEntity<>(faenaZonaNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<FaenaZona> update(@Valid @RequestBody FaenaZona faena){
        Optional<FaenaZona> faenaOld = service.findById(faena.getId());
        FaenaZona faneaNew = null;

        if(faenaOld.isPresent()){
            faneaNew = service.update(faena);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
