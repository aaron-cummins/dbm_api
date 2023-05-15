package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.Faena;
import cl.cummins.dbm.service.FaenaService;
import cl.cummins.dbm.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/faena")
public class FaenaController {
    @Autowired
    private FaenaService service;

    @GetMapping
    public ResponseEntity<List<Faena>> findAll(){
        List<Faena> faenas = service.findAll();
        return new ResponseEntity<>(faenas, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Faena> findById(@PathVariable("id") Long id){
        Faena faena = service.findById(id).orElseThrow(() -> new ModelNotFoundException("Faena no encontrado"));
        return new ResponseEntity<>(faena, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Faena> create(@Valid @RequestBody Faena faena){
        Faena user = service.create(faena);
        Optional<Faena> faenaNew = service.findById((user.getId()));
        if (faenaNew.isPresent()){
            return new ResponseEntity<>(faenaNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<Faena> update(@Valid @RequestBody Faena faena){
        Optional<Faena> faenaOld = service.findById(faena.getId());
        Faena faneaNew = null;

        if(faenaOld.isPresent()){
            faneaNew = service.update(faena);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
