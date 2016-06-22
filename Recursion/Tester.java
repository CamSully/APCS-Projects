import java.util.*;
/**
 * This tester class is meant to introduce the user to the PigLatin class and allow them to interact with it.
 * 
 * @author Cameron Sullivan 
 * @version 2016.2.27
 */
public class Tester
{
    public static void main (String args[]) throws Exception {
        PigLatin translator = new PigLatin();
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean isDone = false;
        
        System.out.println("Welcome to the Pig Latin Translator.\n");
        Thread.sleep(1000);
        System.out.println("This tester class is meant to teach you how to use the pig latin translator class.");
        Thread.sleep(500);
        System.out.println("The PigLatin class uses recursion to translate a sentence of any number of words.");
        Thread.sleep(500);
        System.out.println("To see how this works, reference the PigLatin source code.\n");
        Thread.sleep(1000);
        
        System.out.println("Now that you've been introduced to PigLatin, a few examples will be translated for you.");
        Thread.sleep(500);
        System.out.println("English: 'sandwich'");
        Thread.sleep(500);
        System.out.println("Pig Latin Translation: " + translator.translate("sandwich") + "\n");
        Thread.sleep(1000);
        
        System.out.println("English: 'apple'");
        Thread.sleep(500);
        System.out.println("Pig Latin Translation: " + translator.translate("apple") + "\n");
        Thread.sleep(1000);
        
        System.out.println("Now, some multiple word translations that apply recursion.");
        Thread.sleep(500);
        System.out.println("English: 'saline solution'");
        Thread.sleep(500);
        System.out.println("Pig Latin Translation: " + translator.translate("saline solution") + "\n");
        Thread.sleep(1000);
        
        System.out.println("English: 'It is elementary my dear Watson'");
        Thread.sleep(500);
        System.out.println("Pig Latin Translation: " + translator.translate("it is elementary my dear watson") + "\n");
        Thread.sleep(1000);
        
        System.out.println("Now that you know how the translator functions, you will be allowed to translate your own strings.");
        while (!isDone) {
            System.out.println("\nEnter a string you would like translated to Pig Latin.");
            System.out.print("~$ ");
            input = scanner.nextLine();
            System.out.println("Translating...");
            Thread.sleep(1000);
            System.out.println("Pig Latin Translation: " + translator.translate(input));
            
            System.out.println("Press q to quit, press any other key to continue.");
            if (scanner.nextLine().equals("q")) {
                isDone = true;
            }
        }
    }
}
