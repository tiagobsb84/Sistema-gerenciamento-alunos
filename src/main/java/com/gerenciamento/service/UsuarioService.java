package com.gerenciamento.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciamento.exceptions.CriptoExistException;
import com.gerenciamento.exceptions.EmailExistsException;
import com.gerenciamento.exceptions.ServicoException;
import com.gerenciamento.model.Usuario;
import com.gerenciamento.repositorys.UsuarioRepository;
import com.gerenciamento.util.Util;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void salvarUsuario(Usuario user) throws Exception {
		
		try {
			if(usuarioRepository.findByEmail(user.getEmail()) != null) {
				throw new EmailExistsException("Já existe um email cadastrado para: " + user.getEmail());
			}	
			
			user.setSenha(Util.md5(user.getSenha()));
			
		} catch (NoSuchAlgorithmException e) {

			throw new CriptoExistException("Erro na criptografia da senha");
		}
		
		usuarioRepository.save(user);
	}
	
	public Usuario loginUser(String user, String senha) throws ServicoException {
		
		Usuario userLogin = usuarioRepository.buscarLogin(user, senha);
		return userLogin;
	}
}
