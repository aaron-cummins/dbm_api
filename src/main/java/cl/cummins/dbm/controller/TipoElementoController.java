package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.TipoElemento;
import cl.cummins.dbm.service.TipoElementoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipoelemento")
public class TipoElementoController {
    @Autowired
    private TipoElementoService service;

    @GetMapping
    public ResponseEntity<List<TipoElemento>> findAll(){
        List<TipoElemento> tipoElementos = service.findAll();
        return new ResponseEntity<>(tipoElementos, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TipoElemento> findById(@PathVariable("id") Long id){
        TipoElemento tipoElemento = service.findById(id).orElseThrow(() -> new ModelNotFoundException("TipoElemento no encontrado"));
        return new ResponseEntity<>(tipoElemento, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<TipoElemento> create(@Valid @RequestBody TipoElemento tipoElemento){
        TipoElemento user = service.create(tipoElemento);
        Optional<TipoElemento> tipoElementoNew = service.findById((user.getId()));
        if (tipoElementoNew.isPresent()){
            return new ResponseEntity<>(tipoElementoNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<TipoElemento> update(@Valid @RequestBody TipoElemento tipoElemento){
        Optional<TipoElemento> tipoElementoOld = service.findById(tipoElemento.getId());
        TipoElemento faneaNew = null;

        if(tipoElementoOld.isPresent()){
            faneaNew = service.update(tipoElemento);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
