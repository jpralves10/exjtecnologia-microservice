package br.com.exj.cadastro.converters;

import br.com.exj.cadastro.enums.StatusTableEnum;
import br.com.exj.cadastro.repository.converters.StatusTableEnumAttributeConverter;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StatusTableEnumAttributeConverterTest {

    @Test
    public void test0() throws Throwable {
        StatusTableEnumAttributeConverter converter = new StatusTableEnumAttributeConverter();
        StatusTableEnum statusTableEnum = converter.convertToEntityAttribute("1");
        assertEquals(StatusTableEnum.ATIVO, statusTableEnum);
    }

    @Test
    public void test1() throws Throwable {
        StatusTableEnumAttributeConverter converter = new StatusTableEnumAttributeConverter();
        StatusTableEnum statusTableEnum = StatusTableEnum.ENCERRADO;
        String string0 = converter.convertToDatabaseColumn(statusTableEnum);
        assertEquals("4", string0);
    }

    @Test
    public void test2() throws Throwable {
        StatusTableEnumAttributeConverter converter = new StatusTableEnumAttributeConverter();
        assertNull(converter.convertToDatabaseColumn((StatusTableEnum) null));
    }
}
