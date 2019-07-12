package com.infomendes.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.infomendes.brewer.model.Cliente;

@Controller
public class ClientesController {

	@GetMapping("/clientes/novo")
	public String novo(Cliente cliente) {
		return "cliente/CadastroCliente";
	}

	@PostMapping("/clientes/novo")
	public String cadastrar(@Validated Cliente cliente, BindingResult result, RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return novo(cliente);
		}

		// salvar
		attributes.addFlashAttribute("mensagem", "Cadastrado com sucesso");
		System.out.println(">>>>>>> Ok:" + cliente.getEmail());

		return "redirect:/clientes/novo";
	}

}
