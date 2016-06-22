import java.util.*;
import java.lang.*;
import java.text.*;
/**
 * HealthcareHolder simulates a stockholder of the healthcare sector.
 * 
 * @author Cameron Sullivan
 * @version 2016.1.31
 */
public class HealthcareHolder extends StockHolder implements FundControl
{
    // Initialize private class variables.
    private double sharePrice;
    private double cost;
    private int shareNum;
    private double investment;
    private double rate;
    private double printRate;
    Random random = new Random();
    
    public HealthcareHolder(String name, String birthdate, double balance) {
        // Complete the superclass constructor with identical parameters.
        super(name, birthdate, balance);
        // Set a random stock price from $10-$20.
        sharePrice = random.nextInt(1000) + 1000;
        sharePrice /= 100;
    }
    
    /**
     * buyStock allows the stockholder to purchase stock, if they are authenticated.
     * 
     * @param sharesToBuy, id
     * @return none
     */
    public void buyStock(int sharesToBuy, int id) {
        // Complete the authentication in the superclass.
        super.buyStock(id);
        // If the stockholder is authenticated...
        if (super.isAuthenticated()) {
            // Add the shares they are purchasing to their total share number.
            shareNum += sharesToBuy;
            cost = sharePrice * shareNum;
            // If they didn't spend more than they have...
            if (cost <= getBalance()) {
                balance -= cost;
                investment += cost;
            }
        }
    }
    
    /**
     * Invest simulates the passing of time while a stockholder owns stocks.
     * 
     * @param   months    amount of time money is invested for.
     * @return none
     */
    public void invest(int months) {
        // If the investor owns shares...
        if (shareNum > 0) {
            rate = 0;
            // While their rate is too low, find a new rate.
            while (rate < .15) {
                rate = random.nextDouble();
            }
            // Get a rate that's around 5-10%
            rate *= 1000;
            rate = Math.round(rate);
            rate /= 10000;
            // Add the profits to the investment.
            investment += (investment*rate);
        }
        // Pay the stockholder's commission (INHERITED from superclass).
        payCommission();
    }
    
    /**
     * SellStock allows the stockholder to sell some shares.
     * 
     * @param sharesToSell
     * @return none
     */
    public void sellStock (int sharesToSell) {
        // Find a random change in the price of the stock ($1.5-$3.49).
        double shareChange = random.nextInt(200) + 150;
        shareChange /= 100;
        // Use random number evaluation to tell if stock price should rise or fall.
        int decider = random.nextInt(10);
        if (decider < 3) {
            sharePrice -= shareChange;
        }
        //Decider is from 3-9.
        else {
            sharePrice += shareChange;
        }
        
        // If the stockholder is selling more shares than 0 and less than or equal to the number they own...
        if (sharesToSell > 0 && sharesToSell <= shareNum) {
            // Subtract the shares, lessen their investment, and add to balance.
            shareNum -= sharesToSell;
            investment -= sharePrice * sharesToSell;
            balance += sharePrice * sharesToSell;
        }
    }
    
    /**
     * GetSharePrice returns the price of a share.
     * 
     * @param none
     * @return sharePrice
     */
    public double getSharePrice() {
        return sharePrice;
    }
    
    /**
     * getShareNum returns the number of shares a stockholder owns.
     * 
     * @param none
     * @return shareNum
     */
    public int getShareNum() {
        return shareNum;
    }
    
    /**
     * getInvestment returns the stockholder's investment.
     * 
     * @param none
     * @return investment
     */
    public double getInvestment() {
        return investment;
    }
    
    /**
     * getRate returns the growth rate of a stock.
     * 
     * @param none
     * @return rate
     */
    public double getRate() {
        printRate = rate * 100;
        return printRate;
    }
}
