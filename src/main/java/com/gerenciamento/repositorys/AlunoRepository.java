package com.gerenciamento.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gerenciamento.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	@Query("select p from Aluno p where p.nome like %?1%")
	List<Aluno> findalunoByNome(String nome);
}
