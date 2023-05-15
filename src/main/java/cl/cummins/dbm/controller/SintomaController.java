package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.Sintoma;
import cl.cummins.dbm.service.SintomaCategoriaService;
import cl.cummins.dbm.service.SintomaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sintoma")
public class SintomaController {

    @Autowired
    private SintomaService service;

    @GetMapping
    public ResponseEntity<List<Sintoma>> findAll(){
        List<Sintoma> sintomas = service.findAll();
        return new ResponseEntity<>(sintomas, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Sintoma> findById(@PathVariable("id") Long id){
        Sintoma sintoma = service.findById(id).orElseThrow(() -> new ModelNotFoundException("Sintoma no encontrado"));
        return new ResponseEntity<>(sintoma, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Sintoma> create(@Valid @RequestBody Sintoma sintoma){
        Sintoma user = service.create(sintoma);
        Optional<Sintoma> categoriaSintomaNew = service.findById((user.getId()));
        if (categoriaSintomaNew.isPresent()){
            return new ResponseEntity<>(categoriaSintomaNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<Sintoma> update(@Valid @RequestBody Sintoma sintoma){
        Optional<Sintoma> categoriaSintomaOld = service.findById(sintoma.getId());
        Sintoma faneaNew = null;

        if(categoriaSintomaOld.isPresent()){
            faneaNew = service.update(sintoma);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
