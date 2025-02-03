class Bank {
    private final String name;
    private final int accountNumber;
    private double checkingBalance = 50;
    private double savingsBalance = 0;

    public Bank(String name, int accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public String getName() { return name; }
    public int getAccountNumber() { return accountNumber; }

    public void depositChecking(double amount) { checkingBalance += amount; }
    public void withdrawChecking(double amount) {
        if (amount <= checkingBalance) checkingBalance -= amount;
        else System.out.println("Insufficient funds.");
    }

    public void depositSavings(double amount) { savingsBalance += amount; }
    public void withdrawSavings(double amount) {
        if (amount <= savingsBalance) savingsBalance -= amount;
        else System.out.println("Insufficient funds.");
    }

    public void displayBankStatement() {
        System.out.println("\nName: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Checking Balance: $" + checkingBalance);
        System.out.println("Savings Balance: $" + savingsBalance);
    }
}
