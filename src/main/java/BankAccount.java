public class BankAccount {

    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

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
            System.out.println("Desposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrew: " + Math.abs(previousTransaction));
        }
        System.out.println("No transaction occurred");
    }

    public void showMenu() {
        
    }

}
