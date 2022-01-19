public class BankAccountTest {
    public static void main(String[] args) {
        
        // Create bank accounts
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();
        BankAccount account3 = new BankAccount();

        System.out.println(account1.getAccountNumber());
        System.out.println(account2.getAccountNumber());
        System.out.println(account3.getAccountNumber());

        // Test the deposit method
        account1.deposit("checking", 150.50);
        account2.deposit("checking", 200.50);
        account3.deposit("checking", 220.25);
        account1.deposit("savings", 1000);
        account2.deposit("savings", 500);
        account3.deposit("savings", 450.25);

        System.out.println("Account1 - " + account1.totalAccount());
        System.out.println("Account2 - " + account2.totalAccount());
        System.out.println("Account3 - " + account3.totalAccount());

        
        account1.withdraw("savings", 500);
        System.out.println("Account1 - " + account1.totalAccount());

        account2.withdraw("checking", 500);
        System.out.println("Account2 - " + account2.totalAccount());


        System.out.printf("Total Number of Accounts: %d\n", BankAccount.accountCount());
        System.out.printf("Total Amount of Money: $%.2f\n", BankAccount.totalBankAmount());
    }
}
