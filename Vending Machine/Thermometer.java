import java.util.*;
import java.lang.*;
/**
 * The thermometer calculates a random temperature between 32 and 100.
 * The temperature will be rounded to the nearest degree for the purpose of price calculation.
 * The temperature will be rounded to the nearest tenth of a degree for the user to see.
 * 
 * @author Cameron Sullivan 
 * @version 2016.1.2
 */
public class Thermometer
{
    // Initialize some private variables for each Thermometer object.
    private double temp;
    private int finalTemp;
    private double userTemp;
    
    public Thermometer () {
        Random random = new Random();
        
        // Set a low value for the user temperature to allow the while loop to function.
        userTemp = 0;
        
        // While the temperature is below the lower limit...
        while (userTemp < 32) {
            // Calculate a random double (0<x<1)
            userTemp = random.nextDouble();
            // Multiply the number by 1000 to get a 3 digit number (to allow for rounding to 3 digits).
            userTemp *= 1000;
            // Round the number.
            userTemp = Math.round(userTemp);
            // Divide by 10 to get a number from 32.0-100.0 rounded to one decimal.
            userTemp /= 10;
        }
    }
    
    /*
     * getUserTemp simply returns the temperature to one decimal to the user.
     * 
     * @param none
     * @return userTemp
     */
    public double getUserTemp () {
        // Return the temperature to the user (degrees Fahrenheit).
        return userTemp;
    }
    
    /*
     * getPriceTemp returns the temperature to the nearest degree.
     * 
     * @param none
     * @return finalTemp
     */
    public int getPriceTemp () {
        // Round the one decimal temperature that is shown to the user (still a double).
        temp = Math.round(userTemp);
        // Convert the double to an int (because switches only accept ints).
        finalTemp = (int)(temp);
        // Return the temperature rounded to nearest degree (degrees Fahrenheit).
        return finalTemp;
    }
}
