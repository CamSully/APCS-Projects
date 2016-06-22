// ORIGINAL DOCUMENTATION
//********************************************************************
//  DVDCollection.java       Author: Lewis/Loftus
//
//  Represents a collection of DVD movies.
//********************************************************************

// EDITION 2 DOCUMENTATION
/**
 * DVDCollection simulates a collection of DVDs, referencing DVD class.
 * 
 * @author Cameron Sullivan
 * @version 2016.2.15
 */

import java.text.NumberFormat;

public class DVDCollection
{
   public DVD[] collection;
   public DVD[] unsortedCollection;
   private int count;
   private double totalCost;
   Sorting sorter = new Sorting();

   //-----------------------------------------------------------------
   //  Constructor: Creates an initially empty collection.
   //-----------------------------------------------------------------
   public DVDCollection ()
   {
      collection = new DVD[100];
      unsortedCollection = new DVD[100];
      count = 0;
      totalCost = 0.0;
   }

   /**
    * addDVD() allows a new DVD to be added to the collection
    * 
    * @param title, director, year, cost, bluRay
    * @return none
    */
   public void addDVD (String title, String director, int year,
      double cost, boolean bluRay)
   {
      collection[count] = new DVD (title, director, year, cost, bluRay);
      unsortedCollection[count] = new DVD (title, director, year, cost, bluRay);
      totalCost += cost;
      count++;
      
      // Sort the collection with the addition of the latest title.
      sorter.insertionSort(collection, count);
   }

   //-----------------------------------------------------------------
   //  Returns a report describing the DVD collection.
   //-----------------------------------------------------------------
   public String toString()
   {
      String report = "";

      for (int dvd = 0; dvd < count; dvd++)
          report += collection[dvd].toString() + "\n";

      return report;
   }
   
   /**
    * toString2() is a duplicated toString() that makes a report for the unsorted collection (needed for showing the user in Movies class).
    * 
    * @param none
    * @return none
    */
   public String toString2() {
       String report2 = "";
       
       for (int dvd = 0; dvd < count; dvd++) 
           report2 += unsortedCollection[dvd].toString() + "\n";
           
       return report2;
   }
   
   /**
    * getCount() returns the number of DVD's added for use in Sorting class.
    * 
    * @param none
    * @return count
    */
   public int getCount() {
       return count;
   }
}
