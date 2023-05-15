package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.FaenaZona;
import cl.cummins.dbm.model.FaenaZonaNumerica;
import cl.cummins.dbm.service.FaenaZonaNumericaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/faenazonanumerica")
public class FaenaZonaNumericaController {

    @Autowired
    private FaenaZonaNumericaService service;


    @GetMapping
    public ResponseEntity<List<FaenaZonaNumerica>> findAll(){
        List<FaenaZonaNumerica> faenas = service.findAll();
        return new ResponseEntity<>(faenas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FaenaZonaNumerica> findById(@PathVariable("id") Long id){
        FaenaZonaNumerica faena = service.findById(id).orElseThrow(() -> new ModelNotFoundException("Faena Zona Numerica no encontrado"));
        return new ResponseEntity<>(faena, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<FaenaZonaNumerica> create(@Valid @RequestBody FaenaZonaNumerica faena){
        FaenaZonaNumerica faenaZona = service.create(faena);
        Optional<FaenaZonaNumerica> faenaZonaNew = service.findById((faenaZona.getId()));
        if (faenaZonaNew.isPresent()){
            return new ResponseEntity<>(faenaZonaNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<FaenaZonaNumerica> update(@Valid @RequestBody FaenaZonaNumerica faena){
        Optional<FaenaZonaNumerica> faenaOld = service.findById(faena.getId());
        FaenaZonaNumerica faneaNew = null;

        if(faenaOld.isPresent()){
            faneaNew = service.update(faena);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
