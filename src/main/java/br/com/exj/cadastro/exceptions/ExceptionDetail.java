package br.com.exj.cadastro.exceptions;

import lombok.Getter;

@Getter
public enum ExceptionDetail {

    ATUALIZA_PAINEL_CONTROLE_ACAO_SUGERIDA("EXJ-FI-1001", "Erro ao atualizar a ação sugerida do Painel de Controle online. "),
    ATUALIZA_PAINEL_CONTROLE_STATUS("EXJ-FI-1002", "Erro ao atualizar status no Painel de Controle online. ");

    ExceptionDetail(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;
    private String message;
}
