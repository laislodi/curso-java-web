package br.com.tt.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tt.exception.CursoJavaWebException;
import br.com.tt.model.CadastroCnpj;
import br.com.tt.util.HttpClient;
import br.com.tt.util.JsonMap;

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
	
	public CadastroCnpj consultaCnpj(String cnpj) throws CursoJavaWebException {
		String receitaJson = HttpClient.get("https://www.receitaws.com.br/v1/cnpj/" + cnpj);
		return JsonMap.jsonToObject(receitaJson, CadastroCnpj.class);
	}
	
	public static void main(String[] args) throws Exception{
		new ClienteService().consultaCnpj("00000000000191");
	}
}
