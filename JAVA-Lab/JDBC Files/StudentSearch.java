import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentSearch {
    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/school"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter search key (student ID or name): ");
        String searchKey = scanner.nextLine();
        // Search for student information
        searchStudent(searchKey);
    }

    private static void searchStudent(String searchKey) {
        String query = "SELECT name, age, grade FROM students WHERE id = ? OR name LIKE ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set parameters for the query
            preparedStatement.setString(1, searchKey);
            preparedStatement.setString(2, "%" + searchKey + "%");

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process the result
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String grade = resultSet.getString("grade");
                System.out.println("Student Found:");
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Grade: " + grade);
            } else {
                System.out.println("No student found with the search key: " + searchKey);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}