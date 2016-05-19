package com.makitoo.java.servlet.service;

import com.makitoo.java.servlet.model.User;

import java.util.Collection;

/**
 * Created by mclement on 5/17/2016.
 */
public interface UserService {

    Collection<User> getAll();

    User retrieve(String id);

    User save(User user);

    User update(User user);

    User delete(String id);

}
