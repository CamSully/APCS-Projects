import java.util.Random;
/**
 * SixSidedDie is the base class of this program.
 * This class uses random.nextInt() to roll a theoretical die and saves the value it lands on.
 * 
 * @author Cameron Sullivan
 * @version 2015.10.22
 */
public class SixSidedDie
{
    // Initialize random.
    private Random random = new Random();
    // Initial roll value.
    private int roll_value;
    
    // Main method to start operation.
    public static void main (String args[]) {
        System.out.println("Die created. Invoke the \"roll\" method to roll the die.");
    }
    
    /**
     * Method roll uses random numbers 1-6 to simulate rolling a die.
     * 
     * @return roll_value this allows the value of the die to be stored.
     */
    public int roll () {
        // Create a random integer between 1 and 6 to simulate rolling a die.
        roll_value = random.nextInt(6) + 1;
        // Print out the end result.
        System.out.println("Die value = " + roll_value);
        // Return the end result
        return roll_value;
    }
}
