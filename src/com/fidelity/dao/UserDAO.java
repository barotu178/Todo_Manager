package com.fidelity.dao;

import com.fidelity.model.User;

public interface UserDAO {
    void register(User user);
    User login(String username, String password);
}

