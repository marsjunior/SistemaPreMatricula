package br.edu.ufcg.preMatricula.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufcg.preMatricula.exception.NaoAutorizadoException;
import br.edu.ufcg.preMatricula.model.RequestNote;
import br.edu.ufcg.preMatricula.model.UsuarioNote;
import br.edu.ufcg.preMatricula.service.UsuarioService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	LoginController loginController;

	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public List<UsuarioNote> getAll(@RequestHeader(required = true, value = LoginController.TOKEN_ID) String token) throws UnsupportedOperationException, IOException {
		
		RequestNote info = loginController.login(token);
		if(info.getEmail() == null || !info.getHd().equals("ccc.ufcg.edu.br")){
			throw new NaoAutorizadoException("Acesso negado!");
		}else if(!usuarioService.getByToken(token).isAdmin()){
			throw new NaoAutorizadoException("Você não tem autorização de realizar está ação!");
		}
		return usuarioService.getUsers();
	}
	
	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public UsuarioNote save(@RequestBody UsuarioNote usuario, @RequestHeader(required = true, value = LoginController.TOKEN_ID) String token) throws UnsupportedOperationException, IOException {
		
		RequestNote info = loginController.login(token);
		if(info.getEmail() == null || !info.getHd().equals("ccc.ufcg.edu.br")){
			throw new NaoAutorizadoException("Email Invalido!");
		}
		usuario.setIdToken(token);
		usuarioService.save(usuario);
		return usuario;
	}
	
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioNote> getUsuario(@PathVariable("id") String id) {
		UsuarioNote todo = usuarioService.getUsuarioId(id);
		return new ResponseEntity<UsuarioNote>(todo, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<UsuarioNote> deleteUsuario(@PathVariable("id") String id) {
		UsuarioNote todo = usuarioService.delete(id);
		return new ResponseEntity<UsuarioNote>(todo, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/usuario/email/{email}", method = RequestMethod.GET)
	public UsuarioNote getDisciplinaCodigo(@PathVariable("email") String email) {
		return usuarioService.getUsuario(email);
	}
	

	

}
