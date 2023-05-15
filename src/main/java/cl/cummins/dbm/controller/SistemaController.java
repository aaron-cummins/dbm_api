package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.Sistema;
import cl.cummins.dbm.service.SistemaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sistema")
public class SistemaController {
    @Autowired
    private SistemaService service;

    @GetMapping
    public ResponseEntity<List<Sistema>> findAll(){
        List<Sistema> sistemas = service.findAll();
        return new ResponseEntity<>(sistemas, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Sistema> findById(@PathVariable("id") Long id){
        Sistema sistema = service.findById(id).orElseThrow(() -> new ModelNotFoundException("Sistema no encontrado"));
        return new ResponseEntity<>(sistema, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Sistema> create(@Valid @RequestBody Sistema sistema){
        Sistema user = service.create(sistema);
        Optional<Sistema> categoriaSistemaNew = service.findById((user.getId()));
        if (categoriaSistemaNew.isPresent()){
            return new ResponseEntity<>(categoriaSistemaNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<Sistema> update(@Valid @RequestBody Sistema sistema){
        Optional<Sistema> categoriaSistemaOld = service.findById(sistema.getId());
        Sistema faneaNew = null;

        if(categoriaSistemaOld.isPresent()){
            faneaNew = service.update(sistema);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
