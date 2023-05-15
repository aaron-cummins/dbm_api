package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.TipoEmision;
import cl.cummins.dbm.model.TipoSalida;
import cl.cummins.dbm.service.TipoEmisionService;
import cl.cummins.dbm.service.TipoSalidaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipoemision")
public class TipoEmisionController {
    @Autowired
    private TipoEmisionService service;

    @GetMapping
    public ResponseEntity<List<TipoEmision>> findAll(){
        List<TipoEmision> tipoEmisions = service.findAll();
        return new ResponseEntity<>(tipoEmisions, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TipoEmision> findById(@PathVariable("id") Long id){
        TipoEmision tipoEmision = service.findById(id).orElseThrow(() -> new ModelNotFoundException("TipoEmision no encontrado"));
        return new ResponseEntity<>(tipoEmision, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<TipoEmision> create(@Valid @RequestBody TipoEmision tipoEmision){
        TipoEmision user = service.create(tipoEmision);
        Optional<TipoEmision> tipoEmisionNew = service.findById((user.getId()));
        if (tipoEmisionNew.isPresent()){
            return new ResponseEntity<>(tipoEmisionNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<TipoEmision> update(@Valid @RequestBody TipoEmision tipoEmision){
        Optional<TipoEmision> tipoEmisionOld = service.findById(tipoEmision.getId());
        TipoEmision faneaNew = null;

        if(tipoEmisionOld.isPresent()){
            faneaNew = service.update(tipoEmision);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
