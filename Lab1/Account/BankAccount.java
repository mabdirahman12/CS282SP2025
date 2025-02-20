/* CS 282 Intermediate Java  Spring 2023
 * Cuyamaca College
 * Muhsin Abdirahman
 * Lab 1 
 * 
 */

import java.util.Scanner;

public class BankAccount {
    private double balance;
    private double interestRate;

    public BankAccount() {
        this(0.0, 0.0);
    }

    public BankAccount(double balance, double interestRate) {
        this.balance = Math.max(balance, 0.0);
        this.interestRate = Math.max(interestRate, 0.0);
    }

    public double getBalance() {
        return balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setBalance(double amount) {
        if (amount >= 0) {
            this.balance = amount;
        } else {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
    }

    public void setInterestRate(double rate) {
        if (rate >= 0) {
            this.interestRate = rate;
        } else {
            throw new IllegalArgumentException("Interest rate cannot be negative.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Withdrawal amount must be positive and not exceed the balance.");
        }
    }

    public void accrueInterest(int months) {
        if (months < 0) {
            throw new IllegalArgumentException("Number of months cannot be negative.");
        }

        double monthlyRate = interestRate / 12;
        for (int i = 0; i < months; i++) {
            balance += (balance * monthlyRate);
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000, 0.05); // $1000 balance, 5% annual interest
        account.deposit(500);
        account.withdraw(200);
        account.accrueInterest(6);  // Apply interest for 6 months
        System.out.printf("Balance after interest: $%.2f%n", account.getBalance());
    }
}
