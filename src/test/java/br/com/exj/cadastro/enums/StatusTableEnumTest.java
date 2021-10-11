package br.com.exj.cadastro.enums;

import org.junit.jupiter.api.Test;

import java.util.IllegalFormatConversionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class StatusTableEnumTest {

    @Test
    public void test0() throws Throwable {
        Boolean boolean0 = Boolean.FALSE;
        StatusTableEnum statusTableEnum = StatusTableEnum.getStatusByActive(boolean0);
        String string0 = statusTableEnum.getStatus();
        assertEquals("2", string0);
    }

    @Test
    public void test1() throws Throwable {
        StatusTableEnum statusTableEnum = StatusTableEnum.getStatusByValue("2");
        assertEquals(StatusTableEnum.INATIVO, statusTableEnum);
    }

    @Test
    public void test2() throws Throwable {
        try {
            StatusTableEnum.getStatusByValue("br.com.exj.cadastro.enums.StatusTableEnum");
            fail("Expecting exception: IllegalFormatConversionException");
        }catch (IllegalFormatConversionException e){
            //
        }
    }

    @Test
    public void test3() throws Throwable {
        StatusTableEnum statusTableEnum = StatusTableEnum.valueOf("AGUARDANDO_APROVACAO");
        assertEquals("3", statusTableEnum.getStatus());
    }

    @Test
    public void test4() throws Throwable {
        StatusTableEnum[] statusTableEnums = StatusTableEnum.values();
        assertEquals(4, statusTableEnums.length);
    }

    @Test
    public void test5() throws Throwable {
        StatusTableEnum statusTableEnum = StatusTableEnum.getStatusByValue("1");
        assertEquals(StatusTableEnum.ATIVO, statusTableEnum);
    }
}
