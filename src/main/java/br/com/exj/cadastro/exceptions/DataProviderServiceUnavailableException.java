package br.com.exj.cadastro.exceptions;

/**
 * Exceção que representa falha no processo de obtenção de dados de algum
 * DataProvider. O motivo dessa falha pode ser uma exceção lançada por algum
 * provedor externo, ou uma falha na conexão com esse provedor. Deve resultar
 * em uma resposta com status
 * {@link org.springframework.http.HttpStatus#SERVICE_UNAVAILABLE}
 */
public abstract class DataProviderServiceUnavailableException extends RuntimeException {

    public DataProviderServiceUnavailableException(String msg){
        super(msg);
    }

    public DataProviderServiceUnavailableException(String msg, Throwable cause){
        super(msg, cause);
    }
}
