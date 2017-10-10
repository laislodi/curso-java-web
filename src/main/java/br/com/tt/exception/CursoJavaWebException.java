package br.com.tt.exception;

public class CursoJavaWebException extends Exception {

	private static final long serialVersionUID = 1L;

	public CursoJavaWebException(String message, Throwable cause) {
		super(message, cause);
		System.err.println(message + " - Erro: " + cause.getMessage());
	}

	public CursoJavaWebException(String message) {
		super(message);
		System.err.println("Erro: " + message);
	}
	
	
	
}
