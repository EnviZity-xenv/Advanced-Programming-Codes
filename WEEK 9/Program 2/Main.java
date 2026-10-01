public class Main {
    public static void main(String[] args) {
        VehicleServiceModel model = new VehicleServiceModel();
        VehicleServiceView view = new VehicleServiceView();
        VehicleServiceController controller = new VehicleServiceController(view, model);
    
        view.setVisible(true);
    }
}