package com.fidelity.app;

import java.util.Scanner;
import java.time.LocalDate;

import com.fidelity.dao.*;
import com.fidelity.model.*;
import com.fidelity.exception.*;

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

                    if (user instanceof Client) {
                        System.out.println("1.Add 2.Update 3.Delete 4.Sort ASC 5.Sort DESC");
                    } else {
                        System.out.println("1.View 2.Mark Completed 3.View Completed 4.View Pending 5.Sort ASC 6.Sort DESC");
                    }

                    int op = sc.nextInt();
                    sc.nextLine();

                    if (op == 0) break;

                    if (user instanceof Client) {
                        if (op == 1) {
                            System.out.print("Title: ");
                            String t = sc.nextLine();
                            System.out.print("Text: ");
                            String tx = sc.nextLine();
                            System.out.print("Assign To: ");
                            String a = sc.nextLine();
                            System.out.print("Completion Date (YYYY-MM-DD): ");
                            LocalDate d = LocalDate.parse(sc.nextLine());

                            taskDAO.addTask(new Task(t, tx, a, d));
                        }
                        if (op == 4)
                            taskDAO.sortByDateAsc(user.getUsername());
                        if (op == 5)
                            taskDAO.sortByDateDesc(user.getUsername());
                    } else {
                        if (op == 2) {
                            System.out.print("Task ID: ");
                            taskDAO.markCompleted(sc.nextInt(), user.getUsername());
                        }
                        if (op == 3)
                            taskDAO.showCompleted(user.getUsername());
                        if (op == 4)
                            taskDAO.showIncomplete(user.getUsername());
                        if (op == 5)
                            taskDAO.sortByDateAsc(user.getUsername());
                        if (op == 6)
                            taskDAO.sortByDateDesc(user.getUsername());
                    }
                }
            }
        }
        sc.close();
    }
}
