package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.IntervencionDecisiones;
import cl.cummins.dbm.service.IntervencionDecisionesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/intervenciondecisiones")
public class intervencionDecisionesController {
    @Autowired
    private IntervencionDecisionesService service;

    @GetMapping
    public ResponseEntity<List<IntervencionDecisiones>> findAll(){
        List<IntervencionDecisiones> intervencionDecisioness = service.findAll();
        return new ResponseEntity<>(intervencionDecisioness, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<IntervencionDecisiones> findById(@PathVariable("id") Long id){
        IntervencionDecisiones intervencionDecisiones = service.findById(id).orElseThrow(() -> new ModelNotFoundException("Intervencion Decisiones no encontrado"));
        return new ResponseEntity<>(intervencionDecisiones, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<IntervencionDecisiones> create(@Valid @RequestBody IntervencionDecisiones intervencionDecisiones){
        IntervencionDecisiones user = service.create(intervencionDecisiones);
        Optional<IntervencionDecisiones> intervencionDecisionesNew = service.findById((user.getId()));
        if (intervencionDecisionesNew.isPresent()){
            return new ResponseEntity<>(intervencionDecisionesNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<IntervencionDecisiones> update(@Valid @RequestBody IntervencionDecisiones intervencionDecisiones){
        Optional<IntervencionDecisiones> intervencionDecisionesOld = service.findById(intervencionDecisiones.getId());
        IntervencionDecisiones faneaNew = null;

        if(intervencionDecisionesOld.isPresent()){
            faneaNew = service.update(intervencionDecisiones);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
