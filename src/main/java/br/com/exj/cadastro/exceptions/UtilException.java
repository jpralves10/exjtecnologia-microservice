package br.com.exj.cadastro.exceptions;

import lombok.Getter;

@Getter
public class UtilException extends RuntimeException {

    private String code;

    public UtilException(String message, String code, Throwable cause){
        super(message, cause);
        this.code = code;
    }

    public UtilException(String message, String code){
        super(message);
        this.code = code;
    }

    public UtilException(String message, Throwable cause){
        super(message, cause);
    }
}
