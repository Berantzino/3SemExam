package objectOrientedProgramming;

public class SavingsAccount extends BankAccount
{
    private double interestRate;
    private double minBalance;

    /**
     * Constructs a savings account with a zero balance.
     */
    public SavingsAccount()
    {
        interestRate = 0;
        minBalance = 0;
    }

    /**
     * Sets the interest rate for this account.
     * @param rate the monthly interest rate in percent
     */
    public void setInterestRate(double rate)
    {
        interestRate = rate;
    }

    // These methods override superclass methods
    @Override
    public void withdraw(double amount)
    {
      super.withdraw(amount);
      double balance = getBalance();
      if (balance < minBalance)
      {
          minBalance = balance;
      }
    }

    // You do not receive interest for the first month,
    // since the minBalance is 0 when the account is created.
    public void monthEnd()
    {
        double interest = minBalance * interestRate / 100;
        deposit(interest);
        minBalance = getBalance();
    }
}
