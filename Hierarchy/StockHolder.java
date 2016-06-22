import java.util.*;
import java.lang.*;
import java.text.*;
/**
 * StockHolder is an abstract parent class that simulates a generic stockholder.
 * 
 * @author Cameron Sullivan 
 * @version 2016.1.31
 */
public abstract class StockHolder
{
    private String name;
    private String birthdate;
    private int ID;
    public double balance;
    private boolean authenticated;
    private double fee;
    DecimalFormat two = new DecimalFormat();
    
    public StockHolder(String name, String birthdate, double balance) {
        // Set parameters equal to class variables.
        this.name = name;
        this.birthdate = birthdate;
        this.balance = balance;
        Random random = new Random();
        
        // Calculate a random 5 digit ID number.
        while (ID < 10000) {
            ID = random.nextInt(100000);
        }
    }
    
    /**
     * getBalance returns the stockholder's balance.
     * 
     * @param none
     * @return balance
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * getName returns the name of the stockholder.
     * 
     * @param none
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * getBirth returns the birthdate of the stockholder.
     * 
     * @param none
     * @return birthdate
     */
    public String getBirth() {
        return birthdate;
    }
    
    /**
     * getID returns the ID of the stockholder.
     * 
     * @param none
     * @return ID
     */
    public int getID() {
        return ID;
    }
    
    /**
     * isAuthenticated returns whether the stockholder has input the correct ID or not.
     * 
     * @param none
     * @return authenticated
     */
    public boolean isAuthenticated () {
        return authenticated;
    }
    
    /**
     * getFee returns the commission fee that the stockholder must pay.
     * 
     * @param none
     * @return fee
     */
    public double getFee() {
        return fee;
    }
    
    /**
     * buyStock checks the ID of the stockholder. To actually purchase stock, this method is overridden in child classes.
     * 
     * @param checkID
     * @return none
     */
    public void buyStock(int checkID) {
        // If the ID the stockholder inputs is incorrect...
        if (checkID != ID) {
            authenticated = false;
        }
        // If the ID the stockholder inputs is correct...
        else {
            authenticated = true;
        }
    }
    
    /**
     * payCommission subtracts the commission fee from the stockholder's balance. This method is used in subclasses as inheritance.
     * 
     * @param none
     * @return none
     */
        public void payCommission() {
        fee = 0.015 * balance;
        balance -= fee;
    }
}
