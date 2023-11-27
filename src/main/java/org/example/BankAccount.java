package org.example;

public class BankAccount {
    private double balance;
    private final String accountId;

    public BankAccount(String accountId) {
        this.accountId = accountId;
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            throw new IllegalArgumentException("Invalid amount or insufficient funds");
        }
        balance -= amount;
    }

    public void transfer(BankAccount toAccount, double amount) {
        if (amount <= 0 || amount > this.balance) {
            throw new IllegalArgumentException("Invalid amount or insufficient funds");
        }
        this.withdraw(amount);
        toAccount.deposit(amount);
    }
}