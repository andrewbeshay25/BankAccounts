class SavingsAccount {
    private double balance = 0;

    public double getBalance() { return balance; }

    public void deposit(double amount) { balance += amount; }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
