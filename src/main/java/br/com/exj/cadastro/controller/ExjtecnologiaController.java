package br.com.exj.cadastro.controller;

import br.com.exj.cadastro.entity.*;
import br.com.exj.cadastro.service.ExjtecnologiaService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/exjtecnologia")
public class ExjtecnologiaController {

    private final Logger LOGGER = LoggerFactory.getLogger(ExjtecnologiaController.class);

    @Autowired
    private ExjtecnologiaService exjtecnologiaService;

    @Autowired
    private JmsTemplate jmsTemplateTopic;

    @Autowired
    private KafkaTemplate<String, KafkaModel> kafkaTemplate;

    @Value("${spring.activemq.topic}")
    private String topic;

    @Value("${kafka.producer.topic-name}")
    private String producerTopic;

    @GetMapping("/ola")
    public ResponseEntity<String> getExJTecnologia() {
        return ResponseEntity.ok("Hello World!");
    }

    @ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso")})
    @GetMapping("/checkout")
    public ResponseEntity<CheckoutModel> checkoutExJTecnologia(){

        CheckoutModel exjtecnologia = CheckoutModel.builder()
                .statusCheckout(true)
                .dataHoraCheckout(LocalDateTime.now())
                .build();

        return ResponseEntity.ok().body(exjtecnologia);
    }

    @ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso")})
    @GetMapping("/checkout/servicos")
    public ResponseEntity<CheckoutEntity> checkoutExJTecnologiaServicos(){

        CheckoutEntity checkoutEntity =
                exjtecnologiaService.checkoutExJTecnologia();

        if(checkoutEntity != null){
            return ResponseEntity.ok().body(checkoutEntity);
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    @ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso")})
    @GetMapping("/checkout/{statusCheckout}")
    public ResponseEntity<List<CheckoutEntity>> buscarCheckoutsExJTecnologia(
            @PathVariable String statusCheckout){

        List<CheckoutEntity> checkouts =
                exjtecnologiaService.buscarCheckoutsExJTecnologia(statusCheckout);

        if(checkouts != null){
            return ResponseEntity.ok().body(checkouts);
        }else{
            return ResponseEntity.noContent().build();
        }
    }

    @ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso")})
    @PostMapping("/checkout/activemq")
    public ResponseEntity<Object> obterStatusActiveMQ(@RequestBody ActiveMQModel activeMQModel){

        jmsTemplateTopic.convertAndSend(topic, activeMQModel);

        return ResponseEntity.ok().build();
    }

    @ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso")})
    @PostMapping("/checkout/kafka")
    public ResponseEntity<Object> producerKafka(@RequestBody KafkaModel kafkaModel){

        kafkaTemplate.send(producerTopic, kafkaModel);

        return ResponseEntity.ok().build();
    }
}
