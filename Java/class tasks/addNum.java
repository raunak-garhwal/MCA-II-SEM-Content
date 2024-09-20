import java.util.Scanner;

public class addNum {
    public static void main(String[] args) {
        float a, b, sum;
        Scanner myObj = new Scanner(System.in);
        System.out.println("\n---Addition Program---");
        System.out.print("Enter First Number : ");
        a = myObj.nextFloat();

        System.out.print("Enter Second Number : ");
        b = myObj.nextFloat();

        sum = a + b;
        System.out.println("The sum of the two numbers is : "+sum);
    }
}