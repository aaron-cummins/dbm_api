package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.SintomaCategoria;
import cl.cummins.dbm.service.SintomaCategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoriasintoma")
public class SintomaCategoriaController {
    @Autowired
    private SintomaCategoriaService service;

    @GetMapping
    public ResponseEntity<List<SintomaCategoria>> findAll(){
        List<SintomaCategoria> sintomaCategorias = service.findAll();
        return new ResponseEntity<>(sintomaCategorias, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<SintomaCategoria> findById(@PathVariable("id") Long id){
        SintomaCategoria sintomaCategoria = service.findById(id).orElseThrow(() -> new ModelNotFoundException("Categoria Sintoma no encontrado"));
        return new ResponseEntity<>(sintomaCategoria, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<SintomaCategoria> create(@Valid @RequestBody SintomaCategoria sintomaCategoria){
        SintomaCategoria user = service.create(sintomaCategoria);
        Optional<SintomaCategoria> categoriaSintomaNew = service.findById((user.getId()));
        if (categoriaSintomaNew.isPresent()){
            return new ResponseEntity<>(categoriaSintomaNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<SintomaCategoria> update(@Valid @RequestBody SintomaCategoria sintomaCategoria){
        Optional<SintomaCategoria> categoriaSintomaOld = service.findById(sintomaCategoria.getId());
        SintomaCategoria faneaNew = null;

        if(categoriaSintomaOld.isPresent()){
            faneaNew = service.update(sintomaCategoria);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
