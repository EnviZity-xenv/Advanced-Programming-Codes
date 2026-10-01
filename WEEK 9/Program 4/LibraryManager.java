import java.sql.*;
import java.util.Scanner;

public class LibraryManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/library_db";
    private static final String USER = "root";        
    private static final String PASS = "password";    
    public static void main(String[] args) {
        
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Scanner scanner = new Scanner(System.in)) {
            
            System.out.println("Connected to the Library Database successfully!");
            boolean running = true;

            while (running) {
                System.out.println("\n=== Library Management System ===");
                System.out.println("1. Insert details of a new book");
                System.out.println("2. Search for a book using Book ID");
                System.out.println("3. Display all available books");
                System.out.println("4. Issue a book (Change availability)");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        insertBook(conn, scanner);
                        break;
                    case 2:
                        searchBook(conn, scanner);
                        break;
                    case 3:
                        displayAvailableBooks(conn);
                        break;
                    case 4:
                        issueBook(conn, scanner);
                        break;
                    case 5:
                        running = false;
                        System.out.println("Exiting application...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Database connection or query failed: " + e.getMessage());
        }
    }
    private static void insertBook(Connection conn, Scanner scanner) throws SQLException {
        String sql = "INSERT INTO Book (BookID, Title, Author, Price, Availability) VALUES (?, ?, ?, ?, ?)";
        
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, title);
            pstmt.setString(3, author);
            pstmt.setDouble(4, price);
            pstmt.setString(5, "Yes"); // Default availability is 'Yes'
            
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Book inserted successfully!");
            }
        }
    }

    private static void searchBook(Connection conn, Scanner scanner) throws SQLException {
        String sql = "SELECT * FROM Book WHERE BookID = ?";
        
        System.out.print("Enter Book ID to search: ");
        int id = scanner.nextInt();
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("\n--- Book Details ---");
                    System.out.println("ID: " + rs.getInt("BookID"));
                    System.out.println("Title: " + rs.getString("Title"));
                    System.out.println("Author: " + rs.getString("Author"));
                    System.out.println("Price: ₹" + rs.getDouble("Price"));
                    System.out.println("Available: " + rs.getString("Availability"));
                } else {
                    System.out.println("No book found with ID " + id);
                }
            }
        }
    }


    private static void displayAvailableBooks(Connection conn) throws SQLException {
        String sql = "SELECT * FROM Book WHERE Availability = 'Yes'";
        
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            System.out.println("\n--- Available Books ---");
            boolean hasBooks = false;
            
            while (rs.next()) {
                hasBooks = true;
                System.out.printf("ID: %-5d | Title: %-20s | Author: %-15s | Price: ₹%.2f\n",
                        rs.getInt("BookID"),
                        rs.getString("Title"),
                        rs.getString("Author"),
                        rs.getDouble("Price"));
            }
            
            if (!hasBooks) {
                System.out.println("No books are currently available.");
            }
        }
    }


    private static void issueBook(Connection conn, Scanner scanner) throws SQLException {
        String checkSql = "SELECT Availability FROM Book WHERE BookID = ?";
        String updateSql = "UPDATE Book SET Availability = 'No' WHERE BookID = ?";
        
        System.out.print("Enter Book ID to issue: ");
        int id = scanner.nextInt();
        
        try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
            checkStmt.setInt(1, id);
            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next()) {
                    if ("No".equalsIgnoreCase(rs.getString("Availability"))) {
                        System.out.println("This book is already issued.");
                        return;
                    }
                } else {
                    System.out.println("Book ID not found.");
                    return;
                }
            }
        }
        
        try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
            updateStmt.setInt(1, id);
            int rowsAffected = updateStmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Book issued successfully! Availability updated to 'No'.");
            }
        }
    }
}