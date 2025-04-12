/* CS 282 Intermediate Java  Spring 2025
 * Cuyamaca College
 * Muhsin Abdirahman
 * Lab 1 
 * The program uses an Account class (not shown here) to manage account operations.
 * It features an interactive console menu and handles input validation for a 
 * smoother user experience.
 */

import java.util.Scanner;

public class BankAccount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account acct = new Account(1000, 0.05); // Initial balance: $1000, 5% interest rate

        int choice = 99;

        System.out.println("Welcome to Town Bank\n");

        while (choice != 6) {
            choice = menu(sc);
            switch (choice) {
                case 1:
                    acct.displayBalance();
                    break;
                case 2:
                    acct.displayInterestRate();
                    break;
                case 3:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    acct.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = sc.nextDouble();
                    acct.withdraw(withdrawAmount);
                    break;
                case 5:
                    System.out.print("Enter number of months for interest accrual: ");
                    int months = sc.nextInt();
                    acct.accrueInterest(months);
                    break;
                case 6:
                    System.out.println("!!Thank you and Good Bye!!\n");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.\n");
            }
        }
        sc.close();
    }

    public static int menu(Scanner sc) {
        int choice = 99;

        System.out.println("Enter the number for the Operation you wish to perform:");
        System.out.println("1. Check Balance\n" +
                           "2. Check Current Rate\n" +
                           "3. Deposit to Account\n" +
                           "4. Withdraw from Account\n" +
                           "5. Project Interest Accrual\n" +
                           "6. Exit Program\n");

        System.out.print("Enter Choice: ");
        try {
            choice = sc.nextInt();
            while (choice < 1 || choice > 6) {
                System.out.print("Please enter a valid menu choice: ");
                choice = sc.nextInt();
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("!!Non-integer entered!! Please enter a valid number.");
            sc.next();
            choice = 99;
        }
        System.out.println(); // prints blank line
        return choice;
    }
}
