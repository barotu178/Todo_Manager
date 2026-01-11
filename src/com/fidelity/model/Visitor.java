package com.fidelity.model;


public class Visitor extends User {
    public Visitor(String username, String password) {
        super(username, password);
    }
    public String getRole() { 
    	return "VISITOR"; 
    }
}
