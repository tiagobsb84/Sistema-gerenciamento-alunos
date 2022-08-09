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

	//Abre a página formulario e instancia o objeto para receber os dados
	@GetMapping("/formulario")
	public ModelAndView solicitaAluno(Aluno aluno) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("formularioCadastro");
		mv.addObject("aluno", new Aluno());
		return mv;
	}
	
	//Salva cadastro no BD
	@PostMapping("/cadastro-formulario")
	public ModelAndView cadastraAluno(Aluno aluno) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/lista-alunos");
		mv.addObject("aluno", new Aluno());
		alunoRepository.save(aluno);
		return mv;
	}
	
	//Lista todos alunos
	@GetMapping("lista-alunos")
	public ModelAndView listaAlunos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("listaAlunos");
		mv.addObject("listaAlunos", alunoRepository.findAll());
		return mv;
	}
}
