package com.makitoo.java.servlet.service.impl;

import com.makitoo.java.servlet.model.User;
import com.makitoo.java.servlet.service.UserService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by mclement on 5/17/2016.
 */
public class UserServiceImpl implements UserService {

    /**
     * Simulate Database
     */
    private static final Map<String, User> users = new HashMap<String, User>();

    @Override
    public Collection<User> getAll() {
        return users.values();
    }

    @Override
    public User retrieve(String id) {
        return users.get(id);
    }

    @Override
    public User save(User user) {
        String id = UUID.randomUUID().toString();
        user.setId(id);
        user.setLastname(user.getLastname().toUpperCase());
        users.put(id, user);
        return user;
    }

    @Override
    public User update(User user) {
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public User delete(String id) {
        return users.remove(id);
    }
}
