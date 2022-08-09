package com.gerenciamento.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamento.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
