package br.com.tt.cliente;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// Cliente - Entidade, Long - ID

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query("select c from Cliente c ORDER BY c.nome ")
	List<Cliente> findAllNomeSort();
	
	@Query("select c from Cliente c ORDER BY c.id ")
	List<Cliente> findAllIdSort();
	
	@Query("select c from Cliente c ORDER BY c.cpf ")
	List<Cliente> findAllCpfSort();
	
	@Query("select c from Cliente c ORDER BY c.data ")
	List<Cliente> findAllDataSort();

	// https://docs.spring.io/spring-data/jpa/docs/1.4.3.RELEASE/reference/html/jpa.repositories.html
	// Usar nomes de parametros para ser implementado SOZINHO!!! =O

	List<Cliente> findByNomeLike(String nome);
	
	List<Cliente> findByNomeNotLike(String nome);

	List<Cliente> findByNomeNot(String nome);

	List<Cliente> findByNomeStartingWith(String nome);
	
	List<Cliente> findByNomeEndingWith(String nome);
	
	List<Cliente> findByDataBetween(Date data1, Date data2);
	
	List<Cliente> findByDataBefore(Date data);

	List<Cliente> findByDataAfter(Date data);
	
	List<Cliente> findByDataOrderByNome(Date data);
}
