package br.com.tt.cliente;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.tt.exception.CursoJavaWebException;
import br.com.tt.model.CadastroCnpj;

@Controller
@RequestMapping("cliente")
public class ClienteController {
	// MVC Modelo View Controller
	
	// Autowired instancia a classe e preenche os campos, como está na classe
	@Autowired
	private ClienteService service;
	
	@GetMapping
	ModelAndView cliente(){
		
		ModelAndView mv = new ModelAndView("cliente/index");
		
		// _clientes esta sendo chamado no index.html do cliente
		mv.addObject("_clientes", service.consulta());
		
		return mv;
	}
	
	@GetMapping("/cadastro")
	ModelAndView cadastro(Cliente cliente){
		ModelAndView mv = new ModelAndView("cliente/cadastro");
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
	
	@GetMapping("/editar/{id}")
	ModelAndView editar(@PathVariable("id") Long id){
		return cadastro(service.buscar(id));
	}
	
	@GetMapping("/excluir/{id}")
	ModelAndView excluir(@PathVariable("id") Long id){
		service.excluir(id);
		return cliente();
	}
	
	@GetMapping("/consulta/cnpj")
	ModelAndView telaConsultaReceita(){
		ModelAndView mv = new ModelAndView("/cliente/consulta-cnpj");
		mv.addObject("cadastroCnpj", new CadastroCnpj());
		return mv;
	}
	
	@PostMapping("/consulta/cnpj")
	ModelAndView consultaReceita(CadastroCnpj cadastroCnpj) throws CursoJavaWebException{
		Cliente cliente = new Cliente();
		cadastroCnpj = service.consultaCnpj(cadastroCnpj.getCnpj());
		cliente.setNome(cadastroCnpj.getFantasia());
		return cadastro(cliente);
	}
	
}
