package br.com.tt.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConvertTeste {

	@Test
	public void testCpf() {
		String cpf = new Convert().cpf("12345678901");
		assertEquals("123.456.789-01", cpf);
		cpf = new Convert().cpf("123456789012");
		assertEquals(null, cpf);
		cpf = new Convert().cpf("12345678");
		assertEquals(null, cpf);
	}

}
