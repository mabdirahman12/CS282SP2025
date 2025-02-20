/* 
 * CS 282 Intermediate Java Spring 2023
 * Cuyamaca College
 * Muhsin Abdirahman
 * Lab 1 
 * This class represents a bank account that keeps track of a balance and 
 * an annual interest rate. It provides methods for deposits, withdrawals, 
 * interest accrual, and retrieving account details.
 */

public class Account {
    private double balance;
    private double interestRate;

    public Account() {
        this(0.0, 0.0);
    }

    public Account(double balance, double interestRate) {
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
            System.out.printf("Deposited: $%.2f | New Balance: $%.2f%n", amount, balance);
        } else {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Withdrew: $%.2f | New Balance: $%.2f%n", amount, balance);
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
        System.out.printf("Accrued interest for %d months | New Balance: $%.2f%n", months, balance);
    }
}
