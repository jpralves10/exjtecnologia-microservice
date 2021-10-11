package br.com.exj.cadastro.enums;

import br.com.exj.cadastro.config.util.MessageUtil;

import java.util.Optional;

public enum StatusTableEnum {

    ATIVO("1"), INATIVO("2"), AGUARDANDO_APROVACAO("3"), ENCERRADO("4");

    private String status;

    private static final StatusTableEnum NULL_STATUS = null;

    private StatusTableEnum(String status){ this.status = status; }

    /**
     * Recupera o Status da Garantia pelo seu valor numério
     *
     * @param value
     * @return
     */
    public static StatusTableEnum getStatusByValue(String value){
        if(value == null){
            return null;
        }
        for(StatusTableEnum status : StatusTableEnum.values()){
            if(value.equals(status.getStatus())){
                return status;
            }
        }
        throw new IllegalArgumentException(
                String.format(MessageUtil.INVALID_NUMERIC_CODE_MESSAGE, value));
    }

    public String getStatus(){ return status; }

    /**
     * Converte o status active para o enum
     *
     * @param active
     * @return
     */
    public static StatusTableEnum getStatusByActive(Boolean active){
        return Optional.ofNullable(active)
                        .map(a -> a ? StatusTableEnum.ATIVO : StatusTableEnum.INATIVO)
                        .orElse(NULL_STATUS);
    }
}
