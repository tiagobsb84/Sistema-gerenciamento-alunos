package com.gerenciamento.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gerenciamento.model.Aluno;

@Controller
public class HomeController {

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/index");
		mv.addObject("aluno", new Aluno());
		return mv;
	}
	
}
