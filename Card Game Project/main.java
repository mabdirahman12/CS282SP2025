
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== WAR CARD GAME ===");
            System.out.println("1. Run Game");
            System.out.println("2. Rules");
            System.out.println("3. Run Test Mode");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    Game game = new Game();
                    game.startGame();
                }
                case "2" -> printRules();
                case "3" -> runTests();
                case "4" -> exit = true;
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void printRules() {
        System.out.println("\n=== Rules of War ===");
        System.out.println("Each player is dealt 26 cards. Each round, players reveal the top card of their deck.");
        System.out.println("The player with the higher card wins both cards. In case of a tie, a war is declared:");
        System.out.println("Both players place three cards face down and a fourth face up. The higher face-up card wins all.");
        System.out.println("Repeat war if another tie. Game ends when a player has all cards or round limit reached.");
    }

    private static void runTests() {
        System.out.println("\n=== Running Test Mode ===");
        Card card1 = new Card("Hearts", "King", 13);
        Card card2 = new Card("Spades", "Ace", 14);
        assert card2.getValue() > card1.getValue();
        System.out.println("Test 1 Passed: Card comparison works.");

        Deck deck = new Deck();
        Card topCard = deck.dealCard();
        assert topCard != null;
        System.out.println("Test 2 Passed: Deck deals cards.");

        Player player = new Player();
        player.addCard(card1);
        assert player.playCard().getValue() == 13;
        System.out.println("Test 3 Passed: Player plays card correctly.");
    }
}
