package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.DeltaDetalle;
import cl.cummins.dbm.service.DeltaDetalleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/deltadetalle")
public class DeltaDetalleController {
    @Autowired
    private DeltaDetalleService service;

    @GetMapping
    public ResponseEntity<List<DeltaDetalle>> findAll(){
        List<DeltaDetalle> deltaDetalles = service.findAll();
        return new ResponseEntity<>(deltaDetalles, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<DeltaDetalle> findById(@PathVariable("id") Long id){
        DeltaDetalle deltaDetalle = service.findById(id).orElseThrow(() -> new ModelNotFoundException("Delta Detalle no encontrado"));
        return new ResponseEntity<>(deltaDetalle, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<DeltaDetalle> create(@Valid @RequestBody DeltaDetalle deltaDetalle){
        DeltaDetalle user = service.create(deltaDetalle);
        Optional<DeltaDetalle> deltaDetalleNew = service.findById((user.getId()));
        if (deltaDetalleNew.isPresent()){
            return new ResponseEntity<>(deltaDetalleNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<DeltaDetalle> update(@Valid @RequestBody DeltaDetalle deltaDetalle){
        Optional<DeltaDetalle> deltaDetalleOld = service.findById(deltaDetalle.getId());
        DeltaDetalle faneaNew = null;

        if(deltaDetalleOld.isPresent()){
            faneaNew = service.update(deltaDetalle);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
