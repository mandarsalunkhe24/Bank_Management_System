import java.util.Scanner;

class BankAccount {
    private final String accountHolder;
    private final String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountHolder, String accountNumber, double initialBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Deposit Method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw Method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Display Account Details
    public void displayAccountDetails() {
        System.out.println("\nAccount Details:");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: ₹" + balance);
    }
}

public class banking_system {
    public static void main(String[] args) {
        // Create a new bank account
        try (Scanner scanner = new Scanner(System.in)) {
            // Create a new bank account
            System.out.print("Enter Account Holder Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Account Number: ");
            String accNumber = scanner.nextLine();
            System.out.print("Enter Initial Deposit Amount: ₹");
            double initialBalance = scanner.nextDouble();
            
            BankAccount account = new BankAccount(name, accNumber, initialBalance);
            System.out.println("Bank Account Created Successfully!");
            
            // Menu-driven program
            int choice;
            do {
                System.out.println("\n===== Bank Menu =====");
                System.out.println("1. Deposit Money");
                System.out.println("2. Withdraw Money");
                System.out.println("3. View Account Details");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        System.out.print("Enter Deposit Amount: ₹");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter Withdrawal Amount: ₹");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;
                    case 3:
                        account.displayAccountDetails();
                        break;
                    case 4:
                        System.out.println("Thank you for using the Bank Management System!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 4);
        }
    }
}
