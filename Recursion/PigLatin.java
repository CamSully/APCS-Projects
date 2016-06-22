/**
 * PigLatin is a recursive translator that translates English to Pig Latin.
 * 
 * @author Cameron Sullivan
 * @version 2016.2.27
 */
public class PigLatin
{
    String translation;
    int spaceCount;
    int spaceIndex;
    int mainSpaceIndex;
    
    /**
     * translate() is used to translate English strings to PigLatin strings.
     * 
     * @param input The string the user wants translated.
     * @return translation The Pig Latin translation.
     */
    public String translate(String input) {
        spaceCount = 0;
        // Iterate through all characters of the input.
        for (int i = 0; i < input.length(); i++) {
            // Look for spaces (char code 32).
            if ((int)input.charAt(i) == 32) {
                // If a space is found, add to the count, set the index, and break the loop (so that the first space is the only one counted).
                spaceCount++;
                spaceIndex = i;
                break;
            }
        }
        
        // If there are no spaces...
        if (spaceCount == 0) {
            char var;
            // Get the first character of the word.
            var = input.charAt(0);
            // If the first character is a vowel...
            if (var == 'a' || var == 'e' || var == 'i' || var == 'o' || var == 'u' || var == 'y') {
                // Add "yay" to the end.
                translation = input.substring(0, input.length()) + "yay";
                return translation;
            }
            
            // If the first character is a consonant...
            else {
                // Remove the first letter.
                translation = input.substring(1, input.length());
                // Add the first letter to the translation.
                translation += var;
                // Add 'ay' to the translation.
                translation += "ay";
                return translation;
            }
        }
        
        // If there are multiple words...
        else {
            // Keep the value of the first space in the string to split the translation.
            mainSpaceIndex = spaceIndex;
            // Translate the first word and second part (second part is after the space to the last character).
            return translate(input.substring(0, mainSpaceIndex)) + " " + translate(input.substring((mainSpaceIndex + 1)));
        }
    }
}