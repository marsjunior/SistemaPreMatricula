package br.edu.ufcg.preMatricula.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufcg.preMatricula.exception.RegisterNotFoundException;
import br.edu.ufcg.preMatricula.model.DisciplinaAlocadaNote;
import br.edu.ufcg.preMatricula.repository.DisciplinaAlocadaRepository;

@Service
public class DisciplinaAlocadaService {
	
	@Autowired
	private DisciplinaAlocadaRepository disciplinaAlocada;
	
	public List<DisciplinaAlocadaNote> getAll() {
		return disciplinaAlocada.findAll();
	}
	
	public DisciplinaAlocadaNote getById(Long id) {
		Optional<DisciplinaAlocadaNote> optTodo = disciplinaAlocada.findById(id);

		if (!optTodo.isPresent()) {
			throw new RegisterNotFoundException("Todo don't exists");
		}

		return optTodo.get();
	}
	
	public DisciplinaAlocadaNote save(DisciplinaAlocadaNote todo) {
		disciplinaAlocada.save(todo);
		return todo;
	}
	
	public List<DisciplinaAlocadaNote> getByDisciplina(String codigo){
		return disciplinaAlocada.findCodigoDisciplina(codigo);
	}
	
	public List<DisciplinaAlocadaNote> getByMatricula(String codigo){
		return disciplinaAlocada.findMatricula(codigo);
	}
	
	public DisciplinaAlocadaNote update(DisciplinaAlocadaNote disciplina, Long id) {
		Optional<DisciplinaAlocadaNote> optDisciplina = disciplinaAlocada.findById(id);

		if (!optDisciplina.isPresent()) {
			throw new RegisterNotFoundException("Disciplina não existe.");
		}

		DisciplinaAlocadaNote newDisciplina = optDisciplina.get();
		newDisciplina.setCodigoDisciplina(disciplina.getCodigoDisciplina());
		newDisciplina.setMatricula(disciplina.getMatricula());

		disciplinaAlocada.save(newDisciplina);

		return newDisciplina;
	}
	
	public DisciplinaAlocadaNote delete(Long id) {
		Optional<DisciplinaAlocadaNote> optTodo = disciplinaAlocada.findById(id);

		if (!optTodo.isPresent()) {
			throw new RegisterNotFoundException("Todo don't exists");
		}

		DisciplinaAlocadaNote todo = optTodo.get();
		disciplinaAlocada.delete(todo);

		return todo;
	}
}
