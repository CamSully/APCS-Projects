import java.util.*;
/**
 * Tester is meant to be a tutorial for the user in which they see example objects, and learn the behaviors and attributes.
 * 
 * @author Cameron Sullivan 
 * @version 2015.10.22
 */
public class Tester
{
    public static void main (String args[]) throws Exception {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Welcome to the tutorial for the highway EZPass project.");
        Thread.sleep(2500);
        System.out.println("Press 0 to view an example creation of an EZPass object.");
        
        int silly = scanner.nextInt();
        if (silly == 0) {
            System.out.println(" ");
            Thread.sleep(2500);
            EZPass pass = new EZPass("User", 123456, 60);
            System.out.println(" ");
       }
        else {
            System.out.println("Error");
       }
        
        System.out.println("Press 1 to continue to behaviors and attributes");
        int dude = scanner.nextInt();
        if (dude == 1) {
            System.out.println("The methods from EZPass are:");
            System.out.println("addFunds()");
            System.out.println("bridgeToll()");
            System.out.println("roadToll()");
            System.out.println("tunnelToll()");
            System.out.println("checkBalance()");
            Thread.sleep(2000);
            
            System.out.println(" ");
            System.out.println("The variables from EZPass are:");
            System.out.println("balance");
            System.out.println("roadTollPrice");
            System.out.println("bridgeTollPrice");
            System.out.println("tunnelTollPrice");
            System.out.println("passNumber");
            System.out.println("passName");
       }
       else {
           System.out.println("Error");
       }
    }
}
