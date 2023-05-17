package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.FluidoUnidad;
import cl.cummins.dbm.service.FluidoUnidadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fluidounidad")
public class FluidoUnidadController {
    @Autowired
    private FluidoUnidadService service;

    @GetMapping
    public ResponseEntity<List<FluidoUnidad>> findAll(){
        List<FluidoUnidad> fluidoUnidads = service.findAll();
        return new ResponseEntity<>(fluidoUnidads, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<FluidoUnidad> findById(@PathVariable("id") Long id){
        FluidoUnidad fluidoUnidad = service.findById(id).orElseThrow(() -> new ModelNotFoundException("Unidad de Fluido no encontrado"));
        return new ResponseEntity<>(fluidoUnidad, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<FluidoUnidad> create(@Valid @RequestBody FluidoUnidad fluidoUnidad){
        FluidoUnidad user = service.create(fluidoUnidad);
        Optional<FluidoUnidad> fluidoUnidadNew = service.findById((user.getId()));
        if (fluidoUnidadNew.isPresent()){
            return new ResponseEntity<>(fluidoUnidadNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<FluidoUnidad> update(@Valid @RequestBody FluidoUnidad fluidoUnidad){
        Optional<FluidoUnidad> fluidoUnidadOld = service.findById(fluidoUnidad.getId());
        FluidoUnidad faneaNew = null;

        if(fluidoUnidadOld.isPresent()){
            faneaNew = service.update(fluidoUnidad);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
