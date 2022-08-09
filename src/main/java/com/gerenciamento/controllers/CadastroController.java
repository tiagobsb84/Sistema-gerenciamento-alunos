package com.gerenciamento.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gerenciamento.model.Aluno;
import com.gerenciamento.repositorys.AlunoRepository;

@Controller
public class CadastroController {
	
	@Autowired
	private AlunoRepository alunoRepository;

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
		alunoRepository.save(aluno);
		return mv;
	}
}
