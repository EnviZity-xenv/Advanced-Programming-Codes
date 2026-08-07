import java.util.Scanner;

class AreaCalculator {

    // 1. Overloaded method to calculate Area of a Square (1 parameter: side length)
    public double calculateArea(double side) {
        return side * side;
    }

    // 2. Overloaded method to calculate Area of a Rectangle (2 parameters: length and width)
    public double calculateArea(double length, double width) {
        return length * width;
    }

    // 3. Overloaded method to calculate Area of a Circle (1 parameter: radius, float type to differentiate signature)
    public double calculateArea(float radius) {
        return Math.PI * radius * radius;
    }
}

public class Geometry{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AreaCalculator calculator = new AreaCalculator();

        System.out.println("=== Geometry Area Calculator ===");
        System.out.println("1. Calculate Area of Square");
        System.out.println("2. Calculate Area of Rectangle");
        System.out.println("3. Calculate Area of Circle");
        System.out.print("Choose an option (1-3): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter side length of square: ");
                double side = scanner.nextDouble();
                // Calls calculateArea(double)
                double squareArea = calculator.calculateArea(side);
                System.out.println("Area of Square = " + squareArea);
                break;

            case 2:
                System.out.print("Enter length of rectangle: ");
                double length = scanner.nextDouble();
                System.out.print("Enter width of rectangle: ");
                double width = scanner.nextDouble();
                // Calls calculateArea(double, double)
                double rectangleArea = calculator.calculateArea(length, width);
                System.out.println("Area of Rectangle = " + rectangleArea);
                break;

            case 3:
                System.out.print("Enter radius of circle: ");
                float radius = scanner.nextFloat();
                double circleArea = calculator.calculateArea(radius);
                System.out.printf("Area of Circle = %.2f\n", circleArea);
                break;

            default:
                System.out.println("Invalid option selected!");
                break;
        }
        scanner.close();
    }
}