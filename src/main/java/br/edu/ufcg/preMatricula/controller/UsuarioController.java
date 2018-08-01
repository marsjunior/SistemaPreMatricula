package br.edu.ufcg.preMatricula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufcg.preMatricula.model.DisciplinaNote;
import br.edu.ufcg.preMatricula.model.UsuarioNote;
import br.edu.ufcg.preMatricula.service.DisciplinaService;
import br.edu.ufcg.preMatricula.service.UsuarioService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;

	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public List<UsuarioNote> getAll() {
		return usuarioService.getUsers();
	}
	
	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public UsuarioNote save(@RequestBody UsuarioNote usuario) {
		return usuarioService.save(usuario);
	}
	
	@RequestMapping(value = "/usuario/delete/{id}", method = RequestMethod.GET)
	public UsuarioNote deleteUsuario(@PathVariable("id") String id) {
		return usuarioService.delete(id);
	}
	
	@RequestMapping(value = "/usuario/{email}", method = RequestMethod.GET)
	public UsuarioNote getDisciplinaCodigo(@PathVariable("email") String email) {
		return usuarioService.getUsuario(email);
	}
	

	

}
