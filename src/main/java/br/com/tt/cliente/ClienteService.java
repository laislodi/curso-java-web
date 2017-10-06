package br.com.tt.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Regras de negocio
@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	List<Cliente> consulta() {
		return repository.findAll();
	}
	
	public void salvar(Cliente cliente){
		repository.save(cliente);
	}
}
