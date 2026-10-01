public class VehicleServiceModel {
    private String registrationNo;
    private String vehicleType;
    private boolean generalService;
    private boolean oilChange;
    private boolean brakeService;
    private boolean batteryCheck;
    
    private double totalCost;
    public void setServiceDetails(String regNo, String type, boolean gen, boolean oil, boolean brake, boolean battery) {
        this.registrationNo = regNo;
        this.vehicleType = type;
        this.generalService = gen;
        this.oilChange = oil;
        this.brakeService = brake;
        this.batteryCheck = battery;
    }

    public void calculateCost() {
        totalCost = 0;
        if (generalService) totalCost += 1000;
        if (oilChange) totalCost += 800;
        if (brakeService) totalCost += 1200;
        if (batteryCheck) totalCost += 500;
    }

    public String getRegistrationNo() { return registrationNo; }
    public String getVehicleType() { return vehicleType; }
    public double getTotalCost() { return totalCost; }
}