/* 
 * CS 282 Intermediate Java Spring 2025
 * Cuyamaca College
 * Muhsin Abdirahman
 * Lab 2 - OOP
The code defines a Polygon interface with area() and perimeter() methods and implements various polygon classes, including triangles, quadrilaterals, and regular polygons.
It also provides a user interface for creating polygons, inputting dimensions, and displaying their area and perimeter, with an additional feature to check polygon similarity.
 */

import java.util.*;

// Polygon interface
interface Polygon {
    double area();
    double perimeter();
}

// Triangle class
class Triangle implements Polygon {
    double a, b, c;

    Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }

    @Override
    public double area() {
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}

// IsoscelesTriangle class
class IsoscelesTriangle extends Triangle {
    IsoscelesTriangle(double base, double side) {
        super(base, side, side);
    }
}

// EquilateralTriangle class
class EquilateralTriangle extends Triangle {
    EquilateralTriangle(double side) {
        super(side, side, side);
    }
}

// Quadrilateral class
class Quadrilateral implements Polygon {
    double a, b, c, d;

    Quadrilateral(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double perimeter() {
        return a + b + c + d;
    }

    @Override
    public double area() {
        return 0; // Placeholder: Can be implemented based on specific quadrilateral types
    }
}

// Rectangle class
class Rectangle extends Quadrilateral {
    double width, height;

    Rectangle(double width, double height) {
        super(width, height, width, height);
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

// Square class
class Square extends Rectangle {
    Square(double side) {
        super(side, side);
    }
}

// Regular Polygon class (for Pentagon, Hexagon, Octagon)
class RegularPolygon implements Polygon {
    int sides;
    double sideLength;

    RegularPolygon(int sides, double sideLength) {
        this.sides = sides;
        this.sideLength = sideLength;
    }

    @Override
    public double perimeter() {
        return sides * sideLength;
    }

    @Override
    public double area() {
        return (sides * Math.pow(sideLength, 2)) / (4 * Math.tan(Math.PI / sides));
    }
}

// Polygon similarity check
class PolygonUtil {
    static boolean areSimilar(List<Double> sides1, List<Double> sides2) {
        if (sides1.size() != sides2.size()) return false;
        Collections.sort(sides1);
        Collections.sort(sides2);
        double ratio = sides1.get(0) / sides2.get(0);
        for (int i = 1; i < sides1.size(); i++) {
            if (Math.abs((sides1.get(i) / sides2.get(i)) - ratio) > 1e-6) return false;
        }
        return true;
    }
}

// User Interface
public class PolygonApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a polygon: 1) Triangle 2) Rectangle 3) Square 4) Pentagon 5) Hexagon 6) Octagon");
        int choice = scanner.nextInt();

        Polygon polygon = null;

        switch (choice) {
            case 1:
                System.out.println("Enter three sides of the triangle:");
                polygon = new Triangle(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
                break;
            case 2:
                System.out.println("Enter width and height of the rectangle:");
                polygon = new Rectangle(scanner.nextDouble(), scanner.nextDouble());
                break;
            case 3:
                System.out.println("Enter side length of the square:");
                polygon = new Square(scanner.nextDouble());
                break;
            case 4:
                System.out.println("Enter side length of the pentagon:");
                polygon = new RegularPolygon(5, scanner.nextDouble());
                break;
            case 5:
                System.out.println("Enter side length of the hexagon:");
                polygon = new RegularPolygon(6, scanner.nextDouble());
                break;
            case 6:
                System.out.println("Enter side length of the octagon:");
                polygon = new RegularPolygon(8, scanner.nextDouble());
                break;
            default:
                System.out.println("Invalid choice!");
        }

        if (polygon != null) {
            System.out.println("Area: " + polygon.area());
            System.out.println("Perimeter: " + polygon.perimeter());
        }

        scanner.close();
    }
}

