package br.com.tt.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.tt.model.CadastroReceita;
import br.com.tt.util.HttpClient;

// Regras de negocio
@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	List<Cliente> consulta() {
		return repository.findAll();
	}
	
	public Cliente salvar(Cliente cliente){
		return repository.save(cliente);
	}
	
	public Cliente buscar(Long id){
		return repository.findOne(id);
	}
	
	public void excluir(Long id){
		repository.delete(id);
	}
	
	public CadastroReceita consulta(String cnpj) throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		String receitaJson = HttpClient.get("https://www.receitaws.com.br/v1/cnpj/" + cnpj);
		CadastroReceita receita = mapper.readValue(receitaJson, CadastroReceita.class);
		System.out.println("Nome: " + receita.getNome());
		System.out.println("Fantasia: " + receita.getFantasia());
		System.out.println("Data de Abertura: " + receita.getAbertura());
		System.out.println("Email: " + receita.getEmail());
		System.out.println("Logradouro: "+ receita.getLogradouro());
		System.out.println("Situação: " + receita.getSituacao());
		return receita;
	}
	
	public static void main(String[] args) throws Exception{
		new ClienteService().consulta("00000000000191");
	}
}
