import java.util.Scanner;

public class Student {
    // Attributes
    String name;
    int rollNumber;
    String department;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student student1 = new Student();
        System.out.print("Enter Student Name: ");
        student1.name = scanner.nextLine();
        System.out.print("Enter Roll Number: ");
        student1.rollNumber = scanner.nextInt();
        System.out.print("Enter Department: ");
        student1.department = scanner.next();
        System.out.println("\n--- Student Details ---");
        System.out.println("Name        : " + student1.name);
        System.out.println("Roll Number : " + student1.rollNumber);
        System.out.println("Department  : " + student1.department);
        scanner.close();
    }
}