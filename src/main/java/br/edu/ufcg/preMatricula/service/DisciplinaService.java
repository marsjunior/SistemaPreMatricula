package br.edu.ufcg.preMatricula.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufcg.preMatricula.exception.RegisterNotFoundException;
import br.edu.ufcg.preMatricula.model.DisciplinaNote;
import br.edu.ufcg.preMatricula.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository DisciplinaRepository;

	public List<DisciplinaNote> getAll() {
		return DisciplinaRepository.findAll();
	}

	public DisciplinaNote getById(String id) {
		Optional<DisciplinaNote> optTodo = DisciplinaRepository.findById(id);

		if (!optTodo.isPresent()) {
			throw new RegisterNotFoundException("Todo don't exists");
		}

		return optTodo.get();
	}

	public DisciplinaNote save(DisciplinaNote todo) {
		DisciplinaRepository.save(todo);
		return todo;
	}

	public DisciplinaNote update(DisciplinaNote disciplina, String id) {
		Optional<DisciplinaNote> optDisciplina = DisciplinaRepository.findById(id);

		if (!optDisciplina.isPresent()) {
			throw new RegisterNotFoundException("Disciplina não existe.");
		}

		DisciplinaNote newDisciplina = optDisciplina.get();
		newDisciplina.setNome(disciplina.getNome());
		newDisciplina.setCodigo(disciplina.getCodigo());
		newDisciplina.setCreditos(disciplina.getCreditos());
		newDisciplina.setPeriodo(disciplina.getPeriodo());
		newDisciplina.setGrade(disciplina.getGrade());
		newDisciplina.setTipo(disciplina.getTipo());

		DisciplinaRepository.save(newDisciplina);

		return newDisciplina;
	}

	public DisciplinaNote delete(String id) {
		Optional<DisciplinaNote> optTodo = DisciplinaRepository.findById(id);

		if (!optTodo.isPresent()) {
			throw new RegisterNotFoundException("Todo don't exists");
		}

		DisciplinaNote todo = optTodo.get();
		DisciplinaRepository.delete(todo);

		return todo;
	}
	
	public List<DisciplinaNote> getDisciplinaCodigo(String codigo){
		List<DisciplinaNote> opt = DisciplinaRepository.findCodigoDisciplina(codigo);
		return opt;
	}
	
	
}