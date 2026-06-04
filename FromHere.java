
import java.util.Scanner;

class FromHere {

    private Scanner sc = new Scanner(System.in);
    private final Auth auth = new Auth();
    private Accountable account;

    public void start() {
        System.out.println("------------------------------------------------");
        System.out.println("Welcome to the Bank ");

        // default user// please register your user first
        boolean passchecker = false;
        while (!passchecker) {
            try {

                System.out.println("------------------------------------------------");
                System.out.println("Register your name");
                String registername = sc.nextLine();
                System.out.println("------------------------------------------------");
                System.out.println("Register your password");
                String registerpassword = sc.nextLine();
                System.out.println("------------------------------------------------");
                auth.register(new User(registername, registerpassword));
                passchecker = true;

                System.out.println("User registered!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Please try again");

            }

        }

        if (login()) {
            account = new Banking(1000, currentuser);

            menuLoop();
        } else {
            System.out.println("Login failed");
        }
    }
    private String currentuser;

    private boolean login() {
        System.out.println("Login to your account :");
        System.out.print("Enter your Username: ");
        String userName = sc.nextLine();

        System.out.print("Enter your Password: ");
        String password = sc.nextLine();

        if (auth.login(userName, password)) {
            System.out.println("------------------------------------------------");
            System.out.println("Login successful");
            currentuser = userName;
            System.out.println("Welcome back " + userName);
            return true;
        }
        return false;
    }

    private void menuLoop() {
        while (true) {
            System.out.println("1-Deposit");
            System.out.println();
            System.out.println("2-Withdraw");

            System.out.println();
            System.out.println("3-Check balance");
            System.out.println();

            System.out.println("4-Transaction history");
            System.out.println();
            // System.out.println(" ");
            System.out.println("5-Exit");
            System.out.println();
            // System.out.println(" ");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    double depositAmount = sc.nextDouble();
                    processing();

                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    double withdrawAmount = sc.nextDouble();
                    processing();

                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    processing();

                    account.checkBalance();
                    break;

                case 4:
                    processing();
                    System.out.println("------------------------------------------------");
                    account.transactionHistory();
                    break;

                case 5:
                    System.out.println("------------------------------------------------");
                    exit();
                    System.out.println("------------------------------------------------");
                    return;

                default:
                    System.out.println("Invalid choice, try again");
            }
        }
    }

    private final void processing() {
        System.out.println("Processing.............");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void exit() {
        System.out.println("Exiting...");
        System.out.println("Thank you for using our Banking System.");
        sc.close();
    }
}
