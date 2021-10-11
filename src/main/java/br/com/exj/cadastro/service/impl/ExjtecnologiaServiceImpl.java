package br.com.exj.cadastro.service.impl;

import br.com.exj.cadastro.config.util.RotasWebSocketUtil;
import br.com.exj.cadastro.entity.ActiveMQModel;
import br.com.exj.cadastro.entity.CheckoutModel;
import br.com.exj.cadastro.entity.CheckoutEntity;
import br.com.exj.cadastro.entity.KafkaModel;
import br.com.exj.cadastro.enums.ServicosEnum;
import br.com.exj.cadastro.exceptions.ServiceUnavailableException;
import br.com.exj.cadastro.feign.AutenticacaoFeignClient;
import br.com.exj.cadastro.repository.ExjtecnologiaRepository;
import br.com.exj.cadastro.service.ExjtecnologiaService;
import feign.FeignException;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.ObjectMessage;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ExjtecnologiaServiceImpl implements ExjtecnologiaService {

    private final Logger LOGGER = LoggerFactory.getLogger(ExjtecnologiaServiceImpl.class);

    private final String INICIALIZANDO_CHECKOUT_SERVICOS = "[Checkout Serviços] | Inicializando checkout de serviçõs";
    private final String FINALIZANDO_CHECKOUT_SERVICOS = "[Checkout Serviços] | Finalizando checkout de serviços";
    private final String CONSULTA_CHECKOUT_SERVICOS = "[Checkout Serviços] | Consulta checkout de serviços";

    @Autowired
    private ExjtecnologiaRepository exjtecnologiaRepository;

    @Autowired
    private AutenticacaoFeignClient autenticacaoFeignClient;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    public CheckoutEntity checkoutExJTecnologia(){

        try {
            LOGGER.info(INICIALIZANDO_CHECKOUT_SERVICOS);

            CheckoutModel checkoutModel =
                    this.checkoutAutenticacao();

            List<String> servicos = new ArrayList<>();

            if (checkoutModel != null && checkoutModel.getStatusCheckout())
                servicos.add(ServicosEnum.AUTENTICACAO.getDescription());

            String status = servicos.size() < 1 ? "FALHA" : "OK";

            CheckoutEntity checkoutEntity = CheckoutEntity.builder()
                    .statusCheckout(status)
                    .servicosDisponiveis(servicos.toString())
                    .dataHoraCheckout(LocalDateTime.now())
                    .build();

            exjtecnologiaRepository.save(checkoutEntity);

            LOGGER.info(FINALIZANDO_CHECKOUT_SERVICOS);

            return checkoutEntity;
        } catch (ServiceUnavailableException e){
            throw e;
        }
    }

    @Bulkhead(name = "autenticacao", fallbackMethod = "fallbackAutenticacao")
    public CheckoutModel checkoutAutenticacao() {
        ResponseEntity<CheckoutModel> responseEntity =
                autenticacaoFeignClient.checkoutAutenticacao("");

        return responseEntity != null ? responseEntity.getBody() : null;
    }

    private CheckoutModel fallbackAutenticacao(FeignException e) {
        System.out.println("...fallbackAutenticacao");
        return CheckoutModel.builder()
                .statusCheckout(false)
                .dataHoraCheckout(LocalDateTime.now())
                .build();
    }

    public List<CheckoutEntity> buscarCheckoutsExJTecnologia(String statusCheckout){
        try {
            LOGGER.info(CONSULTA_CHECKOUT_SERVICOS);

            List<CheckoutEntity> listCheckout =
                    exjtecnologiaRepository.buscarCheckoutsPorStatus(statusCheckout);

            /**
             * WebSocket message
             */
            if(this.simpMessagingTemplate != null)
                this.simpMessagingTemplate.convertAndSend(RotasWebSocketUtil.ROTA_STATUS, listCheckout);

            return listCheckout;

        } catch (ServiceUnavailableException e){
            throw e;
        }
    }

    @JmsListener(destination = "${spring.activemq.topic}", containerFactory = "jmsFactoryTopic")
    public void onReceiverTopic(Message message) {
        try{
            ObjectMessage objectMessage = (ObjectMessage) message;
            ActiveMQModel active = (ActiveMQModel) objectMessage.getObject();

            LOGGER.info("AQUI:: " + active.getUser() + " - " + active.getTipo());
            System.out.println( active.getUser() + " - " + active.getTipo() );

        } catch(Exception e) {
            LOGGER.error("Received Exception JMS : "+ e);
        }
    }

    @KafkaListener(topics = "${kafka.consumer.topic-name}", groupId = "group_id")
    public void onReceiverTopicKafka(ConsumerRecord<String, KafkaModel> payload){
        LOGGER.info("key: {}", payload.key());
        LOGGER.info("Headers: {}", payload.headers());
        LOGGER.info("Partion: {}", payload.partition());
        LOGGER.info("Model: {}", payload.value());
    }
}
