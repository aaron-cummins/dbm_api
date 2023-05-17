package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.IntervencionFechas;
import cl.cummins.dbm.service.IntervencionFechasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/intervencionfechas")
public class IntervencionFechasController {
    @Autowired
    private IntervencionFechasService service;

    @GetMapping
    public ResponseEntity<List<IntervencionFechas>> findAll(){
        List<IntervencionFechas> intervencionFechass = service.findAll();
        return new ResponseEntity<>(intervencionFechass, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<IntervencionFechas> findById(@PathVariable("id") Long id){
        IntervencionFechas intervencionFechas = service.findById(id).orElseThrow(() -> new ModelNotFoundException("Intervencion Fechas no encontrado"));
        return new ResponseEntity<>(intervencionFechas, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<IntervencionFechas> create(@Valid @RequestBody IntervencionFechas intervencionFechas){
        IntervencionFechas user = service.create(intervencionFechas);
        Optional<IntervencionFechas> intervencionFechasNew = service.findById((user.getId()));
        if (intervencionFechasNew.isPresent()){
            return new ResponseEntity<>(intervencionFechasNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<IntervencionFechas> update(@Valid @RequestBody IntervencionFechas intervencionFechas){
        Optional<IntervencionFechas> intervencionFechasOld = service.findById(intervencionFechas.getId());
        IntervencionFechas faneaNew = null;

        if(intervencionFechasOld.isPresent()){
            faneaNew = service.update(intervencionFechas);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
