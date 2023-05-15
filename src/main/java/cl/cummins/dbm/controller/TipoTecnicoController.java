package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.TipoTecnico;
import cl.cummins.dbm.service.TipoTecnicoService;
import cl.cummins.dbm.service.TipoTecnicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipotecnico")
public class TipoTecnicoController {
    @Autowired
    private TipoTecnicoService service;

    @GetMapping
    public ResponseEntity<List<TipoTecnico>> findAll(){
        List<TipoTecnico> tipoTecnicos = service.findAll();
        return new ResponseEntity<>(tipoTecnicos, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TipoTecnico> findById(@PathVariable("id") Long id){
        TipoTecnico tipoTecnico = service.findById(id).orElseThrow(() -> new ModelNotFoundException("TipoTecnico no encontrado"));
        return new ResponseEntity<>(tipoTecnico, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<TipoTecnico> create(@Valid @RequestBody TipoTecnico tipoTecnico){
        TipoTecnico user = service.create(tipoTecnico);
        Optional<TipoTecnico> tipoTecnicoNew = service.findById((user.getId()));
        if (tipoTecnicoNew.isPresent()){
            return new ResponseEntity<>(tipoTecnicoNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<TipoTecnico> update(@Valid @RequestBody TipoTecnico tipoTecnico){
        Optional<TipoTecnico> tipoTecnicoOld = service.findById(tipoTecnico.getId());
        TipoTecnico faneaNew = null;

        if(tipoTecnicoOld.isPresent()){
            faneaNew = service.update(tipoTecnico);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
