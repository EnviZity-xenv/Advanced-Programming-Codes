import java.util.Scanner;

interface Confidential {
}

class Document {
    String name;

    public Document(String name) {
        this.name = name;
    }
}

class PublicDocument extends Document {
    public PublicDocument(String name) {
        super(name);
    }
}

class SecretDocument extends Document implements Confidential {
    public SecretDocument(String name) {
        super(name);
    }
}

public class DocumentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Document Name: ");
        String docName = scanner.nextLine();

        System.out.println("Select Document Type:");
        System.out.println("1. Public Document");
        System.out.println("2. Secret Document");
        System.out.print("Enter choice (1/2): ");
        int choice = scanner.nextInt();

        Document myDoc;

        if (choice == 2) {
            myDoc = new SecretDocument(docName);
        } else {
            myDoc = new PublicDocument(docName);
        }

        System.out.println("\n--- Security Verification ---");
        
        if (myDoc instanceof Confidential) {
            System.out.println("Status: '" + myDoc.name + "' is tagged as CONFIDENTIAL.");
            System.out.println("Action: Restricted Access.");
        } else {
            System.out.println("Status: '" + myDoc.name + "' is a standard document.");
            System.out.println("Action: Open Access Granted.");
        }

        scanner.close();
    }
}