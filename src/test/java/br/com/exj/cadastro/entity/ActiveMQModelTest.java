package br.com.exj.cadastro.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActiveMQModelTest {

    @Test
    public void test00(){
        ActiveMQModel.ActiveMQModelBuilder ActiveMQModelBuilder0 = ActiveMQModel.builder();
        ActiveMQModel.ActiveMQModelBuilder ActiveMQModelBuilder1 = ActiveMQModelBuilder0.user("");
        Assertions.assertSame(ActiveMQModelBuilder0, ActiveMQModelBuilder1);
    }

    @Test
    public void test01(){
        ActiveMQModel.ActiveMQModelBuilder ActiveMQModelBuilder0 = ActiveMQModel.builder();
        ActiveMQModel.ActiveMQModelBuilder ActiveMQModelBuilder1 = ActiveMQModelBuilder0.tipo("");
        Assertions.assertSame(ActiveMQModelBuilder0, ActiveMQModelBuilder1);
    }
}
