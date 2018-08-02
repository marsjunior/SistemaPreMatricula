package br.edu.ufcg.preMatricula.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "disciplinaAlocada")
public class DisciplinaAlocadaNote {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "codigoDisciplina")
	@NotNull(message = "O codigo não pode ser nulo.")
	@NotEmpty(message = "O codigo não pode ser vazio.")
	private String codigoDisciplina;
	
	@Column(name = "matricula")
	@NotNull(message = "A matricula não pode ser nula.")
	@NotEmpty(message = "A matricula não pode ser vazia.")
	private String matricula;

	public DisciplinaAlocadaNote(long id, String codigoDisciplina, String matricula) {
		super();
		this.id = id;
		this.codigoDisciplina = codigoDisciplina;
		this.matricula = matricula;
	}
	
	public DisciplinaAlocadaNote(){
		
	}
	
	public Long getId(){
		return id;
	}

	public String getCodigoDisciplina() {
		return codigoDisciplina;
	}

	public void setCodigoDisciplina(String codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String emailAluno) {
		this.matricula = emailAluno;
	}
	
	
}
