package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.TipoAdmision;
import cl.cummins.dbm.service.TipoAdmisionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipoadmision")
public class TipoAdmisionController {
    @Autowired
    private TipoAdmisionService service;

    @GetMapping
    public ResponseEntity<List<TipoAdmision>> findAll(){
        List<TipoAdmision> tipoAdmisions = service.findAll();
        return new ResponseEntity<>(tipoAdmisions, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TipoAdmision> findById(@PathVariable("id") Long id){
        TipoAdmision tipoAdmision = service.findById(id).orElseThrow(() -> new ModelNotFoundException("TipoAdmision no encontrado"));
        return new ResponseEntity<>(tipoAdmision, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<TipoAdmision> create(@Valid @RequestBody TipoAdmision tipoAdmision){
        TipoAdmision user = service.create(tipoAdmision);
        Optional<TipoAdmision> tipoAdmisionNew = service.findById((user.getId()));
        if (tipoAdmisionNew.isPresent()){
            return new ResponseEntity<>(tipoAdmisionNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<TipoAdmision> update(@Valid @RequestBody TipoAdmision tipoAdmision){
        Optional<TipoAdmision> tipoAdmisionOld = service.findById(tipoAdmision.getId());
        TipoAdmision faneaNew = null;

        if(tipoAdmisionOld.isPresent()){
            faneaNew = service.update(tipoAdmision);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
