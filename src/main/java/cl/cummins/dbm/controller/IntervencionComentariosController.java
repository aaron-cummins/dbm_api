package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.IntervencionComentarios;
import cl.cummins.dbm.service.IntervencionComentariosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/intervencioncomentarios")
public class IntervencionComentariosController {
    @Autowired
    private IntervencionComentariosService service;

    @GetMapping
    public ResponseEntity<List<IntervencionComentarios>> findAll(){
        List<IntervencionComentarios> intervencionComentarioss = service.findAll();
        return new ResponseEntity<>(intervencionComentarioss, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<IntervencionComentarios> findById(@PathVariable("id") Long id){
        IntervencionComentarios intervencionComentarios = service.findById(id).orElseThrow(() -> new ModelNotFoundException("Intervencion Comentarios no encontrado"));
        return new ResponseEntity<>(intervencionComentarios, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<IntervencionComentarios> create(@Valid @RequestBody IntervencionComentarios intervencionComentarios){
        IntervencionComentarios user = service.create(intervencionComentarios);
        Optional<IntervencionComentarios> intervencionComentariosNew = service.findById((user.getId()));
        if (intervencionComentariosNew.isPresent()){
            return new ResponseEntity<>(intervencionComentariosNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<IntervencionComentarios> update(@Valid @RequestBody IntervencionComentarios intervencionComentarios){
        Optional<IntervencionComentarios> intervencionComentariosOld = service.findById(intervencionComentarios.getId());
        IntervencionComentarios faneaNew = null;

        if(intervencionComentariosOld.isPresent()){
            faneaNew = service.update(intervencionComentarios);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
