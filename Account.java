package com.ATM;

public class Account
{
    private String name;
    private long accountNumber;
    private int pin;
    private double balance;

    // Parameterized constructor
    public Account(String name, long accountNumber, int pin, double balance)
    {
        this.name = name;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }
    
public String getName() 
{
    return name;
}

public long getAccountNumber()
{
    return accountNumber;
}

public double getBalance() 
{
    return balance;
}

public boolean verifyPin(int enteredPin)
{
    return this.pin == enteredPin;        //if the given pin is equal to enteredpin it will return true

}


public boolean deposit(double amount)
{

    if (amount > 0)
    {
        balance = balance + amount;
        return true;
    }
    else 
    {
        return false;
    }
}
public boolean withdraw(double amount) 
{

    if (amount > 0 && amount <= balance) 
    {

        balance = balance - amount;
        return true;

    } 
    else 
    {

        return false;

    }
}


public boolean changePin(int oldPin, int newPin) 
{
    if (this.pin == oldPin && newPin >= 1000 && newPin <= 9999 && oldPin != newPin)  //verifying the given pin with old pin, new pin must have 4 digits or atmost 4 digits and newpin and oldpin should not match
    {

        this.pin = newPin;
        return true;

    } 
    else 
    {

        return false;
    }
   }
}



