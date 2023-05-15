package cl.cummins.dbm.controller;

import cl.cummins.dbm.dto.TokenDto;
import cl.cummins.dbm.service.LoginService;
import cl.cummins.dbm.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	private LoginService loginService;

	@Autowired
	private UsuarioService usuarioService;
	
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	
	@PostMapping(path = "/login", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public TokenDto login(@RequestParam Integer username, @RequestParam String password) {

		return this.loginService.login(username, password);
	}

}
