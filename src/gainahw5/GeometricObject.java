package gainahw5;

import java.util.Date;
import java.util.Scanner;

public abstract class GeometricObject {
    Scanner keyboard = new Scanner(System.in);

    /* data fields */
    private String color = "white";
    private boolean filled;
    private Date dateCreated;

    /* Construct a default geometric object */
    protected GeometricObject() {
        dateCreated = new Date();
    }

    /* Construct a geometric object with color and filled value */
    protected GeometricObject(String color, boolean filled) {
        dateCreated = new Date();
        this.color = color;
        this.filled = filled;
    }

    /* return color */
    public String getColor() {
        return color;
    }

    /* set a new color */
    public void setColor() {
        System.out.print("Enter the color: ");
        color = keyboard.next();
    }

    /* return filled since filled is boolean, the get method is named isFilled */
    public boolean isFilled() {
        return filled;
    }

    /* set a new filled */
    public void setFilled() {
        System.out.print("Enter a Boolean value for filled (true or false): ");
        filled = keyboard.nextBoolean();
    }

    /* get dateCreated */
    public Date getDateCreated() {
        return dateCreated;
    }

    /* converts date to string */
    @Override
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
    }

    /* abstract method getArea */
    public abstract double getArea();

    /* abstract method getPerimeter */
    public abstract double getPerimeter();
}