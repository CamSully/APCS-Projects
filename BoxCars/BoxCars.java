/**
 * The BoxCars class is meant to roll a pair of dice 1,000 times.
 * It will calculate the number of double sixes (boxcars), which arise during rolling.
 * 
 * @author Cameron Sullivan
 * @version 2015.10.22
 */
public class BoxCars
{
    public static void main (String Args[]) throws Exception {
        // Initialize counter for boxcars.
        int boxCar_counter = 0;
        // Create a pair of dice object.
        PairOfDice dice = new PairOfDice();
        // Initial statement
        System.out.println("PairOfDice object created... starting dice rolls.");
        Thread.sleep(2000);
        
        // Use a for loop to roll the dice 1000 times.
        for (int x = 1; x <= 1001; x++) {
            // Roll those dice! See the method in PairOfDice.
            dice.roll();
            // If there is a boxcar, print a message and count it.
            if (dice.roll() == 12) {
                System.out.println("BOX CAR DETECTED");
                boxCar_counter++;
            }
        }
        
        // Print the final summary.
        System.out.println("During the 1,000 rolls, there were " + boxCar_counter + " box cars (double sixes)");
        // Reset the counter for the next trial.
        boxCar_counter = 0;
    }
}
