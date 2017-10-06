package br.com.tt.cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// Cliente - Entidade, Long - ID

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query("select c from Cliente c ORDER BY c.nome ")
	List<Cliente> findAllNomeSort();

	// https://docs.spring.io/spring-data/jpa/docs/1.4.3.RELEASE/reference/html/jpa.repositories.html
	// Usar nomes de parametros para ser implementado SOZINHO!!! =O

	List<Cliente> findByNomeLike(String nome);

	List<Cliente> findByNomeNot(String nome);

	List<Cliente> findByNomeStartingWith(String nome);
}
