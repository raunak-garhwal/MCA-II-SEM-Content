import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Invalid age. Age cannot be negative.");
        }
    }
}

class Employee extends Person {
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Invalid salary. Salary cannot be negative.");
        }
    }

    public void displayEmployeeDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Salary: $" + getSalary());
    }

    public void insertIntoDatabase() {
        String insertQuery = "INSERT INTO employees (name, age, salary) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(Inheritance.DB_URL + Inheritance.DB_NAME, Inheritance.DB_USER, Inheritance.DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {

            pstmt.setString(1, this.getName());
            pstmt.setInt(2, this.getAge());
            pstmt.setDouble(3, this.getSalary());
            pstmt.executeUpdate();

            System.out.println("Employee details inserted successfully.");

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

public class Inheritance {
    // Database URL, username, and password
    public static final String DB_URL = "jdbc:mysql://localhost:3306/";
    public static final String DB_NAME = "Employee"; // Replace with your database name
    public static final String DB_USER = "root"; // Your DB username
    public static final String DB_PASSWORD = ""; // Your DB password

    public static void main(String[] args) {
        // Initialize the database and table
        initializeDatabase();

        Scanner scanner = new Scanner(System.in);

        Employee employee = new Employee();

        System.out.print("Enter employee's name: ");
        String name = scanner.nextLine();
        employee.setName(name);

        System.out.print("Enter employee's age: ");
        int age = scanner.nextInt();
        employee.setAge(age);

        System.out.print("Enter employee's salary: ");
        double salary = scanner.nextDouble();
        employee.setSalary(salary);

        employee.displayEmployeeDetails();
        
        // Insert employee details into the database
        employee.insertIntoDatabase();

        scanner.close();
    }

    private static void initializeDatabase() {
        String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS " + DB_NAME;
        String createTableQuery = "CREATE TABLE IF NOT EXISTS " + DB_NAME + ".employees (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(255) NOT NULL, " +
                "age INT NOT NULL, " +
                "salary DOUBLE NOT NULL" +
                ")";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(createDatabaseQuery)) {

            // Create database if it doesn't exist
            stmt.execute();
            System.out.println("Database created or already exists.");

        } catch (SQLException e) {
            System.out.println("Error creating database: " + e.getMessage());
            e.printStackTrace();
        }

        // Use the database and create the table
        try (Connection conn = DriverManager.getConnection(DB_URL + DB_NAME, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(createTableQuery)) {

            // Create table if it doesn't exist
            stmt.execute();
            System.out.println("Table created or already exists.");

        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
            e.printStackTrace();
        }
    }
}