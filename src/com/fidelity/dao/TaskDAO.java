package com.fidelity.dao;

import com.fidelity.model.Task;

public interface TaskDAO {

    void addTask(Task task);
    void updateTask(int id, String title, String text, String assignedTo);
    void deleteTask(int id);

    void showByUser(String username);

    void markCompleted(int id, String username);
    void showCompleted(String username);
    void showIncomplete(String username);

    void sortByDateAsc(String username);
    void sortByDateDesc(String username);
}
