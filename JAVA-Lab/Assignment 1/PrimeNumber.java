import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] args) {
        Scanner myobj = new Scanner(System.in);
        System.out.println("\n<--- Program for Getting Prime Numbers for a given range --->\n");
        System.out.print("Enter the starting number : ");
        int a = myobj.nextInt();
        System.out.print("Enter the ending number : ");
        int b = myobj.nextInt();
        System.out.print("\nPrime numbers between " + a + " and " + b + " :- ");

        // Loop through each number in the range [a, b]
        for (int i = a; i <= b; i++) {
            boolean isPrime = true;

            // Check if i is a prime number
            if (i <= 1) {
                isPrime = false;
            } else {
                // Check divisibility from 2 to i-1
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            // If i is prime, print it
            if (isPrime) {
                System.out.print(i+" ");
            }
        }
        System.out.print("\n");
    }
}
