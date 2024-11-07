import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDatabaseManager {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    private static final String DATABASE = "school";
    private static final String CREATE_DATABASE = "CREATE DATABASE IF NOT EXISTS " + DATABASE;
    private static final String USE_DATABASE = "USE " + DATABASE;
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS students (" +
            "id INT AUTO_INCREMENT PRIMARY KEY, " +
            "name VARCHAR(255) NOT NULL, " +
            "age INT NOT NULL, " +
            "grade INT NOT NULL" +
            ")";
    private static final String INSERT_STUDENT = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
    private static final String RETRIEVE_STUDENT_BY_ID = "SELECT * FROM students WHERE id = ?";
    private static final String RETRIEVE_STUDENT_BY_NAME = "SELECT * FROM students WHERE name = ?";

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);) {
            initializeDatabase(connection);

            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Insert Student");
                System.out.println("2. Retrieve Student");
                System.out.println("3. Exit");
                System.out.print("\nPlease enter your choice : ");

                String choice = scanner.nextLine();
                
                switch (choice) {
                    case "1" -> insertStudent(scanner, connection);
                    case "2" -> retrieveStudent(scanner, connection);
                    case "3" -> {
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Invalid Choice. Please try again.");
                }
            }
        }
    }

    private static void initializeDatabase(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {

            statement.executeUpdate(CREATE_DATABASE);
            System.out.println("\n" + DATABASE + " database is ready!");

            statement.execute(USE_DATABASE);

            statement.executeUpdate(CREATE_TABLE);
            System.out.println("students table is ready!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertStudent(Scanner scanner, Connection connection) throws SQLException {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        int age;
        int grade;

        while (true) {
            System.out.print("Enter student age (5-25): ");
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                if (age >= 5 && age <= 25) {
                    break;
                }
                System.out.println("Enter age between 5 and 25.");
            }
            else{
                System.out.println("Please enter a valid numerical value for age.");
                scanner.nextLine();
            }
        }

        while (true) {
            System.out.print("Enter student grade (1-10): ");
            if (scanner.hasNextInt()) {
                grade = scanner.nextInt();
                if (grade >= 1 && grade <= 10) {
                    break;
                }
                System.out.println("Enter grade between 5 and 25.");
            }
            else{
                System.out.println("Please enter a valid numerical value for grade.");
                scanner.nextLine();
            }
        }   
        scanner.nextLine();
    
        try (PreparedStatement statement = connection.prepareStatement(INSERT_STUDENT)) {
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.setInt(3, grade);
            statement.executeUpdate();
            System.out.println("Student inserted successfully.");
        }
    }

    private static void retrieveStudent(Scanner scanner, Connection connection) throws SQLException {
        System.out.println("\nRetrieve by:-");
        System.out.println("1. ID");
        System.out.println("2. Name");
        System.out.print("\nPlease enter your choice : ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1" -> retrieveStudentById(scanner, connection);
            case "2" -> retrieveStudentByName(scanner, connection);
            default -> System.out.println("Invalid Choice. Please try again.");
        }
    }

    private static void retrieveStudentById(Scanner scanner, Connection connection) throws SQLException {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        try (PreparedStatement statement = connection.prepareStatement(RETRIEVE_STUDENT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("\nStudent Details:");
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Age: " + resultSet.getInt("age"));
                System.out.println("Grade: " + resultSet.getInt("grade"));
            } else {
                System.out.println("Student not found.");
            }
        }
    }

    private static void retrieveStudentByName(Scanner scanner, Connection connection) throws SQLException {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        try (PreparedStatement statement = connection.prepareStatement(RETRIEVE_STUDENT_BY_NAME)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("\nStudent Details:");
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Age: " + resultSet.getInt("age"));
                System.out.println("Grade: " + resultSet.getInt("grade"));
            } else {
                System.out.println("Student not found.");
            }
        }
    }
}