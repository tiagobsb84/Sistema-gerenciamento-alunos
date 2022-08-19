package com.gerenciamento.controllers;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gerenciamento.exceptions.ServicoException;
import com.gerenciamento.model.Aluno;
import com.gerenciamento.model.Usuario;
import com.gerenciamento.service.UsuarioService;
import com.gerenciamento.util.Util;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	//da tela principal.
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/index");
		mv.addObject("aluno", new Aluno());
		return mv;
	}

	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login/login");
		mv.addObject("usuarioLogin", new Usuario());
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
	public ModelAndView cadastrar(Usuario usuario) throws Exception {
		ModelAndView mv = new ModelAndView();
		usuarioService.salvarUsuario(usuario);
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@PostMapping("/login")
	public ModelAndView login(@Valid Usuario usuarioLog, BindingResult result, HttpSession session) throws NoSuchAlgorithmException, ServicoException {
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuarioLogin", new Usuario());
		if(result.hasErrors()) {
			mv.setViewName("Login/login");
		}
		
		Usuario usuarioLogin = usuarioService.loginUser(usuarioLog.getUserLogin(), Util.md5(usuarioLog.getSenha())); 
		if(usuarioLogin == null) {
			mv.addObject("msg", "Usuário não encontrado. Tente novamente!");
		} else {
			session.setAttribute("usuarioLogin", usuarioLogin);
			return index();
		}
		
		return mv;
	}
}
