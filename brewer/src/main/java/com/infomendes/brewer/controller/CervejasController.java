package com.infomendes.brewer.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.infomendes.brewer.model.Cerveja;
import com.infomendes.brewer.repository.Cervejas;

@Controller
public class CervejasController {

	private static final Logger logger = LoggerFactory.getLogger(CervejasController.class);
	
	@Autowired
	private Cervejas cervejas;

	@GetMapping("/cervejas/novo")
	public String novo(Cerveja cerveja) {
		
		Optional<Cerveja> cervejaOptional = cervejas.findBySkuIgnoreCase("aaa");
		if(cervejaOptional.isPresent()) {
			cervejaOptional.get();
		}
		
		return "cerveja/CadastroCerveja";
	}

	@PostMapping("/cervejas/novo")
	public String cadastrar(@Validated Cerveja cerveja, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return novo(cerveja);
		}

		// salvar
		attributes.addFlashAttribute("mensagem", "Cadastrado com sucesso");
		System.out.println(">>>>>>> Ok:" + cerveja.getSku());

		return "redirect:/cervejas/novo";

	}

	@RequestMapping("/cervejas/cadastro")
	public String cadastro() {
		return "cerveja/cadastro-produto";
	}

}
