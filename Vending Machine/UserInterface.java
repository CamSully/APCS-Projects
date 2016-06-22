/**
 * UserInterface combines the thermometer, price generator, and cash machine together to form a user interface.
 * The user interface allows them to purchase a soda and experience the whole process of the three classes.
 * 
 * @author Cameron Sullivan 
 * @version 2016.1.2
 */
public class UserInterface
{
    public static void main (String args[]) throws Exception {
        // Create a Thermometer object.
        Thermometer thermo = new Thermometer();
        // Create a PriceGenerator object with the above thermometer as a parameter.
        PriceGenerator priceGen = new PriceGenerator(thermo);
        // Create a CashMachine object with the above price generator as a parameter.
        CashMachine cashMach = new CashMachine(priceGen);
        
        // Print an introductory message.
        System.out.println("Welcome to the Happy Times Soda Co. soda machine!");
        Thread.sleep(2000);
        // Inform the user of the outdoor temperature.
        System.out.println("Current outdoor temperature: " + thermo.getUserTemp() + " degrees Fahrenheit.");
        Thread.sleep(1000);
        // Inform the user of the price of a can of soda.
        System.out.println("A can of soda costs $" + priceGen.getPrice());
        Thread.sleep(1000);
        // Accept payment from the user.
        cashMach.acceptPayment();
        Thread.sleep(1000);
        // Calculate the necessary denominations of change.
        cashMach.calculateChange();
        // Give the user change and their soda.
        cashMach.giveChange();
    }
}
