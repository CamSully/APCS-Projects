import java.util.*;

// ORIGINAL DOCUMENTATION
//********************************************************************
//  Movies.java       Author: Lewis/Loftus
//
//  Demonstrates the use of an array of objects.
//********************************************************************

// EDITION 2 DOCUMENTATION
/**
 * Movies is a tester class that shows the user a movie collection, then lets the user make their own.
 * 
 * @author Cameron Sullivan
 * @version 2016.2.15
 */
public class Movies
{
   public static void main (String[] args) throws Exception
   {
      // Initialize variables.
      boolean userDone = false;
      String title;
      String director;
      int year;
      double cost;
      String bluRayInput;
      boolean bluRay;
      
      // Create two collections.
      DVDCollection movies = new DVDCollection();
      DVDCollection clientMovies = new DVDCollection();
      
      // Introduce user.
      System.out.println("Welcome to the movie collection sorting algorithm.");
      Thread.sleep(1000);
      System.out.println("This program simulates a collection of movies that is sorted in alphabetical order.");
      Thread.sleep(1000);
      System.out.println("To demonstrate to you how this program works, an example is in order.");
      Thread.sleep(1000);
      System.out.println("Seven movies will now be added.");
      Thread.sleep(1000);
      System.out.println("Each time a movie is added, the list will be printed.");
      Thread.sleep(1000);
      System.out.println("Then the list will be sorted and printed again.\n");
      
      Thread.sleep(1000);
      
      System.out.println("____________________________________________________________________________\n");
      
      // Add the first film.
      movies.addDVD ("The Godfather", "Francis Ford Coppala", 1972, 24.95, true);
      System.out.println("Movie 1 has been added.");
      // Print the unsorted list.
      System.out.println("Unsorted list: \n");
      System.out.println(movies.toString2());
      // Print the sorted list.
      System.out.println("Sorted list: \n");
      System.out.println(movies);
      
      Thread.sleep(2000);
      
      System.out.println("____________________________________________________________________________\n");
      
      // Add the second film.
      movies.addDVD ("District 9", "Neill Blomkamp", 2009, 19.95, false);
      System.out.println("Movie 2 has been added.");
      System.out.println("Unsorted list: \n");
      System.out.println(movies.toString2());
      System.out.println("Sorted list: \n");
      System.out.println(movies);
      
      Thread.sleep(2000);
      
      System.out.println("____________________________________________________________________________\n");
      
      // Add the third film.
      movies.addDVD ("Iron Man", "Jon Favreau", 2008, 15.95, false);
      System.out.println("Movie 3 has been added.");
      System.out.println("Unsorted list: \n");
      System.out.println(movies.toString2());
      System.out.println("Sorted list: \n");
      System.out.println(movies);
      
      Thread.sleep(2000);
      
      System.out.println("____________________________________________________________________________\n");
      
      // Add the fourth film.
      movies.addDVD ("All About Eve", "Joseph Mankiewicz", 1950, 17.50, false);
      System.out.println("Movie 4 has been added.");
      System.out.println("Unsorted list: \n");
      System.out.println(movies.toString2());
      System.out.println("Sorted list: \n");
      System.out.println(movies);
      
      Thread.sleep(2000);
      
      System.out.println("____________________________________________________________________________\n");
      
      // Add the fifth film.
      movies.addDVD ("The Matrix", "Andy & Lana Wachowski", 1999, 19.95, true);
      System.out.println("Movie 5 has been added.");
      System.out.println("Unsorted list: \n");
      System.out.println(movies.toString2());
      System.out.println("Sorted list: \n");
      System.out.println(movies);
      
      Thread.sleep(2000);
      
      System.out.println("____________________________________________________________________________\n");
      
      // Add the sixth film.
      movies.addDVD ("Iron Man 2", "Jon Favreau", 2010, 22.99, false);
      System.out.println("Movie 6 has been added.");
      System.out.println("Unsorted list: \n");
      System.out.println(movies.toString2());
      System.out.println("Sorted list: \n");
      System.out.println(movies);
      
      Thread.sleep(2000);
      
      System.out.println("____________________________________________________________________________\n");
      
      // Add the seventh film.
      movies.addDVD ("Casablanca", "Michael Curtiz", 1942, 19.95, false);
      System.out.println("Movie 7 has been added.");
      System.out.println("Unsorted list: \n");
      System.out.println(movies.toString2());
      System.out.println("Sorted list: \n");
      System.out.println(movies);
      
      Thread.sleep(2000);
      
      System.out.println("____________________________________________________________________________\n");
      
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
      
      // Introduce user the interactive part.
      System.out.println("Now that you know how the program works, you will be allowed to create your own collection of movies.");
      System.out.println("Your movies will be sorted each time you add one, and will be printed for you to view.");
      
      int count = 0;
      // Loop: user adds movies to their collection.
      while (!userDone) {
          // Take user input.
          Scanner scanner = new Scanner(System.in);
          System.out.println("Enter a movie title.");
          title = scanner.nextLine();
          System.out.println("Enter the director of the movie.");
          director = scanner.nextLine();
          System.out.println("Enter the year of the movie's production.");
          year = scanner.nextInt();
          System.out.println("Enter the cost of purchasing the movie.");
          cost = scanner.nextDouble();
          System.out.println("Enter 'yes' if the movie is bluRay, or 'no' if the movie is non-bluRay.");
          bluRayInput = scanner.next();
          if (bluRayInput.toLowerCase().equals("yes")) {
              bluRay = true;
          }
          else {
              bluRay = false;
          }
          
          // Create a movie with the user's inputs.
          clientMovies.addDVD(title, director, year, cost, bluRay);
          
          // Show that the movie is being added.
          System.out.print("Adding movie to your collection");
          Thread.sleep(600);
          System.out.print(".");
          Thread.sleep(600);
          System.out.print(".");
          Thread.sleep(600);
          System.out.println(".");
          Thread.sleep(500);
          System.out.println("Your movie has been added.");
          Thread.sleep(500);
          // Print the sorted collection.
          System.out.println("Your sorted collection:\n");
          
          System.out.println(clientMovies + "\n");
          
          // Allow user to quit or continue.
          System.out.println("To quit, press 'q'. To continue, press any other key.");
          if (scanner.next().equals("q")) {
              userDone = true;
          }
      }
      System.out.println("Thank you!");
   }
}
