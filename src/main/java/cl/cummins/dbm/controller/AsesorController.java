package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.Asesor;
import cl.cummins.dbm.service.AsesorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/asesor")
public class AsesorController {
    @Autowired
    private AsesorService service;

    @GetMapping
    public ResponseEntity<List<Asesor>> findAll(){
        List<Asesor> asesors = service.findAll();
        return new ResponseEntity<>(asesors, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Asesor> findById(@PathVariable("id") Long id){
        Asesor asesor = service.findById(id).orElseThrow(() -> new ModelNotFoundException("Asesor no encontrado"));
        return new ResponseEntity<>(asesor, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Asesor> create(@Valid @RequestBody Asesor asesor){
        Asesor user = service.create(asesor);
        Optional<Asesor> asesorNew = service.findById((user.getId()));
        if (asesorNew.isPresent()){
            return new ResponseEntity<>(asesorNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<Asesor> update(@Valid @RequestBody Asesor asesor){
        Optional<Asesor> asesorOld = service.findById(asesor.getId());
        Asesor faneaNew = null;

        if(asesorOld.isPresent()){
            faneaNew = service.update(asesor);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
