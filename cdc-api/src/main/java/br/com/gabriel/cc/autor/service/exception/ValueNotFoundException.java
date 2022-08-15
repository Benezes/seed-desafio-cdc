package br.com.gabriel.cc.autor.service.exception;

public class ValueNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ValueNotFoundException() {
		super();
	}

	public ValueNotFoundException(String message) {
		super(message);
	}

}
