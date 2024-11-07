// Classes and Data Abstraction: Design an abstract class BankAccount with abstract methods deposit(double amount) and withdraw(double amount). Create a subclass SavingsAccount that implements these methods and maintains a balance. Write a program to demonstrate the functionality.

import java.util.Scanner;

// Abstract class BankAccount with abstract methods
abstract class BankAccount {
    protected double balance; // Protected field to maintain the account balance

    // Constructor to initialize the balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Abstract method for deposit
    public abstract void deposit(double amount);

    // Abstract method for withdraw
    public abstract void withdraw(double amount);

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }
}

// Subclass SavingsAccount that implements the BankAccount abstract class
class SavingsAccount extends BankAccount {

    // Constructor to initialize the SavingsAccount with an initial balance
    public SavingsAccount(double initialBalance) {
        super(initialBalance); // Call to the parent class constructor
    }

    // Implement the deposit method to add the amount to the balance
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: Rs." + amount + ", New Balance: Rs." + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Implement the withdraw method to subtract the amount from the balance
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: Rs." + amount + ", New Balance: Rs." + balance);
        } else {
            System.out.println("Invalid withdraw amount. Insufficient balance or negative input.");
        }
    }
}

// Main class to demonstrate the functionality of the SavingsAccount
public class ClassesAndDataAbstraction {
    public static void main(String[] args) {
        SavingsAccount myAccount = null; // Account is initially null until opened
        
        while (true) {
            Scanner myobj = new Scanner(System.in);
            System.out.println("\n<--- Bank Account Menu --->");
            System.out.println("1. Open Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            // Handling menu selection with exception handling for input errors
            try {
                int choice = myobj.nextInt();

                switch (choice) {
                    case 1 -> {
                        // Open Account
                        if (myAccount == null) {
                            System.out.print("Enter initial deposit amount: ");
                            double initialDeposit = myobj.nextDouble();
                            if (initialDeposit > 0) {
                                myAccount = new SavingsAccount(initialDeposit);
                                System.out.println("Account opened with balance: Rs." + initialDeposit);
                            } else {
                                System.out.println("Initial deposit must be positive.");
                            }
                        } else {
                            System.out.println("Account already opened.");
                        }
                    }

                    case 2 -> {
                        // Deposit
                        if (myAccount != null) {
                            System.out.print("Enter amount to deposit: ");
                            double depositAmount = myobj.nextDouble();
                            myAccount.deposit(depositAmount);
                        } else {
                            System.out.println("Please open an account first.");
                        }
                    }

                    case 3 -> {
                        // Withdraw
                        if (myAccount != null) {
                            System.out.print("Enter amount to withdraw: ");
                            double withdrawAmount = myobj.nextDouble();
                            myAccount.withdraw(withdrawAmount);
                        } else {
                            System.out.println("Please open an account first.");
                        }
                    }

                    case 4 -> {
                        // Check Balance
                        if (myAccount != null) {
                            System.out.println("Current Balance: Rs." + myAccount.getBalance());
                        } else {
                            System.out.println("Please open an account first.");
                        }
                    }

                    case 5 -> {
                        // Exit
                        System.out.println("Exiting the program. Thank you!");
                        myobj.close();
                        return;
                    }

                    default -> System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid numerical value.");
            }
        }
    }
}