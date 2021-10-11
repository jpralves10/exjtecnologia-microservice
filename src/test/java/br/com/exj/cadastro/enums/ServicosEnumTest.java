package br.com.exj.cadastro.enums;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ServicosEnumTest {

    @Test
    public void test0() throws Throwable {
        String string0 = "0";
        ServicosEnum servicosEnum = ServicosEnum.getEnumByKey(string0);
        assertEquals("0", servicosEnum.getKey());
    }

    @Test
    public void test1() throws Throwable {
        ServicosEnum servicosEnum = ServicosEnum.getEnumByKey("1");
        assertEquals(ServicosEnum.EXJTECNOLOGIA, servicosEnum);
    }

    @Test
    public void test2() throws Throwable {
        assertNull(ServicosEnum.getEnumByKey(null));
    }

    @Test
    public void test3() throws Throwable {
        ServicosEnum servicosEnum = ServicosEnum.valueOf("AUTENTICACAO");
        assertEquals("Autenticacao", servicosEnum.getDescription());
    }

    @Test
    public void test4() throws Throwable {
        ServicosEnum[] servicosEnums = ServicosEnum.values();
        assertEquals(2, servicosEnums.length);
    }
}
