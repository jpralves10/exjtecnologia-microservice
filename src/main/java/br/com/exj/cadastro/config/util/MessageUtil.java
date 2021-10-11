package br.com.exj.cadastro.config.util;

/**
 * Mensagens utilizadas na aplicação
 */
public class MessageUtil {

    public static final String INVALID_CODE_MESSAGE = "Código inválido: ";
    public static final String INVALID_DESCRIPTION_MESSAGE = "Descrição inválida!";
    public static final String INVALID_NUMERIC_CODE_MESSAGE = INVALID_CODE_MESSAGE + "%d";
    public static final String INVALID_TEXT_CODE_MESSAGE = INVALID_CODE_MESSAGE + "%s";
    public static final String INVALID_OFFSET_AND_LIMIT_PARAM = "Parâmetros offset e limit incorretos";
    public static final String MESSAGE_INVALID = "Status inválido";

    public static final String SERVICO_503 = "Serviço Temporariamente Indisponível";
    public static final String SERVICO_400 = "Solicitação Imprópria";
    public static final String SERVICO_500 = "O servidor encotrou um erro interno ou uma configuração errada e não pôde concluir sua solicitação";

    /* Domínios da Ação */
    public static final String BEAN_ERROR = "Ocorreu um erro ao recuperar o bean";
    public static final String CLASS_NOT_FOUND = "Não foi encontrada a classe de configuração da ação";

    public static final String FEIGN_ADMIN = "Serviço Admin Temporariamente Indisponível";
    public static final String FEIGN_ECONOMIA = "Serviço Economia Temporariamente Indisponível";
    public static final String FEIGN_CONTABIL = "Serviço Contabil Temporariamente Indisponível";

    /* Token */
    public static final String FALHA_SEGURANCA_TOKEN = "Falha ao tentar recuperar o Token enviado para a aplicação";
    public static final String TOKEN_SECURYT_RECOVER_FAIL = "Falha ao tentar recuperar o Token enviado para a aplicação";

    /* Auditoria Log */
    public static final String CADASTRO_AUDT_LOG = "Não foi possível salvar o Log de Auditoria do Cadastro";
}
