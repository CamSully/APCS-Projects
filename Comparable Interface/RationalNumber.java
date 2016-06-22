// ORIGINAL DOCUMENTATION

//********************************************************************
//  RationalNumber.java       Author: Lewis/Loftus
//
//  Represents one rational number with a numerator and denominator.
//********************************************************************

// EDITION 2 DOCUMENTATION
/**
 * RationalNumber is a class that allows rational numbers to be created, viewed, and manipulated.
 * Note that Sullivan's contributions are mainly the inclusion of the comparable interface, and the addition of the compareTo() method.
 * 
 * @author: Cameron Sullivan
 * @version: 2015.12.17
 */
public class RationalNumber implements Comparable
{
   // Initialize some values.
   private int numerator, denominator;
   public float rawNum;
   //-----------------------------------------------------------------
   //  Constructor: Sets up the rational number by ensuring a nonzero
   //  denominator and making only the numerator signed.
   //-----------------------------------------------------------------
   public RationalNumber (int numer, int denom)
   {
      if (denom == 0)
         denom = 1;

      // Make the numerator "store" the sign
      if (denom < 0)
      {
         numer = numer * -1;
         denom = denom * -1;
      }

      numerator = numer;
      denominator = denom;
      
      // Create versions of the numerator and denominator in float form.
      float numF = numerator;
      float denomF = denominator;
      // Divide the two floats to obtain the raw number.
      rawNum = numF / denomF;

   }
   /*
    * compareTo() takes an object as a parameter and compares it to the current object.
    * Specifically, the raw number of each object are compared, and either a -1,0, or 1 is returned based on the result.
    * 
    * @param object2    Select an object to be compared with the current object.
    * @return compareValue    Return the value of comparing two raw numbers from the two objects.
    */
   public int compareTo (Object object2) {
       // convert ojbect2 from "object type" to "RationalNumber" type.
       RationalNumber testObj = (RationalNumber) object2;
       int compareValue;
       String compareString;
       
       // If the rational numbers are within .0001 of each other...
       if (rawNum - testObj.rawNum <= 0.0001 && rawNum - testObj.rawNum >= -0.0001) {
           // They are considered equal (represented by 0).
           compareValue = 0;
           compareString = this.toString() + " = " + testObj.toString();
       }
       // If the first rational number is greater than the second number by more than .0001...
       else if (rawNum - testObj.rawNum > .0001) {
           // First rational number is considered greater (represented by positive 1).
           compareValue = 1;
           compareString = this.toString() + " > " + testObj.toString();
       }
       // If the first rational number is less than the first by more than .0001...
       else {
           // First rational number is considered less (represented by negative 1).
           compareValue = -1;
           compareString = this.toString() + " < " + testObj.toString();
        }
       
       // Print the value of the comparison for user understanding.
       System.out.println(compareValue + "     " + compareString);
       return compareValue;
   }
   
   //-----------------------------------------------------------------
   //  Returns the numerator of this rational number.
   //-----------------------------------------------------------------
   public int getNumerator ()
   {
      return numerator;
   }

   //-----------------------------------------------------------------
   //  Returns the denominator of this rational number.
   //-----------------------------------------------------------------
   public int getDenominator ()
   {
      return denominator;
   }

   //-----------------------------------------------------------------
   //  Returns the reciprocal of this rational number.
   //-----------------------------------------------------------------
   public RationalNumber reciprocal ()
   {
      return new RationalNumber (denominator, numerator);
   }

   //-----------------------------------------------------------------
   //  Adds this rational number to the one passed as a parameter.
   //  A common denominator is found by multiplying the individual
   //  denominators.
   //-----------------------------------------------------------------
   public RationalNumber add (RationalNumber op2)
   {
      int commonDenominator = denominator * op2.getDenominator();
      int numerator1 = numerator * op2.getDenominator();
      int numerator2 = op2.getNumerator() * denominator;
      int sum = numerator1 + numerator2;

      return new RationalNumber (sum, commonDenominator);
   }

   //-----------------------------------------------------------------
   //  Subtracts the rational number passed as a parameter from this
   //  rational number.
   //-----------------------------------------------------------------
   public RationalNumber subtract (RationalNumber op2)
   {
      int commonDenominator = denominator * op2.getDenominator();
      int numerator1 = numerator * op2.getDenominator();
      int numerator2 = op2.getNumerator() * denominator;
      int difference = numerator1 - numerator2;

      return new RationalNumber (difference, commonDenominator);
   }

   //-----------------------------------------------------------------
   //  Multiplies this rational number by the one passed as a
   //  parameter.
   //-----------------------------------------------------------------
   public RationalNumber multiply (RationalNumber op2)
   {
      int numer = numerator * op2.getNumerator();
      int denom = denominator * op2.getDenominator();

      return new RationalNumber (numer, denom);
   }

   //-----------------------------------------------------------------
   //  Divides this rational number by the one passed as a parameter
   //  by multiplying by the reciprocal of the second rational.
   //-----------------------------------------------------------------
   public RationalNumber divide (RationalNumber op2)
   {
      return multiply (op2.reciprocal());
   }

   //-----------------------------------------------------------------
   //  Determines if this rational number is equal to the one passed
   //  as a parameter. Assumes they are both reduced.
   //-----------------------------------------------------------------
   public boolean isLike (RationalNumber op2)
   {
      return ( numerator == op2.getNumerator() &&
               denominator == op2.getDenominator() );
   }

   //-----------------------------------------------------------------
   //  Returns this rational number as a string.
   //-----------------------------------------------------------------
   public String toString ()
   {
      String result;
      if (numerator == 0)
         result = "0";
      else
         if (denominator == 1)
            result = numerator + "";
         else
            result = numerator + "/" + denominator;
      return result;
   }

   //-----------------------------------------------------------------
   //  Reduces this rational number by dividing both the numerator
   //  and the denominator by their greatest common divisor.
   //-----------------------------------------------------------------
   private void reduce ()
   {
      if (numerator != 0)
      {
         int common = gcd (Math.abs(numerator), denominator);

         numerator = numerator / common;
         denominator = denominator / common;
      }
   }

   //-----------------------------------------------------------------
   //  Computes and returns the greatest common divisor of the two
   //  positive parameters. Uses Euclid's algorithm.
   //-----------------------------------------------------------------
   private int gcd (int num1, int num2)
   {
      while (num1 != num2)
         if (num1 > num2)
            num1 = num1 - num2;
         else
            num2 = num2 - num1;

      return num1;
   }
}
