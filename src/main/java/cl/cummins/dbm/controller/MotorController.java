package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.Motor;
import cl.cummins.dbm.service.MotorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/motor")
public class MotorController {
    @Autowired
    private MotorService service;

    @GetMapping
    public ResponseEntity<List<Motor>> findAll(){
        List<Motor> motors = service.findAll();
        return new ResponseEntity<>(motors, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Motor> findById(@PathVariable("id") Long id){
        Motor motor = service.findById(id).orElseThrow(() -> new ModelNotFoundException("Motor no encontrado"));
        return new ResponseEntity<>(motor, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Motor> create(@Valid @RequestBody Motor motor){
        Motor user = service.create(motor);
        Optional<Motor> categoriaMotorNew = service.findById((user.getId()));
        if (categoriaMotorNew.isPresent()){
            return new ResponseEntity<>(categoriaMotorNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<Motor> update(@Valid @RequestBody Motor motor){
        Optional<Motor> categoriaMotorOld = service.findById(motor.getId());
        Motor faneaNew = null;

        if(categoriaMotorOld.isPresent()){
            faneaNew = service.update(motor);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
