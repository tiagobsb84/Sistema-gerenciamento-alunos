package com.gerenciamento.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "aluno")
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Size(min=2 , max = 30,  message = "O nome deve contém no mínimo 2 caracteres, maximo 30 caracteres")
	@NotBlank(message = "O campo nome obrigatório!")
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private CursoEnum curso;
	
	@NotBlank(message = "O campo Matrícula obrigatória!")
	private String matricula;
	
	@Enumerated(EnumType.STRING)
	private SituacaoEnum situacao;
	
	@Enumerated(EnumType.STRING)
	private TurnoEnum turno;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public CursoEnum getCurso() {
		return curso;
	}
	public void setCurso(CursoEnum curso) {
		this.curso = curso;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public SituacaoEnum getSituacao() {
		return situacao;
	}
	public void setSituacao(SituacaoEnum situacao) {
		this.situacao = situacao;
	}
	public TurnoEnum getTurno() {
		return turno;
	}
	public void setTurno(TurnoEnum turno) {
		this.turno = turno;
	}
	
}
