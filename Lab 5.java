/* 
 * CS 282 Intermediate Java Spring 2025
 * Cuyamaca College
 * Muhsin Abdirahman
 * Lab 5
 * This program simulates a waiting list system for a service office, such as the DMV.
 * The program uses a Queue data structure (LinkedList implementation) to manage
 * the first-in, first-out behavior of a real-world service line.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WaitingListApp {

    public static void main(String[] args) {
        Queue<String> waitingList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Service Office Waiting List ---");
            System.out.println("1. Add a person");
            System.out.println("2. Check who is next");
            System.out.println("3. Assist next person");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter the person's name: ");
                    String name = scanner.nextLine();
                    waitingList.offer(name);
                    System.out.println(name + " has been added to the waiting list.");
                    break;

                case "2":
                    if (!waitingList.isEmpty()) {
                        System.out.println("The next person is: " + waitingList.peek());
                    } else {
                        System.out.println("The waiting list is currently empty.");
                    }
                    break;

                case "3":
                    if (!waitingList.isEmpty()) {
                        String nextPerson = waitingList.poll();
                        System.out.println("Assisting " + nextPerson + ". They have been removed from the list.");
                    } else {
                        System.out.println("No one to assist. The waiting list is empty.");
                    }
                    break;

                case "4":
                    running = false;
                    System.out.println("Exiting program. Have a nice day!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option (1-4).");
                    break;
            }
        }

        scanner.close();
    }
}
