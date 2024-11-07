// Inheritance: Create a class Person with fields for name and age. Create a subclass Employee that adds a field for salary and a method to display employee details. Write a main method to create and display an employee's details.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person {

    protected String name;
    protected int age;

    public void setName(String name) {
        // Regular expression to match names containing only letters, spaces, hyphens and apostrophes
        if (name.matches("[a-zA-Z\\s'-]+")) {
            this.name = name;
        } else {
            System.out.println("Invalid name. Please enter a name with only letters and valid characters.");
        }
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Employee extends Person {

    private int salary;

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void displayEmployeeDetails() {
        System.out.println("Name of the employee: " + this.name);
        System.out.println("Age of the employee: " + this.age);
        System.out.println("Salary of the employee: " + this.salary);
    }
}

public class Inheritance {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();   // List to store multiple Employee objects

        while (true) {
            System.out.println("\n<--- MENU DRIVEN PROGRAM --->");
            System.out.println("Press 1 for registering a new employee.");
            System.out.println("Press 2 for getting employee information.");
            System.out.println("Press 3 to exit.");
            Scanner myobj = new Scanner(System.in);
            System.out.println("\nEnter your choice: ");
            try {
                int choice = myobj.nextInt();
                switch (choice) {
                    case 1 -> {
                        Employee emp1 = new Employee();
                        System.out.println("\n<--- Enter the Employee Details --->");
                        System.out.print("\nEnter the name of the employee: ");
                        String name = myobj.next();
                        emp1.setName(name);
                        // Input employee age with validation
                        while (true) {
                            System.out.println("Enter the age of the employee: ");
                            int age = myobj.nextInt();
                            if (age >= 20 && age <= 60) {
                                emp1.setAge(age);
                                break;
                            } else {
                                System.out.println("\nPlease enter the age between 20 and 60...");
                            }
                        }
                        // Input employee salary with validation
                        while (true) {
                            System.out.println("Enter the salary of the employee: ");
                            int salary = myobj.nextInt();
                            if (salary >= 10000) {
                                emp1.setSalary(salary);
                                break;
                            } else {
                                System.out.println("Salary must be a positive integer and greater than or equal to 10000.");
                            }
                        }
                        // Add the employee to the list
                        employees.add(emp1);
                        System.out.println("Employee registered successfully!");
                    }

                    case 2 -> {
                        if (employees.isEmpty()) {
                            System.out.println("WARNING: No employees registered yet...");
                        } else {
                            System.out.println("\n<--- Employee Details --->");
                            System.out.print("\nEnter the name of the employee (or press Enter to list all): ");
                            myobj.nextLine(); // Consume the newline left by nextInt()
                            String userName = myobj.nextLine();

                            if (userName.isEmpty()) {
                                // If user presses Enter, display all employees
                                System.out.println("\nListing all registered employees :-\n");
                                for (Employee employee : employees) {
                                    employee.displayEmployeeDetails();
                                    System.out.println();
                                }
                            } else {
                                // Find and display employee details by name
                                boolean found = false;
                                for (Employee employee : employees) {
                                    if (employee.name.equalsIgnoreCase(userName)) {
                                        employee.displayEmployeeDetails();
                                        found = true;
                                        break;
                                    }
                                }
                                if (!found) {
                                    System.out.println("No employee registered with this name.");
                                }
                            }
                        }
                    }

                    case 3 -> {
                        System.out.println("\nThanks for using this program......Please come back soon......");
                        myobj.close();
                        return;
                    }

                    default -> System.out.println("\nPlease enter a valid choice.");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid numerical choice.");
            }
        }
    }
}