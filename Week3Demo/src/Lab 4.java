

public class Main {

    // Recursive function to find the sum of digits of a number
    public static int sumOfDigits(int n) {
        // Base case: if the number is 0, the sum of digits is 0
        if (n == 0) {
            return 0;
        }
        // Recursive case: sum the last digit and call the function with the rest of the digits
        return n % 10 + sumOfDigits(n / 10);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Sum of digits of 1234: " + sumOfDigits(1234)); // Expected output: 10
        System.out.println("Sum of digits of 9876: " + sumOfDigits(9876)); // Expected output: 30
        System.out.println("Sum of digits of 0: " + sumOfDigits(0));       // Expected output: 0
        System.out.println("Sum of digits of 555: " + sumOfDigits(555));   // Expected output: 15
    }
}
