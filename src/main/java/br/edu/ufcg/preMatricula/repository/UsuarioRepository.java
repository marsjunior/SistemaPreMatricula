package br.edu.ufcg.preMatricula.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.ufcg.preMatricula.model.DisciplinaNote;
import br.edu.ufcg.preMatricula.model.UsuarioNote;

@Repository
@Transactional

public interface UsuarioRepository extends JpaRepository<UsuarioNote, String>  {
	@Query("select u from UsuarioNote u where u.email = ?1")
	UsuarioNote findByEmail(String Email);
}
