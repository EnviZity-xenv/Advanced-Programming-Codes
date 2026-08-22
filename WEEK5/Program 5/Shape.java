import java.util.Scanner;

public class Shape {

    double calculateArea() {
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Shape Area Calculator ---");
        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        System.out.println("3. Triangle");
        System.out.print("Enter your choice (1, 2, or 3): ");
        int choice = sc.nextInt();

        Shape shape;

        if (choice == 1) {
            System.out.print("Enter the radius of the circle: ");
            double radius = sc.nextDouble();
            shape = new Circle(radius);
        } else if (choice == 2) {
            System.out.print("Enter the length of the rectangle: ");
            double length = sc.nextDouble();
            System.out.print("Enter the width of the rectangle: ");
            double width = sc.nextDouble();
            shape = new Rectangle(length, width);
        } else {
            System.out.print("Enter the base of the triangle: ");
            double base = sc.nextDouble();
            System.out.print("Enter the height of the triangle: ");
            double height = sc.nextDouble();
            shape = new Triangle(base, height);
        }

        System.out.println("\n--- Calculation Result ---");
        System.out.println("Area: " + shape.calculateArea());
        
        sc.close();
    }
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double length;
    double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double calculateArea() {
        return length * width;
    }
}

class Triangle extends Shape {
    double base;
    double height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    double calculateArea() {
        return 0.5 * base * height;
    }
}