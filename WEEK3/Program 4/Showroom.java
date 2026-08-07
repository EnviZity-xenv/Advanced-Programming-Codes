import java.util.Scanner;

class Car {
    String model;
    double price;

    public Car() {
        this.model = "Honda Civic";
        this.price = 750000.0;
    }

    public Car(String model) {
        this.model = model;
        this.price = 6700000.0;
    }

    public Car(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("\n--- Car Registration Summary ---");
        System.out.println("Model : " + this.model);
        if (this.price > 0) {
            System.out.println("Price : ₹" + (int) this.price);
        } else {
            System.out.println("Price : Not Specified");
        }
    }
}

public class Showroom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Welcome to the Car Showroom Registration ===");
        System.out.println("1. Register without entering any details");
        System.out.println("2. Register by entering only the Model Name");
        System.out.println("3. Register by entering both Model Name and Price");
        System.out.print("Choose your registration option (1-3): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        Car userCar; 
        switch (choice) {
            case 1:
                userCar = new Car();
                break;

            case 2:
                System.out.print("Enter Car Model Name: ");
                String modelOnly = scanner.nextLine();
                userCar = new Car(modelOnly);
                break;

            case 3:
                System.out.print("Enter Car Model Name: ");
                String model = scanner.nextLine();
                System.out.print("Enter Car Price: ");
                double price = scanner.nextDouble();
                scanner.nextLine();
                userCar = new Car(model, price);
                break;

            default:
                System.out.println("Invalid choice! Defaulting to no-detail registration.");
                userCar = new Car();
                break;
        }
        userCar.displayDetails();
        scanner.close();
    }
}