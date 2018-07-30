package br.edu.ufcg.preMatricula.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufcg.preMatricula.model.DisciplinaNote;

@Repository
@Transactional
public interface DisciplinaRepository extends JpaRepository<DisciplinaNote, Long> {

}
