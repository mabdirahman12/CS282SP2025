/* 
 * CS 282 Intermediate Java Spring 2025
 * Cuyamaca College
 * Muhsin Abdirahman
 * Lab 3 - Cipher
 * This program implements a keyword-based variation of the Caesar Cipher.
 * Users can input a keyword to generate a custom cipher alphabet, 
 * encrypt and decrypt messages, and interact with a simple text-based menu.
 */

import java.util.Scanner;

public class KeywordCaesarCipher {
    private static String createCipher(String keyword) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder cipher = new StringBuilder();
        for (char ch : (keyword + alphabet).toCharArray()) {
            if (cipher.indexOf(String.valueOf(ch)) == -1) {
                cipher.append(ch);
            }
        }
        return cipher.toString();
    }

    private static String convert(String message, String from, String to) {
        StringBuilder result = new StringBuilder();
        for (char ch : message.toUpperCase().toCharArray()) {
            int index = from.indexOf(ch);
            result.append(index != -1 ? to.charAt(index) : ch);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String keyword = "TOY";
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String cipher = createCipher(keyword);
        
        while (true) {
            System.out.println("\n1. Set Keyword\n2. Encrypt\n3. Decrypt\n9. Quit");
            String choice = scanner.nextLine().trim();
            
            if (choice.equals("1")) {
                System.out.print("New keyword: ");
                keyword = scanner.nextLine().trim().toUpperCase();
                cipher = createCipher(keyword);
            } else if (choice.equals("2")) {
                System.out.print("Message: ");
                System.out.println("Encrypted: " + convert(scanner.nextLine(), alphabet, cipher));
            } else if (choice.equals("3")) {
                System.out.print("Message: ");
                System.out.println("Decrypted: " + convert(scanner.nextLine(), cipher, alphabet));
            } else if (choice.equals("9")) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}
