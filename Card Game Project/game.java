/* 
 * CS 282 Intermediate Java Spring 2025
 * Cuyamaca College
 * Muhsin Abdirahman
 * Card Game Project
 * This program defines the Game class that controls the game logic
 * for the War card game. It includes the game loop, round handling,
 * and war logic.
 */
import java.util.*;

public class Game {
    private final Player player;
    private final Player computer;
    private int roundCount;
    private final int MAX_ROUNDS = 1000;

    public Game() {
        player = new Player();
        computer = new Player();
        roundCount = 0;
    }

    public void startGame() {
        Deck deck = new Deck();
        for (int i = 0; i < 52; i++) {
            if (i % 2 == 0) {
                player.addCard(deck.dealCard());
            } else {
                computer.addCard(deck.dealCard());
            }
        }

        while (!player.isOutOfCards() && !computer.isOutOfCards() && roundCount < MAX_ROUNDS) {
            playRound();
            roundCount++;
        }

        checkGameOver();
    }

    private void playRound() {
        System.out.println("\nRound " + (roundCount + 1));
        List<Card> warPile = new ArrayList<>();

        Card playerCard = player.playCard();
        Card computerCard = computer.playCard();

        warPile.add(playerCard);
        warPile.add(computerCard);

        System.out.println("Player plays: " + playerCard);
        System.out.println("Computer plays: " + computerCard);

        if (playerCard.getValue() > computerCard.getValue()) {
            System.out.println("Player wins the round.");
            player.addCards(warPile);
        } else if (playerCard.getValue() < computerCard.getValue()) {
            System.out.println("Computer wins the round.");
            computer.addCards(warPile);
        } else {
            System.out.println("War!");
            handleWar(warPile);
        }
    }

    private void handleWar(List<Card> warPile) {
        if (!player.hasEnoughCards(4) || !computer.hasEnoughCards(4)) {
            System.out.println("One player does not have enough cards to continue war.");
            return;
        }

        for (int i = 0; i < 3; i++) {
            warPile.add(player.playCard());
            warPile.add(computer.playCard());
        }

        Card playerCard = player.playCard();
        Card computerCard = computer.playCard();
        warPile.add(playerCard);
        warPile.add(computerCard);

        System.out.println("War card - Player: " + playerCard);
        System.out.println("War card - Computer: " + computerCard);

        if (playerCard.getValue() > computerCard.getValue()) {
            System.out.println("Player wins the war.");
            player.addCards(warPile);
        } else if (playerCard.getValue() < computerCard.getValue()) {
            System.out.println("Computer wins the war.");
            computer.addCards(warPile);
        } else {
            System.out.println("Another tie! Going to war again.");
            handleWar(warPile);
        }
    }

    private void checkGameOver() {
        System.out.println("\nGame Over!");
        if (player.isOutOfCards()) {
            System.out.println("Computer wins the game.");
        } else if (computer.isOutOfCards()) {
            System.out.println("Player wins the game.");
        } else {
            System.out.println("Game ended in a draw after " + MAX_ROUNDS + " rounds.");
        }
    }
}
