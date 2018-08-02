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
@Table(name = "disciplina")
public class DisciplinaNote implements Serializable {
	private static final long serialVersionUID = 1l;
	
	@Id
	@Column(name = "codigo")
	@NotNull(message = "O codigo não pode ser nulo.")
	@NotEmpty(message = "O codigo não pode ser vazio.")
	private String codigo;
	
	@Column(name = "nome")
	@NotNull(message = "O nome não pode ser nulo.")
	@NotEmpty(message = "O nome não pode ser vazio.")
	private String nome;
	
	@Column(name = "periodo")
	@NotNull(message = "O periodo não pode ser nulo.")
	private int periodo;
	
	@Column(name = "creditos")
	@NotNull(message = "O credito não pode ser nulo.")
	private int creditos;
	
	@Column(name = "tipo")
	@NotNull(message = "O tipo não pode ser nulo.")
	@NotEmpty(message = "O tipo não pode ser vazio.")
	private String tipo;
	
	@Column(name = "grade")
	@NotNull(message = "O grade não pode ser nulo.")
	@NotEmpty(message = "O grade não pode ser vazio.")
	private String grade;
	
	public DisciplinaNote(){
		
	}
	
	public DisciplinaNote(String nome, String codigo, int periodo, int creditos, String tipo, String grade ){
		this.nome = nome;
		this.codigo = codigo;
		this.periodo = periodo;
		this.creditos = creditos;
		this.tipo = tipo;
		this.grade = grade;
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}
