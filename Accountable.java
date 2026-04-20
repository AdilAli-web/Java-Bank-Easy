
interface Accountable {

    void deposit(double amount);

    void checkBalance();

    void transactionHistory();

    void withdraw(double amount);

    static void processing() {
        System.out.println("processing............");

    }

    default void printAccountDetails(String accountholderName) {

        System.out.println("Account Holder : " + accountholderName);

    }

}
