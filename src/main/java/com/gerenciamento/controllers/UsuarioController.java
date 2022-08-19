package com.gerenciamento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gerenciamento.model.Usuario;
import com.gerenciamento.repositorys.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login/login");
		return mv;
	}
	
	@GetMapping("/cadastro")
	public ModelAndView cadastroUsuario() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuarioLogin", new Usuario());
		mv.setViewName("Login/cadastroLogin");
		return mv;
	}
	
	@PostMapping("salvarUsuario")
	public ModelAndView cadastrar(Usuario usuario) {
		ModelAndView mv = new ModelAndView();
		usuarioRepository.save(usuario);
		mv.setViewName("redirect:/");
		return mv;
	}
}
