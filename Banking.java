
import java.util.ArrayList;

class Banking implements Accountable {

    private double balance;
    private String accountHolderName;
    private ArrayList<String> transactions = new ArrayList<>();

// constructor when it its a new account.
    public Banking(double balance, String accountHolderName) {

        this.balance = balance;
        this.accountHolderName = accountHolderName;

    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount X");
        } else {
            this.balance += amount;
            System.out.println("Received " + amount + "succesfully. current balance is : " + balance);
            transactions.add("Credit " + amount);
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance -= amount;
            transactions.add("Debit: " + amount);
        }
    }

    @Override
    public void checkBalance() {
        System.out.println(" Your current Balance: " + this.balance);
    }

    @Override
    public void transactionHistory() {
        for (String t : transactions) {
            System.out.println(t);
        }
    }

}
