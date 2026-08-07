import java.util.Scanner;

public class Attendance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] attendance = new int[7];
        int presentCount = 0;
        int workingDays = 0;

        System.out.println("Enter attendance for 7 days (1 for Present, 0 for Absent):");
        
        for (int i = 0; i < 7; i++) {
            if (i >= 5) {
                System.out.println("Day " + (i + 1) + " (Weekend/Holiday): Automatically marked 0 (Not counted in percentage)");
                attendance[i] = 0; 
                continue; 
            }
            System.out.print("Day " + (i + 1) + " (Working Day): ");
            attendance[i] = scanner.nextInt();
            workingDays++; 
            if (attendance[i] == 1) {
                presentCount++;
            }
        }
 
        double percentage = ((double) presentCount / workingDays) * 100;
        System.out.println("\n--- Attendance Summary ---");
        System.out.println("Total Working Days   : " + workingDays);
        System.out.println("Total Present Days   : " + presentCount);
        System.out.println("Attendance Percentage : " + (int) percentage + "%");
        
        if (percentage >= 75) {
            System.out.println("Status                : Eligible for Exam");
        } else {
            System.out.println("Status                : Not Eligible");
        }
        scanner.close();
    }
}