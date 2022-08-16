package com.gerenciamento.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gerenciamento.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
	List<Aluno> findByNomeContainingIgnoreCase(String nome);
	
	@Query("select j from Aluno j where j.situacao = 'ATIVO' ")
	List<Aluno> findBySituacaoAtivo();
	
	@Query("select j from Aluno j where j.situacao = 'TRANCADO' ")
	List<Aluno> findBySituacaoTrancado();
	
	@Query("select j from Aluno j where j.situacao = 'INATIVO' ")
	List<Aluno> findBySituacaoInativo();
}
