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

import br.edu.ufcg.preMatricula.model.DisciplinaAlocadaNote;
import br.edu.ufcg.preMatricula.service.DisciplinaAlocadaService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class DisciplinaAlocadaController {

	@Autowired
	DisciplinaAlocadaService disciplinaAlocada;
	
	@RequestMapping(value = "/disciplinaAlocada", method = RequestMethod.GET)
	public List<DisciplinaAlocadaNote> getAll() {
		return disciplinaAlocada.getAll();
	}
	
	@RequestMapping(value = "/disciplinaAlocada/{id}", method = RequestMethod.GET)
	public DisciplinaAlocadaNote getById(@PathVariable("id") Long id) {
		return disciplinaAlocada.getById(id);
	}
	
	@RequestMapping(value = "/disciplinaAlocada", method = RequestMethod.POST)
	public DisciplinaAlocadaNote save(@RequestBody DisciplinaAlocadaNote disciplina) {
		return disciplinaAlocada.save(disciplina);
	}
	
	@RequestMapping(value = "/disciplinaAlocada/{id}", method = RequestMethod.PUT)
	public ResponseEntity<DisciplinaAlocadaNote> update(@PathVariable("id") Long id, @RequestBody DisciplinaAlocadaNote todo) {
		DisciplinaAlocadaNote updatedTodo = disciplinaAlocada.update(todo, id);
		return new ResponseEntity<DisciplinaAlocadaNote>(updatedTodo, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/disciplinaAlocada/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<DisciplinaAlocadaNote> delete(@PathVariable("id") Long id) {
		DisciplinaAlocadaNote todo = disciplinaAlocada.delete(id);
		return new ResponseEntity<DisciplinaAlocadaNote>(todo, HttpStatus.OK);
	}
}
