/** 
 * Integrity Policy Statement  
 * My words and actions will reflect Academic Integrity. 
 * I will not cheat or lie or steal in academic matters. 
 * I will promote integrity in the UNCG community.
 * Austin Gain 03/29/2022 
 */

/*
GainAHW5
Austin Gain
CSC 230, Sec 3
*/

package gainahw5;

/* import statements */
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.IllegalFormatException;
import java.util.Scanner;

/**
 * Notes:
 * Added isTriangleValid() method to Triangle class; area would return NaN if triangle was not checked
 * IOException not needed for Printwriter, only FileNotFoundException
 * The user input is in the setter methods in the Triangle class
 * do-while loop added for convenience
 * Program information is in a method to clean up main method
 */

public class main {

    /* Prints the program information */
    public static void printInfo() {
        System.out.println("GainAHW5\n" + 
                            "Austin Gain\n" + 
                            "CSC 230, Sec 3\n\n" + 
                            "This program consists of three classes, a main class, the GeometricObject class, and a Triangle class.\n" +
                            "The Triangle class extends from the GeometricObject class.\n" +
                            "The user will be asked to enter the 3 sides and the color of the triangle.\n" +
                            "The user will also be asked to enter if the triangle is filled or not by entering a true if it is filled and a false if it not filled\n" +
                            "The results will be printed to the screen and to a file called triangleOut.txt\n" +
                            "When the program is run again, the new data will be appended to the old data in the file.\n");
    }

    /* Main method, Exceptions are thrown accordingly */
    public static void main(String[] args) throws FileNotFoundException, IllegalFormatException, NullPointerException {
        Scanner keyboard = new Scanner(System.in);

        /* Prints program information */
        printInfo();
        

        /* Creates a triangle object */
        Triangle triangle = new Triangle(); // no arg constructor used since user is inputting data


        /* do-while loop for added convenience */
        char choice = ' ';
        do {
            /* Sets sides, color, and filled status of triangle */
            triangle.setSide1();
            triangle.setSide2();
            triangle.setSide3();

            while (!triangle.isTriangleValid()) { // if triangle is invalid, then user must input new side values
                System.out.println("Triangle is invalid, please enter new values");
                triangle.setSide1();                                                                        
                triangle.setSide2();
                triangle.setSide3();
            }

            triangle.setColor();
            triangle.setFilled();

            
            /* Prints information to the screen */
            System.out.printf("\nThe color is %s\n", triangle.getColor());
            if (triangle.isFilled()) { // checks to see if "filled" is set to true or false, then prints accordingly
                System.out.println("The triangle is filled");
            }
            else {
                System.out.println("The triangle is not filled");
            }
            System.out.printf("The area is %.3f\n", triangle.getArea());
            System.out.printf("The perimeter is %.3f\n", triangle.getPerimeter());
            System.out.printf("%s\n", triangle.toString());


            /* Outputs data to txt file */
            PrintWriter writer = new PrintWriter(new FileOutputStream("triangleOut.txt", true)); // printwriter object created, txt filed created if necessary        
            writer.printf("\nThe color is %s\n", triangle.getColor());
            if (triangle.isFilled()) { // checks to see if "filled" is set to true or false, then prints accordingly
                writer.println("The triangle is filled");
            }
            else {
                writer.println("The triangle is not filled");
            }
            writer.printf("The area is %.3f\n", triangle.getArea());
            writer.printf("The perimeter is %.3f\n", triangle.getPerimeter());
            writer.printf("%s\n", triangle.toString());
            writer.close(); // close file


            /* loop check to run the program again */
            System.out.print("\nWould you like to run the program again? (Y/N): ");
            choice = keyboard.next().charAt(0);

        } while (choice == 'Y' || choice == 'y');


        /* End of program */
        System.out.println("\nThank you for using my program!\n" + 
                            "Please check txt file for data.");
        keyboard.close(); // close scanner
    }
}