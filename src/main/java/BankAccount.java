import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class BankAccount {

    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    public BankAccount(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    public void deposit(int amount) {

        if (amount != 0) { //could be '> 0'
            balance = balance + amount;
            previousTransaction = amount;
        }

    }

    public void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    public void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrew: " + Math.abs(previousTransaction));
        }
        System.out.println("No transaction occurred");
    }

    public void showMenu() {
        char option = '\u0000';
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerId);
        System.out.println("\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");

        do {
            System.out.println("==============================================================================");
            System.out.println("Enter an option");
            System.out.println("==============================================================================");

            option = scanner.nextLine().charAt(0);

            System.out.println("\n");

            switch (option) {
                case 'A':
                    System.out.println("----------------------------------");
                    System.out.println("Balance = " + balance);
                    System.out.println("----------------------------------");
                    System.out.println("\n");
                    break;
                case 'B':
                    System.out.println("----------------------------------");
                    System.out.println("Enter an amount to deposit");
                    System.out.println("----------------------------------");
                    int depositAmount = scanner.nextInt();
                    deposit(depositAmount);
                    System.out.println("\n");
                    break;
                case 'C':
                    System.out.println("----------------------------------");
                    System.out.println("Enter an amount to withdraw");
                    System.out.println("----------------------------------");
                    int withdrawAmount = scanner.nextInt();
                    withdraw(withdrawAmount);
                    System.out.println("\n");
                case 'D':
                    System.out.println("----------------------------------");
                    getPreviousTransaction();
                    System.out.println("----------------------------------");
                    System.out.println("\n");
                    break;
                case 'E':
                    System.out.println("**********************************");
                    break;
                default:
                    System.out.println("Invalid Option! Please try again");
                    break;
            }
        } while (option != 'E');

        System.out.println("Thank you for banking with Cromericore");
    }

}
