package br.edu.ufcg.preMatricula.controller;

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
import br.edu.ufcg.preMatricula.model.DisciplinaNote;
import br.edu.ufcg.preMatricula.model.UsuarioNote;
import br.edu.ufcg.preMatricula.service.DisciplinaService;
import br.edu.ufcg.preMatricula.service.UsuarioService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class DisciplinaController {

	@Autowired
	private DisciplinaService disciplinaService;
	
	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/disciplina", method = RequestMethod.GET)
	public List<DisciplinaNote> getAll(@RequestHeader(required = true, value = LoginController.TOKEN_ID) String token) {
		UsuarioNote usuario = usuarioService.getByToken(token);
		if(usuario.getNome() == null){
			throw new NaoAutorizadoException("Voce não está autorizado");
		}
		return disciplinaService.getAll();
	}

	@RequestMapping(value = "/disciplina/{id}", method = RequestMethod.GET)
	public DisciplinaNote getById(@PathVariable("id") String id, @RequestHeader(required = true, value = LoginController.TOKEN_ID) String token) {
		UsuarioNote usuario = usuarioService.getByToken(token);
		if(usuario.getNome() == null){
			throw new NaoAutorizadoException("Voce não está autorizado");
		}
		return disciplinaService.getById(id);
	}

	@RequestMapping(value = "/disciplina", method = RequestMethod.POST)
	public DisciplinaNote save(@RequestBody DisciplinaNote disciplina, @RequestHeader(required = true, value = LoginController.TOKEN_ID) String token ) {
		
		UsuarioNote usuario = usuarioService.getByToken(token);
		if(usuario == null || !usuario.isAdmin()){
			throw new NaoAutorizadoException("Usuario Não Autorizado");
		}
		return disciplinaService.save(disciplina);
	}

	@RequestMapping(value = "/disciplina/{id}", method = RequestMethod.PUT)
	public ResponseEntity<DisciplinaNote> update(@PathVariable("id") String id, @RequestBody DisciplinaNote todo, @RequestHeader(required = true, value = LoginController.TOKEN_ID) String token ) {
		UsuarioNote usuario = usuarioService.getByToken(token);
		if(usuario != null && usuario.isAdmin()){
			DisciplinaNote updatedTodo = disciplinaService.update(todo, id);
			return new ResponseEntity<DisciplinaNote>(updatedTodo, HttpStatus.OK);
		}
		throw new NaoAutorizadoException("Usuario Não Autorizado");
		
	}

	@RequestMapping(value = "/disciplina/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<DisciplinaNote> delete(@PathVariable("id") String id, @RequestHeader(required = true, value = LoginController.TOKEN_ID) String token ) {
		
		UsuarioNote usuario = usuarioService.getByToken(token);
		if(usuario == null || !usuario.isAdmin()){
			throw new NaoAutorizadoException("Usuario Não Autorizado");
		}
		DisciplinaNote todo = disciplinaService.delete(id);
		return new ResponseEntity<DisciplinaNote>(todo, HttpStatus.OK);
	}
}
