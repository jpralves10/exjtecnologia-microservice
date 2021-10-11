package br.com.exj.cadastro.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckoutModelTest {

    @Test
    public void test00(){
        CheckoutModel.CheckoutModelBuilder CheckoutModelBuilder0 = CheckoutModel.builder();
        CheckoutModel.CheckoutModelBuilder CheckoutModelBuilder1 = CheckoutModelBuilder0.statusCheckout(true);
        Assertions.assertSame(CheckoutModelBuilder0, CheckoutModelBuilder1);
    }

    @Test
    public void test01(){
        CheckoutModel.CheckoutModelBuilder CheckoutModelBuilder0 = CheckoutModel.builder();
        CheckoutModel.CheckoutModelBuilder CheckoutModelBuilder1 = CheckoutModelBuilder0.dataHoraCheckout(null);
        Assertions.assertSame(CheckoutModelBuilder0, CheckoutModelBuilder1);
    }
}
