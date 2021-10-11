package br.com.exj.cadastro.config.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Classe abstrata de Mapper quando se deseja criar um mapper que gera
 * uma entidade de fora do Core (OuterEntity) à partir de uma do core (CoreEntity)
 *
 * @param <T> Entidade de fora do core (Entrypoint ou Dataprovider)
 * @param <E> Entidade do Core (UseCase)
 */
public abstract class FromMapper<T, E> {

    protected final T NULL_NOT_CORE_ENTITY = null;

    /**
     * Converter uma entidade do core em uma do Dataprovider/Entrypoint:
     * Retorna nulo caso o objeto de origem seja nulo.
     *
     * @param entity Entidade do Core
     * @return Entidade do Dataprovider/Entrypoint
     */
    public T from(E entity){
        return Optional.ofNullable(entity).map(this::fromNonNull).orElse(NULL_NOT_CORE_ENTITY);
    }

    protected abstract T fromNonNull(E entity);

    /**
     * Converter uma lista de entidades do core em uma de entidades do
     * Dataprovider/Entrypoint. Caso a lista de origem seja nula ou vazia,
     * retornar uma lista vazia.
     *
     * @param entities Lista de Entidades do Core
     * @return Lista entidade do Dataprovider/Entrypoint
     */
    public List<T> fromList(List<E> entities){
        return Optional.ofNullable(entities).map(this::fromListNonNull).orElse(Collections.emptyList());
    }

    private List<T> fromListNonNull(List<E> entities){
        return entities.stream().map(this::from).collect(Collectors.toList());
    }
}
