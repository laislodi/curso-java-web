package br.com.tt.util;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import br.com.tt.exception.CursoJavaWebException;

public class HttpClient {
	
	public static String get(String url) throws CursoJavaWebException {
		try {
			HttpResponse<String> response = Unirest.get(url)
					.asString();
			return response.getBody();
		} catch (UnirestException e) {
			throw new CursoJavaWebException("Acesso a URL: " + url, e);
		}
	}
	
	public static void main(String[] args) throws CursoJavaWebException {
		String url = "https://www.receitaws.com.br/v1/cnpj/00000000000191";
		System.out.println(get(url));
	}
}
