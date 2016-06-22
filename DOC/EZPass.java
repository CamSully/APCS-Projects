import java.util.*;
/**
 * EZPass simulates a modern highway EZPass, allowing tolls to be conveniently purchased.
 * 
 * @author Cameron Sullivan
 * @version 2015.10.22
 */
public class EZPass
{
    // Price/balance definitions
    double balance;
    int roadTollPrice;
    int bridgeTollPrice;
    int tunnelTollPrice;
    
    // Identification definitions.
    int passNumber;
    String passName;
    
    /**
     * Creates an EZPass for the card holder with an entered credentials and initial balance on the card.
     * Note that a $10 deposit will be subtracted from the balance of the card.
     * Note that the cardNumber must be at least 5 digits.
     */
    public EZPass(String name, int cardNumber, double initialFunds) throws Exception
    {
        // Sets the inputed name equal to the pass name.
        passName = name;
        
        if (cardNumber < 9999) {
            // Prints an error message requesting a new, correct card number.
            System.out.println("Invalid card number. Please make the number at least 5 digits long.");
        }
        else {
            // Print a thank you message to show the successful creation.
            System.out.println("Thank you for creating your EZ Pass.");
            // Sets the inputted number equal to the pass number.
            passNumber = cardNumber;
            Thread.sleep(1500);             
            System.out.println("Creating personal pass account...");             
            Thread.sleep(1500);               
            // Print out the user's name.
            System.out.println("Passholder name: " + name + ".");
            Thread.sleep(1500);
            // Print out the user's card number.
            System.out.println("EZ pass number: " + cardNumber + ".");
            Thread.sleep(1500);
            System.out.println("Your pass is now ready to use.");
            Thread.sleep(1500);
        }
        
        if (initialFunds < 30) {
            // Scold user.
            System.out.println("You must add more than $30 to your EZPass. Please re-enter your initial value.");
        }
        else {
            //Set the balance equal to the initial funds minus the $10 deposit.
            balance = initialFunds - 10;
            //Print a confirming message and the balance.
            System.out.println("Thank you for purchasing your EZPass. Your $10 deposit has been recorded.");
            Thread.sleep(1500);
            System.out.println("EZPass Balance: $" + balance);
            System.out.println(" ");
        }
        
        //Set the toll prices. 
        roadTollPrice = 1;
        bridgeTollPrice = 2;
        tunnelTollPrice = 3;
    }

    // This method allows the cardholder to travel through a road toll booth. One dollar will be subtracted from the EZPass.
    public void roadToll() {
        // Subtract a road toll from the balance.
        balance = balance - roadTollPrice;
        // Print a line showing a completed transaction.
        System.out.println("Thank you for using EZPass! You have passed through the road toll booth.");
        // Print a receipt.
        System.out.println("Price of toll: $" + roadTollPrice);
        System.out.println("EZPass Balance: $" + balance);
        System.out.println(" ");
    }
    
    // This method allows the cardholder to travel through a bridge toll booth. Two dollars will be subtracted from the EZPass.
    public void bridgeToll() {
        // Subtract the toll price from the balance.
        balance = balance - bridgeTollPrice;
        // Print proof of the transaction.
        System.out.println("Thank you for using EZPass! You have passed through the bridge toll booth.");
        // Print a receipt.
        System.out.println("Price of toll: $" + bridgeTollPrice);
        System.out.println("EZPass Balance: $" + balance);
        System.out.println(" ");
    }
    
    // This method allows the cardholder to travel through a road toll booth. Three dollars will be subtracted from the EZPass.
    public void tunnelToll() {
        //Subtract the price of a toll.
        balance = balance - tunnelTollPrice;
        // Print proof of the transaction.
        System.out.println("Thank you for using EZPass! You have passed through the tunnel toll booth.");
        // Print a receipt.
        System.out.println("Price of toll: $" + tunnelTollPrice);
        System.out.println("EZPass Balance: $" + balance);
        System.out.println(" ");
    }
    
    // This method allows the cardholder to check their EZPass balance.
    public void checkBalance() {
        //Print the EZPasse's balance.
        System.out.println("Your balance is: $" + balance + ".");
        System.out.println(" ");
    }
    
    // This method allows the cardholder to add money to their EZPass.
    public void addFunds(double funds) {
        if (funds < 0) {
            // Print an error message.
            System.out.println("Error: You cannot add negative money to your EZ Pass.");
        }
        else {
            // Add the funds to the balance.
            balance = balance + funds;
            // Print proof of the transaction.
            System.out.println("You have added $" + funds + " To your EZPass.");
            // Print the new balance.
            System.out.println("EZPass balance: $" + balance);
            System.out.println("Your credit card has been charged for the added funds.");
            System.out.println(" ");
       }
    }
}
