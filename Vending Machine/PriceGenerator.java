/**
 * PriceGenerator takes a Thermometer object as a parameter, because it relies on having the temperature of a specific thermometer to calculate price.
 * The purpose of PriceGenerator is to calculate a price for any temperature, and pass that price along to the cash machine.
 * 
 * @author Cameron Sullivan 
 * @version 2016.1.2
 */
public class PriceGenerator
{
    // Initialize some variables.
    private int temp;
    private double price;
    Thermometer tempReading;
    
    public PriceGenerator (Thermometer thermo) {
        // Make a usable thermometer for the price generator (give it class-wide access).
        tempReading = thermo;
    }
    
    /*
     * getPrice calculates the price of the user's soda, given the temperature outside.
     * 
     * @param none
     * @return price
     */
    public double getPrice () {
        // Get the temperature from the thermometer.
        temp = tempReading.getPriceTemp();
        
        // Switch temperature to find price.
        switch (temp) {
            // If the temperature is from 50-60 degrees...
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
                // price is 55 cents.
                price = 0.55;
                break;
                
            // If the temperature is from 61-65 degrees...
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
                // Price is 60 cents.
                price = 0.60;
                break;
                
            // If the temperature is from 66-70 degrees...
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
                // Price is 65 cents.
                price = 0.65;
                break;
                
            // If the temperature is from 71-75 degrees...
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
                // Price is 75 cents.
                price = 0.75;
                break;
                
            // If the temperature is from 76-80 degrees...
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
                // Price is 80 cents.
                price = 0.80;
                break;
                
            // If the temperature is from 81-85 degrees...
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
                // Price is 85 cents.
                price = 0.85;
                break;
                
            // If the temperature is from 86-90 degrees...
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
                // Price is 90 cents.
                price = 0.90;
                break;
                
            // If the temperature is from 91-100 degrees...
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
                // Price is 1 dollar.
                price = 1.00;
                break;
                
            // (if temperature is less than 50 degrees)
            default:
                // Price is 50 cents.
                price = 0.50;
                break;
        }
        
        return price;
    }
}
