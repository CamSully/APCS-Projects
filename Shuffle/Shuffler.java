import java.util.*;
/**
 * Original Documentation not provided.
 * 
 * Edition 2 Documentation:
 * @author Cameron Sullivan
 * @version 2016.3.26
 * 
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {
    // The number of consecutive shuffle steps to be performed in each call to each sorting procedure.
    private static final int SHUFFLE_COUNT = 3;
    // The number of values to shuffle.
    private static final int VALUE_COUNT = 52;
    // Used to convert decks in methods to the main decks.
    private static int[] deck;
    
    /**
     * Tests shuffling methods.
     * @param args is not used.
     */
    public static void main(String[] args) {
        System.out.println("Results of " + SHUFFLE_COUNT + " consecutive perfect shuffles:");
        int[] values1 = new int[VALUE_COUNT];
        for (int i = 0; i < values1.length; i++) {
            values1[i] = i;
        }
        
        for (int j = 1; j <= SHUFFLE_COUNT; j++) {
            perfectShuffle(values1);
            System.out.print("  " + j + ":");
            for (int k = 0; k < deck.length; k++) {
                System.out.print(" " + deck[k]);
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Results of " + SHUFFLE_COUNT +
                                 " consecutive efficient selection shuffles:");
        int[] values2 = new int[VALUE_COUNT];
        for (int i = 0; i < values2.length; i++) {
            values2[i] = i;
        }
        
        for (int j = 1; j <= SHUFFLE_COUNT; j++) {
            selectionShuffle(values2);
            System.out.print("  " + j + ":");
            for (int k = 0; k < deck.length; k++) {
                System.out.print(" " + deck[k]);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Apply a "perfect shuffle" to the argument.
     * The perfect shuffle algorithm splits the deck in half, then interleaves
     * the cards in one half with the cards in the other.
     * @param values is an array of integers simulating cards to be shuffled.
     */
    public static void perfectShuffle(int[] values) {
        // Initialize to decks, one for original, and one for shuffled.
        int[] originalDeck = values;
        int[] shuffledDeck = new int[values.length];
        
        int x = 0;
        // Set the first half of the cards on even indices.
        for (int i = 0; i < values.length/2; i++) {
            shuffledDeck[x] = originalDeck[i];
            x += 2;
        }
        
        x = 1;
        // Set the second half of the cards on odd indices.
        for (int i = values.length/2; i < values.length; i++) {
            shuffledDeck[x] = originalDeck[i];
            x += 2;
        }
        deck = shuffledDeck;
    }

    /**
     * Apply an "efficient selection shuffle" to the argument.
     * The selection shuffle algorithm conceptually maintains two sequences
     * of cards: the selected cards (initially empty) and the not-yet-selected
     * cards (initially the entire deck). It repeatedly does the following until
     * all cards have been selected: randomly remove a card from those not yet
     * selected and add it to the selected cards.
     * An efficient version of this algorithm makes use of arrays to avoid
     * searching for an as-yet-unselected card.
     * @param values is an array of integers simulating cards to be shuffled.
     */
    public static void selectionShuffle(int[] values) {
        Random random = new Random();
        
        int selectedCard;
        int tempVal;
        int neededCard;
        for (int i = values.length - 1; i > 0; i--) {
             tempVal = i + 1;
             // Get a random card from the deck.
             selectedCard = random.nextInt(tempVal);
             // Get the card needed for the second trade. JAVA makes all arrays that are equal to each other automatically update when one changes???
             neededCard = values[i];
             // Set the iteration card equal to the random card.
             values[i] = values[selectedCard];
             // Set the random card equal to the iteration card. THIS COMPLETES A SWAP OF THE TWO CARDS.
             values[selectedCard] = neededCard;
        }
        deck = values;
    }
}