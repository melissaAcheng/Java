import java.util.Random;

public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private int accountNumber;

    private static int numberOfAccounts = 0;
    private static double totalAmount = 0;

    private static int createAccountNumber() {
        Random rand = new Random();
        int randAccountNum = rand.nextInt(999999);
        return randAccountNum;
    }

    // Create the constructor
    public BankAccount() {
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        this.accountNumber = BankAccount.createAccountNumber();

        numberOfAccounts++;   
    }
    
    // Getter methods
    public double getCheckingBalance() {
        return this.checkingBalance;
    }
    
    public double getSavingsBalance() {
        return this.savingsBalance;
    }
    public static int accountCount() {
        return numberOfAccounts;
    }

    public static double totalBankAmount() {
        return totalAmount;
    }

    public long getAccountNumber() {
        return this.accountNumber;
    }


    // Create a method that will allow a user to deposit money into either the checking or saving, be sure to add to total amount stored.
    public void deposit(String account, double amount) {
        if (account.equals("savings")) {
            this.savingsBalance += amount;
        } else if (account.equals("checking")) {
            this.checkingBalance += amount;
        }
        BankAccount.totalAmount += amount;
    }

    // Create a method to withdraw money from one balance. Do not allow them to withdraw money if there are insufficient funds.
    public void withdraw(String account, double amount) {
        if (account.equals("savings") && this.savingsBalance > amount) {
            this.savingsBalance -= amount;
        } else if (account.equals("checking") && this.checkingBalance > amount) {
            this.checkingBalance -= amount;
        } else {
            System.out.println("Not enough funds");
        }
        BankAccount.totalAmount -= amount;
    }
    
    // Create a method to see the total money from the checking and saving
    public String totalAccount() {
        return String.format("Checking: $%.2f Savings: $%.2f", this.getCheckingBalance(), this.getSavingsBalance());
    }

}
