import java.util.*;
/**
 * Note that no original documentation was provided.
 * 
 * Edition 2 Documentation:
 * @author Cameron Sullivan
 * @version 2016.4.2
 * 
 * The Deck class represents a shuffled deck of cards.
 * It provides several operations including
 *      initialize, shuffle, deal, and check if empty.
 */
public class Deck {

    // cards contains all the cards in the deck.
    private ArrayList<Card> deck;
    
    /**
     * size is the number of not-yet-dealt cards.
     * Cards are dealt from the top (highest index) down.
     * The next card to be dealt is at size - 1.
     */
    private int size;

    /**
     * Creates a new <code>Deck</code> instance.<BR>
     * It pairs each element of ranks with each element of suits,
     * and produces one of the corresponding card.
     * @param ranks is an array containing all of the card ranks.
     * @param suits is an array containing all of the card suits.
     * @param values is an array containing all of the card point values.
     */
    public Deck(String[] ranks, String[] suits, int[] values) {
        // Create an arraylist for the deck.
        deck = new ArrayList<Card>();
        
        // Iterate through each suit and each rank to add every card to the deck.
        for (int i = 0; i < suits.length; i++) {
            for (int x = 0; x < ranks.length; x++) {
                deck.add(new Card(ranks[x], suits[i], values[x]));
            }
        }
        
        // Get the size of the deck and shuffle the deck.
        size = deck.size();
        shuffle();
    }

    /**
     * Determines if this deck is empty (no undealt cards).
     * @return true if this deck is empty, false otherwise.
     */
    public boolean isEmpty() {
        // If size is 0, the deck is empty.
        if (deck.size() == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Accesses the number of undealt cards in this deck.
     * @return the number of undealt cards in this deck.
     */
    public int size() {
        return size;
    }
    
    /**
     * Randomly permute the given collection of cards
     * and reset the size to represent the entire deck.
     */
    public void shuffle() {
        Random random = new Random();
        int randomCard;
        
        for (int i = deck.size() - 1; i > 0; i--) {
            // Get a random number to represent a random card in the deck.
            randomCard = random.nextInt(i + 1);
            // Capture the needed card so it isn't lost when it is replaced by randomCard (Java makes all arrays that are equal to each other instantly update).
            Card tempCard = deck.get(i);
            // Replace deck[i] with deck[random].
            deck.set(i, deck.get(randomCard));
            // Replace deck[random] with deck[i].
            deck.set(randomCard, tempCard);
        }
        
        size = deck.size();
    }

    /**
     * Deals a card from this deck.
     * @return the card just dealt, or null if all the cards have been
     *         previously dealt.
     */
    public Card deal() {
        // If the deck is empty, nothing can be dealt.
        if (isEmpty()) {
            return null;
        }
        // If there are cards in the deck, decrease size, then deal the last card.
        else {
            size--;
            return deck.get(size);
        }
    }

    /**
     * Generates and returns a string representation of this deck.
     * @return a string representation of this deck.
     */
    @Override
    public String toString() {
        String rtn = "size = " + size + "\nUndealt cards: \n";

        for (int k = size - 1; k >= 0; k--) {
            rtn = rtn + deck.get(k);
            if (k != 0) {
                rtn = rtn + ", ";
            }
            if ((size - k) % 2 == 0) {
                // Insert carriage returns so entire deck is visible on console.
                rtn = rtn + "\n";
            }
        }

        rtn = rtn + "\nDealt cards: \n";
        for (int k = deck.size() - 1; k >= size; k--) {
            rtn = rtn + deck.get(k);
            if (k != size) {
                rtn = rtn + ", ";
            }
            if ((k - deck.size()) % 2 == 0) {
                // Insert carriage returns so entire deck is visible on console.
                rtn = rtn + "\n";
            }
        }

        rtn = rtn + "\n";
        return rtn;
    }
}
