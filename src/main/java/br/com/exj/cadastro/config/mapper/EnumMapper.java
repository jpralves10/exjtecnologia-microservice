package br.com.exj.cadastro.config.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Mapper genérico de Enums
 */
public class EnumMapper {

    private EnumMapper(){
        throw new IllegalStateException();
    }

    /**
     * Mapeia um enum para outro à partir do nome. Ex: HttpEnum.OPCAO_1 pode ser
     * mapeado para EntityEnum.OPCAO_1
     *
     * @param destinationClass Classe do Enum de destino
     * @param entityEnum Enum de origem para mapear
     * @param <H>
     * @param <E>
     * @return Enum de destino
     */
    public static <H extends Enum<H>, E extends Enum<E>> H mapByName(Class<H> destinationClass, E entityEnum){
        return Optional.ofNullable(entityEnum).map(e -> mapNonNullByName(destinationClass, entityEnum.name())).orElse(null);
    }

    private static <H extends Enum<H>, E extends Enum<E>> H mapNonNullByName(Class<H> destinationClass, String name){
        return H.valueOf(destinationClass, name);
    }

    /**
     * Mapeia uma lista de enums de um tipo para uma de outro à partir do nome.
     * Ex: HttpEnum.OPCAO_1 pode ser mapeado para EntityEnum.OPCAO_1
     *
     * @param destinationClass Classe do Enum de destino
     * @param entityEnums Lista de Enums de origem para mapear
     * @param <H>
     * @param <E>
     * @return Lista de Enums de destino
     */
    public static <H extends Enum<H>, E extends Enum<E>> List<H> mapListByName(Class<H> destinationClass, List<E> entityEnums){
        return Optional.ofNullable(entityEnums).map(e -> EnumMapper.mapNonNullListByName(destinationClass, e)).orElse(Collections.emptyList());
    }

    private static <H extends Enum<H>, E extends Enum<E>> List<H> mapNonNullListByName(Class<H> destinationClass, List<E> entityEnums){
        return entityEnums.stream().map(e -> EnumMapper.mapByName(destinationClass, e)).collect(Collectors.toList());
    }
}
