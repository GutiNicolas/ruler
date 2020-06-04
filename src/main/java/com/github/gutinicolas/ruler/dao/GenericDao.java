package com.github.gutinicolas.ruler.dao;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Future;

public interface GenericDao<T> {
    /**
     * Saves an object on the collection
     *
     * @param t
     * @return
     */
    Future<Integer> save(T t);

    /**
     * Updates an object on the collection
     * @param t
     * @return
     */
    Future<Integer> update(T t);

    Future<Optional<T>> findById(UUID id);

}

