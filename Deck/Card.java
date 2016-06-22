/**
 * Card.java
 * <code>Card</code> represents a playing card.
 * 
 * @author Cameron Sullivan
 * @version 2016.3.11
 */
public class Card {
   // String value that holds the suit of the card
   private String suit;
   // String value that holds the rank of the card
   private String rank;
   // int value that holds the point value.
   private int pointValue;
   // String for the printed message of toString().
   private String message;

   /**
	 * Creates a new <code>Card</code> instance.
	 *
	 * @param cardRank  a <code>String</code> value
	 *                  containing the rank of the card
	 * @param cardSuit  a <code>String</code> value
	 *                  containing the suit of the card
	 * @param cardPointValue an <code>int</code> value
	 *                  containing the point value of the card
	 */
	public Card(String cardRank, String cardSuit, int cardPointValue) {
	    // Set the private variables equal to the parameters.
	    suit = cardSuit;
	    rank = cardRank;
	    pointValue = cardPointValue;
	}


	/**
	 * Accesses this <code>Card's</code> suit.
	 * @author Cameron Sullivan
	 * @version 2016.3.10
	 * @return this <code>Card's</code> suit.
	 */
	public String getSuit() {
	    return suit;
   }

	/**
	 * Accesses this <code>Card's</code> rank.
	 * @author Cameron Sullivan
	 * @version 2016.3.10
	 * @return this <code>Card's</code> rank.
	 */
	public String getRank() {
		return rank;
	}

   /**
	 * Accesses this <code>Card's</code> point value.
	 * @author Cameron Sullivan
	 * @version 2016.3.10
	 * @return this <code>Card's</code> point value.
	 */
	public int getPointValue() {
		return pointValue;
	}

	/** Compare this card with the argument.
	 * @author Cameron Sullivan
	 * @version 2016.3.11
	 * @param otherCard the other card to compare to this
	 * @return true if the rank and suit of this card are equal to those of the argument, false otherwise.
	 */
	public boolean equals(Card otherCard) {
	    // If the cards are of the same suit and same rank, they are identical.
		if (getSuit().equals(otherCard.getSuit()) && getRank().equals(otherCard.getRank())) {
		    return true;
		}
		// If not, they are not the same card.
		else {
		    return false;
		}
	}

	/**
	 * Converts the rank, suit, and point value into a string in the format
	 *     "[Rank] of [Suit] (point value = [PointValue])".
	 * This provides a useful way of printing the contents
	 * of a <code>Deck</code> in an easily readable format or performing
	 * other similar functions.
	 *
	 * @author Cameron Sullivan
	 * @version 2016.3.11
	 * @return a <code>String</code> containing the rank, suit,
	 *         and point value of the card.
	 */
	@Override
	public String toString() {
	    // Create a message that contains the card's rank, suit, and point value.
	    message = "";
		message += getRank() + " of " + getSuit();
		message += "(point value = " + pointValue + ")";
		return message;
	}
}
