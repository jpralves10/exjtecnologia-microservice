package br.com.exj.cadastro.service;

import br.com.exj.cadastro.entity.CheckoutEntity;
import br.com.exj.cadastro.entity.KafkaModel;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import javax.jms.Message;
import java.util.List;

public interface ExjtecnologiaService {

    CheckoutEntity checkoutExJTecnologia();

    List<CheckoutEntity> buscarCheckoutsExJTecnologia(String statusCheckout);

    void onReceiverTopic(Message message);

    void onReceiverTopicKafka(ConsumerRecord<String, KafkaModel> payload);
}
