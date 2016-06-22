/**
 * This tester class introduces the user to the Coin class and tests several aspects of Coin.
 * 
 * @author Cameron Sullivan
 * @version 2015.12.27
 */
public class Tester
{
    public static void main (String args[]) throws Exception {
        // Introduce the user.
        System.out.println("Welcome to the Coin test class. \n ");
        Thread.sleep(2000);
        System.out.println("Part I- User Introduction: \n ");
        Thread.sleep(1000);
        
        // Name the class.
        System.out.println("Class- Coin \n ");
        Thread.sleep(1000);
        
        // Name the methods.
        System.out.println("Methods: ");
        Thread.sleep(1000);
        System.out.println("Method 1- void flip()");
        Thread.sleep(500);
        System.out.println("Method 2- boolean isHeads()");
        Thread.sleep(500);
        System.out.println("Method 3- string makeString()");
        Thread.sleep(500);
        System.out.println("Method 4- void setKey()");
        Thread.sleep(500);
        System.out.println("Method 5- void lock()");
        Thread.sleep(500);
        System.out.println("Method 6- void unlock()");
        Thread.sleep(500);
        System.out.println("Method 7- boolean locked() \n ");
        Thread.sleep(500);
        
        // Name the variables.
        System.out.println("Variables: ");
        Thread.sleep(1000);
        System.out.println("Variable 1- int face");
        Thread.sleep(500);
        System.out.println("Variable 2- boolean isLocked");
        Thread.sleep(500);
        System.out.println("Variable 3- boolean keyInit");
        Thread.sleep(500);
        System.out.println("Variable 4- int realKey");
        Thread.sleep(500);
        System.out.println("Variable 5- string faceName \n");
        Thread.sleep(2000);
        
        // Show a transition to testing.
        System.out.println("Part II- Code Example:");
        Thread.sleep(1000);
        
        // Create an object and inform the user.
        Coin exampleCoin = new Coin();
        System.out.println("A coin object has been created.");
        Thread.sleep(1000);
        System.out.println("Because an object has been created, the coin was automatically flipped. \n ");
        Thread.sleep(1000);
        
        // Check to see if heads is facing up.
        System.out.println("The coin will now be checked to see if it is heads.");
        Thread.sleep(1000);
        exampleCoin.isHeads();
        
        // Make the face into a string.
        System.out.println("\nThe coin's face will now be made into a string.");
        Thread.sleep(1000);
        exampleCoin.makeString();
        
        // Set a key on the coin.
        System.out.println("\n\nThe coin will now be secured to prevent unauthorized use.");
        Thread.sleep(1000);
        System.out.println("The setkey() method will be used with \"2597\" as a parameter to represent the key.");
        Thread.sleep(1000);
        exampleCoin.setKey(2597);
        
        // Check if the coin is locked.
        System.out.println("\nThe coin now has a key but is still not fully secured. The locked() method will prove its lack of security.");
        Thread.sleep(1000);
        exampleCoin.locked();
        System.out.println("    (The coin is unlocked) \n");
        
        // Lock the coin.
        System.out.println("The coin will now be locked by invoking the lock() method and providing the key.");
        Thread.sleep(1000);
        exampleCoin.lock(2597);
        System.out.println("Because the coin is locked, other public methods cannot be invoked.");
        Thread.sleep(1000);
        System.out.println("This will not be tested because the methods would throw exceptions, which would stop this method from running. \n");
        Thread.sleep(1000);
        
        // Try to unlock with a wrong key.
        System.out.println("Now that the coin is locked, unlocking will be attempted using the unlock() method and the wrong key.");
        Thread.sleep(1000);
        exampleCoin.unlock(1013);
        
        // Unlock with the correct key.
        System.out.println("\n The unlocking will be retried with the correct key.");
        Thread.sleep(1000);
        exampleCoin.unlock(2597);
        
        // Prove that they coin is unlocked.
        System.out.println("\nTo prove that the coin is unlocked, the locked() method will be used.");
        Thread.sleep(1000);
        exampleCoin.locked();
        System.out.println("    (The coin is unlocked)");
    }
}
