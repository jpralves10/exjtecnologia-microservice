package br.com.exj.cadastro.exceptions;

/**
 * Exceção que representa uma falha interna do serviço, algum bug ou exceção que
 * foi causado por um erro de lógica, uma falha na máquina, etc. Essa falha não
 * é culpa do cliente que realizou a requisição ou de algum provedor externo.
 * Deve resultar em uma resposta com status
 * {@link org.springframework.http.HttpStatus#INTERNAL_SERVER_ERROR}
 */
public abstract class InternalServerErrorException extends RuntimeException {

    public InternalServerErrorException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public InternalServerErrorException(String msg) {
        super(msg);
    }
}
