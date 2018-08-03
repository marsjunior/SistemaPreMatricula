package br.edu.ufcg.preMatricula.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.ufcg.preMatricula.model.DisciplinaAlocadaNote;
import br.edu.ufcg.preMatricula.model.DisciplinaNote;

public interface DisciplinaAlocadaRepository extends JpaRepository<DisciplinaAlocadaNote, Long>{
	
	@Query("select u from DisciplinaAlocadaNote u where u.codigoDisciplina = ?1")
	List<DisciplinaAlocadaNote> findCodigoDisciplina(String codigo);
	
	@Query("select u from DisciplinaAlocadaNote u where u.matricula = ?1")
	List<DisciplinaAlocadaNote> findMatricula(String codigo);
}
