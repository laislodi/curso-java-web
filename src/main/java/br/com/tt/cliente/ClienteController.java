package br.com.tt.cliente;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	// MVC Modelo View Controller
	
	// Autowired instancia a classe e preenche os campos, como está na classe
	@Autowired
	private ClienteService service;
	
	@GetMapping
	ModelAndView cliente(){
		
		ModelAndView mv = new ModelAndView("/cliente/index");
		
		// _clientes esta sendo chamado no index.html do cliente
		mv.addObject("_clientes", service.consulta());
		
		return mv;
	}
	
	@GetMapping("/cadastro")
	ModelAndView cadastro(Cliente cliente){
		ModelAndView mv = new ModelAndView("/cliente/cadastro");
		if (cliente == null){
			cliente = new Cliente();
		}
		mv.addObject("cliente", cliente);
		return mv;
	}
	
	@PostMapping("/salvar")
	ModelAndView salvar(@Valid Cliente cliente, BindingResult result){
		if (result.hasErrors()){
			return this.cadastro(cliente);
		}
		service.salvar(cliente);
		return this.cliente();
	}
}
