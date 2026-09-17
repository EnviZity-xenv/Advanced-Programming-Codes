package student;

public class Student {
    private int studentId;
    private String studentName;
    private String major;

    public Student(int studentId, String studentName, String major) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.major = major;
    }

    public void displayStudentInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + studentName);
        System.out.println("Major: " + major);
    }
}