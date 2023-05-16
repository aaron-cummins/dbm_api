package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.LugarCreacion;
import cl.cummins.dbm.service.LugarCreacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lugarcreacion")
public class LugarCreacionController {
    @Autowired
    private LugarCreacionService service;

    @GetMapping
    public ResponseEntity<List<LugarCreacion>> findAll(){
        List<LugarCreacion> lugarCreacions = service.findAll();
        return new ResponseEntity<>(lugarCreacions, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<LugarCreacion> findById(@PathVariable("id") Long id){
        LugarCreacion lugarCreacion = service.findById(id).orElseThrow(() -> new ModelNotFoundException("Lugar Creación no encontrado"));
        return new ResponseEntity<>(lugarCreacion, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<LugarCreacion> create(@Valid @RequestBody LugarCreacion lugarCreacion){
        LugarCreacion user = service.create(lugarCreacion);
        Optional<LugarCreacion> lugarCreacionNew = service.findById((user.getId()));
        if (lugarCreacionNew.isPresent()){
            return new ResponseEntity<>(lugarCreacionNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<LugarCreacion> update(@Valid @RequestBody LugarCreacion lugarCreacion){
        Optional<LugarCreacion> lugarCreacionOld = service.findById(lugarCreacion.getId());
        LugarCreacion faneaNew = null;

        if(lugarCreacionOld.isPresent()){
            faneaNew = service.update(lugarCreacion);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
