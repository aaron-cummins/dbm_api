package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.TipoSalida;
import cl.cummins.dbm.service.TipoSalidaService;
import cl.cummins.dbm.service.TipoSalidaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tiposalida")
public class TipoSalidaController {
    @Autowired
    private TipoSalidaService service;

    @GetMapping
    public ResponseEntity<List<TipoSalida>> findAll(){
        List<TipoSalida> tipoSalidas = service.findAll();
        return new ResponseEntity<>(tipoSalidas, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TipoSalida> findById(@PathVariable("id") Long id){
        TipoSalida tipoSalida = service.findById(id).orElseThrow(() -> new ModelNotFoundException("TipoSalida no encontrado"));
        return new ResponseEntity<>(tipoSalida, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<TipoSalida> create(@Valid @RequestBody TipoSalida tipoSalida){
        TipoSalida user = service.create(tipoSalida);
        Optional<TipoSalida> tipoSalidaNew = service.findById((user.getId()));
        if (tipoSalidaNew.isPresent()){
            return new ResponseEntity<>(tipoSalidaNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<TipoSalida> update(@Valid @RequestBody TipoSalida tipoSalida){
        Optional<TipoSalida> tipoSalidaOld = service.findById(tipoSalida.getId());
        TipoSalida faneaNew = null;

        if(tipoSalidaOld.isPresent()){
            faneaNew = service.update(tipoSalida);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
