import java.util.*;
/**
 * Tester serves as a testing class for RationalNumber.
 * There is a user introduction section, in which the user will become familiar with the RationalNumber class,
 * and there is an interactive section, that allows the user to compare their own rational numbers via the terminal.
 * 
 * @author Cameron Sullivan 
 * @version 2015.12.19
 */
public class Tester
{
    public static void main (String args[]) throws Exception {
        //Introduce user to RationalNumber
        System.out.println("Welcome to the RationalNumber tester class.");
        Thread.sleep(2000);
        System.out.println("Initiating user introduction... \n");
        Thread.sleep(1000);
        System.out.println("Class: RationalNumber \n");
        Thread.sleep(500);
        
        //Introduce variables
        System.out.println("Attributes: ");
        Thread.sleep(1000);
        System.out.println("Variables 1 & 2: ints numerator and denominator- variables to store components of rational numbers.");
        Thread.sleep(500);
        System.out.println("Variable 3: float rawNum- the value of the numerator divided by denominator.");
        Thread.sleep(500);
        System.out.println("Variable 4: int compareValue- the result of comparing two RationalNumber objects- either 0, 1, or -1.");
        Thread.sleep(500);
        System.out.println("Variables 5 & 6: sum and difference- the result of adding or subtracting two rational numbers.");
        Thread.sleep(500);
        System.out.println("Variable 7: string result- the string obtained when a rational number is converted to string form.");
        Thread.sleep(500);
        System.out.println("There are other local variables that are not necessary to be included. \n");
        Thread.sleep(1000);
        
        //Introduce methods.
        System.out.println("Behaviors: ");
        Thread.sleep(1000);
        System.out.println("Method 1: compareTo(object2)- compares the raw numbers of two RationalNumber objects and returns the result.");
        Thread.sleep(500);
        System.out.println("Method 2: getNumerator()- a basic method to return the numerator of a rational number.");
        Thread.sleep(500);
        System.out.println("Method 3: getDenominator()- a basic method to return the denominator of a rational number.");
        Thread.sleep(500);
        System.out.println("Method 4: reciprocal()- creates a new rational number object with the numerator and denominator switched.");
        Thread.sleep(500);
        System.out.println("Method 5: add(op2)- adds the inputted rational number to the saved rational number.");
        Thread.sleep(500);
        System.out.println("Method 6: subtract(op2)- subtracts the inputted rational number from the saved rational number.");
        Thread.sleep(500);
        System.out.println("Method 7: multiply(op2)- multiplies the inputted rational number with the saved rational number.");
        Thread.sleep(500);
        System.out.println("Method 8: divide(op2)- multiplies the rational number by the reciprocal of op2.");
        Thread.sleep(500);
        System.out.println("Method 9: isLike(op2)- checks to see if two rational numbers are the same (in fraction form).");
        Thread.sleep(500);
        System.out.println("Method 10: toString()- converts a rational number in fraction form (ints) to string form.");
        Thread.sleep(500);
        System.out.println("Methods 11 & 12: reduce() and gcd(): two private methods that operate within the other methods. \n");
        Thread.sleep(1000);
        
        // Instantiate 3 RationalNumber objects.
        RationalNumber number1 = new RationalNumber(2,5);
        RationalNumber number2 = new RationalNumber(3,4);
        RationalNumber number3 = new RationalNumber(7,8);
        // Introduce user to the objects.
        System.out.println("Three RationalNumber objects have been created:");
        Thread.sleep(1000);
        System.out.println("Rational number 1: 2/5");
        Thread.sleep(500);
        System.out.println("Rational number 2: 3/4");
        Thread.sleep(500);
        System.out.println("Rational number 3: 7/8 \n");
        Thread.sleep(1000);
        
        // Complete regular and transitive tests.
        System.out.println("compareTo() test using the above objects:");
        Thread.sleep(1000);
        number1.compareTo(number2);
        Thread.sleep(500);
        number2.compareTo(number3);
        Thread.sleep(500);
        System.out.println("Therefore: 2/5 < 3/4 < 7/8 \n");
        Thread.sleep(1000);
        System.out.println("CompareTo() transitive test:");
        Thread.sleep(1000);
        number2.compareTo(number1);
        Thread.sleep(500);
        number3.compareTo(number2);
        Thread.sleep(500);
        System.out.println("Therefore: 7/8 > 3/4 > 2/5 \n");
        Thread.sleep(1000);
        
        //Create a 4th RationalNumber object whose value is within tolerance, show that it is "equal" to others.
        RationalNumber number4 = new RationalNumber (70001,80000);
        System.out.println("Rational number 4: 70001/80000");
        Thread.sleep(500);
        number3.compareTo(number4);
        System.out.println("(object 3 and 4 are considered equal because they are within the tolerance of .0001) \n");
        Thread.sleep(1000);
        
        //Loop: user can enter two numbers, RationalNumber objects are created, and results of comparison are printed.
        System.out.println("End of introduction. \n");
        Thread.sleep(1000);
        System.out.println("User interactive: \n");
        Thread.sleep(1000);
        while (true) {
            // Initialize scanner, have user input a rational number.
            Scanner reader = new Scanner(System.in);
            System.out.println("Enter the numerator (integer)");
            int numer1 = reader.nextInt();
            System.out.println("Enter the denominator (integer)");
            int denom1 = reader.nextInt();
            
            // Create an object based on user input.
            RationalNumber compare1 = new RationalNumber (numer1, denom1);
            
            // Repeat process for second rational number.
            System.out.println("Enter the SECOND numerator (integer)");
            int numer2 = reader.nextInt();
            System.out.println("Enter the SECOND denominator (integer)");
            int denom2 = reader.nextInt();
            
            RationalNumber compare2 = new RationalNumber (numer2, denom2);
            
            // Compare the two rational numbers.
            compare1.compareTo(compare2);
            
            // Allow user to continue or stop based on the "q" key.
            System.out.println("\nTo quit, press q");
            System.out.println("To continue, press any other key");
            String userEval = reader.next();
            if (userEval.equals("q")) {
                break;
            }
        }
    }
}
