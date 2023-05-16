package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.MotivoLlamado;
import cl.cummins.dbm.service.MotivoLlamadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/motivollamado")
public class MotivoLlamadoController {
    @Autowired
    private MotivoLlamadoService service;

    @GetMapping
    public ResponseEntity<List<MotivoLlamado>> findAll(){
        List<MotivoLlamado> motivoLlamados = service.findAll();
        return new ResponseEntity<>(motivoLlamados, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<MotivoLlamado> findById(@PathVariable("id") Long id){
        MotivoLlamado motivoLlamado = service.findById(id).orElseThrow(() -> new ModelNotFoundException("Motivo llamado no encontrado"));
        return new ResponseEntity<>(motivoLlamado, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<MotivoLlamado> create(@Valid @RequestBody MotivoLlamado motivoLlamado){
        MotivoLlamado user = service.create(motivoLlamado);
        Optional<MotivoLlamado> motivoLlamadoNew = service.findById((user.getId()));
        if (motivoLlamadoNew.isPresent()){
            return new ResponseEntity<>(motivoLlamadoNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<MotivoLlamado> update(@Valid @RequestBody MotivoLlamado motivoLlamado){
        Optional<MotivoLlamado> motivoLlamadoOld = service.findById(motivoLlamado.getId());
        MotivoLlamado faneaNew = null;

        if(motivoLlamadoOld.isPresent()){
            faneaNew = service.update(motivoLlamado);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
