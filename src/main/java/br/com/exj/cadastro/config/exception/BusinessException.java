package br.com.exj.cadastro.config.exception;

import java.util.ArrayList;
import java.util.List;

public class BusinessException extends RuntimeException {

    private transient List<FieldError> fields = new ArrayList<>();

    private String code;

    public BusinessException(final String code, final String message, final List<FieldError> fields){
        super(message);
        this.code = code;
        this.fields = fields;
    }

    public BusinessException(final String message, final List<FieldError> fields, final String code){
        super(message);
        this.fields = fields;
        this.code = code;
    }

    public BusinessException(final String message, final List<FieldError> fields){
        super(message);
        this.fields = fields;
    }

    public BusinessException(String code, String message, Throwable cause){
        super(message, cause);
        this.code = code;
    }

    public BusinessException(String message, Throwable cause){
        super(message);
    }

    public BusinessException(final String code, final String message){
        super(message);
        this.code = code;
    }

    public BusinessException(final String message) {
        super(message);
    }

    public List<FieldError> getFields() {
        return fields;
    }

    public String getCode() {
        return code;
    }

    public void setFields(List<FieldError> fields) {
        this.fields = fields;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
