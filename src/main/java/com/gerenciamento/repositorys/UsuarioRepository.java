package com.gerenciamento.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamento.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
