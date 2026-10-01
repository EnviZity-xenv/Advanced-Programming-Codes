public class Main {
    public static void main(String[] args) {
    
        PortalModel model = new PortalModel();
        LoginView loginView = new LoginView();
        MainView mainView = new MainView();
        

        PortalController controller = new PortalController(loginView, mainView, model);
        
        
        loginView.setVisible(true);
    }
}