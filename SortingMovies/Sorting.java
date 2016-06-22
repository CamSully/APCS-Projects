//********************************************************************
//  Sorting.java       Author: Lewis/Loftus
//
//  Demonstrates the selection sort and insertion sort algorithms.
//********************************************************************

public class Sorting
{
   /**
    * insertionSort() uses the insertion sorting algorithm to sort films by alphabetical title order.
    * 
    * @param dvdCollection the collection to be sorted
    * @param length the number of DVDs in the collection
    * @return none
    */
   public void insertionSort (Comparable[] dvdCollection, int length)
   {
      for (int index = 0; index < length; index++)
      {
         // Reference a specific DVD object.
         Comparable dvd = dvdCollection[index];
         int position = index;
         
         // If there is only a single object in the list, don't sort it.
         if (length == 1) {
             break;
         }
         
         //  Shift larger values to the right
         while (position > 0 && dvd.compareTo(dvdCollection[position-1]) < 0)
         {
            // Put higher alphabetical DVD at the high position.
            dvdCollection[position] = dvdCollection[position-1];
            position--;
         }
         
         // Put the lower alphabetical DVD in the low position (complete the swap).
         dvdCollection[position] = dvd;
      }
   }
}
