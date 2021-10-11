package br.com.exj.cadastro.config.mapper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Classe abstrata de Mapper quando se deseja criar um mapper que gera uma
 * entidade do core (CoreEntity) à partir de uma de fora do Core (OuterEntity)
 *
 * @param <T> Entidade de fora do core (Entrypoint ou DataProvider)
 * @param <E> Entidade do Core (UseCase)
 */
public abstract class ToMapper<T, E> {

    protected final E NULL_ENTITY = null;

    /**
     * Converter uma entidade do DataProvider/Entrypoint em uma do core.
     * Retorna nulo caso o objeto de origem seja nulo.
     *
     * @param outerEntity Entidade do Dataprovider/Entrypoint
     * @return Entidade do Core
     */
    public E to(T outerEntity){
        return Optional.ofNullable(outerEntity).map(this::toNonNull).orElse(NULL_ENTITY);
    }

    protected abstract E toNonNull(T entity);

    /**
     * Converte uma lista de entidades do DataProvider/Entrypoint em uma de
     * entidades do core. Caso a lista de origem seja nula ou vazia, retorna
     * uma lista vazia.
     *
     * @param outerEntities Lista de Entidades do DataProvider/Entrypoint
     * @return Lista entidade do Core
     */
    public List<E> toList(List<T> outerEntities){
        return Optional.ofNullable(outerEntities).map(this::toListNonNull).orElse(Collections.emptyList());
    }

    private List<E> toListNonNull(List<T> outerEntities){
        return outerEntities.stream().map(this::to).collect(Collectors.toList());
    }
}