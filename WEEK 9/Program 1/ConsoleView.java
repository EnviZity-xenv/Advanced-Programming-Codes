import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner = new Scanner(System.in);
    public String getStudentName() {
        System.out.print("Enter Student Name: ");
        return scanner.nextLine();
    }

    public double getSubjectMark(int subjectNumber) {
        System.out.print("Enter Subject " + subjectNumber + " Marks: ");
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a number for Subject " + subjectNumber + ": ");
            scanner.next(); 
        }
        double mark = scanner.nextDouble();
        scanner.nextLine(); 
        return mark;
    }


    public void printResults(String name, double total, double avg, String grade) {
        System.out.println("\n=========================");
        System.out.println("     STUDENT RESULTS     ");
        System.out.println("=========================");
        System.out.println("Name:    " + name);
        System.out.printf("Total:   %.2f\n", total);
        System.out.printf("Average: %.2f\n", avg);
        System.out.println("Grade:   " + grade);
        System.out.println("=========================");
    }
}