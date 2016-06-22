import java.util.*;
/**
 * This tester class introduces the user to WhoGoesFirst, then allows them to interact with it.
 * 
 * @author Cameron Sullivan
 * @version 2016.3.5
 */
public class Tester
{
    public static void main (String args[]) throws Exception {
        // Initialize all objects.
        WhoGoesFirst playerChooser = new WhoGoesFirst();
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list1 = new ArrayList();
        ArrayList<String> list2 = new ArrayList();
        ArrayList<String> userList = new ArrayList();
        
        // Add names to the example lists.
        list1.add("Steve Balmer");
        list1.add("Marco Rubio");
        list2.add("Dana Humphrey");
        list2.add("Zdeno Chara");
        list2.add("Linus Torvalds");
        list2.add("Mike Iaconelli");
        list2.add("Damian Lewis");
        
        // Initialize looping variables.
        boolean completelyDone = false;
        boolean done = false;
        String name;
        
        // Introduce the user.
        System.out.println("Welcome to the WhoGoesFirst tester class.");
        Thread.sleep(1500);
        System.out.println("The purpose of this class is to teach you how to work with the recursive selector method.");
        Thread.sleep(1000);
        System.out.println("The selector method takes an ArrayList of names as input, and randomly selects players to eliminate until one player remains.");
        Thread.sleep(1000);
        System.out.println("That player must theoretically 'go first' in whatever game is being played.");
        
        System.out.println("_________________________________________________________________________________________________________________________________\n");
        Thread.sleep(1000);
        
        // Prep user for examples.
        System.out.println("Now that you understand how the WhoGoesFirst class works, some examples will be provided.");
        Thread.sleep(750);
        System.out.println("First, a list of names will be printed, then the first player will be printed.\n");
        Thread.sleep(1000);
        
        // Complete first example.
        System.out.println("List of Names: Steve Balmer, Marco Rubio");
        Thread.sleep(1000);
        System.out.println("First Player: " + playerChooser.selector(list1));
        
        System.out.println("_________________________________________________________________________________________________________________________________\n");
        Thread.sleep(1000);
        
        // Complete second example.
        System.out.println("List of Names: Dana Humphrey, Zdeno Chara, Linus Torvalds, Mike Iaconelli, Damian Lewis");
        Thread.sleep(1000);
        System.out.println("First Player: " + playerChooser.selector(list2));
        
        System.out.println("_________________________________________________________________________________________________________________________________\n");
        Thread.sleep(1000);
        
        // Allow user to enter their own lists.
        System.out.println("Now that you've seen how the selector method works, you will now enter your own list of names\n");
        Thread.sleep(750);
        
        // Loop until user quits.
        while (!completelyDone) {
            // Prep the user list for new names.
            userList.clear();
            int counter = 0;
            done = false;
            // Loop the number of names the user desires.
            while (!done) {
                counter++;
                System.out.print("Enter name " + counter + ": ");
                name = scanner.nextLine();
                // Add the name to user's list.
                userList.add(name);
                // Let the user decide if they wish for another name in their list.
                System.out.println("Enter another name? (Type 'y' for yes or 'n' for no)");
                System.out.print("/>"); 
                if (scanner.nextLine().equals("n")) {
                    done = true;
                }
            }
            
            // Final statement: show the user who the first player is.
            System.out.print("The player chosen to go first is");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.println(".");
            Thread.sleep(500);
            System.out.println(playerChooser.selector(userList));
            Thread.sleep(1000);
            
            // Allow the user to enter another list, or quit.
            System.out.println("To enter another list, press 'e'. To stop, press 's'.");
            if (scanner.nextLine().equals("s")) {
                completelyDone = true;
            }
        }
    }
}
