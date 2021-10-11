package br.com.exj.cadastro.exceptions;

/**
 * Exceção lançada no UseCase ao validar informações e algum erro for identificado
 */
public class ValidateException extends BadRequestException {

    public ValidateException(String msg) {
        super(msg);
    }
}
