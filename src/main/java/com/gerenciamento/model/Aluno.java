package com.gerenciamento.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	private CursoEnum curso;
	private String matricula;
	private SituacaoEnum Situacao;
	private TurnoEnum turno;
	
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
		return Situacao;
	}
	public void setSituacao(SituacaoEnum situacao) {
		Situacao = situacao;
	}
	public TurnoEnum getTurno() {
		return turno;
	}
	public void setTurno(TurnoEnum turno) {
		this.turno = turno;
	}
	
}
