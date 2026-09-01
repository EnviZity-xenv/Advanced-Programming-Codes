import java.util.Scanner;

class Student {
    public String name;
    public int id;
    public String branch;

    public Student(String name, int id, String branch) {
        this.name = name;
        this.id = id;
        this.branch = branch;
    }

    public void displayStudent() {
        System.out.println("Student Name: " + name);
        System.out.println("Student ID: " + id);
        System.out.println("Branch: " + branch);
    }
}

class Course {
    public String courseName;
    public String courseCode;
    public int credits;

    public Course(String courseName, String courseCode, int credits) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credits = credits;
    }

    public void displayCourse() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Code: " + courseCode);
        System.out.println("Credits: " + credits);
    }
}

public class ClgManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();
        
        scanner.nextLine(); 

        System.out.print("Enter Branch: ");
        String studentBranch = scanner.nextLine();

        System.out.print("\nEnter Course Name: ");
        String courseName = scanner.nextLine();

        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();

        System.out.print("Enter Credits: ");
        int courseCredits = scanner.nextInt();

        Student student1 = new Student(studentName, studentId, studentBranch);
        Course course1 = new Course(courseName, courseCode, courseCredits);

        System.out.println("\n--- Student Details ---");
        student1.displayStudent();
        
        System.out.println("\n--- Course Details ---");
        course1.displayCourse();

        scanner.close();
    }
}