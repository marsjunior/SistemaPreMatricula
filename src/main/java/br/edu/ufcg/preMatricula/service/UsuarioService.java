package br.edu.ufcg.preMatricula.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufcg.preMatricula.exception.RegisterNotFoundException;
import br.edu.ufcg.preMatricula.model.DisciplinaNote;
import br.edu.ufcg.preMatricula.model.UsuarioNote;
import br.edu.ufcg.preMatricula.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UsuarioNote getUsuario(String email) {
		return this.usuarioRepository.findByEmail(email);
	}

	public List<UsuarioNote> getUsers() {
		return this.usuarioRepository.findAll();
	}

	public UsuarioNote save(UsuarioNote usuario) {
		this.usuarioRepository.save(usuario);
		return usuario;
	}
	
	public UsuarioNote delete(String id) {
		Optional<UsuarioNote> optTodo = usuarioRepository.findById(id);

		if (!optTodo.isPresent()) {
			throw new RegisterNotFoundException("Todo don't exists");
		}

		UsuarioNote todo = optTodo.get();
		usuarioRepository.delete(todo);
		return todo;
	}

}
