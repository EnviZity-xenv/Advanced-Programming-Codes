public class Employee {
    String name;
    int employeeId;
    double basicSalary;

    Employee(String name, int employeeId, double basicSalary) {
        this.name = name;
        this.employeeId = employeeId;
        this.basicSalary = basicSalary;
    }

    double calculateSalary() {
        return basicSalary;
    }

    public static void main(String[] args) {
        System.out.println("--- Employee Payroll System ---");

        Employee e1 = new Professor("Arun", 101, 50000);
        Employee e2 = new LabAssistant("Priya", 102, 30000);
        Employee e3 = new AdministrativeStaff("Ravi", 103, 25000);

        System.out.println("\n--- Salary Details ---");
        
        System.out.println("Role: Professor");
        System.out.println("Name: " + e1.name + " | ID: " + e1.employeeId);
        System.out.println("Total Salary: " + e1.calculateSalary());
        System.out.println("---------------------------------");

        System.out.println("Role: Lab Assistant");
        System.out.println("Name: " + e2.name + " | ID: " + e2.employeeId);
        System.out.println("Total Salary: " + e2.calculateSalary());
        System.out.println("---------------------------------");

        System.out.println("Role: Administrative Staff");
        System.out.println("Name: " + e3.name + " | ID: " + e3.employeeId);
        System.out.println("Total Salary: " + e3.calculateSalary());
        System.out.println("---------------------------------");
    }
}

class Professor extends Employee {
    Professor(String name, int employeeId, double basicSalary) {
        super(name, employeeId, basicSalary);
    }

    double calculateSalary() {
        return basicSalary + 10000;
    }
}

class LabAssistant extends Employee {
    LabAssistant(String name, int employeeId, double basicSalary) {
        super(name, employeeId, basicSalary);
    }

    double calculateSalary() {
        return basicSalary + 5000;
    }
}

class AdministrativeStaff extends Employee {
    AdministrativeStaff(String name, int employeeId, double basicSalary) {
        super(name, employeeId, basicSalary);
    }

    double calculateSalary() {
        return basicSalary + 3000;
    }
}
