import course.Course;
import student.Student;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(1001, "Aarav", "Computer Science");
        Student student2 = new Student(1002, "Priya", "Information Technology");

        Course course1 = new Course("CS203", "Advanced Programming Practice", 4);
        Course course2 = new Course("IT105", "Database Management Systems", 3);

        System.out.println("College Management System");

        student1.displayStudentInfo();
        student2.displayStudentInfo();

        course1.displayCourseInfo();
        course2.displayCourseInfo();
    }

    
}
