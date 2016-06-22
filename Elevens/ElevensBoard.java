import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 * 
 * No original documentation provided.
 * 
 * Implemented edition documentation:
 * @author Cameron Sullivan
 * @version 2016.4.30
 */
public class ElevensBoard extends Board {

    /**
     * The size (number of cards) on the board.
     */
    private static final int BOARD_SIZE = 9;

    /**
     * The ranks of the cards for this game to be sent to the deck.
     */
    private static final String[] RANKS =
        {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

    /**
     * The suits of the cards for this game to be sent to the deck.
     */
    private static final String[] SUITS =
        {"spades", "hearts", "diamonds", "clubs"};

    /**
     * The values of the cards for this game to be sent to the deck.
     */
    private static final int[] POINT_VALUES =
        // CHANGE: JQK WAS ORIGINALLY: 0, 0, 0     NOW IS: 11, 15, 17.
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 15, 17};

    /**
     * Flag used to control debugging print statements.
     */
    private static final boolean I_AM_DEBUGGING = false;


    /**
     * Creates a new <code>ElevensBoard</code> instance.
     */
     public ElevensBoard() {
        super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
     }

    /**
     * Determines if the selected cards form a valid group for removal.
     * In Elevens, the legal groups are (1) a pair of non-face cards
     * whose values add to 11, and (2) a group of three cards consisting of
     * a jack, a queen, and a king in some order.
     * @param selectedCards the list of the indices of the selected cards.
     * @return true if the selected cards form a valid group for removal;
     *         false otherwise.
     */
    @Override
    public boolean isLegal(List<Integer> selectedCards) {
        boolean legal;
        
        switch (selectedCards.size()) {
            // If the user selects two cards...
            case 2:
                // If the two cards add to eleven, the move is legal.
                if (containsPairSum11(selectedCards)) {
                    legal = true;
                }
                // If the two cards do not add to eleven, the move is illegal.
                else {
                    legal = false;
                }
            break;
            
            // If the user selects three cards...
            case 3:
                // If the three cards are a jack, queen, and king, the move is legal.
                if (containsJQK(selectedCards)) {
                    legal = true;
                }
                // If the three are not JQK, the move is illegal.
                else {
                    legal = false;
                }
            break;
            
            // If the user select 1 or 4+ cards, the move is illegal.
            default:
            legal = false;
        }
        
        return legal;
    }

    /**
     * Determine if there are any legal plays left on the board.
     * In Elevens, there is a legal play if the board contains
     * (1) a pair of non-face cards whose values add to 11, or (2) a group
     * of three cards consisting of a jack, a queen, and a king in some order.
     * @return true if there is a legal play left on the board;
     *         false otherwise.
     */
    @Override
    public boolean anotherPlayIsPossible() {
        boolean play = false;
        // If there is an 11 sum or JQK in any of the cards on the board, there is another possible play.
        if (containsPairSum11(cardIndexes()) || containsJQK(cardIndexes())) {
            play = true;
        }
        return play;
    }

    /**
     * Check for an 11-pair in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find an 11-pair.
     * @return true if the board entries in selectedCards
     *              contain an 11-pair; false otherwise.
     */
    private boolean containsPairSum11(List<Integer> selectedCards) {
        boolean pair = false;
        
        // Iterate through all the cards and eliminate high cards to improve efficiency.
        for (int i = 0; i < selectedCards.size(); i++) {
            if (getPointValue(cardAt(selectedCards.get(i))) > 10) {
                selectedCards.remove(selectedCards.get(i));
            }
        }
        
        // Iterate through all possible card combinations.
        for (int x = 0; x < selectedCards.size(); x++) {
            for (int y = x+1; y < selectedCards.size(); y++) {
                // If the card values add to eleven, there is a legal pair.
                if (getPointValue(cardAt(selectedCards.get(x))) + getPointValue(cardAt(selectedCards.get(y))) == 11) {
                    pair = true;
                    break;
                }
            }
            if (pair) {
                break;
            }
        }
        
        return pair;
    }

    /**
     * Check for a JQK in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find a JQK group.
     * @return true if the board entries in selectedCards
     *              include a jack, a queen, and a king; false otherwise.
     */
    private boolean containsJQK(List<Integer> selectedCards) {
        boolean JQK = false;
        
        // Iterate through all cards and remove the low cards to improve efficiency.
        for (int i = 0; i < selectedCards.size(); i++) {
            if (getPointValue(cardAt(selectedCards.get(i))) < 11) {
                selectedCards.remove(i);
            }
        }
        
        // Use three seperate booleans for a jack, queen, and king.
        boolean jackFound = false;
        boolean queenFound = false;
        boolean kingFound = false;
        // Iterate through all the selected cards...
        for (int x = 0; x < selectedCards.size(); x++) {
            // If there is a jack in the cards, indicate that it was found.
            if (getPointValue(cardAt(selectedCards.get(x))) == 11) {
                jackFound = true;
            }
            // If there is a queen in the cards, indicate that it was found.
            else if (getPointValue(cardAt(selectedCards.get(x))) == 15) {
                queenFound = true;
            }
            // If there is a king in the cards, indicate that it was found.
            else if (getPointValue(cardAt(selectedCards.get(x))) == 17) {
                kingFound = true;
            }
            
            // If all three cards have been found, the selection contains JQK.
            if (jackFound && queenFound && kingFound) {
                JQK = true;
                break;
            }
            
            // If all three cards have not been found, the selection doesn't contain JQK.
            else {
               JQK = false; 
            }
        }
        
        return JQK;
    }
}
