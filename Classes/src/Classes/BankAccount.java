package Classes;

public class BankAccount {
    private int  id;
    private double balance;
    private static double interestRate = 0.02;

    public BankAccount(int id)
    {
        this.id = id;
        this.balance = 0.0;
    }

    public static void setInterestRate(double interest)
    {
        interestRate = interest;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }
    public static double getInterestRate()
    {
        return interestRate;
    }

    public double getInterest(int years)
    {
        return balance * interestRate * years;
    }

    public void deposit(double amount)
    {
        System.out.println(STR."Deposited \{String.format("%.0f", amount)} to ID\{this.id}.");
        this.balance += amount;
    }

    public String notifyOnCreate()
    {
        return STR."Account ID\{this.id} created.";
    }

}
