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
	
	public UsuarioNote getByToken(String token){
		Optional<UsuarioNote> optTodo = this.usuarioRepository.findByToken(token);
		if (!optTodo.isPresent()) {
			throw new RegisterNotFoundException("Token não cadastrado");
		}
		return optTodo.get();
	}
	public UsuarioNote save(UsuarioNote usuario) {
		this.usuarioRepository.save(usuario);
		return usuario;
	}
	
	public UsuarioNote getUsuarioId(String id){
		Optional<UsuarioNote> optTodo = usuarioRepository.findById(id);
		if (!optTodo.isPresent()) {
			throw new RegisterNotFoundException("Todo don't exists");
		}
		UsuarioNote todo = optTodo.get();
		return todo;
	}
	
	public UsuarioNote update(UsuarioNote usuario, String matricula) {
		Optional<UsuarioNote> optUsuario = usuarioRepository.findById(matricula);

		if (!optUsuario.isPresent()) {
			throw new RegisterNotFoundException("Usuario não existe.");
		}
		UsuarioNote newUsuario = optUsuario.get();
		newUsuario.setNome(usuario.getNome());
		newUsuario.setEmail(usuario.getEmail());
		newUsuario.setAdmin(usuario.isAdmin());
		newUsuario.setGrade(usuario.getGrade());
		newUsuario.setAnoIngresso(usuario.getAnoIngresso());

		usuarioRepository.save(newUsuario);

		return newUsuario;
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
