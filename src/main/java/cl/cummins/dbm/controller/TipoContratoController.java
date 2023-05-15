package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.TipoContrato;
import cl.cummins.dbm.service.TipoContratoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipocontrato")
public class TipoContratoController {
    @Autowired
    private TipoContratoService service;

    @GetMapping
    public ResponseEntity<List<TipoContrato>> findAll(){
        List<TipoContrato> tipoContratos = service.findAll();
        return new ResponseEntity<>(tipoContratos, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TipoContrato> findById(@PathVariable("id") Long id){
        TipoContrato tipoContrato = service.findById(id).orElseThrow(() -> new ModelNotFoundException("TipoContrato no encontrado"));
        return new ResponseEntity<>(tipoContrato, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<TipoContrato> create(@Valid @RequestBody TipoContrato tipoContrato){
        TipoContrato user = service.create(tipoContrato);
        Optional<TipoContrato> tipoContratoNew = service.findById((user.getId()));
        if (tipoContratoNew.isPresent()){
            return new ResponseEntity<>(tipoContratoNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<TipoContrato> update(@Valid @RequestBody TipoContrato tipoContrato){
        Optional<TipoContrato> tipoContratoOld = service.findById(tipoContrato.getId());
        TipoContrato faneaNew = null;

        if(tipoContratoOld.isPresent()){
            faneaNew = service.update(tipoContrato);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
