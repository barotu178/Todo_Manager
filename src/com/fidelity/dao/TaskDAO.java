package com.fidelity.dao;

import com.fidelity.model.Task;

public interface TaskDAO {
    void addTask(Task task);
    void updateTask(int id, String title, String text, String assignedTo);
    void deleteTask(int id);
    void searchTask(String title);
    void showAll();
    void showByUser(String username);
}
