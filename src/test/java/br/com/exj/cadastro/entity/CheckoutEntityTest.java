package br.com.exj.cadastro.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckoutEntityTest {

    @Test
    public void test00(){
        CheckoutEntity.CheckoutEntityBuilder CheckoutEntityBuilder0 = CheckoutEntity.builder();
        CheckoutEntity.CheckoutEntityBuilder CheckoutEntityBuilder1 = CheckoutEntityBuilder0.id(null);
        Assertions.assertSame(CheckoutEntityBuilder0, CheckoutEntityBuilder1);
    }

    @Test
    public void test01(){
        CheckoutEntity.CheckoutEntityBuilder CheckoutEntityBuilder0 = CheckoutEntity.builder();
        CheckoutEntity.CheckoutEntityBuilder CheckoutEntityBuilder1 = CheckoutEntityBuilder0.statusCheckout("");
        Assertions.assertSame(CheckoutEntityBuilder0, CheckoutEntityBuilder1);
    }

    @Test
    public void test02(){
        CheckoutEntity.CheckoutEntityBuilder CheckoutEntityBuilder0 = CheckoutEntity.builder();
        CheckoutEntity.CheckoutEntityBuilder CheckoutEntityBuilder1 = CheckoutEntityBuilder0.servicosDisponiveis("");
        Assertions.assertSame(CheckoutEntityBuilder0, CheckoutEntityBuilder1);
    }

    @Test
    public void test03(){
        CheckoutEntity.CheckoutEntityBuilder CheckoutEntityBuilder0 = CheckoutEntity.builder();
        CheckoutEntity.CheckoutEntityBuilder CheckoutEntityBuilder1 = CheckoutEntityBuilder0.dataHoraCheckout(null);
        Assertions.assertSame(CheckoutEntityBuilder0, CheckoutEntityBuilder1);
    }
}
