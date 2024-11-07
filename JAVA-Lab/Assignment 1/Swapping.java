import java.util.Scanner;

public class Swapping{
    public static void main(String[] args) {
        System.out.println("\n<--- Program for Swapping two numbers --->");
        Scanner myobj = new Scanner(System.in);
        System.out.print("\nEnter the first number : ");
        float a = myobj.nextFloat();
        System.out.print("\nEnter the second number : ");
        float b = myobj.nextFloat();
        System.out.println("\nBefore Swapping");
        System.out.println("a = " + a + ", b = " + b);
        // Swapping logic
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("\nAfter Swapping");
        System.out.println("a = " + a + ", b = " + b);
    }
}