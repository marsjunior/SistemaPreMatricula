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
import br.edu.ufcg.preMatricula.exception.RegisterNotFoundException;
import br.edu.ufcg.preMatricula.model.DisciplinaAlocadaNote;
import br.edu.ufcg.preMatricula.model.UsuarioNote;
import br.edu.ufcg.preMatricula.service.DisciplinaAlocadaService;
import br.edu.ufcg.preMatricula.service.UsuarioService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class DisciplinaAlocadaController {

	@Autowired
	DisciplinaAlocadaService disciplinaAlocada;
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(value = "/disciplinaAlocada", method = RequestMethod.GET)
	public List<DisciplinaAlocadaNote> getAll(@RequestHeader(required = true, value = LoginController.TOKEN_ID) String token ) {
		
		UsuarioNote usuario = usuarioService.getByToken(token);
		if(!usuario.isAdmin()){
			throw new NaoAutorizadoException("Usuario Não Autorizado");
		}
		return disciplinaAlocada.getAll();
	}
	
	@RequestMapping(value = "/disciplinaAlocada/aluno", method = RequestMethod.GET)
	public List<DisciplinaAlocadaNote> getById(@RequestHeader(required = true, value = LoginController.TOKEN_ID) String token ) {
		UsuarioNote usuario = usuarioService.getByToken(token);
		String matricula = usuario.getMatricula();
		List<DisciplinaAlocadaNote> disciplinasAlocadas = disciplinaAlocada.getByMatricula(matricula);
		return disciplinasAlocadas;
	}
	
	@RequestMapping(value = "/disciplinaAlocada/disciplina/{codigo}", method = RequestMethod.GET)
	public List<DisciplinaAlocadaNote> getByAluno(@PathVariable("codigo") String codigo, @RequestHeader(required = true, value = LoginController.TOKEN_ID) String token ) {
		
		UsuarioNote usuario = usuarioService.getByToken(token);
		if(!usuario.isAdmin()){
			throw new NaoAutorizadoException("Usuario Não Autorizado");
		}
		return disciplinaAlocada.getByDisciplina(codigo);
	}
	
	@RequestMapping(value = "/disciplinaAlocada", method = RequestMethod.POST)
	public DisciplinaAlocadaNote save(@RequestBody DisciplinaAlocadaNote disciplina, @RequestHeader(required = true, value = LoginController.TOKEN_ID) String token ) {
		UsuarioNote usuario = usuarioService.getByToken(token);
		return disciplinaAlocada.save(disciplina);
	}
	
	@RequestMapping(value = "/disciplinaAlocada/{id}", method = RequestMethod.PUT)
	public ResponseEntity<DisciplinaAlocadaNote> update(@PathVariable("id") Long id, @RequestBody DisciplinaAlocadaNote todo, @RequestHeader(required = true, value = LoginController.TOKEN_ID) String token ) {
		UsuarioNote usuario = usuarioService.getByToken(token);
		if(disciplinaAlocada.getById(id).getCodigoDisciplina() != usuario.getMatricula()){
			throw new NaoAutorizadoException("Voce não está autorizado");
		}
		DisciplinaAlocadaNote updatedTodo = disciplinaAlocada.update(todo, id);
		return new ResponseEntity<DisciplinaAlocadaNote>(updatedTodo, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/disciplinaAlocada/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<DisciplinaAlocadaNote> delete(@PathVariable("id") Long id, @RequestHeader(required = true, value = LoginController.TOKEN_ID) String token ) {
		UsuarioNote usuario = usuarioService.getByToken(token);
		if(disciplinaAlocada.getById(id).getCodigoDisciplina() != usuario.getMatricula()){
			throw new NaoAutorizadoException("Voce não está autorizado");
		}
		DisciplinaAlocadaNote todo = disciplinaAlocada.delete(id);
		return new ResponseEntity<DisciplinaAlocadaNote>(todo, HttpStatus.OK);
	}
}
