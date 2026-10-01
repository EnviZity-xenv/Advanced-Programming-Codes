import java.sql.*;
import java.util.Scanner;

public class CourseRegistrationViewer {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/college_db";
    private static final String USER = "root";       
    private static final String PASS = "password";  

    public static void main(String[] args) {
       
        try (Scanner scanner = new Scanner(System.in);
             Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            
            System.out.print("Enter Course Code to search: ");
            String searchCode = scanner.nextLine().trim();
            String sql = "SELECT StudentID, StudentName, CourseName, Semester " +
                         "FROM CourseRegistration WHERE CourseCode = ?";
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
                pstmt.setString(1, searchCode);
                

                try (ResultSet rs = pstmt.executeQuery()) {
                    boolean hasStudents = false;

                    while (rs.next()) {
                        if (!hasStudents) {
                            System.out.println("\n--- Students Registered for " + searchCode + " ---");
                            hasStudents = true;
                        }
      
                        String studentId = rs.getString("StudentID");
                        String studentName = rs.getString("StudentName");
                        String courseName = rs.getString("CourseName");
                        int semester = rs.getInt("Semester");
                        
                        // Display student details
                        System.out.printf("ID: %-10s | Name: %-20s | Course: %-20s | Semester: %d\n", 
                                          studentId, studentName, courseName, semester);
                    }
                
                    if (!hasStudents) {
                        System.out.println("\nNo students are registered for the course code: " + searchCode);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }
}