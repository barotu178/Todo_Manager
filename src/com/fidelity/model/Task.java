package com.fidelity.model;

public class Task {
    private static int counter = 1;

    private int taskId;
    private String title;
    private String text;
    private String assignedTo;

    public Task(String title, String text, String assignedTo) {
        this.taskId = counter++;
        this.title = title;
        this.text = text;
        this.assignedTo = assignedTo;
    }

    public int getTaskId() { 
    	return taskId; 
    }
    public String getTitle() { 
    	return title; 
    }
    public String getText() {
    	return text; 
    }
    public String getAssignedTo() {
    	return assignedTo; 
    	
    }

    public void setTitle(String title) { 
    	this.title = title; 
    	
    }
    public void setText(String text) { 
    	this.text = text; 
    	}
    public void setAssignedTo(String assignedTo) { 
    	this.assignedTo = assignedTo; 
    	}

    public String toString() {
        return taskId + " | " + title + " | " + text + " | Assigned To: " + assignedTo;
    }
}

