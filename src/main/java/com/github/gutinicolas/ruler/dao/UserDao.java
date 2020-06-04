package com.github.gutinicolas.ruler.dao;

import com.github.gutinicolas.ruler.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Future;

public interface UserDao extends GenericDao<User> {

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);
}

class UserDaoImpl implements UserDao{

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Future<Integer> save(User user) {
        return null;
    }

    @Override
    public Future<Integer> update(User user) {
        return null;
    }

    @Override
    public Future<Optional<User>> findById(UUID id) {
        return null;
    }
}
