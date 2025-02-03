import java.util.Random;


public class Bank {
    Random rand = new Random();

    String[] accountInfo;
    String name;
    int accountNumber;

    public Bank(String name) {
        accountInfo = new String[10];
        this.name = name;
        accountNumber = rand.nextInt(9999 - 1000 + 1) + 1000;


    }

    public void displayMenu(){
        System.out.println("""
                1.  Create an account
                
                2.  Deposit into Checking Account
                
                3.  Deposit into Savings Account
                
                4.  Withdrawal from Checking Account
                
                5.  Withdrawal from Savings Account
                
                6.  Print out Bank Statement
                
                0.  Quit""");
    }

    public void displayBankStatement(){}

    public void depositChecking(int amount){}
    public void withdrawChecking(int amount){}

    public void depositSavings(int amount){}
    public void withdrawSavings(int amount){}
}
