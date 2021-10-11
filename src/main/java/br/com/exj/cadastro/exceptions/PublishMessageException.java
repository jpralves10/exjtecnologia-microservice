package br.com.exj.cadastro.exceptions;

public class PublishMessageException extends InternalServerErrorException {

    public PublishMessageException(String msg, Throwable cause){
        super(msg, cause);
    }
}
