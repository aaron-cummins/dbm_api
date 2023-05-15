package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.EstadoMotor;
import cl.cummins.dbm.model.Motor;
import cl.cummins.dbm.service.EstadoMotorService;
import cl.cummins.dbm.service.MotorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estadomotor")
public class EstadoMotorController {
    @Autowired
    private EstadoMotorService service;

    @GetMapping
    public ResponseEntity<List<EstadoMotor>> findAll(){
        List<EstadoMotor> estadoMotors = service.findAll();
        return new ResponseEntity<>(estadoMotors, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<EstadoMotor> findById(@PathVariable("id") Long id){
        EstadoMotor estadoMotor = service.findById(id).orElseThrow(() -> new ModelNotFoundException("EstadoMotor no encontrado"));
        return new ResponseEntity<>(estadoMotor, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<EstadoMotor> create(@Valid @RequestBody EstadoMotor estadoMotor){
        EstadoMotor user = service.create(estadoMotor);
        Optional<EstadoMotor> estadoMotorNew = service.findById((user.getId()));
        if (estadoMotorNew.isPresent()){
            return new ResponseEntity<>(estadoMotorNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<EstadoMotor> update(@Valid @RequestBody EstadoMotor estadoMotor){
        Optional<EstadoMotor> estadoMotorOld = service.findById(estadoMotor.getId());
        EstadoMotor faneaNew = null;

        if(estadoMotorOld.isPresent()){
            faneaNew = service.update(estadoMotor);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
