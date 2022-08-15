package br.com.gabriel.cc.autor.service.exception;

public class ValueDuplicatedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ValueDuplicatedException(String msg) {
		super(msg);
	}

	public ValueDuplicatedException() {

	}
}
