package com.fidelity.app;

import java.util.Scanner;
import com.fidelity.model.*;
import com.fidelity.dao.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserDAO userDAO = new UserDAOImpl();
        TaskDAO taskDAO = new TaskDAOImpl();

        while (true) {
            System.out.println("1.Register 2.Login 0.Exit");
            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 0) break;

            if (ch == 1) {
                System.out.print("Username: ");
                String u = sc.nextLine();
                System.out.print("Password: ");
                String p = sc.nextLine();
                System.out.print("Role (client/visitor): ");
                String r = sc.nextLine();

                if (r.equalsIgnoreCase("client"))
                    userDAO.register(new Client(u, p));
                else
                    userDAO.register(new Visitor(u, p));
            }

            if (ch == 2) {
                System.out.print("Username: ");
                String u = sc.nextLine();
                System.out.print("Password: ");
                String p = sc.nextLine();

                User user = userDAO.login(u, p);
                if (user == null) {
                    System.out.println("Invalid Login");
                    continue;
                }

                while (true) {
                    System.out.println("0.Logout");
                    if (user.getRole().equals("CLIENT")) {
                        System.out.println("1.Add 2.Update 3.Delete 4.Search 5.View All");
                    } else {
                        System.out.println("1.View My Tasks");
                    }

                    int op = sc.nextInt();
                    sc.nextLine();
                    if (op == 0) break;

                    if (user.getRole().equals("CLIENT")) {
                        if (op == 1) {
                            System.out.print("Title: ");
                            String t = sc.nextLine();
                            System.out.print("Text: ");
                            String tx = sc.nextLine();
                            System.out.print("Assign to: ");
                            String a = sc.nextLine();
                            taskDAO.addTask(new Task(t, tx, a));
                        }
                        if (op == 2) {
                            System.out.print("ID: ");
                            int id = sc.nextInt(); sc.nextLine();
                            System.out.print("New Title: ");
                            String t = sc.nextLine();
                            System.out.print("New Text: ");
                            String tx = sc.nextLine();
                            System.out.print("Assign To: ");
                            String a = sc.nextLine();
                            taskDAO.updateTask(id, t, tx, a);
                        }
                        if (op == 3) {
                            System.out.print("ID: ");
                            taskDAO.deleteTask(sc.nextInt());
                        }
                        if (op == 4) {
                            System.out.print("Title: ");
                            taskDAO.searchTask(sc.nextLine());
                        }
                        if (op == 5) taskDAO.showAll();
                    } else {
                        taskDAO.showByUser(user.getUsername());
                    }
                }
            }
        }
        sc.close();
    }
}

