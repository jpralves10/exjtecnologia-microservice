package br.com.exj.cadastro.exceptions;

/**
 * Exceção que representa uma falha na requisição causada pelo cliente.
 * Por exemplo, algum parâmetro incorreto, ou parâmetro obrigatório faltando.
 * Deve resultar em uma resposta com status
 * {@link org.springframework.http.HttpStatus#BAD_REQUEST}
 */
public abstract class BadRequestException extends RuntimeException{

    public BadRequestException(String msg){
        super(msg);
    }
}
