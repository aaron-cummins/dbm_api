package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.LugarReparacion;
import cl.cummins.dbm.service.LugarReparacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lugarreparacion")
public class LugarReparacionController {
    @Autowired
    private LugarReparacionService service;

    @GetMapping
    public ResponseEntity<List<LugarReparacion>> findAll(){
        List<LugarReparacion> lugarReparacions = service.findAll();
        return new ResponseEntity<>(lugarReparacions, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<LugarReparacion> findById(@PathVariable("id") Long id){
        LugarReparacion lugarReparacion = service.findById(id).orElseThrow(() -> new ModelNotFoundException("Lugar Reparación no encontrado"));
        return new ResponseEntity<>(lugarReparacion, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<LugarReparacion> create(@Valid @RequestBody LugarReparacion lugarReparacion){
        LugarReparacion user = service.create(lugarReparacion);
        Optional<LugarReparacion> lugarReparacionNew = service.findById((user.getId()));
        if (lugarReparacionNew.isPresent()){
            return new ResponseEntity<>(lugarReparacionNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<LugarReparacion> update(@Valid @RequestBody LugarReparacion lugarReparacion){
        Optional<LugarReparacion> lugarReparacionOld = service.findById(lugarReparacion.getId());
        LugarReparacion faneaNew = null;

        if(lugarReparacionOld.isPresent()){
            faneaNew = service.update(lugarReparacion);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
