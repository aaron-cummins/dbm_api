package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.EstadoEquipos;
import cl.cummins.dbm.model.Motor;
import cl.cummins.dbm.service.EstadoEuiposService;
import cl.cummins.dbm.service.MotorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estadoequipos")
public class EstadoEquiposController {
    @Autowired
    private EstadoEuiposService service;

    @GetMapping
    public ResponseEntity<List<EstadoEquipos>> findAll(){
        List<EstadoEquipos> estadoEquiposs = service.findAll();
        return new ResponseEntity<>(estadoEquiposs, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<EstadoEquipos> findById(@PathVariable("id") Long id){
        EstadoEquipos estadoEquipos = service.findById(id).orElseThrow(() -> new ModelNotFoundException("EstadoEquipos no encontrado"));
        return new ResponseEntity<>(estadoEquipos, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<EstadoEquipos> create(@Valid @RequestBody EstadoEquipos estadoEquipos){
        EstadoEquipos user = service.create(estadoEquipos);
        Optional<EstadoEquipos> estadoEquiposNew = service.findById((user.getId()));
        if (estadoEquiposNew.isPresent()){
            return new ResponseEntity<>(estadoEquiposNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<EstadoEquipos> update(@Valid @RequestBody EstadoEquipos estadoEquipos){
        Optional<EstadoEquipos> estadoEquiposOld = service.findById(estadoEquipos.getId());
        EstadoEquipos faneaNew = null;

        if(estadoEquiposOld.isPresent()){
            faneaNew = service.update(estadoEquipos);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
