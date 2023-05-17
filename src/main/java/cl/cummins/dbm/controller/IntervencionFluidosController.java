package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.IntervencionFluidos;
import cl.cummins.dbm.service.IntervencionFluidosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/intervencionfluidos")
public class IntervencionFluidosController {
    @Autowired
    private IntervencionFluidosService service;

    @GetMapping
    public ResponseEntity<List<IntervencionFluidos>> findAll(){
        List<IntervencionFluidos> intervencionFluidoss = service.findAll();
        return new ResponseEntity<>(intervencionFluidoss, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<IntervencionFluidos> findById(@PathVariable("id") Long id){
        IntervencionFluidos intervencionFluidos = service.findById(id).orElseThrow(() -> new ModelNotFoundException("Intervencion Fluidos no encontrado"));
        return new ResponseEntity<>(intervencionFluidos, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<IntervencionFluidos> create(@Valid @RequestBody IntervencionFluidos intervencionFluidos){
        IntervencionFluidos user = service.create(intervencionFluidos);
        Optional<IntervencionFluidos> intervencionFluidosNew = service.findById((user.getId()));
        if (intervencionFluidosNew.isPresent()){
            return new ResponseEntity<>(intervencionFluidosNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<IntervencionFluidos> update(@Valid @RequestBody IntervencionFluidos intervencionFluidos){
        Optional<IntervencionFluidos> intervencionFluidosOld = service.findById(intervencionFluidos.getId());
        IntervencionFluidos faneaNew = null;

        if(intervencionFluidosOld.isPresent()){
            faneaNew = service.update(intervencionFluidos);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
