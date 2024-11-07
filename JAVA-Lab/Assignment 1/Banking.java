
import java.util.Scanner;

class Customer {
    String cust_name;
    double balance;
    String accType;
    int acc_number;

    void createAcc(String cust_name, double balance, String accType, int acc_number) {
        this.cust_name = cust_name;
        this.balance = balance;
        this.accType = accType;
        this.acc_number = acc_number;
    }

    void depositAmount(int acc_number, int amt) {
        if (this.acc_number == acc_number) {
            this.balance += amt;
            System.out.println(amt + " Rs. " + "deposited in the account number - " + acc_number);
        } else {
            System.out.println("WARNING : Please enter correct account number.....");
        }
    }
    
    void withdrawAmount(int acc_number, int amt) {
        if (this.acc_number == acc_number) {
            if ((this.balance - amt) >= 0) {
                this.balance -= amt;
                System.out.println(amt + " Rs. " + "withdrawn from the account number - " + acc_number);
            } else {
                System.out.println("WARNING : You cannot withdraw more than the available balance.....");
            }
        } else {
            System.out.println("WARNING : Please enter correct account number.....");
        }
    }

    void checkBalance(int acc_number) {
        if (this.acc_number == acc_number) {
            System.out.println("\nCustomer Name : " + this.cust_name);
            System.out.println("Account Number : " + this.acc_number);
            System.out.println("Type of Account-(Saving/Current) : " + this.accType);
            System.out.println("Available Balance : " + this.balance);
        } else {
            System.out.println("WARNING : Please enter correct account number.....");
        }
    }
}

public class Banking {
    public static void main(String[] args) {
        System.out.println("\n<--- Welcome to the Banking Portal --->");
        Customer c1 = new Customer();
        OUTER:
        while (true) {
            System.out.println("\nWhat Operation would you like to perform ?");
            System.out.println("Press 1 for opening new account.");
            System.out.println("Press 2 for depositing amount.");
            System.out.println("Press 3 for withdrawing amount.");
            System.out.println("Press 4 for checking balance.");
            System.out.println("Press 5 to exit.");
            Scanner obj = new Scanner(System.in);
            System.out.print("Enter your choice : ");
            try {
                int choice = obj.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.print("\nEnter the name of the Customer : ");
                        String cust_name = obj.next();
                        System.out.print("Enter the initial deposit amount : ");
                        int balance = obj.nextInt();
                        System.out.print("Enter the Type of Account : ");
                        String accType = obj.next();
                        System.out.print("Enter the Account Number : ");
                        int acc_number = obj.nextInt();
                        c1.createAcc(cust_name, balance, accType, acc_number);
                    }

                    case 2 -> {
                        System.out.print("Enter the account number : ");
                        int acc_number = obj.nextInt();
                        System.out.print("Enter the amount to be deposited : ");
                        int amt = obj.nextInt();
                        if (amt > 0) {
                            c1.depositAmount(acc_number, amt);
                        } else {
                            System.out.println("WARNING : Please deposit amount greater than 0.....");
                        }
                    }

                    case 3 -> {
                        System.out.print("Enter the account number : ");
                        int acc_number = obj.nextInt();
                        System.out.print("Enter the amount to withdraw : ");
                        int amt = obj.nextInt();
                        if (amt > 0) {
                            c1.withdrawAmount(acc_number, amt);
                        } else {
                            System.out.println("WARNING : Please withdraw amount greater than 0.....");
                        }
                    }

                    case 4 -> {
                        System.out.print("Enter the account number : ");
                        int acc_number = obj.nextInt();
                        c1.checkBalance(acc_number);
                    }

                    case 5 -> {
                        System.out.println("\nThanks for using this program. Please come back soon....");
                        break OUTER;
                    }

                    default -> {
                        System.out.println("\nPlease enter a valid available choice.");
                    }
                }
            } catch (Exception e) {
                System.out.println("\nPlease enter a valid numeric value.");
            }
        }
    }
}