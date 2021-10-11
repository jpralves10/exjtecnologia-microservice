package br.com.exj.cadastro.repository.converters;

import br.com.exj.cadastro.enums.StatusTableEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

/**
 * Converter para o Enum de Status Table
 */
@Converter(autoApply = true)
public class StatusTableEnumAttributeConverter implements AttributeConverter<StatusTableEnum, String> {

    private static final StatusTableEnum NULL_STATUS_TABLE_ENUM = null;
    private static final String NULL_STRING = null;

    @Override
    public String convertToDatabaseColumn(StatusTableEnum status) {
        return Optional.ofNullable(status).map(StatusTableEnum::getStatus).orElse(NULL_STRING);
    }

    @Override
    public StatusTableEnum convertToEntityAttribute(String statusValue) {
        return Optional.ofNullable(statusValue).map(StatusTableEnum::getStatusByValue).orElse(NULL_STATUS_TABLE_ENUM);
    }
}
