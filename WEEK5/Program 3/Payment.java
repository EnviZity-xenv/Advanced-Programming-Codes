import java.util.Scanner;

public class Payment {

    interface PaymentMethod {
        void makePayment(double amount);
    }

    static class UPI implements PaymentMethod {
        public void makePayment(double amount) {
            System.out.println("UPI Payment: " + amount);
        }
    }

    static class CreditCard implements PaymentMethod {
        public void makePayment(double amount) {
            System.out.println("Credit Card Payment: " + amount);
        }
    }

    static class NetBanking implements PaymentMethod {
        public void makePayment(double amount) {
            System.out.println("Net Banking Payment: " + amount);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Payment Gateway ---");
        System.out.println("1. UPI");
        System.out.println("2. Credit Card");
        System.out.println("3. Net Banking");
        System.out.print("Enter your choice (1, 2, or 3): ");
        int choice = sc.nextInt();

        System.out.print("Enter the amount to pay: ");
        double amount = sc.nextDouble();
        
        System.out.println("\n--- Transaction Status ---");

        PaymentMethod payment;

        if (choice == 1) {
            payment = new UPI();
        } else if (choice == 2) {
            payment = new CreditCard();
        } else {
            payment = new NetBanking();
        }

        payment.makePayment(amount);
        
        sc.close();
    }
}
