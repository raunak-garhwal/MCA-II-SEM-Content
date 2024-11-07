import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Abstract class BankAccount with abstract methods
abstract class BankAccount {
    protected double balance; // Protected field to maintain the account balance
    protected int accountId; // Unique account ID

    // Constructor to initialize the balance and accountId
    public BankAccount(int accountId, double initialBalance) {
        this.accountId = accountId;
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

    // Method to get the account ID
    public int getAccountId() {
        return accountId;
    }
}

// Subclass SavingsAccount that implements the BankAccount abstract class
class SavingsAccount extends BankAccount {

    // Constructor to initialize the SavingsAccount with an initial balance
    public SavingsAccount(int accountId, double initialBalance) {
        super(accountId, initialBalance); // Call to the parent class constructor
    }

    // Implement the deposit method to add the amount to the balance
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: Rs." + amount + ", New Balance: Rs." + balance);
            // Update the balance in the database after deposit
            BankAppWithJDBC.updateAccountBalanceInDatabase(accountId, balance);
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
            // Update the balance in the database after withdrawal
            BankAppWithJDBC.updateAccountBalanceInDatabase(accountId, balance);
        } else {
            System.out.println("Invalid withdraw amount. Insufficient balance or negative input.");
        }
    }
}

// Main class to demonstrate the functionality of the SavingsAccount
public class BankAppWithJDBC {
    // Database credentials
    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "root";
    static final String PASS = "";
    static final String DATABASE = "bank_system_db";

    // HashMap to store multiple account holder objects
    private static Map<Integer, SavingsAccount> accountHolders = new HashMap<>();

