package com.github.gutinicolas.ruler.service;

import com.github.gutinicolas.ruler.dao.GenericDao;
import com.github.gutinicolas.ruler.exceptions.DocumentNotFoundException;
import org.springframework.data.util.Pair;

public abstract class DataManipulationInterceptas<T> extends Interceptas {

    protected static GenericDao collection;

    public Pair<ValidationStatusCode, T> intercept() {
        try{
            T result = this.query();
            return Pair.of(ValidationStatusCode.OK, result);
        } catch (DocumentNotFoundException e) {
            e.getMessage();
            return Pair.of(ValidationStatusCode.NOT_FOUND, null);
        } catch (Exception e) {
            e.printStackTrace();
            return Pair.of(ValidationStatusCode.ERROR, null);
        }
    }

    protected abstract T query() throws Exception;

}
