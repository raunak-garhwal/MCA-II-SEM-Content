// Encapsulation: Write a Java program to create a class Student with private fields for name, age, and grade. Provide public getter and setter methods for each field. Ensure that the age and grade are within a valid range (e.g., age between 5 and 25, grade between 1 and 10).

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {

    private String name;
    private int age;
    private int grade;

    // Method to set name with validation to allow only real names
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

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public int getGrade() {
        return this.grade;
    }

    public void displayDetails() {
        System.out.println("\nName of the student: " + getName());
        System.out.println("Age of the student: " + getAge());
        System.out.println("Grade of the student: " + getGrade());
    }
}

public class Encapsulation {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();   // List to store multiple Student objects

        while (true) {
            System.out.println("\n<--- MENU DRIVEN PROGRAM --->");
            System.out.println("Press 1 for registering a new student.");
            System.out.println("Press 2 for getting student information.");
            System.out.println("Press 3 to exit.");
            Scanner myobj = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            try {
                int choice = myobj.nextInt();
                switch (choice) {
                    case 1 -> {
                        Student s1 = new Student();
                        System.out.println("\n<---Enter the Student Details--->");
                        System.out.print("\nEnter the name of the student: ");
                        String name = myobj.next();
                        s1.setName(name);
                        
                        while (true) {
                            System.out.print("Enter the age of the student: ");
                            int age = myobj.nextInt();
                            if (age >= 5 && age <= 25) {
                                s1.setAge(age);
                                break;
                            } else {
                                System.out.println("\nPlease enter the age between 5 and 25...");
                            }
                        }

                        while (true) {
                            System.out.print("Enter the grade of the student: ");
                            int grade = myobj.nextInt();
                            if (grade >= 1 && grade <= 10) {
                                s1.setGrade(grade);
                                break;
                            } else {
                                System.out.println("Please enter the grade between 1 and 10...");
                            }
                        }
                        // Add the student to the list
                        students.add(s1);
                        System.out.println("Student registered successfully!");
                    }

                    case 2 -> {
                        if (students.isEmpty()) {
                            System.out.println("WARNING: No students registered yet...");
                        } else {
                            System.out.println("\n<---Student Details--->");
                            System.out.print("\nEnter the name of the student (or press Enter to list all): ");
                            myobj.nextLine(); // Consume the newline left by nextInt()
                            String userName = myobj.nextLine();

                            if (userName.isEmpty()) {
                                // If user presses Enter, display all students
                                System.out.println("\nListing all registered students:-");
                                for (Student student : students) {
                                    student.displayDetails();
                                }
                            } else {
                                // Find and display student details by name
                                boolean found = false;
                                for (Student student : students) {
                                    if (student.getName().equalsIgnoreCase(userName)) {
                                        student.displayDetails();
                                        found = true;
                                        break;
                                    }
                                }
                                if (!found) {
                                    System.out.println("No student registered with this name.");
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
                System.out.println("Please enter a valid numerical value....");
            }
        }
    }
}