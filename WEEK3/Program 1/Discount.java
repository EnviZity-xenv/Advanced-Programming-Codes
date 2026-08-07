import java.util.Scanner;

public class Discount{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] prices = new double[5];
        double totalBill = 0;
        System.out.println("Enter prices of 5 products:");
        for (int i = 0; i < 5; i++) {
            prices[i] = scanner.nextDouble();
            totalBill += prices[i]; 
        }
        System.out.println("\nTotal Bill : " + (int) totalBill);
        if (totalBill > 5000) {
            System.out.println("Discount Applicable");
        } else {
            System.out.println("No Discount");
        }
        scanner.close();
    }
}