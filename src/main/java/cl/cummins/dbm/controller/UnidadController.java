package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.Unidad;
import cl.cummins.dbm.service.UnidadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/unidad")
public class UnidadController {
    @Autowired
    private UnidadService service;

    @GetMapping
    public ResponseEntity<List<Unidad>> findAll(){
        List<Unidad> unidads = service.findAll();
        return new ResponseEntity<>(unidads, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Unidad> findById(@PathVariable("id") Long id){
        Unidad unidad = service.findById(id).orElseThrow(() -> new ModelNotFoundException("Unidad no encontrado"));
        return new ResponseEntity<>(unidad, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Unidad> create(@Valid @RequestBody Unidad unidad){
        Unidad user = service.create(unidad);
        Optional<Unidad> unidadNew = service.findById((user.getId()));
        if (unidadNew.isPresent()){
            return new ResponseEntity<>(unidadNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<Unidad> update(@Valid @RequestBody Unidad unidad){
        Optional<Unidad> unidadOld = service.findById(unidad.getId());
        Unidad faneaNew = null;

        if(unidadOld.isPresent()){
            faneaNew = service.update(unidad);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
