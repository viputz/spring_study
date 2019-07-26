package com.infomendes.brewer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.infomendes.brewer.model.Estilo;
import com.infomendes.brewer.service.EstiloService;
import com.infomendes.brewer.service.exception.NomeEstiloJaCadastradoException;

@Controller
public class EstilosController {

	@Autowired
	private EstiloService estiloService;

	@GetMapping("/estilos/novo")
	public ModelAndView novo(Estilo estilo) {
		ModelAndView mv = new ModelAndView("estilo/CadastroEstilo");
		return mv;
	}

	@PostMapping("/estilos/novo")
	public ModelAndView cadastrar(@Valid Estilo estilo, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return novo(estilo);
		}
		try {
			estiloService.salvar(estilo);

		} catch (NomeEstiloJaCadastradoException e) {
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			return novo(estilo);
		}
		attributes.addFlashAttribute("mensagem", "Cadastrado com sucesso");

		return new ModelAndView("redirect:/estilos/novo");
	}

	@PostMapping(value = "/estilos", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ResponseEntity<?> salvarAjax(@RequestBody @Valid Estilo estilo, BindingResult result) {

		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(result.getFieldError("nome").getDefaultMessage());
		}

		try {

			estilo = estiloService.salvar(estilo);

		} catch (NomeEstiloJaCadastradoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

		return ResponseEntity.ok(estilo);
	}

}
