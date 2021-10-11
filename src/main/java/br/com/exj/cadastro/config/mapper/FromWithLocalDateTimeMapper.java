package br.com.exj.cadastro.config.mapper;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Classe abstrata de Mapper quando se deseja criar um mapper
 * que gera uma entidade de fora do Core (OuterEntity) à partir
 * de uma do core (CoreEntity)
 *
 * @param <T> Entidade de fora do core (Entrypoint ou Dataprovider)
 * @param <E> Entidade do Core (UseCase)
 */
public abstract class FromWithLocalDateTimeMapper<T, E> {

    protected final T NULL_NOT_CORE_ENTITY = null;

    /**
     * Converter uma entidade do core em uma do Dataprovider/Entrypoint.
     * Retorna nulo caso o objeto de origem seja nulo.
     *
     * @param entity Entidade do Core
     * @param validityStart
     * @param contractId
     * @param userInfo
     * @return Entidade do Dataprovider/Entrypoint
     */
    public T from(E entity, LocalDateTime validityStart, Long contractId, String userInfo){
        return Optional.ofNullable(entity).map(e -> fromNonNull(e, validityStart, contractId, userInfo)).orElse(NULL_NOT_CORE_ENTITY);
    }

    protected abstract T fromNonNull(E entity, LocalDateTime validityStart, Long contractId, String userInfo);
}
