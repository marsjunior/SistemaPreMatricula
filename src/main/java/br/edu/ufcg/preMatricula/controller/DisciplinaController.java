package br.edu.ufcg.preMatricula.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufcg.preMatricula.model.DisciplinaNote;
import br.edu.ufcg.preMatricula.service.DisciplinaService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class DisciplinaController {

	@Autowired
	DisciplinaService disciplinaService;

	@RequestMapping(value = "/disciplina", method = RequestMethod.GET)
	public List<DisciplinaNote> getAll() {
		return disciplinaService.getAll();
	}

	@RequestMapping(value = "/disciplina", method = RequestMethod.POST)
	public DisciplinaNote save(@RequestBody DisciplinaNote disciplina) {
		return disciplinaService.save(disciplina);
	}

	@RequestMapping(value = "/disciplina/{id}", method = RequestMethod.GET)
	public DisciplinaNote getById(@PathVariable("id") Long id) {
		return disciplinaService.getById(id);
	}

	@RequestMapping(value = "/disciplina/{id}", method = RequestMethod.PUT)
	public ResponseEntity<DisciplinaNote> update(@PathVariable("id") Long id, @RequestBody DisciplinaNote todo) {
		DisciplinaNote updatedTodo = disciplinaService.update(todo, id);
		return new ResponseEntity<DisciplinaNote>(updatedTodo, HttpStatus.OK);
	}

	@RequestMapping(value = "/disciplina/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<DisciplinaNote> delete(@PathVariable("id") Long id) {
		DisciplinaNote todo = disciplinaService.delete(id);
		return new ResponseEntity<DisciplinaNote>(todo, HttpStatus.OK);
	}
	
}
