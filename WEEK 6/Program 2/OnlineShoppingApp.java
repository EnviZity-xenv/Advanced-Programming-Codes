import java.util.Scanner;

interface Payment {
    void pay(double amount);
}

class CreditCardPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Authenticating Credit Card details...");
        System.out.println("Successfully processed Credit Card payment of:" + amount);
    }
}

class UPIPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Verifying UPI ID...");
        System.out.println("Successfully processed UPI payment of:" + amount);
    }
}

class NetBankingPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Redirecting to bank portal...");
        System.out.println("Successfully processed Net Banking payment of:" + amount);
    }
}

public class OnlineShoppingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter checkout amount: ");
        double amount = scanner.nextDouble();

        System.out.println("\nSelect Payment Method:");
        System.out.println("1. Credit Card");
        System.out.println("2. UPI");
        System.out.println("3. Net Banking");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        Payment Method = null;

         if(choice == 1) {
            Method = new CreditCardPayment();
        } else if(choice == 2) {
            Method = new UPIPayment();
        } else if(choice == 3) {
            Method = new NetBankingPayment();
        } else {
            System.out.println("Invalid payment selection. Transaction cancelled.");
            System.exit(0);
        }

        System.out.println("\n--- Transaction Details ---");
        Method.pay(amount);

        scanner.close();
    }
}