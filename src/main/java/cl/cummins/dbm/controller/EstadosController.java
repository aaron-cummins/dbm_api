package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.Estados;
import cl.cummins.dbm.service.EstadosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estados")
public class EstadosController {
    @Autowired
    private EstadosService service;

    @GetMapping
    public ResponseEntity<List<Estados>> findAll(){
        List<Estados> estadoss = service.findAll();
        return new ResponseEntity<>(estadoss, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Estados> findById(@PathVariable("id") Long id){
        Estados estados = service.findById(id).orElseThrow(() -> new ModelNotFoundException("Estados no encontrado"));
        return new ResponseEntity<>(estados, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Estados> create(@Valid @RequestBody Estados estados){
        Estados user = service.create(estados);
        Optional<Estados> categoriaEstadosNew = service.findById((user.getId()));
        if (categoriaEstadosNew.isPresent()){
            return new ResponseEntity<>(categoriaEstadosNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<Estados> update(@Valid @RequestBody Estados estados){
        Optional<Estados> categoriaEstadosOld = service.findById(estados.getId());
        Estados faneaNew = null;

        if(categoriaEstadosOld.isPresent()){
            faneaNew = service.update(estados);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
