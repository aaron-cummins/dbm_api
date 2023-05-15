package cl.cummins.dbm.service;

import cl.cummins.dbm.model.Usuario;
import cl.cummins.dbm.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements ICRUDService<Usuario> {

    @Autowired
    private IUsuarioRepository usuarioRepo;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepo.findAll();
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepo.findById(id);
    }

    @Override
    public Usuario create(Usuario model) {
        return usuarioRepo.saveAndFlush(model);
    }

    @Override
    public Usuario update(Usuario model) {
        return usuarioRepo.save(model);
    }

    @Override
    public void delete(Long id) {
        usuarioRepo.deleteById(id);
    }

    public Optional<Usuario> findByCorreo(String correo){
        return usuarioRepo.getCorreo(correo);
    }

    public Optional<Usuario> findByUsuarioPin(String usuario, String pin) {
        return usuarioRepo.getByUsuarioAndPin(usuario, pin);
    }

    public Optional<Usuario> findByUsuario(Integer usuario) {
        return usuarioRepo.getByUsuario(usuario);
    }
}
