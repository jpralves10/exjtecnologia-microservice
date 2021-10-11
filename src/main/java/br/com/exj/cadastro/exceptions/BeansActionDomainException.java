package br.com.exj.cadastro.exceptions;

/**
 * Exception lançada ao tentar recuperar uma classe do GetBeans
 */
public class BeansActionDomainException extends InternalServerErrorException {

    /**
     * Construtor para Exception de BeansActionDomainException que lança
     * uma Exception de InternalServerError
     * @param msg
     */
    public BeansActionDomainException(String msg){
        super(msg);
    }

    public BeansActionDomainException(String msg, Throwable cause){
        super(msg, cause);
    }
}
