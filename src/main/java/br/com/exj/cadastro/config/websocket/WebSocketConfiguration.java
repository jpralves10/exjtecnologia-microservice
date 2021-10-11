package br.com.exj.cadastro.config.websocket;

import br.com.exj.cadastro.config.util.RotasWebSocketUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        registry.addEndpoint(RotasWebSocketUtil.END_POINT_SOCKET_JS)
                .setAllowedOrigins("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){
        registry.setApplicationDestinationPrefixes(RotasWebSocketUtil.URL_ONLINE_PREFIX)
                .enableSimpleBroker(RotasWebSocketUtil.ROTA_ACAO_SUGERIDA,
                                    RotasWebSocketUtil.ROTA_STATUS,
                                    RotasWebSocketUtil.ROTA_VALOR_LIQUIDADO,
                                    RotasWebSocketUtil.ROTA_VALOR_SUFICIENCIA);
    }
}
