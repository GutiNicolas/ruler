package com.github.gutinicolas.ruler.service;

import com.github.gutinicolas.ruler.dao.GenericDao;
import com.github.gutinicolas.ruler.exceptions.DocumentNotFoundException;
import org.springframework.data.util.Pair;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public abstract class DataManipulationInterceptas<T> extends Interceptas {

    protected static GenericDao collection;

    public Future<Pair<ValidationStatusCode, T>> intercept() {
        try{
            T result = this.query();
            return CompletableFuture.completedFuture(Pair.of(ValidationStatusCode.OK, result));
        } catch (DocumentNotFoundException e) {
            e.getMessage();
            return CompletableFuture.completedFuture(Pair.of(ValidationStatusCode.NOT_FOUND, null));
        } catch (Exception e) {
            e.printStackTrace();
            return CompletableFuture.completedFuture(Pair.of(ValidationStatusCode.NOT_FOUND, null));
        }
    }

    protected abstract T query() throws Exception;

}
