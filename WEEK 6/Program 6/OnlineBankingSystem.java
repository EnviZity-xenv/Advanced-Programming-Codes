import java.util.Scanner;

interface OnlineTransaction {
}

interface Payment {
    void pay(double amount);
}

interface SecurePayment extends Payment {
    void verifyPayment();
}

class UPIPayment implements SecurePayment, OnlineTransaction {
    public void verifyPayment() {
        System.out.println("Verifying UPI Security PIN...");
    }

    public void pay(double amount) {
        System.out.println("UPI Payment of " + amount + " successful.");
    }
}

class CardPayment implements Payment, OnlineTransaction {
    public void pay(double amount) {
        System.out.println("Card Payment of " + amount + " successful.");
    }
}

class Account {
    String accountNumber;
    String accountHolder;

    public Account(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
    }
}

class SavingsAccount extends Account {
    double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double interestRate) {
        super(accountNumber, accountHolder);
        this.interestRate = interestRate;
    }

    public void displayDetails() {
        System.out.println("Account Type: Savings");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

class CurrentAccount extends Account {
    int overdraftLimit;

    public CurrentAccount(String accountNumber, String accountHolder, int overdraftLimit) {
        super(accountNumber, accountHolder);
        this.overdraftLimit = overdraftLimit;
    }

    public void displayDetails() {
        System.out.println("Account Type: Current");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}

public class OnlineBankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String accName = scanner.nextLine();

        System.out.println("Select Account Type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.print("Choice (1/2): ");
        int accChoice = scanner.nextInt();

        Account userAccount;

        if (accChoice == 1) {
            System.out.print("Enter Interest Rate (%): ");
            double interest = scanner.nextDouble();
            userAccount = new SavingsAccount(accNum, accName, interest);
        } else {
            System.out.print("Enter Overdraft Limit: ");
            int overdraft = scanner.nextInt();
            userAccount = new CurrentAccount(accNum, accName, overdraft);
        }

        System.out.print("\nEnter Payment Amount: ");
        double amount = scanner.nextDouble();

        System.out.println("Select Payment Method:");
        System.out.println("1. UPI");
        System.out.println("2. Card");
        System.out.print("Choice (1/2): ");
        int payChoice = scanner.nextInt();

        Payment paymentMethod;

        if (payChoice == 1) {
            paymentMethod = new UPIPayment();
        } else {
            paymentMethod = new CardPayment();
        }

        System.out.println("\n--- Account Details ---");
        userAccount.displayDetails();

        System.out.println("\n--- Transaction Status ---");
        
        if (paymentMethod instanceof OnlineTransaction) {
            System.out.println("Transaction Type: Verified Online Transaction");
        }

        if (paymentMethod instanceof SecurePayment) {
            ((SecurePayment) paymentMethod).verifyPayment();
        }

        paymentMethod.pay(amount);

        scanner.close();
    }
}