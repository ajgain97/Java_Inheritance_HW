package gainahw5;

import java.util.Scanner;

public class Triangle extends GeometricObject {
    Scanner keyboard = new Scanner(System.in);

    /* data fields */
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;
    private boolean valid;

    /* create a default constructor */
    public Triangle() {}

    /* create a constructor for the sides of the triangle */
    public Triangle(double side1, double side2, double side3, boolean valid, String color, boolean filled) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.valid = valid;
        setColor();
        setFilled();
    }

    /* return side1 */
    public double getSide1() {
        return side1;
    }

    /* set a new side1 */
    public void setSide1() {
        System.out.print("Enter the 1st of three sides: ");
        side1 = keyboard.nextDouble();
    }

    /* return side2 */
    public double getSide2() {
        return side2;
    }

    /* set a new side2 */
    public void setSide2() {
        System.out.print("Enter the 2nd of three sides: ");
        side2 = keyboard.nextDouble();
    }

    /* return side3 */
    public double getSide3() {
        return side3;
    }

    /* set a new side3 */
    public void setSide3() {
        System.out.print("Enter the 3rd of three sides: ");
        side3 = keyboard.nextDouble();
    }

    /* checks to see if triangle is valid */
    public boolean isTriangleValid() {
        if ((side1 + side2) > side3 && (side1 + side3) > side2 && (side2 + side3) > side1) {
            valid = true;
        }
        else {
            valid = false;
        }
        return valid;
    }

    /* returns a string to display the sides of the Triangle 
        date used because it did not seem right to leave it out */
    @Override
    public String toString() {
        return "Triangle: side1 = " + side1 + ", side2 = " + side2 + ", side3 = " + side3 + "\n" + getDateCreated();
    }

    /* use the abstract getArea method from GeometricObject */
    @Override
    public double getArea() {
        // area of triangle calculated using Heron's Formula
        double semiPerimeter = (side1 + side2 + side3) / 2;
        double area = Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
        return area;
    }

    /* use the abstract getPerimeter method from GeometricObject */
    @Override
    public double getPerimeter() {
        double perimeter = side1 + side2 + side3;
        return perimeter;
    }
}