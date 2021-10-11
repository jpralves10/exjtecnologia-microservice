package br.com.exj.cadastro.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KafkaModelTest {

    @Test
    public void test00(){
        KafkaModel.KafkaModelBuilder kafkaModelBuilder0 = KafkaModel.builder();
        KafkaModel.KafkaModelBuilder kafkaModelBuilder1 = kafkaModelBuilder0.message("");
        Assertions.assertSame(kafkaModelBuilder0, kafkaModelBuilder1);
    }
}
