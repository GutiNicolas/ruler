package com.github.gutinicolas.ruler.dao;

import com.github.gutinicolas.ruler.model.User;

public interface UserDao {
    void saveUser(User user);
}

class UserDaoImpl implements UserDao{

    @Override
    public void saveUser(User user) {

    }
}
