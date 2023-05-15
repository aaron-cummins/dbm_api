package cl.cummins.dbm.controller;

import cl.cummins.dbm.exception.ModelNotFoundException;
import cl.cummins.dbm.model.Usuario;
import cl.cummins.dbm.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        List<Usuario> usuarios = service.findAll();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable("id") Long id){
        Usuario usuario = service.findById(id).orElseThrow(() -> new ModelNotFoundException("Usuario no encontrado"));
        return new ResponseEntity<>(usuario, HttpStatus.OK);

    }

    @GetMapping("/login/{correo}")
    public ResponseEntity<Usuario> findById(@PathVariable("correo") String correo){
        Usuario usuario = service.findByCorreo(correo).orElseThrow(() -> new ModelNotFoundException("Usuario no encontrado"));
        return new ResponseEntity<>(usuario, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Usuario> create(@Valid @RequestBody Usuario usuario){
        Usuario user = service.create(usuario);
        Optional<Usuario> usuarioNew = service.findById((user.getId()));
        if (usuarioNew.isPresent()){
            return new ResponseEntity<>(usuarioNew.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<Usuario> update(@Valid @RequestBody Usuario usuario){
        Optional<Usuario> usuarioOld = service.findById(usuario.getId());
        Usuario usuarioNew = null;

        if(usuarioOld.isPresent()){
            usuarioNew = service.update(usuario);

            return new ResponseEntity<>(usuarioNew, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


}
