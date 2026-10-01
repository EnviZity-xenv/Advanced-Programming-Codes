import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VehicleServiceController {
    private VehicleServiceView view;
    private VehicleServiceModel model;

    public VehicleServiceController(VehicleServiceView view, VehicleServiceModel model) {
        this.view = view;
        this.model = model;
        this.view.addCalculateListener(new CalculateListener());
    }

    class CalculateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
     
            String regNo = view.getRegNo();
            String type = view.getVehicleType();
            boolean gen = view.isGeneralService();
            boolean oil = view.isOilChange();
            boolean brake = view.isBrakeService();
            boolean batt = view.isBatteryCheck();

            model.setServiceDetails(regNo, type, gen, oil, brake, batt);
            model.calculateCost();
            String resultText = String.format("Total Cost for %s: ₹%.2f", 
                    model.getRegistrationNo(), 
                    model.getTotalCost());
            view.setTotalCostDisplay(resultText);
        }
    }
}