package br.com.gabriel.cc.autor.service.exception;

public class EmailDuplicatedException extends RuntimeException {
    public EmailDuplicatedException(String msg) {
        super(msg);
    }

    public EmailDuplicatedException() {
        
    }
}
