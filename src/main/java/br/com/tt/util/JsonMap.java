package br.com.tt.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.tt.exception.CursoJavaWebException;

public class JsonMap {

	public static <T> T jsonToObject(String json, Class<T> valueType) throws CursoJavaWebException {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(json, valueType);
		} catch (Exception e) {
			String msgErro = "Falha ao converter o arquivo Json: " + json;
			CursoJavaWebException cjwException = new CursoJavaWebException(msgErro, e);
			throw cjwException;
		}
	}
}
