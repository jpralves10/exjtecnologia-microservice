package br.com.exj.cadastro.exceptions;

import lombok.Getter;

@Getter
public class ServiceUnavailableException extends DataProviderServiceUnavailableException {

    private String code;

    public ServiceUnavailableException(String msg) {
        super(msg);
    }

    public ServiceUnavailableException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ServiceUnavailableException(String code, String message){
        super(message);
        this.code = code;
    }

    public ServiceUnavailableException(String code, String message, Throwable cause){
        super(message);
        this.code = code;
    }
}
