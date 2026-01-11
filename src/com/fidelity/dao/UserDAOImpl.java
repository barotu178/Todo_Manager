package com.fidelity.dao;

import com.fidelity.model.*;

public class UserDAOImpl implements UserDAO {
    private User[] users = new User[20];
    private int index = 0;

    public void register(User user) {
        users[index++] = user;
        System.out.println("User Registered");
    }
    
    public User login(String username, String password) {
        for (int i = 0; i < index; i++) {
            if (users[i].getUsername().equals(username)
             && users[i].getPassword().equals(password)) {
                return users[i];
            }
        }
        return null;
    }
}

