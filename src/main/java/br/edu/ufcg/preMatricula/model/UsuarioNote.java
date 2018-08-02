package br.edu.ufcg.preMatricula.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuarios")
public class UsuarioNote implements Serializable{
	private static final long serialVersionUID = 1l;
	
	@Id
	@NotNull(message = "A matricula não pode ser nulo.")
	@NotEmpty(message = "A matricula não pode ser vazio.")
	@Column(name = "matricula")
	private String matricula;
	
	@Column(name = "nome")
	@NotNull(message = "O nome não pode ser nulo.")
	@NotEmpty(message = "O nome não pode ser vazio.")
	private String nome;
	
	@NotNull(message = "O email não pode ser nulo.")
	@NotEmpty(message = "O email não pode ser vazio.")
	@Column(name = "email")
	private String email;
	
	@NotNull(message = "O anoIngresso não pode ser nulo.")
	@NotEmpty(message = "O anoIngresso não pode ser vazio.")
	@Column(name = "anoIngresso")
	private String anoIngresso;
	
	@NotNull(message = "A grade não pode ser nulo.")
	@NotEmpty(message = "A grade não pode ser vazio.")
	@Column(name = "grade")
	private String grade;
	
	public UsuarioNote(){
		
	}
	
	public UsuarioNote( String nome, String email, String anoIngresso, String matricula, String grade) {
		this.nome = nome;
		this.email = email;
		this.matricula = matricula;
		this.anoIngresso = anoIngresso;
		this.grade = grade;
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String getAnoIngresso() {
		return anoIngresso;
	}

	public void setAnoIngresso(String anoIngresso) {
		this.anoIngresso = anoIngresso;
	}


	
}
