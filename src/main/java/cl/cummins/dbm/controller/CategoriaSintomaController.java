package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.CategoriaSintoma;
import cl.cummins.dbm.service.CategoriaSintomaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoriasintoma")
public class CategoriaSintomaController {
    @Autowired
    private CategoriaSintomaService service;

    @GetMapping
    public ResponseEntity<List<CategoriaSintoma>> findAll(){
        List<CategoriaSintoma> categoriaSintomas = service.findAll();
        return new ResponseEntity<>(categoriaSintomas, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CategoriaSintoma> findById(@PathVariable("id") Long id){
        CategoriaSintoma categoriaSintoma = service.findById(id).orElseThrow(() -> new ModelNotFoundException("Categoria Sintoma no encontrado"));
        return new ResponseEntity<>(categoriaSintoma, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<CategoriaSintoma> create(@Valid @RequestBody CategoriaSintoma categoriaSintoma){
        CategoriaSintoma user = service.create(categoriaSintoma);
        Optional<CategoriaSintoma> categoriaSintomaNew = service.findById((user.getId()));
        if (categoriaSintomaNew.isPresent()){
            return new ResponseEntity<>(categoriaSintomaNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<CategoriaSintoma> update(@Valid @RequestBody CategoriaSintoma categoriaSintoma){
        Optional<CategoriaSintoma> categoriaSintomaOld = service.findById(categoriaSintoma.getId());
        CategoriaSintoma faneaNew = null;

        if(categoriaSintomaOld.isPresent()){
            faneaNew = service.update(categoriaSintoma);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
