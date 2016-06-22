import java.util.*;
/**
 * SearchTest is an application of the binary search algorithm in which the user enters a number from 1-500 and the computer guesses it.
 * 
 * @author Cameron Sullivan
 * @version 2016.2.6
 */
public class SearchTest
{
    // Initialize some class-wide variables (to be used in tellGuess()).
    static int guess;
    static String guessStatus;
    static Scanner scanner = new Scanner(System.in);
    
    public static void main (String args[]) throws Exception {
        // Initialize method variables.
        int userNum;
        int upper;
        int lower;
        int middle;
        int tempX;
        int guessNum;
        boolean done = false;
        
        // Print an introductory message and take user input.
        System.out.println("Welcome to the binary search test program. Enjoy your trial!");
        Thread.sleep(1000);
        System.out.println("To begin, please enter a number from 1-500.");
        Thread.sleep(100);
        System.out.print("~$ ");
        userNum = scanner.nextInt();
        System.out.println("");
        
        // If the user enters a number not in the range, tell them and end execution.
        if (userNum < 1 || userNum > 500) {
            System.out.println("Error: your number is not in the range 1-500. Please try again.");
        }
        
        // If the user's number is in the range, run the guess program.
        else {
            // Create an array filled with all numbers from 1-500.
            int library[] = new int[500];
            for (int x = 0; x < library.length; x++) {
                tempX = x+1;
                library[x] = tempX;
            }
            
            // Set some variables for guessing.
            lower = 0;
            upper = library.length - 1;
            guessNum = 0;
            
            // While the number is still being guessed...
            while (!done) {
                // Set middle to be the center of the range.
                middle = (upper - lower) / 2;
                middle += lower;
                
                // If middle is the user's number, finish.
                if (library[middle] == userNum) {
                    guessNum++;
                    done = true;
                }
                
                // If the user's number is above the middle, adjust the lower bound.
                else if (userNum > library[middle]) {
                    guessNum++;
                    guess = library[middle];
                    lower = middle + 1;
                    // Run tellGuess() (see method below).
                    tellGuess();
                }
                
                // If the user's number is below the middle, adjust the upper bound.
                else {
                    guessNum++;
                    guess = library[middle];
                    upper = middle - 1;
                    tellGuess();
                }
            }
            
            // When 'done' is true, tell the user their number has been guessed and print results.
            System.out.println("The computer has guessed your number!");
            System.out.println("Your number is: " + userNum);
            System.out.println("Number of guesses taken: " + guessNum);
        }
    }
    
    /**
     * TellGuess is a private method that allows the user to tell the computer if the computer's guess was too high or too low.
     * 
     * @param none
     * @return none
     */
    private static void tellGuess() throws Exception {
        boolean finished = false;
        
        // Print a nice 'calculating' message to show the process of guessing is occuring.
        System.out.print("Calculating");
        Thread.sleep(500);
        System.out.print(".");
        Thread.sleep(500);
        System.out.print(".");
        Thread.sleep(500);
        System.out.println(".");
        Thread.sleep(750);
        
        // Tell the user the computer's guess and prompt them to give feedback.
        System.out.println("The computer has guessed: " + guess);
        System.out.println("Please tell the computer if their guess is 'high' or 'low'.");
        while (!finished) {
            // Have the user give feedback.
            System.out.print("~$ ");
            guessStatus = scanner.next();
            // Only accept the desired messages.
            if (guessStatus.equals("low")) {
                finished = true;
            }
            else if (guessStatus.equals("high")) {
                finished = true;
            }
            else {
                System.out.println("Invalid input. Please try again.");
            }
        }
        
        // Print a line to separate guesses.
        System.out.println("___________________________________________________________________________");
    }
}
