package com.gerenciamento.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView cadastraAluno(@Valid Aluno aluno, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		
		if(result.hasErrors()) {
			mv.setViewName("formularioCadastro.html");
			mv.addObject("aluno");
		
		} else {
			mv.setViewName("redirect:/lista-alunos");
			alunoRepository.save(aluno);
			
		}
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
	public ModelAndView editarAluno(@Valid Aluno aluno, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		
		if(result.hasErrors()) {
			mv.setViewName("editar");
			mv.addObject("aluno");
			
		} else {
			mv.setViewName("redirect:/lista-alunos");
			alunoRepository.save(aluno);
		}
		
		return mv;
	}
	
	//Deletar dado formulario
	@GetMapping("/deletar/{id}")
	 public String deletarAluno(@PathVariable("id") Long id) {
		alunoRepository.deleteById(id);
		return "redirect:/lista-alunos";
	}
	
	@GetMapping("filtro-alunos")
	public ModelAndView filtrar() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("filtroAluno");
		mv.addObject("listaDeAlunos", new Aluno());
		return mv;
	}
	
	//Pesquisar ALuno
	@PostMapping("pesquisar-aluno")
	public ModelAndView pesquisar(@RequestParam("nomePesquisa") String alunos) {
		ModelAndView mv = new ModelAndView();
		List<Aluno> listaAlunos;
		if(alunos == null || alunos.trim().isEmpty()) {
			listaAlunos = alunoRepository.findAll();
		
		} else {
			listaAlunos = alunoRepository.findByNomeContainingIgnoreCase(alunos);
		}
		
		mv.addObject("listaDeAlunos", listaAlunos);
		mv.setViewName("filtroAluno");
		return mv;
	}
	
	//Pesquisar Status Alunos
	@GetMapping("status")
	public ModelAndView stausPesquisa() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("pesquisaStatus");
		return mv;
	}
	
	//Pesquisar ALunos Ativos
	@GetMapping("alunos-ativos")
	public ModelAndView alunosAtivos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("status/alunos-ativos");
		return mv;
	}
	
	//Pesquisar ALunos Trancados
	@GetMapping("alunos-trancados")
	public ModelAndView alunosTrancados() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("status/alunos-trancados");
		return mv;
	}
		
	//Pesquisar ALunos Inativos
	@GetMapping("alunos-inativos")
	public ModelAndView alunosInativos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("status/alunos-inativos");
		return mv;
	}
}
