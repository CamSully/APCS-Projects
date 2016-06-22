import java.util.*;
import java.lang.*;
import java.text.*;
/**
 * CashMachine takes a PriceGenerator object as a parameter because it must get the price of a certain temperature.
 * the CashMachine, given the price of a soda from PriceGenerator, charges the user to pay for their soda and gives them change and the product.
 * 
 * @author Cameron Sullivan 
 * @version 2016.1.2
 */
public class CashMachine
{
    // Initialize some variables.
    private double price;
    private double change;
    PriceGenerator priceGetter;
    int dollarC;
    int quarterC;
    int dimeC;
    int nickelC;
    int pennyC;
    double oldChange;
    boolean isNegative;
    
    public CashMachine (PriceGenerator pricey) {
        // Give the PriceGenerator object class-wide access.
        priceGetter = pricey;
    }
    
    /*
     * acceptPayment charges the user and takes their payment as input, then calculates the amount of change the user is due.
     * 
     * @param none
     * @return none
     */
    public void acceptPayment () throws Exception {
        Scanner reader = new Scanner(System.in);
        double payment;
        // Get the price of the soda from the PriceGenerator object.
        price = priceGetter.getPrice();
        
        // Create a decimal format to show the user only the first two decimals of the change they will get (a partial solution to double inaccuracy).
        DecimalFormat two = new DecimalFormat("0.00");
        
        // Prompt the user to pay for their soda.
        System.out.print("Please pay for your soda by entering your payment. Only dollars and cents are acceptable. \n$");
        // Accept their payment as a double.
        payment = reader.nextDouble();
        
        // If payment is negative...
        if (payment < 0) {
            // Scold the user and instruct them to re-invoke the method.
            System.out.println("Purchase Failure. You cannot pay negative money. Please try again.");
            // Make isNegative true for later use.
            isNegative = true;
            // End method execution.
            return;
        }
        
        // while they pay less than the price of their soda...
        while (payment < price) {
            // Let them know what they did.
            System.out.println("Purchase Failure. You did not pay enough for your drink.");
            // Calculate how much they still need to pay.
            double difference = price - payment;
            // Have them make another payment to get their soda.
            System.out.print("Please pay at least $" + two.format(difference) + " to purchase your soda. \n$");
            double secPayment = reader.nextDouble();
            // Add the second payment to the first.
            payment += secPayment;
        }
        
        // Set change to the amount they paid minus the price of the soda.
        change = payment - price;
        // Record the real amount of change to be used later.
        oldChange = change;
        
        // Print some messages to inform the user of execution.
        System.out.println(".");
        Thread.sleep(500);
        System.out.println(".");
        Thread.sleep(500);
        System.out.println(".");
        Thread.sleep(500);
        System.out.println("Payment accepted.");
        Thread.sleep(1000);
        
        // Format the amount of change they will get and tell them.
        System.out.println("Change owed: $" + two.format(change));
        
        // Add a bit to eliminate double error but not interfere with change.
        change += 0.001;
    }
    
    /*
     * giveChange converts the change from a raw number to dollars, quarters, dimes, nickels, and pennies.
     * 
     * @param none
     * @return none
     */
    public void calculateChange () {
        // Set the counts of all monetary units to zero.
        dollarC = 0;
        quarterC = 0;
        dimeC = 0;
        nickelC = 0;
        pennyC = 0;
        
        // While the amount of change owed is greater than one dollar...
        while (change >= 1.00) {
            // Subtract one dollar from the change.
            change--;
            // Add one to the dollar count.
            dollarC++;
        }
        
        // While the amount of change is greater than a quarter...
        while (change >= 0.25) {
            // Subtract a quarter from the change.
            change -= 0.25;
            // Add one to the quarter count.
            quarterC++;
        }
        
        // While the amount of change is greater than a dime...
        while (change >= 0.10) {
            // Subtract a dime from the change.
            change -= 0.10;
            // Add one to the dime count.
            dimeC++;
        }
        
        // While the change is greater than a nickel...
        while (change >= 0.05) {
            // Subtract a nickel from the change.
            change -= 0.05;
            // Add one to the nickel count.
            nickelC++;
        }
        
        // While the change is greater than a penny...
        while (change >= 0.01) {
            // Subtract a penny from the change.
            change -= 0.01;
            // Add one to the penny count.
            pennyC++;
        }
    }
    
    /*
     * giveChange takes the itemized change from calculateChange and creates a message for the user that gives them their change.
     * 
     * @param none
     * @return none
     */
    public void giveChange() throws Exception {
        // If the user made a negative payment, do not run the method.
        if (isNegative) {
            return;
        }
        
        // Initialize the strings to form the message.
        String message = "";
        String dollarM;
        String quarterM;
        String dimeM;
        String nickelM;
        String pennyM;
        
        // If the dollar count is not zero...
        if (dollarC > 0) {
            // If there is a single dollar...
            if (dollarC == 1) {
                // Save a message that the user receives one dollar.
                dollarM = "1 dollar ";
            }
            // (If there are multiple dollars...)
            else {
                // Save a message that the user receives multiple dollars.
                dollarM = dollarC + " dollars ";
            }
            // Add the dollar message to the whole message.
            message += dollarM;
        }
        
        // For the following loops, reference the above documentation (nearly identical).
        if (quarterC > 0) {
            if (quarterC == 1) {
                quarterM = "1 quarter ";
            }
            else {
                quarterM = quarterC + " quarters ";
            }
            message += quarterM;
        }
        
        if (dimeC > 0) {
            if (dimeC ==1) {
                dimeM = "1 dime ";
            }
            else {
                dimeM = dimeC + " dimes ";
            }
            message += dimeM;
        }
        
        if (nickelC > 0) {
            if (nickelC == 1) {
                nickelM = "1 nickel ";
            }
            else {
                nickelM = nickelC + " nickels ";
            }
            message += nickelM;
        }
        
        if (pennyC > 0) {
            if (pennyC == 1) {
                pennyM = "1 penny";
            }
            else {
                pennyM = pennyC + " pennies";
            }
            message += pennyM;
        }
        
        // If the user requires change...
        if (oldChange > 0) {
            // Print a message detailing the coins/bills they will receive.
            System.out.println("*clink* Your change rolls into the receptacle.");
            Thread.sleep(1000);
            System.out.println("You have received: " + message);
            System.out.println(".");
            Thread.sleep(750);
            System.out.println(".");
            Thread.sleep(750);
            System.out.println(".");
            Thread.sleep(750);
        }
        
        // Give the user their soda and thank them for their purchase.
        System.out.println("*Ker-chunk* A soda can falls into the bottom tray.");
        Thread.sleep(1000);
        System.out.println("Thank you for your purchase. Enjoy your beverage!");
    }
}
