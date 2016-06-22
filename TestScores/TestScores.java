import java.util.*;
/**
 * TestScores takes a series of test score inputs from the user, and calculates some summary statistics, displaying them at the end of execution.
 * 
 * @author Cameron Sullivan 
 * @version 2015.11.28
 */
public class TestScores
{
    public static void main (String args[]) {
        
        // Initialize some variables.
        double total = 0;
        double average = 0;
        int minimum = 100;
        int maximum = 0;
        int medianCounter = 0;
        int firstIndex = 0;
        int secondIndex = 0;
        double median = 0;
        int counter = 0;
        
        // Initialize the scanner to take input.
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many test scores do you need to enter?");
        // Save their entered value for number of scores.
        int numOfTests = scanner.nextInt();
        // Create an array for scores with the proper number of indices.
        int[] testScore = new int[numOfTests];
        
        // Pass through the test entering loop.
        for (int i = 0; i < numOfTests; i++) {
            counter++;
            // Print the test score number for the user.
            System.out.println("Enter test score " + counter);
            // Take the score as an inputted integer.
            int input = scanner.nextInt();
            // Save the input at the proper index in the test score array.
            testScore[i] = input;
        }
        
        // Sort the array to ensure the values are ascending.
        Arrays.sort(testScore);
        
        // Pass through the summing loop to get the total score of all tests.
        for (int x = 0; x < numOfTests; x++) {
            // Add each score to the total.
            total += testScore[x];
        }
        // Calculate the average.
        average = total / numOfTests;
        
        // Pass through the min/max evaluation loop.
        for (int w = 0; w < numOfTests; w++) {
            // For each entered value, see if it is greater than the current maximum (starts at 0).
            if (testScore[w] > maximum) {
                // If score IS greater than current max, make it the new max.
                maximum = testScore[w];
            }
            // Also see if values are less than current minimum (starts at 100).
            if (testScore[w] < minimum) {
                // If score IS less than current min, make it the new min.
                minimum = testScore[w];
            }
        }
        
        // Median section: if/else evaluation.
        // If the number of entered scores is odd...
        if (numOfTests % 2 == 1) {
            // Divide the number of tests by two (still an integer) to get the index of the median value.
            medianCounter = (numOfTests / 2);
            // Find the median by taking the previously calculated index of the test score array.
            median = testScore[medianCounter];
        }
        // If the number of entered scores is even...
        else {
            // Find the two middle indices.
            firstIndex = (numOfTests / 2) - 1;
            secondIndex = numOfTests / 2;
            // Find the first and second numbers in the array by using the indices.
            double firstNum = testScore[firstIndex];
            double secondNum = testScore[secondIndex];
            // Find the median by averaging the first and second numbers.
            median = (firstNum + secondNum) / 2;
        }
        
        // Print a final statement to the user.
        System.out.println("You entered " + numOfTests + " tests.");
        System.out.println("Average Score: " + average);
        System.out.println("Minimum Score: " + minimum);
        System.out.println("Maximum Score: " + maximum);
        System.out.println("Median Score: " + median);
    }
}