    public static void main(String[] args) {
        // Create the database and tables if they don't exist
        createDatabaseAndTables();

        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            // Displaying the menu
            System.out.println("\n=== Bank Account Menu ===");
            System.out.println("1. Open Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Retrieve Account Details");
            System.out.println("6. Get Transaction History");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            // Handling menu selection
            try {
                choice = Integer.parseInt(scanner.nextLine()); // Reading user input

                switch (choice) {
                    case 1 -> {
                        // Open Account
                        System.out.print("Enter your name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter your initial deposit amount: ");
                        double initialDeposit = Double.parseDouble(scanner.nextLine());
                        if (initialDeposit > 0) {
                            int accountId = openAccountInDatabase(name, initialDeposit);
                            SavingsAccount newAccount = new SavingsAccount(accountId, initialDeposit);
                            accountHolders.put(accountId, newAccount);
                            System.out.println("Account opened with balance: Rs." + initialDeposit + ", Account ID: " + accountId);
                        } else {
                            System.out.println("Initial deposit must be positive.");
                        }
                    }

                    case 2 -> {
                        // Deposit
                        System.out.print("Enter your account ID: ");
                        int depositAccountId = Integer.parseInt(scanner.nextLine());
                        // Retrieve the account details from the database
                        SavingsAccount depositAccount = retrieveAccountFromDatabase(depositAccountId);
                        if (depositAccount != null) {
                            System.out.print("Enter amount to deposit: ");
                            double depositAmount = Double.parseDouble(scanner.nextLine());
                            depositAccount.deposit(depositAmount);
                            saveTransaction(depositAccount.getAccountId(), "Deposit", depositAmount);
                        } else {
                            System.out.println("Account not found. Please open an account first.");
                        }
                    }

                    case 3 -> {
                        // Withdraw
                        System.out.print("Enter your account ID: ");
                        int withdrawAccountId = Integer.parseInt(scanner.nextLine());
                        // Retrieve the account details from the database
                        SavingsAccount withdrawAccount = retrieveAccountFromDatabase(withdrawAccountId);
                        if (withdrawAccount != null) {
                            System.out.print("Enter amount to withdraw: ");
                            double withdrawAmount = Double.parseDouble(scanner.nextLine());
                            withdrawAccount.withdraw(withdrawAmount);
                            saveTransaction(withdrawAccount.getAccountId(), "Withdraw", withdrawAmount);
                        } else {
                            System.out.println("Account not found. Please open an account first.");
                        }
                    }

                    case 4 -> {
                        // Check Balance
                        System.out.print("Enter your account ID: ");
                        int balanceAccountId = Integer.parseInt(scanner.nextLine());
                        // Retrieve the account details from the database
                        SavingsAccount balanceAccount = retrieveAccountFromDatabase(balanceAccountId);
                        if (balanceAccount != null) {
                            System.out.println("Current Balance: Rs." + balanceAccount.getBalance());
                        } else {
                            System.out.println("Account not found.");
                        }
                    }

                    case 5 -> {
                        // Retrieve Account Details
                        System.out.print("Enter your account ID: ");
                        int detailsAccountId = Integer.parseInt(scanner.nextLine());
                        retrieveAccountDetails(detailsAccountId);
                    }

                    case 6 -> {
                        // Get Transaction History
                        System.out.print("Enter your account ID: ");
                        int historyAccountId = Integer.parseInt(scanner.nextLine());
                        getTransactionHistory(historyAccountId);
                    }

                    case 7 -> {
                        // Exit
                        System.out.println("Exiting the program. Thank you!");
                        scanner.close();
                        return;
                    }

                    default -> System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    // Method to create the database and tables if they do not exist
    public static void createDatabaseAndTables() {
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS " + DATABASE;
        String useDatabaseSQL = "USE " + DATABASE;

        String createAccountTableSQL = "CREATE TABLE IF NOT EXISTS account_holders ("
                + "account_id INT AUTO_INCREMENT PRIMARY KEY, "
                + "name VARCHAR(255) NOT NULL, "
                + "balance DOUBLE NOT NULL"
                + ")";

        String createTransactionTableSQL = "CREATE TABLE IF NOT EXISTS transaction_history ("
                + "transaction_id INT AUTO_INCREMENT PRIMARY KEY, "
                + "account_id INT NOT NULL, "
                + "transaction_type VARCHAR(50), "
                + "amount DOUBLE, "
                + "transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, "
                + "FOREIGN KEY (account_id) REFERENCES account_holders(account_id)"
                + ")";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            // Create the database if it doesn't exist
            stmt.execute(createDatabaseSQL);
            System.out.println("\nDatabase '" + DATABASE + "' is ready!");

            // Switch to the newly created database
            stmt.execute(useDatabaseSQL);

            // Create account holders table
            stmt.execute(createAccountTableSQL);
            System.out.println("Table 'account_holders' is ready!");

            // Create transaction history table
            stmt.execute(createTransactionTableSQL);
            System.out.println("Table 'transaction_history' is ready!");

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred while creating the database or tables: " + e.getMessage());
        }
    }

    // Method to open an account in the database and return the account ID
    public static int openAccountInDatabase(String name, double initialDeposit) {
        String insertSQL = "INSERT INTO account_holders (name, balance) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL + DATABASE, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, name);
            pstmt.setDouble(2, initialDeposit);
            pstmt.executeUpdate();

            // Retrieve generated account ID
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating account failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error opening account: " + e.getMessage());
        }
        return -1; // Return -1 if there is an error
    }

    // Method to retrieve account from the database
    public static SavingsAccount retrieveAccountFromDatabase(int accountId) {
        String selectSQL = "SELECT * FROM account_holders WHERE account_id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL + DATABASE, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {

            pstmt.setInt(1, accountId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                double balance = rs.getDouble("balance");
                return new SavingsAccount(accountId, balance); // Return a new account object with the retrieved balance
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving account from database: " + e.getMessage());
        }
        return null; // Return null if account not found
    }

    // Method to update the account balance in the database
    public static void updateAccountBalanceInDatabase(int accountId, double newBalance) {
        String updateSQL = "UPDATE account_holders SET balance = ? WHERE account_id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL + DATABASE, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

            pstmt.setDouble(1, newBalance);
            pstmt.setInt(2, accountId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating account balance: " + e.getMessage());
        }
    }

    // Method to save a transaction in the database
    public static void saveTransaction(int accountId, String transactionType, double amount) {
        String insertSQL = "INSERT INTO transaction_history (account_id, transaction_type, amount) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL + DATABASE, USER, PASS);
            PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            pstmt.setInt(1, accountId);
            pstmt.setString(2, transactionType);
            pstmt.setDouble(3, amount);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error saving transaction: " + e.getMessage());
        }
    }

    // Method to retrieve account details
    public static void retrieveAccountDetails(int accountId) {
        String selectSQL = "SELECT * FROM account_holders WHERE account_id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL + DATABASE, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {

            pstmt.setInt(1, accountId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                double balance = rs.getDouble("balance");
                System.out.println("Account ID: " + accountId + ", Name: " + name + ", Balance: Rs." + balance);
            } else {
                System.out.println("Account not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving account details: " + e.getMessage());
        }
    }

    // Method to get transaction history for a specific account
    public static void getTransactionHistory(int accountId) {
        String selectSQL = "SELECT * FROM transaction_history WHERE account_id = ? ORDER BY transaction_date DESC";
        try (Connection conn = DriverManager.getConnection(DB_URL + DATABASE, USER, PASS);
            PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {

            pstmt.setInt(1, accountId);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("Transaction History for Account ID: " + accountId);
            while (rs.next()) {
                String transactionType = rs.getString("transaction_type");
                double amount = rs.getDouble("amount");
                Timestamp transactionDate = rs.getTimestamp("transaction_date");
                System.out.printf("Date: %s, Type: %s, Amount: Rs.%.2f%n", transactionDate, transactionType, amount);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving transaction history: " + e.getMessage());
        }
    }
}
