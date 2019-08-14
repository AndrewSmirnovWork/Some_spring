package com.werdnaa.service;

import com.werdnaa.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User getById(int id);

    void delete(int id);

    void update(User user);

    List<User> findAll();
}
