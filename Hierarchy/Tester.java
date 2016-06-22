import java.util.*;
import java.text.*;
/**
 * A basic tester class for the energy sector.
 * 
 * @author Cameron Sullivan
 * @version 2016.1.31
 */
public class Tester
{
    public static void main (String args[]) throws Exception {
        // Create an object and a decimal formatter for output.
        EnergyHolder sHolder1 = new EnergyHolder("Jack Lew", "8-17-74", 537.50);
        DecimalFormat two = new DecimalFormat("0.00");
        
        // Introduction.
        System.out.println("Welcome to the Hierarchy tester class.\n");
        Thread.sleep(1000);
        System.out.println("This tutorial will teach you about how to use the class system of this project.");
        System.out.println("The superclass, StockHolder, is meant to simulate any ordinary stockholder.");
        System.out.println("The subclasses are meant to simulate investors who have specific holdings in sectors of the market.");
        System.out.println("The interface, FundControl, is meant to simulate a regulatory body, ");
        System.out.println("That requires the funds to provide the stockholders with infomation and methods.\n");
        
        System.out.println("______________________________________________________________________________________\n");
        
        // Specific intro
        Thread.sleep(1000);
        System.out.println("Now that you know about how the system works, an example is in order.");
        System.out.println("You are now a new stockholder of the energy sector. Your name is Jack Lew.");
        System.out.println("The output below is an instance of you operating your account: \n");

        // Account creation
        Thread.sleep(1000);
        System.out.println("Thank you for creating your energy sector stock account.");
        Thread.sleep(500);
        System.out.println("Name: " + sHolder1.getName());
        Thread.sleep(500);
        System.out.println("Birthdate: " + sHolder1.getBirth());
        Thread.sleep(500);
        System.out.println("ID: " + sHolder1.getID());
        Thread.sleep(500);
        System.out.println("Balance: $" + two.format(sHolder1.getBalance()) + "\n");
        Thread.sleep(2000);
        
        System.out.println("______________________________________________________________________________________\n");
        
        //buyStock()
        System.out.println("You will now purchase some stock.\n");
        Thread.sleep(1000);
        System.out.println("The price per share of energy sector stock is $" + two.format(sHolder1.getSharePrice()));
        System.out.println("To buy stocks, you must enter the number of stocks you would like to buy, and your ID.");
        System.out.println("Your ID will now be entered and you will choose to buy 5 stocks.");
        sHolder1.buyStock(5, sHolder1.getID());
        System.out.println("You have purchased 5 shares of the energy sector.");
        System.out.println("Balance: $" + two.format(sHolder1.getBalance()));
        System.out.println("Investment: $" + two.format(sHolder1.getInvestment()) + "\n");
        
        System.out.println("______________________________________________________________________________________\n");
        
        //Invest()
        System.out.println("You will now simulate passing time and waiting for your shares to appreciate.");
        System.out.println("In this case, 12 months have passed.\n");
        System.out.println("You own " + sHolder1.getShareNum() + " shares of the energy sector.");
        System.out.println("Your total investment is $" + two.format(sHolder1.getInvestment()));
        sHolder1.invest(12);
        System.out.println("Over these 12 months, the rate of return has been " + sHolder1.getRate() + "%.");
        System.out.println("Your new investment is $" + two.format(sHolder1.getInvestment()) + "\n");
        
        System.out.println("______________________________________________________________________________________\n");
        
        //getCommission()
        System.out.println("As compensation for owning shares of our managed fund, you must pay a commission fee whenever you invest in stock.");
        System.out.println("The universal commission fee is 1.5% of your current balance.");
        System.out.println("Your fee is $" + two.format(sHolder1.getFee()) + " of your balance.");
        System.out.println("Your fee will now be subtracted.");
        System.out.println("Your new balance is: $" + two.format(sHolder1.getBalance()));
        System.out.println("Be sure to pay your next commission before the end of next year.");
        
        System.out.println("______________________________________________________________________________________\n");
        
        //sellStock()
        System.out.println("You will now sell 3 of your shares.\n");
        System.out.println("You own " + sHolder1.getShareNum() + " shares of the energy sector.");
        sHolder1.sellStock(3);
        System.out.println("The current share price is $" + sHolder1.getSharePrice());
        System.out.println("Your 3 shares will now be sold.");
        System.out.println("Sale successful.");
        System.out.println("You now own " + sHolder1.getShareNum() + " shares for a total investment of $" + two.format(sHolder1.getInvestment()));
        System.out.println("Your new balance is $" + two.format(sHolder1.getBalance()) + "\n");
    }
}
