import java.util.*;

public class Main {
    private static Bank[] accounts = new Bank[0];
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            displayMenu();
            String response = scan.nextLine();

            if (response.equals("1")) {
                createAccount();
            } else if (response.equals("2")) {
                depositToChecking();
            } else if (response.equals("3")) {
                depositToSavings();
            } else if (response.equals("4")) {
                withdrawFromChecking();
            } else if (response.equals("5")) {
                withdrawFromSavings();
            } else if (response.equals("6")) {
                printBankStatement();
            } else if (response.equals("0")) {
                running = false;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }
    }

    static void displayMenu() {
        System.out.println("\n1. Create an Account\n2. Deposit into Checking Account\n3. Deposit into Savings Account\n4. Withdrawal from Checking Account\n5. Withdrawal from Savings Account\n6. Print out Bank Statement\n0. Quit");
    }

    static void createAccount() {
        System.out.print("Enter account holder's name: ");
        String name = scan.nextLine();
        Bank newAccount = new Bank(name, generateUniqueAccountNumber());
        accounts = Arrays.copyOf(accounts, accounts.length + 1);
        accounts[accounts.length - 1] = newAccount;
        System.out.println("Account created successfully! Account Number: " + newAccount.getAccountNumber());
    }

    static void depositToChecking() {
        Bank account = findAccount();
        if (account != null) {
            System.out.print("Enter deposit amount: ");
            double amount = scan.nextDouble();
            scan.nextLine();
            account.depositChecking(amount);
        }
    }

    static void depositToSavings() {
        Bank account = findAccount();
        if (account != null) {
            System.out.print("Enter deposit amount: ");
            double amount = scan.nextDouble();
            scan.nextLine();
            account.depositSavings(amount);
        }
    }

    static void withdrawFromChecking() {
        Bank account = findAccount();
        if (account != null) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scan.nextDouble();
            scan.nextLine();
            account.withdrawChecking(amount);
        }
    }

    static void withdrawFromSavings() {
        Bank account = findAccount();
        if (account != null) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scan.nextDouble();
            scan.nextLine();
            account.withdrawSavings(amount);
        }
    }

    static void printBankStatement() {
        Bank account = findAccount();
        if (account != null) {
            account.displayBankStatement();
        }
    }

    static Bank findAccount() {
        if (accounts.length == 0) {
            System.out.println("No accounts available.");
            return null;
        }

        System.out.println("Accounts:");
        for (Bank acc : accounts) {
            System.out.println("Name: " + acc.getName() + " | Account Number: " + acc.getAccountNumber());
        }

        System.out.print("Enter Account Name or Number: ");
        String input = scan.nextLine();

        for (Bank acc : accounts) {
            if (acc.getName().equalsIgnoreCase(input) || Integer.toString(acc.getAccountNumber()).equals(input)) {
                return acc;
            }
        }

        System.out.println("Account not found.");
        return null;
    }

    static int generateUniqueAccountNumber() {
        Random rand = new Random();
        int accountNumber;
        boolean unique;
        do {
            accountNumber = rand.nextInt(9000) + 1000;
            unique = true;
            for (Bank acc : accounts) {
                if (acc.getAccountNumber() == accountNumber) {
                    unique = false;
                    break;
                }
            }
        } while (!unique);
        return accountNumber;
    }
}
