package com.gerenciamento.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CadastroController {

	@GetMapping("/formulario")
	public ModelAndView formularioCadastro() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("formularioCadastro");
		return mv;
	}
}
