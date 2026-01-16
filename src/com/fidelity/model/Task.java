package com.fidelity.model;

import java.time.LocalDate;

public class Task {

    private static int counter = 1;

    private int taskId;
    private String title;
    private String text;
    private String assignedTo;
    private LocalDate completionDate;
    private boolean completed;

    public Task(String title, String text, String assignedTo, LocalDate completionDate) {
        this.taskId = counter++;
        this.title = title;
        this.text = text;
        this.assignedTo = assignedTo;
        this.completionDate = completionDate;
        this.completed = false;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        this.completed = true;
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

    @Override
    public String toString() {
        return taskId + " | " + title +
                " | Due: " + completionDate +
                " | Assigned To: " + assignedTo +
                " | Status: " + (completed ? "COMPLETED" : "PENDING");
    }
}
