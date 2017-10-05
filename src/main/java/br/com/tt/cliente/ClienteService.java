package br.com.tt.cliente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

// Regras de negocio
@Service
public class ClienteService {

	List<Cliente> consulta() {
		List<Cliente> clientes = new ArrayList<>();

		clientes.add(new Cliente(1L, "Lais Gabrielle Lodi", "123.098.283-91", new Date()));
		clientes.add(new Cliente(2L, "Aghata Christy", "243.568.098-21", new Date()));
		clientes.add(new Cliente(3L, "Cristina Hernandes", "223.538.123-57", new Date()));
		clientes.add(new Cliente(4L, "Patrick Gother", "098.374.926-16", new Date()));
		clientes.add(new Cliente(5L, "Gustavo Torpe", "092.928.082-72", new Date()));
		clientes.add(new Cliente(6L, "Jurandi Estêvão Romênio", "922.878.982-30", new Date()));

		return clientes;
	}
}
