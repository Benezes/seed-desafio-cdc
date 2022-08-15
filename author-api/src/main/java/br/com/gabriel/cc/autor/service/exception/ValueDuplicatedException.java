package br.com.gabriel.cc.autor.service.exception;

public class ValueDuplicatedException extends RuntimeException {
    public ValueDuplicatedException(String msg) {
        super(msg);
    }

    public ValueDuplicatedException() {

    }
}
