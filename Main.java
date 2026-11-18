package com.ATM;

import java.util.Scanner;
public class Main 
{
	public static void main(String[] args) 
	{

		Scanner sc = new Scanner(System.in);
        // Create customer account
        Account account = new Account("Karthisha", 1234567890L, 7890, 9000.0);

        // Create ATM object
        ATM atm = new ATM(account);

        System.out.println("Welcome to ATM Banking System");
        System.out.println("Customer Name: " + account.getName());
        System.out.println("Account Number: " + account.getAccountNumber());
        
		
		boolean loginSuccess = false;
		
		for (int i = 1; i <= 3; i++) 
		{
		    System.out.print("Enter your ATM PIN: ");
		    int enteredPin = sc.nextInt();
		
		    if (atm.verifyPin(enteredPin)) 
		    {
		        System.out.println("Login Successful!");
		        loginSuccess = true;
		        break;
		
		    } 
		    else
		    {
		
		        System.out.println("Incorrect PIN!");
		
		    }
		}
		
		if (loginSuccess == false) 
		{
		    System.out.println("Your account is blocked. Too many incorrect attempts.");
		}
		
		if (loginSuccess) 
		{
		
		    boolean running = true;
		
		    while (running) 
		    {
		        System.out.println("\n========== ATM MENU ==========");
		        System.out.println("1. Check Balance");
		        System.out.println("2. Deposit Money");
		        System.out.println("3. Withdraw Money");
		        System.out.println("4. Change PIN");
		        System.out.println("5. Exit");
		        System.out.println("==============================");
		
		        System.out.print("Enter your choice: ");
		        int choice = sc.nextInt();
		
		        switch (choice) 
		        {
		
		            case 1:
		                System.out.println("Your current balance is: " + atm.getBalance());
		                break;
		
		            case 2:
		                System.out.print("Enter deposit amount: ");
		                double amount = sc.nextDouble();
		
		                if (atm.depositMoney(amount)) 
		                {
		                    System.out.println("Deposit Successful!");
		                    System.out.println("Updated Balance: " + atm.getBalance());
		                } 
		                else
		                {
		                    System.out.println("Invalid deposit amount!");
		                }
		                break;
		
		            case 3:
		                System.out.print("Enter withdrawal amount: ");
		                double withdrawAmount = sc.nextDouble();
		
		                if (atm.withdrawMoney(withdrawAmount))
		                {
		                    System.out.println("Withdrawal Successful!");
		                    System.out.println("Remaining Balance: " + atm.getBalance());
		                } 
		                else
		                {
		                    System.out.println("Invalid amount or Insufficient Balance!");
		                }
		                break;
		
		            case 4:
		                System.out.print("Enter old PIN: ");
		                int oldPin = sc.nextInt();
		
		                System.out.print("Enter new PIN: ");
		                int newPin = sc.nextInt();
		
		                if (atm.changePin(oldPin, newPin)) 
		                {
		                    System.out.println("PIN Changed Successfully!");
		                } 
		                else
		                {
		                    System.out.println("Invalid old PIN or new PIN!");
		                }
		                break;
		
		            case 5:
		                System.out.println("Thank you for using ATM!");
		                running = false;
		                break;
		
		            default:
		                System.out.println("Invalid Choice!");
		        }
		    }
		}
			}
		
