import java.util.Scanner;

public class Product {
    int productId;
    String name;
    double price;

    Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    double calculateDiscount() {
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Product Discount Calculator ---");
        System.out.println("1. Electronics");
        System.out.println("2. Clothing");
        System.out.println("3. Books");
        System.out.print("Enter product category (1, 2, or 3): ");
        int choice = sc.nextInt();

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Product Price: ");
        double price = sc.nextDouble();

        Product product;

        if (choice == 1) {
            product = new Electronics(id, name, price);
        } else if (choice == 2) {
            product = new Clothing(id, name, price);
        } else {
            product = new Books(id, name, price);
        }

        double discount = product.calculateDiscount();
        double finalPrice = price - discount;

        System.out.println("\n--- Checkout Summary ---");
        System.out.println("Product Name: " + name);
        System.out.println("Product ID: " + id);
        System.out.println("Original Price: " + price);
        System.out.println("Discount: " + discount);
        System.out.println("Final Price: " + finalPrice);
        
        sc.close();
    }
}

class Electronics extends Product {
    Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    double calculateDiscount() {
        return price * 0.10;
    }
}

class Clothing extends Product {
    Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    double calculateDiscount() {
        return price * 0.20;
    }
}

class Books extends Product {
    Books(int id, String name, double price) {
        super(id, name, price);
    }

    double calculateDiscount() {
        return price * 0.15;
    }
}
