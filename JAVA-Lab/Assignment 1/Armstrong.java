
import java.util.Scanner;

public class Armstrong {
    static int no_of_digit(int num){
        int cnt = 0;
        while (num>0) {
            cnt++;
            num/=10;
        }
        return cnt;
    }

    static boolean checkArmstrong(int num) {
        int sum = 0;
        int numcopy = num;
        int no_of_digit = no_of_digit(num);
        while (numcopy > 0) {
            int digit = numcopy % 10;
            sum += Math.pow(digit, no_of_digit);
            numcopy /= 10;
        }
        return num == sum;
    }

    public static void main(String[] args) {
        Scanner myobj = new Scanner(System.in);
        System.out.println("\n<--- Program for checking Armstrong number --->\n");
        System.out.print("Enter the number : ");
        int a = myobj.nextInt();
        if (checkArmstrong(a)) {
            System.out.println("\n" + a + " is an Armstrong number.\n");
        } else {
            System.out.println("\n" + a + " is not an Armstrong number.\n");
        }
    }
}
