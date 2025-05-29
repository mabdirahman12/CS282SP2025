/* 
 * CS 282 Intermediate Java Spring 2025
 * Cuyamaca College
 * Muhsin Abdirahman
 * Card Game Project
 * This program defines the Card class used in a War card game simulation.
 * Each card has a suit, rank, and value used for comparing cards.
 */
public class Card {
    private final String suit;
    private final String rank;
    private final int value;

    public Card(String suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
