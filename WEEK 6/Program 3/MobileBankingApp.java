interface BasicSecurity {
    void login();
    void logout();
}

interface AdvancedSecurity extends BasicSecurity {
    void authenticateFingerprint();
    void authenticateFace();
}

class BankingApplication implements AdvancedSecurity {
    
    public void login() {
        System.out.println("Processing basic password login...");
        System.out.println("Login successful.");
    }

    public void authenticateFingerprint() {
        System.out.println("Scanning fingerprint...");
        System.out.println("Fingerprint verified successfully.");
    }

    public void authenticateFace() {
        System.out.println("Activating front camera for face recognition...");
        System.out.println("Face match confirmed.");
    }

    public void logout() {
        System.out.println("Logging out and securing session...");
        System.out.println("Logout complete.");
    }
}

public class MobileBankingApp {
    public static void main(String[] args) {
        BankingApplication myBankApp = new BankingApplication();

        System.out.println("--- Starting Mobile Banking App ---");
        
        myBankApp.login();
        System.out.println();
        
        myBankApp.authenticateFingerprint();
        System.out.println();
        
        myBankApp.authenticateFace();
        System.out.println();
        
        myBankApp.logout();
    }
}