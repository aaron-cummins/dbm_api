package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.DeltaItem;
import cl.cummins.dbm.service.DeltaItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/deltaitem")
public class DeltaItemController {
    @Autowired
    private DeltaItemService service;

    @GetMapping
    public ResponseEntity<List<DeltaItem>> findAll(){
        List<DeltaItem> deltaItems = service.findAll();
        return new ResponseEntity<>(deltaItems, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<DeltaItem> findById(@PathVariable("id") Long id){
        DeltaItem deltaItem = service.findById(id).orElseThrow(() -> new ModelNotFoundException("Delta Item no encontrado"));
        return new ResponseEntity<>(deltaItem, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<DeltaItem> create(@Valid @RequestBody DeltaItem deltaItem){
        DeltaItem user = service.create(deltaItem);
        Optional<DeltaItem> deltaItemNew = service.findById((user.getId()));
        if (deltaItemNew.isPresent()){
            return new ResponseEntity<>(deltaItemNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<DeltaItem> update(@Valid @RequestBody DeltaItem deltaItem){
        Optional<DeltaItem> deltaItemOld = service.findById(deltaItem.getId());
        DeltaItem faneaNew = null;

        if(deltaItemOld.isPresent()){
            faneaNew = service.update(deltaItem);

            return new ResponseEntity<>(faneaNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
