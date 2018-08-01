package br.edu.ufcg.preMatricula.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "disciplinaAlocada")
public class DisciplinaAlocadaNote {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "codigoDisciplina")
	private String codigoDisciplina;
	
	@Column(name = "emailAluno")
	private String emailAluno;

	public DisciplinaAlocadaNote(long id, String codigoDisciplina, String emailAluno) {
		super();
		this.id = id;
		this.codigoDisciplina = codigoDisciplina;
		this.emailAluno = emailAluno;
	}

	public String getCodigoDisciplina() {
		return codigoDisciplina;
	}

	public void setCodigoDisciplina(String codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}

	public String getEmailAluno() {
		return emailAluno;
	}

	public void setEmailAluno(String emailAluno) {
		this.emailAluno = emailAluno;
	}
	
	
}
