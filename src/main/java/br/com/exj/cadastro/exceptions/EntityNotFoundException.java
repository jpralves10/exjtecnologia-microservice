package br.com.exj.cadastro.exceptions;

import java.text.MessageFormat;

/**
 * Classe de exceção para entidades não encontradas
 */
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(final String message, final Object... params){
        super(MessageFormat.format(message, params));
    }
}
