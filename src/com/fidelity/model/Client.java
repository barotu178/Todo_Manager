package com.fidelity.model;


public class Client extends User {
	
    public Client(String username, String password) {
        super(username, password);
    }
    public String getRole() { 
    	return "CLIENT"; 
    }
}

