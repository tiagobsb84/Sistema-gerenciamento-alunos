package com.gerenciamento.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	
	@Enumerated(EnumType.STRING)
	private CursoEnum tipoCurso;
	
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
	public CursoEnum gettipoCurso() {
		return tipoCurso;
	}
	public void settipoCurso(CursoEnum tipoCurso) {
		this.tipoCurso = tipoCurso;
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
