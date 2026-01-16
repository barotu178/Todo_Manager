# Todo Manager

## Description
Todo Manager is a Java-based application to manage and track daily tasks.  
It supports multiple users (clients and visitors), task assignment, and provides basic CRUD operations for tasks.  
This project was developed incrementally over 4 sprints, improving functionality and design each week.

---

## Features by Sprint

### Sprint 1
- Print user name on screen
- List at least 5 tasks for the day
- View tasks in increasing or decreasing order
- Detect repeated tasks

### Sprint 2
- Add, update, delete, and search tasks using arrays
- Persistent menu loop until user exits
- Code refactored for better structure

### Sprint 3
- Introduced `Task` object with:
  - Task ID (auto-generated)
  - Task title
  - Task text
  - Assigned user
- CRUD operations handled in DAO classes
- Main menu handles user interaction

### Sprint 4
- User registration and login
- Two types of users:
  - **Client**: can add, update, delete, search, and assign tasks
  - **Visitor**: can view tasks assigned to them
- Refactored code to include `User`, `Client`, `Visitor` classes
- DAO interfaces and implementation classes for tasks and users
- Menu loop persists until user chooses to exit

---

## Technology Stack
- Java 17
- Eclipse IDE
- Git & GitHub for version control

  
---

## How to Run
1. Clone the repository:
```bash
git clone https://github.com/barotu178/Todo_Manager.git
2. Open the project in Eclipse as a Java project

3. Navigate to Main.java and run the program

4. Use the menu to add, update, delete, search, or assign tasks

---
Future Enhancements

Database integration for persistent storage

Graphical User Interface (GUI)

Notifications or reminders for tasks

Multi-user support with authentication and roles

## Project Structure

Author
Obaro Aruotu
Trenton, NJ
