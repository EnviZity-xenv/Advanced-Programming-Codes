import java.util.Scanner;

public class Area {
    double length;
    double breadth;
    public void calculateAndDisplayArea() {
        double area = length * breadth;
        System.out.println("\n--- Room Area Estimation ---");
        System.out.println("Length    : " + length + " meters");
        System.out.println("Breadth   : " + breadth + " meters");
        System.out.println("Floor Area: " + area + " sq meters");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Area room = new Area();
        System.out.print("Enter room length: ");
        room.length = scanner.nextDouble();
        System.out.print("Enter room breadth: ");
        room.breadth = scanner.nextDouble();
        room.calculateAndDisplayArea();
        scanner.close();
    }
}