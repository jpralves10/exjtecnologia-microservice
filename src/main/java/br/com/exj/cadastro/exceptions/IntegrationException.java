package br.com.exj.cadastro.exceptions;

import lombok.Getter;

@Getter
public class IntegrationException extends RuntimeException {

    private String code;

    public IntegrationException(String message){
        super(message);
    }

    public IntegrationException(String code, String message){
        super(message);
        this.code = code;
    }

    public IntegrationException(String message, Throwable cause){
        super(message, cause);
    }

    public IntegrationException(String code, String message, Throwable cause){
        super(message, cause);
        this.code = code;
    }
}
