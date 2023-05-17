package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.FluidoTipoIngreso;
import cl.cummins.dbm.service.FluidoTipoIngresoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fluidotipoingreso")
public class FluidoTipoIngresoController {
    @Autowired
    private FluidoTipoIngresoService service;

    @GetMapping
    public ResponseEntity<List<FluidoTipoIngreso>> findAll(){
        List<FluidoTipoIngreso> fluidoTipoIngresos = service.findAll();
        return new ResponseEntity<>(fluidoTipoIngresos, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<FluidoTipoIngreso> findById(@PathVariable("id") Long id){
        FluidoTipoIngreso fluidoTipoIngreso = service.findById(id).orElseThrow(() -> new ModelNotFoundException("Tipo Ingreso Fluido no encontrado"));
        return new ResponseEntity<>(fluidoTipoIngreso, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<FluidoTipoIngreso> create(@Valid @RequestBody FluidoTipoIngreso fluidoTipoIngreso){
        FluidoTipoIngreso user = service.create(fluidoTipoIngreso);
        Optional<FluidoTipoIngreso> fluidoTipoIngresoNew = service.findById((user.getId()));
        if (fluidoTipoIngresoNew.isPresent()){
            return new ResponseEntity<>(fluidoTipoIngresoNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<FluidoTipoIngreso> update(@Valid @RequestBody FluidoTipoIngreso fluidoTipoIngreso){
        Optional<FluidoTipoIngreso> fluidoTipoIngresoOld = service.findById(fluidoTipoIngreso.getId());
        FluidoTipoIngreso faneaNew = null;

        if(fluidoTipoIngresoOld.isPresent()){
            faneaNew = service.update(fluidoTipoIngreso);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
