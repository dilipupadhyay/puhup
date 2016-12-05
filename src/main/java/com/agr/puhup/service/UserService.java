package com.agr.puhup.service;

import com.agr.puhup.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
