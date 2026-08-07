import java.util.Scanner;

public class Employee {
    int empId;
    String name;
    double salary;
    public Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }
    public void display() {
        System.out.println("Employee ID : " + empId);
        System.out.println("Employee Name : " + name);
        System.out.println("Salary : " + (int) salary);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Employee ID : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Employee Name : ");
        String name = scanner.nextLine();
        System.out.print("Salary : ");
        double salary = scanner.nextDouble();
        Employee emp = new Employee(id, name, salary);
        emp.display();
        scanner.close();
    }
}