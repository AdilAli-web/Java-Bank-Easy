
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        System.out.println("Welcome to the Interest free Bank");

        Scanner sc = new Scanner(System.in);
        Auth auth = new Auth();

        auth.register(new User("adil", "1234"));
        System.out.print("Enter your Username :");
        String userName = sc.nextLine();
        System.out.print("Enter your Password :");
        String password = sc.nextLine();
        if (auth.login(userName, password)) {
            System.out.println("Login successful");
            Accountable account = new Banking(1000, "Ali");
            System.out.println("Welcome back " + userName);

            while (true) {
                System.out.println("1-Deposit");
                System.out.println("2-Withdraw");
                System.out.println("3-check balance");
                System.out.println("4-Transaction history");
                System.out.println("5-Exit");
                System.out.println("choose an option : ");
                int choice = sc.nextInt();
                switch (choice) {

                    case 1:
                        double amounts = sc.nextDouble();
                        Accountable.processing();
                        account.deposit(amounts);
                        break;

                    case 2:
                        double amountss = sc.nextDouble();
                        Accountable.processing();
                        account.withdraw(amountss);
                        break;

                    case 3:
                        Accountable.processing();
                        account.checkBalance();
                        break;

                    case 4:
                        Accountable.processing();
                        account.transactionHistory();
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        System.out.println("Thank you for using our Banking System. Please Visit again");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice,Please try again");

                }

            }

        } else {
            System.out.println("Login failed ");
        }
    }
}
