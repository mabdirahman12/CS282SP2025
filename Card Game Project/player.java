/* 
 * CS 282 Intermediate Java Spring 2025
 * Cuyamaca College
 * Muhsin Abdirahman
 * Card Game Project
 * This program defines the Player class for the War card game.
 * Each player maintains a queue of cards representing their hand.
 */
import java.util.*;

public class Player {
    private final Queue<Card> hand;

    public Player() {
        hand = new LinkedList<>();
    }

    public void addCards(List<Card> wonCards) {
        hand.addAll(wonCards);
    }

    public void addCard(Card card) {
        hand.offer(card);
    }

    public Card playCard() {
        return hand.poll();
    }

    public boolean hasEnoughCards(int count) {
        return hand.size() >= count;
    }

    public boolean isOutOfCards() {
        return hand.isEmpty();
    }

    public int getCardCount() {
        return hand.size();
    }
}
