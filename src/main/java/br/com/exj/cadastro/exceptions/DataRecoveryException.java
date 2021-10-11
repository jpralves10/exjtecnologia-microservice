package br.com.exj.cadastro.exceptions;

/**
 * Exception lançada ao tentar recuperar uma informação
 */
public class DataRecoveryException extends InternalServerErrorException {

    public DataRecoveryException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public DataRecoveryException(String msg) {
        super(msg);
    }
}
