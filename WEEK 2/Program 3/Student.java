import java.util.Scanner;

public class Student {
    String name;
    int rollNumber;
    public void display() {
        System.out.println("\n--- Student Details ---");
        System.out.println("Name       : " + name);
        System.out.println("Roll Number: " + rollNumber);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Student student1 = new Student();
        System.out.print("Enter Student Name: ");
        student1.name = input.nextLine();
        System.out.print("Enter Roll Number: ");
        student1.rollNumber = Integer.parseInt(input.nextLine());
        student1.display();
        input.close();
    }
}