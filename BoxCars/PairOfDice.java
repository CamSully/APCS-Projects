/**
 * The PairOfDice class is used to roll two dice created as SixSidedDie objects, add their results, and return the value.
 * 
 * @author Cameron Sullivan 
 * @version 2015.10.22
 */
public class PairOfDice
{
    // Initialize the sum of the two rolls.
    private int roll_sum;
    // Initialize two die objects.
    private SixSidedDie die1 = new SixSidedDie();
    private SixSidedDie die2 = new SixSidedDie();
    
    // Start operation with a main method.
    public static void main (String Args[]) {
        System.out.println("Invoke the \"roll\" method to roll the two dice.");
    }
    
    /**
     * Method roll is used to roll two dice and return the sum of their values.
     * 
     * @return roll_sum The sum of the two dices' values is stored for later use.
     */
    public int roll () {
        // Print a space after the two (THIS IS ONLY FOR USE WITH BoxCars CLASS).
        System.out.println(" ");
        // Calculate and return the sum of the two rolls.
        roll_sum = die1.roll() + die2.roll();
        return roll_sum;
    }
}
