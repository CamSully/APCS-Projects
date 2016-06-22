/**
 * This is a class that tests the Deck class.
 * 
 * @author Cameron Sullivan
 * @version 2016.4.2
 */
public class DeckTester {
	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) throws Exception {
	    // Introduce user to the project and class.
	    System.out.println("Welcome to the Deck tester class.");
	    Thread.sleep(1000);
	    System.out.println("The purpose of this project is for the user to create decks of cards.");
	    System.out.println("Various methods can be called on the decks of cards.");
	    System.out.println("This class exists to test the sucess of this project.\n");
	    Thread.sleep(1000);
	    
	    // Create first deck.
	    System.out.println("The first deck of cards will now be created and tested.");
	    System.out.println("The ranks of this deck will be: two, jack.");
	    System.out.println("The suit of this deck will be: spades.");
	    System.out.println("The values of this deck will be: 2, 11.");
	    String[] ranks1 = new String[] {"two", "jack"};
	    String[] suits1 = new String[] {"spades"};
	    int[] values1 = new int[] {2, 11};
	    Deck deck1 = new Deck(ranks1, suits1, values1);
	    System.out.println("The first deck of cards has been created.\n");
	    
	    // Test methods on deck 1.
	    System.out.println("Now the isEmpty() method will be called, to see if the deck is empty.");
	    System.out.println("> The deck is empty? " + deck1.isEmpty());
	    System.out.println("Next the size() method will be called, to see how many cards are in the deck.");
	    System.out.println("> There are " + deck1.size() + " cards in the deck.");
	    System.out.println("The deal() method will now be called, to 'deal' the user a card.");
	    System.out.println("> Your card is the " + deck1.deal());
	    System.out.println("Finally, the toString() method will be called to show the contents of the deck.");
	    System.out.println("> " + deck1);
	    
	    System.out.println("_______________________________________________________________________________________________\n");
	    Thread.sleep(1000);
	    
	    // Create second deck.
	    System.out.println("The second deck of cards will now be created and tested.");
	    System.out.println("The ranks of this deck will be: four, nine, queen, ace.");
	    System.out.println("The suits of this deck will be: diamonds, clubs.");
	    System.out.println("The values of this deck will be: 4, 9, 12, 14.");
	    String[] ranks2 = new String[] {"four", "nine", "queen", "ace"};
	    String[] suits2 = new String[] {"diamonds", "clubs"};
	    int[] values2 = new int[] {4, 9, 12, 14};
	    Deck deck2 = new Deck(ranks2, suits2, values2);
	    System.out.println("The second deck of cards has been created.\n");
	    
	    // Test methods on second deck.
	    System.out.println("Now the isEmpty() method will be called, to see if the deck is empty.");
	    System.out.println("> The deck is empty? " + deck2.isEmpty());
	    System.out.println("Next the size() method will be called, to see how many cards are in the deck.");
	    System.out.println("> There are " + deck2.size() + " cards in the deck.");
	    System.out.println("The deal() method will now be called, to 'deal' the user a card.");
	    System.out.println("> Your card is the " + deck2.deal());
	    System.out.println("Finally, the toString() method will be called to show the contents of the deck.");
	    System.out.println("> " + deck2);
	    
	    System.out.println("_______________________________________________________________________________________________\n");
	    Thread.sleep(1000);
	    
	    // Create third deck.
	    System.out.println("The third deck of cards will now be created and tested.");
	    System.out.println("The ranks of this deck will be: seven, three, king, queen, four");
	    System.out.println("The suits of this deck will be: hearts, spades, clubs.");
	    System.out.println("The values of this deck will be: 7, 3, 13, 12, 4.");
	    String[] ranks3 = new String[] {"seven", "three", "king", "queen", "four"};
	    String[] suits3 = new String[] {"hearts", "spades", "clubs"};
	    int[] values3 = new int[] {7, 3, 13, 12, 4};
	    Deck deck3 = new Deck(ranks3, suits3, values3);
	    System.out.println("The third deck of cards has been created.\n");
	    
	    // Test methods on third deck.
	    System.out.println("Now the isEmpty() method will be called, to see if the deck is empty.");
	    System.out.println("> The deck is empty? " + deck3.isEmpty());
	    System.out.println("Next the size() method will be called, to see how many cards are in the deck.");
	    System.out.println("> There are " + deck3.size() + " cards in the deck.");
	    System.out.println("The deal() method will now be called, to 'deal' the user a card.");
	    System.out.println("> Your card is the " + deck3.deal());
	    System.out.println("Finally, the toString() method will be called to show the contents of the deck.");
	    System.out.println("> " + deck3);
	    
	    System.out.println("_______________________________________________________________________________________________\n");
	    Thread.sleep(1000);
	    
	    // Test shuffle() twice with a standard 52 card deck.
	    System.out.println("Lastly, a standard 52 card deck will now be created to test the efficacy of the shuffle method.");
	    String[] ranks52 = new String[] {"two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace"};
	    String[] suits52 = new String[] {"spades", "hearts", "clubs", "diamonds"};
	    int[] values52 = new int[] {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
	    Deck deck52 = new Deck(ranks52, suits52, values52);
	    System.out.println("The shuffled deck will now be printed for you to see: ");
	    System.out.println("> " + deck52);
	    System.out.println("The deck will now be shuffled and printed again: ");
	    deck52.shuffle();
	    System.out.println("> " + deck52);
	}
}
