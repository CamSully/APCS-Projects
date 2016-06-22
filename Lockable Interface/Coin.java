import java.util.*;
// ORIGINAL DOCUMENTATION
//********************************************************************
//  Coin.java       Author: Lewis/Loftus
//
//  Represents a coin with two sides that can be flipped.
//********************************************************************
// EDITION 2 DOCUMENTATION
/**
 * Coin is a class that simulates any coin with a head and tail side.
 * However, this particular coin is unique in that it allows the user to lock their coin with a four digit pin.
 * 
 * @author Cameron Sullivan
 * @version 2015.12.27
 */
public class Coin implements Lockable
{
   private final int HEADS = 0;
   private final int TAILS = 1;

   private int face;
   
   // Initialize some variables.
   boolean isLocked;
   boolean keyInit = false;
   int realKey;
   
   //-----------------------------------------------------------------
   //  Sets up the coin by flipping it initially.
   //-----------------------------------------------------------------
   public Coin ()
   {
      flip();
   }

   //-----------------------------------------------------------------
   //  Flips the coin by randomly choosing a face value.
   //-----------------------------------------------------------------
   public void flip ()
   {
      // If the coin is locked...
      if (isLocked) {
          // Prevent the method from running and tell the user.
          System.out.println("Operation failure. Please unlock your coin to run this method.");
          return;
      }
      
      face = (int) (Math.random() * 2);
   }

   //-----------------------------------------------------------------
   //  Returns true if the current face of the coin is heads.
   //-----------------------------------------------------------------
   public boolean isHeads () throws Exception
   {
        // If the coin is locked...
        if (isLocked) {
            // Prevent the method from running and tell the user.
            System.out.println("Operation failure. Please unlock your coin to run this method.");
            throw new Exception();
        }
        
        // Print the result for the user's information.
        System.out.print(face == HEADS);
        return (face == HEADS);
   }

   //-----------------------------------------------------------------
   //  Returns the current face of the coin as a string.
   //-----------------------------------------------------------------
   public String makeString () throws Exception
   {
       // If the coin is locked...
       if (isLocked) {
           // Prevent the method from running and tell the user.
           System.out.println("Operation failure. Please unlock your coin to run this method.");
           throw new Exception();
       }
       String faceName;

       if (face == HEADS)
            faceName = "Heads";
       else
            faceName = "Tails";
       
       // Print the result for user understanding.
       System.out.print(faceName);
       return faceName;
    }
   
   /*
    * @param: key   setKey requires either an initial key, or the previously entered key to run.
    * @return: null (void)
    */
   public void setKey (int key) throws Exception {
       // If the coin is locked...
       if (isLocked) {
           System.out.println("Operation failure. Please unlock your coin to run this method.");
           // Prevent the method from running.
           return;
       }
       
       // Create a scanner object to take user input.
       Scanner reader = new Scanner(System.in);
       
       // If a key has not been created...
       if (!keyInit) {
           // Prevent the user from entering a 3 or 5 digit number.
           while (key < 1000 || key > 9999) {
               System.out.println("Invalid key- please re-enter a valid four digit number.");
               // Retake input until a 4 digit number is entered.
               key = reader.nextInt();
           }
           
           // After a four digit number is received, make the real key the same as the user entered key.
           realKey = key;
           // Set keyInit so that a key has been created.
           keyInit = true;
       }
       
       // (If a key has been created...)
       else {
           // Have the user re-enter thier key until the enter the real key.
           while (key != realKey) {
               System.out.println("Authentication failed. Please enter your key.");
               key = reader.nextInt();
           }
           
           // Once the entered key is the same as the real key, have them change their key.
           System.out.println("Authentication successful.");
           System.out.println("Please enter your new key.");
           realKey = reader.nextInt();
           
           // Ensure that the new key is a four digit number.
           while (realKey < 1000 || realKey > 9999) {
               System.out.println("Invalid key- please re-enter a valid four digit number.");
               realKey = reader.nextInt();
           }
       }
       
       // After a key has been set, print it for user understanding.
       System.out.println("Your key is: " + realKey);
   }
   
   /*
    * @param: key   Require the user to enter their key for security purposes.
    * @return: null (void)
    */
   public void lock(int key) throws Exception {
       // If the coin is locked...
       if (isLocked) {
           System.out.println("Operation failure. Please unlock your coin to run this method.");
           // Prevent the method from running.
           return;
       }
       
       // If the entered key is the same as the real key...
       if (key == realKey) {
           // Lock the coin.
           isLocked = true;
           System.out.println("Your coin is now locked");
       }
       
       // (if the entered key is not correct...)
       else {
           // Print an explanatory message that asks the user to try again.
           System.out.println("Authorization failure: the operation has been terminated. Please try again with the correct key.");
       }
   }
   
   /*
    * @param: key   Require the user to enter their key for security purposes.
    * @return: null (void)
    */
   public void unlock(int key) {
       // If the entered key is the same as the real key...
       if (key == realKey) {
           // Unlock the coin.
           isLocked = false;
           System.out.println("Your coin is now unlocked.");
       }
       
       // (if the entered key is not correct...)
       else {
           // Print an explanatory message that asks the user to try again.
           System.out.println("Authorization failure: the operation has been terminated. Please try again with the correct key.");
       }
   }
   
   /*
    * @param: none
    * @return: isLocked     return true if the coin is locked and false if it is unlocked.
    */
   public boolean locked() {
       // Return the state of the coin's security.
       System.out.print(isLocked);
       return isLocked;
   }
}
