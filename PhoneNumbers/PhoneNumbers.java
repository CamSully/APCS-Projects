import java.util.Random;
/**
 * PhoneNumbers is a simple class that creates a random phone number (with conditions) upon activation via main method.
 * 
 * @author Cameron Sullivan 
 * @version 2015.10.22
 */
public class PhoneNumbers
{
    public static void main(String args[]) throws Exception {
        // Initialize output.
        System.out.println("Deriving a random phone number...");
        Thread.sleep(1000);
        
        // Initialize random.
        Random random = new Random();
        // Declare variables.
        int three_num;
        int last_four;
        int num1;
        int num2;
        int num3;
        
        // Create three random integers from 0-7.
        num1 = random.nextInt(8);
        num2 = random.nextInt(8);
        num3 = random.nextInt(8);
        
        // Create the second group of three digits which cannot be over 784.
        three_num = random.nextInt(685) + 100;
        
        // Create the final group with four digits.
        last_four = random.nextInt(9000) + 1000;
        
        // Print final output.
        System.out.println(num1 + "" + num2 + "" + num3 + "-" + three_num + "-" + last_four);
    }
}
