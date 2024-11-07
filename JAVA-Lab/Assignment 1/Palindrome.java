
import java.util.Scanner;

public class Palindrome {

    static boolean checkPalindrome(String str) {
        String revStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            revStr += str.charAt(i);
        }
        return revStr.equalsIgnoreCase(str);     // for case-insensitive comparison
        // return revStr.equals(str);            // for case-sensitive comparison
    }

    public static void main(String[] args) {
        System.out.println("\n<--- Program for checking Palindrome --->");
        System.out.print("\nEnter the String : ");
        Scanner myobj = new Scanner(System.in);
        String str = myobj.next();
        if (checkPalindrome(str)) {
            System.out.println("\nThe entered String '" + str + "' is a Palindrome.");
        } else {
            System.out.println("\nThe entered String '" + str + "' is not a Palindrome.");
        }
    }
}