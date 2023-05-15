package cl.cummins.dbm.service;


import cl.cummins.dbm.dto.UsuarioDto;
import cl.cummins.dbm.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import cl.cummins.dbm.dto.TokenDto;
import cl.cummins.dbm.security.JwtUtil;

import java.util.Optional;

@Component
public class LoginService {
	private PasswordEncoder passwordEncoder;
	private JwtUtil jwtUtil;

	@Autowired
	private UsuarioService service;

	public LoginService(PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
		this.passwordEncoder = passwordEncoder;
		this.jwtUtil = jwtUtil;
	}
	
	
	public TokenDto login(Integer userName, String password) {
		
		try {

			Optional<Usuario> usuario = service.findByUsuario(userName);
			UsuarioDto user = new UsuarioDto();

			user.setId(usuario.get().getId());
			user.setNombres(usuario.get().getNombres());
			user.setApellidos(usuario.get().getApellidos());
			user.setE(usuario.get().getE());
			user.setU(usuario.get().getU());
			user.setCorreo_electronico(usuario.get().getCorreo_electronico());


			if(this.passwordEncoder.matches(password, usuario.get().getPin())){
				TokenDto tokenDto =  new TokenDto();
				tokenDto.setToken(this.jwtUtil.generateJwtToken(user.toString()));
				tokenDto.setRefreshToken(this.jwtUtil.generateRefreshToken(user.toString()));
				return tokenDto;
			}else {
				throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario o password incorrecto");
			}
			
		} catch(UsernameNotFoundException unnfe) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario o password incorrecto");			
		}
	}
	
}
