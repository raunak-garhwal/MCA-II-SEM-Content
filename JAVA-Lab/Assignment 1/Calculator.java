
import java.util.Scanner;
import pack.Diff;
import pack.Div;
import pack.Product;
import pack.Sum;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("\n<---Calculator Program--->");
        OUTER:
        while (true) {
            System.out.println("\nWhat Operation would you like to perform ?");
            System.out.println("Press 1 for Addition.");
            System.out.println("Press 2 for Subtraction.");
            System.out.println("Press 3 for Multiplication.");
            System.out.println("Press 4 for Division.");
            System.out.println("Press 5 to exit.");
            Scanner obj = new Scanner(System.in);
            System.out.print("Enter your choice : ");
            try {
                int choice = obj.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.print("\nEnter First Number : ");
                        float firstNum = obj.nextFloat();
                        System.out.print("Enter Second Number : ");
                        float secondNum = obj.nextFloat();
                        Sum a = new Sum();
                        System.out.println("\nThe Sum of the numbers is " + a.add(firstNum, secondNum));
                    }
                    case 2 -> {
                        System.out.print("\nEnter First Number : ");
                        float firstNum = obj.nextFloat();
                        System.out.print("Enter Second Number : ");
                        float secondNum = obj.nextFloat();
                        Diff b = new Diff();
                        System.out.println("\nThe Difference of the numbers is " + b.diff(firstNum, secondNum));
                    }
                    case 3 -> {
                        System.out.print("\nEnter First Number : ");
                        float firstNum = obj.nextFloat();
                        System.out.print("Enter Second Number : ");
                        float secondNum = obj.nextFloat();
                        Product c = new Product();
                        System.out.println("\nThe Product of the numbers is " + c.product(firstNum, secondNum));
                    }
                    case 4 -> {
                        System.out.print("\nEnter First Number : ");
                        float firstNum = obj.nextFloat();
                        System.out.print("Enter Second Number : ");
                        float secondNum = obj.nextFloat();
                        Div d = new Div();
                        System.out.println("\nThe Division of the numbers is " + d.div(firstNum, secondNum));
                    }
                    case 5 -> {
                        System.out.println("\nThanks for using this program. Please come back soon....");
                        break OUTER;
                    }
                    default -> {
                        System.out.println("\nPlease enter a valid avaiable choice.");
                    }
                }
                obj.close();
            } catch (Exception e) {
                System.out.println("\nPlease enter a valid numeric value.");
            }
        }
    }
}