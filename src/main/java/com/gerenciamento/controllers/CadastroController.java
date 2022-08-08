package com.gerenciamento.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gerenciamento.model.Aluno;

@Controller
public class CadastroController {

	@GetMapping("/formulario")
	public ModelAndView solicitaAluno(Aluno aluno) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("formularioCadastro");
		mv.addObject("aluno", new Aluno());
		return mv;
	}
	
	@PostMapping("/cadastro-formulario")
	public ModelAndView cadastraAluno(Aluno aluno) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		mv.addObject("aluno", new Aluno());
		return mv;
	}
}
