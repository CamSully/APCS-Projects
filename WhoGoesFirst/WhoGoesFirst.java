import java.util.*;
/**
 * WhoGoesFirst is an algorithm that simulates the selection of a player to go first in a game.
 * The selector method uses a recursive function to decide which player goes first.
 * 
 * @author Cameron Sullivan
 * @version 2016.3.5
 */
public class WhoGoesFirst
{
    private String name;
    private int eliminator;
    Random random = new Random();
    
    public WhoGoesFirst() {
        // Empty constructor- nothing to do here.
    }
    
    /**
     * selector takes a list of names as input and returns the selected first player.
     * 
     * @param ArrayList<String> nameList The list of players' names.
     * @retrun name The name of the selected player.
     */
    public String selector (ArrayList<String> nameList) {
        // If there is one name in the list...
        if (nameList.size() == 1) {
            // Get that single name.
            name = nameList.get(0);
            return name;
        }
        
        // If there are multiple names in the list...
        else {
            // Pick one random name to eliminate (0-[nameList.size() - 1]).
            int tempVal = nameList.size();
            eliminator = random.nextInt(tempVal);
            // Remove the selected name.
            nameList.remove(eliminator);
            // Return the method with the new list as a parameter.
            return selector(nameList);
        }
    }
}
