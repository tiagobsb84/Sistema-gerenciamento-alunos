package com.gerenciamento.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	//Editar aluno
	@GetMapping("/editar/{id}")
	public ModelAndView editarAluno(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("editar");
		Optional<Aluno> aluno = alunoRepository.findById(id);
		mv.addObject("aluno", aluno);
		return mv;
	}
	
	//Salva aluno editado
	@PostMapping("/editar")
	public ModelAndView editarAluno(Aluno aluno) {
		ModelAndView mv = new ModelAndView();
		alunoRepository.save(aluno);
		mv.setViewName("redirect:/lista-alunos");
		return mv;
	}
	
	//Deletar dado formulario
	@GetMapping("/deletar/{id}")
	 public String deletarAluno(@PathVariable("id") Long id) {
		alunoRepository.deleteById(id);
		return "redirect:/lista-alunos";
	}
}
