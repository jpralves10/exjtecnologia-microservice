package br.com.exj.cadastro.exceptions;

/**
 * Exception lançada ao tentar recuperar a class através do nome da classe
 */
public class ClassNotFoundActionDomainException extends InternalServerErrorException {

    public ClassNotFoundActionDomainException(String msg, Throwable cause){
        super(msg, cause);
    }
}
