import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VehicleServiceView extends JFrame {
    private JTextField regNoInput = new JTextField(15);
    private JComboBox<String> typeCombo = new JComboBox<>(new String[]{"Two Wheeler", "Car"});
    
    private JCheckBox genServiceCheck = new JCheckBox("General Service (₹1,000)");
    private JCheckBox oilChangeCheck = new JCheckBox("Oil Change (₹800)");
    private JCheckBox brakeServiceCheck = new JCheckBox("Brake Service (₹1,200)");
    private JCheckBox batteryCheck = new JCheckBox("Battery Check (₹500)");
    
    private JButton calculateBtn = new JButton("Calculate Cost");
    private JLabel resultLabel = new JLabel("Total Cost: ₹0.00");

    public VehicleServiceView() {
        setTitle("Vehicle Service Cost Estimator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        JPanel regPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        regPanel.add(new JLabel("Registration Number:"));
        regPanel.add(regNoInput);
        
        JPanel typePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        typePanel.add(new JLabel("Vehicle Type:"));
        typePanel.add(typeCombo);
        JPanel servicesPanel = new JPanel(new GridLayout(4, 1));
        servicesPanel.setBorder(BorderFactory.createTitledBorder("Select Services"));
        servicesPanel.add(genServiceCheck);
        servicesPanel.add(oilChangeCheck);
        servicesPanel.add(brakeServiceCheck);
        servicesPanel.add(batteryCheck);
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(calculateBtn);
        
        JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        resultPanel.add(resultLabel);
        add(regPanel);
        add(typePanel);
        add(servicesPanel);
        add(bottomPanel);
        add(resultPanel);
    }
    public String getRegNo() { return regNoInput.getText(); }
    public String getVehicleType() { return typeCombo.getSelectedItem().toString(); }
    public boolean isGeneralService() { return genServiceCheck.isSelected(); }
    public boolean isOilChange() { return oilChangeCheck.isSelected(); }
    public boolean isBrakeService() { return brakeServiceCheck.isSelected(); }
    public boolean isBatteryCheck() { return batteryCheck.isSelected(); }


    public void setTotalCostDisplay(String text) { resultLabel.setText(text); }

    public void addCalculateListener(ActionListener listener) {
        calculateBtn.addActionListener(listener);
    }
}