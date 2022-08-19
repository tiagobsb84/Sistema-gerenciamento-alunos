package com.gerenciamento.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gerenciamento.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("select i from Usuario i where i.email = :email")
	Usuario findByEmail(String email);
	
	@Query("select j from Usuario j where j.userLogin = :userLogin and j.senha = :senha")
	Usuario buscarLogin(String userLogin, String senha);
}
