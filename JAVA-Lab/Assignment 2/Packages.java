// Packages: Create a package named com.example.shapes. Inside this package, define a class Circle with methods to calculate the area and circumference. Write a program to use this package and demonstrate the functionality.

import com.example.shapes.Circle;
import java.util.Scanner;

public class Packages {

    public static void main(String[] args) {

        Scanner myobj = new Scanner(System.in);
        Circle c = new Circle();

        while (true) {
            System.out.print("\nEnter the radius of the circle :- ");
            if (myobj.hasNextDouble()) {
                double radius = myobj.nextDouble();
                c.calculateCircumference(radius);
                c.calculateArea(radius);
                myobj.close();
                break;
            } else {
                System.out.println("WARNING :- Invalid input. Please enter an integer value......");
                myobj.next(); // Consume the invalid input
            }
        }
    }
}
