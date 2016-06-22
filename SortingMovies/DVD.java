// ORIGINAL DOCUMENTATION
//********************************************************************
//  DVD.java       Author: Lewis/Loftus
//
//  Represents a DVD video disc.
//********************************************************************

// EDITION 2 DOCUMENTATION
/**
 * DVD simulates any movie that has a year, cost, title, director, and can be bluRay or non-bluRay.
 * 
 * @author Cameron Sullivan
 * @version 2016.2.15
 */
import java.text.NumberFormat;

public class DVD implements Comparable
{
   private String title, director;
   private int year;
   private double cost;
   private boolean bluRay;
   private String compTitle;

   //-----------------------------------------------------------------
   //  Creates a new DVD with the specified information.
   //-----------------------------------------------------------------
   public DVD (String title, String director, int year, double cost,
      boolean bluRay)
   {
      this.title = title;
      this.director = director;
      this.year = year;
      this.cost = cost;
      this.bluRay = bluRay;
      
      compTitle = title;
   }

   //-----------------------------------------------------------------
   //  Returns a string description of this DVD.
   //-----------------------------------------------------------------
   public String toString()
   {
      NumberFormat fmt = NumberFormat.getCurrencyInstance();

      String description;

      description = fmt.format(cost) + "\t" + year + "\t";
      description += title + "\t" + director;

      if (bluRay)
         description += "\t" + "Blu-Ray";

      return description;
   }
   
   /**
    * compareTo() implements the method from the Comparable Interface to compare two titles (alphabetically).
    * 
    * @param dvd2 the object to be compared to
    * @return compVal the value of comparison
    */
   public int compareTo (Object dvd2) {
       int compVal;
       int count = 0;
       // Cast the compared object to 'DVD' type.
       DVD secondDVD = (DVD) dvd2;
       
       // If 'the' is part of the title, make a substring the excludes 'the'.
       if (title.substring(0,3).equals("The")) {
           compTitle = title.substring(4);
       }
       if (secondDVD.title.substring(0,3).equals("The")) {
           secondDVD.compTitle = secondDVD.title.substring(4);
       }
       
       // Get the first letters of each title.
       char letter1 = compTitle.charAt(0);
       char letter2 = secondDVD.compTitle.charAt(0);
       
       // try/catch is used because one title's length may be shorter than another's (e.g. Iron Man and Iron Man 2 cause exceptions).
       try {
           // While the two letters are the same, look further into the titles to find different letters.
           while (letter1 == letter2) {
               count++;
               letter1 = compTitle.charAt(count);
               letter2 = secondDVD.compTitle.charAt(count);
           }
        } catch (Exception e) {}
       
       // Make the first letters into numbers.
       int num1 = (int) letter1;
       int num2 = (int) letter2;
       
       // Create a comparison value to indicate which letter is alphabetically higher.
       if (num1 > num2) {
           compVal = 1;
       }
       else if (num2 > num1) {
           compVal = -1;
       }
       // (If num2 == num1)...
       else {
           compVal = 0;
       }
       
       return compVal;
    }
}
