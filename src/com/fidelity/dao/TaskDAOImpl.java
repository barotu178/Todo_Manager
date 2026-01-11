package com.fidelity.dao;

import com.fidelity.model.Task;

public class TaskDAOImpl implements TaskDAO {
    private Task[] tasks = new Task[50];
    private int index = 0;

    public void addTask(Task task) {
        tasks[index++] = task;
        System.out.println("Task Added!");
    }

    public void updateTask(int id, String title, String text, String assignedTo) {
        for (int i = 0; i < index; i++) {
            if (tasks[i].getTaskId() == id) {
                tasks[i].setTitle(title);
                tasks[i].setText(text);
                tasks[i].setAssignedTo(assignedTo);
                System.out.println("Task Updated");
                return;
            }
        }
        System.out.println("Task not found");
    }

    public void deleteTask(int id) {
        for (int i = 0; i < index; i++) {
            if (tasks[i].getTaskId() == id) {
                for (int j = i; j < index - 1; j++) {
                    tasks[j] = tasks[j + 1];
                }
                index--;
                System.out.println("Task Deleted");
                return;
            }
        }
        System.out.println("Task not found");
    }

    public void searchTask(String title) {
        for (int i = 0; i < index; i++) {
            if (tasks[i].getTitle().equalsIgnoreCase(title)) {
                System.out.println(tasks[i]);
            }
        }
    }

    public void showAll() {
        for (int i = 0; i < index; i++) {
            System.out.println(tasks[i]);
        }
    }

    public void showByUser(String username) {
        for (int i = 0; i < index; i++) {
            if (tasks[i].getAssignedTo().equalsIgnoreCase(username)) {
                System.out.println(tasks[i]);
            }
        }
    }
}

