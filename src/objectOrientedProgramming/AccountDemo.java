package objectOrientedProgramming;

import java.util.Scanner;

public class AccountDemo
{
    public static void main(String[] args)
    {
        // Create accounts

        final int ACCOUNTS_SIZE = 10;
        BankAccount[] accounts = new BankAccount[ACCOUNTS_SIZE];
        for (int i = 0; i < accounts.length / 2; i++)
        {
            accounts[i] = new CheckingAccount();
        }

        for (int i = accounts.length / 2; i < accounts.length; i++)
        {
            SavingsAccount account = new SavingsAccount();
            account.setInterestRate(0.75);
            accounts[i] = account;
        }

        // Execute commands

        Scanner in = new Scanner(System.in);
        boolean done = false;
        while (!done)
        {
            System.out.print("D)eposit  W)ithdraw  S)howAcc  M)onth end  Q)uit: ");
            String input = in.next();
            if (input.equals("D") || input.equals("W")) // Deposit or withdrawal
            {
                System.out.print("Enter account number and amount: ");
                int num = in.nextInt();
                double amount = in.nextDouble();

                if (input.equals("D"))
                {
                    accounts[num].deposit(amount);
                }
                else
                {
                    accounts[num].withdraw(amount);
                }

                System.out.println(accounts[num].displayAccount(accounts[num]));
            }
            else if (input.equals("S")) // Show an acc
            {
                System.out.print("Enter account number for the account you wish to see: ");
                int num = in.nextInt();

                System.out.println("Account number " + num + ": " + accounts[num].displayAccount(accounts[num]));
            }
            else if (input.equals("M")) // Month end processing
            {
                for (int n = 0; n < accounts.length; n++)
                {
                    accounts[n].monthEnd();
                    System.out.println(n + " " + accounts[n].displayAccount(accounts[n]));
                }
            }
            else if (input.equals("Q"))
            {
                done = true;
            }
        }
    }
}


