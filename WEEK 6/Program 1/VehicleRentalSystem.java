import java.util.Scanner;

class Vehicle {
    String vehicleNumber;
    String brand;
    int speed;

    public Vehicle(String vehicleNumber, String brand, int speed) {
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
        this.speed = speed;
    }

    public void displayDetails() {
        System.out.println("Vehicle No: " + vehicleNumber + " | Brand: " + brand + " | Speed: " + speed + " km/h");
    }
}

class Car extends Vehicle {
    int numberOfDoors;

    public Car(String vehicleNumber, String brand, int speed, int numberOfDoors) {
        super(vehicleNumber, brand, speed);
        this.numberOfDoors = numberOfDoors;
    }

    public void displayDetails() {
        System.out.println("Car No: " + vehicleNumber + " | Brand: " + brand +
                           " | Speed: " + speed + " km/h | Doors: " + numberOfDoors);
    }
}

class Bike extends Vehicle {
    int hasGear;

    public Bike(String vehicleNumber, String brand, int speed, int hasGear) {
        super(vehicleNumber, brand, speed);
        this.hasGear = hasGear;
    }

    public void displayDetails() {
        String gearStatus; 
        if (hasGear == 1) {
            gearStatus = "Yes";
        } else {
            gearStatus = "No";
        }
        System.out.println("Bike No: " + vehicleNumber + " | Brand: " + brand +
                           " | Speed: " + speed + " km/h | Has Gear: " + gearStatus);
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Car Vehicle Number: ");
        String carNumber = scanner.nextLine();
        
        System.out.print("Enter Car Brand: ");
        String carBrand = scanner.nextLine();
        
        System.out.print("Enter Car Speed: ");
        int carSpeed = scanner.nextInt();
        
        System.out.print("Enter Number of Doors: ");
        int carDoors = scanner.nextInt();

        scanner.nextLine(); 

        System.out.print("\nEnter Bike Vehicle Number: ");
        String bikeNumber = scanner.nextLine();
        
        System.out.print("Enter Bike Brand: ");
        String bikeBrand = scanner.nextLine();
        
        System.out.print("Enter Bike Speed: ");
        int bikeSpeed = scanner.nextInt();
        
        System.out.print("Does Bike have gear (1/0): ");
        int bikeGear = scanner.nextInt();

        Vehicle myCar = new Car(carNumber, carBrand, carSpeed, carDoors);
        Vehicle myBike = new Bike(bikeNumber, bikeBrand, bikeSpeed, bikeGear);

        System.out.println("\n--- Rental Vehicle Details ---");
        myCar.displayDetails();
        myBike.displayDetails();

        scanner.close();
    }
}
